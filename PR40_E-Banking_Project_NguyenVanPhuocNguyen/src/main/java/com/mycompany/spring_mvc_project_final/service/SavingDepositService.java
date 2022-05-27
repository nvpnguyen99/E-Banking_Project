package com.mycompany.spring_mvc_project_final.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.SavingCategory;
import com.mycompany.spring_mvc_project_final.entities.SavingDeposit;
import com.mycompany.spring_mvc_project_final.entities.Transfer;
import com.mycompany.spring_mvc_project_final.enums.InterestPayment;
import com.mycompany.spring_mvc_project_final.enums.SavingStatus;
import com.mycompany.spring_mvc_project_final.repository.SavingDepositRepository;


@Service
public class SavingDepositService {
	@Autowired
	SavingDepositRepository savingDepositRepository;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	SavingCategoryService savingCategoryService;
	
	public List<SavingDeposit> findAllSavingDeposit(){
		return (List<SavingDeposit>) savingDepositRepository.findAll();
	}
	
	public void save(SavingDeposit savingDeposit) {
		savingDepositRepository.save(savingDeposit);
	}
	
	public Optional<SavingDeposit> findById(int id) {
		return savingDepositRepository.findById(id);
	}
	
	public void updateSavingDeposit(long currentAmount,long interestAmount,LocalDate interestPaymentDate,String savingDepositId) {
		savingDepositRepository.updateSavingDeposit(currentAmount, interestAmount, interestPaymentDate, savingDepositId);
	}
	
	public void generateDepositId(SavingDeposit savingDeposit) {
		List<SavingDeposit> savingDepositList = (List<SavingDeposit>) savingDepositRepository.findAll();
		if(savingDepositList.isEmpty()) {
			System.out.print("first deposit");
			savingDeposit.setSavingDepositId("SV"+"00000001");
		} else {
			System.out.print("deposit");
		int max = 0;
		for (SavingDeposit saving_deposit : savingDepositList) {
			if(saving_deposit.getId()>= max) {
				max = saving_deposit.getId();
			}
		}
		int saving_id = max+1;
		String saving_deposit_id = "SV";
		for(int i=0; i<8 ; i++) {
			if((saving_id)/10 < Math.pow(10,i)){
				for (int j=1; j<8-i;j++) {
					saving_deposit_id=saving_deposit_id.concat("0");
				}
				break;
			}
		}
		saving_deposit_id=saving_deposit_id.concat(Integer.toString(saving_id));
		savingDeposit.setSavingDepositId(saving_deposit_id);
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void savingAndUpdateBalance(SavingDeposit savingDeposit, Optional<SavingCategory> savingCategory, Account account) throws Exception {
		LocalDate instance = LocalDate.now();
		savingDeposit.setCreateDate(instance);
		savingDeposit.setInterestPaymentDate(instance);
		if(savingCategory.get().getPeriod() == 0) {
			savingDeposit.setExpiredDate(account.getExpiredDate());
		} else {
		savingDeposit.setExpiredDate(instance.plusMonths(savingDeposit.getSavingCategory().getPeriod()));
		}
		savingDeposit.setCurrentAmount(savingDeposit.getSavingAmount());
		if(savingCategory.get().getPeriod() != 0 && savingDeposit.getInterestPayment().equals(InterestPayment.PREPAID)) {
			long interestAmount = (long)(savingDeposit.getSavingAmount() * (savingCategory.get().getInterestRate()/100/12));
			savingDeposit.setInterestAmount(interestAmount);
		} else {
		savingDeposit.setInterestAmount(0);
		}
		generateDepositId(savingDeposit);
		savingDeposit.setSavingStatus(SavingStatus.IN_PROCESS);
		accountService.updateBalance(account.getBalance()-savingDeposit.getSavingAmount(), account.getAccountId());
		savingDepositRepository.save(savingDeposit);
		if(account.getBalance()<0) {
			throw new Exception("amount exception");
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void calculateInterestAndUpdateSaving(SavingDeposit deposit) throws Exception {
		if(deposit.getSavingStatus().equals(SavingStatus.IN_PROCESS)) {
			if(deposit.getInterestPaymentDate().getMonthValue()<LocalDate.now().getMonthValue() && deposit.getInterestPaymentDate().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
				if(deposit.getInterestPayment().equals(InterestPayment.MONTHLY)) {
//				deposit.setCurrentAmount((long) (deposit.getCurrentAmount()+ deposit.getSavingAmount()*deposit.getSavingCategory().getInterestRate()/12/100));	
				deposit.setInterestAmount((long) (deposit.getInterestAmount()+ deposit.getSavingAmount()*deposit.getSavingCategory().getInterestRate()/12/100));
				}
				if(deposit.getInterestPayment().equals(InterestPayment.DEFERRED)) {
					deposit.setCurrentAmount((long) (deposit.getCurrentAmount()+ deposit.getCurrentAmount()*deposit.getSavingCategory().getInterestRate()/12/100));	
//					deposit.setInterestAmount((long) (deposit.getInterestAmount()+ deposit.getCurrentAmount()*deposit.getSavingCategory().getInterestRate()/12/100));
					}
				deposit.setInterestPaymentDate(LocalDate.now());
				if(LocalDate.now().isEqual(deposit.getExpiredDate())) {
					deposit.setInterestAmount(deposit.getInterestAmount()+deposit.getCurrentAmount());
					deposit.setCurrentAmount(0);
					deposit.setSavingStatus(SavingStatus.EXPIRED);
				}
//				savingDepositService.updateSavingDeposit(95000, 950, LocalDate.now(), deposit.getSavingDepositId());
				savingDepositRepository.save(deposit);
			}
			}
		if(deposit.getSavingAmount()<0) {
			throw new Exception("amount exception");
		}
	}
	@Transactional(rollbackFor = Exception.class)
	public void withdrawMoneyAndUpdateBalance(SavingDeposit deposit) throws Exception {
		deposit.getAccount().setBalance(deposit.getAccount().getBalance()+deposit.getInterestAmount());
		deposit.setInterestAmount(0);
		savingDepositRepository.save(deposit);
		accountService.save(deposit.getAccount());
		if(deposit.getInterestAmount()<0) {
			throw new Exception("amount exception");
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void settleSavingDepositAndUpdateBalance(SavingDeposit deposit) throws Exception {
		deposit.getAccount().setBalance(deposit.getAccount().getBalance()+deposit.getInterestAmount()+deposit.getCurrentAmount());
		deposit.setInterestAmount(0);
		deposit.setCurrentAmount(0);
		deposit.setSavingStatus(SavingStatus.SETTLEMENT);
		savingDepositRepository.save(deposit);
		accountService.save(deposit.getAccount());
		if(deposit.getInterestAmount()<0) {
			throw new Exception("amount exception");
		}
	}
	
	public void estimateSaving(Model model, SavingDeposit savingDeposit) {
		Optional<SavingCategory> savingCategory = savingCategoryService.findById(savingDeposit.getSavingCategory().getId());
		if (savingCategory.get().getPeriod() == 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.MONTHLY)) {
			long interest = (long) (savingDeposit.getSavingAmount()
					* (savingCategory.get().getInterestRate() / 100 / 12));
			model.addAttribute("estimate", "non-term_monthly");
			model.addAttribute("interestEstimate", interest);
			model.addAttribute("savingCategory", savingCategory.get());
		}
		if (savingCategory.get().getPeriod() == 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.DEFERRED)) {
			model.addAttribute("estimate", "non-term_deferred");
			List<SavingDeposit> estimateList = new ArrayList<>();
			long estimate_total_amount = savingDeposit.getSavingAmount();
			for (int i = 1; i <= 9; i++) {
				SavingDeposit estimateSaving = new SavingDeposit();
				estimateSaving.setId(i);
				estimateSaving.setSavingAmount(savingDeposit.getSavingAmount());
				estimate_total_amount = (long) (estimate_total_amount
						+ estimate_total_amount * savingCategory.get().getInterestRate() / 100 / 12);
				estimateSaving.setCurrentAmount(estimate_total_amount);
				estimateSaving.setInterestAmount(estimate_total_amount - savingDeposit.getSavingAmount());
				estimateList.add(estimateSaving);
			}
			model.addAttribute("estimateList", estimateList);
			model.addAttribute("savingCategory", savingCategory.get());
		}
		if (savingCategory.get().getPeriod() == 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.PREPAID)) {
			model.addAttribute("interestPaymentError", "Can not choose Prepaid method with Non-term Saving !");
		}
		if (savingCategory.get().getPeriod() != 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.MONTHLY)) {
			long interestAmount = (long) (savingDeposit.getSavingAmount()
					* (savingCategory.get().getInterestRate() / 100 / 12));
			model.addAttribute("estimate", "term_monthly");
			model.addAttribute("interestEstimate", interestAmount);
			model.addAttribute("savingCategory", savingCategory.get());
			model.addAttribute("termInterestEstimate", interestAmount * savingCategory.get().getPeriod());
		}
		if (savingCategory.get().getPeriod() != 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.PREPAID)) {
			long interestAmount = (long) (savingDeposit.getSavingAmount()
					* (savingCategory.get().getInterestRate() / 100 / 12));
			model.addAttribute("estimate", "term_prepaid");
			model.addAttribute("savingCategory", savingCategory.get());
			model.addAttribute("termInterestEstimate", interestAmount * savingCategory.get().getPeriod());
		}

		if (savingCategory.get().getPeriod() != 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.DEFERRED)) {
			model.addAttribute("estimate", "term_deferred");
			List<SavingDeposit> estimateList = new ArrayList<>();
			long estimate_total_amount = savingDeposit.getSavingAmount();
			for (int i = 1; i <= savingCategory.get().getPeriod(); i++) {
				SavingDeposit estimateSaving = new SavingDeposit();
				estimateSaving.setId(i);
				estimateSaving.setSavingAmount(savingDeposit.getSavingAmount());
				estimate_total_amount = (long) (estimate_total_amount
						+ estimate_total_amount * savingCategory.get().getInterestRate() / 100 / 12);
				estimateSaving.setCurrentAmount(estimate_total_amount);
				estimateSaving.setInterestAmount(estimate_total_amount - savingDeposit.getSavingAmount());
				estimateList.add(estimateSaving);
			}
			model.addAttribute("estimateList", estimateList);
			model.addAttribute("savingCategory", savingCategory.get());
		}
	}
}

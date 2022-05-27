package com.mycompany.spring_mvc_project_final.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.SavingCategory;
import com.mycompany.spring_mvc_project_final.entities.SavingDeposit;
import com.mycompany.spring_mvc_project_final.enums.InterestPayment;
import com.mycompany.spring_mvc_project_final.enums.SavingStatus;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import com.mycompany.spring_mvc_project_final.service.MailService;
import com.mycompany.spring_mvc_project_final.service.SavingCategoryService;
import com.mycompany.spring_mvc_project_final.service.SavingDepositService;

@Controller
public class SavingController {
	@Autowired
	AccountService accountService;

	@Autowired
	MailService mailService;

	@Autowired
	SavingCategoryService savingCategoryService;

	@Autowired
	SavingDepositService savingDepositService;

	@RequestMapping("/savingList")
	public String savingList(Model model, HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("account");
		List<SavingDeposit> savingDepositList = account.getSavingList();
		model.addAttribute("savingList", savingDepositList);
		return "saving-list";
	}

	@RequestMapping("/savingsPage")
	public String savingsPage(Model model, HttpServletRequest request) {
		List<SavingCategory> categoryList = savingCategoryService.findAllSavingCategory();
		model.addAttribute("saving", new SavingDeposit());
		model.addAttribute("savingCategoryList", categoryList);
		List<InterestPayment> enums = Arrays.asList(InterestPayment.values());
		model.addAttribute("enums", enums);
		return "saving";
	}

	@RequestMapping(value = "/savings", params = "submit")
	public String savings(Model model, @ModelAttribute(name = "saving") SavingDeposit savingDeposit) {
		List<SavingCategory> categoryList = savingCategoryService.findAllSavingCategory();
		model.addAttribute("savingCategoryList", categoryList);
		Optional<SavingCategory> savingCategory = savingCategoryService
				.findById(savingDeposit.getSavingCategory().getId());
		savingDeposit.setSavingCategory(savingCategory.get());
		savingDeposit.setAccount(accountService.findById(savingDeposit.getAccount().getId()).get());
		if (savingDeposit.getSavingAmount() > savingDeposit.getAccount().getBalance()) {
			model.addAttribute("amountError", "Amount is more than Balance");
			return "saving";
		}
		if (savingCategory.get().getPeriod() == 0
				&& savingDeposit.getInterestPayment().equals(InterestPayment.PREPAID)) {
			model.addAttribute("interestPaymentError", "Can not choose Prepaid method with Non-term Saving !");
			return "saving";

		}
		model.addAttribute("saving", savingDeposit);
		return "savings-comfirm";
	}

	@RequestMapping("/savingComfirm")
	public String savingComfirm(Model model, @ModelAttribute(name = "saving") SavingDeposit savingDeposit,
			ModelMap modelMap, HttpServletRequest request) {
		savingDeposit
				.setSavingCategory(savingCategoryService.findById(savingDeposit.getSavingCategory().getId()).get());
		savingDeposit.setAccount(accountService.findById(savingDeposit.getAccount().getId()).get());
		String captcha = request.getSession().getAttribute("captcha_security").toString();
		String verifyCaptcha = savingDeposit.getCaptcha();
		if (captcha.equals(verifyCaptcha)) {
			System.out.print("captcha valid");
		} else {
			model.addAttribute("captcharError", "Captcha Invalid");
			List<SavingCategory> categoryList = savingCategoryService.findAllSavingCategory();
			model.addAttribute("savingCategoryList", categoryList);
			model.addAttribute("saving", savingDeposit);
			return "savings-comfirm";
		}
		model.addAttribute("saving", savingDeposit);
		mailService.sendOtpByEmail(request, "nguyenvanphuocnguyen99@gmail.com", "nvpnguyen309@gmail.com");
		model.addAttribute("email", savingDeposit.getAccount().getUserEntity().getEmail());
		return "savings-otp-comfirm";
	}

	@RequestMapping(value = "/savings", params = "estimate")
	public String savingsEstimate(Model model, @ModelAttribute(name = "saving") SavingDeposit savingDeposit) {
		List<SavingCategory> categoryList = savingCategoryService.findAllSavingCategory();
		model.addAttribute("saving", savingDeposit);
		model.addAttribute("savingCategoryList", categoryList);
		List<InterestPayment> enums = Arrays.asList(InterestPayment.values());
		model.addAttribute("enums", enums);
		savingDepositService.estimateSaving(model, savingDeposit);
		return "saving";
	}

	@RequestMapping("/savingComfirmOTP")
	public String savingComfirmOTP(Model model, @ModelAttribute(name = "saving") SavingDeposit savingDeposit,
			ModelMap modelMap, HttpServletRequest request) {
		String otp_code = request.getSession().getAttribute("otp").toString();
		Account account = (Account) request.getSession().getAttribute("account");
		Optional<SavingCategory> savingCategory = savingCategoryService.findById(savingDeposit.getSavingCategory().getId());
		savingDeposit.setSavingCategory(savingCategoryService.findById(savingDeposit.getSavingCategory().getId()).get());
		savingDeposit.setAccount(accountService.findById(savingDeposit.getAccount().getId()).get());
		if (savingDeposit.getOtp().equals(otp_code)) {
			try {
				savingDepositService.savingAndUpdateBalance(savingDeposit, savingCategory, account);
		        } catch (Exception ex) {
		            System.out.println(ex);
		        }
		} else {
			model.addAttribute("otpError", "OTP INVALID!");
			return "savings-otp-comfirm";
		}
		model.addAttribute("saving", savingDepositService.findById(savingDeposit.getId()).get());
		return "savings-success";
	}
	
	@RequestMapping("/withdraw")
  public String withdraw(Model model,@RequestParam(name = "id") int id, HttpServletRequest request) {	
	SavingDeposit deposit = savingDepositService.findById(id).get();
	if(deposit.getInterestAmount()==0) {
		model.addAttribute("amountError", "Can not withdraw money from deposit!");
	} else {
	try {
		savingDepositService.withdrawMoneyAndUpdateBalance(deposit);
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
		Account account = deposit.getAccount();
		List<SavingDeposit> savingDepositList = account.getSavingList();
		model.addAttribute("savingList", savingDepositList);
	
		return "saving-list";
  }
	
	@RequestMapping("/settle")
	  public String settle(Model model,@RequestParam(name = "id") int id, HttpServletRequest request) {	
		SavingDeposit deposit = savingDepositService.findById(id).get();
		if(deposit.getSavingStatus().equals(SavingStatus.EXPIRED)) {
		try {
			savingDepositService.withdrawMoneyAndUpdateBalance(deposit);
	        } catch (Exception ex) {
	            System.out.println(ex);
	        }
		} else {
			try {
				savingDepositService.settleSavingDepositAndUpdateBalance(deposit);
		        } catch (Exception ex) {
		            System.out.println(ex);
		        }
		}
		Account account = deposit.getAccount();
		List<SavingDeposit> savingDepositList = account.getSavingList();
		model.addAttribute("savingList", savingDepositList);
			return "saving-list";
	  }
	
	@Scheduled(fixedDelay = 10000)
	public void scheduleFixedDelayTask() {
		List<SavingDeposit> savingDepositList = savingDepositService.findAllSavingDeposit();
		for (SavingDeposit deposit : savingDepositList) {
			try {
				savingDepositService.calculateInterestAndUpdateSaving(deposit);
		        } catch (Exception ex) {
		            System.out.println(ex);
		        }
			
		}
	}

}

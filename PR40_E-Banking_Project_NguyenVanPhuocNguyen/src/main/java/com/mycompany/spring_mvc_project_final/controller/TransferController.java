package com.mycompany.spring_mvc_project_final.controller;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.Transfer;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import com.mycompany.spring_mvc_project_final.service.MailService;
import com.mycompany.spring_mvc_project_final.service.TransferService;

@Controller
public class TransferController {
	@Autowired
	TransferService transferService;

	@Autowired
	AccountService accountService;

	@Autowired
	MailService mailService;

	@RequestMapping("/activityHistory")
	public String activityHistory(Model model, HttpServletRequest request, WebRequest webRequest,
			SessionStatus status) {
		Account account = (Account) request.getSession().getAttribute("account");
		List<Transfer> transferList = transferService.findTransferByAccountId(account.getAccountId());
		model.addAttribute("transferList", transferList);
		return "activity-history";
	}

//    public String transferPage(Model model,@RequestParam(name = "accountId") String accountId) {
	@RequestMapping("/transferPage")
	public String transferPage(Model model, HttpServletRequest request) {
		model.addAttribute("transfer", new Transfer());
		return "transfer";
	}

	@RequestMapping("/transfer")
	public String transfer(Model model, @ModelAttribute(name = "transfer") Transfer transfer) {
		Account account_target = accountService.findByAccountId(transfer.getAccountTarget());
		if (account_target == null) {
			model.addAttribute("idError", "Account Target Id Invalid");
			return "transfer";
		}
		String account_target_name = account_target.getUserEntity().getName();
		model.addAttribute("transfer", transfer);
		model.addAttribute("account_target_name", account_target_name);
		return "transfer-comfirm";
	}

	@RequestMapping("/transferComfirm")
	public String transferComfirm(Model model, @ModelAttribute(name = "transfer") Transfer transfer, ModelMap modelMap,
			HttpServletRequest request) {
		String captcha = request.getSession().getAttribute("captcha_security").toString();
		String verifyCaptcha = transfer.getCaptcha();
		Account account_source = accountService.findByAccountId(transfer.getAccountSource());
		transfer.setAccount(account_source);
		Account account_target = accountService.findByAccountId(transfer.getAccountTarget());
		String account_target_name = account_target.getUserEntity().getName();
		
		if(transfer.getAmount()>account_source.getBalance()) {
			model.addAttribute("account_target_name", account_target_name);
			model.addAttribute("amountError", "Amount is than Balance");
			return "transfer-comfirm";
		}
		
		if (captcha.equals(verifyCaptcha)) {
			System.out.print("captcha valid");
		} else {
			model.addAttribute("account_target_name", account_target_name);
			model.addAttribute("captcharError", "Captcha Invalid");
			return "transfer-comfirm";
		}
		
		mailService.sendOtpByEmail(request, "nguyenvanphuocnguyen99@gmail.com", "nvpnguyen309@gmail.com");
	
		return "otp-comfirm";
	}

	@RequestMapping("/transferComfirmOTP")
	public String transferComfirmOTP(Model model, @Valid @ModelAttribute(name = "transfer") Transfer transfer,
			ModelMap modelMap, HttpServletRequest request) {
		String otp_code = request.getSession().getAttribute("otp").toString();
		Account account_source = accountService.findByAccountId(transfer.getAccountSource());
		Account account_target = accountService.findByAccountId(transfer.getAccountTarget());
		transfer.setAccount(account_source);
	
		if (transfer.getOtp().equals(otp_code)) {
			 try {
				 transferService.transferAndUpdateAccount(transfer, account_source, account_target);
		        } catch (Exception ex) {
		            System.out.println(ex);
		        }
			
		} else {
			model.addAttribute("otpError", "OTP INVALID!");
			return "otp-comfirm";
		}

		String account_target_name = account_target.getUserEntity().getName();
		model.addAttribute("transfer", transfer);
		model.addAttribute("account_target_name", account_target_name);
		return "transfer-success";
	}
}

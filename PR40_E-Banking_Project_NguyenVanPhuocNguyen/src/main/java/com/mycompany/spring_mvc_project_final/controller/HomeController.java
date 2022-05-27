/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.SavingCategory;
import com.mycompany.spring_mvc_project_final.entities.SavingDeposit;
import com.mycompany.spring_mvc_project_final.entities.Transfer;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.enums.InterestPayment;
import com.mycompany.spring_mvc_project_final.enums.SavingStatus;
import com.mycompany.spring_mvc_project_final.enums.TranferFee;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import com.mycompany.spring_mvc_project_final.service.MailService;
import com.mycompany.spring_mvc_project_final.service.SavingCategoryService;
import com.mycompany.spring_mvc_project_final.service.SavingDepositService;
import com.mycompany.spring_mvc_project_final.service.TransferService;
import com.mycompany.spring_mvc_project_final.service.UserService;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {
	@Autowired
	SavingCategoryService savingCategoryService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		List<SavingCategory> categoryList = savingCategoryService.findAllSavingCategory();
		model.addAttribute("saving", new SavingDeposit());
		model.addAttribute("savingCategoryList", categoryList);
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage(Model model, @RequestParam(value = "error", required = false) boolean error) {
		if (error) {
			model.addAttribute("message", "Login Fail!!!");
		}
		return "login";
	}


		
	@RequestMapping("/403")
	public String accessDenied(Model model) {
		return "403Page";
	}

}

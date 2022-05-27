/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/account")
	public String account(Model model, HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}

		model.addAttribute("message_user", "Hello User: " + username);
		UserEntity user = userService.findUsername(username);
		List<Account> accountList = user.getAccountList();
		request.getSession().setAttribute("accountList", accountList);
		request.getSession().setAttribute("account", accountList.get(0));
		return "account";
	}

	@RequestMapping("/accountChoice")
	public String accountChoice(Model model, @RequestParam(name = "accountId") String accountId,
			HttpServletRequest request, WebRequest webRequest, SessionStatus status) {
		List<Account> accountList = (List<Account>) request.getSession().getAttribute("accountList");
		for (Account account : accountList) {
			if (account.getAccountId().equals(accountId)) {
				status.setComplete();
				webRequest.removeAttribute("account", WebRequest.SCOPE_SESSION);
				request.getSession().setAttribute("account", account);
			}
		}
		return "account";
	}
}

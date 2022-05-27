/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;

import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.enums.TranferFee;
import com.mycompany.spring_mvc_project_final.enums.TranferRole;





@Entity
@Table(name = "transfer")
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "accountSource")
	@NotBlank(message = "accountSource is required")
	private String accountSource;
//	@NotNull(message = "transferDate is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "transferDate")
	private LocalDateTime transferDateTime;
	@Column(name = "accountTarget")
	@NotBlank(message = "accountTarget is required")
	private String accountTarget;
//	@NotBlank(message = "amount is required")
	@Column(name = "amount")
	private long amount;
	@Column(name = "content")
	@NotBlank(message = "content is required")
	private String content;
	@Transient
	private String captcha;
	@Transient
	private String otp;
	
//	  @Enumerated(EnumType.STRING)
//	  private TranferFee transferFee;
//	
//	  @Enumerated(EnumType.STRING)
//	  private TranferRole transferRole;
	  
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}


	@ManyToOne
	@JoinColumn(name = "account_Id")
	private Account account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountSource() {
		return accountSource;
	}
	public void setAccountSource(String accountSource) {
		this.accountSource = accountSource;
	}
	
	public LocalDateTime getTransferDateTime() {
		return transferDateTime;
	}
	public void setTransferDateTime(LocalDateTime transferDateTime) {
		this.transferDateTime = transferDateTime;
	}
	public String getAccountTarget() {
		return accountTarget;
	}
	public void setAccountTarget(String accountTarget) {
		this.accountTarget = accountTarget;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transfer(@NotBlank(message = "accountSource is required") String accountSource,
			LocalDateTime transferDateTime, @NotBlank(message = "accountTarget is required") String accountTarget,
			long amount, @NotBlank(message = "content is required") String content, Account account) {
		super();
		this.accountSource = accountSource;
		this.transferDateTime = transferDateTime;
		this.accountTarget = accountTarget;
		this.amount = amount;
		this.content = content;
		this.account = account;
	}
	

}

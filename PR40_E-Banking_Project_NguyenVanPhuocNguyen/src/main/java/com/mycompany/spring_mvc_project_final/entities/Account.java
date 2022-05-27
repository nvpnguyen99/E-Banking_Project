/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
//	@UniqueElements
	@Column(name = "accountid")
	@NotBlank(message = "accountId is required")
	private String accountId;
//	@UniqueElements
	@Column(name = "cardid")
	@NotBlank(message = "cardId is required")
	private String cardId;
	@Column(name = "ccv_code")
	@NotBlank(message = "ccvCode is required")
	private String ccvCode;
	
	@Column(name = "balance")
	@NotNull(message = "balance is required")
	private long balance;
	@Column(name = "expired_date")
	@NotNull(message = "expired_date is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate expiredDate;
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private UserEntity userEntity;
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private List<Transfer> transferList;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
	private List<SavingDeposit> savingList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCcvCode() {
		return ccvCode;
	}
	public void setCcvCode(String ccvCode) {
		this.ccvCode = ccvCode;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public List<Transfer> getTransferList() {
		return transferList;
	}
	public void setTransferList(List<Transfer> transferList) {
		this.transferList = transferList;
	}
	
	public LocalDate getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}
	public List<SavingDeposit> getSavingList() {
		return savingList;
	}
	public void setSavingList(List<SavingDeposit> savingList) {
		this.savingList = savingList;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

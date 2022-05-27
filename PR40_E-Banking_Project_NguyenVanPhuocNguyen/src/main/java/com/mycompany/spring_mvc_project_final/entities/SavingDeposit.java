package com.mycompany.spring_mvc_project_final.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import com.mycompany.spring_mvc_project_final.enums.InterestPayment;
import com.mycompany.spring_mvc_project_final.enums.SavingStatus;

@Entity
@Table(name = "saving_deposit")
public class SavingDeposit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	
	@Column(name = "saving_deposit_id")
	@NotBlank(message = "savingDepositId is required")
	private String savingDepositId;
	@Column(name = "saving_amount")
	@NotNull(message = "savingAmount is required")
	private long savingAmount;
	@Column(name = "interest_amount")
	@NotNull(message = "interestAmount is required")
	private long interestAmount;
	@Column(name = "current_amount")
	@NotNull(message = "currentAmount is required")
	private long currentAmount;
	@Column(name = "create_date")
	@NotNull(message = "createDate is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate createDate;
	@Column(name = "expired_date")
	@NotNull(message = "expired_date is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate expiredDate;
	@Column(name = "interest_payment_date")
	@NotNull(message = "interestPaymentDate is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate interestPaymentDate;
	@Column(name = "interest_payment")
	@NotNull(message = "interestPayment is required")
	@Enumerated(EnumType.STRING)
    private InterestPayment interestPayment;
	@Column(name = "description")
	@NotBlank(message = "description is required")
	private String description;
	@Column(name = "saving_status")
	@NotNull(message = "savingStatus is required")
	@Enumerated(EnumType.STRING)
    private SavingStatus savingStatus;
	@ManyToOne
	@JoinColumn(name = "account_Id")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "category_Id")
	private SavingCategory savingCategory;
	
	@Transient
	private String captcha;
	@Transient
	private String otp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSavingDepositId() {
		return savingDepositId;
	}
	public void setSavingDepositId(String savingDepositId) {
		this.savingDepositId = savingDepositId;
	}
	public long getSavingAmount() {
		return savingAmount;
	}
	public void setSavingAmount(long savingAmount) {
		this.savingAmount = savingAmount;
	}
	public long getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(long interestAmount) {
		this.interestAmount = interestAmount;
	}
	public long getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(long currentAmount) {
		this.currentAmount = currentAmount;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDate getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}
//	public String getInterestPayment() {
//		return interestPayment;
//	} 
//	public void setInterestPayment(String interestPayment) {
//		this.interestPayment = interestPayment;
//	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getInterestPaymentDate() {
		return interestPaymentDate;
	}
	public void setInterestPaymentDate(LocalDate interestPaymentDate) {
		this.interestPaymentDate = interestPaymentDate;
	}
	public SavingStatus getSavingStatus() {
		return savingStatus;
	}
	public void setSavingStatus(SavingStatus savingStatus) {
		this.savingStatus = savingStatus;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public SavingCategory getSavingCategory() {
		return savingCategory;
	}
	public void setSavingCategory(SavingCategory savingCategory) {
		this.savingCategory = savingCategory;
	}
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
	
	public InterestPayment getInterestPayment() {
		return interestPayment;
	}
	public void setInterestPayment(InterestPayment interestPayment) {
		this.interestPayment = interestPayment;
	}
	public SavingDeposit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


	
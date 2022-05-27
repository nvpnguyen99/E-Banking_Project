package com.mycompany.spring_mvc_project_final.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;




@Entity
@Table(name = "saving_category")
public class SavingCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;		
	@Column(name = "name")
	@NotBlank(message = "name is required")
	private String name;
	@Column(name = "interest_rate")
	@NotNull(message = "interestRate is required")
	private double interestRate;
	@Column(name = "period")
	@NotNull(message = "period is required")
	private int period;
	@OneToMany(mappedBy = "savingCategory", fetch = FetchType.EAGER)
	private List<SavingDeposit> savingList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public List<SavingDeposit> getSavingList() {
		return savingList;
	}
	public void setSavingList(List<SavingDeposit> savingList) {
		this.savingList = savingList;
	}
	public SavingCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

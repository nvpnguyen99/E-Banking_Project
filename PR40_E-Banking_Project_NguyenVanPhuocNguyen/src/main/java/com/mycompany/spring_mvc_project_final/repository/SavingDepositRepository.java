package com.mycompany.spring_mvc_project_final.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.SavingDeposit;



@Repository
public interface SavingDepositRepository extends CrudRepository<SavingDeposit, Integer>{

	@Transactional
	@Modifying
	@Query("update SavingDeposit s set s.currentAmount = ?1, s.interestAmount = ?2, s.interestPaymentDate = ?3 where s.savingDepositId = ?4")
	void updateSavingDeposit(long currentAmount,long interestAmount,LocalDate interestPaymentDate,String savingDepositId);
}

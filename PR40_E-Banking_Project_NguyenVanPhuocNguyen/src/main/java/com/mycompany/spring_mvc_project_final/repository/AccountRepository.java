/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findByAccountId(String AccountId);
	
	@Transactional
	@Modifying
	@Query("update Account a set a.balance = ?1 where a.accountId = ?2")
	void updateBalance(long balance, String accountId);
//	@Modifying
//	@Query("update Account a set a.balance = :balance where a.accountId = :accountId")
//	void updateBalance(@Param(value = "accountId") String accountId, @Param(value = "balance") double balance);
}

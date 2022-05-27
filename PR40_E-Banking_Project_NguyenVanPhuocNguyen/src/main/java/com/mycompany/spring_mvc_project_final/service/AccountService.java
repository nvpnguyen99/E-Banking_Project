package com.mycompany.spring_mvc_project_final.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.SavingDeposit;
import com.mycompany.spring_mvc_project_final.entities.Transfer;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.entities.UserRoleEntity;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.UserRepository;



@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	public Account findByAccountId(String AccountId)  {
		return accountRepository.findByAccountId(AccountId);
	}
	
	public Optional<Account> findById(int id)  {
		return accountRepository.findById(id);
	}
	
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	public List<Account> findAllAccount() {
		return (List<Account>) accountRepository.findAll();
	}

	
	public void updateBalance(long balance, String accountId ) {
		accountRepository.updateBalance(balance,accountId);
	}
}
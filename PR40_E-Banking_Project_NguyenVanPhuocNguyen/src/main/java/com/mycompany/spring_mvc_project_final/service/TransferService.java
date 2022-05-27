package com.mycompany.spring_mvc_project_final.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.Transfer;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.entities.UserRoleEntity;
import com.mycompany.spring_mvc_project_final.repository.TransferRepository;
import com.mycompany.spring_mvc_project_final.repository.UserRepository;






@Service
public class TransferService {
	@Autowired
	TransferRepository transferRepository;
	
	@Autowired
	AccountService accountService;
	
	public void save(Transfer transfer) {
		transferRepository.save(transfer);
	}
	
	public List<Transfer> findTransferByAccountId (String accountId){
		return transferRepository.findTransferByAccountId(accountId);
	}
	
	 @Transactional(rollbackFor = Exception.class)
	public void transferAndUpdateAccount(Transfer transfer,Account account_source, Account account_target) throws Exception {
		long amount_source = account_source.getBalance() - transfer.getAmount();
		account_source.setBalance(amount_source);
        // accountService.save(account_source);		
		accountService.updateBalance(account_source.getBalance(), transfer.getAccountSource());

		long amount_target = account_target.getBalance() + transfer.getAmount();
		account_target.setBalance(amount_target);
		// accountService.save(account_target);
		accountService.updateBalance(account_target.getBalance(), transfer.getAccountTarget());
		LocalDateTime instance = LocalDateTime.now();
		transfer.setTransferDateTime(instance);
		transferRepository.save(transfer);
		if(account_source.getBalance()<0) {
			throw new Exception("amount exception");
		}
	}
}
package com.vinhnguyen.crudapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinhnguyen.crudapi.entites.Account;
import com.vinhnguyen.crudapi.repository.AccountRepository;
import com.vinhnguyen.crudapi.service.AccountService;

@Service
public class AccountServiceimpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

}

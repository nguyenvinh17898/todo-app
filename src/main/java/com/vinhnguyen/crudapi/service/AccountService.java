package com.vinhnguyen.crudapi.service;

import com.vinhnguyen.crudapi.entites.Account;

public interface AccountService {
	
	public Account findByUsername(String username);
}

package com.vinhnguyen.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinhnguyen.crudapi.entites.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	public Account findByUsername(String username);
}
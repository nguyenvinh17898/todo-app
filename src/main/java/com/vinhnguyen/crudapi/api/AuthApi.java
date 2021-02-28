package com.vinhnguyen.crudapi.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinhnguyen.crudapi.entites.Account;

@RestController
public class AuthApi {
	@PostMapping("/api/register")
	public void register(@Valid @RequestBody Account account) {
		System.out.println(account);
	}
	
	@PostMapping("/api/login")
	public void login(@RequestParam("username") String username) {
		System.out.println(username);
	}
	
	@GetMapping("/api/loginSuccess")
	public String loginSuccess() {
		return "Success";
	}
}

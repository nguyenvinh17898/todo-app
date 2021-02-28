package com.vinhnguyen.crudapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vinhnguyen.crudapi.entites.Account;
import com.vinhnguyen.crudapi.service.impl.AccountServiceimpl;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountServiceimpl acccountService = new AccountServiceimpl();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = acccountService.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("Username Not Found");
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		return new User(account.getUsername(), account.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

}

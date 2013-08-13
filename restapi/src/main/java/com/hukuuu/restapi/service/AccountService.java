package com.hukuuu.restapi.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.hukuuu.restapi.domain.Account;

public interface AccountService {

	public List<Account> findAll();
	public Account create(Account account);
	public UserDetails loadUserByUsername(String username);
	
}

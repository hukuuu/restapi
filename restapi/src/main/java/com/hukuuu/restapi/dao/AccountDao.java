package com.hukuuu.restapi.dao;

import java.util.List;

import com.hukuuu.restapi.domain.Account;

public interface AccountDao {

	public List<Account> findAll();
	public Account create(Account account);
	public Account findByUserName(String username);
}

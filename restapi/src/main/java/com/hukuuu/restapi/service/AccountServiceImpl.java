package com.hukuuu.restapi.service;

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
import org.springframework.transaction.annotation.Transactional;
import com.hukuuu.restapi.dao.AccountDao;
import com.hukuuu.restapi.domain.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Account account = accountDao.findByUserName(username);
		if (account == null) {
			throw new UsernameNotFoundException("username is not found");
		}
		SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("USER");
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(userRole);
		return new User(account.getUsername(), account.getPassword(),roles );
	}

	
	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public Account create(Account account) {
		return accountDao.create(account);
	}


}

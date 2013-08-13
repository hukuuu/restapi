package com.hukuuu.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hukuuu.restapi.domain.Account;
import com.hukuuu.restapi.service.AccountService;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Account> getAll() {
		System.out.println("controller get accounts");
		return accountService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Account create(@RequestBody @Valid Account account) {
		return accountService.create(account);

	}
}

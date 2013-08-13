package com.hukuuu.restapi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hukuuu.restapi.domain.Account;

@Repository
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {

	@PersistenceContext
	private EntityManager em;

	public AccountDaoImpl() {
		super(Account.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public Account findByUserName(String username) {
		TypedQuery<Account> query = em.createNamedQuery(Account.FIND_BY_USERNAME, Account.class);
		query.setParameter("username", username);
		Account result = query.getSingleResult();
		System.out.println("account: " + result );
		return result;
	}
	
}

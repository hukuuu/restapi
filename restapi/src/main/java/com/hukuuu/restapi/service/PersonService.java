package com.hukuuu.restapi.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hukuuu.restapi.domain.Person;

@Service
@Transactional
public class PersonService {

	@PersistenceContext
	private EntityManager em;

	public Person savePerson(Person person) {
		em.persist(person);
		em.flush();
		System.out.println(person);
		return person;
	}
}

package com.hukuuu.restapi.controller;

import javax.validation.Valid;
import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hukuuu.restapi.domain.Person;
import com.hukuuu.restapi.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping( method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}

	@RequestMapping( method = RequestMethod.GET, value = "/signup")
	public String signUp(){
		return "signup";
	}
	

	@RequestMapping( method = RequestMethod.GET, value = "/people")
	public @ResponseBody Person getPeople() {
		return new Person("nikolai");
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/people" )
	@Consumes(value= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Person createPerson(@RequestBody @Valid Person person) {
		return personService.savePerson(person);
	}
}

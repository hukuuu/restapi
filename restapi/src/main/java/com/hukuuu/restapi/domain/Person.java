/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hukuuu.restapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
 	private String name;
 	
 	public Person(){
 		
 	}

	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "id: " + this.id + " name: " + this.name;
	}
}

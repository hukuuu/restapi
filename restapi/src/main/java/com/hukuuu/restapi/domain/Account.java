package com.hukuuu.restapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Account.FIND_BY_USERNAME", query = "SELECT a FROM Account a WHERE a.username LIKE :username") })
public class Account {

	public static final String FIND_BY_USERNAME = "findByUsername";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String acessToken;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private String username;

	@OneToMany(mappedBy = "owner")
	private List<Ride> rides;

	public String getAcessToken() {
		return acessToken;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public List<Ride> getRides() {
		return rides;
	}

	public String getUsername() {
		return username;
	}

	public void setAcessToken(String acessToken) {
		this.acessToken = acessToken;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

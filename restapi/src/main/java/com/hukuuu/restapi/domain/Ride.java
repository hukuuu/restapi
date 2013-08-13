package com.hukuuu.restapi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ride {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String from;
	private String to;
	private Date dateWhen;
	private String startTime;

	@ManyToOne()
	private Account owner;

	public Date getDateWhen() {
		return dateWhen;
	}
	public String getFrom() {
		return from;
	}
	public Long getId() {
		return id;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getTo() {
		return to;
	}
	public void setDateWhen(Date dateWhen) {
		this.dateWhen = dateWhen;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Account getOwner() {
		return owner;
	}
	public void setOwner(Account owner) {
		this.owner = owner;
	}
	
	
	
	
}

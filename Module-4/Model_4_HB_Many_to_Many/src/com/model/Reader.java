package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Reader")
public class Reader
{
	private int readerid;
	private String email,firstname,lastname;
	Set<Subscrptions> subscriptions;
	public int getReaderid() {
		return readerid;
	}

	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@ManyToMany(mappedBy = "reader")
	public Set<Subscrptions> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(Set<Subscrptions> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
}

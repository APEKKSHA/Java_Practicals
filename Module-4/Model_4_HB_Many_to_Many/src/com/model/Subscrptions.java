package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Subscrptions")
public class Subscrptions 
{
	private int subid;
	private String subname;
	Set<Reader> reader;
	
	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	
	@ManyToMany
	@JoinTable( name = "red_sub",
	joinColumns = @JoinColumn(name="subid"),
	inverseJoinColumns = @JoinColumn(name = "readerid") 
			)	
			
	public Set<Reader> getReader() {
		return reader;
	}
	public void setReader(Set<Reader> reader) {
		this.reader = reader;
	}
	
}

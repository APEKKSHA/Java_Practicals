package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Cart")
public class Cart 
{
	private int cartid;
	private double total;
	private String name;
	Set<Items> itemss;
	
	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "cart")
	public Set<Items> getItemss() {
		return itemss;
	}
	public void setItemss(Set<Items> itemss) {
		this.itemss = itemss;
	}
	
}

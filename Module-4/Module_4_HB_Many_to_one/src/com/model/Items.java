package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Items")
public class Items
{
	private int id,quantity;
	private String itemid;
	private double itemTotal;
	Cart cart;
	
	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	@ManyToOne
	@JoinColumn(name = "cartid")
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}

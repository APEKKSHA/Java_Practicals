package com.test;

import com.dao.HBDao;
import com.model.Cart;
import com.model.Items;

public class Test 
{
	public static void main(String[] args) 
	{
		HBDao dao=new HBDao();
		
		Cart ct=new Cart();
		ct.setName("cart-1");
		ct.setTotal(1200);
		dao.addCart(ct);
		
		Items it=new Items();
		it.setItemid("salt");
		it.setItemTotal(150);
		it.setQuantity(3);
		dao.addItems(it);
		

		Items it2=new Items();
		it2.setItemid("sugar");
		it2.setItemTotal(250);
		it2.setQuantity(2);
		dao.addItems(it2);
		
		dao.deleteItems(it2);
	}
}

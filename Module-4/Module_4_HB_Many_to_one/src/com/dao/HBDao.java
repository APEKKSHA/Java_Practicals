package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Cart;

import com.model.Items;
import com.util.HBUtil;

public class HBDao 
{
	
	Session session=null;
	Transaction tx=null;
	 public void addItems(Items i)
	 {
		 session=new HBUtil().getSessionData();
			tx= session.beginTransaction();
			session.save(i);
			tx.commit();
			session.close();
			System.out.println("Item record inserted successfully...");
	 }
	 
	 public void updateItems(Items i)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.update(i);
			tx.commit();
			System.out.println("Record inserted...");
		}
		
		public void deleteItems(Items i)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.delete(i);
			tx.commit();
			System.out.println("Record deleted...");
		}
		public void addCart(Cart c)
		 {
			 session=new HBUtil().getSessionData();
				tx= session.beginTransaction();
				session.save(c);
				tx.commit();
				session.close();
				System.out.println("Cart record inserted successfully...");
		 }
		public void updateCart(Cart c)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.update(c);
			tx.commit();
			System.out.println("Record inserted...");
		}
		
		public void deleteCart(Cart c)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.delete(c);
			tx.commit();
			System.out.println("Record deleted...");
		}
		 
}

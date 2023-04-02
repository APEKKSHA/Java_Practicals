package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Reader;
import com.model.Subscrptions;
import com.util.HBUtil;

public class HBDao 
{
	
	Session session=null;
	Transaction tx=null;
	 public void addReader(Reader i)
	 {
		 session=new HBUtil().getSessionData();
			tx= session.beginTransaction();
			session.save(i);
			tx.commit();
			session.close();
			System.out.println("Item record inserted successfully...");
	 }
	 
	 public void updateReader(Reader i)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.update(i);
			tx.commit();
			System.out.println("Record inserted...");
		}
		
		public void deleteReader(Reader i)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.delete(i);
			tx.commit();
			System.out.println("Record deleted...");
		}
		public void addSubscriptions(Subscrptions c)
		 {
			 session=new HBUtil().getSessionData();
				tx= session.beginTransaction();
				session.save(c);
				tx.commit();
				session.close();
				System.out.println("Cart record inserted successfully...");
		 }
		public void updateSubscriptions(Subscrptions c)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.update(c);
			tx.commit();
			System.out.println("Record inserted...");
		}
		
		public void deleteSubscriptions(Subscrptions c)
		{
			session=new HBUtil().getSessionData();
			tx=session.beginTransaction();
			session.delete(c);
			tx.commit();
			System.out.println("Record deleted...");
		}
		 
}

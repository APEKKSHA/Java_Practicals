package com.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Address;
import com.model.Student;
import com.util.HBUtil;

public class StudentDao 
{
		Session session=null;
		Transaction tx=null;
		public void addStud(Student s)
		{
			session=new HBUtil().getSessionData();
			tx= session.beginTransaction();
			session.save(s);
			tx.commit();
			session.close();
			System.out.println("student record inserted successfully...");
		}
		public void addAdd(Address a)
		{
			session=new HBUtil().getSessionData();
			tx= session.beginTransaction();
			session.save(a);
			tx.commit();
			session.close();
			System.out.println("student address record inserted successfully...");
		}
}

package com.test;

import java.util.HashSet;

import com.dao.HBDao;
import com.model.Reader;
import com.model.Subscrptions;

public class Test 
{
	public static void main(String[] args) 
	{
		HBDao dao=new HBDao();
		HashSet<Reader> red=new HashSet<Reader>();
		
		Reader r1=new Reader();
		r1.setEmail("apeksha6580@gmail.com");
		r1.setFirstname("Apeksha");
		r1.setLastname("Patel");
		r1.setReaderid(101);
		 dao.addReader(r1);
		
		 Reader r2=new Reader();
			r2.setEmail("abc123@gmail.com");
			r2.setFirstname("ABC");
			r2.setLastname("XYZ");
			r2.setReaderid(102);
			 dao.addReader(r2);
			 
			 red.add(r1);
			 red.add(r2);
			 
			 Subscrptions sb=new Subscrptions();
			 sb.setSubid(111);
			 sb.setSubname("TopsTech");
			 dao.addSubscriptions(sb);
		
	}
}

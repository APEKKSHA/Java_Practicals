package com.test;

import com.dao.StudentDao;
import com.model.Address;
import com.model.Student;

public class StudentTest 
{
	public static void main(String[] args) 
	{
			StudentDao dao=new StudentDao();
			
			
			Address a1=new Address();
			a1.setCity("Ahmedabad");
			a1.setState("Gujarat");
			a1.setStreet("Chandkheda");
			a1.setZipcode("380019");
			dao.addAdd(a1);
			
			Student s1=new Student();
			s1.setStudentName("Apeksha");
			s1.setAddress1(a1);
			dao.addStud(s1);
			
	}
}

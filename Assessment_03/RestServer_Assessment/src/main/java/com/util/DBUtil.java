package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil 
{
	
	public static Connection getConnectionData()
	{Connection cn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment","root", "Apeksha@9");
			System.out.println("Connection Established...");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return cn;
	}
}

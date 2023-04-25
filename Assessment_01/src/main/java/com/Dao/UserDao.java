package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model.UserModel;
import com.util.DBUtil;

public class UserDao 
{
	Connection cn=null;
	int x=0;
	public int doUserRegister(UserModel um)
	{
		cn=new DBUtil().getConnectionData();
		String qry="insert into userdata(firstname,lastname,email,mobno,address,gender,password) value(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st=cn.prepareStatement(qry);
			
			st.setString(1, um.getFirstname());
			st.setString(2, um.getLastname());
			st.setString(3, um.getEmail());
			st.setString(4, um.getMobno());
			st.setString(5, um.getAddress());
			st.setString(6, um.getGender());
			st.setString(7, um.getPassword());
			x=st.executeUpdate();
			cn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	
	UserModel m=null;
	public UserModel doUserLogin(UserModel um)
	{
		cn=new DBUtil().getConnectionData();
		String  qry="select * from userdata where email=? and password=?";
		try {
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, um.getEmail());
			st.setString(2 , um.getPassword());
			
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				m=new UserModel();
				m.setUid(rs.getInt(1));
				m.setFirstname(rs.getString(2));
				m.setLastname(rs.getString(3));
				m.setEmail(rs.getString(4));
				m.setMobno(rs.getString(5));
				m.setAddress(rs.getString(6));
				m.setGender(rs.getString(7));
				m.setPassword(rs.getString(8));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
}

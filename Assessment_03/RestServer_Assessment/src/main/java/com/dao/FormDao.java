package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Personaldetails;

import com.util.DBUtil;



public class FormDao
{
	static Connection cn=null;
	static int x=0;
	
	public static int doRegister(Personaldetails pd)
	{ int x=0;
		try {
		cn=new DBUtil().getConnectionData();
		String qry="insert into personaldetails(fname,lname,address,mobno) values(?,?,?,?)";
	
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, pd.getFname());
			st.setString(2, pd.getLname());
			st.setString(3, pd.getAddress());
			st.setString(4, pd.getMobno());
			
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return x;
	}

	public static List<Personaldetails> getAllDetails()
	{
		List<Personaldetails> list=new ArrayList<Personaldetails>();
		String sql="select * from emp";
		try {
		Connection cn= DBUtil.getConnectionData();
		PreparedStatement pst=cn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Personaldetails p=new Personaldetails();
			p.setPid(rs.getInt("pid"));
			p.setFname(rs.getString("fname"));
			p.setLname(rs.getString("lname"));
			p.setAddress(rs.getString("address"));
			p.setMobno(rs.getString("mobno"));
			list.add(p);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static Personaldetails getdetails(int id)
	{
		Personaldetails s=null;
		try {
			Connection conn=DBUtil.getConnectionData();
			String sql="select * from emp where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				s=new Personaldetails();
				s.setPid(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setAddress(rs.getString("address"));
				s.setMobno(rs.getString("mobno"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public static int doEdit(Personaldetails pd)
	{
		try {
		cn=new DBUtil().getConnectionData();
		String qry="update personaldetails set fname=?,lname=? ,address=? ,mobno=? where pid=?";
		
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, pd.getFname());
			st.setString(2, pd.getLname());
			st.setString(3, pd.getAddress());
			st.setString(4, pd.getMobno());
			st.setInt(5, pd.getPid());
			
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return x;
	}
	
	public static int doDelete( Personaldetails pd)
	{
		cn=new DBUtil().getConnectionData();
		String qry="delete from personaldetails where pid=?";
		try {
			PreparedStatement st=cn.prepareStatement(qry);

			st.setInt(1, pd.getPid());
			System.out.println(st);
			x=st.executeUpdate();
			System.out.println(x);
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return x;
	}
}

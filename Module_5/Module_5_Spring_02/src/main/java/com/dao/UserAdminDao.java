package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.UserModel1;



public class UserAdminDao 
{
	JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public int save(UserModel1 p){    
	    String sql="insert into useradmin(fname,lname,email,mobno,password,profile) values('"+p.getFname()+"','"+p.getLname()+"','"+p.getEmail()+"','"+p.getMobno()+"','"+p.getPassword()+"','"+p.getGender()+"','null')";    
//	    '"+p.getProfile()+"'
	    return jt.update(sql);    
	}
	
	public List<UserModel1> getUser()
	{ 
	    return jt.query("select * from useradmin",new RowMapper<UserModel1>()
	    {    
	        public UserModel1 mapRow(ResultSet rs, int row) throws SQLException {    
	        	UserModel1 e=new UserModel1();    
	            e.setId(rs.getInt(1));    
	            e.setFname(rs.getString(2));
	            e.setLname(rs.getString(3));    
	            e.setEmail(rs.getString(4));
	            e.setMobno(rs.getString(5));
	            e.setPassword(rs.getString(6));
	            e.setGender(rs.getString(7));
	            e.setProfile(rs.getString(8));
//	            e.setFramework(rs.getString(4));    
	            return e;    
	        }    
	    });    
	    
	}
	public UserModel1 getUserById(int id){    
	    String sql="select * from useradmin where id=?";    
	    return jt.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<UserModel1>(UserModel1.class));    
	}  
	
	public int update(UserModel1 p){    
	    String sql="update useradmin set fname='"+p.getFname()+"',lname='"+p.getLname()+"', email="+p.getEmail()+",mobno='"+p.getMobno()+"',password='"+p.getPassword()+"',gender='"+p.getGender()+"',profile='"+p.getProfile()+"', where id="+p.getId()+"";    
	    return jt.update(sql);    
	} 
	public int delete(int id){    
	    String sql="delete from useradmin where id="+id+"";    
	    return jt.update(sql);    
	} 
}

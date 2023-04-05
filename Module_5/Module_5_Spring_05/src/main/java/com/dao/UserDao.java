package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.UserModel;



public class UserDao 
{
	JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public int save(UserModel p){    
	    String sql="insert into user(id,name,email,framework) values("+p.getId()+",'"+p.getName()+"','"+p.getEmail()+"','"+p.getFramework()+"')";    
	    return jt.update(sql);    
	}
	
	public List<UserModel> getUser()
	{ 
	    return jt.query("select * from user",new RowMapper<UserModel>()
	    {    
	        public UserModel mapRow(ResultSet rs, int row) throws SQLException {    
	        	UserModel e=new UserModel();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setEmail(rs.getString(3));    
	            e.setFramework(rs.getString(4));    
	            return e;    
	        }    
	    });    
	    
	}
	public UserModel getUserById(int id){    
	    String sql="select * from user where id=?";    
	    return jt.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<UserModel>(UserModel.class));    
	}  
	
	public int update(UserModel p){    
	    String sql="update User set name='"+p.getName()+"', email="+p.getEmail()+",framework='"+p.getFramework()+"' where id="+p.getId()+"";    
	    return jt.update(sql);    
	} 
	public int delete(int id){    
	    String sql="delete from user where id="+id+"";    
	    return jt.update(sql);    
	} 
}

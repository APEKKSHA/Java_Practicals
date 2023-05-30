package com.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.Personaldetails;
import com.dao.FormDao;

import com.google.gson.Gson;

@Path("student")
public class StudentService {

	Gson gson=new Gson();
	
	@Path("insert")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public String insertDetailss(String details)
	{
		Personaldetails s=gson.fromJson(details, Personaldetails.class);
		int result=FormDao.doRegister(s);
		if(result>0)
		{
			return "Data Inserted Successfully";
		}
		else
		{
			return "Data Insertion Failed";
		}
	}
	
	@Path("fetchall")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String getAllDetails()
	{
		 List<Personaldetails> list=FormDao.getAllDetails();
		return gson.toJson(list);
	}
	
	@Path("getid")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public String getDetails(String pid)
	{
		System.out.println("getid called");
		int id=gson.fromJson(pid, Integer.class);
		Personaldetails s=FormDao.getdetails(id);
		System.out.println(s.getPid());
		return gson.toJson(s);
	}
	
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public String updateDetails(String student)
	{
		Personaldetails s=gson.fromJson(student, Personaldetails.class);
		int result=FormDao.doEdit(s);
		if(result>0)
		{
			return "Data Updated Successfully";
		}
		else
		{
			return "Data Updation Failed";
		}
	}
	
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String deleteDetails(String sid)
	{
		Personaldetails id=gson.fromJson(sid, Personaldetails.class);
		int result=FormDao.doDelete(id);
		if(result>0)
		{
			return "Data Deleted Successfully";
		}
		else
		{
			return "Data Deletion Failed";
		}
	}
}

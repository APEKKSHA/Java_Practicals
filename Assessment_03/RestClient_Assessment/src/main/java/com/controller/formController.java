package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.bean.Personaldetails;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//import com.dao.FormDao;
//import com.model.Personaldetails;

/**
 * Servlet implementation class formController
 */
@WebServlet("/formController")
public class formController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String WebServer="http://localhost:8080/RestServer_Assessment/";
	ClientConfig config=null;
	Client client=null;
	WebTarget target=null;
	Gson gson=null;
	
	
    public formController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		config=new ClientConfig();
		client=ClientBuilder.newClient(config);
		target=client.target(WebServer).path("rest");
		gson=new Gson();
		String action=request.getParameter("action");
		
		if(action.equals("register"))
		{
			Personaldetails pd=new Personaldetails();
			pd.setFname(request.getParameter("fname"));
			pd.setLname(request.getParameter("lname"));
			pd.setAddress(request.getParameter("address"));
			pd.setMobno(request.getParameter("mobno"));
			
			String details=gson.toJson(pd);
			
			Response rs=target.path("details").path("insert").request().post(Entity.json(details));
			String result=rs.readEntity(String.class);
			

			if(rs.getStatus()==200)
			{
				showDetails(request, response);
			}
			else
			{
				System.out.println(result);
			}
		}
		else if(action.equals("edit"))
		{
			Personaldetails pd1=new Personaldetails();
			String pid=gson.toJson(pd1);
			Response rs=target.path("details").path("pid").request().post(Entity.json(pid));
			String result=rs.readEntity(String.class);
			if(rs.getStatus()==200)
			{
				Personaldetails s=gson.fromJson(result, Personaldetails.class);
				request.setAttribute("details", s);
				
			}
			else
			{
				request.setAttribute("error", "Data Fetching Failed");
			}
			request.getRequestDispatcher("editform.jsp").forward(request, response);
		
			
		}
		else if(action.equals("delete"))
		{	
			Personaldetails pd=new Personaldetails();
			pd.setPid(Integer.parseInt(request.getParameter("pid")));
			System.out.println(pd);
			String pid=gson.toJson(pd);
			Response rs=target.path("details").path("delete").request().post(Entity.json(pid));
			String result=rs.readEntity(String.class);
			if(rs.getStatus()==200)
			{
				showDetails(request, response);
			}
			else
			{
				System.out.println(result);
			}
		}
		else if(action.equals("Submit"))
		{
			Personaldetails pd=new Personaldetails();
			pd.setFname(request.getParameter("fname"));
			pd.setLname(request.getParameter("lname"));
			pd.setAddress(request.getParameter("address"));
			pd.setMobno(request.getParameter("mobno"));
			pd.setPid(Integer.parseInt(request.getParameter("pid")));
			String details=gson.toJson(pd);
			
			Response rs=target.path("details").path("Ssubmit").request().post(Entity.json(details));
			String result=gson.toJson(pd);
			if(rs.getStatus()==200)
			{
				showDetails(request, response);
			}
			else
			{
				System.out.println(result);
			}
			
		}
		else
		{
			System.out.println("In Else Part");
		}
		
		
	}
	protected void showDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Response rs=target.path("details").path("fetchall").request().get();
		String result=rs.readEntity(String.class);
		if(rs.getStatus()==200)
		{
			List<Personaldetails> list=gson.fromJson(result, new TypeToken<List<Personaldetails>>(){}.getType());
			request.setAttribute("list", list);
		}
		else
		{
			request.setAttribute("error", "Data Fetching Failed");
		}
		request.getRequestDispatcher("viewdetails.jsp").forward(request, response);
	}

}

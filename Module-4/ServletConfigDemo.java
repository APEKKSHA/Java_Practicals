package com.Servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletConfigDemo")
public class ServletConfigDemo extends HttpServlet {
	ServletConfig config=null;
	private static final long serialVersionUID = 1L;
       
    
    public ServletConfigDemo() {
        super();
        }

	
    public void init(ServletConfig config) throws ServletException
    {
    	this.config=config;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("ServletConfig Demo...");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		out.print("<h1> Username is:"+username);
		out.print("<br> Password is:"+password);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}

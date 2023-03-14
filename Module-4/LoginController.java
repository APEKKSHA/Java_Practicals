package com.Servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
     }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals(password))
		{
//			request.setAttribute("username", username);
//			request.getRequestDispatcher("welcome.jsp").forward(request,response);
	response.sendRedirect("welcome.jsp?username="+username);
		
		}
		else
		{
			request.setAttribute("error", "Invalid Username or password...");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

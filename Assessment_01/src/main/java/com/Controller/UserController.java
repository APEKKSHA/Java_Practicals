package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Model.UserModel;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action=request.getParameter("action");
			if(action.equals("submit"))
			{
				UserModel um=new UserModel();
				um.setFirstname(request.getParameter("firstname"));
				um.setLastname(request.getParameter("lastname"));
				um.setEmail(request.getParameter("email"));
				um.setMobno(request.getParameter("mobno"));
				um.setAddress(request.getParameter("address"));
				um.setGender(request.getParameter("gender"));
				um.setPassword(request.getParameter("password"));
						
//				int m=((UserDao) new UserDao()).doUserLogin(um);
				int m=new UserDao().doUserRegister(um);
				if(m>0)
				{
					response.sendRedirect("user-header.jsp");
				}
				else
				{
					System.out.println("value of m..."+m);
					response.sendRedirect("UserSignUp.jsp");
				}
			}
			else if(action.equals("login"))
			{
				UserModel lm=new UserModel();
				lm.setEmail(request.getParameter("email"));
				lm.setPassword(request.getParameter("password"));
				UserModel m=new UserDao().doUserLogin(lm);
				if(m!=null)
				{
					HttpSession session=request.getSession(true);
					session.setAttribute("m", m);
					session.setAttribute("firstname", m.getFirstname());
					session.setAttribute("lastname", m.getLastname());
					response.sendRedirect("cust-home.jsp");
				}
				
			}
			
			else
			{
				System.out.println("in else part..");
			}
	}

}

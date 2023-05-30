<%@page import="com.bean.Personaldetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Edit Personal Details Form</h4>
<form action="formController" method="post" >

<%
		/* int pid=Integer.parseInt(request.getParameter("pid"));                      
           	Connection cn=new DBUtil().getConnectionData();
          PreparedStatement st=cn.prepareStatement("select * from personaldetails where pid=?");
          st.setInt(1, pid);
          ResultSet rs=st.executeQuery();
          while(rs.next())
          
		{ */
        	  
        	  Personaldetails rs=(Personaldetails)request.getAttribute("details");
        %>
  <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname" value="<%= rs.getFname() %>"><br>
  <label for="lname">Last name:</label>
  <input type="text" id="lname" name="lname" value="<%= rs.getLname() %>"><br>
  <label for="add">Address:</label>
  <input type="text" id="address" name="address" value="<%= rs.getAddress() %>"><br>
  <label for="mobno">Mobile No:</label>
  <input type="text" id="mobno" name="mobno" value="<%= rs.getMobno() %>"><br>
 
  <br>
  <input type="submit" name="action" value="Submit">
  
  
</form>
</body>
</html>
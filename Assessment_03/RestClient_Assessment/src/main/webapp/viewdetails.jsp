<%@page import="com.bean.Personaldetails"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<h4>Details </h4>
<!-- <form action="formController" method="post" > -->
<table>
  <tr>
    <th>Sr no.</th>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Address</th>
    <th>Mobile</th>
    <th colspan="2">Edit</th>
  </tr>
  <tr>
  	<% 
  	List<Personaldetails> list=(List<Personaldetails>)request.getAttribute("list");
	for(Personaldetails rs:list)
	{
  	%>
  
    <td><%= rs.getPid() %></td>
    <td><%= rs.getFname() %></td>
    <td><%= rs.getLname() %></td>
    <td><%= rs.getAddress() %></td>
    <td><%= rs.getMobno() %></td>
    <td>
    <form name="edit" method="post" action="formController">
	<input type="hidden" name="id" value="<%=rs.getPid()%>">
    <input type="submit" name="action" value="edit">
    </a></td>
   <td> 
   <formname="delete" action="formController" method="post">
    <input type="hidden" name="pid" value="<%=rs.getPid()%>">
    <input type="submit" name="action" value="delete" >
  </form>
  </td>
  </tr>
  <%
    }
   /*  cn.close(); */
  %>
</table>
<!-- </form> -->
</body>
</html>
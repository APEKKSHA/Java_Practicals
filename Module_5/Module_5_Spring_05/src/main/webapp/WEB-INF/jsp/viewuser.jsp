<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #777;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
#p {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
li a:hover {
  background-color: #333;
}
</style>
</head>

<body>
<ul>
  <li id="p">Spring MVC Form</li>
  <li style="float:right"><a href="adduser">Add User</a></li>
  
</ul>
<br>


<table border="3">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Framework</th>
		<th colspan="2">Action</th>
		
	</tr>
	<c:forEach var="list" items="${list }">
		<tr>
			<td>${list.id }</td>
			<td>${list.name }</td>
			<td>${list.email }</td>
			<td>${list.framework }</td>
			<td> <a href="edituser/${ list.id }"> Edit</a></td>
			<td> <a href="deleteuser/${list.id }"> Delete</a></td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>
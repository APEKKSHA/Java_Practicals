<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username=request.getAttribute("username").toString();
%>
<%-- <h1>Welcome , <%=username  %> </h1>  --%>

 <%-- <%
	String username=request.getParameter("username");
%> --%>
<h1>Welcome , <%=username  %> </h1> 
</body>
</html>
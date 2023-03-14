<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="s1" class="com.Model.Student"></jsp:useBean>

<jsp:useBean id="s2" class="com.Model.Student"></jsp:useBean>

<jsp:setProperty property="sid" value="1234" name="s1"/>
<jsp:setProperty property="sname" value="Apeksha" name="s1"/>
<jsp:setProperty property="city" value="Ahmedabad" name="s1"/>
<jsp:setProperty property="sid" value="1235" name="s2"/>
<jsp:setProperty property="sname" value="Ram" name="s2"/>
<jsp:setProperty property="city" value="Nehrunagar" name="s2"/>

<table border="1">
<tr>
	<th>Sid</th>
	<th>Sname</th>
	<th>City</th>
</tr>
<tr>
	<td><%= s1.getSid() %></td>
	<td><jsp:getProperty property="sname" name="s1" /></td>
	<td><jsp:getProperty property="city" name="s1"/></td>
	
</tr>
<tr>
	<td><%= s2.getSid() %></td>
	<td><jsp:getProperty property="sname" name="s2" /></td>
	<td><jsp:getProperty property="city" name="s2"/></td>
	
</tr>

</table>

</body>
</html>
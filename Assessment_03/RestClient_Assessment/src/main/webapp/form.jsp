<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Personal Details Form</h4>
<form name="insert" action="formController" method="post" >
  <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname"><br><br>
  <label for="lname">Last name:</label>
  <input type="text" id="lname" name="lname"><br><br>
  <label for="address">Address:</label>
  <input type="text" id="address" name="address"><br><br>
  <label for="mobno">Mobile No:</label>
  <input type="text" id="mobno" name="mobno">
  <br><br>
  <input type="submit" name="action" value="register">
</form>
</body>
</html>
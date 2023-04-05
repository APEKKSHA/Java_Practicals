<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="save"">
<h1>Add User</h1>
<!-- user id -->
<div class="form-outline mb-4">
    
    <label class="form-label" for="form1Example1">ID</label>
  <input type="text" id="form1Example1" class="form-control" name="id"/>
  </div>
  <br>
  <!-- user Name -->
  <div class="form-outline mb-4">
    
    <label class="form-label" for="form1Example1">Name</label>
  <input type="text" id="form1Example1" class="form-control" name="name"/>
  </div>
  <br>
  <!-- Email input -->
  <div class="form-outline mb-4">
    
    <label class="form-label" for="form1Example1">Email address</label>
  <input type="email" id="form1Example1" class="form-control" name="email"/>
  </div>
<br>
  <!-- framework input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form1Example2">Framework</label>
  	<input type="text" id="form1Example2" class="form-control" name="framework"/>
  </div>

<br>
  <!-- Submit button -->
  <button type="submit" value="Add" class="btn btn-primary btn-block">Add</button>
</form>
</body>
</html>
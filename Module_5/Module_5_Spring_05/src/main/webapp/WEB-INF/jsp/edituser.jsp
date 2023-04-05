<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/Module_5_Spring_05/editsave">
<h1>Add User</h1>
<!-- user id -->
<div class="form-outline mb-4">
    
    <label class="form-label" for="form1Example1">ID</label>
  <input type="text" id="form1Example1" value="${command.id }" class="form-control" />
  </div>
  <!-- user Name -->
  <div class="form-outline mb-4">
    
    <label class="form-label" for="form1Example1">Name</label>
  <input type="email" id="form1Example1" value="${command.name }" class="form-control" />
  </div>
  <!-- Email input -->
  <div class="form-outline mb-4">
    
    <label class="form-label" for="form1Example1">Email address</label>
  <input type="email" id="form1Example1" value="${command.email }" class="form-control" />
  </div>

  <!-- framework input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form1Example2">Framework</label>
  	<input type="text" id="form1Example2" value="${command.framework }" class="form-control" />
  </div>

<br>
  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block">Add</button>
</form>
</body>
</html>
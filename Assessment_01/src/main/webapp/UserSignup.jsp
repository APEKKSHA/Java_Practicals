<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>GfG</title>
  
  <style type="text/css">
  
  input[type=text]:focus {
  border: 3px solid #555;
}
  </style>
  <script>  
function matchPassword() {  
  var pw1 = document.getElementById("password");  
  var pw2 = document.getElementById("cpassword");  
  if(pw1 != pw2)  
  {   
    alert("Passwords did not match");  
  } else {  
    alert("Password Registered successfully");  
  }  
}  
  
var request=new XMLHttpRequest();  
function searchMailInfo()
{  
	var email=document.vinform.email.value;  
	var url="usersignupajax.jsp?val="+email;  
  	try
  	{  
		request.onreadystatechange=function()
		{  
			if(request.readyState==4)
			{  
				var val=request.responseText;  
				document.getElementById('tops').innerHTML=val;  
			}  
		}  
		request.open("GET",url,true);  
		request.send();  
	}
  	catch(e)
  	{
  		alert("Unable to connect to server");
  	}  
}  
 
</script>  
</head>
<body>
<%@ include file="header.jsp" %>
  <form method="post" action="UserController" >
    <fieldset>
      <legend>Sign Up</legend>
<!-- 
<p>
        <label>
          Salutation
          <br />
          <select name="salutation">
            <option>--None--</option>
            <option>Mr.</option>
            <option>Ms.</option>
            <option>Mrs.</option>
            <option>Dr.</option>
            <option>Prof.</option>
          </select>
        </label>
      </p> -->
 
<p>
        <label>First name: <input name="firstname" required/></label>
      </p>
 
 
       
 
<p>
        <label>Last name: <input name="lastname" required/></label>
      </p>
 
 <p>
        <label>Email:<input type="email" name="email" onkeyup="searchMailInfo()" /></label>
      </p>
      <p>
        <label>Mobile:<input type="text" name="mobno" required/></label>
      </p>
      <p>
        <label>
          Address :
          <br />
          <textarea name="address" cols="30" rows="3" required></textarea>
        </label>
      </p>
<p>
        Gender :
        <label><input type="radio" name="gender" value="male" /> Male</label>
        <label><input type="radio" name="gender" value="female" /> Female</label>
      </p>
 
<p>
        <label>Password:<input type="password" name="password" required></label>
      </p>
   
<p>
        <label>Confirm Password:<input type="password" name="cpassword" required></label>
      </p>   
 
<p>
        <button type="submit" name="action" value="submit" onclick="matchPassword()">Submit</button>
      </p>

     </fieldset>
  </form>
  <span id="tops"></span> 
</body>
</html>
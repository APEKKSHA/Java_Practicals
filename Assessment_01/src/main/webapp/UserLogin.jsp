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
</head>
<body>
<%@ include file="header.jsp" %>
  <form name="form-login" id="form-login" action="UserController" method="post">
    <fieldset>
      <legend>User Login</legend>
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
        <label>Email:<input type="email" id="email" name="email" /></label>
      </p>
      <!-- <p>
        <label>Mobile:<input type="text" name="mobno" /></label>
      </p>
       -->
 
<p>
        <label>Password:<input type="password" id="password" name="password"></label>
      </p>
 <p>
        <button type="submit" name="action" value="login" onclick="login()">Submit</button>
      </p>

     </fieldset>
  </form>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script >

	var msg=null;

	function login()
	 {
		if($('#email').val()=="")
		{
			$('#email').parent('input').addClass('has-error');
			return false;
		}	
		else if($('#password').val()=="")
		{
				$('#password').parent('input').addClass('has-error');
				return false;
		}
		var data = $("#form-login").serialize();

		$.ajax({

				type : 'POST',
				url : 'UserController',
				data : data,
				dataType : 'JSON',

				success : functon(data)
				{
					msg=data[0].msg
				}
			
			})	
	}	

  </script>
</body>
</html>
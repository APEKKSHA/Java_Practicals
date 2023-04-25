    <%@ page import="java.sql.*" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
    <%  
    String mail=request.getParameter("val");  
    if(mail==null||mail.trim().equals(""))
    {  
    	out.print("<p>Please enter Email!</p>");  
    }
    else
    {  
    	try
    	{  
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment","root", "Apeksha@9");  
    		PreparedStatement ps=con.prepareStatement("select email from  userdata where email like '"+mail+"%'");  
    		ResultSet rs=ps.executeQuery();  
      		if(!rs.isBeforeFirst()) 
      		{      
     			out.println("<p>Enter Unique Mail Id!</p>");   
    		}
      		else
      		{  /* 
    			out.print("<table border='1' cellpadding='2' width='100%'>");  
    			out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Address</th><th>City</th><th>State</th><th>Country</th></tr>"); */  
    			while(rs.next())
    			{  
    				/* out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>"); */  
    				String str="This Mail Id Has Already Registered!! please try another one";
    				out.print(" <script> alert("+str+");	</script> ");
    			}  
    			/* out.print("</table>");  */ 
    		}  
    		con.close();  
    	}
    	catch(Exception e)
    	{
    		out.print(e);
    	}  
    }  
    %>  
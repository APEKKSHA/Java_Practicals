<%@ page import="java.sql.*"%>  
  
<%  
String s=request.getParameter("val");  
if(s==null || s.trim().equals("")){  
out.print("Please select Product ");  
}else{  
int id=Integer.parseInt(s);  
out.print(id);  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/QualityDeal","root", "Apeksha@9");  
PreparedStatement ps=con.prepareStatement("select price from addproduct where id=?");  
ps.setInt(1,id);  
ResultSet rs=ps.executeQuery();  
while(rs.next()){  
	%>
	 <div class="form-floating mb-3">
     <input type="text" class="form-control" name="pprice" id="floatingInput" value="<%= rs.getInt(4) %>"
         placeholder="name@example.com">
     <label for="floatingInput">Product Price</label>
 </div>  
 <% 
}  
con.close();  
}catch(Exception e){e.printStackTrace();}  
}  
%>  
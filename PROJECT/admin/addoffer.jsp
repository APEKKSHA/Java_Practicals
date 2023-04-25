<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <script>  
var request;  
function sendInfo()  
{  
var v=document.vinform.proname.value;  
var url="productprice.jsp?val="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('amit').innerHTML=val;  
}  
}  
  
</script>  
</head>

<body>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%-- <%@ include file="content.jsp" %> --%>
 <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
 <div class="col-sm-12 col-xl-6">
 			<form name="vinform" action="../AdminprocductController" method="post" enctype="multipart/form-data">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Add Product Offers</h6>
                           <div class="form-floating mb-3">
                                <select class="form-select" id="floatingSelect"
                                    aria-label="Floating label select example">
                                    <option value="-1">Product List</option>
                                    <% 
                                  /*  int pid=Integer.parseInt(request.getParameter("pid")); */
                                    	Connection cn1=new DBUtil().getConnectionData();
                                    PreparedStatement st1=cn1.prepareStatement("select * from addproduct");
                                    ResultSet rs1=st1.executeQuery();
                                    while(rs1.next())
                                    {
                                  			  
                                    %>
                                    
                                    <option value="<%= rs1.getInt(1) %>" name="proname" onkeyup="sendInfo()" ><%= rs1.getString(2)%></option>
                                     <%
                                    }
                                    cn1.close();
                                		%>
                                    <!-- <option value="2">Two</option>
                                    <option value="3">Three</option> -->
                                    
                                  
                                   <!-- /*  PreparedStatement st2=cn1.prepareStatement("select * from addproduct where pid=?");
                    				st2.setInt(1, pid);
                                    ResultSet rs2=st2.executeQuery();
                                    while(rs2.next())
                                    { */ -->
                                   
                                </select>
                                <label for="floatingSelect">Select Product</label>
                                 
                            </div>
                           <%--  <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="pprice" id="floatingInput" value="jbkjbh<%= rs2.getInt(4) %>"
                                    placeholder="name@example.com">
                                <label for="floatingInput">Product Price</label>
                            </div> --%>
                            
                             <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="ocode" id="floatingPassword"
                                    placeholder="Password">
                                <label for="floatingPassword">Offer Code</label>
                            </div>
                             <div class="form-floating mb-3">
                                <select class="form-select" id="floatingSelect"
                                    aria-label="Floating label select example">
                                    <option selected value="-1">Select Offer Percentage</option>
                                    <option value="5">5 %</option>
                                    <option value="10">10 %</option>
                                    <option value="15">15 %</option>
                                    <option value="20">20 %</option>
                                    <option value="25">25 %</option>
                                    <option value="30">30 %</option>
                                    <option value="40">40 %</option>
                                    <option value="50">50 %</option>
                                    <option value="60">60 %</option>
                                    <option value="70">70 %</option>
                                    <option value="80">80 %</option>
                                </select>
                                <label for="floatingSelect">Offer Percentage</label>
                            </div>
                            <!-- <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="disper" id="floatingPassword"
                                    placeholder="Password">
                                <label for="floatingPassword">Offer Percentage</label>
                            </div> -->
                            <!-- <div class="form-floating mb-3">
                                <select class="form-select" id="floatingSelect"
                                    aria-label="Floating label select example">
                                    <option selected>Open this select menu</option>
                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                </select>
                                <label for="floatingSelect">Works with selects</label>
                            </div> -->
                            <!-- <div class="form-floating">
                                <textarea class="form-control" name="pdetails" placeholder="Leave a comment here"
                                    id="floatingTextarea" style="height: 150px;"></textarea>
                                <label for="floatingTextarea">Product Details</label>
                            </div>
                             -->
                            
                               <!--  <div class="mb-3">
                                <br>
                                <label for="formFileSm" class="form-label">Product Photo</label>
                                
                                <input class="form-control form-control-sm" name="ppic" id="formFileSm" type="file">
                            </div> -->
                        <button type="submit" name="action" value="addoffer" class="btn btn-primary">Add Product Offer</button>
                    </div>
                    </form>
                    <span id="amit"></span>

</div>
    </div>
    </div>


 <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
	 			<!-- <div class="col-sm-12 col-xl-6"> -->
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Placed Orders List</h6>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col">Product ID</th>
                                        <th scope="col">Product Name</th>
                                        <th scope="col">Product Price</th>
                                        <th scope="col">Product Image</th>
                                      	<th scope="col">Edit Product</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    
                                    	Connection cn=new DBUtil().getConnectionData();
                                    PreparedStatement st=cn.prepareStatement("select * from productoffer");
                                    ResultSet rs=st.executeQuery();
                                    while(rs.next())
                                    {
                                    %>
                                    
                                    <tr>
                                        <th scope="row"><%= rs.getInt(1) %></th>
                                        <td><%= rs.getString(2) %></td>
                                        <td> Rs. <%= rs.getInt(4) %></td>
                                        <td><img class="rounded-circle" src="../productpic/<%= rs.getString(5) %>" alt="" style="width: 40px; height: 40px;"></td>
                                   		<td><a href="editproductdetail.jsp?pid=<%= rs.getInt(1)%>" ><button type="submit" name="action" value="viewproductdetails" class="btn btn-primary">Update</button></a> <button type="submit" name="action" value="deletedetail" class="btn btn-primary">Delete</button></td>
                                   		
                                    
                                    
                                    </tr>
                                    <% 
                                    }
                                    cn.close();
                                    
                                    %>
                                    
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
				 </div>
 <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    

<%@ include file="footer.jsp" %>
    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>
</html>
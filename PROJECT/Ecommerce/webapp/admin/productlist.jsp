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
</head>

<body>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>


<div class="container-fluid pt-4 px-4">
                <div class="row g-4">
	 			<!-- <div class="col-sm-12 col-xl-6"> -->
                        <div class="bg-light rounded h-100 p-4">
                        <form action="AdminprocductController" method="post">
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
                                    PreparedStatement st=cn.prepareStatement("select * from addproduct");
                                    ResultSet rs=st.executeQuery();
                                    while(rs.next())
                                    {
                                    %>
                                    
                                    <tr>
                                        <th scope="row"><%= rs.getInt(1) %></th>
                                        <td><%= rs.getString(2) %></td>
                                        <td> Rs. <%= rs.getInt(4) %></td>
                                        <td><img class="rounded-circle" src="../productpic/<%= rs.getString(5) %>" alt="" style="width: 40px; height: 40px;"></td>
                                   		<td><a href="editproductdetail.jsp?pid=<%= rs.getInt(1)%>" ><button type="submit" name="action" value="viewproductdetails" class="btn btn-primary">Update</button></a> 
                                   		<button type="submit" name="action" value="deletedetail" class="btn btn-primary">Delete</button></td>
                                   		
                                    
                                    
                                    </tr>
                                    <% 
                                    }
                                    cn.close();
                                    
                                    %>
                                    
                                    
                                </tbody>
                            </table>
                            </form>
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
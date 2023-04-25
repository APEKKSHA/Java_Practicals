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



                                    <%-- <%
                                    
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
                                   		<td><a href="productdetail.jsp?pid=<%= rs.getInt(1)%>" ><button type="submit" name="action" value="viewproductdetails" class="btn btn-primary">Edit</button></a></td>
                                    
                                    
                                    </tr>
                                    <% 
                                    }
                                    cn.close();
                                    
                                    %> 
                                    --%>
                                    <div class="container-fluid pt-4 px-4">
							                <div class="row g-4">
							 <div class="col-sm-12 col-xl-6">
 			<form action="../AdminprocductController" method="post" enctype="multipart/form-data">
 			<%
 									int pid=Integer.parseInt(request.getParameter("pid"));
 			
                                  	Connection cn=new DBUtil().getConnectionData();
                                    PreparedStatement st=cn.prepareStatement("select * from addproduct where pid=?");
                                    st.setInt(1, pid);
                                    ResultSet rs=st.executeQuery();
                                    while(rs.next())
                                    {
                                    %>
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Edit Product Details</h6>
                             <div class="form-floating mb-3">
                                <input type="hidden" class="form-control" name="pname" id="floatingInput"
                                    placeholder="name@example.com" value="<%=rs.getInt(1) %>">
                                <label for="floatingInput">Product Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="pname" id="floatingInput"
                                    placeholder="name@example.com" value="<%=rs.getString(2) %>">
                                <label for="floatingInput">Product Name</label>
                            </div>
                             <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="pprice" id="floatingPassword"
                                    placeholder="Password" value="<%=rs.getString(4) %>">
                                <label for="floatingPassword">Product Price</label>
                            </div>
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
                            <div class="form-floating">
                                <textarea value="<%=rs.getString(3) %>" class="form-control" name="pdetails" placeholder="Leave a comment here"
                                     style="height: 150px;"><%=rs.getString(3) %></textarea>
                                <label for="floatingTextarea">Product Details</label>
                            </div>
                            
                            
                                <div class="mb-3">
                                <br>
                                <label for="formFileSm" class="form-label">Product Photo</label>
                                
                                <input class="form-control form-control-sm" name="ppic" id="formFileSm" type="file" value="<%=rs.getString(5) %>">
                            </div>
                        <button type="submit" name="action" value="updatedetail" class="btn btn-primary">Update</button>
                    </div>
                     <% 
                                    }
                                    cn.close();
                                    
                                    %> 
                    </form>

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
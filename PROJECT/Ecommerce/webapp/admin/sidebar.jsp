<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="index.jsp" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"></i>ADMIN</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">Jhon Doe</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="index.jsp" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Orders</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="placedorder.jsp" class="dropdown-item"><i class="fa fa-table me-2"></i>Placed Orders</a>
                            
                           <!--  <a href="element.html" class="dropdown-item">Other Elements</a> -->
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-th me-2"></i>Products</a>
                   <div class="dropdown-menu bg-transparent border-0">
                    <a href="addproduct.jsp" class="dropdown-item"><i class="fa fa-table me-2"></i>Add Product</a>
                    <a href="productlist.jsp" class="dropdown-item"><i class="fa fa-table me-2"></i>Product List</a>
                     </div>
                     </div>
                    <!-- <a href="chart.html" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>Charts</a> -->
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Offers/Feedback</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="addoffer.jsp" class="dropdown-item"><i class="fa fa-table me-2"></i>Add Offers</a>
                            <a href="feedback.jsp" class="dropdown-item"><i class="fa fa-table me-2"></i>Feedback and Reviews</a>
                            <!-- <a href="signup.html" class="dropdown-item">Sign Up</a>
                            <a href="404.html" class="dropdown-item">404 Error</a> -->
                            <!-- <a href="blank.html" class="dropdown-item">Blank Page</a> -->
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 20.09.2020
  Time: 02:13
  To change this template use File | Settings | File Templates.
--%>
<%--<% response.sendRedirect("user");--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <div class="key-text" >
                <h1 class="text-center">Welcome to our travel service</h1>
            </div>
            <div class="container">
                <h3 >All possible actions :</h3>
                <div class="well" >
                    <a href="${pageContext.request.contextPath}/user/findHotel">Find hotel in our system and book available apartments</a> </div>
                <div class="well" >
                    <a href="${pageContext.request.contextPath}/manager/addHotel">Add new hotel</a>
                </div>
                <div class="well">
                    <a href="${pageContext.request.contextPath}/manager/addApartments">Add apartments to existing hotel</a>
                </div>
                <div class="well">
                    <a href="${pageContext.request.contextPath}/manager/getAllReservations">See all users and their reservations</a>
                </div>
                <div class="alert alert-warning alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Warning!</strong> Manager access level is required for any modification with hotel or apartments.
                </div>
            </div>
        </div>
    </div>

</body>
</html>

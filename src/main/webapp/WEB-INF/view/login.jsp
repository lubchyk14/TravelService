
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 20.09.2020
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<%--    have to use form springframework to enable csrf properties--%>
<form:form  action="${pageContext.request.contextPath}/authenticateUser" method="post">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger col-xs-offset-1 col-xs-10">
            Invalid username and password.
        </div>
    </c:if>

    <c:if test="${param.logout !=null}">
        <div class="alert alert-success col-xs-offset-1 col-xs-10">
            You have been logged out
        </div>
    </c:if>
    <input type="text" name="username" placeholder="Type user's name" >
    <input type="password" name="password" placeholder="Type password">
    <button type="submit">Login</button>
</form:form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 20.09.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Access Denied</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
        <secutiry:authentication
                property="principal.authorities" var="roleRaw"/>
        <secutiry:authentication
                property="principal.username" var="userName"/>

        <div class="container">
            <div class="alert alert-danger">
                <strong>Access denied for ${roleRaw} </strong>
            </div>
        </div>
        <div class="container">
            <div class="btn-group">
                <a href="${pageContext.request.contextPath}/" class="btn btn-success" role="button">Go to main page </a>
                <form:form action="${pageContext.request.contextPath}/logout">
                    <input type="submit" class="btn btn-warning" value="Log out"/>
                </form:form>
            </div>
        </div>
</body>
</html>

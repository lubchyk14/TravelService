<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 20.09.2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>Find hotel</h2>
            <c:if test="${hotelNotFound!=null}">
                <div class="alert alert-danger">
                    <strong>WARNING!</strong>${hotelNotFound}
                </div>
            </c:if>
            <form:form action="${pageContext.request.contextPath}/user/findHotel" method="post" >
                <div class="form-group">
                    <label for="hotel">Hotel name :</label>
                    <input type="text" id="hotel" name="hotelName" placeholder="Type hotel's name" required>
                </div>
                <button type="submit" class="btn btn-info" >
                    <span class="glyphicon glyphicon-search"></span>Find
                </button>
            </form:form>
    </div>
</body>
</html>

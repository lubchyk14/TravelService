<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 26.09.2020
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add apartments</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <div class="alert alert-info">
                Here you can add new apartments to already tracked in system hotel
            </div>
            <form:form action="${pageContext.request.contextPath}/manager/addApartments"
                       method="post" cssClass="form-inline" modelAttribute="apartments">
                <div class="form-group">
                    <label for="hotel">Hotel : </label>
                    <select id="hotel" class="form-control" required name="hotelId">
                        <c:forEach items="${hotels}"  var="hotelOne">
                            <option value="${hotelOne.id}">${hotelOne.hotelName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rooms">Number of bedrooms</label>
                    <form:input  path="numberOfRooms" cssClass="form-control" id="rooms"/>
                </div>

                <div class="form-group">
                    <label for="apartmentsClass">Apartments type</label>
                    <form:input path="roomClass" cssClass="form-control" id="apartmentsClass"/>
                </div>
                <br>
                <form:errors path="numberOfRooms"></form:errors>
                <button type="submit" class="btn btn-success">Add apartments</button>
            </form:form>
        </div>
    </div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 20.09.2020
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Add new hotel</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
        <div class="jumbotron">
            <div class="alert alert-info">
                Add <strong>NEW HOTEL</strong> to the system
            </div>

            <form:form class="form-inline" action="${pageContext.request.contextPath}/manager/addHotel" method="post"
                modelAttribute="hotel">
                <div class="form-group">
                    <label for="country" >Country</label>
                    <select required class="form-control" name="country" id="country">
                        <c:forEach items="${countries}" var="countryOne">
                            <option value="${countryOne.id}">${countryOne.countryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="hotel">Hotel name : </label>
                    <form:input  id="hotel" path="hotelName" />
                </div>
                <button type="submit" class="btn btn-success">Save hotel</button>
            </form:form>
        </div>
    </div>
<%--    <p>In this page you can add hotel to system</p>--%>

<%--    <form:form action="${pageContext.request.contextPath}/manager/addHotel" method="post"--%>
<%--                    modelAttribute="hotel">--%>
<%--        <select name="country">--%>
<%--            <c:forEach items="${countries}" var="countryOne">--%>
<%--                <option value="${countryOne.id}">${countryOne.countryName}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--        <tr>--%>
<%--            <td><p>Name of the hotel</p></td>--%>
<%--            <td><form:input path="hotelName"/></td>--%>
<%--        </tr>--%>
<%--        <button type="submit">Add Hotel</button>--%>
<%--    </form:form>--%>
</body>
</html>

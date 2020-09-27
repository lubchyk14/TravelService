<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 26.09.2020
  Time: 00:00
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
</head>
<body>
    <p >${hotel.hotelName}</p>
    <p>Available apartments : </p>
    <c:forEach var="apartments" items="${hotel.apartmentsList}">
        <p>${apartments.roomClass}</p>
        <p>${apartments.numberOfRooms}</p>
    </c:forEach>
</body>
</html>

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
    <table>
        <tr>
            <th><p>Apartments class </p></th>
            <th><p>Number of rooms in apartments</p></th>
            <c:if test="${reservation!=null}">
                <th><p>Available</p></th>
            </c:if>
        </tr>
        <c:forEach var="apartments" items="${hotel.apartmentsList}">
            <tr>
                <td><p>${apartments.roomClass}</p></td>
                <td><p>${apartments.numberOfRooms}</p></td>
                <c:if test="${reservation!=null}">
                    <c:choose>
                        <c:when test="${invalid.contains(apartments.id)}">
                            <td><p>Apartments are reserved</p></td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <form:form modelAttribute="reservation" action="${pageContext.request.contextPath}/user/bookApartments/${apartments.id}"
                                      method="get">
                                    <button type="submit" >Book apartments</button>
                                </form:form>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </c:if>

            </tr>
        </c:forEach>
    </table>
    <form:form action="${pageContext.request.contextPath}/user/findApartments/${hotel.id}"
                method="post">
        <label for="trip">
            <input type="date" id="trip" min="2020-09-28" name="startDate" required placeholder="Type arriving date">
        </label>
        <label for="trip2">
            <input type="date" id="trip2"  name="endDate" required placeholder="Type leaving date">
        </label>
        <secutiry:authentication
                property="principal.username" var="userName"/>
        <input type="hidden" name="userName" value="${userName}">
        <input type="hidden" name="hotelName" value="${hotel.hotelName}">
        <button type="submit">Check available rooms</button>

    </form:form>
<%--    <form:form action="" method="get"--%>
</body>
</html>

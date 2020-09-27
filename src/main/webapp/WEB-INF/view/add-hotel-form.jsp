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
    <title>Title</title>
</head>
<body>
    <p>In this page you can add hotel to system</p>

    <form:form action="${pageContext.request.contextPath}/manager/addHotel" method="post"
                    modelAttribute="hotel">
        <select name="country">
            <c:forEach items="${countries}" var="countryOne">
                <option value="${countryOne.id}">${countryOne.countryName}</option>
            </c:forEach>
        </select>
        <tr>
            <td><p>Name of the hotel</p></td>
            <td><form:input path="hotelName"/></td>
        </tr>
        <button type="submit">Add Hotel</button>
    </form:form>
</body>
</html>

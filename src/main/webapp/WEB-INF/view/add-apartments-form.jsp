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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/manager/addApartments" method="post"
                modelAttribute="apartments">
        <select name="hotel">
            <c:forEach items="${hotels}" var="hotelOne">
                <option value="${hotelOne.id}">${hotelOne.hotelName}</option>
            </c:forEach>
        </select>
        <tr>
            <td><label>Number of rooms</label></td>
            <td><form:input path="numberOfRooms" /></td>
        </tr>
        <tr>
            <td><label>Class of the room</label></td>
            <td><form:input path="roomClass"/></td>
        </tr>
        <button type="submit">Add apartments</button>
    </form:form>

</body>
</html>

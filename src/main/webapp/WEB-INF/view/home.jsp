<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 20.09.2020
  Time: 03:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/logout">
        <button type="submit">Log out</button>
    </form:form>

    <div >
        <secutiry:authorize access="hasRole('MANAGER')">
            <a  href="${pageContext.request.contextPath}/manager/addHotel">Add Hotel</a>
        </secutiry:authorize>

    </div>

</body>
</html>

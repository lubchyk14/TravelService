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
</head>
<body>
    <div>
        <secutiry:authentication
                property="principal.authorities" var="roleRaw"/>
        <secutiry:authentication
                property="principal.username" var="userName"/>

        <p>Requested page has restricted access for Roles ${roleRaw} and name: ${userName} </p>
<%--        <c:param name="userRole" value="${roleRaw}">F</c:param>--%>
<%--        show this part for users with role - MANAGER --%>
        <secutiry:authorize access="hasRole('MANAGER')" >
            <p>
                <a href="${pageContext.request.contextPath}/manager/addHotel" >Add hotel to system</a>
                <a href="${pageContext.request.contextPath}/manager/addApartments"  >Add apartments to system</a>
            </p>
        </secutiry:authorize>
    </div>
</body>
</html>

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
</head>
<body>
    <p>In this page can find hotel</p>
    <br>
    <p>${hotelNotFound}</p>
    <br>
    <form:form action="${pageContext.request.contextPath}/user/findHotel" method="post">
        <input type="text" name="hotelName" placeholder="Type hotel's name here"/>
        <button type="submit">Find hotel</button>
    </form:form>
</body>
</html>

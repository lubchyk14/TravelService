<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 25.09.2020
  Time: 02:56
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
    <form action="" method="post">
        <select name="country">
            <c:forEach items="${countries}" var="country">
                <option value="${country.countryName}">${country.countryName}</option>
            </c:forEach>

        </select>
        <button type="submit">Submit</button>
    </form>
</body>
</html>

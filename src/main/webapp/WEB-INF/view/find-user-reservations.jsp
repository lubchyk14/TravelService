<%--
  Created by IntelliJ IDEA.
  User: lubchyk
  Date: 29.09.2020
  Time: 00:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>View all reservations</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>List of reservations : </h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>
                        User's name
                    </th>
                    <th>
                        Reservation detail
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach  var="record" items="${reservationsMap}">
                    <tr>
                        <td>${record.key}</td>

                        <td>
                            <div class="list-group">
                                <c:forEach  items="${record.value}" var="reservation" >
                                    <a href="#" class="list-group-item">
                                        Reservation : Arriving date : ${reservation.startDate} ,
                                        Leaving date : ${reservation.endDate},
                                        Apartments class : ${reservation.apartments.roomClass},
                                        Number of rooms : ${reservation.apartments.numberOfRooms},
                                        Hotel : ${reservation.apartments.hotel.hotelName}
                                        <br>
                                    </a>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/" class="btn btn-success" role="button">Go to main page </a>
    </div>
</body>
</html>

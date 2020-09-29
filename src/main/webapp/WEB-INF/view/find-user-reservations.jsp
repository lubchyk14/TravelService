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
</head>
<body>
    <table>
        <tr>
            <th>
                <h3>User name</h3>
            </th>
            <th>
                <h3>Reservations</h3>
            </th>
        </tr>
        <c:forEach var="record" items="${reservationsList}">
            <tr>
                <td>
                        ${record.key}
                </td>
                <td>
                    <ul>
                        <c:forEach  items="${record.value}" var="reservation" >
                            <li>
                                    Reservation : arriving date : ${reservation.startDate} ,
                                leaving date : ${reservation.endDate},
                                apartments class : ${reservation.apartments.roomClass},
                                number of rooms : ${reservation.apartments.numberOfRooms},
                                hotel name : ${reservation.apartments.hotel.hotelName}
                                <br>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

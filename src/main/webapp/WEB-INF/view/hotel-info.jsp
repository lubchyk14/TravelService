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
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function getToday(){
            const today = new Date();
            return today;
        }
    </script>
    <style>
        td,th{
            text-align: center;
        }
        .form-inline{
            display: flex;
            flex-flow: row wrap;
            align-items: center;
        }
        .form-inline label {
            margin: 5px 10px 5px 0;
        }
        .form-inline input {
            vertical-align: middle;
            margin: 5px 10px 5px 0;
            padding: 10px;
            background-color: #fff;
            border: 1px solid #ddd;
        }.form-inline button:hover {
             background-color: royalblue;
         }
    </style>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <div class="key-text">
                <h2>Information and apartments list for <strong>${hotel.hotelName}</strong>  hotel</h2>
            </div>
            <table class="table table-hover" >
                <thead>
                    <tr class="success">
                        <th >Class of the apartments</th>
                        <th>Number of bedrooms</th>
                        <c:if test="${reservation!=null}">
                            <th>Availability on period ${reservation.startDate} - ${reservation.endDate}</th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="apartments" items="${hotel.apartmentsList}">
                        <tr>
                            <td>${apartments.roomClass}</td>
                            <td>${apartments.numberOfRooms}</td>
                            <c:if test="${reservation!=null}">
                                <c:choose>
                                    <c:when test="${invalid.contains(apartments.id)}">
                                        <td class="danger">Apartments not available</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="success">
                                            <form:form modelAttribute="reservation"
                                                       action="${pageContext.request.contextPath}/user/bookApartments/${apartments.id}"
                                                       method="get">
                                                <input type="text" name="startDate" value="${reservation.startDate}" hidden>
                                                <input type="text" name="endDate" value="${reservation.endDate}" hidden>
                                                <input type="text" name="userName" value="${reservation.userName}" hidden>
                                                <button onclick="return confirm('Confirm booking ?')" type="submit"  >Book apartments</button>
                                            </form:form>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form:form cssClass="form-inline" action="${pageContext.request.contextPath}/user/findApartments/${hotel.id}"
                    method="post">
                <label for="startTrip">From : </label>
                <input type="date" id="startTrip" name="startDate" min="getToday()" required>
                <label for="endDate">To : </label>
                <input type="date" id="endDate" name="endDate" required>
                <secutiry:authentication
                        property="principal.username" var="userName"/>
                <input type="hidden" name="userName" value="${userName}">
                <input type="hidden" name="hotelName" value="${hotel.hotelName}">
                <button type="submit" class="btn btn-success">Book apartments</button>
            </form:form>
        </div>
    </div>
</body>
</html>

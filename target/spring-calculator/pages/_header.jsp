<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Header</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<c:if test="${sessionScope.isGuest}">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/reg">Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/auth">Authorization</a>
        </li>
    </ul>
</c:if>
<c:if test="${sessionScope.isUser}">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/calc">Calculator</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/calc/history">History</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/out">LogOut</a>
        </li>
    </ul>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<h1>History of operations: </h1>
<c:forEach items="${list}" var="operation">
    <div class="col-auto">
        <li>${operation}</li>
    </div>
</c:forEach>
</body>
</html>

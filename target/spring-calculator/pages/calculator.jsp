<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="card" style="width: 18rem;">
    <div class="card-header">
        Calculator functions:
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">"sum": summing. </li>
        <li class="list-group-item">"dif": difference.</li>
        <li class="list-group-item">"mul": multiplication.</li>
        <li class="list-group-item">"div": division.</li>
    </ul>
</div>
<form class="row g-3 needs-validation" novalidate action="/calc" method="post">
    <div class="col-md-3" style="width: 15%">
        <label class="form-label">Number 1: </label>
        <input type="number" class="form-control" name="num1">
        <br>
        <p style="color: red">${num1}</p>
        <br>
    </div>
    <div class="col-md-3" style="width: 15%">
        <label class="form-label" >Number 2: </label>
        <input type="number" class="form-control" name="num2">
        <br>
        <p style="color: red">${num2}</p>
        <br>
    </div>
    <div class="col-md-3" style="width: 15%">
        <label class="form-label" >Operation: </label>
        <input type="text" class="form-control" name="operator">
        <br>
        <p style="color: red">${operator}</p>
        <br>
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Calculate</button>
    </div>
    <p class="text-start">Result: ${res}</p>
</form>
</body>
</html>
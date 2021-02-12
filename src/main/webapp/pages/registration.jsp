<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align: -webkit-center">
    <form novalidate action="/user/reg" method="post" >
        <div class="mb-3" style="width: 25%">
            <label class="form-label">Name: </label>
            <input type="text" class="form-control" name="name">
            <br>
            <p style="color: red">${name}</p>
            <br>
        </div>
        <div class="mb-3" style="width: 25%">
            <label class="form-label" >Login: </label>
            <input type="text" class="form-control" name="login">
            <br>
            <p style="color: red">${login}</p>
            <br>
        </div>
        <div class="mb-3" style="width: 25%">
            <label class="form-label" >Password: </label>
            <input type="password" class="form-control" name="password">
            <br>
            <p style="color: red">${password}</p>
            <br>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Register</button>
        </div>
        <label style="color: red">${answer}</label>
    </form>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorisation</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align: -webkit-center">
    <form  novalidate action="/user/auth" method="post">
        <div class="md-3" style="width: 25%">
            <label class="form-label">Login: </label>
            <input type="text" class="form-control" name="login">
            <p style="color: red">${login}</p>
        </div>
        <div class="md-3" style="width: 25%">
            <label class="form-label">Password: </label>
            <input type="password" class="form-control" name="password">
            <p style="color: red">${password}</p>
        </div>
        <br>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Sing in!</button>
        </div>
        <label style="color: red">${answer}</label>
    </form>
</div>
</body>
</html>
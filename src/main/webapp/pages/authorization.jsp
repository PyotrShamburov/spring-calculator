<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authorisation</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align: -webkit-center">
    <sf:form modelAttribute="newUserDTO" action="/user/auth" method="post">
        <label class="form-label">Login: </label>
        <sf:input path="login"/>
        <br>
        <sf:errors path="login" cssStyle="color: red"/>
        <br>
        <label class="form-label">Password: </label>
        <sf:input path="password" cssClass="password-field"/>
        <br>
        <sf:errors path="password" cssStyle="color: red"/>
        <br>
        <sf:button>Sing in!</sf:button>
    </sf:form>
    <label style="color: red">${answer}</label>
</div>
</body>
</html>
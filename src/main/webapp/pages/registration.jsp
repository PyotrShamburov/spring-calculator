<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align: -webkit-center">
    <sf:form modelAttribute="newUser" action="/user/reg" method="post">
        <label class="form-label">Name: </label>
        <br>
        <sf:input path="name"/>
        <br>
        <sf:errors path="name" cssStyle="color: red"/>
        <br>

        <label class="form-label" >Login: </label>
        <br>
        <sf:input path="login" />
        <br>
        <sf:errors path="login" cssStyle="color: red"/>
        <br>

        <label class="form-label" >Password: </label>
        <br>
        <sf:input path="password" cssClass="password-field"/>
        <br>
        <sf:errors path="password" cssStyle="color: red"/>
        <br>
        <sf:button>Register!</sf:button>
    </sf:form>
    <label style="color: red">${answer}</label>
</div>
</body>
</html>
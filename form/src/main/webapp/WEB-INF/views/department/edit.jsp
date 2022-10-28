<%--
  Created by IntelliJ IDEA.
  User: Ahnaf Ahmed
  Date: 10/28/2022
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Department</title>
</head>
<body>

<h1>Edit Department</h1>

<form:form action="update" modelAttribute="department">

    <label for="id">Id:</label>
    <form:input path="id" id="for" readonly="true"/>
    <form:errors path="id"/>

    <label for="department_name">Name:</label>
    <form:input path="name" id="department_name"/>
    <form:errors path="name"/>

    <br><br>

    <input type="submit">

</form:form>

</body>
</html>

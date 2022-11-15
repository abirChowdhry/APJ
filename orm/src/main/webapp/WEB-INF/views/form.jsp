<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

<h1><center>Employee Form</center></h1>

<form:form action="submit" modelAttribute="employee">
    <label for="firstname">First Name:</label>
    <form:input path="firstname" id="firstname"/>
    <form:errors path="firstname"/>

    <br><br>

    <label for="lastname">Last Name:</label>
    <form:input path="lastname" id="lastname"/>
    <form:errors path="lastname"/>

    <br><br>

    <input type="submit">

</form:form>

</body>
</html>

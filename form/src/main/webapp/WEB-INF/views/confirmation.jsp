
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Confiramtion</title>
</head>
<body>

<h1>Confirmation</h1>

<c:out value="${message}" />

<hr>

<p>Welcome, ${user.email} ${user.password}</p>

</body>
</html>

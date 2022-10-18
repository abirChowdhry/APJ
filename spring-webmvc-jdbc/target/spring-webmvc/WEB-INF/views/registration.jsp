<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 10/13/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form method="post" action="data/create">
        <label for="num1">Number 1:</label>
        <input type="number" name="num1" id="num1"/>

        <br><br>

        <label for="op">Choose a Operation:</label>

        <select name="op" id="op">
            <option value="add">Addition</option>
            <option value="sub">Subtraction</option>
            <option value="multiply">Multiplication</option>
            <option value="divide">Division</option>
        </select>

        <br><br>

        <label for="num2">Number 2:</label>
        <input type="number" name="num2" id="num2"/>

        <br><br>

        <input type="submit" value="Register">
    </form>

</body>
</html>

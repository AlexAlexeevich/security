<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 24.06.2020
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>UserHome</title>
</head>
<body>
<c:set var="user" value="${user}"/>

<h1>Hello ${user.name}</h1>
<table cellspacing="0" border="2">
    <tr>
        <td>Айди</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Пароль</td>
        <td>${user.password}</td>
    </tr>
</table>
<br>
<a href="/logout">Logout</a>

<%--<form th:action="@{/logout}" method="post">--%>
<%--    <input type="submit" value="Sign Out"/>--%>
<%--</form>--%>

</body>
</html>

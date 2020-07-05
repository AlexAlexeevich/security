<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10.06.2020
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Admin</title>
</head>
<body>
Общее количество юзеров в таблице -
<c:out value="${list.size()}" default="guest"/>
<table cellspacing="1" border="5" cellpadding="7">
    <tr>
        <th><h3>Id</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Password</h3></th>
        <th><h3>Role</h3></th>
        <th colspan="2"><h3>Action with user</h3></th>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><c:forEach items="${user.roles}" var="role">${role.role}; </c:forEach></td>
            <td>
                <a href="<c:url value='/admin/deleteUser/${user.id}'/>">Delete</a>
            </td>
            <td>
                <a href="<c:url value='/admin/updateUser/${user.id}'/>">Update</a>
            </td>

        </tr>
    </c:forEach>
</table>
<br>
<table cellspacing="10">
    <tr>
        <td><a href="/admin/addUser">Add Users</a></td>
    </tr>
</table>
<br>
<a href="/user">Home</a>
<br>
<a href="/logout">Logout</a>

</body>
</html>

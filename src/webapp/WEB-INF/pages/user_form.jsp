<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 12.06.2020
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>User-form</h1>

<form action="/admin/save" method="post">
    <table cellspacing="0" border="1">
        <tr>
            <td>ID:</td>
            <td>
                <c:if test="${user != null}">
                    <input type="text" name="id" value="<c:out value='${user.id}' />"/>
                </c:if>
                <c:if test="${user == null}">
                    <input type="hidden" name="id" value='${user.id}'>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>User Name:</td>
            <td><c:if test="${user != null}">
                <input type="text" name="name" value="<c:out value='${user.name}' />"/>
            </c:if>
                <c:if test="${user == null}">
                    <input type="text" name="name">
                </c:if>
            </td>
        </tr>
        <tr>
            <td>User Password:</td>
            <td><c:if test="${user != null}">
                <input type="text" name="password" value="<c:out value='${user.password}' />"/>
            </c:if>
                <c:if test="${user == null}">
                    <input type="text" name="password">
                </c:if></td>
        </tr>
        <tr>
            <td>User Role:</td>
            <td>
                <c:forEach var="role" items="${listOfRoles}">
                    <label><input type="checkbox" value="${role.role}" name="roles">${role.role}</label>
                </c:forEach>
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Add User"/>
</form>

</body>
</html>

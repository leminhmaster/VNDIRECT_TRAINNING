<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="user_db" driver="org.apache.derby.jdbc.EmbeddedDriver" url="jdbc:derby:C://Java//servlet-sample//user_db"/>
<sql:query dataSource="${user_db}" var="result">
    select * from hanoi_user
</sql:query>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.username}</td>
            <td><c:out value="${row.password}"/></td>
            <td>${row.email}</td>
            <td><a href="save?action=del&username=${row.username}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<div><a href="register.html">Add new</a></div>
</body>
</html>

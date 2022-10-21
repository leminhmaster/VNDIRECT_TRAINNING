<%--
  Created by IntelliJ IDEA.
  User: minh0
  Date: 10/10/2022
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>User</h1>
        <p>Username: ${user.username}</p>
        <p>Password: ${user.password}</p>
        <p>Email: ${user.email}</p>
        <p>Age: ${user.age}</p>
        <p>Group Id: ${user.group.name}</p>

    </tiles:putAttribute>
</tiles:insertDefinition>
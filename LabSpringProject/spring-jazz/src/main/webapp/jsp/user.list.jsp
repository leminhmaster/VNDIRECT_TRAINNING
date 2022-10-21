<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>User list</h1>
        <table style="width: 100%">
            <tr>
                <td>Username</td>
                <td>Password</td>
                <td>Email</td>
                <td>Age</td>
                <td>Group</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${users}" var="item" varStatus="loop">
                <tr>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.email}</td>
                    <td>${item.age}</td>
                    <td>${item.groupId}</td>
                    <td>
                        <a href="">update</a>
                        <a href="/account/delete/${item.username}">delete</a>
                        <a href="/account/detail/${item.username}">detail</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>Average of age is ${average}</h3>
    </tiles:putAttribute>
</tiles:insertDefinition>

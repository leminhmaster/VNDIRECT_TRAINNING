<%--
  Created by IntelliJ IDEA.
  User: minh0
  Date: 10/10/2022
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="template">
  <tiles:putAttribute name="body">
    <h1>Group list</h1>
    <table style="width: 100%;">
      <tr>
        <td>Name</td>
        <td>#</td>
      </tr>
      <tr>
        <td colspan="2">
          <form method="get" action="../group/list">
            <input type="text" name="q" value="${q}">
          </form>
        </td>
      </tr>
      <c:forEach items="${groups}" var="item" varStatus="loop">
        <tr>
          <td>
            <a href="/account/list?groupId=${item.id}">${item.name}</a>
            <ul>
              <c:forEach items="${item.users}" var="user" varStatus="loop">
                <li>${user.username} - ${user.age}</li>
              </c:forEach>
            </ul>
          </td>
          <td>
            <a href="../group/delete/${item.id}">delete</a>
            <a href="../group/update?id=${item.id}">update</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </tiles:putAttribute>
</tiles:insertDefinition>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>EL example</title>
</head>
<body>
<h1>EL Example</h1>

<c:forEach var="i" begin="1" end="8" step="1">

  ${i}:
  <c:choose>
      <c:when test="${i%2==0}">hello ${i} !<br> </c:when>
      <c:otherwise> not found ! <br> </c:otherwise>
  </c:choose>
</c:forEach>

</body>
</html>

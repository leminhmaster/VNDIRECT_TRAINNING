<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>EL Example</h1>
<c:if test="${param.person != null}">
    <c:out value="hello ${param.person}" escapeXml="true"/>
</c:if>
<h1>EL-implicit</h1>
<c:forEach var="reqHeader" items="${header}">
    ${reqHeader.key} = ${reqHeader.value}
    request value - length = ${fn:length(reqHeader.value)}
</c:forEach>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
<%
    String agent = request.getHeader("User-Agent");
%>
<% if(agent.indexOf("Firefox") > -1){ %>
    <jsp:forward page="path.jsp"/>
<% } else { %>
    <jsp:forward page="include.jsp"/>
<% } %>
</body>
</html>

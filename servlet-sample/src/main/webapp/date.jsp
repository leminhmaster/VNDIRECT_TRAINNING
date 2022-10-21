<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% response.setHeader("Refresh", "6"); %>
<h1>Today's date is <%= new java.util.Date() %>
</h1>
<h1>Session ID: <%= session.getId() %>
</h1>
<h1>Today's date1 is <%= new Date() %>
</h1>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Welocome to our Website</title>
</head>
<body>
<marquee>
    <font size="3" color="#dc143c">Hello word!! <%= request.getParameter("j_username") %></font>
</marquee>
<font color="blue">Host name : <%= request.getRemoteHost() %></font>
<br>
<font color="blue">Session id: <%= session.getId()  %></font>
<br>
<font color="blue">Session id: ${param["j_username"]}</font>
<br>
<h1>${say}</h1>
</body>
</html>

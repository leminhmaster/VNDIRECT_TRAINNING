<%--
  Created by IntelliJ IDEA.
  User: minh0
  Date: 9/22/2022
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
<h1>Display sum</h1>
<%
    int sum = 0;
    for (int i = 0; i < 25; i++) {
        sum += i;
    }
    //out.println("Sum of number id " + sum);
%>
<h2>Sum of number is <% out.println(sum); %></h2>
The other way to display sum:
<h2>Sum of number is <%= sum %></h2>
</body>
</html>

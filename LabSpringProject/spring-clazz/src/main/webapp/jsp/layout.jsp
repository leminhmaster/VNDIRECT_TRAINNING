<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Boot Application</title>
</head>
<body>
	<table border="1" cellpadding="2" cellspacing="2" align="center">
		<tr>
			<td height="30" >Welcome to Java Spring Clazz
			</td>
		</tr>
		<tr>
			<td>
				<a href="/">Trang chu</a>
				<sec:authorize access="!hasAnyRole('USER')">
					<a href="/login" style="margin-left: 30px">Login</a>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('USER')">
					<a href="/nguoi-dung" style="margin-left: 30px">Person</a>
					<a href="/logout" style="margin-left: 30px">Logout</a>
				</sec:authorize>
			</td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="body" /></td>
		</tr>
		
	</table>
</body>
</html>
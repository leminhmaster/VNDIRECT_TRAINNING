<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Add Group</h1>	
		<form:form method="post" action="/group/save">
			<p>
				<form:input path="id" name="id" type="hidden"/>
				<form:input type="text" path="name" name="name"/>
			</p>
			<p class="submit">
				<input type="submit" value="Add" name="add">
			</p>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
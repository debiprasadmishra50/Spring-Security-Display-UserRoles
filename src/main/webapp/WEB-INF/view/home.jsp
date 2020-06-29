<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Demo App</title>
</head>
<body>
	<h1>Spring Security Display User Roles</h1> <hr><br>
	
	<hr>
	
	<!-- display User Name and roles -->
	<p>
		User : <security:authentication property="principal.username" /> <br><br>
		Role(s) : <security:authentication property="principal.authorities"/> <br>
	</p>
	
	<hr><br>	
	
	
	
	<!-- Add the Logout Section -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>
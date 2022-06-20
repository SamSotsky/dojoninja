<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Swag Muney Ghang Ghang</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Create New Ninja</h1>
	<form:form action="/ninja/create" method="post" modelAttribute="ninja">
			<div>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo}">
							<c:out value="${dojo.getName()}"/>
						</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="dojo"/>
			</div>
			<div>
				<form:label path="first_name">First Name</form:label>
				<form:input path="first_name"/>
				<form:errors path="first_name"/>
			</div>
			<div>
				<form:label path="last_name">Last Name</form:label>
				<form:input path="last_name"/>
				<form:errors path="last_name"/>
			</div>
			<div>
				<form:label path="age">Age</form:label>
				<form:input path="age" type="number" min="1"/>
				<form:errors path="age"/>
			</div>
			<input type="submit" value="Create"/>
		</form:form>

   
</body>
</html>
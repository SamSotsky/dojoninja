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
	<div class="container">
		   	<div class="col">
			   	<h1><c:out value="${dojo.getName()}"/></h1>
		   	</div>
		   	<div class="col text-end">
		   		<a href="/dojo">Create New Dojo</a>
		   		
		   	</div>	
		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${dojo.getNinjas()}">
						<tr>
							<th scope="row"><c:out value="${ninja.getId()}"/></th>
							<td><c:out value="${ninja.getFirst_name()}"/></td>
							<td><c:out value="${ninja.getLast_name()}"/></td>
							<td><c:out value="${ninja.getAge()}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
   
</body>
</html>
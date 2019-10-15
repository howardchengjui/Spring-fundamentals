<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage = "true" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Create a New Dorm</h1>
		<p><form:errors class="alert alert-danger" path="newDormObj.*"/></p>
			<form:form action="/dorm/new" modelAttribute="newDormObj" method="post">
			
			<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" class="form-control col-6"/>
			</p>
			<input type="submit" value="Create Dorm" class="btn btn-primary"/>
			<a class="btn btn-secondary" href="/student/new">Create Student</a>
			
			</form:form>
		
	</div>
</body>
</html>
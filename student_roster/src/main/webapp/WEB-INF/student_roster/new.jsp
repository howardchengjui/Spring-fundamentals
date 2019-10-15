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
		<h1>New Student</h1>
		
		<form:form action="/student/new" method="post" modelAttribute="newStudent">
			<p>
			<form:label path="firstName">First Name</form:label>
			<form:errors class="alert alert-danger" path="firstName" />
			<form:input path="firstName" class="form-control col-6"/>
			</p>
			<p>
			<form:label path="lastName">Last Name</form:label>
			<form:errors class="alert alert-danger" path="lastName" />
			<form:input path="lastName" class="form-control col-6"/>
			</p>
			<p>
			<form:label path="age">Age</form:label>
			<form:errors class="alert alert-danger" path="age" />
			<form:input path="age" class="form-control col-6"/>
			</p>
			<input type="submit" value="Create Student" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>
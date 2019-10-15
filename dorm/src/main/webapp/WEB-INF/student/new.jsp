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
		<h1>Create a Student</h1>
		<p>
			<form:form action="/student/new" modelAttribute="newStudentObj" method="post">
			<form:label path="firstName">First Name:</form:label>
			<p><form:errors class="alert alert-danger" path="firstName"/></p>
			<form:input path="firstName" class="form-control col-6"/>
			
			<p>
			<form:label path="lastName">Last Name:</form:label>
			<p><form:errors class="alert alert-danger" path="lastName"/></p>
			
			<form:input path="lastName" class="form-control col-6"/>
			
			<p>
			<form:label path="age">Age:</form:label>
			<p><form:errors class="alert alert-danger" path="age"/></p>
			<form:input path="age" class="form-control col-6"/>
			<p>
				<form:select path="dorm">
					<c:forEach items="${Dorms}" var="dorm">
						<form:option value="${dorm.id}">
							<c:out value="${dorm.name}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<input type="submit" value="Create Student" class="btn btn-primary"/>
			<a class="btn btn-secondary" href="/dorm/new">Create Dorm</a>
			
		</form:form>
	</div>
</body>
</html>
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
	<div class="row">
			<div class="col-md-6">
            <div class="form-group">
				<h1 class="alert alert-success">Register</h1>
					<p><c:out value="${errors}"/></p>
					<form:form action="/registration" method="post" modelAttribute="user">
					<p>
		        		<form:label path="firstName">First name:</form:label>
		        		<form:errors path="firstName"/>
		        		<form:input class="form-control mb-2 col6" path="firstName"/>
		    		</p>
		    		<p>
				        <form:label path="lastName">Last name:</form:label>
				        <form:errors path="lastName"/>
				        <form:input class="form-control mb-2 col6" path="lastName"/>
				    </p>
				    <p>
				        <form:label path="email">Email:</form:label>
				        <form:errors path="email"/>
				        <form:input type="email" class="form-control mb-2 col6" path="email"/>
				    </p>
				    <p>
				        <form:label path="city">City:</form:label>
				        <form:errors path="city"/>
				        <form:input class="form-control mb-2 col6" path="city"/>
				    
		        		<form:label path="state">State</form:label>
		        		<form:errors path="state"/>
		        		<form:input class="form-control mb-2 col6" path="state"/>
		    		</p>
		    		<p>
				        <form:label path="password">Password:</form:label>
				        <form:errors path="password"/>
				        <form:input class="form-control mb-2 col6" path="password"/>
				    </p>
				    <p>
				        <form:label path="passwordConfirmation">Confirm password:</form:label>
				        <form:errors path="passwordConfirmation"/>
				        <form:input class="form-control mb-2 col6" path="passwordConfirmation"/>
				    </p>
				    <input type="submit" class="btn btn-primary" value="Submit"/>
					</form:form>
	</div>
	</div>
	<div class="col-md-6">
            <div class="form-group">
            <h1 class="alert alert-success">Login</h1>
				<p><c:out value="${errors}"/></p>
				<form:form action="/login" method="post" modelAttribute="user">
			<p>
		        <form:label path="email">Email:</form:label>
		        <form:errors path="email"/>
		        <form:input type= "email" class="form-control mb-2 col6" path="email"/>
		    </p>
		    <p>
		        <form:label path="password">Password:</form:label>
		        <form:errors path="password"/>
		        <form:input class="form-control mb-2 col6" path="password"/>
		    </p>
		    <input type="submit" class="btn btn-primary" value="Submit"/>
		</form:form>
		</div>
		</div>
	</div>
	</div>
</body>
</html>
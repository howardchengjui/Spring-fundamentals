<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage = "true" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8" >
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h1>Edit show</h1>
				<form:form action="/edit/${newShowObj.id}" modelAttribute="newShowObj" method="post">
					<form:label path="name">Title: </form:label>
					<p><form:errors class="alert alert-danger" path="name"/></p>
					<form:input type= "text" value="${newShowObj.name}" path="name" class="form-control col-6"/>
					
					<form:label path="network">Network: </form:label>
					<p><form:errors class="alert alert-danger" path="network"/></p>
					<form:input type="text" value="${newShowObj.network}" path="network" class="form-control col-6"/>
					
					<form:label path="rating">Rating: </form:label>
					<p><form:errors class="alert alert-danger" path="rating"/></p>
					<form:input type="rating" value="${newShowObj.rating}" path="rating" class="form-control col-6"/>
					
					<form:hidden path="host" value="${user.id}"/>
					
					
					<br>					
					<input type="submit" value="Create" class="btn btn-primary"/>			
				</form:form>
				<form style="display:inline-block;" action="/delete/${newShowObj.id}" method="post">
	    	  			<input type="hidden" name="_method" value="delete"/>
	    	  			<input type="submit" value="delete"/>
    	 		</form>
			
					
	</div>
</body>
</html>
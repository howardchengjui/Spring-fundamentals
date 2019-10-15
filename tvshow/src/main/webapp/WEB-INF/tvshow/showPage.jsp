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
			<h1><c:out value="${newShowObj.name}"/></h1>
				<p>Network: <c:out value="${newShowObj.network}"/> </p>
				
				<h1>Users who rated this show:</h1>
				
				<%-- <table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Rating</th>
						</tr>
					<thead>
					<tbody>
					<c:forEach items="${newShowObj.getUsersRated()}" var="raters">
						<tr>
							<td scope="row"><c:out value="${raters.name}"/></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/edit/${newShowObj.id}">Edit</a>
			</div>
		</div>
		 --%>
		
			<div class="col-md-6">
				<form:form action="/rate/${newShowObj.id}" modelAttribute="newShowObj" method="post">
					
					
					
					
					
					<form:label path="rating">Rating: </form:label>
					<p><form:errors class="alert alert-danger" path="rating"/></p>
					
					<form:select path="rating" class="form-control col-6">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</form:select>
					
					<form:hidden path="usersRated" value="${user.id}"/>	
					<form:hidden path="name" value="${newShowObj.name}"/>	
					<form:hidden path="network" value="${newShowObj.network}"/>	
					<br>
					<input type="submit" value="Rate" class="btn btn-primary"/>		
				</form:form>
				<br>
				<a href="/edit/${newShowObj.id}">Edit</a>
			</div>	
		</div>
		
		
</body>
</html>
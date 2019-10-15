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
			<h1><c:out value="${newEventObj.name}"/></h1>
				<p>Host: <c:out value="${newEventObj.host.firstName}"/> <c:out value="${newEventObj.host.lastName}"/></p>
				<p>Date: <c:out value="${newEventObj.date}"/></p>
				<p>Location: <c:out value="${newEventObj.city}"/> <c:out value="${newEventObj.state}"/></p>
				<p>People who are attending this event:</p>
				
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Location</th>
						</tr>
					<thead>
					<tbody>
					<c:forEach items="${newEventObj.usersAttending}" var="participants">
						<tr>
							<td scope="row"><c:out value="${participants.firstName}"/></td>
							<td scope="row"><c:out value="${participants.city}"/>,<c:out value="${participants.state}"/></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
			<div class="col-md-6">

			</div>	
		</div>
</body>
</html>
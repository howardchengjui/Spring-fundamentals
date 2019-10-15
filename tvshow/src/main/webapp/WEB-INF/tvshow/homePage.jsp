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
				<h1>Welcome, <c:out value="${user.name}"/></h1>
				<p style="float:right"><a href="/logout">logout</a>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Show</th>
							<th scope="col">Network</th>
							<th scope="col">Avg Rating</th>					
						</tr>
					<thead>
					<tbody>
						<c:forEach items="${allshows}" var="show">
							<tr>
								<td scope="col"><a href="show/${show.id}"><c:out value="${show.name}"/></a></td>
								<td scope="row"><c:out value="${show.network}"/></td>
								<td scope="row"><c:out value="${show.rating}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/newshow">Add a show</a>
						
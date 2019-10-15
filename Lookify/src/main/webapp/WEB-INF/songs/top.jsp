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
		<table>
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Rating</th>
				<th scope="col">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thisSong" items="${topten}">
				<tr>
					<th scope="row"><a href="/show/${thisSong.id}">${thisSong.title}</a>
					<th scope="row">${thisSong.rating}
					<th scope="row">${thisSong.artist}
    	 			</th>
				</tr>
			</c:forEach>
		</tbody>
		</table>	
	</div>
</body>
</html>
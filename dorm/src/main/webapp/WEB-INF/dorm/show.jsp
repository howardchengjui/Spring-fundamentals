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
		<tr>
			<th>Name</th>
			<th>Action</th>
		</tr>
		
		<c:forEach items="${students}" var="student">
		<tr>
			<td>
				<c:out value="${student.firstName}"/>
			</td>
				<td>
					<form style="display:inline-block;" action="/delete/${student.id}/${dorm.id}" method="post">
	    	  			<input type="hidden" name="_method" value="delete"/>
	    	  			<input type="submit" value="delete"/>
    	 			</form>
    	 		</td>
    	 	</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
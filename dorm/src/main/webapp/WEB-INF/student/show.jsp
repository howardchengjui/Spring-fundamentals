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
		<h1><c:out value="${student.firstName} ${student.lastName}"></c:out></h1>
		
		<div class="row">
			<div class="col">
			<table>
				<tr>
					<th>Class</th>
					<th>Action</th>
				</tr>
			<c:forEach items="${student.course}" var="course">
				
				<tr>
					<td>
					<a href="/class/${course.id}"><li><c:out value="${course.name}"/></li></a>
					</td>
					<td>
							<form style="display:inline-block;" action="/drop/${student.id}/${course.id}" method="post">
	    	  					<input type="hidden" name="_method" value="delete"/>
	    	  					<input type="submit" value="delete"/>
    	 					</form>
					</td>
				</tr>
			</c:forEach>
				
				
			</div>
			<div class="col">
			<form:form action="/addcourses" method="post" modelAttribute="middleTableObj">
				<form:select path="course">
					<c:forEach items="${allCourses}" var="course">
						<form:option value="${course.id}">
							<c:out value="${course.name}"/>
						</form:option>	
					</c:forEach>
				</form:select>
				<form:hidden path="student" value="${student.id}"/>
				<input type="submit" value="Add Course" class="btn btn-info">
				
			</form:form>
			
			</div>
		</div>
	</div>
</body>
</html>
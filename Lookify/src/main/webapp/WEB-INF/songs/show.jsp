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
		<h1>Title: <c:out value="${thisSong.title}"/></h1>
		<h1>Artist: <c:out value="${thisSong.artist}"/></h1>
		<h1>Rating(1-10): <c:out value="${thisSong.rating}"/></h1>
			<form style="display:inline-block;" action="/delete/${thisSong.id}" method="post">
	    	  			<input type="hidden" name="_method" value="delete"/>
	    	  			<input type="submit" value="delete"/>
    	 	</form>
    	 				
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style=color:red><c:out value="${error}"/></p>
	<h1>Dojo Survey</h1>
	<form method="POST" action="/process">
	
    	<label> Your Name: <input type="text" name="name"></label><br>
    	<label> Dojo Location: <input type="text" name="location"></label><br>
    	<label> Favorite Language: <input type="text" name="language"></label><br>
    	<label> Comment (optional): <input type="text" name="comment"></label><br>
    	
    	<button type="submit">Submit</button>
	</form>
	</body>
</html>
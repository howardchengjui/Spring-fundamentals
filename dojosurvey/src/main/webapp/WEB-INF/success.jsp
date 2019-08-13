<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Submitted info</h1>
	<p>Name: <c:out value="${name}"/></p>
	<p>location: <c:out value="${location}"/></p>
	<p>language: <c:out value="${language}"/></p>
	<p>comment: <c:out value="${comment}"/></p>
	
	</body>
</html>
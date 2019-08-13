<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>
</head>
<body>
	<h1></h1>
	<h2>You have visited <a href="http://localhost:8080/your_server">http://your_server</a> <c:out value="${count}"/> times.</h2>
	<p><a href="http://localhost:8080/your_server/clear">clear session</a></p>
	</body>
</html>
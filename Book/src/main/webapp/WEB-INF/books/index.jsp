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
		<h1>All books</h1>
		<a href="/create">create a new book</a>
		<table class="table">
  <thead>
	    <tr>
	      <th scope="col">Title</th>
	      <th scope="col">Description</th>
	      <th scope="col">Language</th>
	      <th scope="col">Pages</th>
	      <th scope="col">Action</th>
	      
	    </tr>
  </thead>
  <tbody>
  	<c:forEach var="book" items="${Books}" >
    	<tr>
	      <th scope="row"><c:out value="${book.title}"/></th>
	      <th scope="row"><c:out value="${book.description}"/></th>
	      <th scope="row"><c:out value="${book.language}"/></th>
	      <th scope="row"><c:out value="${book.numberOfPages}"/></th>
      	  <th scope="row"><a href="/show/${book.id}">show</a></th>
    	  <th scope="row"><a href="/update/${book.id}">update</a></th>
    	  
    	  <th scope="row"> 
    	  <form style="display:inline-block;" action="/delete/${book.id}" method="post">
    	  	<input type="hidden" name="_method" value="delete"/>
    	  	<input type="submit" value="delete"/>
    	  </form>
    	  </th>
    	  
    	</tr>
	</c:forEach>
  </tbody>
</table>
	</div>
</body>
</html>
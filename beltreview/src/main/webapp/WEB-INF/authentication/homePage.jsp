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
				<h1>Welcome, <c:out value="${user.firstName}"/></h1>
				<p style="float:right"><a href="/logout">logout</a>
				<p>Here are some the events in your state(<c:out value="${user.state}"/>):<p>
				<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Date</th>
						<th scope="col">Location</th>
						<th scope="col">Host</th>
						<th scope="col">Action/status</th>						
					</tr>
				<thead>
				<tbody>
				<c:forEach items="${instateevents}" var="event">
					<tr>
						<td scope="row"><a href="/events/${event.getId()}"><c:out value="${event.name}"/></a></td>
						<td scope="row"><c:out value="${event.date}"/></td>
						<td scope="row"><c:out value="${event.city}"/>,<c:out value="${event.state}"/></td>
						<td scope="row"><c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/></td>
						<c:choose>
							<c:when test="${event.host == user }">
								<td scope="row"><a href="/edit/${event.id}">Edit</a> | <a href="/delete/${event.id}">Delete</a></td>
							</c:when>
							<c:otherwise>
								<c:set var = "attending" value="${false}"/>
								<c:forEach items="${event.getUsersAttending()}" var="participants">
									<c:if test="${ participants ==user}">
										<c:set var = "attending" value= "${true}"/>
									</c:if>
								</c:forEach>
								
								<c:choose>
                                       <c:when test="${attending == false}">
                                           <td scope="row"><a href="/join/${event.id}">Join</a></td>
                                       </c:when>
                                       <c:otherwise>
                                           <td scope="row">Joining | <a href="/leave/${event.id}">Cancel</a></td>
                                       </c:otherwise>
                                 </c:choose>
                              </c:otherwise>
                          </c:choose>
					</tr>
					</c:forEach>
				</tbody>
				</table>
				<br>
				<p>Here are some the events in other states:<p>
				<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Date</th>
						<th scope="col">Location</th>
						<th scope="col">State</th>
						<th scope="col">Host</th>
						<th scope="col">Action/status</th>						
					</tr>
				<thead>
				<tbody>
				<c:forEach items="${outofstateevents}" var="event">
					<tr>
						<td scope="row"><a href="/events/${event.getId()}"><c:out value="${event.name}"/></a></td>
						<td scope="row"><c:out value="${event.date}"/></td>
						<td scope="row"><c:out value="${event.city}"/></td>
						<td scope="row"><c:out value="${event.state}"/></td>
						<td scope="row"><c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/></td>
				<c:choose>
							<c:when test="${event.host == user }">
								<td scope="row"><a href="/edit/${event.id}">Edit</a> | <a href="/delete/${event.id}">Delete</a></td>
							</c:when>
							<c:otherwise>
								<c:set var = "attending" value="${false}"/>
								<c:forEach items="${event.getUsersAttending()}" var="participants">
									<c:if test="${ participants ==user}">
										<c:set var = "attending" value= "${true}"/>
									</c:if>
								</c:forEach>
								<c:choose>
                                       <c:when test="${attending == false}">
                                           <td scope="row"><a href="/join/${event.id}">Join</a></td>
                                       </c:when>
                                       <c:otherwise>
                                           <td scope="row">Joining | <a href="leave/${event.id}">Cancel</a></td>
                                       </c:otherwise>
                                 </c:choose>
                              </c:otherwise>
                          </c:choose>
					</tr>
					</c:forEach>
				</tbody>
				</table>
				<h1>Create a new event</h1>
				<form:form action="/newevent" modelAttribute="newEventObj" method="post">
					<form:label path="name">Event: </form:label>
					<p><form:errors class="alert alert-danger" path="name"/></p>
					<form:input path="name" class="form-control col-6"/>
					
					<form:label path="date">Date: </form:label>
					<p><form:errors class="alert alert-danger" path="date"/></p>
					<form:input type="date" path="date" class="form-control col-6"/>
					
					<form:label path="city">City: </form:label>
					<p><form:errors class="alert alert-danger" path="city"/></p>
					<form:input path="city" class="form-control col-6"/>
					
					<form:label path="state">State: </form:label>
					<p><form:errors class="alert alert-danger" path="state"/></p>
					<form:input path="state" class="form-control col-6"/>
					
					<form:hidden path="usersRated" value="${user.id}"/>
					
					
					<input type="submit" value="Create" class="btn btn-primary"/>			
				</form:form>
			</div>		
			
</body>
</html>
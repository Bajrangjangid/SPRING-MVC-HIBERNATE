<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<title>Customer List CRUD</title>
</head>
<body>
<center>
<h1 class="color">Customer Relationship Management</h1>
<br><br>
<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
			/>
			
<br><br>
<table border="1">
	<tr>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email ID</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="obj" items="${customersList}">
	
		<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${obj.id}"></c:param>
		</c:url>
		
		<c:url var="deleteLink" value="/customer/deleteCustomer">
			<c:param name="customerId" value="${obj.id}"></c:param>
		</c:url>
		
		<tr>
			<td>${obj.firstName}</td>
			<td>${obj.lastName}</td>
			<td>${obj.email}</td>
			<td>
				<a href="${updateLink}">Update</a>
				 | 
				<a href="${deleteLink}"
				onclick="if(!(conform('Are you sure???'))) return false;">Delete</a>
			</td>
		</tr>	
	</c:forEach>
</table>
</center>
</body>
</html>
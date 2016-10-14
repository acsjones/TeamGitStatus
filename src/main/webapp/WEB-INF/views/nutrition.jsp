<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="parts/head.jsp"%>
</head>
<body>
	<div class="nav">
		<a href="<c:url value="/"/>">Home</a>
	</div>
	<h1>Nutrition</h1>


	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Calories</th>
				<th>Total Fat</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nutrition" items="${nutritionList}">
				<tr>
					<td><c:out value="${ nutrition.name}" /></td>
					<td><c:out value="${ nutrition.calories}" /></td>
					<td><c:out value="${ nutrition.total_fat}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>





</body>
</html>
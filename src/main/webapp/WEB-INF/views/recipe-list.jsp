<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="parts/head.jsp"%>
<style>
     body{
       background: none !important;
       background-image:none !important;
     }
    </style>
</head>

<body>

	<div class="nav">

		<a href="<c:url value="/"/>">Home</a>

	</div>
	

	<h1>Food</h1>





	<table class="table table-striped">

		<thead>

			<tr>

				<th>Title</th>


				<th>Image</th>

			</tr>

		</thead>

		<tbody>

			<c:forEach var="food" items="${foodList}">

				<tr>
					<td><a href="<c:url value="${ food.source }"/>">${ food.title}</a></td>

		
					<td> <img src="${ food.image }" /></td>

					



				</tr>

			</c:forEach>

		</tbody>

	</table>





</body>

</html>
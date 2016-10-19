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

<table>
	<c:forEach var="vitamin" items="${vitamins}">
			<tr>
				<td><a href="<c:url value="/vitamins/${vitamin.vitamin_key}"/>">
				<c:out value="${ vitamin.vitamin_letter }" /> </a></td>
	</tr>
		</c:forEach>
	</table>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Serves</th>
				<th>Calories Per Serving</th>
				<th>Vitamin A(µg)</th>
				<th>Vitamin B1(mg)</th>
				<th>Vitamin B2(mg)</th>
				<th>Vitamin B3(mg)</th>
				<th>Vitamin B6(mg)</th>
				<th>Vitamin B9(µg)</th>
				<th>Vitamin B12(µg)</th>
				<th>Vitamin C(mg)</th>
				<th>Vitamin D(µg)</th>
				<th>Vitamin E(mg)</th>
				<th>Vitamin K(µg)</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nutrition" items="${nutritionList}">
				<tr>
					<td><a href="<c:url value="${nutrition.url}"/>">${ nutrition.name}</a></td>
					<td>${nutrition.yield }
					<td>${nutrition.calPerServing}</td>
					<td><c:out value="${ nutrition.vitA}" /> (<c:out value="${ nutrition.vitAPer}" />)</td>
					<td><c:out value="${ nutrition.vitB}" /> (<c:out value="${ nutrition.vitBPer}" />)</td>
					<td><c:out value="${ nutrition.vitB2}" /> (<c:out value="${ nutrition.vitB2Per}" />)</td>
					<td><c:out value="${ nutrition.vitB3}" /> (<c:out value="${ nutrition.vitB3Per}" />)</td>
					<td><c:out value="${ nutrition.vitB6}" /> (<c:out value="${ nutrition.vitB6Per}" />)</td>
					<td><c:out value="${ nutrition.vitB9}" /> (<c:out value="${ nutrition.vitB9Per}" />)</td>
					<td><c:out value="${ nutrition.vitB12}" /> (<c:out value="${ nutrition.vitB12Per}" />)</td>
					<td><c:out value="${ nutrition.vitC}" /> (<c:out value="${ nutrition.vitCPer}" />)</td>
					<td><c:out value="${ nutrition.vitD}" /> (<c:out value="${ nutrition.vitDPer}" />)</td>
					<td><c:out value="${ nutrition.vitE}" /> (<c:out value="${ nutrition.vitEPer}" />)</td>
					<td><c:out value="${ nutrition.vitK}" /> (<c:out value="${ nutrition.vitKPer}" />)</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>





</body>
</html>
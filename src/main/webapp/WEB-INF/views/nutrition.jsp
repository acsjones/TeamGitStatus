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


	<table class="nutrition_table">
		<thead>
			<tr class="whatever">
				<th>Name</th>
				<th>Serves</th>
				<th>Calories</th>
				<th>Vitamin&nbspA (µg)</th>
				<th>Vitamin&nbspB1 (mg)</th>
				<th>Vitamin&nbspB2 (mg)</th>
				<th>Vitamin&nbspB3 (mg)</th>
				<th>Vitamin&nbspB6 (mg)</th>
				<th>Vitamin&nbspB9 (µg)</th>
				<th>Vitamin&nbspB12 (µg)</th>
				<th>Vitamin&nbspC (mg)</th>
				<th>Vitamin&nbspD (µg)</th>
				<th>Vitamin&nbspE (mg)</th>
				<th>Vitamin&nbspK (µg)</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nutrition" items="${nutritionList}">
				<tr class="whatever">
					<td class="whatever"><a class="url-name" href="<c:url value="${nutrition.url}"/>">${ nutrition.name}</a></td>
					<td class="whatever">${nutrition.yield }
					<td class="whatever">${nutrition.calPerServing}</td>
					<td class="whatever"><c:out value="${ nutrition.vitA}" /> (<c:out value="${ nutrition.vitAPer}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitB}" /> (<c:out value="${ nutrition.vitBPer}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitB2}" /> (<c:out value="${ nutrition.vitB2Per}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitB3}" /> (<c:out value="${ nutrition.vitB3Per}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitB6}" /> (<c:out value="${ nutrition.vitB6Per}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitB9}" /> (<c:out value="${ nutrition.vitB9Per}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitB12}" /> (<c:out value="${ nutrition.vitB12Per}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitC}" /> (<c:out value="${ nutrition.vitCPer}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitD}" /> (<c:out value="${ nutrition.vitDPer}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitE}" /> (<c:out value="${ nutrition.vitEPer}" />)</td>
					<td class="whatever"><c:out value="${ nutrition.vitK}" /> (<c:out value="${ nutrition.vitKPer}" />)</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>





</body>
</html>
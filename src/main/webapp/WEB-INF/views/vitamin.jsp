<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page we have a form to edit a single movie and a button to delete it.
	
	Model:
	- Movie movie
 --%>
<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<div class="nav">
	<a href="<c:url value="/vitamins"/>">Back</a>
		<a href="<c:url value="/food"/>">Food</a>
</div>
<h1>
Vitamin ${ vitamin.vitamin_letter }
</h1>
Also known as ${ vitamin.vitamin_name }
<form method="post">
	<div>
		<label>${ vitamin.vitamin_benefits }</label>
	</div>
	<h2>Foods</h2>
<label><a href="<c:url value="/food?q=${vitamin.food_1 }"/>">${ vitamin.food_1 }</a></label>
<label><a href="<c:url value="/food?q=${vitamin.food_2 }"/>">${ vitamin.food_2 }</a></label>
<label><a href="<c:url value="/food?q=${vitamin.food_3 }"/>">${ vitamin.food_3 }</a></label>
</form>

</body>
</html>

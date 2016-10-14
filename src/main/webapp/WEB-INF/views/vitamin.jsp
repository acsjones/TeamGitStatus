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
</div>
<h1>
Vitamin ${ vitamin.vitamin_letter }
</h1>
${ vitamin.vitamin_name }
<form method="post">
	<div>
		<label>${ vitamin.vitamin_benefits }</label><br>
		<h2>Food Items list</h2>
		<a href="<c:url value="/food?q=${vitamin.food1}"/>"><label>${ vitamin.food1 }</label></a>
		<a href="<c:url value="/food?q=${vitamin.food2}"/>"><label>${ vitamin.food2 }</label></a>
		<a href="<c:url value="/food?q=${vitamin.food3}"/>"><label>${ vitamin.food3 }</label></a>
		
		
	</div>
	
</form>

</body>
</html>

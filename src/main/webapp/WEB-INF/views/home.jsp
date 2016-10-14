<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page the user can choose to view movies or categories.
	
	Model: none
 --%>
<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<h1>
	Welcome. This is the homepage where we will introduce VitaMenu. Click the link to start VitaMenu.
</h1>

<a href="<c:url value="/vitamins"/>">VitaMenu Start</a><br>
<a href="<c:url value="/nutrition"/>">Nutrition</a><br>
<div>
      <label>Enter item</label>
		<input type="text" name="item" value="${nutrition.nutritionList}"/>
	</div>

</body>
</html>

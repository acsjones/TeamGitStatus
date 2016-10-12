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
	<a href="<c:url value="/"/>">Home</a>
	<a href="<c:url value="/vitamin"/>">Back to Movies List</a>
</div>
<h1>
	Vitamin: ${ vitamin.vitaminLetter }
</h1>

<form method="post">
	<div>
		<label>VitaminLetter</label>
		<input type="text" name="letter" value="${vitamin.vitaminLetter}"/>
	</div>
	<div>
		<label>recIntake</label>
		<input type="text" name="intake" value="${vitamin.recIntake}"/>
	</div>
	<button type="submit">Save Changes</button>
</form>



</body>
</html>

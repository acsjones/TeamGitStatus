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
Disclaimer: We are not doctors.
<p><a href="<c:url value="/vitamins"/>">VitaMenu Start</a></p>

</body>
</html>
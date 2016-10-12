<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<h1>
	Welcome.
</h1>

<%-- <a href="<c:url value="/home"/>">VitaMenu</a>--%>
<a href ="<c:url value="/vitamin"/>"> Vitamin A</a> <br>
Vitamin B1<br>
Vitamin B2
Vitamin B3
Vitamin B5
Vitamin B7
Vitamin B9
Vitamin B12
Vitamin C
Vitamin D
Vitamin E
Vitamin K
Vitamin B6

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page we list all the users.
	
	Model:
	- List<User> users
 --%>
<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<div class="nav">
	<a href="<c:url value="/"/>">Home</a>
</div>
<h1>
	All the Vitamins
</h1>


<table>
	
	<c:forEach var="vitamins" items="${vitamins}" >
		<tr>
			
			<td><c:out value="${ vitamin.vitamin_letter}"/></td><td><c:out value="${ vitamin.vitamin_name }"/></td>
		    <td><c:out value="${ vitamin.vitamin_benefit }"/></td><td><c:out value="${ vitamin.vitamin_recommenedintake }"/></td>
		</tr>
	</c:forEach>
</table>


</body>
</html>
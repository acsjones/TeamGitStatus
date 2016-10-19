<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
	On this page we list all the users.
	
	Model:
	- List<User> users
 --%>
<html>
<head>
<%@ include file="parts/head.jsp"%>
</head>
<body>

	

<div class="nav">
	<a href="<c:url value="/"/>">Home</a>

</div>

<h1>
	Choose your Vitamin!
</h1>
	
	<h1> All the Vitamins Choose your Vitamin!</h1>
	
	<table>
	<c:forEach var="vitamin" items="${vitamins}">
			<tr>
				<td><a href="<c:url value="/vitamins/${vitamin.vitamin_key}"/>">
				<c:out value="${ vitamin.vitamin_letter }" /> </a></td>
	</tr>
		</c:forEach>
	</table>

<form method=get action="<c:url value="/nutrition?search=${search}"/>">
    <div>
        <label>Search for food item:</label><input type="text" name="search" value="">
     </div>
    <button type="submit">Search</button>
    </form>

</body>

</html>



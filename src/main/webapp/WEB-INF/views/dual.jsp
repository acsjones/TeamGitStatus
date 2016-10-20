<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
    On this page the user can choose to view movies or categories.
    
    Model:
    - List<User> users
--%>
<html>
<head>

<title>VitaMenu</title>
<link rel="stylesheet" type="text/css" href="resources/dual.css" />

<script type="text/javascript" src="resources/dual.js"></script>

</head>
<body>
	<!-- The overlay -->
	<div id="myNav" class="overlay">

		<!-- Button to close the overlay navigation -->
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<p><a href="<c:url value="/vitamins"/>">Home</a></p>
		 <form method=get action="<c:url value="/nutrition?search=${search}"/>">
   <div>
       <label>Search for food item:</label><input type="text" name="search" value="">
    </div>
   <button type="submit">Search</button>
   </form>
<table>
    <c:forEach var="vitamin" items="${vitamins}">
            <tr>
                <td><a href="<c:url value="/vitamins/${vitamin.vitamin_key}"/>">
                <c:out value=" Vitamin ${ vitamin.vitamin_letter }" /> </a></td>
    </tr>
        </c:forEach>
    </table>
    
    
			<!-- LAYERED -->
		

	</div>
	<!-- Overlay content -->
	<div class="overlay-content">
		<h1>Welcome to VitaMenu!!</h1>
		<blockquote>
		<i>If we could give every individual the right amount of nourishment
		and exercise, not too little and not too much, we would have found the
		safest way to health</i>.<br>
		<i>Hippocrates</i>....
		</blockquote>
		<span onclick="openNav()">Enter VitaMenu</span>
		






	</div>




</body>
</html>
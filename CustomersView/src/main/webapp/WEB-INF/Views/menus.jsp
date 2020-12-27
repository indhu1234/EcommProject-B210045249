<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width,initial-scale=1"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<nav>
<ul>
<li><a href="<c:url value='home'></c:url>">Home</a>
<c:if test="${sessionScope.loggedIn}"> 
     <c:if test="${sessionScope.role=='ROLE_ADMIN'}"> 
      		<li><a href="category">Manage Category</a></li>
      		<li><a href="product">Manage Product</a></li>
      </c:if>
    </c:if> 
<%-- <li><a href="<c:url value='category'></c:url>">Manage Category</a>
<li><a href="<c:url value='product'></c:url>">Manage Product</a>
 --%>
 <li><a href="<c:url value='register'></c:url>">Register</a>
<li><a href="<c:url value='login'></c:url>">Login</a>
<li><a href="<c:url value='allproducts'></c:url>">All Products</a>
</ul>
</nav>
</body>
</html>
<%@ include file="menus.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Products</h1>
<div class="container">
	<div class="row text-center text-lg-left">
	
	<c:forEach items="${productList}" var="product">
		<div class="col-md-3 col-sm-4 col-xs-12">
			<a href="<c:url value='/totalProductDisplay/${product.prodid}'/>" class="d-block mb-4 h-100">
			<img class="img-fluid img-thumbnail" src="<c:url value='/resources/images/${product.prodid}.jpg'/>" width="100" height="100"/>
			<p>Price :${product.price}</p>
			<p>Stock :${product.stock}</p>
			</a>
		</div>
	</c:forEach>
	
	</div>
</div>

</body>
</html>
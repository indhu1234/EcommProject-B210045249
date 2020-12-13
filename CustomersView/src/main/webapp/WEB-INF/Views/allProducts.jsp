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
<h1>Product Catelog</h1>
<div class="container">
 <div class="content-wrapper">
   <div class="item-container">
     <%-- <c:forEach items="${ productList }" var="product"> --%>
     <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-12">
          <div class="product col-md-3 service-image-left">
           <center>
           <img id="item-display" src="<c:url value='/resources/images/${product.prodid }.jpg'></c:url>"> </img>
           
           </center>
          </div>
        </div>
     <form action="<c:url value="/addToCart/${product.prodid}"/>" method="get">
       <div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
         <div class="product-title">${product.prodName }</div>
         <div class="product-desc">${product.prodDesc }</div>
         <hr>
         <div class="product-price">${product.price }</div>
         <div class="product-stock">${product.stock }</div>
         <div class="product-price">Quantity </div>
            <select name="quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            </select>
            
       </div>
       <hr>
       <input type="submit" value="Add to Cart" class="btn btn-success">
       </form>
     </div>   
   </div>
   <%-- </c:forEach>   --%>
</div>
</div>
</body>
</html>
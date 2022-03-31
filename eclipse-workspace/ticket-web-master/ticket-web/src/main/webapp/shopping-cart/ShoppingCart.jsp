<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping cart</title>
</head>
<body>
<h1>Shopping cart</h1>

<table border="1">
	<c:forEach var="product" items="${products}">
		<tr>
			<td><c:out value="${product.name}"/></td>
			<td><c:out value="${product.price}"/></td>
		</tr>
	</c:forEach>
</table>

<a href="/ticket-web/product/">Back to the catalog.</a>

</body>
</html>
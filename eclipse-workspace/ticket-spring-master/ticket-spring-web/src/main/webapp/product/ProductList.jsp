<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of products</title>
</head>
<body>
<h1>List of products</h1>

<table border="1">
	<c:forEach var="product" items="${products}">
		<tr>
			<td><c:out value="${product.name}"/></td>
			<td><c:out value="${product.price}"/></td>
			<td>
				<form method="post" action="/ticket-spring-web/shopping-cart/add/">
					<input name="id"
						   type="hidden" 
						   value="<c:out value='${product.id}'/>">
					<input type="submit" value="Buy">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
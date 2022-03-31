<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- This is delivered to the browser  -->
	<%-- This is NOT delivered to the browser --%>
	<%= request.getAttribute("result") %>
</body>
</html>
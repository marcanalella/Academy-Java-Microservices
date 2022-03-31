<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add product</title>
</head>
<body>

<form action="/ticket-web/product/process-add" method="post">
Name: <input name="name" type="text"><br>
Price: <input name="price" type="text"><br>
<input type="submit" value="Ok">
</form>


</body>
</html>
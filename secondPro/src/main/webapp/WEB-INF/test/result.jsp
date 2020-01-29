<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Spring Web MVC 구축</h1>
	<hr/>
	<h3>JSP로 코드 출력 : <%= request.getAttribute("msg") %></h3>
	<h3>EL로 코드 출력 : ${msg}</h3>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>Spring Web MVC 구축</h1>
	<hr/>
	<h3>JSP로 코드 출력 : <%= request.getAttribute("msg") %></h3>
	<h3>EL로 코드 출력 : ${msg}</h3>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>spring mvc 테스트</h1>
	<hr/>
	<h3><a href="/firstPro/test.do">테스트 컨트롤러 요청하기</a></h3>
	<form method="post" action="/firstPro/search.do">
		검색어 : <input type="text" name="search" >
		<input type="submit" value="검색">
	</form>
</body>
</html>
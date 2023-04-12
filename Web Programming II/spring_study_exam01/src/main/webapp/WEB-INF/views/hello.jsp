<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello Spring</h2>
	오늘 날짜와 시간은 : <%=java.time.LocalDateTime.now() %> 입니다.
</body>
</html>
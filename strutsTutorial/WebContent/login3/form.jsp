<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style></style>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>로그인페이지</h1>
	<%
		Map<String,List> map = (Map<String,List>)request.getAttribute("fieldErrors");
	%>
	<form action="test32.action">
	<p>id:<input type="text" name="id" value="${id }"/><%=map.get("id") %></p>
	<p>pw:<input type="text" name="pw" value="${pw }"/>${fieldErrors.pw }</p>
	<p>
		<button type="submit">LOGIN</button>
		<button type="reset">RESET</button>
	</p>
	</form>
</body>
</html>
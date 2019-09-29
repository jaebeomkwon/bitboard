<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
		<p>${sessionScope.id}</p>
		${message }<br>
		<h1>${sessionScope.name }님 안녕하세요.</h1>
		<input type="button" id="listBtn" value="게시판으로">
		<input type="button" id="logoutBtn" value="로그아웃">
		<input type="button" id="infoModifyBtn" value="회원정보수정">
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>
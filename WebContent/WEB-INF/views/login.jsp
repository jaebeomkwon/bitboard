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
	<p>${sessionScope.id }</p>
	${message}<br>
	<form action="LoginOk.do" method="post">
		<input type="hidden" id="sessionId" value="${sessionScope.id}">
		<span id="loginPart">
		아이디 : <input type="text" name="id" value="${requestScope.id}"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
		<input type="button" id="joinUsBtn" value="회원가입">
		<input type="button" id="listBtn" value="게시판으로">
		</span>
		<span id="logoutPart">
		<input type="button" id="logoutBtn" value="로그아웃">
		<input type="button" id="list2Btn" value="게시판으로">
		</span>
	</form>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>
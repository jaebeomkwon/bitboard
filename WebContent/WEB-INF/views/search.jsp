<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
	<form action="Search.do" method="post">
		<select name="opt">
			<option value="bTitle">제목</option>
			<option value="bContent">내용</option>
			<option value="bName">작성자</option>
		</select>
		<input type="text" name="keywork">
		<input type="submit" value="검색">
	</form>
	</div>
</body>
</html>
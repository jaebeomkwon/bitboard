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
	${sessionScope.id }
		<form action="Reply.do" method="post">
			<input type="hidden" name="bId" value="${replyView.bId}"> 
			<input type="hidden" name="bName" value="${replyView.bName}"> 
			<input type="hidden" name="bGroup" value="${replyView.bGroup}"> 
			<input type="hidden" name="bStep" value="${replyView.bStep}"> 
			<input type="hidden" name="bIndent" value="${replyView.bIndent}">
			<table>
				<tr>
					<td>번호</td>
					<td>${replyView.bId}</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${replyView.bHit}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${replyView.bName}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>re:<input type="text" name="bTitle" value="${replyView.bTitle}" style="width: 94%;"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" name="bContent" style="width: 98%;">${replyView.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="답변달기">
					<input type="button" id="listBtn" value="목록보기">
				</tr>
			</table>
		</form>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>
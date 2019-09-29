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
		<form action="ReCommentWrite.do" method="post">
			<input type="hidden" name="cId" value="${reCommentView.cId}"> 
			<input type="hidden" name="cName" value="${reCommentView.cName}"> 
			<input type="hidden" name="cGroup" value="${reCommentView.cGroup}"> 
			<input type="hidden" name="cGroup2" value="${reCommentView.cGroup2}"> 
			<input type="hidden" name="cStep" value="${reCommentView.cStep}">
			<input type="hidden" name="cIndent" value="${reCommentView.cIndent}">
			<table>
				<tr>
					<td>번호</td>
					<td>${reCommentView.cId}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${reCommentView.cName}</td>
				</tr>
				<tr>
					<td>댓글</td>
					<td>re:<input type="text" name="cContent"
						value="${reCommentView.cContent}" style="width: 94%;"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="댓글달기"> 
					<input type="button" id="listBtn" value="목록보기">
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>
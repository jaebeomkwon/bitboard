<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
<script>
	function goPage(bId,cContent) {
		var f = document.contentView;
		f.bId.value;
		f.cContent.value;
		f.action = "Comment.do"
		f.method="post"
		f.submit();
	};
</script>
</head>
<body>
	<div>
		${sessionScope.id }
		<form action="Modify.do" name="contentView" method="post">
			<input type="hidden" id="bId" name="bId" value="${contentView.bId}">
			<input type="hidden" name="bName" value="${contentView.bName}">
			<table>
				<tr>
					<td>번호</td>
					<td>${contentView.bId}</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${contentView.bHit}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${contentView.bName}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle"
						value="${contentView.bTitle}" style="width: 98%;"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" name="bContent" style="width: 98%;">${contentView.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"> 
					<input type="button" id="deleteBtn" value="삭제"> 
					<input type="button" id="replyBtn" value="답변"> 
					<input type="button" id="listBtn" value="목록보기"></td>
				</tr>
				<tr>
					<td>댓글</td>
					<td><textarea rows="3" name="cContent" style="width: 98%;"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><a href="javascript:goPage('bId','cContent');" class="btn">댓글달기</a>
					</td>
				</tr>
			</table>
		</form>
		<table>
			<tr>
				<td>이름</td>
				<td colspan="2">댓글내용</td>
				<td>날짜</td>
			</tr>
			<c:forEach items="${cList}" var="cDto">
			<input type="hidden" id="cId" value="${cDto.cId}">
				<tr>
					<td>${cDto.cName}</td>
					<td style="text-align: left;"><c:forEach begin="1" end="${cDto.cIndent}">&nbsp;</c:forEach> 
						<c:choose>
							<c:when test="${cDto.cIndent>0 }">
								re:${cDto.cContent}
							</c:when>
							<c:otherwise>
								${cDto.cContent}
							</c:otherwise>
						</c:choose></td>
						<td><input type="button" id="reCommentBtn" value="답글"></td>
					<td>${cDto.cDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>
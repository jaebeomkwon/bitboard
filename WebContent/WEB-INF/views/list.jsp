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
</head>
<body>
	<div>
	${sessionScope.id }
	<input type="hidden" id="sessionId" value="${sessionScope.id}">
	<span id="loginPart"><p style="text-align:right;"><input type="button" id="loginBtn" value="로그인"></p></span>
	<span id="logoutPart"><p style="text-align:right;"><input type="button" id="logoutBtn" value="로그아웃"></p></span>
	<p style="text-align:right;"><input type="button" id="searchBtn" value="검색"></p>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td style="text-align: left;"><c:forEach begin="1" end="${dto.bIndent}">&nbsp;</c:forEach>
					<c:choose>
						<c:when test="${dto.bIndent>0 }">
							<a href="ContentView.do?bId=${dto.bId}">re:${dto.bTitle}</a>
						</c:when>
						<c:otherwise>
							<a href="ContentView.do?bId=${dto.bId}">${dto.bTitle}</a>						
						</c:otherwise>
					</c:choose>
				</td>
				<td>${dto.bDate}</td>
				<td>${dto.bHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			<input type="button" id="writeBtn" value="글작성">
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<c:if test="${page.currentBlock > 1 }">
					<a href="BList.do?currentPage=${page.prevPage}">[이전]</a>
				</c:if>
				<c:if test="${page.currentBlock > 1 }">
					<a href="BList.do?currentPage=1">1...</a>
				</c:if>
				<c:forEach var="num" begin="${page.blockStart }" end="${page.blockEnd }">
					<c:choose>
						<c:when test="${num==page.currentPage }">
							<a href="BList.do?currentPage=${num}" style="color:orange;">${num}</a>
						</c:when>
						<c:otherwise>
							<a href="BList.do?currentPage=${num}">${num}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${page.currentBlock < page.totalBlock }">
					<a href="BList.do?currentPage=${page.totalPage}">...${page.totalPage}</a>
				</c:if>
				<c:if test="${page.currentBlock < page.totalBlock }">
					<a href="BList.do?currentPage=${page.nextPage}">[다음]</a>
				</c:if>
			</td>
		</tr>
	</table>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>	
</body>
</html>
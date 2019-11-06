<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<%
// ContextPath가 "/"이 아니라 "/board"일 경우
String rPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<table border="3">
	<tr>
		<th>제목</th>
		<td>${board.biTitle}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${board.biContent}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${board.uiName}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${board.credat}</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td>${board.cretim}</td>
	</tr>
	<tr>
		<th>수정일</th>
		<td>${board.moddat}</td>
	</tr>
	<tr>
		<th>수정시간</th>
		<td>${board.modtim}</td>
	</tr>
	<tr>
		<th colspan="2">
			<a href="<%=rPath%>/board/list"><button>게시판 가기!</button></a><br>
			<button onclick="goPage('/board/logout')">LOGOUT</button><br>
			
		<c:if test="${user.uiNum == board.uiNum}">
			<button onclick="goPage('/board/update?biNum=${board.biNum}')"><b><i>수정하기</i></b></button><br>
			<!-- 원래 삭제하기는 post로 넘겨야 함 -->
			<button onclick="goPage('/board/delete?biNum=${board.biNum}')"><b><i>삭제하기</i></b></button>
		</c:if>
		</th>
	</tr>
</table>
<%-- 	${board}<br><br> --%>

<script>
	function goPage(url){
		location.href = url;
	}
</script>
</body>
</html>
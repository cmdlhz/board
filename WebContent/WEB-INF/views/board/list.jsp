<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>

<%
String rPath = request.getContextPath();
List<Map<String, String>> list = (List<Map<String, String>>)request.getAttribute("list");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF">
<title>LIST</title>
</head>
<body>
<%
if(user == null){
%>
	<b>You haven't logged in to see your postings.</b><br><br>
	<a href="<%=rPath%>/views/user/login"><button>LOG IN</button></a>
	<a href="<%=rPath%>/views/user/signup"><button>SIGN UP</button></a>
<%
} else {
	%>
	<b>The list of your articles : </b><br><br>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성 일자</th>
			<th>게시 시간</th>
			<th>수정 일자</th>
			<th>수정 시간</th>
		</tr>
	<c:if test="${empty list}">
		<tr>
			<td colspan="5">게시물이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.biNum}</td>
			<td><a href="/board/view?biNum=${board.biNum}">${board.biTitle}</a></td>
			<td>${board.uiId}</td>
			<td>${board.credat}</td>
			<td>${board.cretim}</td>
			<td>${board.moddat}</td>
			<td>${board.modtim}</td>
		</tr>
	</c:forEach>
	</table>
	<br><button onclick="goPage('/views/board/insert')">*** 글쓰기 ***</button><br>
	<br><button onclick="goPage('/views/index')">*** index page로 가기 ***</button><br>
<%
}
%>
<script>
function goPage(url){
	 location.href = url;
}
</script>
</body>
</html>
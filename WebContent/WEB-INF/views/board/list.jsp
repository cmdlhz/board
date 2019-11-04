<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>

<%
String rPath = request.getContextPath();
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
<form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	<%
	if(request.getAttribute("boardList") == null){
		out.println("<tr><td colspan=\"4\">There is no posting.</td></tr>");
	} else {
		List<Map<String, String>> boardList = (List<Map<String, String>>)request.getAttribute("boardList");
		for(Map<String, String> board:boardList){
	%>
		<tr>
			<td><%= board.get("biNum") %></td>
			<td><%= board.get("biTitle") %></td>
			<td><%= board.get("uiNum") %></td>
			<td><%= board.get("credat") %></td>
		</tr>
	<%
		}
	}
	%>
	</table>
</form>
<%
}
%>
<br><a href="/views/board/insert">*** 글쓰기 ***</a><br>
</body>
</html>
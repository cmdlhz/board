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
		</tr>
	<%
	if(list == null || list.size() == 0){
		out.println("<tr align='center'><td colspan=\"5\">There is no posting !!!</td></tr>");
	} else {
		for(Map<String, String> board:list){
	%>
		<tr>
			<td><%= board.get("biNum") %></td>
			<td><%= board.get("biTitle") %></td>
			<td><%= board.get("uiId") %></td>
			<td><%= board.get("credat") %></td>
			<td><%= board.get("cretim") %></td>
		</tr>
	<%
		}
	}
	%>
	</table>
	<br><button onclick="goPage('/views/board/insert')">*** 글쓰기 ***</button><br>
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
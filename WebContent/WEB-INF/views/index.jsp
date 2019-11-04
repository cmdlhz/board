<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<%
// ContextPath가 "/"이 아니라 "/board"일 경우
String rPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEPAGE</title>
</head>
<body>
<b>Welcome !</b><br><br>
<%
if(user == null){
%>
	<a href="<%=rPath%>/views/user/login"><button>Go to the login page!</button></a>
	<a href="<%=rPath%>/views/user/signup"><button>Go to the sign-up page!</button></a>
<% 
} else {
%>
	<a href="<%=rPath%>/views/board/list"><button>게시판 가기!</button></a><br><br>
	<a href="<%=rPath%>/views/user/logout"><button>Go to the logout page...</button></a>
<%
}
%>
</body>
</html>
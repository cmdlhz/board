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
<title>HOMEPAGE</title>
</head>
<body>
<b>Welcome !</b><br><br>
<%
if(user == null){
%>
	<b>Please log in or sign up :)</b><br><br>
	<a href="<%=rPath%>/views/user/login"><button>LOG IN</button></a>
	<a href="<%=rPath%>/views/user/signup"><button>SIGN UP</button></a>
<% 
} else {
%>
	<b>Please choose one of the following: </b><br><br>
	<a href="<%=rPath%>/views/board/list"><button>게시판 가기!</button></a><br>
	<a href="<%=rPath%>/views/user/logout"><button>LOGOUT</button></a>
<%
}
%>
</body>
</html>
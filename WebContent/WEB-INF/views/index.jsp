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
	<b><%= user.get("uiNum") %></b>, <b><%= user.get("uiId") %></b>, <i>please choose one of the following: </i><br><br>
	<a href="<%=rPath%>/board/list"><button>게시판 가기!</button></a><br>
	<a href="<%=rPath%>/users/logout"><button>LOGOUT</button></a><br>
	<a href="<%=rPath%>/users/list"><button>회원 목록</button></a>
<%
}
%>

<!-- 
parameter를 보내면 여기서 보낼 수 있음
<%-- <%= request.getParameter("name") %> --%>
same as
${param.name}
 -->
</body>
</html>
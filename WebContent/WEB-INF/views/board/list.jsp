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
<b>The list of your articles : </b>
<%
if(user == null){
%>
	<a href="<%=rPath%>/views/user/login"><button>Go to the login page!</button></a>
	<a href="<%=rPath%>/views/user/signup"><button>Go to the sign-up page!</button></a>
<%
} else {
%>
<b>My Postings</b><br><br>
<form method="POST" action="/users/signup" onsubmit="return checkForm()">
	<table border="1">
		<tr>
			<td align="center"><b>First Name</b></td>
			<!-- name => key로 받아감 -->
			<td><input type="text" name="uiName" id="uiName"></td>
		</tr>
		<tr>
			<td align="center"><b>ID</b></td>
			<!-- name => key로 받아감 -->
			<td><input type="text" name="uiId" id="uiId"></td>
		</tr>
		<tr>
			<td align="center"><b>Password</b></td>
			<td><input type="password" name="uiPwd" id="uiPwd"></td>
		</tr>
				<tr>
			<td><b>Password Check</b></td>
			<td><input type="password" name="uiPwdCheck" id="uiPwdCheck"></td>
		</tr>
		<tr>
			<th colspan="2"><button>SIGN UP</button></th>
		</tr>
	</table>
</form>
<%
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<form method="POST" action="/users/login">
	<table border="1">
		<tr>
			<td align="center"><b>ID</b></td>
			<!-- name => key로 받아감 -->
			<td><input type="text" name="uiId" id="uiId"></td>
		</tr>
		<tr>
			<td><b>Password</b></td>
			<td><input type="password" name="uiPwd" id="uiPwd"></td>
		</tr>
		<tr>
			<th colspan="2"><button>LOGIN</button></th>
		</tr>
	</table>
</form>
</body>
</html>
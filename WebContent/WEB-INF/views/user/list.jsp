<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER LIST</title>
</head>
<body>
<table border="1">
	<tr>
		<th>User #</th>
		<th>ID</th>
		<th>Name</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.uiNum}</td>
			<td>${user.uiId}</td>
			<td>${user.uiName}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
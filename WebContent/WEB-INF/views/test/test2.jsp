<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST</title>
</head>
<body>
<table border="1">
	<tr>
	<!-- key : 대소문자 구분 -->
		<th>NAme</th>
		<th>Age</th>
	</tr>
	<c:forEach var="tt" items='${list}'>
		<tr>
			<th>${tt.name}</th>
			<th>${tt.age}</th>
		</tr>
	</c:forEach>
</table>
</body>
</html>
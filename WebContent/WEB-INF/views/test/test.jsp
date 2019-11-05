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
		<th>Name</th>
		<th>Age</th>
	</tr>
	<c:forEach var="element" items='${list}'>
		<tr>
			<td>${element.name}</td>
			<td>${element.age}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
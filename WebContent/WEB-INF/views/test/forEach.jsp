<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach</title>
</head>
<body>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />

<%-- <c:forEach var="str" items="item"> --%>
<!-- 	<tr> -->
<%-- 		<td align="right" bgcolor="blue">${str}</td> --%>
<!-- 	</tr> -->
<%-- </c:forEach> --%>
<!-- <br><br> -->
<c:forEach var="i" begin="1" end="10" step="2">
	${i} 사용
</c:forEach>
<br><br>
<c:forEach var="i" items="${intArray}" begin="2" end="4" varStatus="status">
	${status.index} - ${status.count} - [${i}]<br/>
</c:forEach>
</body>
</html>
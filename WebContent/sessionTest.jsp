<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sessionId = session.getId();
Long creTime = session.getCreationTime();
Long modTime = session.getLastAccessedTime();

Date time = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

time.setTime(creTime);
String cre = sdf.format(time);

time.setTime(modTime);
String mod = sdf.format(time);

%>
sessionId : <%= sessionId %><br>
creTime : <%= cre %><br>
modTime : <%= mod %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2.jsp</title>
</head>
<body>
req : <%= request.getAttribute("req") %><br>
ses : <%= session.getAttribute("ses") %><br>
app : <%= application.getAttribute("app") %>
</body>
</html>
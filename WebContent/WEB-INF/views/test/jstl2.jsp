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
String str = (String)pageContext.getAttribute("abc");
if(str!=null && str.equals("abc")){
%>
	"This is abc~";
<%
} else {
%>
 	"This is not abc~";
<%
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 숨어져 있는 것 : scope=”page” /> -->
<!-- "c:set" 대신에 "c1:set" 이라도 상관은 없으나 부르라는대로 부르자~ -->
<c:set var="test" value="Na Na Na" />
${test}<br><br>

<%@ include file="/WEB-INF/views/common/header.jspf" %>

<%
pageContext.setAttribute("msg", "page");
request.setAttribute("msg", "request");
session.setAttribute("msg", "session");
// session.invalidate();
application.setAttribute("msg", "application");

// RequestDispatcher rd = request.getRequestDispatcher("/views/test/2_2");
// rd.forward(request, response);

String a = request.getParameter("a");
%>
${msg}<br><br>

getParameter : <%= a %><br>
${msg} : ${param.a}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>

<%
request.setAttribute("req", "난 응답이 끝나면 사라짐!");
session.setAttribute("ses", "난 세션이 끊어질 때까지 유지됨!");

application.setAttribute("app", "난 서버 꺼질때까지 유지됨!");

RequestDispatcher rd = request.getRequestDispatcher("/views/test/2");
rd.forward(request, response);
%>
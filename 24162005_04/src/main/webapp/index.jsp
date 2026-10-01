<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Tự động chuyển hướng về Servlet /home
response.sendRedirect(request.getContextPath() + "/home");
%>
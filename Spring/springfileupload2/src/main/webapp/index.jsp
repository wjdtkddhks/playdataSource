<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
request.setCharacterEncoding("utf-8");
%>
<%
    String url = request.getContextPath()+"/fileUploadForm";
    response.sendRedirect(url);
%>
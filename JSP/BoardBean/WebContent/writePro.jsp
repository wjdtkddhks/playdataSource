<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>   
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id='article' class='board.BoardDataBean' />
<jsp:setProperty name='article' property='*' />


<%
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		BoardDBBean manager = BoardDBBean.getInstance();
		manager.insertArticle(article);
		
		response.sendRedirect("list.jsp");
%>

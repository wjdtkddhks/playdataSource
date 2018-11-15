<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.ArticleDB" %>
<%
	request.setCharacterEncoding("UTF-8");
	String pageNum = request.getParameter("pageNum");
	String email = "";
	if(request.getParameter("email2").equals("direct")){
		email = request.getParameter("email1") + "@" + request.getParameter("email2sub");
	}else{
		email = request.getParameter("email1") + "@" + request.getParameter("email2");
	}
%>
<jsp:useBean id='article' class='board.ArticleData' />
<jsp:setProperty name='article' property='*' />
<jsp:setProperty name='article' property='email' value='<%=email%>' />

<%

	ArticleDB manager = ArticleDB.getInstance();
	int check = manager.updateArticle(article);
	if(check ==1)	{
%>
	<script>
		alert("해당글이 수정되었습니다.");
		document.location.href="list.jsp?pageNum=<%=pageNum%>"
	</script>
<%
	}else{
%>
	<script>
		alert("해당글이 수정 실패하였습니다.");
		history.back();
	</script>
<%
	}
%>
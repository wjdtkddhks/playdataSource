<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.ArticleDB" %>
<% 
	request.setCharacterEncoding("UTF-8");
	String pageNum = request.getParameter("pageNum");
	String email = "";
	if(request.getParameter("email2").equals("direct")){
		email = request.getParameter("email1") +"@" + request.getParameter("email2sub");
	}else{
		email = request.getParameter("email1") +"@" + request.getParameter("email2");
	}
%>
<jsp:useBean id='article' class='board.ArticleData' />
<jsp:setProperty name='article' property='*' />
<jsp:setProperty name='article' property='email' value='<%=email%>' />

<% 
	ArticleDB manager = ArticleDB.getInstance();
	int check = manager.insertArticle(article);
	
	if(check == 1){
%>		
	<script>
		alert("해당 글이 등록되었습니다.");
		document.location.href='list.jsp?pageNum=<%=pageNum%>';
	</script>
<%
	}else{
%>
	<script>
		alert("해당글 게시에 실패하였습니다. 확인해주세요.");
		history.back();
	</script>		
<%
	}
%>
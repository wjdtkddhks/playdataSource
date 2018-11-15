<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id='article' class='board.BoardDataBean' />
<jsp:setProperty name='article' property='*' />

<%
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		BoardDBBean manager = BoardDBBean.getInstance();
		int result = manager.updateArticle(article);
		
		if(result == 1){
%>
		<script>
			alert("해당 글 수정하였습니다.");
			location.href = "list.jsp?pageNum=<%=pageNum%>";
		</script>
<% 
		}else{
%>		
		<script>
			alert("해당 글 수정실패하였습니다.");
			history.back();
		</script>
<% 
		}
%>


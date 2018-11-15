<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id='article' class='board.BoardDataBean' />
<jsp:setProperty name='article' property='*' />

<%
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		BoardDBBean manager = BoardDBBean.getInstance();
		int check = manager.updatePassArticle(article);
		
		if(check == 1){
%>
		<script>
			alert("해당 글 수정하였습니다.");
		</script>
		<meta http-equiv='refresh' content="0;url='list.jsp?pageNum=<%=pageNum %>'">
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


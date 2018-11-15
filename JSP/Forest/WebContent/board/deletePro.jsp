<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.ArticleDB" %>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	
	ArticleDB manager = ArticleDB.getInstance();
	int check = manager.deleteArticle(num, passwd);
	
	if(check == 1){
%>
	<script>
		alert("해당글이 삭제 되었습니다.");
		opener.document.location.href="list.jsp?pageNum=<%=request.getParameter("pageNum")%>"
		window.close();
	</script>	
<% 		
	}else{
%>
	<script>
		alert("비밀번호를 확인해주세요.");
		history.back();
	</script>
<%
	}
%>
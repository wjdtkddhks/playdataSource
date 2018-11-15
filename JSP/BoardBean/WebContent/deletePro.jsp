<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>
<%@ page import="java.sql.Timestamp" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	String pageNum = request.getParameter("pageNum");
	
	BoardDBBean manager = BoardDBBean.getInstance();
	int check = manager.passCheckArticle(num, passwd);
	
	if(check == 1){
		manager.deleteArticle(num);
%>
	<script>
		alert("해당글이 성공적으로 삭제되었습니다.");
		location.href='list.jsp?pageNum<%=pageNum%>';
	</script>	
<%		
	}else{
%>
	<script>
		alert("비밀번호가 잘못되었습니다.");
		history.go(-1);
	</script>
<%
	}
%>
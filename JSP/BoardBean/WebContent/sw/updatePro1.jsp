<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>

<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	String pageNum = request.getParameter("pageNum");
	
	BoardDBBean manager = BoardDBBean.getInstance();
	int check = manager.passwdCheck(num, passwd);
	
	if(check == 1){
%>
	<script>
		opener.location.href="updateForm2.jsp?num=<%=num%>&pageNum=<%=pageNum%>";
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>
<%@ page import="board.BoardDataBean" %>
<%@ include file='color.jsp' %>

<html>
<head>
	<title>게시판</title>
	<style>
		body{
			background-color: <%=bodyback_c%>;
			text-align: center;
		}
		table{
			width: 400;
			border-spacing: 0;
			padding: 0;
			background-color: <%=bodyback_c%>;
			margin: 10px auto;
		}
		.td_subject{
			width: 70;
			text-align: center;	
			background-color: <%=value_c%>;
			font-weight: 700;
		}
		.td_content{
			width: 330;
			text-align: left;	
		}
	</style>
	<script>
	function blockCheck(){
		var subject = document.upForm.subject.value;
		var email = document.upForm.email.value;
		var content = document.upForm.content.value;
		var passwd = document.upForm.passwd.value;
		
		if(subject == ""){
			alert("제목을 작성해주세요.");
			document.upForm.subject.focus();
			return false;
		}
		
		if(email == ""){
			alert("제목을 작성해주세요.");
			document.upForm.email.focus();
			return false;
		}
		
		if(content == ""){
			alert("제목을 작성해주세요.");
			document.upForm.content.focus();
			return false;
		}
		
		if(passwd == ""){
			alert("제목을 작성해주세요.");
			document.upForm.passwd.focus();
			return false;
		}	
		return true;
	}
</script>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	try{
		BoardDBBean manager = BoardDBBean.getInstance();
		BoardDataBean article = manager.getArticle(num, 1);		
%>

<body>
	<b style='color:<%=title_c %>'>글수정</b> <br />
	<form method='post' name='writeform' action='updatePro.jsp?pageNum=<%=pageNum %>' onsubmit='return blockCheck()'>
		<table border=1>
			<tr>
				<td class='td_subject'> 이 름 </td>
				<td class='td_content'>
					<input type='text' size='10' maxlength='10' name='writer' value='<%=article.getWriter() %>' />
					<input type='hidden' name='num' value='<%=article.getNum() %>' /></td>
			</tr>
			<tr>
				<td class='td_subject'> 제 목 </td>
				<td class='td_content'>
					<input type='text' size='40' maxlength='50' name='subject' value='<%=article.getSubject() %>' /></td>
			</tr>
			<tr>
				<td class='td_subject'> email </td>
				<td class='td_content'>
					<input type='text' size='40' maxlength='30' name='email' value='<%=article.getEmail() %>' /></td>
			</tr>
			<tr>
				<td class='td_subject'> 내 용 </td>
				<td class='td_content'>
					<textarea name='content' rows='13' cols='40'><%=article.getContent() %></textarea></td>
			</tr>
			<tr>
				<td class='td_subject'> 비밀번호 </td>
				<td class='td_content'>
					<input type='password' size='8' maxlength='12' name='passwd' /></td>
			</tr>
			<tr>
				<td colspan=2 bgcolor='<%=value_c %>' align='center'>
					<input type='submit' value='글수정'/>
					<input type='reset' value='다시작성' />
					<input type='button' value='목록보기' onclick="document.location.href='list.jsp?pageNum=<%=pageNum %>'" /></td>
			</tr>
		</table>
	</form>
</body>	
<% 	
	}catch(Exception e){}
%>
</html>
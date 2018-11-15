<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="board.BoardDBBean" %>
<%@ page import="board.BoardDataBean" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	
	BoardDBBean manager = BoardDBBean.getInstance();
	BoardDataBean article = manager.getArticle(num, 1);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판_ 글 수정</title>
<style>
	body{
		background-color: <%=bodyback_c%>;
		text-align: center;
	}
	table{
		width: 420;
		border-spacing: 0;
		padding: 0;
		background-color: <%=bodyback_c%>;
		margin: 10px auto;
	}
	.td_subject{
		width: 90;
		background-color: <%=value_c %>;
		text-align: center;	
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
<body>
<b style='color:<%=title_c %>'>글 수정</b><br />
		<form name='upForm' action='updatePro2.jsp' method='post' onsubmit='return blockCheck()'>
			<input type='hidden' name='num' value='<%=article.getNum() %>' />
			<input type='hidden' name='pageNum' value='<%=pageNum %>' />
		<table border=1>
			<tr align='center'>
				<td class='td_subject'> 작성자 </td>
				<td width='90'><%=article.getWriter() %></td>
				<td class='td_subject'> 작성일 </td>
				<td width='150'><%=sdf.format(article.getReg_date()) %></td>
			</tr>
			<tr>
				<td class='td_subject'> 글제목 </td>
				<td align='left' colspan='3'><input type='text' name='subject' size='40' maxlength='50' value='<%=article.getSubject() %>'  /></td>
			</tr>
			<tr>
				<td class='td_subject'> Email </td>
				<td align='left' colspan='3'><input type='email' name='email' value='<%=article.getEmail() %>' size='40' maxlength='30' ></td>
			</tr>
			<tr>
				<td class='td_subject'>글내용 </td>
				<td align='left' colspan='3'><textarea name='content' rows='13' cols='40' ><%=article.getContent() %></textarea></td>
			</tr>
			<tr>
				<td class='td_subject'>비밀번호 </td>
				<td><input type='password' size='8' maxlength='12' value='<%=article.getPasswd() %>' name='passwd' ></td>
			</tr>
			<tr>
				<td colspan='4' bgcolor='<%=value_c%>' align='center'>
				<input type='submit' value='글수정' />
				&nbsp;&nbsp;
				<input type='button' value='목록보기' onclick="document.location.href='list.jsp?pageNum=<%=pageNum %>'" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDataBean" %>
<%@ page import="board.BoardDBBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="color.jsp" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='jquery-3.3.1.js' /></script>
<style>
	body{
		background-color: <%=bodyback_c%>;
		text-align: center;
	}
	table{
		width: 555;
		border-spacing: 0;
		padding: 0;
		background-color: <%=bodyback_c%>;
		margin: 10px auto;
	}
	.tr_subject{
		width: 125;
		height: 30;
		text-align: center;	
	}
	.td_subject{
		text-align: center;	
		width: 125;
		background-color: <%=value_c%>;
	}
</style>
<script>
	$(document).ready(function(){
		
		$('#update').click(function(){
			$('#contentForm').attr('action', 'updateForm.jsp');
			window.open('', 'passcheck', 'top=80,left=550,width=400,height=150');
			document.contentForm.submit();
		});
		
		$('#delete').click(function(){
			$('#contentForm').attr('action', 'deleteForm.jsp');
			window.open('', 'passcheck', 'top=80,left=550width=400,height=150');
			document.contentForm.submit();
		});
	});

</script>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	int number = Integer.parseInt(request.getParameter("number"));
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	try{
		BoardDBBean manager = BoardDBBean.getInstance();
		BoardDataBean article = manager.getArticle(num, 0);
		
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
%>
<body>
	<b style= 'color:<%=title_c%>'>글 내용 보기</b><br />
	<form name='contentForm' id='contentForm' action='' method='post' target='passcheck'>
		<table border=1>
			<tr class='tr_subject'>
				<td bgcolor='<%=value_c %>'> 글 번호 </td>
				<td><%=number %></td>
				<td bgcolor='<%=value_c %>'> 조회수 </td>
				<td width='180'><%=article.getReadcount() %></td>
			</tr>
			<tr class='tr_subject'>
				<td bgcolor='<%=value_c %>'> 작성자 </td>
				<td><%=article.getWriter() %></td>
				<td bgcolor='<%=value_c %>'> 작성일 </td>
				<td><%=sdf.format(article.getReg_date()) %></td>
			</tr>
			<tr height='30'>
				<td class='td_subject'> 글제목 </td>
				<td align='left' colspan='3'> &nbsp;<%=article.getSubject() %></td>
			</tr>
			<tr>
				<td class='td_subject'>글내용 </td>
				<td align='left' colspan='3'><pre><%=article.getContent() %></pre></td>
			</tr>
			<tr height='30'>
				<td colspan='4' bgcolor='<%=value_c%>' align='center'>
				<input type='hidden' name='num' value='<%=article.getNum() %>' />
				<input type='hidden' name='pageNum' value='<%=pageNum %>' />
				<input type='button' value='글수정' id='update' />
				&nbsp;&nbsp;
				<input type='button' value='글삭제' id='delete' />
				&nbsp;&nbsp;
				<input type='button' value='답글쓰기' onclick="document.location.href='writeForm.jsp?num=<%=num %>&ref=<%=ref %>&re_step=<%=re_step %>&re_level=<%=re_level %>'" />
				&nbsp;&nbsp;
				<input type='button' value='목록보기' onclick="document.location.href='list.jsp?pageNum=<%=pageNum %>'" /></td>
			</tr>
		</table>	
	</form>
	</body>
<% 
	}catch(Exception e){	}
%>	
</html>
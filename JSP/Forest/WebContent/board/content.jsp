<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import='board.ArticleDB' %>
 <%@ page import='board.ArticleData' %>
 <%@ page import='java.text.SimpleDateFormat' %>
<% 
		request.setCharacterEncoding("UTF-8"); 
		int num = Integer.parseInt(request.getParameter("num"));
		int number = Integer.parseInt(request.getParameter("number"));
		String pageNum = request.getParameter("pageNum"); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		ArticleDB manager = ArticleDB.getInstance();
		ArticleData article = manager.getArticle(num, 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css" rel="stylesheet">
<script src='../jquery-3.3.1.js' ></script>
<script>
	$(document).ready(function(){
		$('#delbutton').click(function(){
			window.open("deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>", "d", "top=60,left=100,width=400,height=150");
		});
	});
</script>
<style>
	body{
		text-align: center;
	}
	table{
		width: 580px;
		margin: 20px auto;	
	}
	.td_subject{
		width: 140px;
		background-color : yellow;
		height: 30px;
	}
	table, td{
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<table>
	<tr>
		<td class='td_subject'> 글번호 </td>
		<td width='130px'><%=number %></td>
		<td class='td_subject'> 게시일 </td>
		<td width='170px'><%=sdf.format(article.getRef_date()) %></td>
	</tr>
	<tr>
		<td class='td_subject'> 작성자 </td>
		<td width='110px'><%=number %></td>
		<td class='td_subject'> 이메일 </td>
		<td width='190px'><%=article.getEmail() %></td>
	</tr>
	<tr>
		<td class='td_subject'> 제 목 </td>
		<td colspan=3><%=article.getSubject() %></td>
	</tr>
	<tr>
		<td class='td_subject'>추천지수</td>
		<td colspan=3><%=article.getGrade().toUpperCase() %></td>
	</tr>
	<tr>
		<td class='td_subject'>감상평</td>
		<td colspan=3 align='left'><pre> <%=article.getContent() %></pre></td>
	</tr>
</table>
<form name='contentForm'>
	<input type='button' value='수정' onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum %>'"/>&nbsp;&nbsp;
	<input type='button' value='삭제' id='delbutton'>&nbsp;&nbsp;
	<input type='button' value='답글쓰기' onclick="document.location.href='writeForm.jsp?num=<%=article.getNum() %>&ref=<%=article.getRef() %>&ref_step=<%=article.getRef_step() %>&ref_level=<%=article.getRef_level()%>&pageNum=<%=pageNum %>'" />&nbsp;&nbsp;
	<input type='button' value='목록 보기' 
	onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'" />
</form>
</body>
</html>
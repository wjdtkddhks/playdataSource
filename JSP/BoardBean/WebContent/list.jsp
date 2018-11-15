<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean" %>
<%@ page import="board.BoardDataBean" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file = "color.jsp" %>

<%
	int pageSize = 10;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d HH:mm");
	
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null)
			pageNum = "1";
	
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage - 1) * pageSize + 1;
	int endRow = startRow + pageSize - 1;
	int count = 0;
	int number = 0;
	
	ArrayList<BoardDataBean> articleList = null;
	BoardDBBean dbPro = BoardDBBean.getInstance();
	count = dbPro.getArticleCount();
	
	if(count < startRow){
		currentPage = currentPage - 1;
		startRow = (currentPage - 1) * pageSize + 1;
		endRow = startRow + pageSize - 1;
	}
	if(count > 0)
		articleList = dbPro.getArticles(startRow, endRow);
	
	number = count - (currentPage - 1) * pageSize;

%>
<html>
	<head>
	<title>게시판</title>
	<style>
		body{
			text-align: center;
		}
		table{
			margin: auto;
			width: 600;
			padding: 0;
			border-spacing: 0;
		}
		table:first-of-type{
			margin: 10px auto 0px;
		}
	</style>
	</head>
	<body bgcolor='<%=bodyback_c%>' >
		<b style= 'color:<%=title_c%>'>글목록</b>
		<table>
			<tr>
				<td align='right' bgcolor='<%=value_c %>'><a href='writeForm.jsp'> 글쓰기</a></td>
			</tr>
		</table>
<%
	if(count == 0 ){
%>
		<table border=1>
			<tr><td align='center'>게시판에 저장된 글이 없습니다. </td></tr>
		</table>
<%		
	}else{
%>
		<table border=1>
			<tr height='30' bgcolor='<%=value_c %>'>
				<td align='center' width='50'> 번 호 </td>
				<td align='center' width='250'> 제 목 </td>
				<td align='center' width='100'> 작성자 </td>
				<td align='center' width='150'> 작성일 </td>
				<td align='center' width='50'> 조 회 </td>
			</tr>
<%
	for(int i=0; i<articleList.size(); i++){
		BoardDataBean article = (BoardDataBean)articleList.get(i);
%>
			<tr height='30'>
				<td align='center' width='50'> <%=number %></td>
				<td align='left' >
<% 
		if(article.getRe_level() > 0){
			for(int level=0; level < article.getRe_level(); level++){	
%>
				&nbsp;
<%
			}
%>
			<img src='image/re.gif' />
<%
		}else{
%>
			&nbsp;
<% 
		}
%>
		<a href='content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>&number=<%=number%>'>
		<%=article.getSubject()%> </a>
<%
		if(article.getReadcount() >= 20){
%>
		<img src='image/hot.gif' border=0 height='16' />
<%
		}
%>
				</td>
				<td align='center' width='100'>
				<a href='mailto:<%=article.getEmail()%>'><%=article.getWriter()%></a></td>
				<td align='center' width='150'><%=sdf.format(article.getReg_date()) %></td>
				<td align='center' width='50'><%=article.getReadcount()%></td>
			</tr>
<%
		number--;
		}
%>
		</table>
<%
	}
	
	if(count > 0){
		int pageCount = ((count-1) / pageSize)+1;
		int startPage = 1;
		int i;
		
		if(currentPage%10 != 0)
			startPage = (int)(currentPage/10)*10 +1;
		else
			startPage = currentPage - 9;
		
		int pageBlock= 10;
		
		if(startPage > pageBlock){
%>
			<a href='list.jsp?pageNum=<%=startPage-1%>'>[이전]</a>
<%
		}
		for(i=startPage; (i<=startPage+(pageBlock-1)) && (i<=pageCount); i++){
%>
			<a href='list.jsp?pageNum=<%=i%>'>[<%=i%>]</a>
<%
		}
		
		if(i < pageCount){
%>
			<a href='list.jsp?pageNum=<%=startPage+pageBlock%>'>[다음]</a>
<%	
		}
	}
%>
	</body>
</html>
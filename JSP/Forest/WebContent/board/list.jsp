<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.ArticleDB" %>
<%@ page import="board.ArticleData" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	request.setCharacterEncoding("UTF-8");
	String pageNum = request.getParameter("pageNum");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	ArticleDB manager = ArticleDB.getInstance();
	ArrayList<ArticleData> articlelist = null;
	
	if(pageNum == null)
		pageNum = "1";
	
	int pageSize = 10;
	int startRow = 1;
	int endRow = 1;
	int count = 0;
	int number = 0;
	int currentPage = Integer.parseInt(pageNum);
	
	startRow = (currentPage-1)*pageSize +1;
	endRow = startRow+9;
	count = manager.countArticle();
	
	if(count < startRow){
		currentPage -=1;
		startRow -= pageSize;
		endRow -= pageSize;
	}
	
	articlelist = manager.getArticles(startRow, endRow);

	number = count-(pageSize*(currentPage-1));
%>
<html>
<head>
<title>감상평 게시판</title>
<style>
	body{
		text-align: center;
	}
	table{
		margin: 10px auto;
		text-align: center;
		width: 660;
	}
	table tr{
		height: 30px;
	}

</style>
</head>
<body>
<header>
	<span>감상평 게시판</span>
	<a href='writeForm.jsp?pageNum=<%=pageNum%>'>글쓰기</a>
</header>
		<table border=1>
			<tr>
				<td width='60'> 번 호 </td>
				<td width='300'> 제 목 </td>
				<td width='80'> 작성자 </td>
				<td width='150'> 게시일 </td>
				<td width='70'> 조회수 </td>
			</tr>
<%
		if(count == 0){
%>	
			<tr><td colspan=5>등록된 게시물이 없습니다.</td></tr>		
<% 		
		}else{
			for(int i=0; i<articlelist.size(); i++){
				ArticleData article = articlelist.get(i);
%>
			<tr>
				<td><%=number %></td>
				<td align='left'>
<% 
						for(int j=0; j<=article.getRef_level(); j++){
%>
						&nbsp;
<% 	
						}
						if(article.getRef_level() != 0){
%>
						<img src='../image/re.gif' />
<% 
						}
%>
						<a href='content.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>&number=<%=number%>' >
						<%=article.getSubject() %></a>
<%
						if(article.getReadcount() >= 10){
%>	
						<img src='../image/hot.gif' border=0 height='16' />
<%
						}
%>
				</td>
				<td><a href='mailto:<%=article.getEmail()%>'><%=article.getWriter() %></a></td>
				<td><%=sdf.format(article.getRef_date()) %></td>
				<td><%=article.getReadcount() %></td>
			</tr>
<%		
			number--;
			} //for(article.size() 돌리기) 끝!
		} //else 끝!
%>
		</table>
		<br/>
<%
		int pageBlock = 10;
		int startPage = (currentPage-1)/pageBlock +1;
		int endPage = startPage + (pageBlock-1);
		int lastPage = (count-1)/pageSize +1;
		
		if(startPage != 1){
%>
		<a href='list.jsp?pageNum=<%=startPage-1 %>'>[이전]</a>
<%
		}
		for(int i=startPage; (i<=endPage) && (i<=lastPage); i++){
%>
		<a href='list.jsp?pageNum=<%=i %>'><%=i %></a>
<% 			
		}
		if(endPage < lastPage){
%>
		<a href='list.jsp?pageNum=<%=startPage+pageBlock %>'>[다음]</a>
<% 			
		}
%>
	
</body>
</html>
	
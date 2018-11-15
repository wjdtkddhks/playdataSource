<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<BoardBean> articleList = (ArrayList<BoardBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
	int number = listCount-((nowPage-1)*10);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>MVC 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

#tr_top {
	background: orange;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 게시판 리스트 -->

	<section id="listForm">
		<h2>
			게시판
		</h2>
		
		<table>
		<tr align = 'right'>
			<td colspan=5><a href="boardWriteForm.bo">글쓰기</a></td>
		</tr>
<%
if(articleList != null && listCount > 0){
%>
			<tr id="tr_top">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>

			<%
		for(int i=0;i<articleList.size();i++){
			
	%>
			<tr>
				<td align='center'><%=number%></td>

				<td>
					<%if(articleList.get(i).getBoard_re_lev()!=0){ %> <%for(int a=0;a<=articleList.get(i).getBoard_re_lev()*2;a++){ %>
					&nbsp; <%} %> ▶ <%}else{ %> ▶ <%} %> <a
					href="boardDetail.bo?board_num=<%=articleList.get(i).getBoard_num()%>&page=<%=nowPage%>">
						<%=articleList.get(i).getBoard_subject()%>
				</a>
				</td>

				<td align='center'><%=articleList.get(i).getBoard_name() %></td>
				<td align='center'><%=articleList.get(i).getBoard_date() %></td>
				<td align='center'><%=articleList.get(i).getBoard_readcount() %></td>
			</tr>
			<%number--;} %>
		</table>
	</section>

	<section id="pageList">
		<%if(nowPage<=1){ %>
		[이전]&nbsp;
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="boardList.bo?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		[다음]
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	<%
    }
	else
	{
	%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%
	}
%>

</body>
</html>
<%@page contentType="text/html; charset=utf-8"%> 
<%@page import="com.spring.springboard.BoardDAO"%> 
<%@page import="com.spring.springboard.BoardVO"%> 
<% 
	String userRole = (String)session.getAttribute("userRole"); 
%> 
<html> 
<head> 
<title>글 상세</title> 
</head> 
<body> 
<center> 
<h3>글 상세</h3> 
<hr> 
<table border='1' cellpadding='0' cellspacing='0'> 
	<tr> 
		<td>제목</td>
		<td>${boardVO.getTitle()}</td> 
	</tr> 
	<tr> 
		<td>작성자</td>
		<td>${boardVO.getWriter() }</td> 
	</tr> 
	<tr> 
		<td>내용</td>
		<td><textarea name='content' cols='40' rows='10' disabled='disabled'>${boardVO.getContent() }</textarea>
		</td> 
	</tr> 
	<tr>
		<td>등록일</td>
		<td>${boardVO.getRegdate() }</td> 
	</tr> 
	<tr> 
		<td>조회수</td>
		<td>${boardVO.getCnt() }</td> 
	</tr> 
	<tr> 
		<td colspan='2' align='center'> 
			<a href='./board.do?method=addBoardForm'>글등록</a>&nbsp;&nbsp;&nbsp; 
			<a href='./board.do?method=updateBoardForm&seq=${boardVO.getSeq()}'>글수정</a>&nbsp;&nbsp;&nbsp; 
<%
			if(userRole.equals("Admin")){
%> 
			<a href='./board.do?method=deleteBoard&seq=${boardVO.getSeq() }'>
			글삭제</a>&nbsp;&nbsp;&nbsp; 
<%
			} 
%> 
			<a href='./board.do?method=getBoardList'>글목록</a> 
		</td>
	</tr> 
</table> 
<hr> 
</center> 
</body> 
</html>
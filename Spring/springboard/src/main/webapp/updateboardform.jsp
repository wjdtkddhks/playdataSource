<%@page contentType="text/html; charset=utf-8"%> 
<%@page import="com.spring.springboard.BoardDAO"%> 
<%@page import="com.spring.springboard.BoardVO"%> 
<% 
	if(session.getAttribute("loginID") == null) 
		response.sendRedirect("./loginForm.jsp"); 
%> 
<html> 
<head> 
<title>글 수정</title> 
</head> 
<body> 
<center> 
<h3>글 수정하기</h3> 
<hr> 
<form action='board.do?method=updateBoard' method='post'> 
<input type='hidden' name='seq' value='${boardVO.getSeq() }'/> 
<table border='1' cellpadding='0' cellspacing='0'> 
	<tr> 
		<td>제목</td>
		<td><input type='text' name='title' value='${boardVO.getTitle() }'/></td> 
	</tr> 
	<tr> 
		<td>작성자</td>
		<td>${boardVO.getWriter() }</td> 
	</tr> 
	<tr> 
		<td>내용</td>
		<td><textarea name='content' cols='40' rows='10'>${boardVO.getContent() }</textarea></td> 
	</tr>
		<tr> 
		<td colspan='2' align='center'><input type='submit' value='수정하기'/></td> 
	</tr> 
</table> 
</form> 
<hr> 
</center> 
</body> 
</html>
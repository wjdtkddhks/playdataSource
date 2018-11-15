<%@page contentType="text/html; charset=utf-8"%> 
<html> 
	<head> 
	<title>새글등록</title> 
</head> 
<body> 
<center> 
<h3>새글 등록하기</h3> 
<hr> 
<form action="board.do?method=addBoard" method="post"> 
<table border="1" cellpadding="0" cellspacing="0"> 
	<tr> 
		<td>제목</td>
		<td><input type="text" name="title"/></td> 
	</tr> 
	<tr> 
		<td>작성자</td>
		<td><input type="text" name="writer" size="10"/></td> 
	</tr> 
	<tr> 
		<td>내용</td>
		<td><textarea name="content" cols="40" rows="10"></textarea></td> 
	</tr> 
	<tr> 
		<td colspan="2" align="center"><input type="submit" value=" 새글 등록 "/></td> 
	</tr> 
</table> 
</form> 
<hr> 
</center> 
</body> 
</html>
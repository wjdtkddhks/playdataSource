<%@page contentType="text/html; charset=utf-8"%> 
<%
	String loginIs = (String)request.getAttribute("loginIs");
	if(loginIs != null && loginIs.equals("fail")){
%>
	<script>
		alert("로그인 실패");
	</script>
<% 
	}else if(loginIs != null && loginIs.equals("logout")){
%>
	<script>
		alert("로그아웃되었습니다.");
	</script>
<%
	}
%>
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	<title>로그인</title> 
</head> 

<body> 
<center> 
<h3>Login 하세요</h3> 
<hr> 
<form action="user.do?method=login" method="post"> 
<table border="1" cellpadding="0" cellspacing="0"> 
	<tr> 
		<td>아이디</td>
		<td><input type="text" name="id"/></td> 
	</tr> 
	<tr> 
		<td>비밀번호</td>
		<td><input type="password" name="password"/></td> 
	</tr> 
		<tr> 
		<td align="center" colspan="2"> <input type="submit" value="로그인"/> </td> 
	</tr> 
</table> 
</form> 
<hr> 
</center> 
</body> 
</html>
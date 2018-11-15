<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
 	if(request.getAttribute("loginIs") != null){
		String loginIs = (String)request.getAttribute("loginIs");
 		if(loginIs.equals("joinSuccess")){
%>
			<script>
				alert('가입에 성공하였습니다!');
	  		</script>
<% 
		}else if(loginIs.equals("joinFail")){
%>
		<script>
			alert('가입에 실패하였습니다!');
  		</script>
<% 
		}else if(loginIs.equals("passFail")){
%>
		<script>
			alert('패스워드를 다시 입력하세요!');
  		</script>
<% 
		}else if(loginIs.equals("allFail")){
%>
		<script>
			alert('존재하지 않는 아이디입니다.!');
  		</script>
<%
	}}
%>

<html>
<head>
<title>회원관리 시스템 로그인 페이지</title>
<script language="javascript">
function check_input()
{
	var str, i, ch;
	// 아이디 체크 ----> 
	if (document.loginform.id.value == "")
	{
		alert("아이디를 입력하세요!!!");
		document.loginform.id.focus();
		return;
	}
	else
	{
		str = document.loginform.id.value;
		
		for (i=0; i<str.length; i++)
		{
			ch = str.substring(i, i+1);
			if (!((ch >= "0" && ch <= "9") || (ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z")))
			{
				alert("특수문자가 포함, 다시 입력!!!");
				document.loginform.id.focus();
				return;
			}
		}
	} // 아이디 체크 <------
	
	// 패스워드 체크 ------>
	if (document.loginform.password.value == "")
	{
		alert("패스워드를 입력하세요!!!");
		document.loginform.password.focus();
		return;
	}
	else
	{
		str = document.loginform.password.value;
		
		for (i=0; i<str.length; i++)
		{
			ch = str.substring(i, i+1);
			if (!((ch >= "0" && ch <= "9") || (ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z")))
			{
				alert("특수문자가 포함, 다시 입력!!!");
				document.loginform.password.focus();
				return;
			}
		}
	} // 패스워드 체크 <------
	
	//return true;
	loginform.submit();
}
</script>
</head>
<body>
<form name="loginform" action="member.mo?method=userCheck" method="post">
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>로그인 페이지</font></b>
		</td>
	</tr>
	<tr><td>아이디 : </td><td><input type="text" name="id"/></td></tr>
	<tr><td>비밀번호 : </td><td><input type="password" name="password"/></td></tr>
	<tr>
		<td colspan="2" align=center>
			<a href="javascript:check_input()">로그인</a>&nbsp;&nbsp;
			<a href="member.mo?method=joinForm">회원가입</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>

<%@ page contentType="text/html; charset=utf-8" %>
<%
	String email=(String)request.getAttribute("email");
	int check=((Integer)(request.getAttribute("check"))).intValue();
%>
<html>
<head>
<title>이메일 중복체크</title>
<script>
function windowclose()
{
	opener.document.joinform.MEMBER_EMAIL.value="<%=email %>";
	self.close();
	opener.document.joinform.push.value=1;
}
</script>
</head>

<body bgcolor="#f5f5f5">
<% if(check == 1){ %>
<table width="480" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
	<td height="30">
		<font size="2"><%=email %> 는 이미 사용 중인 이메일입니다.</font>
	</td>
	</tr>
</table>
<form action="./MemberEMAILCheckAction.me" method="post" name="checkForm" >
<table width="480" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<font size="2">다른 이메일을 선택하세요.</font><p>
		<input type="text" size="20" maxlength="20" name="MEMBER_EMAIL"/>
		<input type="submit" value="중복확인" />
	</td>					
	</tr>
</table>
</form>
<% }else{ %>
<table width="480" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		<font size="2">입력하신 <%=email %> 는 사용할 수 있는 이메일입니다.</font>
		<br/><br/>
		<input type="button" value="닫기" onclick="windowclose()" />
		</td>
	</tr>
</table>
<% } %>
</body>
</html>
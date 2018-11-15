<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='color.jsp' %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
%>
<html>
<head>
	<title>글 수정</title>
	<script src='jquery-3.3.1.js' ></script>
		<style>
		body{
			background-color: <%=bodyback_c%>;
			text-align: center;
		}
		table{
			width: 360;
			border-spacing: 0;
			padding: 0;
			background-color: <%=bodyback_c%>;
			margin: 10px auto;
		}
		.td_subject{
			text-align: center;	
			background-color: <%=value_c%>;
			font-weight: 700;
		}
	</style>
	<script>
		function passwdCheck(){
			if(document.upForm.passwd.value == ""){
				alert("패스워드를 입력해주세요.");
				document.upForm.passwd.focus();
				return false;
			}
			return true;
		}
		
		$(document).ready(function(){
			$('#list').click(function(){
				opener.document.location.href="list.jsp?pageNum=<%=pageNum %>";
				window.close();
			});
		});
	</script>
</head>
<body>
	<b style='color:<%=title_c %>'>글 수정</b>
	<form name='upForm' action='updatePro1.jsp?pageNum=<%=pageNum %>' method='post' onsubmit='return passwdCheck()' >
		<table border='1'>
			<tr height='30'><td class='td_subject'>비밀번호를 입력해주세요</td></tr>
			<tr height='30'>
				<td align='center'> 비밀번호 : <input type='password' name='passwd' size='8' maxlength='12' />
				<input type='hidden' name='num' value='<%=num %>' /></td>
			</tr>
			<tr height='30'>
				<td class='td_subject'><input type='submit' value='글 수정' />&nbsp;
				<input type='button' value='글 목록' id='list' onclick=/></td>
			</tr>
		</table>
	</form>
</body>
</html>
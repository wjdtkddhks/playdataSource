<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="board.ArticleDB"%>
 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delete article password check</title>
<script>
	function check(){
		var passwd = document.delForm.passwd.value;
		if(passwd.length < 4 || passwd.length > 8){
			alert("비밀번호는 숫자 4~8자리로 구성되어 있습니다.");
			document.delForm.passwd.focus();
			return false;
		}
		for(var i=0; i<passwd.length; i++){
			var pwchr = passwd.charAt(i);
			if(pwchr < '0' || pwchr > '9'){
				alert("비밀번호는 숫자로만 구성되어 있습니다.");
				document.delForm.passwd.focus();
				return false;	
			}
		}
		return true;
	}
</script>
<style>
	body{
		text-align: center;
	}
	table{
		width: 300px;
		margin: 20px auto;	
		text-align: center;
	}
	.td_subject{
		background-color : yellow;
		height: 30px;
	}
	table, td{
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<form method='post' name='delForm' action='deletePro.jsp' onsubmit='return check();' >
	<input type='hidden' name='num' value='<%=request.getParameter("num")%>' />
	<input type='hidden' name='pageNum' value='<%=request.getParameter("pageNum")%>' />
	<table>
		<tr><td class='td_subject'>비밀번호를 입력해주세요. </td></tr>
		<tr>
			<td height='40px'><input type='password' name='passwd' autofocus /></td>
		</tr>
		<tr>
			<td class='td_subject'><input type='submit' value='확인' />
			<input type='button' value='취소' onclick="window.close();" /></td>
		</tr>
	</table> 
</form>

</body>
</html>
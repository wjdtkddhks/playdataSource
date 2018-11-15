<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
		request.setCharacterEncoding("UTF-8"); 
		String pageNum = request.getParameter("pageNum"); 
		
		int num=0, ref=0, ref_step=0, ref_level=0;
		
		String numStr = request.getParameter("num");
		
		if(numStr != null){
			num = Integer.parseInt(numStr);
			ref = Integer.parseInt(request.getParameter("ref"));
			ref_step = Integer.parseInt(request.getParameter("ref_step"));
			ref_level = Integer.parseInt(request.getParameter("ref_level"));
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css" rel="stylesheet">
<script src="../jquery-3.3.1.js"></script>
<script>
	$(function(){
		$('#selboxDirect').hide();
	
		$('#email2').change(function(){
			if($('#email2').val() == 'direct'){
				$('#selboxDirect').show();
			}else
				$('#selboxDirect').hide();
		});
	});
	
	function check(){
		var writer = document.form1.writer.value;
		if(writer.length == 0){
			alert("작성자 이름을 입력해주세요.");
			document.form1.writer.focus();
			return false;
		}
		
		var subject = document.form1.subject.value;
		if(subject.length == 0){
			alert("제목을 입력해주세요.");
			document.form1.subject.focus();
			return false;
		}
		
		var email1 = $('#email1').val();
		if(email1.length == 0){
			alert("이메일 앞부분을 입력해주세요.");
			document.form1.email1.focus();
			return false;
		}
		for(var i=0; i<email1.length; i++){
			var echr = email1.charAt(i);
			if(echr == '@'){
				alert("이메일 앞부분을 확인해주세요.");
				document.form1.email1.focus();
				return false;
			}
		}
		//email 앞부분 체크 끝!
		
		var email2 = $('#email2').val();
		if(email2.length == 0){
			alert("이메일 뒷부분을 선택해주세요.");
			document.form1.email2.focus();
			return false;
		}
		//email 뒷부분 체크 끝!
		
		var j=0;
		for(var i=0; i<document.form1.grade.length; i++){
			
			if(document.form1.grade[i].checked == true){
				j++;
			}
		}
		if(j != 1){
			alert("추천지수는 하나만 체크해주세요.");
			document.form1.grade[0].focus();
			return false;
		}
		//추천지수 체크 끝!
		
		var passwd = $('#passwd').val();
		if(passwd.length < 4 || passwd.length > 8){
			alert("비밀번호 입력갯수를 확인해주세요.");
			document.form1.passwd.focus();
			return false;
		}
		for(var i=0; i<passwd.length; i++){
			var pwchr = passwd.charAt(i);
			if(pwchr < '0' || pwchr > '9'){
				alert("비밀번호는 숫자로만 입력해주세요.");
				document.form1.passwd.focus();
				return false;	
			}
		}
		//패스워드 체크 끝!
		var textArea = document.form1.content.value;
		if(textArea.length == 0){
			alert("감상평을 입력해주세요.");
			document.form1.content.focus();
			return false;
		}//감상평 체크 끝!
		
		return true;
	}
	
	
</script>
<style>
	body{
		text-align: center;
	}
	table{
		width: 600px;
		margin: 20px auto;	
	}
	.td_subject{
		width: 100px;
		height: 30px;
		text-align: center;
	}
	.td_content{
		width: 500px;
		height: 30px;
		text-align: left;	
	}
	table, td{
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<form name='form1' action='writePro.jsp' onsubmit='return check();'>
<input type='hidden' name='pageNum' value='<%=pageNum %>' />
<input type='hidden' name='num' value='<%=num %>' />
<input type='hidden' name='ref' value='<%=ref %>' />
<input type='hidden' name='ref_step' value='<%=ref_step %>' />
<input type='hidden' name='ref_level' value='<%=ref_level %>' />
<table>
	<tr>
		<td class='td_subject'> 작성자 </td>
		<td class='td_content'>&nbsp;<input type="text" id='writer' name='writer' autofocus/></td>
	</tr>
	<tr>
		<td class='td_subject'> 제 목 </td>
		<td class='td_content'>&nbsp;<input type="text" id='subject' name='subject'
<%
		if(numStr != null){
%>
		value='[답글]'
<%
		}
%>				
		/></td>
	</tr>
	<tr>
		<td class='td_subject'> 이메일 </td>
		<td class='td_content'>&nbsp;<input type="text" id='email1' name='email1' /> <font size=4>@</font> 
		<input type='text' id='selboxDirect' name='email2sub' />
		<select id='email2' name='email2'>
			<option value="">--메 일 선 택--</option>
			<option value='naver.com'>naver.com</option>
			<option value='hanmail.net'>hanmail.net</option>
			<option value='gmail.com'>gmail.com</option>
			<option value='direct'>--직 접 입 력--</option>
		</select>
		</td>
	</tr>
	<tr>
		<td class='td_subject'>추천지수</td>
		<td class='td_content'>&nbsp;<input type="checkbox" name='grade' value='BEST'/> BEST
		<input type="checkbox" name='grade' value='GOOD'/> GOOD
		<input type="checkbox" name='grade' value='NORMAL'/> NORMAL
		<input type="checkbox" name='grade' value='BAD' /> BAD
		<input type="checkbox" name='grade' value='WORST' /> WORST </td>
	</tr>
	<tr>
	<td class='td_subject'>감상평</td>
	<td class='td_content'>&nbsp;
	<textarea name='content' cols='65' rows='20' placeholder='멋진 감상평을 적어주세요 ^^'></textarea></td></tr>
	<tr>
		<td class='td_subject'>비밀번호</td>
		<td class='td_content'>&nbsp;<input type="password" id='passwd' name='passwd' maxlength='8' />
		<font size=2>(최소 4자리에서 8자리이하 숫자로 입력해주세요.)</font></td>
	</tr>
</table>
	<input type='submit' value='작성' />&nbsp;&nbsp;
	<input type='reset' value='취소' />&nbsp;&nbsp;
	<input type='button' value='목록 보기' 
	onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'" />
</form>
</body>
</html>
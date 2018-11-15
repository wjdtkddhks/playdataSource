<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.ArticleDB" %>
<%@ page import="board.ArticleData" %>
<% 
		request.setCharacterEncoding("UTF-8"); 
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum"); 
		
		ArticleDB manager = ArticleDB.getInstance();
		ArticleData article = manager.getArticle(num, 1);
		String email = article.getEmail();
		String[] emailArr = email.split("@", 2);
		String email1 = emailArr[0];
		String email2 = emailArr[1];
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
			if($('#email2').val() == 'direct'){
				$('#selboxDirect').show();
			}else
				$('#selboxDirect').hide();
			
			$('#email2').change(function(){
				if($('#email2').val() == 'direct'){
					$('#selboxDirect').show();
				}else
					$('#selboxDirect').hide();
			});
	});
	
	function check(){
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
				j++;}
		}
		if(j != 1){
			alert("추천지수는 하나만 체크해주세요.");
			document.form1.grade[0].focus();
			return false;
		}
		//추천지수 체크 끝!
		
		var passwd = $('#passwd').val();
		if(!(passwd.equals(<%=article.getPasswd()%>))){
			alert("비밀번호가 일치하지 않습니다. 확인해주세요.");
			document.form1.passwd.focus();
			return false;
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
<form name='form1' action='updatePro.jsp' onsubmit='return check();'>
<input type='hidden' name='pageNum' value='<%=pageNum %>' />
<input type='hidden' name='num' value='<%=num %>' />
<table>
	<tr>
		<td class='td_subject'> 작성자 </td>
		<td class='td_content'> <%=article.getWriter()%></td>
	</tr>
	<tr>
		<td class='td_subject'> 제 목 </td>
		<td class='td_content'> <input type="text" id='subject' name='subject' value='<%=article.getSubject() %>' /></td>
	</tr>
	<tr>
		<td class='td_subject'> 이메일 </td>
		<td class='td_content'>&nbsp;<input type="text" id='email1' name='email1' value='<%=email1%>' /> <font size=4>@</font> 
		<input type='text' id='selboxDirect' name='email2sub' <%if(!(email2.equals("naver.com") || email2.equals("hanmail.net") || email2.equals("gmail.com"))){%> value='<%=email2%>' <%}%>/>
		<select id='email2' name='email2'>
			<option value="">--메 일 선 택--</option>
			<option value='naver.com' <%if(email2.equals("naver.com")){%> selected <%}%>>naver.com</option>
			<option value='hanmail.net' <%if(email2.equals("hamail.net")){%> selected <%}%>>hanmail.net</option>
			<option value='gmail.com' <%if(email2.equals("gmail.com")){%> selected <%}%>>gmail.com</option>
			<option value='direct' <%if(!(email2.equals("naver.com") || email2.equals("hanmail.net") || email2.equals("gmail.com"))){%> selected <%}%>>--직 접 입 력--</option>
		</select>
		</td>
	</tr>
	<tr>
		<td class='td_subject'>추천지수</td>
		<td class='td_content'>
		<input type="checkbox" name='grade' value='BEST' <%if(article.getGrade().equals("BEST")){%> checked <%}%> /> BEST
		<input type="checkbox" name='grade' value='GOOD' <%if(article.getGrade().equals("GOOD")){%> checked <%}%> /> GOOD
		<input type="checkbox" name='grade' value='NORMAL' <%if(article.getGrade().equals("NORMAL")){%> checked <%}%> /> NORMAL
		<input type="checkbox" name='grade' value='BAD'  <%if(article.getGrade().equals("BAD")){%> checked <%}%> /> BAD
		<input type="checkbox" name='grade' value='WORST'  <%if(article.getGrade().equals("WORST")){%> checked <%}%> /> WORST </td>
	</tr>
	<tr>
	<td class='td_subject'>감상평</td>
	<td class='td_content'>
	<textarea name='content' cols='65' rows='20' placeholder='멋진 감상평을 적어주세요 ^^'><%=article.getContent() %></textarea></td></tr>
	<tr>
		<td class='td_subject'>비밀번호</td>
		<td class='td_content'> <input type="password" id='passwd' name='passwd' maxlength='8' />
		<font size=2>(최소 4자리에서 8자리이하 숫자로 입력해주세요.)</font></td>
	</tr>
</table>
	<input type='submit' value='수정' />&nbsp;&nbsp;
	<input type='reset' value='취소' />&nbsp;&nbsp;
	<input type='button' value='목록 보기' 
	onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'" />
</form>
</body>
</html>
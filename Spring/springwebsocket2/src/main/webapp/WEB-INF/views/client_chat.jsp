<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
	request.setCharacterEncoding("utf-8");
	if (session.getAttribute("id") == null){
		out.println("<script>");
		out.println("location.href='loginForm.do'");
		out.println("</script>");
	}
	String name = (String)session.getAttribute("name");
	
%>

<!DOCTYPE html>
<html>
<head>
<title>WebSocket</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<style>
	.list-group{
		width: 100px;
		text-align: center;
	}
</style>
</head>
<body>
<div class="list-group">
  <a href="./client_chat_seoul.do?region=seoul" class="list-group-item list-group-item-action">서울</a>
  <a href="./client_chat_seoul.do?region=incheon" class="list-group-item list-group-item-action">인천</a>
  <a href="#" class="list-group-item list-group-item-action">경기도</a>
  <a href="#" class="list-group-item list-group-item-action">대전</a>
  <a href="#" class="list-group-item list-group-item-action">충청도</a>
  <a href="#" class="list-group-item list-group-item-action">대구</a>
  <a href="#" class="list-group-item list-group-item-action">경상도</a>
  <a href="#" class="list-group-item list-group-item-action">강원도</a>
  <a href="#" class="list-group-item list-group-item-action">광주</a>
  <a href="#" class="list-group-item list-group-item-action">전라도</a>
  <a href="#" class="list-group-item list-group-item-action">제주도</a>
  <a href="#" class="list-group-item list-group-item-action">부산</a>
</div>
	<input type='text' id='input' placeholder='input message...' size='55' />
	<button id='send_button'>SEND</button>
	대화명 : <%=name%>
	<p/>
	<textarea id='output' readonly rows='30' cols='80'>채팅방을 선택해주세요</textarea>
	<textarea id='nameList' readonly rows='30' cols='40'></textarea>
</body>
</html>
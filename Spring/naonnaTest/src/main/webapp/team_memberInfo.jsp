<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.spring.naonnaTest.user.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<% request.setCharacterEncoding("utf-8"); %> 
 <%
    UserVO info = (UserVO)request.getAttribute("teamuserinfo");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 보기</title>

<style>
	body{
	   background-color: #111;
       color: #DDD;  
       opacity: 0.9;
	}
	.memberinfo{
		margin: 20px 10px 10px 10px;
		padding: 15px;
		border: 3px solid #A52A2A;
	}
	.info_title{
		text-align: center;
		font-size: 18px;
		letter-spacing: 1.6px;
		font-weight: 560;
	}
	.info_body{
		font-size: 14px;
		margin-top: 10px;
	}
	.letter2{
		margin-right: 60px;
	}
	.letter3{
		margin-right: 45px;
	}
	.letter4{
		margin-right: 30px;
	}
</style>
</head>
<body>

	<div class="memberinfo">
		<div class="info_title">유저정보</div><hr>
		<div class="info_body">
			<label class="letter3">닉네임</label>
			<%=info.getNickname()%>
		</div>
		
		<div class="info_body">
			<label class="letter3">이메일</label>
			<%=info.getEmail()%>
		</div>
		
		<div class="info_body">
			<label class="letter4">활동지역</label>
			<%=info.getCity()%> 
		</div>
		
		<div class="info_body">
			<label class="letter2">성별</label>
			<%=info.getGender()%> 
		</div>
		
		<div class="info_body">
			<label class="letter2">나이</label>
			<%=info.getAge()%>
		</div>
		
		<div class="info_body"> 
			<label class="letter2">팀명</label>
			<%=info.getTeamName() %>
		</div>
		
		<div class="info_body">
			<label class="letter3">포지션</label>
			<%=info.getPosition() %>
		</div>
	</div>

</body>
</html>
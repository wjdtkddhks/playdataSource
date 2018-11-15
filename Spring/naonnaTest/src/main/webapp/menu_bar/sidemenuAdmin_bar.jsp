<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	String admin = (String)session.getAttribute("admin");			
	String ground_name = (String)session.getAttribute("groundName");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<style>
	.bf_login{
		background-color: black;
		color: white;
		padding-bottom: 15px;
		opacity: 0.9;
	}
	.bf_login a, .bf_login a:hover{
		text-decoration: none;
		color: white;
	}
	.bf_login a:hover{
		color: red;
	}
	.admintext{
		margin-top: 10px;
	}
</style>
</head>
<body>
      <div class="card side-profile">
       	<div class="bf_login">
	        <img id="profileImage" src="https://i.pinimg.com/564x/16/18/70/1618700be54bdc00cffd16c05766c155.jpg" alt="John" style="width:100%">
	        <h1><%=admin %></h1> 안녕하세요 환영합니다.<br/>
					<p class="admintext"><a href="manager.do?admin=<%=admin %>" id="register">관리자페이지</a></p>				
					<p><a href="#" id="booking"></a></p>
			<%if(session.getAttribute("admin") == null){ %>
					<button id="login-button" type="button" data-toggle="modal" data-target="#LoginModal" name="login_btn">Login</button>
			<%}else{%>	
					<a href="logout_a.do">로그아웃</a>
			 <%} %>			
        </div>
      </div>
</body>
</html>
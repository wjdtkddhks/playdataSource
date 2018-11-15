<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>

<body>
  <!-- Top menu -->
  <nav class="top_menu navbar-default navbar-fixed-top">
  
    <!-- Logo div -->
    <div class="navbar-header">
      <a class="navbar-brand" href="home.do">NAONNA</a>
    </div>

    <!-- Main menu -->
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="ground_info.do" class="firstMenu">대관신청</a></li>
        
		<li><a href="matching_search.do" class="firstMenu">매칭신청</a></li>
		
		<li><a href="team_search.do" class="firstMenu">팀관리</a></li>

        <li class="dropdown">
          <a class="dropdown-toggle firstMenu" data-toggle="dropdown" href="#">고객센터
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="notice.do" class="secondMenu">공지사항</a></li>
            <li><a href="faq.do" class="secondMenu">FAQ</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</body>
</html>
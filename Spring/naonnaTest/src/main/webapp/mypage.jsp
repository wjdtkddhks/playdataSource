<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="utf-8">

<head>
  <!-- NAONNA -->
  <title>NAONNA 경기장예약 매칭 사이트 </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aecd4acbce2512282f0d82282be7ebb3"></script>
  <link href="${pageContext.request.contextPath}/resources/naonna_main.css" rel="stylesheet" type="text/css"/>
  
  <script>
	$(document).ready(function() {
		
		$('#nickname').text('${info.nickname}');
		$('#nickname2').attr('value', '${info.nickname}');
		$('#nickname1').attr('value', '${info.nickname}');
		if('${info.teamName}' == "") {
			$('#teamname').text("현재 소속된 팀이 없습니다.");
		}
		else {
			$('#teamname').text('${info.teamName}');
		}
		
		$('#email').attr("value", '${info.email}');
		$('#gender').text('${info.gender}');
		$('#age').attr("value", '${info.age}');
		$('#city').attr("value", '${info.city}');
		
		if('${info.position}' == '') {
			$('#position').attr("placeholder", "뛰고싶은 포지션을 입력하세요");
		}
		else {
			$('#position').attr("value", '${info.position}');
		}
	
	});
</script>

<style>
	.monami {
		background-image : url("https://i1.wp.com/thesefootballtimes.co/wp-content/uploads/2016/03/55f80d2448bdd.jpg?fit=1500%2C900&ssl=1");
		height: 727px;
	}
	.main {
        margin-top : 150px;
     }
     .mypage{
     	background-color: #111;
	    color: #DDD;
	    padding: 15px;
	    border: 3px solid #A52A2A;
	    opacity: 0.9;
     }
     .mypageTitle{
     	color: white;
		font-weight: 600;
		font-size: 30px;
		margin-left: 15px;
		margin-bottom : 30px;
     }
     input[name=email] {
     	margin-left : 0;
     }
     .letterArea {
     	margin-top : 8px;
     }
     #picControl1 {
     	display : inline-block;
     	width : 55%;
     	height: 40px;
     }
     #picControl2{
     	display : inline-block;
     	width : 23%;
     	margin : -10px 0 0 10px;
     	height : 40px;
     	background-color : red;
     	border-color : red;
     	color : white;
     }
     .mypage_button{
     	background-color : red;
     	border-color : red;
     	color : white;
     	border-radius : 4px;
     	height : 40px;
     	margin : 20px 0 10px 300px;
     	border:none;
     	outline:0;
     	
     }
     .mypage_label {
     	text-align : left;
     }
</style>
</head>

<body>
   <jsp:include page="./menu_bar/topnavi.jsp" flush="true"></jsp:include>
 	<div class="monami">
 	<div class="col-sm-2">
		<div class="row">
		<jsp:include page="./menu_bar/sidemenu_bar.jsp" flush="true"></jsp:include>
		</div>
	</div>
	
	<form name="kakaoId">
		<input type="hidden" name="kakao_Id">
	</form>
	
	<div class="main col-sm-10">
     <div class="col-sm-8 col-sm-offset-2">
      <div class="mypage">
         <div class="mypageTitle">
            <p>마이페이지</p>
         </div>
         <form class="form-horizontal" id="mypageForm" action="update_profile.do" method="post" enctype="multipart/form-data">
               <input type="hidden" name="nickname" id="nickname1">
               <input type="hidden" name="kakao_Id">
               <div class="form-group">
               	<label class="mypage_label col-sm-3 control-label">프로필 이미지</label>
               		<div class="col-sm-9"> 
               			<input type="file" id="picControl1" class="form-control" name="imgfile" />
               			<input type="submit" id="picControl2" class="form-control" value="사진 변경 " />
               		</div>
               			  
               	</div>    	  
       	 </form>
            <form class="form-horizontal" id="mypageForm2" action="update_userinfo.do" method="post">
               <input type="hidden" name="kakao_Id">
               <input type="hidden" name="nickname" id="nickname2">
               <div class="form-group">
               	<label class="mypage_label col-sm-3 control-label">닉네임</label>
               		<div class="col-sm-7 letterArea"> 
                  		<span name="nickname" id = "nickname"> </span>
               		</div>  
               	</div> 
               <div class="form-group">
                  <label class="mypage_label col-sm-3 control-label">이메일</label>
                  <div class="col-sm-5"> 
                  	<input type="email" class="form-control" name="email" id="email">
                  </div> 
               </div>
               <div class="form-group">
                  <label id="locControl"class="mypage_label col-sm-3 control-label">활동지역</label>
                  <div class="col-sm-3"> 
                  	<input type="text" class="form-control" name="city" id = "city">
                  </div> 
               </div>
               <div class="form-group">
                  <label class="mypage_label col-sm-3 control-label">성별</label>
                  <div class="col-sm-3 letterArea"> 
                  	<span name="gender" id="gender"> </span>
                  </div> 
               </div>
               <div class="form-group">
                  <label class="mypage_label col-sm-3 control-label">나이</label>
                  <div class="col-sm-3"> 
                  	<input type="number" class="form-control" name="age" id="age">
                  </div> 
               </div>
               <div class="form-group">
                  <label class="mypage_label col-sm-3 control-label">팀명</label>
                  <div class="col-sm-5 letterArea"> 
                  	<span name ="teamName" id = "teamname"> </span>
                  </div> 
               </div>
               <div class="form-group">
                  <label class="mypage_label col-sm-3 control-label">포지션</label>
                  <div class="col-sm-5"> 
                  	<input type="text" class="form-control" name="position" id="position">
                  </div> 
               </div>   
               <div>
                  <button type="submit" class="mypage_button">회원정보 변경</button>
               </div>
            </form>
      </div>
   </div>
   </div>
   </div>
</body>

</html>
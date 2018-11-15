<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.spring.naonnaTest.ground.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<% request.setCharacterEncoding("utf-8"); %> 

<%
String admin = (String)session.getAttribute("admin");
String ground_name = (String)session.getAttribute("groundName");
String nickname = (String)session.getAttribute("nickname");
%>

 <% 
 GroundVO vo = (GroundVO)request.getAttribute("vo"); 	
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- 캘린더 라이브러리-->
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<!-- 캘린더 라이브러리-->
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<!-- 캘린더 라이브러리-->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/naonna_main.css">
  
  <style>
   * {
     box-sizing: border-box;
   }
   body {
  	font-family: Arial;
  	margin: 0;
  	overflow-x: hidden;
  	}
  	html, body {
  		max-width : 100%;
  	}
   
  
   .monami {
       background-image : url("https://lh3.googleusercontent.com/-hrYUHGyoYz4/WIz2mUMTahI/AAAAAAAABNM/d6u3yCje50EBAzYhVFMM3nkPCzjYXtCFACJoC/w1366-h768/Download-Fernando-Torres-Free-HD-Football-Wallpapers_Fotor.jpg");
       height : 1200px;
       background-attachment: fixed;
     }
   .main {
      margin-top : 80px;
   }
   img {
     vertical-align: middle;
   }
   
   .ground_name {
   		display : inline-block;
   		font-size : 24px;
   		font-weight : 550;
   		margin-top : 15px;
   		margin-left : 350px;
   		color : #DDD;
   }
   .ground_addr {
   		display : inline-block;
   		font-size : 18px;
   		font-weight : 500;
   		margin-left : 20px;
   		color : #DDD;
   }
   /* Hide the images by default */
   .mySlides {
      width : 100%;
     display: none;
   }
   .mySlides img {
      width : 100%;
      height : 400px;
   }
   
   /* Add a pointer when hovering over the thumbnail images */
   .cursor {
     cursor: pointer;
   }
   
   /* Next & previous buttons */
   .prev,
   .next {
     cursor: pointer;
     position: absolute;
     top: 40%;
     width: auto;
     padding: 16px;
     margin-top: -50px;
     color: white;
     font-weight: bold;
     font-size: 30px;
     border-radius: 0 3px 3px 0;
     user-select: none;
     -webkit-user-select: none;
   }
   
   /* Position the "next button" to the right */
   .next {
     left: 855px;
     border-radius: 3px 0 0 3px;
   }
   
   /* On hover, add a black background color with a little bit see-through */
   .prev:hover,
   .next:hover {
     background-color: rgba(0, 0, 0, 0.8);
   }
   
   /* Number text (1/3 etc) */
   .numbertext {
     color: #f2f2f2;
     font-size: 12px;
     padding: 8px 12px;
     position: absolute;
     top: 0;
   }
   
   /* Container for image text */
   .caption-container {
     width : 100%;
     text-align: center;
     background-color: #222;
     padding: 2px 16px;
     color: black;
   }
   .row {
      width : 100%;
      margin-left : 0px;
   }
   #row2 {
   		margin-top : -10px;
   }
   .row:after {
     content: "";
     display: table;
     clear: both;
   }
   /* Six columns side by side */
   .column {
     float: left;
     width: 33.33%;
   }
   .row img {
      height :133.8px;
   }
   
   /* Add a transparency effect for thumnbail images */
   .demo {
     opacity: 0.6;
   }
   .demo .cursor{
      height : 100%;
   }
   .active,
   .demo:hover {
     opacity: 1;
   }
   .ground-detail-size {
   	margin-top : 50px;
   	padding : 0;
   	margin-bottom : 40px;
   }
   
   .ground-detail-contents {
   	margin-top : 15px;
   	padding : 15px 0 0 0;
   	color : #ddd;
   }
   .ground-detail-contents .container p{
   		font-size : 20px;
   		font-weight : 500;
   }
   .addr_t {
   		margin-left : 20px;
   }
   .ground-detail {
      margin-top : 10px;
      padding : 0;
   }
   .ground-detail-icon img {
      width : 60px;
      height :60px;
   }
   .ground-detail-texts {
      margin-top : 20px;
   }
   .ground-detail-textmore {
      margin : 20px 10px;
      text-align : center;
   }
   .ground-detail-textmore p {
      color : black;
      font-weight : 500;
      font-size : 15px;
   }
   .ground-detail-size-texts {
      display : inline-block;
      width : 400px;
      margin : 10px 30px 0px;
   }
   .ground-detail-size-fieldtext, .ground-detail-size-formaltext {
      display :inline-block;
      
   }
   
   .formal-ground-size {
      width : 100%;
      height : 270px;
   }
   .small-box {
      width : 17px;
      height : 10px;
      display : inline-block;
      margin : 0 0 0 15px;
   }
   .gray-box {
      background-color : #dedede;
   }
   .green-box {
      background-color: #466626;
   }
   .ground-detail-size-fieldtext p, .ground-detail-size-formaltext p{
      color : #ddd;
      font-size : 10px;
      display : inline-block;
      margin-left : 3px;
   }
   .ground-detail-addr {
      margin-top : 30px;
   }
   .ground-detail-addr p {
      text-align : center;
   }
   .ground-notice {
      margin-left : 40px;
   }
   .ground-notice h2 {
      font-weight : 700px;
      letter-spacing : 3px;
      margin-bottom : 20px;
      margin-top : 20px;
   }
   ul {
      list-style-type : none;
      
   }
   .side_m {
   		margin-left : -15px;
   		padding : 0;
   }
   .ground-notice-1 ul li, .ground-notice-3 ul li{
      margin :  0 0 10px -20px;
      font-size : 12px;
   }
   .ground-pics {
     margin-top : 20px;
     padding : 0;
   }
   .payment, .back-to-list {
      display : inline-block;
      float: right;
      margin-bottom: 15px;
   }
   .back-to-list{
   	margin-right: 25px;
   }
   .contents-row{
   		margin-top : 20px;
   }
   .contents-row p {
   		color : #ddd;
   }
   .form-control {
   		display : inline-block;
   		height : 30px;
   }
   #search_matching {
   		height : 29px;
   }
	#timer h6 {
		display : inline;
	}
   #datePick, #hours {
   	width : 100px;
   	margin-left : 20px;
   	margin-right : 40px;
   	display : inline-block;
   	color : black;
   }
   
   .ground-header th{
		text-align:center;
		height: 30px;
		font-size:15px;
	}
	.ground-body tr, td{
		text-align:center;
		border-bottom: 1px solid silver;
		verticle-align:middle;
		height: 30px;
	}
	.groundValue {
		margin-left : 20px;
	}
  </style>
  <script>
	$(document).ready(function() {
			function printGround() {
				$('#ground_print').empty();
				$.ajax({
					url:'/naonnaTest/getGroundJSON.do',
					type:'POST',
					dataType: "json",
					contentType : 'application/x-www-form-urlencoded; charset=utf-8',
					//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
					success:function(data) {
						$.each(data, function(index, ground) {
							var output = '';
							output += '<tr>';
							output += '<td> <a link href="ground_detail.do?ground_Name='+ground.ground_Name + '">' + ground.ground_Name  + '</td>';
							output += '<td>' + ground.ground_addr + '</td>';
							output += '<td>' + ground.grass + '</td>';
							output += '<td>' + ground.shower + '</td>';
							output += '<td>' + ground.parking + '</td>';
							output += '<td>' + ground.light + '</td>';
							output += '<td>' + ground.ground_size + '</td>';
							output += '<td>' + ground.ground_people + '</td>';
							output += '</tr>';
							console.log("output:" + output);
							$('#ground_print').append(output);												
						});						
					},
					error:function() {
						alert("새로고침을 눌러주세요.")
					}
				});
			}
			printGround();
			
          	 $(function() {
          		 
					var currentDate = new Date();
//					var tomorrow = currentDate.setDate(currentDate.getDate()+1);
        		  $('input[name="datetimes"]').daterangepicker({
					

        			singleDatePicker : true,
       		 		//timePicker: true,
        		    showDropdowns: true, 
        		    startDate: moment().startOf('hour'),
        		    minDate : currentDate,
//    		     endDate: moment().startOf('hour').add(0, 'hour'),
        		    locale: {
       		       format: 'YYYY/M/DD'
//         		    	format: 'YYYY/M/DD'

        		    }
        		  });
    		});
          	 
          	$('#time_Submit').click (function(){
          		
          		var startDate = new Date($('#datePick').val());
          		var assign = $('#hours').val();
          		assign = assign*1;
          		var endDate = new Date(startDate);
          		endDate.setHours(startDate.getHours() + 1);
          		goDAO_time(startDate, endDate);
          	});	
          	
          

	});
	
	function goDAO_time(startDate, endDate) {
		$.ajax({
			url:'/naonnaTest/time_ground_dao.do',
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data:{	'ground_addr':$('#sel1').val(),
					'ground_city':$('#sel2').val(),
				 	'grass' : $('#sel3').val(),
				 	'parking' : $('#sel4').val(),
				 	'shower' : $('#sel5').val(),
				 	'light' : $('#sel6').val(),
				 	'startTime' : startDate,
				 	'assign' : $('#hours').val(),
				 	'endTime' : endDate},
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			success:function(data) {
				
				$('#ground_print').html('');		//기존 것 날려주고..
				
				$.each(data, function(index, ground) {		//새로 뿌리기
					var output = '';
					output += '<tr>';
					output += '<td>' + ground.ground_Name + '</td>';
					output += '<td>' + ground.ground_addr + '</td>';
					output += '<td>' + ground.grass + '</td>';
					output += '<td>' + ground.shower + '</td>';
					output += '<td>' + ground.parking + '</td>';
					output += '<td>' + ground.light + '</td>';
					output += '<td>' + ground.ground_size + '</td>';
					output += '<td>' + ground.ground_people + '</td>';
					output += '</tr>';
					console.log("output:" + output);
					$('#ground_print').append(output);										
				});
				
				console.log(data);
			},
			error:function() {
				alert("ajax통신 실패!!");
			}
		});
	}
	
	function goDAO() {
		$.ajax({
			url:'/naonnaTest/filter_ground_dao.do',
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data:{	'ground_addr':$('#sel1').val(),
					'ground_city':$('#sel2').val(),
				 	'grass' : $('#sel3').val(),
				 	'parking' : $('#sel4').val(),
				 	'shower' : $('#sel5').val(),
				 	'light' : $('#sel6').val()},
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			success:function(data) {
				
				$('#ground_print').html('');		//기존 것 날려주고..
				
				$.each(data, function(index, ground) {		//새로 뿌리기
					var output = '';
					output += '<tr>';
					output += '<td>' + ground.ground_Name + '</td>';
					output += '<td>' + ground.ground_addr + '</td>';
					output += '<td>' + ground.grass + '</td>';
					output += '<td>' + ground.shower + '</td>';
					output += '<td>' + ground.parking + '</td>';
					output += '<td>' + ground.light + '</td>';
					output += '<td>' + ground.ground_size + '</td>';
					output += '<td>' + ground.ground_people + '</td>';
					output += '</tr>';
					console.log("output:" + output);
					$('#ground_print').append(output);
										
				});
				
				console.log(data);
			
			},
			error:function() {
				alert("ajax통신 실패!!");
			}
		});	
	
	}
	
</script>
  <script>
  
  
  
	  $(function() {
			 
			var currentDate = new Date();
		  $('input[name="datetimes"]').daterangepicker({
			
	
			singleDatePicker : true,
		 		timePicker: true,
		    showDropdowns: true, 
		    startDate: moment().startOf('hour'),
		    minDate : currentDate,
		    locale: {
		       format: 'YYYY/M/DD hh:00'
		    }
		  });
	});
	 
		function res3(){
			var startDate = new Date($('#datePick').val());
			var assign = $('#hours').val();
			assign = assign*1;
			var endDate = new Date(startDate);
			endDate.setHours(startDate.getHours() + assign);
			var groundName = '<%=vo.getGround_Name()%>';
			goGroundB_time(startDate, endDate, assign,groundName);
		} 
		  	
  	function goGroundB_time(startDate, endDate ,assign , groundName) {
		$.ajax({
			url:'/naonnaTest/bookingGround.do',
			type:'POST',			
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data:{	'bookNumber': "20180809",
					'groundName':groundName ,
				 	'matchingID' : "asdfqwef" ,
				 	'nickname': "${sessionScope.nickname}",	
				 	'startTime' : startDate,
				 	'assign' : assign,
				 	'endTime' : endDate},
				 	
				 	success: function(data) {
				 		alert('예약 완료되었습니다.');			 		
				 	},
				 	 error:function( request,status, error) {
						alert("code:" +request.status + "\n" +"message:" + request.responseText + "\n" + "error :" +error);
					} 
			});	
			
	}
		
  
  	
  function res() {
     // location.href = "ground_info.do"
	 history.go(-1);
   }
  
  function res2() {
	  location.href = "ground_updating.do?ground_Name="+"<%=ground_name%>"
	
  }
  </script>
</head>

<body>
	<%if(session.getAttribute("admin") != null){ %>
			<div class="monami">
			<div class="col-sm-2 side_m">
			<div class="row">
			<jsp:include page="./menu_bar/sidemenuAdmin_bar.jsp" flush="true"></jsp:include>
		<%} else {%>
			<jsp:include page="./menu_bar/topnavi.jsp" flush="true"></jsp:include>
			<div class="monami">
			<div class="col-sm-2 side_m">
			<div class="row">
			<jsp:include page="./menu_bar/sidemenu_bar.jsp" flush="true"></jsp:include>
			
		<%} %>
	
			
		</div>
	</div>
	<form name="kakaoId">
		<input type="hidden" name="kakao_Id">
	</form>	
	
	<div>
			
	</div>
<!-- start main content -->
  <div class="main col-sm-10">
  	<div class="detail-container col-sm-10 col-sm-offset-1">
  	
     <div>
        <p class="ground_name">${vo.ground_Name}</p>
        <p class="ground_addr">${vo.ground_addr} </p>
     </div>
      <div class="ground-pics col-sm-12">
       <div class="mySlides">
          <div class="numbertext">1 / 3</div>
             <img src="<spring:url value='/image/${vo.photo1}' />" style="width:100%" />            
           </div>

           <div class="mySlides">
             <div class="numbertext">2 / 3</div>
             <img src="<spring:url value='/image/${vo.photo2}' />" style="width:100%" />
           </div>

           <div class="mySlides">
             <div class="numbertext">3 / 3</div>
             <img src="<spring:url value='/image/${vo.photo3}' />" style="width:100%" />

           </div>
    
           <a class="prev" onclick="plusSlides(-1)">❮</a>
           <a class="next" onclick="plusSlides(1)">❯</a>

           <div class="caption-container">
             <p id="caption"></p>
           </div>

           <div class="row">
             <div class="column">
               <img class="demo cursor" src="<spring:url value="/image/${vo.photo1}"/>" style="width:100%" onclick="currentSlide(1)">
             </div>
             <div class="column">
               <img class="demo cursor" src="<spring:url value="/image/${vo.photo2}"/>" style="width:100%" onclick="currentSlide(2)">
             </div>
             <div class="column">
               <img class="demo cursor" src="<spring:url value="/image/${vo.photo3}"/>" style="width:100%" onclick="currentSlide(3)">
             </div>
             </div>
  <script>
  var slideIndex = 1;
   showSlides(slideIndex);
   
   function plusSlides(n) {
     showSlides(slideIndex += n);
   }
   
   function currentSlide(n) {
     showSlides(slideIndex = n);
   }
   
   function showSlides(n) {
     var i;
     var slides = document.getElementsByClassName("mySlides");
     var dots = document.getElementsByClassName("demo");
     var captionText = document.getElementById("caption");
     if (n > slides.length) {slideIndex = 1}
     if (n < 1) {slideIndex = slides.length}
     for (i = 0; i < slides.length; i++) {
         slides[i].style.display = "none";
     }
     for (i = 0; i < dots.length; i++) {
         dots[i].className = dots[i].className.replace(" active", "");
     }
     slides[slideIndex-1].style.display = "block";
     dots[slideIndex-1].className += " active";
     captionText.innerHTML = dots[slideIndex-1].alt;
   }
  </script>
  </div>
  <div class="ground-detail col-sm-12">
  	<div class="ground-detail-size col-sm-6">
  		<div class="ground-detail-size-pics">
  			<img class="formal-ground-size" src="https://www.iamground.kr/img/sample/ssize.jpg">
  		</div>
  		
  		<div class="ground-detail-size-texts col-sm-12">
			<div class="ground-detail-size-fieldtext col-sm-6">
				<div class="gray-box small-box"></div>
				<p>경기장${vo.ground_size }</p>
			</div>
			<div class="ground-detail-size-formaltext col-sm-6">
				<div class="green-box small-box"></div>
				<p>정규 규격(105 x 70)</p>
			</div>  			
  		</div>
  	</div>
  	
  	<div class="ground-detail-contents col-sm-6">
  		<div class="row contents-row">
  			<div class="container"><p>주소</p></div>
  			<p class="addr_t">${vo.ground_addr} </p>
  		</div>
  		<div class="row contents-row">
	  		<div class="ground-detail-icon col-sm-2"><img src="https://www.iamground.kr/img/icons/chun.png"></div>
	  		<div class="ground-detail-textmore col-sm-3 col-sm-offset-1"><p>${vo.grass }</p></div>
	  		<div class="ground-detail-icon col-sm-2"><img src="https://www.iamground.kr/img/icons/jo.png"></div>
	  		<div class="ground-detail-textmore col-sm-3 col-sm-offset-1"><p>${vo.light }</p></div>
  		</div>
  		<div class="row contents-row" id="row2">
	  		<div class="ground-detail-icon col-sm-2"><img src="https://www.iamground.kr/img/icons/ju.png"></div>
	  		<div class="ground-detail-textmore col-sm-3 col-sm-offset-1"><p>${vo.parking }</p></div>
	  		<div class="ground-detail-icon col-sm-2"><img src="https://www.iamground.kr/img/icons/sh.png"></div>
	  		<div class="ground-detail-textmore col-sm-3 col-sm-offset-1"><p>${vo.shower }</p></div>
  		</div>
  					<%if(session.getAttribute("admin") == null){ %>		
  					<div class="groundValue" id="timeGround">
						<div class="valueName">
							<h5>날짜</h5>
						</div>										
							<!--  시간 선택 API  -->
							<div class="demo-section k-content" id="timer">
								<h6>날짜 선택</h6>
								<input type="text" id="datePick" name="datetimes" style="width: 25%" />										
								<h6> 대여 시간</h6>
								<input type="number" id="hours" value="0" style="width: 10%;" />							 	
							</div>									
					</div>
					<%} %>
  		
  	</div>  		
  </div>
					
	<div class="button-container">
	<%if(session.getAttribute("nickname") !=null){ %>
  	<div class="payment"><button class="btn btn-success" id="reserve" onclick="res3()">예약하기</button></div>
  	<%} %>
  	<div class="back-to-list"><button class="btn btn-success" onclick="res()">목록으로</button></div>

  	<%if(session.getAttribute("admin") !=null){ %>
  	<div class="back-to-list"><button class="btn btn-success" onclick="res2()">경기장 수정</button></div>
  	<%} %>
  </div>
	</div>
	</div>
	</div>
</body>
</html>
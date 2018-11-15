<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String admin = (String)session.getAttribute("admin");		
	String ground_name = (String)session.getAttribute("groundName");
	
	if (session.getAttribute("admin") == null){
		out.print("<script>");
		out.print("alert('로그인해주세요');");
		out.print("location.href='home.do'");
		out.print("</script>");
	}
%>
<!DOCTYPE html>
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
	<style>
	 .monami {
       background-image : url("https://lh3.googleusercontent.com/-hrYUHGyoYz4/WIz2mUMTahI/AAAAAAAABNM/d6u3yCje50EBAzYhVFMM3nkPCzjYXtCFACJoC/w1366-h768/Download-Fernando-Torres-Free-HD-Football-Wallpapers_Fotor.jpg");
       height : 727px;
     }
     .main {
        margin-top : 150px;
     }
   .content-title-name {
      display : inline;
   }
   .show-ground {
      background-color: #333333;
	  padding:20px 20px 0 25px;
	  width: 100%;
	  opacity : 0.8;
	  color: white;
	  margin-top : -40px;
   }
    .show-book {
      background-color: #333333;
	  padding:40px 30px 0 10px;
	  width: 100%;
	  opacity : 0.8;
	  color: white;
   }
   .sideprofile{
   	margin-top: -100px;
   }
   .bookingtitle{
	    color:white;
   }
   .right {
      float : right;
      border: none;
      outline: 0;
   }
   .makeBtn1, .makeBtn2{
     	height : 26px;
     }
     .content-title{
     	margin-bottom : 20px;
     }
     .bookingtable1{
     	margin-top: 15px;
     	text-align: center;
     }
     .bookingtable1 thead>tr>th{
     	text-align: center;
     }
     .bookingtable2{
     	margin-left: 10px;
     	text-align: center;
     }
     .bookingtable2 thead>tr>th{
     	text-align: center;
     }
     .bookingtable2 a, .bookingtable2 a:hover{
     	text-decoration : none;
     	color : white;
     }
     .bookingtable2 a:hover {
     	color : red;
     }
</style>
<script>

$(document).ready(function() {
	function printBooking() {
		var groundName = "${sessionScope.groundName}"

			console.log(groundName);
		$('#booking_print').empty();
		$.ajax({
			url:'/naonnaTest/getAdminBookingJSON.do',
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data : { 
						'groundName' : groundName
			},
			success:function(data) {																
					$.each(data, function(index, booking) {

						var d = new Date(booking.startTime);
						var y = d.getFullYear();
						var m = (d.getMonth()+1);
						if(m < 10) {
							m = "0" + m;
						}
						var da = d.getDate();
						if(da < 10) {
							da = "0" + da;
						}
						var h = d.getHours();
						if(h < 10) {
							h = "0" + h;
						}
						var mi = d.getMinutes();
						if(mi < 10) {
							mi = "0" + mi;
						}
						
						var de = new Date(booking.endTime);
						var ye = de.getFullYear();
						var me = (de.getMonth()+1);
						if(me < 10) {
							me = "0" + me;
						}
						var dae = de.getDate();
						if(dae < 10) {
							dae = "0" + dae;
						}
						var he = de.getHours();
						if(he < 10) {
							he = "0" + h;
						}
						var mie = de.getMinutes();
						if(mie < 10) {
							mie = "0" + mie;
						}
						
						var output = '';
						if(booking.nickname != null){
							output += '<tr>';						
							output += '<td>' + booking.nickname + '</td>';
							output += '<td>' + y + '-' + m + '-' + da + '&nbsp' + h + ':' + mi + '</td>';
							output += '<td>' + ye + '-' + me + '-' + dae + '&nbsp' + he + ':' + mie + '</td>';
							output += '<td>' + booking.assign*1 + '</td>';
							if(booking.confirm != 1) {
								output += "<td><input class='makeBtn1 btn btn-success' type='button' id='confirm' onclick='click_confirm(\"" +booking.nickname +"\", \""+ booking.groundName    +" \" )'></td>";
								output += "<td><input class='makeBtn2 btn btn-danger' type='button' class='reject' id='reject'" + "></td></tr>";
							}
							else{
								output += "<td><input class='makeBtn1 btn btn-success' type='button' id='confirm' disabled='true'></td>";
								output += "<td><input class='makeBtn2 btn btn-danger' type='button' id='reject' disabled='true'></td></tr>";
							}
							console.log("output:" + output);
							$('#booking_print').append(output);
						}
					});														
			},
			error:function( request,status, error) {
				alert("code:" +request.status + "\n" +"message:" + request.responseText + "\n" + "error :" +error);
			}
		});
		
	}
	
	printBooking();
	
	
function printGround() {
	
	
	var admin = "${sessionScope.admin}"
		console.log(admin);
	
	$('#ground_print').empty();
	$.ajax({
		url:'/naonnaTest/getAdminGroundJSON.do',
		type:'POST',
		dataType: "json",
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		data : { 
					'ground_admin' : admin
		},
		success:function(data) {																
													
				var output = '';
				output += '<tr>';
				
				output += '<td> <a link href="ground_detail.do?ground_Name='+data.ground_Name + '">' + data.ground_Name  + '</td>';
				output += '<td>' + data.ground_admin + '</td>';				
				output += '<td>' + data.ground_addr + '</td>';
				output += '<td>' + data.grass + '</td>';
				output += '<td>' + data.shower + '</td>';
				output += '<td>' + data.parking + '</td>';
				output += '<td>' + data.light + '</td>';
				output += '<td>' + data.ground_size + '</td>';
				output += '<td>' + data.ground_people + '</td>';
				output += '</tr>';
				console.log("output:" + output);
				$('#ground_print').append(output);												
									
			
		},
		error:function() {
			alert("새로고침을 눌러주세요.")
		}
	});
}

printGround();




});

function click_confirm(nickname, groundName) {

	$.ajax({
		url:'/naonnaTest/confirmMatching.do',     			
		type:'POST',
		dataType: "json",
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		data : {
				'nickname' : nickname,
				"groundName" : groundName,
				'bookNumber' : "${sessionScope.admin}",
				"groundName" : "${sessionScope.groundName}"
			},
		
		//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
		success:function(data) {
			console.log(data);
			if(data == 1) {
				alert("경기를 허락하셨습니다..");
				$('#confirm').attr('disabled', true);
				$('#reject').attr('disabled', true);
			}
		},
		error:function() {
			alert("새로고침을 눌러주세요.");			
		}
		 });

	}
		
function res() {
    location.href = "ground_regi.do"
 }
</script>


</head>

<body>
		<div class="monami">
			<div class="col-sm-2 sideprofile">
   				<jsp:include page="./menu_bar/sidemenuAdmin_bar.jsp" flush="true"></jsp:include>
   			</div>
		      	<div class="main col-sm-8 col-sm-offset-1">
		         <div class="container-fluid col-sm-12 manager-index">
		            <div class="show-ground row col-sm-12">
		               <h2 class="bookingtitle content-title-name">예약현황</h2>
		               <table class="table table-straped bookingtable1">
		                  <thead>
		                     <tr>
		                        <th>예약자</th>
		                        <th>예약날짜</th>
		                        <th>종료시간</th>
		                        <th>총 대여 시간</th>
		                        <th>승낙</th>
		                        <th>거부</th>
		                     </tr>
		                  </thead>
		                  <tbody id="booking_print"></tbody>
		               </table>
		            </div>
		            <div class="show-book row col-sm-12">
		               <div class="content-title col-sm-12">
		                  <h2 class="bookingtitle content-title-name">운동장 정보</h2>
		                  <button class="right mov-btn btn btn-success" onclick="res()">경기장 등록</button>
		               </div>
		               <table class="table table-straped bookingtable2">
		                  <thead>
		                     <tr>
		                       		<th>경기장 이름</th>
		                       		<th>경기장 관리자</th>
									<th>주소</th>
									<th>인조잔디</th>
									<th>샤워시설</th>
									<th>주차장</th>
									<th>조명</th>
									<th>크기</th>
									<th>경기 인원 추천</th>
		                     </tr>
		                  </thead>
		               		<tbody class="table-body" id="ground_print"></tbody>
		               </table>
	            </div>
	         </div>    
	      </div>
	  </div>
</body>
</html>


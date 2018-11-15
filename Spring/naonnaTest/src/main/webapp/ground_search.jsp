<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.spring.naonnaTest.ground.*" %>
<!DOCTYPE html> 
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
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
	<!-- 캘린더 라이브러리-->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<!-- 캘린더 라이브러리-->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!-- 캘린더 라이브러리-->
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	<!-- 캘린더 라이브러리-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/naonna_main.css">
	
<style>
body, html {
	height : 100%;
	color : white;
	min-height: 727px;
	
}
.monami {
	background-image : url("https://lh3.googleusercontent.com/-hrYUHGyoYz4/WIz2mUMTahI/AAAAAAAABNM/d6u3yCje50EBAzYhVFMM3nkPCzjYXtCFACJoC/w1366-h768/Download-Fernando-Torres-Free-HD-Football-Wallpapers_Fotor.jpg");
    /* background-attachment: fixed; */
    min-height: 727px;
    height: 100%;
}

.container-filter-box{
	background-color: #333333;
	padding:10px;
	padding-top:20px;
	opacity : 0.8;	
}
#ground_title{
	font-size:30px;
	color : white;
	font-weight : 700;
	background-color : #333333;
	margin : 0;
	opacity : 0.8;
	padding : 20px 0 0 16px;
}
.valueName{
	font-size: 20px;
	margin-left: 20px;
	margin-bottom:0;
}
.groundValue{
	margin-bottom: 20px;
	opacity : 1.0;
}
.ground-calendar-text{
	font-size: 17px;
	display: inline-block;
	margin-left: 20px;
	margin-right: 15px;
}
.ground-calendar-input{
	margin-right: 30px;
	display : inline-block;
}
.ground-search-btn{
	margin-left: 250px;
}
.ground-list-table{
	width:100%;
}
.ground-list-table th{
	height: 40px;
	font-size:15px;
	background-color:;
	max-width:100%;
	text-align:center;
}
.ground-list-table-body tr, .ground-list-table-body td, .ground-list-table-body a{
	text-align:center;
	verticle-align:middle;
	height: 45px;
	background-color : white;
	color : black;
	text-decoration : none;
	letter-spacing : 1.4px;
}
.ground-list-table-body a:hover {
	color : red;
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
			
			
			$('#sel2').on('change',function(){
				goDAO();				
			});
			
			$('#sel3').on('change',function(){				
				goDAO();			   
			});

			$('#sel4').on('change',function(){				
				goDAO();		
			});
			
			$('#sel5').on('change',function(){				
				goDAO();			   
			});
			
			$('#sel6').on('change',function(){			
				goDAO();			   
			});
			
          	 $(function() {
          		 
					var currentDate = new Date();
//					var tomorrow = currentDate.setDate(currentDate.getDate()+1);
        		  $('input[name="datetimes"]').daterangepicker({
					

        			singleDatePicker : true,
       		 		timePicker: true,
        		    showDropdowns: true, 
        		    startDate: moment().startOf('hour'),
        		    minDate : currentDate,
//    		     endDate: moment().startOf('hour').add(0, 'hour'),
        		    locale: {
       		       format: 'YYYY/M/DD hh:00'
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
					output +=  '<td> <a link href="ground_detail.do?ground_Name='+ground.ground_Name + '">' + ground.ground_Name  + '</td>';
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
			//JSon으로 data를 보내고, 그 보낼 data의 정보를 이렇게 지정해주어 나중에 request mapping에서 부합한 객체가 있으면 이와같이 작동하여 java에서 사용.
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			success:function(data) {
				$('#ground_print').html('');		//기존 것 날려주고..
				$.each(data, function(index, ground) {		//새로 뿌리기
					var output = '';
					output += '<tr>';
					output +=  '<td> <a link href="ground_detail.do?ground_Name='+ground.ground_Name + '">' + ground.ground_Name  + '</td>';
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
			<div class="container-filter col-sm-10 col-sm-offset-1">
				<p id="ground_title">경기장 검색</p>
				<div class="container-filter-box container-fluid">
					<div class="groundValue row">
						<div class="valueName">     
							<p>위치</p>
						</div>
						<div class="value-field col-sm-4">
							<form class="form-selection">
								<select class="form-control" id="sel1">
									<option value="서울시">서울특별시</option>
								</select>
							</form>
						</div>
						<div class="value-field col-sm-4">
							<form name="city_name" class="form-selection" method="post" action="filter_city.do">
								<div class="form-select">
									<select class="form-control" name="ground_city" id="sel2">
										<option value=''>구 선택</option>									
										<option>강남구</option>
										<option>강동구</option>
										<option>강북구</option>
										<option>강서구</option>
										<option>관악구</option>
										<option>광진구</option>
										<option>구로구</option>
										<option>금천구</option>
										<option>노원구</option>
										<option>도봉구</option>
										<option>동대문구</option>
										<option>동작구</option>
										<option>마포구</option>
										<option>서대문구</option>
										<option>서초구</option>
										<option>성동구</option>
										<option>성북구</option>
										<option>송파구</option>
										<option>양천구</option>
										<option>영등포구</option>
										<option>용산구</option>
										<option>은평구</option>
										<option>종로구</option>
										<option>중구</option>
										<option>중랑구</option>
									</select>
								</div>
							</form>
						</div>
					</div>
					
					<div class="groundValue row">
						<div class="valueName">
							<p>세부사항</p>
						</div>
						<div class="form-value col-sm-3">
							<form class="form-selection">
								<select class="form-control" id="sel3">
									<option value="">운동장 종류</option>
									<option value="인조잔디">인조잔디</option>
									<option value="천연잔디">천연잔디</option>
									<option value="모래">모래</option>
								</select>
							</form>
						</div>
						<div class="form-value col-sm-3">
							<form class="form-selection">
								<select class="form-control" id="sel4">
									<option value="">주차장</option>
									<option value="주차장 있음">주차장 있음</option>
								</select>
							</form>
						</div>
						<div class="form-value col-sm-3">
							<form class="form-selection">
								<select class="form-control" id="sel5">
									<option value="">샤워장</option>
									<option value="샤워실 있음">샤워장 있음</option>
								</select>
							</form>
						</div>
						<div class="form-value col-sm-3">
							<form class="form-selection">
								<select class="form-control" id="sel6">
									<option value=''>조명</option>
									<option value="조명 있음">조명 있음</option>
								</select>
							</form>
						</div>
					</div>
					
					<div class="groundValue row" id="timeGround">
						<div class="valueName">
							<p>날짜</p>
						</div>
							<!--  시간 선택 API  -->
							<div class="demo-section k-content" id="timer">
								<h4 class="ground-calendar-text">날짜 선택</h4>
								<input class="form-control ground-calendar-input" type="text" id="datePick" name="datetimes" style="width: 25%" />
								<h4 class="ground-calendar-text">대여 시간</h4>
								<input type="number" id="hours" value="0" style="width: 5%;"/>시간
								<input class="ground-search-btn btn btn-primary" type="button" id="time_Submit" value="검색">
							</div>					
					</div>
				</div>
			<div>
				<table class="ground-list-table">
					<thead class="ground-list-table-header">
						<tr class="bg-primary">
							<th>경기장 이름</th>
							<th>주소</th>
							<th>인조잔디</th>
							<th>샤워시설</th>
							<th>주차장</th>
							<th>조명</th>
							<th>크기</th>
							<th>경기 인원 추천</th>
						</tr>
					</thead>
					<tbody class="ground-list-table-body" id="ground_print">
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
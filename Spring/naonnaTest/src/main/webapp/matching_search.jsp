<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

  <style>
  .main {
  	margin-top : 145px;
  }
  	.monami {
		background-image : url("https://i1.wp.com/thesefootballtimes.co/wp-content/uploads/2016/03/55f80d2448bdd.jpg?fit=1500%2C900&ssl=1");
		height: 727px;
	}
     .matching-filter {
        background-color: #333333;
		padding:0 10px 0 10px;
		width: 100%;
		opacity : 0.8;
     }
     #matching_title {
     	font-size:30px;
		color : white;
		font-weight : 700;
		background-color : #333333;
		margin : 0;
		opacity : 0.8;
		padding : 20px 0 0 16px;
     }
     
     .subject-location{
     	margin-top: 10px;
        /* text-align: center; */
        letter-spacing : 5px;
        font-size : 24px;
        color : white;
     } 
     .filter-location, .filter-time {
        display : inline-block; 
        margin-top: 30px;
        margin-left: 70px;
     }
     .filter-location h4, .filter-time h4 {
     	display: inline-block;
     	font-size: 18px;
     	letter-spacing:8px;
     	margin-right: 15px;
    	color : white;
     }
     .filter-location form{
     	display:inline-block;
     	width: 200px;
     	height:35px;
     }
     .time_search{
     	display:inline-block;
     	width: 200px;
     	height:35px;
     }
     .matching_button {
     	border: none;
		outline:0; /* 버튼 누르고 나서 테두리 없애기 위해 */
	  	margin-bottom: 20px;
	  	margin-top: 20px;
	  	margin-left: 60px;
	  	display: inline-block;
	  	padding: 8px;
	  	color: white;
	  	text-align: center;
	  	cursor: pointer;
	  	width: 100px;
	  	font-size: 14px;
     }
     .matching_button:hover {
     	color:black;
     	background-color:silver;
     }
	.matching_main{
		margin-left: 40px;
	}

	/* 매칭생성 모달 */
	#matching_create{
		float: right;
		border: none;
		outline:0; /* 버튼 누르고 나서 테두리 없애기 위해 */
	  	margin-bottom: 20px;
	  	margin-top: 20px;
	  	display: inline-block;
	  	padding: 8px;
	  	color: white;
	  	text-align: center;
	  	cursor: pointer;
	  	width: 100px;
	  	font-size: 14px;
	}
	#matching_create:hover{
		color:white;
		background-color: #2c2d28;
	}
	#MatchingModal {
	    display: none;
	    position: fixed;
	    width: 100%;
	    background-color: rgba(67, 68, 64, 0.4);
	    padding-top: 0;  /*top으로 부터 얼마나 띄울지*/
	}
	.modal-content{
		height: 530px;
	}
	/* 모달바디 */
	.matching_title{
		font-family: sans-serif;
		font-size: 20px;
		margin-left: 42%;
	}
	#matching_close{
		margin-top: 3px;
	}
	.matching_create_table{
	  	border: 1px solid silver;;
	  	border-left-style: none;
	  	border-right-style: none;
	  	width: 100%;
	  	margin-top: 20px;
	  	margin-bottom: 20px;
	  	table-layout: fixed;
	}
	.table_row{
	 	border-bottom : 1px solid silver; 
	}
	.table_menu{
		background-color: #F9F6F6;
	  	padding: 20px;
	  	text-align: center;
	  	width:30%;
	  	height:50px;
	  	color : black;
	} 
	#city{
		width:100%;
		height:40px;
	}
	#city_Search{
		width:100%;
		height:40px;
	}
	#datepick{
		width:50%;
		height:40px;
	}
	.table_contents{
	  	padding: 20px;
	  	font-size: 13px;
	  	height: 50px;
	}
	.table_contents input[type="text"]{
		width:100%;
		height: 40px;
		padding-left: 10px;
	}
	.table_contents input[type="number"]{
		width:100%;
		height: 40px;
		padding-left: 10px;
	}
	button[name="create"]{
		border: none;
		outline:0; /* 버튼 누르고 나서 테두리 없애기 위해 */
	  	padding: 8px;
	  	color: white;
	  	background-color: #000;
	  	text-align: center;
	  	cursor: pointer;
	  	width: 100%;
	  	font-size: 18px;
	}
	.matching_list{
		padding : 0;
		width: 100%;
	}
	.tmatching_header th{
		text-align:center;
		/* border: 1px solid silver; */
		height: 40px;
		font-size:15px;
	}
	.tmatching_body tr, .tmatching_body td, .tmatching_body a{
		text-align:center;
		verticle-align:middle;
		height: 45px;
		background-color : white;
		color : black;
		text-decoration : none;
		letter-spacing : 1.4px;
	}
	.tmatching_body a:hover {
		color : red;
	}
  </style>

<script>
	$(document).ready(function() {
		$(function() {
			var currentDate = new Date();
			//					var tomorrow = currentDate.setDate(currentDate.getDate()+1);
			$('#datePick').daterangepicker({
				singleDatePicker : true,
				timePicker: true,
				showDropdowns : true,
				startDate : moment().startOf('hour'),
				minDate : currentDate,
				//    		     endDate: moment().startOf('hour').add(0, 'hour'),
				locale : {
					format : 'YYYY/M/DD hh:mm'
				//         		    	format: 'YYYY/M/DD'
				}
			});
		});
		
		$(function() {
			var currentDate = new Date();
			$('input[name="datetimes"]').daterangepicker({
				singleDatePicker : true,
				showDropdowns : true,
				startDate : moment().startOf('hour'),
				minDate : currentDate,
				locale : {
				        		    	format: 'YYYY/MM/DD'
				}
			});
		});
		
		$(function() {
			$.ajax({
				url:'/naonnaTest/print_matching.do',
				type:'POST',
				dataType: "json",
				contentType : 'application/x-www-form-urlencoded; charset=utf-8',
				//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
				success:function(data) {
					$('#print_match').html('');		//기존 것 날려주고..		
					var output = '';
					$.each(data, function(index, match) {		//새로 뿌리기
						var d = new Date(match.playDate);
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
						output += '<tr>';
						output += '<td>' + "<a href='go_matchingDetail.do?matchingID="+ match.matchingID + "'>"+ match.matchingID +'</a></td>';
						output += '<td>' + match.matchLocation + '</td>';
						output += '<td>' + y + '-' + m + '-' + da + '&nbsp' + h + ':' + mi + '</td>';
						output += '<td>' + match.homeTeam + '</td>';
						output += '<td>' + match.people + '</td>';
						output += '</tr>';
						console.log("output:" + output);	
					});
					$('#print_match').html(output);
					console.log(data);
				},
				error:function() {
					alert("ajax통신 실패!!");
				}
			});
		});
		
		$('#search_matching').click(function(){
			var matchingCity = $('#city_Search').val();
	  		var matchDate = new Date($('#datePick').val());
	  		matchDate.setHours(0);
	  		matchDate.setMinutes(0);
	  		search_match(matchDate, matchingCity);
		});
		
		$('#matching_create').on('click', function() {	
			if('${sessionScope.cap}' == 1) {
				$('#matching_create').attr('data-target', '#MatchingModal');
				$("#teamNamePrint").text('${sessionScope.teamName}');
				$('#teamNameOut').val('${sessionScope.teamName}');
			}
			else {
				alert("매칭 기능은 주장만 이용할 수 있습니다.");
			}			
		});		
	});
		
	function search_match(matchDate, matchingCity) {
		$.ajax({
			url:'/naonnaTest/searchMatching.do',
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data:{	'matchLocation' : matchingCity,
					'playDate' : matchDate},
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			success:function(data) {
				$('#print_match').html('');		//기존 것 날려주고..
				$.each(data, function(index, match) {		//새로 뿌리기
					var d = new Date(match.playDate);
					var y = d.getFullYear();
					var m = (d.getMonth()+1);
					var da = d.getDate();
					var h = d.getHours();
					var mi = d.getMinutes();
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
					var output = '';
					output += '<tr>';
					
					output += '<td>' + "<a href='go_matchingDetail.do?matchingID="+ match.matchingID + "'>"+ match.matchingID +'</a></td>';
					//output += '<td id="match_want">' + match.matchingID + '</td>';
					output += '<td>' + match.matchLocation + '</td>';
					output += '<td>' + y + '-' + m + '-' + da + '&nbsp' + h + ':' + mi + '</td>';
					output += '<td>' + match.homeTeam + '</td>';
					output += '<td>' + match.people + '</td>';
					output += '</tr>';
					console.log("output:" + output);
					$('#print_match').append(output);
				});
				console.log(data);
			},
			error:function() {
				alert("ajax통신 실패!!");
			}	
		});
	}
		
	function match_want(tex) {		
			location.href="go_matchingDetail.do?matchingID="+tex;
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
			<div class="col-sm-10 col-sm-offset-1">
				<p id="matching_title">매칭 검색</p>
				<div class="matching-filter col-sm-8 container-fluid">
					<div class="filter-location">
						<h4>위치</h4>
						<form action="#">
							<select name="matchLocation" class="custom-select mb-3 form-control" id="city_Search">
								<option value=''>지역 선택</option>
								<option value="강동구">강동구</option>
								<option value="강북구">강북구</option>
								<option value="강서구">강서구</option>
								<option value="관악구">관악구</option>
								<option value="광진구">광진구</option>
								<option value="구로구">구로구</option>
								<option value="금천구">금천구</option>
								<option value="노원구">노원구</option>
								<option value="도봉구">도봉구</option>
								<option value="동대문구">동대문구</option>
								<option value="동작구">동작구</option>
								<option value="마포구">마포구</option>
								<option value="서대문구">서대문구</option>
								<option value="서초구">서초구</option>
								<option value="성동구">성동구</option>
								<option value="성북구">성북구</option>
								<option value="송파구">송파구</option>
								<option value="양천구">양천구</option>
								<option value="영등포구">영등포구</option>
								<option value="용산구">용산구</option>
								<option value="은평구">은평구</option>
								<option value="종로구">종로구</option>
								<option value="중구">중구</option>
								<option value="중랑구">중랑구</option>
							</select>
						</form>
					</div>
					<div class="filter-time">
						<h4>날짜</h4>
						<!--  시간 선택 API  -->
						<input type="text" id="datePick_Search" name="datetimes" class="time_search form-control" />
					</div>
					<button type="button" class="btn btn-primary matching_button" id="search_matching">매칭검색</button>
						</div>
			
			<div class="matching_list col-sm-8 container-fluid">
				<table class="matching_table table table-hover col-sm-12">
					<thead class="tmatching_header">
						<tr class="bg-primary">
							<th>매 칭 이 름</th>						
							<th>지 역</th>
							<th>경 기 일 정</th>
							<th>팀 명</th>
							<th>인 원</th>				
						</tr>
					</thead>
					<tbody class="tmatching_body" id="print_match">
					</tbody>
				</table>
				<div class="matching_main">
						<button class="btn btn-primary" id="matching_create" type="button" data-toggle="modal">매칭등록</button>
							<div class="modal fade" id="MatchingModal" role="dialog">
          						<div class="modal-dialog">
            						<div class="modal-content">
            							<div class="modal-body">
            								<span class="matching_title">매 칭 등 록</span>
            									<button type="button" id="matching_close" class="close" data-dismiss="modal">&times;</button>
			            						<form action="makeMatch.do" method="post">
			            						<input type="hidden" id="teamNameOut" name="homeTeam">
			            						<table class="matching_create_table">
			            							<tr class="table_row">
			      										<td class="table_menu">팀&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명</td>
			      										<td class="table_contents" id="teamNamePrint"></td>
			      									</tr>
			            							<tr class="table_row">
			      										<td class="table_menu">매칭제목</td>
			      										<td class="table_contents"><input type="text" name="matchingID" placeholder="매칭 제목을 입력하세요." required></td>
			      									</tr>
			      									
			      									<tr class="table_row">
			      										<td class="table_menu">경기일정</td>
			      										<td class="table_contents"><input type="text" id="datePick" name="playDate"/></td>
			      									</tr>
			      									
			      									<tr class="table_row">
			     										<td class="table_menu">경기지역</td>
			      										<td class="table_contents">
																<select name="matchLocation" class="custom-select mb-3" id="city">
																	<option value=''>지역 선택</option>
																	<option value="강동구">강동구</option>
																	<option value="강북구">강북구</option>
																	<option value="강서구">강서구</option>
																	<option value="관악구">관악구</option>
																	<option value="광진구">광진구</option>
																	<option value="구로구">구로구</option>
																	<option value="금천구">금천구</option>
																	<option value="노원구">노원구</option>
																	<option value="도봉구">도봉구</option>
																	<option value="동대문구">동대문구</option>
																	<option value="동작구">동작구</option>
																	<option value="마포구">마포구</option>
																	<option value="서대문구">서대문구</option>
																	<option value="서초구">서초구</option>
																	<option value="성동구">성동구</option>
																	<option value="성북구">성북구</option>
																	<option value="송파구">송파구</option>
																	<option value="양천구">양천구</option>
																	<option value="영등포구">영등포구</option>
																	<option value="용산구">용산구</option>
																	<option value="은평구">은평구</option>
																	<option value="종로구">종로구</option>
																	<option value="중구">중구</option>
																	<option value="중랑구">중랑구</option>
																</select>
														</td>
			      									</tr>
			      									<tr class="table_row">
			      										<td class="table_menu">초기 인원</td>
			      										<td class="table_contents"><input type="number" class="form-control" name="people" placeholder="매칭 인원을 입력하세요." required></td>
			      									</tr>
			      								</table>			      								
			      								<button type="submit" name="create">매칭 생성</button>			      								
			                				</form>
			            				</div>	
			            			</div>
			            		</div>
			            	</div>
						</div>
			</div>
		</div>
		</div>
		</div>
		<%-- <div>
		<jsp:include page="./menu_bar/client_chat.jsp" flush="false">
			<jsp:param value='${sessionScope.nickname}' name="sessionNick"/>
		</jsp:include>	
	</div> --%>
</body>
</html>
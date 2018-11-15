<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
  <link href="${pageContext.request.contextPath}/resources/naonna_main.css" rel="stylesheet" type="text/css"/>
  
  <style>
      .ds-btn li{ list-style:none; float:left; padding:10px; }
      .ds-btn li a span{padding-left:15px;padding-right:5px;width:100%;display:inline-block; text-align:left;}
      .ds-btn li a span small{width:100%; display:inline-block; text-align:left;}
    	.monami {
			background-image : url("https://i1.wp.com/thesefootballtimes.co/wp-content/uploads/2016/03/55f80d2448bdd.jpg?fit=1500%2C900&ssl=1");
			height: 727px;
		}
		 .main {
        	margin-top : 150px;
     	}
       .btn-container {
          margin-top : 40px;
       }
       .card-img-top {
       		width : 300px;
       }
       .player-board-container {
          margin-top : 60px;
       }
       .team-table, .away-table {
          border : 1px solid black;
       }
       .team-table td:nth-child(odd), .away-table td:nth-child(odd) {
          border : 3px solid black;
          width : 30%;
          text-align : center;
       }
       .vs-table {
          margin-top : 20px;
          border : 2px solid red;
       }
       .vs-table h1 {
          text-align : center;
          font-weight : 900;
          color : red;
       }
       #page_title {
           font-weight : 600;
           font-size : 30px;
           margin-bottom : 15px;
           color : white;
       }
       .team-name {
          text-align : center;
       }
       .team-name-p {
          font-weight : 900;
          background-color : black;
          color : white;
          padding : 20px 0;
       }
       .matching-detail-table {
          margin-top : 40px;
          border : 1px solid yellow;
       }
       .matching-detail-table tr {
          height : 40px;
          text-align : center;
          font-weight : 600;
       }
       .card_team_info {
          float : left;
       }
       .table tr td {
          padding : 15px;
       }
       .card_team_info img{
       		width : 100%;
       }
       
       #teamEmblem {
       		height : 200px;
       }
       .btn-collection{
       	float: right;
       }
       .player-table-container {
       		background-color : #111;
       		color : #DDD;
       		padding: 15px;
       		border : 3px solid #A52A2A;
       		opacity : 0.9;
       }
       #matchingInfo {
       		border-bottom : 1px solid;
       }
  </style>
	
	<script>
	$(document).ready(function () {

		$('#matchingInfo').html("");
		var d = new Date(Date.parse("${requestScope.playDate}"));
		var y = d.getFullYear()+"";
		var m = (d.getMonth()+1)+"";
		var da = d.getDate()+"";
		var h = d.getHours()+"";
		var mi = d.getMinutes()+"";
		
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
		
		if('${requestScope.matFin}' == 1) {
			alert("마감된 매칭입니다.");
			$("#match_wanna").hide();
			$('#selectPeople').hide();								
			$('#finish').attr("disabled", true);
		}
		output = "";
		output += "<tr><td>장소</td><td>" + "${requestScope.matchLocation}" + "</td></tr>";
		output += "<tr><td>시간</td><td>" + y + '-' + m + '-' + da + '&nbsp' + h + ':' + mi + "</td></tr>";
		output += "<tr><td>참가자</td><td>" + "${requestScope.homeTeam}" +"팀 &nbsp" + "${requestScope.people}" +"명" +"</td></tr>";	
		$('#matchingInfo').html(output);
		
		$.ajax({
	   			url:'/naonnaTest/printPlayer.do',     			
	   			type:'POST',
	   			dataType: "json",
	   			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
	   			data : {
	   					'matchingID' : '${requestScope.matchingID}'
	   				},
	   			
	   			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
	   			success:function(data) {
	   				console.log("용병 =" + data);
	   				output = "";
	   				$.each(data, function(index, player) {
	   					output += "<tr><td>참여자 : </td><td>" + player.nickname +" 외 " + player.people + "명" + "</td></tr>";
	   				});
	   				$('#playerInfo').html(output);
	   			},
	   			error:function() {
	   				alert("새로고침을 눌러주세요.");			
	   			}
	       });

		team_detail("${requestScope.homeTeam}");
		
		$('#finish').click(function() {
			if('${sessionScope.teamName}'== "${requestScope.homeTeam}") {
				var retVal = confirm("매칭을 마감하시겠습니까?");
				if(retVal == true) {
					$.ajax({
						url:'/naonnaTest/matchFinish.do',
						type:'POST',
						dataType: "json",
						contentType : 'application/x-www-form-urlencoded; charset=utf-8',
						data : {"matchingID" : "${requestScope.matchingID}"},
						success:function(data) {
							if(data == 1){
								alert("매칭신청이 마감되었습니다.");
								$("#match_wanna").hide();
								$('#selectPeople').hide();								
								$('#finish').attr("disabled", true);
							}
						},
						error:function() {
							alert("ajax통신 실패!!");
						}
					});
				}
			}
			else{
				alert("마감할 수 있는 권한이 없습니다.");
			}
		});
		
		$('#delete').click(function(){
			if('${sessionScope.teamName}'== "${requestScope.homeTeam}") {
				if(confirm('매칭을 삭제하시겠습니까?') == true) {
					$.ajax({
						url:'/naonnaTest/matchdelete.do',
						type:'POST',
						dataType: "json",
						contentType : 'application/x-www-form-urlencoded; charset=utf-8',
						data : {"matchingID" : "${requestScope.matchingID}"},
						success:function(data) {							
								alert("매칭이 삭제되었습니다.");
								location.href="matching_search.do"
							
						},
						error:function( request,status, error) {
							alert("code:" +request.status + "\n" +"message:" + request.responseText + "\n" + "error :" +error);
						}
					});
				}
			}
			else{
				alert('매칭을 삭제할 권한이 없습니다.');
				history.go(0);
			}
			
		});
		
		$('#match_wanna').click(function (){
			if('${sessionScope.nickname}' != "") {
				$.ajax({
					url: '/naonnaTest/messageToMatch.do',
					type:'POST',
					dataType: "json",
					contentType : 'application/x-www-form-urlencoded; charset=utf-8',
					data : {"matchingID" : "${requestScope.matchingID}",
							"sendPeople" : '${sessionScope.nickname}',	
							"teamName" : '${requestScope.homeTeam}',
							"people" : $('#selectPeople').val()
					},
					success:function(data) {
						alert("매칭 신청이 완료되었습니다. 결과를 기다려주세요");				
					},
					error:function() {
						alert("ajax통신 실패!!");
					}
				});
			}
			else {
				alert("로그인이 필요합니다.");
			}
		});
	});
	
	function team_detail(homeTeam) {
		
		$.ajax({
			url:'/naonnaTest/teamOnMatch.do',
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			data : {"team_name" : homeTeam},
			
			success:function(data) {
				console.log("teamDetail" + data);
				$('#homeDetail').attr("href", "team_detail.do?team_name="+ data.team_name);
				var output = '';
				/* $('#teamEmblem').attr("src", '/naonnaTest/image/' + data.emblem) */
				$('#teamName').text("");
				$('#ability').text("");
				$('#area').text("");
				$('#teamName').text("개최 팀 : " + data.team_name);
				$('#ability').text("실력 : " + data.ability);
				$('#area').text("주요 활동 지역 : " + data.area);
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
      	<div class="col-sm-9 col-sm-offset-1 sub_main">
            
            <div class="player-table-container row justify-content-md-center">
            	<div class="player-nameboard col-sm-12">
               		<p id="page_title">매칭 상세 정보</p>
            	</div>
               <div class="col-sm-4 team-info">
                  <div class="card_team_info" id="teamDetail">
                           <div class="card-body">
                               <h4 id="teamName" class="card-title text-center">팀 이름</h4><br>
                               <p id="ability" class="card-text">실력 : </p>
                               <p id="area" class="card-text">주 활동 지역 : 지구</p>
                               <a class="btn btn-primary btn-block" id="homeDetail">자세히보기</a>
                           </div>
                      </div>
                   </div>
                   <div class="col-sm-8">
                      <div class="matching_info">
                         <table class="table" id="matchingInfo">
                         </table>
                         <table class="table" id="playerInfo">
                         </table>
                         
                      </div>
						<div class="btn-collection">
	                      <select class="btn btn-primary" id="selectPeople" name="people">
	                      	<option value="1">혼자 참여</option>
	                      	<option value="2">둘이 참여</option>
	                      	<option value="3">셋이 참여</option>
	                      	<option value="4">4명 참여</option>
	                      	<option value="5">5명 참여</option>
	                      	<option value="6">6명 참여</option>
	                      	<option value="7">7명 참여</option>
	                      	<option value="8">8명 참여</option>
	                      	<option value="9">9명 참여</option>
	                      	<option value="10">10 참여</option>
	                      	<option value="11">11명 참여</option>
	                      	<option value='${sessionScope.teamName}'>내 팀으로 참여</option>
	                      </select>
	                       <button class="btn btn-primary" id="match_wanna">참가 신청</button>
                      <button class="btn btn-warning" onclick="history.back()">목록으로</button>
                      <button class="btn btn-warning" id="finish">참가 마감</button>
                      <button class="btn btn-warning" id="delete">매칭 삭제</button>
                      </div>
               		</div>
            </div>
         </div>
      </div>
      </div>
</body>
</html>
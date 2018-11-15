<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link href="${pageContext.request.contextPath}/resources/naonna_main.css" rel="stylesheet" type="text/css"/>
  <style>
  	.table tr{
  		text-align : center;
  		color: white;
  	}
  	.table th{
  		text-align: center;
  	}
	.monami {
       background-image : url("https://lh3.googleusercontent.com/-hrYUHGyoYz4/WIz2mUMTahI/AAAAAAAABNM/d6u3yCje50EBAzYhVFMM3nkPCzjYXtCFACJoC/w1366-h768/Download-Fernando-Torres-Free-HD-Football-Wallpapers_Fotor.jpg");
       height : 727px;
     }
     .main {
        margin-top : 120px;
     }
     .show-ground{
     	 background-color: #333333;
	     padding:0 10px 0 10px;
	     width: 100%;
	     opacity : 0.8;
     }
     .bookingtitle{
	      font-size:30px;
	      color : white;
	      font-weight : 700;
	      margin : 0;
	      padding : 20px 0 0 16px;
     }
     .makeBtn1, .makeBtn2{
     	height : 26px;
     }
     #msgDelete{
     	margin: 10px 0 5px 20px;
     }
  </style>
  
  <script>
  	$(document).ready(function () {
   		$.ajax({
   			url:'/naonnaTest/printMessage.do',     			
   			type:'POST',
   			dataType: "json",
   			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
   			data : {
   					'nickname' : '${sessionScope.nickname}'
   				},
   			
   			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
   			success:function(data) {
   				console.log(data); 
   				var output = "";	
   				$.each(data, function(index, msg) {
   					var d = new Date(msg.messageDate);
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
					
					output += "<input type='hidden' id='matchingID' value='" +msg.matchingID+"'>";
					output += "<input type='hidden' id='people' value='" +msg.people+"'>";
			  		output += "<tr><td><input type='checkbox' class='checkBox' value=\"" + msg.message + "\"></td>"			//이거 바꾸면 아래 바꿔줘야함.
					output += "<td id='msgSendID'>" + msg.sendPeople + "</td>";
					output += "<td id='msgContent'" +index+ ">" + msg.message + "</td>";
					output += "<td>" + y + '-' + m + '-' + da + '&nbsp' + h + ':' + mi + "</td>";
					if(msg.confirm != 1) {
						if(msg.matchingID != null) {
							output += "<td><input class='btn btn-success makeBtn1' type='button' onclick='click_confirm(\"" +msg.matchingID +"\", \""+ msg.sendPeople + "\", \""+ msg.people  + "\")'></td>";
							output += "<td><input class='btn btn-danger makeBtn2' type='button' class='reject' id='reject'" + "></td></tr>";
						}
						else if(msg.teamName !=null) {
							output += "<td><input class='btn btn-success makeBtn1' type='button' onclick='click_joinTeam(\"" +msg.teamName +"\", \""+ msg.sendPeople + "\")'></td>";
							output += "<td><input class='btn btn-danger makeBtn2' type='button' class='reject' id='reject'" + "></td></tr>";
						}
						if(msg.message == '대관신청이 완료되었습니다.') {
							output += "<td><a href='kakaoPay.do?groundName=" + msg.groundName +"'>결제 </a></td>"
						}
					}
					else{
						output += "<td><input type='button' id='confirm' disabled='true'></td>";
						output += "<td><input type='button' id='reject' disabled='true'></td></tr>";
					}
   				});
   				$('#messageList').html(output);  
   			},
   			error:function() {
   				alert("새로고침을 눌러주세요.");			
   			}
       });
   		
   		
   		$('#checkAll').on('click', function() {
   			if($('#checkAll').prop("checked") == true) {
   				$('.checkBox').prop('checked', true);
   			}
   			else {
   				$('.checkBox').prop('checked', false);
   			}
   			
   		});
   		
   		
   		$('#msgDelete').click(function() {
   			var chkArr = new Array($('.checkBox:checked').length);
		    var cnt = 0;
		    
   			$('.checkBox:checked').each(function() { 
   		        chkArr[cnt] = $(this).val();
   		        cnt += 1; 		        
   		   });
   			
   			console.log(chkArr);
   			jQuery.ajaxSettings.traditional = true;

   			$.ajax({
   	   			url:'/naonnaTest/deleteMessage.do',     			
   	   			type:'POST',
   	   			dataType: "json",
   	   			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
   	   			data : {
   	   					'message' : chkArr
   	   				},
   	   			
   	   			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
   	   			success:function(data) {
   	   				alert("메세지가 삭제되었습니다.");
   	   				window.location.reload();
   	   			},
   	   			error:function() {
   	   				alert("새로고침을 눌러주세요.");			
   	   			}
   	       });
   		});
   		
  	});
  	
  	function click_confirm(matchingID, sendPeople, people) {
  		
		$.ajax({
			url:'/naonnaTest/confirmPlayer.do',     			
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data : {
					'nickname' : sendPeople,
					'matchingID' : matchingID,
					'people' : people
				},
			
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			success:function(data) {
				console.log(data);
				if(data == 1) {
					alert("매칭이 승낙되었습니다.");
					$('#confirm').attr('disabled', true);
					$('#reject').attr('disabled', true);
				}
				
			},
			error:function() {
				alert("새로고침을 눌러주세요.");			
			}
 		 });

  	}

  	
  	function click_joinTeam(teamName, sendPeople) {
  		console.log("teamName : " + teamName);
  		console.log("sendPeople : " + sendPeople);
  		
  		$.ajax({             
			url:'/naonnaTest/joinTeamMema.do',     			
			type:'POST',
			dataType: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data : {
					'nickname' : sendPeople,
					'team_name' : teamName,
				},
			
			//제이슨 형식의 리턴된 데이터는 아래의 data가 받음
			success:function(data) {
				console.log(data);
				if(data == 1) {
					alert(sendPeople + "님이 팀에 들어오셨습니다.");
					$('#confirm').attr('disabled', true);
					$('#reject').attr('disabled', true);
				}
				else {
					alert("값 전달 안됨");
				}
				
			},
			error:function( request,status, error) {
				alert("code:" +request.status + "\n" +"message:" + request.responseText + "\n" + "error :" +error);
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
   
  <div class="main col-sm-10"><br>
         <div class="col-sm-10 col-sm-offset-1 manager-index">
            <div class="show-ground row col-sm-12">
                 <p class="bookingtitle content-title-name">알림창</p>
	             <div class="button-container">
	                <button class="btn btn-danger" id="msgDelete">삭제</button>
	             </div>
               <table class="table table-straped">
                  <thead>
                     <tr>
                        <th><input type="checkbox" id='checkAll'/></th>
                        <th>보낸사람</th>
                        <th>내용</th>
                        <th>발송일</th>
                        <th>승낙</th>
                        <th>거부</th>
                     </tr>
                  </thead>
                  <tbody id="messageList"> 
                  </tbody>
               </table>
            </div>
          </div>    
      </div>
  </div>
  <!-- end main content -->
  </div>
  <!-- main body end -->
</body>
</html>

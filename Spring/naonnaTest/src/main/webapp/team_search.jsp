<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<% 
   String nickname = (String)session.getAttribute("nickname");   
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
     .team-filter {
        background-color: #333333;
	    padding:0 10px 0 10px;
	    width: 100%;
	    opacity : 0.8;
     }
     .row {
        margin-bottom : 20px;
     }
     .row p {
        font-weight : 700;
        font-size : 18px;
        color : white;
        text-align : center;
        letter-spacing : 1.5px;
     }
     .team-filter-name input {
        display : inline;
        width : 100px;
        height : 40px;
        margin : 20px;
     }
     .team-filter-value {
        display : inline-block;
     }
     .container-page {
        display : inline;
     }
     
/* 팀생성 모달 */
#team_create{
   float: right;
   border: none;
   outline:0; /* 버튼 누르고 나서 테두리 없애기 위해 */
     margin-bottom: 20px;
     display: inline-block;
     padding: 8px;
     color: white;
     text-align: center;
     cursor: pointer;
     width: 15%;
     font-size: 18px;
}
#team_create:hover{
   color:white;
   background-color: #2c2d28;
}
#TeamModal {
    display: none;
    position: fixed;
    width: 100%;
    background-color: rgba(67, 68, 64, 0.4);
    padding-top: 10px;  /*top으로 부터 얼마나 띄울지*/
}
/* 모달바디 */
.team_title{
   font-size: 20px;
   margin-left: 45%;
}
#team_close{
   margin-top: 3px;
   margin-right: 5px;
   outline: none;
}
.create_modal_table{
   border: 1px solid silver;
     border-left-style: none;
     border-right-style: none;
     width: 100%;
     margin-top: 20px;
     margin-bottom: 20px;
     table-layout: fixed;
     border-collapse: collapse;
}
.modal-body {
   height : 610px;
}

.table_menu{
   background-color: #F9F6F6;   
     text-align: center;

     height: 60px;
}
.table_contents{
     padding: 10px;
     font-size: 13px;
     width:70%;
     height: 60px;
}
#city{
   padding: 10px;
     font-size: 13px;
     width:100%;
     float:left;
     height: 40px;
}
.table_contents input[type="text"]{
   width:100%;
   height: 40px;
   padding-left: 10px;
}
.team_text{
   width:100%;
   height: 90px;
   padding-left: 10px;
}
button[name="create"]{
   border: none;
   outline:0; /* 버튼 누르고 나서 테두리 없애기 위해 */
     padding: 8px;
     color: white;
     margin-top: -10px;
     background-color: #000;
     text-align: center;
     cursor: pointer;
     width: 100%;
     height: 40px;
     font-size: 15px;
}
.menu-nameboard h3{
   font-weight : 800;
   color : white;
   margin-bottom : 20px;
}
#team_title {
   font-size:30px;
      color : white;
      font-weight : 700;
      background-color : #333333;
      margin : 0;
      opacity : 0.8;
      padding : 20px 0 0 16px;
}
.team-filter-row {
   padding : 20px 5px;
}
.team-filter-row p{
   text-align : right;
   font-weight : 500;
   
}

.btn-search-select {
   float : right;
   margin-top : 30px;
   margin-right : 14px;
   width : 100px;
}
.contents_table th {
   text-align : center;
}

.team-body tr, .team-body tr td a {
	background-color : white;
	text-align : center;
	color : black;
	letter-spacing : 1.4px;
	font-weight : 550;
}
.team-body tr td a:hover {
	color : red;
}
  </style>
  
  <script>
   $(document).ready(function() {
       function printTeam() {
            $('#team_print').empty();
            $.ajax({
               url:'/naonnaTest/getTeamlistJSON.do',
               type:'POST',
               dataType: "json",
               contentType : 'application/x-www-form-urlencoded; charset=utf-8',
               //제이슨 형식의 리턴된 데이터는 아래의 data가 받음
               success:function(data) {
                  $.each(data, function(index, team) {
                     var output = '';
                     output += '<tr>';
                     output += '<td> <a link href="team_detail.do?team_name='+team.team_name + '">' + team.team_name  + '</td>';
                     output += '<td>' + team.area + '</td>';
                     output += '<td>' + team.nickname + '</td>';
                     output += '<td>' + team.ability + '</td>';
                     output += '<td>' + team.number_team + '</td>';
                     output += '</tr>';
                     console.log("output:" + output);
                     $('#team_print').append(output);
                  });
               },
               error:function() {
                  alert("새로고침을 눌러주세요.")
               }
            }); // ajax
         } // printTeam function
         
         
         $('#target').click(function (){ 
            
            goFindteam();         
         }); //target
         
      
         function goFindteam() {
            
            $.ajax({
               url:'/naonnaTest/getTeamfindJSON.do',
               type:'POST',
               dataType: "json",
               contentType : 'application/x-www-form-urlencoded; charset=utf-8',      
               data:{                     
                     'team_name':$('#teamid').val(),
                     'area': $('#address').val(),
                     'nickname' : $('#capid').val()                     
                  },   
                  
            success:function(data) {
            
               $('#team_print').html('');      //기존 것 날려주고..
               
               $.each(data, function(index, team) {      //새로 뿌리기
                  var output = '';
                  output += '<tr>';
                  output += '<td> <a link href="team_detail.do?team_name='+team.team_name + '">' + team.team_name  + '</td>';
                  output += '<td>' + team.area + '</td>';
                  output += '<td>' + team.nickname + '</td>';
                  output += '<td>' + team.ability + '</td>';
                  output += '<td>' + team.number_team + '</td>';
                  output += '</tr>';
                  console.log("output:" + output);
                  $('#team_print').append(output);
                  
               });
               console.log(data);
            },
            error:function() {
               alert("ajax통신 findteam실패!!");
            }
         });   
                              
      }            
         
   
         printTeam();
         
        
      $('#target2').click(function (){
         printTeam();
      });
       

});
   
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
        <p id="team_title">팀관리</p>
        <div class="team-filter container-fluid">
           <div class="team-filter-row">
                <div class="row">
              <div class="team-filter-name col-sm-2"><p> 팀 명 </p></div>
              <div class="team-filter-value col-sm-4"><input type="text" class="form-control" id="teamid" placeholder="팀의 이름을 입력하세요." autofocus></div>
              <div class="team-filter-name col-sm-2"><p> 팀 활동 지역 </p></div>
              <div class="team-filter-value col-sm-4">
               <form class="form-selection">
                  <select class="form-control" id="address">
                      <option value=''>선택사항</option>
                     <option >강남구</option>
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
               </form>
            </div>
            </div>
            <div class="row">
              <div class="team-filter-name col-sm-2"><p> 주장 닉네임 </p></div>
              <div class="team-filter-value col-sm-4"><input type="text" class="form-control" id="capid" placeholder="주장의 닉네임을 입력하세요."></div>
             <div class="team-search">
                <button type="button" class="btn btn-primary btn-search-select" id="target">팀 검색</button>
             </div>
             </div>
           </div>
        </div>
        
        <div class="container-board">           
           <table class="table contents_table table-hover">
              <thead class="team-header">
                  <tr class="bg-primary">
                    <th>팀명</th>
                    <th>위치</th>
                    <th>팀 주장</th>
                    <th>실력</th>
                    <th>인원</th>
                  </tr>
             </thead>
              <tbody class="team-body" id="team_print">  
              </tbody>
           </table>
        </div>
      <div>
      <%System.out.println("session.getAttribute('cap') :" + session.getAttribute("cap")); %>
      
       <%if(session.getAttribute("cap") == null){ %>
      <button class="btn btn-primary" id="team_create" type="button" data-toggle="modal" data-target="#TeamModal">팀생성</button>
      <%} %>     
             <div class="modal fade" id="TeamModal" role="dialog">
                   <div class="modal-dialog">
                     <div class="modal-content">
                        <div class="modal-body">                      
                             <span class="team_title">팀생성</span>                       
                             <button type="button" id="team_close" class="close" data-dismiss="modal">&times;</button>                                
                             <form id="multiform" action="insertTeam.do" method="post" enctype="multipart/form-data">
                             <table class="create_modal_table" >
                                <tr class="table_row">
                                   <td class="table_menu">팀명</td>
                                   <td class="table_contents"><input type="text" placeholder="팀명을 입력하세요." name ="team_name" required></td>
                                   <!--중복확인 넣기-->
                                </tr>                            
                                <tr class="table_row">
                                   <td class="table_menu">닉네임</td>
                                   <td class="table_contents">${sessionScope.nickname}<input type="hidden" name="nickname" value='${sessionScope.nickname}' required></td>
                                   
                                   
                                </tr>
                                <tr class="table_row">
                                   <td class="table_menu">위치</td>
                                   <td class="table_contents">
                                    <select name="area" class="custom-select mb-3" id="city">
                                       <option value=''>지역 선택</option>
                                       <option value="강남구">강남구</option>
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
                                   <td class="table_menu">연령</td>
                                   <td class="table_contents"><input type="text" placeholder="나이를 입력하세요." name="age" required></td>
                                </tr>
                                <tr class="table_row">
                                   <td class="table_menu">엠블럼</td>
                                   <td class="table_contents"><input type="file" placeholder="엠블럼을 넣어주세요." name="emblem2"></td>
                                </tr>
                                <tr class="table_row">
                                   <td class="table_menu">실력</td>
                                   <td class="table_contents"><input type="text" placeholder="실력을 입력하세요." name="ability" required></td>
                                </tr>
                                <tr class="table_row">                            
                                   <td class="table_menu">팀소개</td>
                                   <td class="table_contents"><input type="hidden" placeholder="간단한 팀 소개를 작성해 주세요." name="number_team" value="1">
                                   <textarea class="team_text" name="intro" ></textarea>
                                   </td>
                                </tr>
                             </table>
                                <button type="submit" name="create">Create</button>   
                             </form>
                         </div>
                      </div>
                   </div>
                </div>
          </div>
       </div>
    </div>
    </div>   
</body>
</html>
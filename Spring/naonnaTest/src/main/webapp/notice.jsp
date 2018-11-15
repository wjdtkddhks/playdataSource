<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.spring.naonnaTest.notice.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<% request.setCharacterEncoding("utf-8"); %>

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
     #notice_title {
      font-size:30px;
      color : white;
      font-weight : 700;
      background-color : #333333;
      margin : 0;
      opacity : 0.9;
      padding : 20px 0 0 16px;
   }
   .notice-table{
      background-color: #333333;
      padding:0 10px 0 10px;
      width: 100%;
      opacity : 0.9;
   }
      .table {
         margin-top : 30px;
         background-color : white;
         text-align : center;
         opacity:1;
      }
      tbody > tr > td > a{
      	color: black;
      	text-decoration: none;
      }
      tbody > tr > td > a:hover{
      	color: red;
      	text-decoration: none;
      }
       #right {
          margin-top : 20px;
          float : right;
          margin-bottom: 20px;
       }
  </style>

<script>
   $(document).ready(function() {

      function printNotice() {
         $('#notice_print').empty();
         $.ajax({
            url:'/naonnaTest/getNoticeList.do',
            type:'POST',
            dataType: "json",
            contentType : 'application/x-www-form-urlencoded; charset=utf-8',
            //제이슨 형식의 리턴된 데이터는 아래의 data가 받음
            success:function(data) {                                                
               $.each(data, function(index, notice) {                                          
                  var output = '';
                  output += '<tr>';
                  output += '<td> <a link href="notice_datail.do?title='+ notice.title + '">' + notice.title  + '</td>'; 
                  output += '<td>' + notice.writer + '</td>';
                  output += '<td>' + notice.write_date + '</td>';                  
                  output += '</tr>';
                  console.log("output:" + output);
                  $('#notice_print').append(output);                                    
               });                  
               
            },
            error:function() {
               alert("새로고침을 눌러주세요.")
            }
         });
      }
      
      printNotice();
   });
   function res1 (){
      location.href="notice_page.do"

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
         <div class="col-sm-9 col-sm-offset-1">
            <p id="notice_title">공지사항</p>
            <div class="container-fluid notice-table">
               <table class="board-table table">
                  <thead>
                     <tr class="bg-primary">
                        <td>제목</td>
                        <td>작성자</td>
                        <td>등록날짜</td>
                     </tr>
                  </thead>
                  <tbody id="notice_print"></tbody>
               </table>
              <%if(session.getAttribute("nickname").equals("superadmin")){ %>
               <span id="right"><button class="wirte-button btn btn-primary" onclick="res1()">글쓰기</button></span>
               <%} %>
            </div>
         </div>
      </div>
   </div>


</body>
</html>
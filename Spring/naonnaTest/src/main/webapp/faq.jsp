<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="utf-8">
 
 <head>
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
   <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
   <script type="text/javascript" src="js/faq.js"></script>
   <link href="${pageContext.request.contextPath}/resources/naonna_main.css" rel="stylesheet" type="text/css"/>

   <script>
      function faqFunction(idMyDiv){
         var objDiv = document.getElementById(idMyDiv);
         if(objDiv.style.display=="block"){
            objDiv.style.display = "none";
         }else{
            objDiv.style.display = "block";
         }
      }
  </script>
  
  <style>
  .monami {
       background-image : url("https://lh3.googleusercontent.com/-hrYUHGyoYz4/WIz2mUMTahI/AAAAAAAABNM/d6u3yCje50EBAzYhVFMM3nkPCzjYXtCFACJoC/w1366-h768/Download-Fernando-Torres-Free-HD-Football-Wallpapers_Fotor.jpg");
       height : 727px;
     }
     .main {
        margin-top : 150px;
        color : white;
     }
  	.answer{
     	display:none;
     	padding : 0 10px 10px 10px;
     	letter-spacing : 2px;
     	line-height : 1.7;
 	 }
   
      .faqNav{
         width:70%;
         margin-left : 15px;
         margin-top: 20px;
         ;
      }
     .faqTab{
     	margin-left : 15px;
     }
     .question {
     	text-decoration : none;
     	margin-left : 10px;
     	font-size : 16px;
     	font-weight : 550;
     }
     a:focus {
     	text-decoration:none;
     	color : white;
     }
     .question:hover{
        color:red;
        text-decoration : none;
        
     }
     
     table{
     border:1px solid silver;
     margin-top: 5px;
     
     }
     td {
     	border-right : 1px solid silver;
     }
     .thead{
        text-align:center;
        font-size : 16px;
        padding : 10px 0 0 10px;
     }
     .table_number{
        text-align: center;
     }
     
     .faq_filter{
     	background-color: #111;
	    color: #DDD;
	    padding: 15px;
	    border: 3px solid #A52A2A;
	    opacity: 0.9;
     }
     .faqTitle {
     	display : inline-block;
     	margin-left : 15px;
     }
     .faqTabContents {
     	width : 25%;
     	text-align : center;
     	font-size : 18px;
     	letter-spacing : 1.4px;
     	font-weight : 560;
     }
     .answer {
     	margin-top : 15px;
     }
     #menu2, #menu3, #menu4 {
     	margin-top : -56px;
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
   <div class="faq_filter col-sm-10 col-sm-offset-1">
      <div class="faq_name">
         <h2 class="faqTitle">FAQ</h2>
         <p class="faqTitle">자주묻는질문</p>
      </div>
 
      <ul class="nav nav-tabs faqNav">
        <li class="active faqTabContents"><a data-toggle="tab" href="#menu1">대관</a></li>
        <li class="faqTabContents"><a data-toggle="tab" href="#menu2">매칭</a></li>
        <li class="faqTabContents"><a data-toggle="tab" href="#menu3">용병</a></li>
        <li class="faqTabContents"><a data-toggle="tab" href="#menu4">팀</a></li>
      </ul>
 
      <div class="faqTab">
       <div id="menu1" class="tab-pane faqSection fade in active">
          <table>
             <tr>
                <td class="thead" style="width:100px;">번호</td>
                <td class="thead" style="width:600px;">내용</td>
             </tr>
             <tr>
                <td class="table_number" rowspan="2">1</td>
                <td>
                   <a href="#" onclick="faqFunction('faq_01'); return false;" class="question">상품 교환은 가능한가요?</a>
                </td>
             </tr>
             <tr>
                <td>
                  <div class="answer" id="faq_01">질문에 대한 답변 : <br><br>
                                        교환의 경우 동일 상품의 재고가 있을 경우 사이즈 교환만 가능합니다.다른 상품으로 교환을 원하실 경우 반품 후 재주문을 해주셔야 합니다. ※ 교환 신청을 하지 않고 상품을 보내는 경우, 
                                        분실 우려가 있으니 반드시 마이페이지에서 교환 신청해 주셔야 합니다. 
                  </div>
                </td>                
             </tr>
          </table>
       </div>
        <div id="menu2" class="tab-pane fade">
        <!-- <table>
             <tr>
                <td class="thead" style="width:100px;">번호</td>
                <td class="thead" style="width:600px;">내용</td>
             </tr>
             <tr>
                <td class="table_number" rowspan="2">1</td>
                <td>
                   <a href="#" onclick="faqFunction('faq_02'); return false;" class="question">상품 교환은 가능한가요?</a>
                </td>
             </tr>
             <tr>
                <td>
                  <div class="answer" id="faq_02">질문에 대한 답변 : <br><br>
                                        교환의 경우 동일 상품의 재고가 있을 경우 사이즈 교환만 가능합니다.다른 상품으로 교환을 원하실 경우 반품 후 재주문을 해주셔야 합니다. ※ 교환 신청을 하지 않고 상품을 보내는 경우, 
                                        분실 우려가 있으니 반드시 마이페이지에서 교환 신청해 주셔야 합니다. 
                  </div>
                </td>                
             </tr>
          </table> -->
        </div>
        <div id="menu3" class="tab-pane fade">
          <!-- <table>
             <tr>
                <td class="thead" style="width:100px;">번호</td>
                <td class="thead" style="width:600px;">내용</td>
             </tr>
             <tr>
                <td class="table_number" rowspan="2">1</td>
                <td>
                   <a href="#" onclick="faqFunction('faq_03'); return false;" class="question">상품 교환은 가능한가요?</a>
                </td>
             </tr>
             <tr>
                <td>
                  <div class="answer" id="faq_03">질문에 대한 답변 : <br><br>
                                        교환의 경우 동일 상품의 재고가 있을 경우 사이즈 교환만 가능합니다.다른 상품으로 교환을 원하실 경우 반품 후 재주문을 해주셔야 합니다. ※ 교환 신청을 하지 않고 상품을 보내는 경우, 
                                        분실 우려가 있으니 반드시 마이페이지에서 교환 신청해 주셔야 합니다. 
                  </div>
                </td>                
             </tr>
          </table> -->
        </div>
        <div id="menu4" class="tab-pane fade">
           <!-- <table>
             <tr>
                <td class="thead" style="width:100px;">번호</td>
                <td class="thead" style="width:600px;">내용</td>
             </tr>
             <tr>
                <td class="table_number" rowspan="2">1</td>
                <td>
                   <a href="#" onclick="faqFunction('faq_04'); return false;" class="question">상품 교환은 가능한가요?</a>
                </td>
             </tr>
             <tr>
                <td>
                  <div class="answer" id="faq_04">질문에 대한 답변 : <br><br>
                                        교환의 경우 동일 상품의 재고가 있을 경우 사이즈 교환만 가능합니다.다른 상품으로 교환을 원하실 경우 반품 후 재주문을 해주셔야 합니다. ※ 교환 신청을 하지 않고 상품을 보내는 경우, 
                                        분실 우려가 있으니 반드시 마이페이지에서 교환 신청해 주셔야 합니다. 
                  </div>
                </td>                
             </tr>
          </table> -->
        </div>
    </div>
   </div>
   </div>
   </div>
 </body>
 
 </html>
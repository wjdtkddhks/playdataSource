<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>Insert title here</title>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
      <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
      <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
      
      <!-- include summernote css/js -->
      <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
      <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
       <link href="${pageContext.request.contextPath}/resources/naonna_main.css" rel="stylesheet" type="text/css"/>
   <script>
      $(document).ready(function() {
          $('.summernote').summernote({
                height : 300,
                minHeight : null,
                maxHeight : null,
                focus : false,
                lang : 'ko-KR'
              });
      });
      
       function res2(){
            history.go(-1);
         }
   </script>
   <style>
   
      .writing-container {
         background-color : red;
         margin : 120px 0 0 0;
      }
      .writing-headname {
         background-color : white;
         margin : 20px 0; 
      }
      .writing_body{
          margin-top : 100px;
      }
      .head-blank label, .head-blank input {
         display : inline-block;
      }
      #altim {
         float : right;
      }
      #cancelBtn {
         width : 100px;
      }
   </style>
</head>
   <body>
       <jsp:include page="./menu_bar/topnavi.jsp" flush="true"></jsp:include>
 
         <div class="main col-sm-8 col-sm-offset-2 writing_body">
            <div class="writing-form col-sm-12">
            
            
            <form id ="noticeIn" action="noticeinsert.do" method="post">
            <div class="writing-headname">
               <div class="head-blank form-group">
                  <!-- <input type="text" class="form-control" id="writing-title" name="context">    -->               
                  <input type="hidden" name="writer" value="admin" readonly>                  
                  <br>
                  <input type="text" class="form-control" name="title" placeholder="제목">
               </div>
            </div>
            <input type="hidden" class="summernote" name="contents" id="contents" />
            <!-- <div class="summernote" name="contents"></div> -->
            
              <button id="altim" class="btn btn-primary" onclick="showingz()" type="button">작성완료</button>
              </form>
              <button class="btn btn-danger" id="cancelBtn" onclick="res2()">뒤로가기</button>
        
        
        <script>
            var showingz = function() {
              // $('.summernote').append('<input type="hidden" name="Contents", id="Contents" />');
               // $('#Contents').val($('.summernote').code());
              var sHTML = $('.summernote').summernote('code');
              $('#contents').val(sHTML);              
              $('#noticeIn').submit();
            };
  </script>
              </div>
           </div>
        </div>
   </body>
</html>
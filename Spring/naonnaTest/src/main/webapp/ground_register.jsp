<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

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
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
   <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
</head>
<style>
	.monami {
       background-image : url("https://lh3.googleusercontent.com/-hrYUHGyoYz4/WIz2mUMTahI/AAAAAAAABNM/d6u3yCje50EBAzYhVFMM3nkPCzjYXtCFACJoC/w1366-h768/Download-Fernando-Torres-Free-HD-Football-Wallpapers_Fotor.jpg");
       height : 727px;
     }
     .main {
        margin-top : 70px;
     }
     .sideprofile{
     	margin-top: 100px;
     	text-align:center;
     }
	.form-group {
		font-size : 15px;
		color: white;
	}
	.form-group h2{
		margin-left: 30px;
		margin-bottom: 20px;
		margin-top: 10px;
		font-weight: 600;
		letter-spacing: 1.4;
	}
	#multiform {
		border : 2px solid red;
		background-color: #333333;
	  	padding:20px 20px 50px 25px;
	  	width: 100%;
	  	opacity : 0.8;
	  	color: white;
	}
	.control-label{
		margin-left: -10px;
	}
		.shower{
		margin-left: -90px;
	}
	.button-container {
		float : right;
		border: none;
      	outline: 0;
	}
</style>
<body>
	<div class="monami">
			<div class="col-sm-2 sideprofile">
   				<jsp:include page="./menu_bar/sidemenuAdmin_bar.jsp" flush="true"></jsp:include>
   			</div>
   			
		<div class="main col-sm-8 col-sm-offset-1">
		   <form class="form-horizontal" id="multiform" action="insertGround.do" method="post" enctype="multipart/form-data">
				<div class="ground-upload form-group">
					<h2>경기장 등록</h2>
		       	   <label for="inputGroundName" class="col-sm-2 control-label">경기장 이름</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="ground_Name" id="inputGroundName" value=<%=ground_name%>
     			        placeholder="경기장이름">
    		       </div>
   		       	   <label for="inputGroundManagerName" class="col-sm-2 control-label">경기장관리자</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="ground_admin" id="inputGroundManagerName" value=<%=admin%>>
    		       </div>
		       	   <label for="inputGroundSize" class="col-sm-2 control-label">경기장사이즈</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="ground_size" id="inputGroundSize" placeholder="경기장사이즈">
    		       </div>
    		   </div>  
			   <div class="ground-upload form-group">
			       <label for="inputGroundCity" class="col-sm-2 control-label">경기장(구)</label>
			       <div class="col-sm-2">
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
		       	   <label for="inputGroundAddr" class="col-sm-2 control-label">경기장주소</label>
			       <div class="col-sm-4">
     			       <input type="text" class="form-control" name="ground_addr" id="inputGroundAddr" placeholder="경기장주소">
    		       </div>
		       	   
    		   </div> 
			   <div class="ground-upload form-group">
		       	   <label class="col-sm-2 control-label">잔디여부</label>
			       <div class="col-sm-3">
			           <div class="radio-inline">
			       		 <label>
						    <input type="radio" name="grass" id="optionsGrassRadios1" value="인조잔디" checked>
						   인조잔디
						  </label>
					   </div>
					   <div class="radio-inline">
						  <label>
						    <input type="radio" name="grass" id="optionsGrassRadios2" value="천연잔디">
						    천연잔디
						  </label>
					   </div>
    		       </div>
		       	   <label class="col-sm-2 control-label shower ">샤워시설</label>
			       <div class="col-sm-2">
			           <div class="radio-inline">
			       		 <label>
						    <input type="radio" name="shower" id="optionsShowerRadios1" value="있음" checked>
						    있음
						  </label>
					   </div>
					   <div class="radio-inline">
						  <label>
						    <input type="radio" name="shower" id="optionsShowerRadios2" value="없음">
						    없음
						  </label>
					   </div>
    		       </div>
    		   </div>
    		   <div class="ground-upload form-group">
		       	   <label class="col-sm-2 control-label">주차장</label>
			       <div class="col-sm-2">
			           <div class="radio-inline">
			       		 <label>
						    <input type="radio" name="parking" id="optionsParkingRadios1" value="있음" checked>
						    있음
						  </label>
					   </div>
					   <div class="radio-inline">
						  <label>
						    <input type="radio" name="parking" id="optionsParkingRadios2" value="없음">
						    없음
						  </label>
					   </div>
    		       </div>
		       	   <label class="col-sm-2 control-label">조명</label>
			       <div class="col-sm-2">
			           <div class="radio-inline">
			       		 <label>
						    <input type="radio" name="light" id="optionsLightRadios1" value="있음" checked>
						    있음
						  </label>
					   </div>
					   <div class="radio-inline">
						  <label>
						    <input type="radio" name="light" id="optionsLightRadios2" value="없음">
						    없음
						  </label>
					   </div>
    		       </div>
    		   </div> 
    		   <div class="ground-upload form-group">
		       	   <label for="inputGroundWeek_morning" class="col-sm-2 control-label">주간오전요금</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="week_morning" id="inputGroundWeek_morning" placeholder="주간오전요금">
    		       </div>
		       	   <label for="inputGroundWeek_Evening" class="col-sm-2 control-label">주간오후요금</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="week_evening" id="inputGroundWeek_Evening" placeholder="주간오전요금">
    		       </div>
    		   </div>
    		   <div class="ground-upload form-group">
		       	   <label for="inputGroundWeek_morning" class="col-sm-2 control-label">주말오전요금</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="weekend_morning" id="inputGroundWeek_morning" placeholder="주간오전요금">
    		       </div>
		       	   <label for="inputGroundWeekend_Evening" class="col-sm-2 control-label">주말오후요금</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="weekend_evening" id="inputGroundWeekend_Evening" placeholder="주말오전요금">
    		       </div>
    		   </div>
    		   <div class="ground-upload form-group">
		       	   <label for="inputGroundRule" class="col-sm-2 control-label">이용규칙</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="rule" id="inputGroundRule" placeholder="이용규칙">
    		       </div>
		       	   <label for="inputGroundPeople" class="col-sm-2 control-label">수용인원</label>
			       <div class="col-sm-2">
     			       <input type="text" class="form-control" name="ground_people" id="inputGroundPeople" placeholder="수용인원">
    		       </div>
    		   </div>     
		       <div class="ground-upload form-group">
		       	   <label for="inputFile1" class="col-sm-2 control-label">경기장사진1</label>
			       <div class="col-sm-6">
     			       <input type="file" class="form-control" name="imgfile1" id="inputFile1">
    		       </div>
    		   </div>
    		   <div class="ground-upload form-group">
		       	   <label for="inputFile2" class="col-sm-2 control-label">경기장사진2</label>
			       <div class="col-sm-6">
     			       <input type="file" class="form-control" name="imgfile2" id="inputFile2">
    		       </div>
    		   </div>
    		   <div class="ground-upload form-group">
		       	   <label for="inputFile3" class="col-sm-2 control-label">경기장사진3</label>
			       <div class="col-sm-6">
     			       <input type="file" class="form-control" name="imgfile3" id="inputFile3">
    		       </div>
    		   </div>
		       <div class="button-container"><input class="btn btn-success" type="submit" value="등록"/></div>
		   </form>
		   
   		</div>
     </div>
</body>
</html>
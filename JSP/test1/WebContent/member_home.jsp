<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<!-- Boot Strap -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<script>
//로그인 양식 체크
function logincheck()
{
	var email=loginform.MEMBER_EMAIL.value;
	var password=loginform.MEMBER_PASSWORD.value;
	
	if(email.length == 0){
		alert("이메일를 입력하세요.");
		loginform.MEMBER_EMAIL.focus();
		return false;
	}
	if(password.length == 0){
		alert("비밀번호를 입력하세요.");
		loginform.MEMBER_PASSWORD.focus();
		return false;
	}
	
	return true;
}

//회원가입 양식 체크
function joincheck()
{
	var email=joinform.MEMBER_EMAIL.value;
	var nickname=joinform.MEMBER_NICKNAME.value;
	var password1=joinform.MEMBER_PASSWORD.value;
	var password2=joinform.MEMBER_PASSWORD2.value;

	if(email.length == 0){
		alert("이메일을 입력하세요.");
		joinform.MEMBER_EMAIL.focus();
		return false;
	}
	if (nickname.length == 0){
		alert("닉네임을 입력하세요.");
		joinform.MEMBER_NICKNAME.focus();
        return false;
	}
	if(password1.length == 0){
		alert("비밀번호를 입력하세요.");
		joinform.MEMBER_PASSWORD.focus();
		return false;
	} 
	if(password1 != password2){
		alert("비밀번호가 일치하지 않습니다.");
		joinform.MEMBER_PASSWORD.value="";
		joinform.MEMBER_PASSWORD2.value="";
		joinform.MEMBER_PASSWORD.focus();
		return false;
	}
	
	return true;
}

//비밀번호 찾기
function openConfirmPassword(loginform)
{	
	var url="./MemberFind.me";
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=450px,height=300");
}

//이메일 중복확인
function openConfirmEMAIL(joinform){			
	var email=joinform.MEMBER_EMAIL.value;
	var url="./MemberEMAILCheckAction.me?MEMBER_EMAIL="+joinform.MEMBER_EMAIL.value;
	
	if(email.length == 0){
		alert("이메일을 입력하세요.");
		joinform.MEMBER_EMAIL.focus();
		return false;
	}
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=450,height=300");
}

//닉네임 중복확인
function openConfirmNICKNAME(joinform){			
	var nickname=joinform.MEMBER_NICKNAME.value;
	var url="./MemberNICKNAMECheckAction.me?MEMBER_NICKNAME="+joinform.MEMBER_NICKNAME.value;
	
	if(nickname.length == 0){
		alert("닉네임을 입력하세요.");
		joinform.MEMBER_NICKNAME.focus();
		return false;
	}
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=450,height=300");
}
</script>

<!-- 프로필 사진 업로드 -->
<script type="text/javascript">
$(function() 
{
	$("#inputPicture").on('change', function(){
    	readURL(this);
    });
});

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
        reader.onload = function (e) {
        	$('#image').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function readTrue(){
	if(document.joinform.push.value == 1){
		document.joinform.submit;
	}else{
		alert('중복체크를 해주세요');
		return false;
	}
	
}
</script>
<title>메인화면</title>
</head>

<body>
<br/>&nbsp;

<!-- Small modal(로그인) -->
<button type="button" class="btn btn-link" data-toggle="modal" data-target=".bs-example-modal-sm">로그인</button>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">막걸리 Guide</h4>
    <form action="./MemberLoginAction.me" method=post name=loginform onsubmit="return logincheck()">
    <div class="modal-body">
        <div class="form-group">
            <input type="email" class="form-control" id="recipient-name" name="MEMBER_EMAIL" placeholder="이메일을 입력하세요.">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="recipient-name" name="MEMBER_PASSWORD" placeholder="비밀번호">
        </div>
        <input type="button" class="btn btn-link" value="아이디/비밀번호 찾기" onclick="openConfirmPassword(this.form)">
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button type="submit" class="btn btn-primary">로그인</button>
    </div>
    </form>
    </div>
    </div>
  </div>
</div>

/

<!-- Large modal(회원가입) -->
<button type="button" class="btn btn-link" data-toggle="modal" data-target=".bs-example-modal-lg">회원가입</button>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">막걸리 Guide</h4>
    <form class="form-horizontal" name="joinform" id="joinform" action="./MemberJoinAction.me" method="post" onsubmit="return joincheck()">
    <input type='hidden' name='push' id='push' />
    <div class="modal-body">
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">이메일</label>
        <div class="col-sm-6">
            <input type="email" class="form-control" id="inputEmail" name="MEMBER_EMAIL">
        </div>
        <div class="col-sm-2">
            <input type="button" class="btn btn-default" name="confirm_email" value="중복확인" onclick="openConfirmEMAIL(this.form)">
        </div>
        </div>
        <div class="form-group">
            <label for="inputNickname" class="col-sm-2 control-label">닉네임</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputNickname" name="MEMBER_NICKNAME">
        </div>
        <div class="col-sm-2">
            <input type="button" class="btn btn-default" name="confirm_nickname" value="중복확인" onclick="openConfirmNICKNAME(this.form)">
        </div>
        </div>
        <div class="form-group">
            <label for="inputPicture" class="col-sm-2 control-label">프로필 사진</label>
        <div class="col-sm-2">
            <img id="image" src="./image/profile.svg" class="img-rounded" width="140" height="140">
        </div>
        <div class="col-sm-8">
            <br><br><br><br><br><br>
            <input type='file' id="inputPicture" name="MEMBER_PICTURE" accept="image/*">
        </div>
        </div>
        <div class="form-group">
            <label for="inputPassword1" class="col-sm-2 control-label">비밀번호</label>
        <div class="col-sm-8">
            <input type="password" class="form-control" id="inputPassword1" name="MEMBER_PASSWORD">
        </div>
        </div>
        <div class="form-group">
            <label for="inputPassword2" class="col-sm-2 control-label">비밀번호 확인</label>
        <div class="col-sm-8">
            <input type="password" class="form-control" id="inputPassword2" name="MEMBER_PASSWORD2">
        </div>
        </div>
        <div class="form-group">
            <label for="inputArea" class="col-sm-2 control-label">관심 지역</label>
        <div class="col-sm-8">
            <select class="form-control" name="MEMBER_AREA">
                <option value="서울">서울</option>
                <option value="부산">부산</option>
                <option value="대구">대구</option>
                <option value="인천">인천</option>
                <option value="광주">광주</option>
                <option value="대전">대전</option>
                <option value="울산">울산</option>
                <option value="울산">세종</option>
                <option value="경기">경기</option>
                <option value="강원">강원</option>
                <option value="충북">충북</option>
                <option value="충남">충남</option>
                <option value="전북">전북</option>
                <option value="전남">전남</option>
                <option value="경북">경북</option>
                <option value="경남">경남</option>
                <option value="제주">제주</option>
            </select>
        </div>
        </div>
        <div class="form-group">
            <label for="inputCountry" class="col-sm-2 control-label">국가</label>
        <div class="col-sm-8">
            <select class="form-control" name="MEMBER_COUNTRY">
                <option value="대한민국(KOR)">대한민국(KOR)</option>
                <option value="미국(USA)">미국(USA)</option>
                <option value="일본(JAP)">일본(JAP)</option>
            </select>
        </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button type="submit" class="btn btn-primary" onsubmit='return readTrue()'>회원가입</button>
    </div>
    </form>
    </div>
    </div>
  </div>
</div>
</body>
</html>
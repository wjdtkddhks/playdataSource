<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>카카오페이</title>
    <meta charset="utf-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
    <link rel="stylesheet" type="text/css" href="//t1.daumcdn.net/kakaopay/tesla/20180108/pg_web/css/common.min.css">
    <script src="//t1.daumcdn.net/kakaopay/tesla/20180108/pg_web/js/lib/jquery.min.js"></script>
<script>
		/* var hash = "64de5f22bbee8299f394c084ec1c7a58e56694e528aa41aeb21186cee65de062";
		var failUrl = "https://developers.kakao.com/payment/web/fail/b072d95b-6a78-4dcc-a384-55d69945f8b0";
		var remainingSec = 894;
		var cancelUrl = "https://developers.kakao.com/payment/web/cancel/b072d95b-6a78-4dcc-a384-55d69945f8b0";
		var isCancelPost = false;
		var isFailPost = false;
		var isApprovalPost = false; */
		 var hash = "6d2439a7875de774d196f898def5a53b3eff5f28f56505cb9097a73d209bcdc7";
        var failUrl = "https://developers.kakao.com/payment/web/fail/2e079972-951b-4ef1-84d6-9c838014c723";
        var remainingSec = 900;
        var cancelUrl = "https://developers.kakao.com/payment/web/cancel/2e079972-951b-4ef1-84d6-9c838014c723";
        var isCancelPost = false;
        var isFailPost = false;
        var isApprovalPost = false;
        
        $(document).ready(function() {
           
           IMP.init('imp02341854');
           
           $('#imp').on('click', function() {
               alert("음?");
               IMP.request_pay({
                   pg : 'inicis', // version 1.1.0부터 지원.
                   pay_method : 'card',
                   merchant_uid : 'merchant_' + new Date().getTime(),
                   name : '주문명:결제테스트',
                   amount : 14000,
                   buyer_email : 'iamport@siot.do',
                   buyer_name : '구매자이름',
                   buyer_tel : '010-1234-5678',
                   buyer_addr : '서울특별시 강남구 삼성동',
                   buyer_postcode : '123-456',
                   m_redirect_url : 'https://www.yourdomain.com/payments/complete'
               }, function(rsp) {
                   if ( rsp.success ) {
                       var msg = '결제가 완료되었습니다.';
                       msg += '고유ID : ' + rsp.imp_uid;
                       msg += '상점 거래ID : ' + rsp.merchant_uid;
                       msg += '결제 금액 : ' + rsp.paid_amount;
                       msg += '카드 승인번호 : ' + rsp.apply_num;
                   } else {
                       var msg = '결제에 실패하였습니다.';
                       msg += '에러내용 : ' + rsp.error_msg;
                   }
                   alert(msg);
               });
            });
        });

	</script>
	
	<script src="//t1.daumcdn.net/kakaopay/tesla/20180108/pg_web/js/lib/spin.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/common_payment.js?v=version"></script>

<script src="${pageContext.request.contextPath}/resources/web_waiting.js?v=version"></script>
</head>
<body>

<div id="payPopupDiv" class="pay_popup hide">
    <div class="inner_terms_layer">
        <div class="layer_head">
            <strong class="tit_terms">제목</strong>
        </div>
        <div class="layer_body">
            <div class="desc_terms">
                내용
            </div>
        </div>
        <div class="layer_foot">
            <button type="button" class="btn_terms">확인</button>
        </div>
    </div>
</div>

<div id="payAlertDiv" class="hide">
    <div class="agree_layer">
        <div class="inner_agree_layer inner_agree_layer2">
            <div class="layer_body">
                <div class="desc_agree"></div>
            </div>
            <div class="layer_foot">
                <button id="alertOkButton" class="btn_layer">확인</button>
            </div>
        </div>
    </div>
</div>

<div id="payConfirmDiv" class="hide">
    <div class="agree_layer">
        <div class="inner_agree_layer inner_agree_layer2">
            <div class="layer_body">
                <strong class="desc_agree">카카오페이 결제를 중단하시겠습니까?</strong>
            </div>
            <div class="layer_foot">
                <button id="confirmCancelButton" class="btn_layer2">취소</button>
                <button id="confirmOkButton" class="btn_layer2">확인</button>
            </div>
        </div>
    </div>
</div>

<script>

    <!-- /* ---------------------------------- 곧 제거 될 것 임 ------------------------------------------ */ -->
    function closeTalkPgWebview() {
        
        window.location = "app://kakaopay/close";
    }

    function payPopup(title, msg) {
        var payPopupDiv = $("#payPopupDiv");
        payPopupDiv.removeClass("hide");
        $("body").addClass("layer_on");
        $(".tit_terms", payPopupDiv).html(title);
        $(".desc_terms", payPopupDiv).html(msg);

        $(".btn_terms", payPopupDiv).click(function() {
            $("body").removeClass("layer_on");
            payPopupDiv.addClass("hide");
        });
    }

    function payAlert(msg, onOk) {
        $("#payAlertDiv").removeClass("hide");
        $("body").addClass("layer_on");
        $(".desc_agree").html(msg);
        $("#alertOkButton").click(function() {
            $("body").removeClass("layer_on");
            $("#payAlertDiv").addClass("hide");
            if(onOk) {
                onOk();
            }
        });
    }

    function payConfirm(msg, onOk, onCancel) {
        $("#payConfirmDiv").removeClass("hide");
        $("body").addClass("layer_on");
        $(".desc_agree").html(msg);

        hide = function () {
            $("body").removeClass("layer_on");
            $("#payConfirmDiv").addClass("hide");
        };

        $("#confirmOkButton").click(function () {
            hide();
            onOk();
        });
        $("#confirmCancelButton").click(function () {
            hide();
            if (onCancel) {
                onCancel();
            }
        });
    }
    <!-- /* ---------------------------------- 곧 제거 될 것 임 ------------------------------------------ */ -->


    (function() {
        function closeTalkPgWebview() {
            
            window.location = "app://kakaopay/close";
        }

        function payPopup(title, msg) {
            var payPopupDiv = $("#payPopupDiv");
            payPopupDiv.removeClass("hide");
            $("body").addClass("layer_on");
            $(".tit_terms", payPopupDiv).html(title);
            $(".desc_terms", payPopupDiv).html(msg);

            $(".btn_terms", payPopupDiv).click(function() {
                $("body").removeClass("layer_on");
                payPopupDiv.addClass("hide");
            });
        }

        function payAlert(msg, onOk) {
            $("#payAlertDiv").removeClass("hide");
            $("body").addClass("layer_on");
            $(".desc_agree").html(msg);
            $("#alertOkButton").click(function() {
                $("body").removeClass("layer_on");
                $("#payAlertDiv").addClass("hide");
                if(onOk) {
                    onOk();
                }
            });
        }

        function payConfirm(msg, onOk, onCancel) {
            $("#payConfirmDiv").removeClass("hide");
            $("body").addClass("layer_on");
            $(".desc_agree").html(msg);

            hide = function () {
                $("body").removeClass("layer_on");
                $("#payConfirmDiv").addClass("hide");
            };

            $("#confirmOkButton").click(function () {
                hide();
                onOk();
            });
            $("#confirmCancelButton").click(function () {
                hide();
                if (onCancel) {
                    onCancel();
                }
            });
        }

        window.teslaBaseCommon = {
            closeTalkPgWebview: closeTalkPgWebview,
            payPopup: payPopup,
            payAlert: payAlert,
            payConfirm: payConfirm
        };

    })();

</script>

<div class="kakaopay_layer">
		<span class="dimmed_layer loading_layer" style="display:none"></span>
		<span id="spin"></span>
		<div class="inner_kakaopay">
			<div class="layer_head">
				<strong class="img_pay logo_kakaopay">kakaopay</strong>
			</div>
			<div class="layer_body">
				<p class="txt_step">입력하신 휴대폰 번호로<br>결제 메시지가 전송되었습니다.</p>
				<form>
					<fieldset>
						<legend class="screen_out">휴대폰 번호 및 생년월일 입력</legend>
						<ol class="list_order">
							<li><em class="emph_num">1</em>휴대폰에서 카카오페이 결제 후, </li>
							<li><em class="emph_num">2</em><em class="emph_info">하단의 결제 완료 버튼</em>을 눌러주세요.</li>
						</ol>
						<div class="area_btn">
							<button type="submit" class="btn_submit">결제 완료</button>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="layer_foot">
				<button class="btn_close"><span class="img_pay">닫기</span></button>
			</div>
		</div>
		<form id="approvalPost" action="approval" method="post">
		</form>
	</div>
</body>
</html>
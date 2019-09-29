2<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.bootpay.co.kr/js/bootpay-3.0.2.min.js" type="application/javascript"></script>
<title>등록관리</title>
</head>
<style>
		#searchInfo {
			float:left;
		}
		
		.table {
			text-align:center;
		}
		th {
			border:1px solid lightgray;
		}
		
		tr {
			border:1px solid lightgray;
		}
		
		td {
			border:1px solid lightgray;
		}
		
</style>
<SCRIPT type="text/javascript">
	$(function(){
		// 결제 버튼 클릭 시
		$('button[name=paymentBtn]').click(function(){
			console.log("in")
			var studentNo = $(this).parents('tr').children().eq(1).html();
			var propTrxSeq = 'rentOrder' + '_' + $(this).parents('tr').children().eq(1).html();
			var count = 1;
			var cat1 = '등록';
			console.log("studentNo :::" + studentNo);
			BootPay.request({
				price: '100', //실제 결제되는 가격
				application_id: "59a4d323396fa607cbe75de4",
				name: 'KH대학교 등록금 결제', //결제창에서 보여질 이름
				pg: 'danal',
				method: 'card', //결제수단, 입력하지 않으면 결제수단 선택부터 화면이 시작합니다.
				show_agree_window: 1, // 부트페이 정보 동의 창 보이기 여부
				items: [
					{
						item_name: '등록금 결제', //상품명
						qty: 1, //수량
						unique: studentNo, //해당 상품을 구분짓는 primary key
						price: 100, //상품 단가
						cat1: '등록', // 대표 상품의 카테고리 상, 50글자 이내
					}
				],
				order_id: propTrxSeq, //고유 주문번호로, 생성하신 값을 보내주셔야 합니다.
			}).error(function (data) {
				//결제 진행시 에러가 발생하면 수행됩니다.
				console.log('error');
				console.log(data);
			}).cancel(function (data) {
				//결제가 취소되면 수행됩니다.
				console.log('cancel');
				console.log(data);
			}).ready(function (data) {
				// 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
				console.log('ready');
				console.log(data);
			}).confirm(function (data) {
				//결제가 실행되기 전에 수행되며, 주로 재고를 확인하는 로직이 들어갑니다.
				//주의 - 카드 수기결제일 경우 이 부분이 실행되지 않습니다.
				console.log('confirm');
				console.log(data);
				var enable = true; // 재고 수량 관리 로직 혹은 다른 처리
				if (enable) {
					this.transactionConfirm(data); // 조건이 맞으면 승인 처리를 한다.
				} else {
					this.removePaymentWindow(); // 조건이 맞지 않으면 결제 창을 닫고 결제를 승인하지 않는다.
				}
			}).close(function (data) {
			    // 결제창이 닫힐때 수행됩니다. (성공,실패,취소에 상관없이 모두 수행됨)
			    console.log('close');
			    console.log(data);
			}).done(function (data) {
				//결제가 정상적으로 완료되면 수행됩니다
				//비즈니스 로직을 수행하기 전에 결제 유효성 검증을 하시길 추천합니다.
				console.log('done');
				console.log(data);
				console.log('승인 완료?');
				paymentTrx(studentNo);
			});
		});
		function paymentTrx(studentNo) {
			console.log('paymentTrx in');
			$.ajax({
				url: 'enrollment.en',
				data: {studentNo:studentNo},
				method: 'POST',
				async: false,
				success: function(data){
					console.log("data ::: " + data)
					console.log("succ");
					if(data = 2){
						alert("결제되었습니다.");
						location.href="updateEnrollment.en";
					} else {
						alert("결제가 실패되었습니다.");
					}
				},
				error: function(){
					console.log("error");
				}
			});
		}
	});
</SCRIPT>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			
			<br>
					        
	  				<h2>등록금 납부 결과 조회</h2>	
					<div style="border:1.5px solid lightgray;" height="100px">
					 	&nbsp;&nbsp;&nbsp;- 입학년도 1학기부터 등록금납부확인증 발급이 가능합니다.<br>
						&nbsp;&nbsp;&nbsp;- 본 화면에서 발급된 등록금납부확인증은 연말정산용 서류 제출용으로 불가합니다.<br>
						&nbsp;&nbsp;&nbsp;- 연말정산 제출용 교육비납입증명서 신청은 우편발급 또는 인터넷제증명자동발급을 통하여 신청하여주시기 바랍니다.<br>
						
					</div>

					<hr>
					<c:if test="${ !empty memberEnrollment }">
					<div class="container">         
	  					<table class="table" text-align="center" style="border:2px solid lightgray">
	  					  <thead style="background-color:#eff1f2">
	  					  	<tr>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">년도학기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">등록금</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">감면액</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">납부한 금액</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">등록금 확인증 출력</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">납부하기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">비고</th>
	 					    </tr>
	 					   </thead> 
	 					   <tbody>
	 					   <c:forEach var="enrollment" items="${ memberEnrollment }">
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ enrollment.enrollYear }"/>학년도 <c:out value="${ enrollment.enrollSemester }"/>학기</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><fmt:formatNumber value="${ enrollment.tuition }" pattern="#,###"/> 원</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">[장학]<br><fmt:formatNumber value="${ enrollment.schoAmount }" pattern="#,###"/> 원</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><fmt:formatNumber value="${ enrollment.payAmount }" pattern="#,###"/> 원</td>
	     					   <c:if test="${ enrollment.payStatus == 'Y'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="print.en" style="border-bottom: dotted 0px;">출력하기</a></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">해당없음</td>
	     					   </c:if>
	     					   <c:if test="${ enrollment.payStatus == 'N'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">해당없음</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><button type="submit" class="paymentBtn" id="paymentBtn" name="paymentBtn" style="border-bottom: dotted 0px;">납부하기</button></td>
	     					   </c:if>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
	  					    </tr>
	  					    </c:forEach>
	   					    <!-- <tr style="background-color:white">
	    					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019년도 1학기</td>
	    					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">1,440,000 원</td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">[장학]<br> 1,440,000 원<br>[이월]<br>0 원 </td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">0 원</td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="#" style="border-bottom: dotted 0px;">출력하기</a></td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="#" style="border-bottom: dotted 0px;">출력하기</a></td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
	      	   			    </tr> -->
	  					  </tbody>
					  </table>
				</div>
				</c:if>
				<c:if test="${ empty memberEnrollment }">
					<h4 align="center">조회결과가 없습니다.</h4>
				</c:if>
			</div>
		</div>
		
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>
</body>
</html>

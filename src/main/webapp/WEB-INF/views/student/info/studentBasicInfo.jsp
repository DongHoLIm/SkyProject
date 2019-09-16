<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
#basic {
	padding: 10px 0px 0px 100px;
}

table.basicinfo td {
	background: #FFF;
}

td.td {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	width: 100px !important;
}

table.basicinfo {
	width: 85%;
	border: 1px solid #dde1e3;
	margin-left: auto;
	margin-right: auto;
}

#modified {
	margin-left: 80%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<h4 id="basic">기본 정보</h4>
			<form class="ba">
				<table class="basicinfo">
					<tr>
						<td class="td">학번</td>
						<td colspan='5'>${personalInfo.studentNo }</td>
					</tr>

					<tr>
						<td class="td" width="15%">한글 성명</td>
						<td width="21%">${personalInfo.kName }</td>
						<td class="td" width="15%">영문 성명</td>
						<td width="21%">${personalInfo.eName }</td>
						<td class="td" width="15%">한문 성명</td>
						<td width="13%"></td>
					</tr>



					<tr>
						<td class="td">주민 번호</td>
						<td>${personalInfo.memberNo }</td>
						<td class="td">생년월일</td>
						<td></td>
						<td class="td">성별</td>
						<td></td>
					</tr>

					<%-- <c:set var="major" value="<%= %>"/> --%>

					<tr>
						<td class="td">학과</td>
						<td>${personalInfo.sdeptName }</td>
						<td class="td">전공</td>
						<td></td>
						<td class="td">학년</td>
						<td>${personalInfo.grade }</td>
					</tr>

					<tr>
						<td class="td">학적 상태</td>
						<td>${personalInfo.studentStatus }</td>
						<td class="td">주야</td>
						<td></td>
						<td class="td">병역 구분</td>
						<td></td>
					</tr>

				</table>


				<!-- 신상 정보 조회 -->
				<h4 id="basic">신상 정보 조회</h4>
				<table class="basicinfo">
					<tr>
						<td class="td">한글 성명</td>
						<td><input type="text" value="${personalInfo.kName }" ></td>
						<td class="td">영문 성명</td>
						<td><input type="text" value="${personalInfo.eName }"></td>
						<td class="td">한문 성명</td>
						<td><input type="text" value=""></td>
					</tr>

					<tr>
						<td class="td">주소</td>
						<td colspan='5'>
							<input style="display: inline-block;" type="button" onclick="findAddress1();" value="검색"> &nbsp; 
							<input style="width: 10%; display: inline-block;" type="text" id="postcode1" placeholder="우편번호"> 
							<input style="width: 55%; display: inline-block;" type="text" id="address1" placeholder="${personalInfo.address }"> 
							<input style="width: 25%; display: inline-block;" type="text" id="detailAddress1" placeholder="상세주소">
						</td>
					</tr>
					<!-- <td class="td">주민등록 주소지</td>
	            	<td colspan='5'><input type="checkbox" id="checkadd">
	            					<input style="width: 50%; display: inline-block;" type="text" value="서울시 역삼동" readonly>
	            				    <input style=" display: inline-block; width:30%;" type="text" value="체르노빌 201호">
	            					<input style=" display: inline-block;" type="button" value="검색">				
	            	</td> -->

					<tr>
						<td class="td">전자 우편</td>
						<td><input type="text" value="${personalInfo.email }"></td>
						<td class="td">연락처</td>
						<td><input type="text" value="${personalInfo.phone }"></td>
						<td class="td">비상 연락처</td>
						<td><input type="text" value="${personalInfo.phone2 }"></td>
					</tr>


					<tr>
						<td class="td">은행명</td>
						<td><select name='bank'>
								<option value='select' selected>-- 선택 --</option>
								<option value='신한은행'>신한은행</option>
								<option value='국민은행'>국민은행</option>
								<option value='우리은행'>우리은행</option>
								<option value='하나은행'>하나은행</option>
								<option value='농협'>농협</option>
								<option value='카카오뱅크'>카카오뱅크</option>
						</select></td>
						<td class="td">계좌 번호</td>
						<td><input type="text" value="${personalInfo.accountNo }"></td>
						<td class="td">예금주</td>
						<td><input type="text" value="${personalInfo.accountHolder }"></td>
					</tr>

				</table>

				<table class="basicinfo">
					<tr>
						<td class="td">보호자성명</td>
						<td><input type="text" value="홍길동"></td>
						<td class="td">보호자관계</td>
						<td><select name='pa'>
								<option value='parents' selected>-- 선택 --</option>
								<option value='father'>부</option>
								<option value='mather'>모</option>
						</select></td>
						<td class="td">보호자연락처</td>
						<td><input type="text" value="010-9478-2687"></td>

					</tr>
					<tr>
						<td class="td">보호자주소</td>
						<td colspan='5'>
							<input style="display: inline-block;" type="button" onclick="findAddress2();" value="검색"> &nbsp; 
							<input style="width: 10%; display: inline-block;" type="text" id="postcode2" placeholder="우편번호"> 
							<input style="width: 55%; display: inline-block;" type="text" id="address2" placeholder="주소"> 
							<input style="width: 25%; display: inline-block;" type="text" id="detailAddress2" placeholder="상세주소">
						</td>
					</tr>

					<table id="modified">
						<input type="button" value="신상정보 수정" id="modified">
					</table>

				</table>
			</form>
		</div>

		<script>
		
		function findAddress1(){
			console.log("함수 들어옴");
		new daum.Postcode({
	        oncomplete: function(data) {
	        	//data는 사용자가 선택한 주소 정보를 담고 있는 객체
	            //팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
	            
	            var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                var detailAddr = '' //상세주소
	            
              	//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
                
            	 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("extraAddress").value = extraAddr;
                    addr += extraAddr;
                
                } else {
                    //document.getElementById("extraAddress").value = '';
                	addr += extraAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode1').value = data.zonecode;
                document.getElementById("address1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress1").focus();
            }   
	      
	    }).open();
		
		}
		
		
		function findAddress2(){
			console.log("함수 들어옴");
		new daum.Postcode({
	        oncomplete: function(data) {
	        	//data는 사용자가 선택한 주소 정보를 담고 있는 객체
	            //팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
	            
	            var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                var detailAddr = '' //상세주소
	            
              	//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
                
            	 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("extraAddress").value = extraAddr;
                    addr += extraAddr;
                
                } else {
                    //document.getElementById("extraAddress").value = '';
                	addr += extraAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode2').value = data.zonecode;
                document.getElementById("address2").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress2").focus();
            }   
	      
	    }).open();
		
		}
		
		</script>


		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
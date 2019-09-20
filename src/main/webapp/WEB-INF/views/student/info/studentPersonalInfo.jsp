<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
 <link rel="stylesheet" href="resources/css/main.css" />
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
			
			<jsp:include page="../info/common.jsp" />
			
			

				<!-- 신상 정보 조회 -->
				<h4 id="basic">신상 정보 조회</h4>
				<form action="st_changePersonalInfo.si" method="post">
				
				<c:set var="studentAddress" value="${personalInfo.address }"/>
				<c:set var="studentAddressArr" value="${ fn:split(studentAddress, '/') }"/>
				
				<table class="basicinfo">
					<tr>
						<td class="td">한글 성명</td>
						<td><input type="text" name="kName" value="${personalInfo.kName }" readonly></td>
						<td class="td">영문 성명</td>
						<td><input type="text" name="eName" value="${personalInfo.eName }"></td>
						<td class="td">한문 성명</td>
						<td><input type="text" value=""></td>
					</tr>

					<tr>
						<td class="td">주소</td>
						<td colspan='5'>
							<input style="display: inline-block;" type="button" onclick="findAddress1();" value="검색"> &nbsp; 
							<c:forEach items="${ studentAddressArr }" varStatus="st">
							<c:if test="${ st.index == 0 }">
								<input style="width: 10%; display: inline-block;" type="text" id="postcode1" name="postcode1" value="${ studentAddressArr[st.index] }"> 
							</c:if>
							<c:if test="${ st.index == 1 }">
								<input style="width: 55%; display: inline-block;" type="text" id="address1" name="address1" value="${ studentAddressArr[st.index] }"> 
							</c:if>
							<c:if test="${ st.index == 2 }">
								<input style="width: 25%; display: inline-block;" type="text" id="detailAddress1" name="detailAddress1" value="${ studentAddressArr[st.index] }">
							</c:if>
							
						</c:forEach>
						
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
						<td><input type="text" name="email" value="${personalInfo.email }"></td>
						<td class="td">연락처</td>
						<td><input type="text" name="phone" value="${personalInfo.phone }"></td>
						<td class="td">비상 연락처</td>
						<td><input type="text" name="phone2" value="${personalInfo.phone2 }"></td>
					</tr>


					<tr>
						<td class="td">은행명</td>
						<td><select id="bank" name="bank">
								<option value='select'>-- 선택 --</option>
								<option value='신한은행'>신한은행</option>
								<option value='국민은행'>국민은행</option>
								<option value='우리은행'>우리은행</option>
								<option value='하나은행'>하나은행</option>
								<option value='농협'>농협</option>
								<option value='카카오뱅크'>카카오뱅크</option>
						</select></td>
						<td class="td">계좌 번호</td>
						<td><input type="text" name="accountNo" value="${personalInfo.accountNo }"></td>
						<td class="td">예금주</td>
						<td><input type="text" name="accountHolder" value="${personalInfo.accountHolder }"></td>
					</tr>

				</table>
				
				
				<c:set var="parentsAddress" value="${personalInfo.parentsAddress }"/>
				<c:set var="parentsAddressArr" value="${ fn:split(parentsAddress, '/') }"/>
				
				<table class="basicinfo">
					<tr>
						<td class="td">보호자성명</td>
						<td><input type="text" name="parentsName" value="${personalInfo.parentsName }"></td>
						<td class="td">보호자관계</td>
						<td><select id='parent' name="parentsRelation">
								<option value='parents' selected>-- 선택 --</option>
								<option value='부'>부</option>
								<option value='모'>모</option>
						</select></td>
						<td class="td">보호자연락처</td>
						<td><input type="text" name="parentsPhone" value="${personalInfo.parentsPhone }"></td>

					</tr>
					<tr>
						<td class="td">보호자주소</td>
						<td colspan='5'>
						<input style="display: inline-block;" type="button" onclick="findAddress2();" value="검색"> &nbsp; 
						<c:forEach items="${ parentsAddressArr }" varStatus="pa">
							<c:if test="${ pa.index == 0 }">
								<input style="width: 10%; display: inline-block;" type="text" id="postcode2" name="postcode2" value="${ parentsAddressArr[pa.index] }"> 
							</c:if>
							<c:if test="${ pa.index == 1 }">
								<input style="width: 55%; display: inline-block;" type="text" id="address2" name="address2" value="${ parentsAddressArr[pa.index] }"> 
							</c:if>
							<c:if test="${ pa.index == 2 }">
								<input style="width: 25%; display: inline-block;" type="text" id="detailAddress2" name="detailAddress2" value="${ parentsAddressArr[pa.index] }">
							</c:if>
							
						</c:forEach>
						
						
						</td>
					</tr>

					<table id="modified">
						<button type="submit" id="modified">신상정보 수정</button> 
						<!-- <input type="button" id="modified" onclick="changeInfo();" value="신상정보 수정" > -->
					</table>
				</table>
			</form>
		</div>

		<script>
		
		$(function(){
			console.log("은행함수호출");
			
			var bankCount = $("#bank option").length;
			console.log("bankCount::" + bankCount);
			
			var bank = '${personalInfo.bank }';
			console.log(bank);
			
			for(var i=0 ; i<bankCount ; i++){
				var option = $("#bank").children().eq(i).val();
				if(option==bank){
					console.log(option);
					$("#bank").children().eq(i).attr("selected","selected");
				}
			}
		});
		
		
		$(function(){
			console.log("부모관계함수호출");
			
			var relCount = $("#parent option").length;
			console.log("relCount::" + relCount);
			
			var rel = '${personalInfo.parentsRelation }';
			console.log(rel);
			
			for(var i=0 ; i<relCount ; i++){
				var option = $("#parent").children().eq(i).val();
				if(option==rel){
					console.log(option);
					$("#parent").children().eq(i).attr("selected","selected");
				}
			}
		});
		
		
		function findAddress1(){
			console.log("함수 들어옴");
		new daum.Postcode({
	        oncomplete: function(data) {
	        	
	            var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                
                if (data.userSelectedType === 'R') { 
                    addr = data.roadAddress;
                } else { 
                    addr = data.jibunAddress;
                }
                
                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    //document.getElementById("extraAddress").value = extraAddr;
                    addr += extraAddr;
                
                } else {
                    //document.getElementById("extraAddress").value = '';
                	addr += extraAddr;
                }

                document.getElementById('postcode1').value = data.zonecode;
                document.getElementById("address1").value = addr;
               
                document.getElementById("detailAddress1").focus();
            }   
	      
	    }).open();
		
		}
		
		
		function findAddress2(){
			console.log("함수 들어옴");
		new daum.Postcode({
	        oncomplete: function(data) {
	        	
	            var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
	            
                if (data.userSelectedType === 'R') { 
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }
                
                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    //document.getElementById("extraAddress").value = extraAddr;
                    addr += extraAddr;
                
                } else {
                    //document.getElementById("extraAddress").value = '';
                	addr += extraAddr;
                }
                
                document.getElementById('postcode2').value = data.zonecode;
                document.getElementById("address2").value = addr;
                
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
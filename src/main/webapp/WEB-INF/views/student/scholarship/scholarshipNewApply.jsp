<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장학금신청</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
<script>
$(function(){	
	$("button[name='postNum']").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                } 
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
                $("[name=postNum]").val(data.zonecode);
                $("[name=address]").val(fullRoadAddr);
                
                document.getElementById('postNum').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullRoadAddr;
                document.getElementById('postNum').value = data.jibunAddress;         
	        }
	    }).open();
	});
});
    
</script>
<style>
		#searchInfo {
			float:left;
		}
		
		.table {
			text-align:center;
			border:1px solid lightgray;
		}
		
		.post{
			display: inline-block;
		}
	</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
					        
	  				<h2>장학금 신청</h2>	
					<form action="scholarshipNewApply.sc" method="post">
					<div class="container">
					    
	  					<table class="table" text-align="center">
	  					  	<tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">소속</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="sdeptName"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">신청학기</td>
	  					      <td style="text-align:center; background-color:white;"><select style="width:385px;" name="dorApplySemester">
											<option value=''>------------------------------ 선택  ------------------------------</option>
											<option value='2019학년도 1학기'>2019학년도 1학기</option>
											<option value='2019학년도 2학기'>2019학년도 2학기</option>
											</select>
											</td>
	 					    </tr>
	 					   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">성명</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" align=center style="width:385px;" name="memberKname"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주민등록번호</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="memberNo"></td>
	 					   </tr>
	     				   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">우편번호</td>
	  					      <td style="text-align:center; background-color:white;"><div style="display: inline-flex;" ><input type="text" style="width:75px;" name="postNum">&nbsp;<button type="button" style="width:50px; padding:0px" name="postNum">검색</button></div></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주소</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="address"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">상세주소</td>
	  					      <td colspan="3" style="text-align:center; background-color:white;"><input type="text" style="width:905px;" name="addressDetail"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">긴급연락처</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="emerPhone"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">E-Mail</td>
	  					      <td style="text-align:center; background-color:white;"><input type="email" style="width:385px;" name="email"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-HP</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="parentPhone"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-TEL</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="parentTel"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">은행명</td>
	  					      <td style="text-align:center; background-color:white;"><select style="width:385px;" name="bank">
											<option value='bank'>------------------------------ 선택  ------------------------------</option>
											<option value='국민은행'>국민은행</option>
											<option value='IBK기업은행'>IBK기업은행</option>
											<option value='EVER RICH'>EVER RICH</option>
											<option value='부산은행'>부산은행</option>
											<option value='우리은행'>우리은행</option>
											<option value='KEB외환은행'>KEB외환은행</option>
											<option value='새마을금고'>새마을금고</option>
											<option value='전북은행'>전북은행</option>
											<option value='신한은행'>신한은행</option>
											<option value='농협'>농협</option>
											<option value='수협은행'>수협은행</option>
											<option value='대구은행'>대구은행</option>
											<option value='하나은행'>하나은행</option>
											<option value='KDB산업은행'>KDB산업은행</option>
											<option value='신협'>신협</option>
											<option value='광주은행'>광주은행</option>
											<option value='SC제일은행'>SC제일은행</option>
											<option value='CITIBANK'>CITIBANK</option>
											<option value='경남은행'>경남은행</option>
											</select></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입금계좌</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text" style="width:385px;" name="accountNo"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">기초생활수급자</td>
	  					      <td style="text-align:center; background-color:white;"><select style="width:385px;" name="basicLife">
											<option value=''>------------------------------ 선택  ------------------------------</option>
											<option value='Yes'>해당</option>
											<option value='No'>해당없음</option>
											</select></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">신청장학금</td>
	  					      <td style="text-align:center; background-color:white;"><select style="width:385px;" name="basicLife">
											<option value=''>------------------------------ 선택  ------------------------------</option>
											<option value='Yes'>성적장학금</option>
											</select></td>
	 					    </tr>
					  </table>
				</div>
					
					<div class="container">         
	  					<div id = "scholarInfo"style="overflow:scroll; height:300px; border:1.5px solid lightgray">
							추가서류 제출 해당자
							<br><br>
							- 서류 : 매학기 1개월 이내 발급된 원본만 가능
							<br><br>
							1. 생활보호대상자 장학금(매학기 제출)
							<br><br>
		   				   *제출서류 - 해당 증명서 1부
							<br><br>
		    				(1) 기초생활수급자증명서(국가장학금 신청서류로 대체 하므로 학교에 추가제출 필요 없음)
							<br><br>
		       				(2) 한부모가족증명서
							<br><br>
		       				(3) 차상위본인부담경감대상자확인서(본인명의)
							<br><br>
							2. 교역직계장학금(매학기 제출)
							<br><br>
		       				* 제출서류
		       				<br><br>
		       				(1) 감리교교역재직증명서
		       				<br><br>
		       				(2) 가족관계증명서 또는 주민등록등본(가족확인 가능)
		       				<br><br>
		       				3. 교역직계장학금(매학기 제출)
							<br><br>
		       				* 제출서류
		       				<br><br>
		       				(1) 재직증명서
		       				<br><br>
		       				(2) 가족관계증명서
		       				<br><br>
		       				4. 한가족장학금(신규 신청자)
							<br><br>
		       				* 제출서류
		       				<br><br>
		       				(1) 가족관계증명서 또는 주민등록등본(가족확인 가능)
		       				<br><br>
		       				(2) 한가족장학금신청서(장학공지에서 다운 받아 작성)
							<br><br>
							5. KH사랑장학금(신규 신청자)
							<br><br>
		       				* 제출서류
		       				<br><br>
		       				(1) 장애학생 : 장애인증명서 1부
		       				<br><br>
		       				(2) 다문화가정학생
		       				<br><br>
		       				- 부,모혼인관계증명서
		       				<br><br>
		       				- 기본증명서
					</div>
					<button type="submit" style="width:527px">신청</button><button type="reset" style="width:527px">취소</button>
				</div>	
				</form>	
		</div>
		</div>
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>
</body>
</html>
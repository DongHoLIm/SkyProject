<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기숙사관리</title>
<style>
		#searchInfo {
			float:left;
		}
		
		.table {
			text-align:center;
			border:1px solid lightgray;
		}
	</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
					        
	  				<h2>기숙사 신청</h2>	
					
					<div class="container">         
	  					<table class="table" text-align="center">
	  					  	<tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">소속</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입사학기</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">성명</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주민등록번호</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					   </tr>
	     				   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">우편번호</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"><input type="button" value="우편번호 찾기"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주소</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">생활관</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">상세주소</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">긴급연락처</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">E-Mail</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-HP</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-TEL</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">환불은행</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">환불계좌</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입사현황</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">흡연여부</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">기초생활수급자</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">특기사항</td>
	  					      <td style="text-align:center; background-color:white;"><input type="text"></td>
	 					    </tr>
					  </table>
				</div>
					
					<div class="container">         
	  					<div id = "scholarInfo"style="overflow:scroll; height:300px; border:1.5px solid lightgray">
							※ 생활관 : 제 1 생활관 - 구관, 제 2 생활관 - 신관
							<br><br>
							※ 서   약   서
							<br><br>
							- 본인은 생활관에 입사함에 있어 규정을 준수하고 단체생활에 협조할 것을 서약합니다
							<br><br>
		   				    - 이를 위변할 시에는 규정에 따른 처벌을 감수하겠습니다
							<br><br>
		    				1. 우편번호, 기본주소는 검색버튼에 의해 선택할 수 있습니다. (주민등록등본 혹은 초본의 원주소와 상이한 경우 합격이 취소됩니다.)
							<br><br>
		       				2. 제출서류
							<br><br>
		       				(1) 필수 : 주민등록등본 혹은 초본 1부 - 신청 기간 내 제출
							<br><br>
							(2) 추가 : 장애인 및 기초생활수급자 증빙서류(복지카드, 수급자증명서 등) 1부
							<br><br>
		       				    - 신청기간내 제출, 해당자에 한하여 별도 심사함
		       				<br><br>
		       				(3) 합격자 제출서류 : 사진(3X4cm) 1장, 건강진단서(결핵검사만 실시) 1부, 본인명의 국민은행 통장사본 1부
		       				<br><br>
		       				3. 환불계좌 : 열쇠보증금, 식비 미사용분에 대한 환불계좌입니다.(국민은행을 제외한 타은행은 수수료공제됨)
		       				<br><br>
					</div>
					<input type="button" value="신청" style="width:686px; text-align:center"><input type="button" value="취소" style="width:686px; text-align:center">
				</div>		
		</div>
		</div>
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>
</body>
</html>
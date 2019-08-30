<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	  					      <td style="text-align:center;">소속</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">입사학기</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					   <tr>
	  					      <td style="text-align:center;">성명</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">주민등록번호</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					   </tr>
	     				   <tr>
	  					      <td style="text-align:center;">우편번호</td>
	  					      <td style="text-align:center;"><input type="text"><input type="button" value="우편번호 찾기"></td>
	  					      <td style="text-align:center;">주소</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">생활관</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">상세주소</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">긴급연락처</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">E-Mail</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">보호자-HP</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">보호자-TEL</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">환불은행</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">환불계좌</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">입사현황</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">교우관계</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">흡연여부</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">입사학기</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center;">특기사항</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	  					      <td style="text-align:center;">입사학기</td>
	  					      <td style="text-align:center;"><input type="text"></td>
	 					    </tr>
					  </table>
				</div>
					
					<div class="container">         
	  					<div id = "scholarInfo"style="overflow:scroll; width:1100px; height:300px; border:1.5px solid lightgray">
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
					<input type="button" value="신청" style="width:550px; text-align:center"><input type="button" value="취소" style="width:550px; text-align:center">
				</div>		
		</div>
		</div>
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>
</body>
</html>
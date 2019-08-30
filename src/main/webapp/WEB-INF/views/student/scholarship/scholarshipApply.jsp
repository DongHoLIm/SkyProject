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
	  				<h2>장학금 신청</h2>
	  				
					<div>
	  				<span>
					<h3 align="right" class="sibal">장학금신청</h3>
					
						<button class="sibal">조회</button>
						<button class="sibal">신규</button>
						<button class="sibal">저장</button>
						<button class="sibal">도움말</button>
					</div>
					<div style="border:1.5px solid lightgray;" height="34px">
						<p>년도</p>
						<p>학기</p>
					</span>
					</div>
					
					<hr>
					
					<div class="container">         
	  					<table class="table" text-align="center" style="border:1.5px solid lightgray">
	  					  <thead style="background-color:skyblue">
	  					  	<tr>
	  					      <th style="text-align:center;">상태</th>
	  					      <th style="text-align:center;">년도</th>
	  					      <th style="text-align:center;">학기</th>
	  					      <th style="text-align:center;">학번</th>
	  					      <th style="text-align:center;">성명</th>
	  					      <th style="text-align:center;">소속</th>
	  					      <th style="text-align:center;">성별</th>
	  					      <th style="text-align:center;">신청장학금</th>
	  					      <th style="text-align:center;">신청일자</th>
	  					      <th style="text-align:center;">승인구분</th>
	  					      <th style="text-align:center;">승인일자</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	 					   	<tr style="background-color:white">
	 					   		<td>승인완료</td>
	 					   		<td>2019</td>
	 					   		<td>2</td>
	 					   		<td>20191234</td>
	 					   		<td>홍길동</td>
	 					   		<td>컴퓨터학과</td>
	 					   		<td>남</td>
	 					   		<td>성적장학금</td>
	 					   		<td>2019-08-24</td>
	 					   		<td>승인</td>
	 					   		<td>2019-08-25</td>
	 					   	</tr>
	 					   </tbody>
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
				</div>
				</div>
			</div>
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장학관리</title>
<style>
		#searchInfo {
			float:left;
		}
		
		.table {
			text-align:center;
		}
		
		.sibal{
			display: inline-block;
		}
		
		.sibal > button{
			float:right;
		}
		
		h3{
			margin-right:53%;
			float:bottom;
		}
		
		.sample11{
			margin-top: 10px;
		}
		
		.sample11 th:nth-child(2n-1){
			padding-left: 5px;
			padding-top: 18px;
			padding-bottom: 0px;
		}
		
		.sample11 th{
			vertical-align: middle;
			padding:5px 2px 5px 2px;
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
	  				
					<div>
	  				
					<h4 align="right" class="sibal">교내장학금 신청 및 결과</h4>
					<div style="float:right">
						<button class="sibal">조회</button>
						<button class="sibal">신규</button>
						<button class="sibal">저장</button>
						<button class="sibal">도움말</button>
					</div>
					</div>
					
					<table class="sample11" style="border:2px solid lightgray">
						<thead>
							<tr  style="text-align:center">
								<th width="5%"><p class="sipal">년도</p></th>
								<th width="40%"><select name='mulitple'>
											<option value=''>-- 선택 --</option>
											<option value='' selected>제2전공(복수전공)</option>
											<option value='' disabled>경영</option>
											<option value='' label=''>영문</option>
									</select>
								</th>
								<th width="5%"><p>학기</p></th>
								<th width="40%"><select name='mulitple'>
											<option value=''>-- 선택 --</option>
											<option value='' selected>제2전공(복수전공)</option>
											<option value='' disabled>경영</option>
											<option value='' label=''>영문</option>
									</select>
								</th>
							</tr>
					</table>
					
					<hr>
					
					<div class="container">         
	  					<table class="table" text-align="center" style="border:2px solid lightgray">
	  					  <thead style="background-color:#eff1f2">
	  					  	<tr>
	  					      <th style="text-align:center; border:1px solid lightgray;">상태</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">년도</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">학기</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">학번</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">성명</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">소속</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">성별</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">신청장학금</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">신청일자</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">승인구분</th>
	  					      <th style="text-align:center; border:1px solid lightgray;">승인일자</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	 					   	<tr style="background-color:white">
	 					   		<td style="border:1px solid lightgray; color:black;">승인완료</td>
	 					   		<td style="border:1px solid lightgray; color:black;">2019</td>
	 					   		<td style="border:1px solid lightgray; color:black;">2</td>
	 					   		<td style="border:1px solid lightgray; color:black;">20191234</td>
	 					   		<td style="border:1px solid lightgray; color:black;">홍길동</td>
	 					   		<td style="border:1px solid lightgray; color:black;">컴퓨터학과</td>
	 					   		<td style="border:1px solid lightgray; color:black;">남</td>
	 					   		<td style="border:1px solid lightgray; color:black;">성적장학금</td>
	 					   		<td style="border:1px solid lightgray; color:black;">2019-08-24</td>
	 					   		<td style="border:1px solid lightgray; color:black;">승인</td>
	 					   		<td style="border:1px solid lightgray; color:black;">2019-08-25</td>
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
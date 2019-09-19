<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장학관리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
						<button class="sibal" id="show" onclick="beforeScholarshipApply()">조회</button>
						<button class="sibal" id="new" onclick="scholarshipNew()">신규</button>
						<button class="sibal" id="help">도움말</button>
					</div>
					</div>
					
					<table class="sample11" style="border:2px solid lightgray">
						<thead>
							<tr  style="text-align:center">
								<th width="5%"><p class="sipal">년도</p></th>
								<th width="40%"><select name='schoYear' id="schoYear">
											<option value=" ">-- 선택 --</option>
											<option value='2019'>2019학년도</option>
											<option value='2018'>2018학년도</option>
											<option value='2017'>2017학년도</option>
											<option value='2016'>2016학년도</option>
											<option value='2015'>2015학년도</option>
											<option value='2014'>2014학년도</option>
											<option value='2013'>2013학년도</option>
											<option value='2012'>2012학년도</option>
									</select>
								</th>
								<th width="5%"><p>학기</p></th>
								<th width="40%"><select name='schoSemester' id="schoSemester">
											<option value=" ">-- 선택 --</option>
											<option value='1'>1</option>
											<option value='2'>2</option>
									</select>
								</th>
							</tr>
					</table>
					
					<hr>
					<c:if test="${ !empty beforeScholarship }">
					<div class="container" id="scholarInfo">
	  					<table class="table" text-align="center" style="border:2px solid lightgray;">
	  					  <thead style="background-color:#eff1f2">
	  					  	<tr>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">상태</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">년도</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">학기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">학번</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">성명</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">소속</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">성별</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">신청장학금</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">신청일자</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">승인구분</th>
	  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">승인일자</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	 					   <c:forEach var="scholarship" items="${ beforeScholarship }">
	 					   	<tr style="background-color:white">
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoAggrementStatus }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoYear }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoSemester }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.studentNo }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.memberKname }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.sdeptName }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.memberGender }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoApplyName }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoApplyDate }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoApplyYn }"/></td>
	 					   		<td style="border:1px solid lightgray; color:black;"><c:out value="${ scholarship.schoAggrementDate }"/></td>
	 					   	</tr>
	 					   	</c:forEach>
	 					   </tbody>
	 					 </table>
	 				</div>
						</c:if>
					
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
<script type="text/javascript">
function beforeScholarshipApply(){
	var schoYear = $("#schoYear").val();
	var schoSemester = $("#schoSemester").val();
	console.log(schoYear);
	console.log(schoSemester);
	location.href = "beforeScholarshipApply.sc?schoYear=" + schoYear + "&schoSemester=" + schoSemester;
}

function scholarshipNew(){
	location.href = "scholarshipNew.sc"

}
</script>
</html>
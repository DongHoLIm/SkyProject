<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
	  				<h2>장학금 수혜내역 조회</h2>	
					
	  					<table class="table" style="border:2px solid lightgray;">
	  						<thead>
		  					  	<tr style="background-color:#eff1f2">
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">학번</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">성명</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">지역대학</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">학과</th>
		 					    </tr>
	 					    </thead>
	 					    <tbody>
	 					    <c:forEach var="scholarship" items="${ memberScholarship }" varStatus="st">
		 					   	<tr style="background-color:white">
		 					   		<td style="border:1px solid lightgray; color:black;">${ scholarship.studentNo }</td>
		 					   		<td style="border:1px solid lightgray; color:black">${ scholarship.memberKname }</td>
		 					   		<td style="border:1px solid lightgray; color:black">서울</td>
		 					   		<td style="border:1px solid lightgray; color:black">${ scholarship.sdeptName }</td>
		 					   	</tr>
		 					</c:forEach>
	 					   	</tbody>
	 					 </table>
					
					<hr>
					
					<div class="container">         
	  					<table class="table" style="border:2px solid lightgray;">
	  						<thead>
		  					  	<tr style="background-color:#f2f2f2">
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">년도학기</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">산정기준</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">장학유형</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">감면내역</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">감면금액</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">취득학점</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">평점평균</th>
		 					    </tr>
	 					    </thead>
	 					    <tbody>
	 					    <c:forEach var="scholarship" items="${ memberScholarship }">
		 					   	<tr style="background-color:white">
		 					   		<td style="border:1px solid lightgray; color:black"><c:out value="${ scholarship.schoYear }"/>학년도 <c:out value="${ scholarship.schoSemester }"/>학기</td>
		 					   		<td style="border:1px solid lightgray; color:black">직전학기성적</td>
		 					   		<td style="border:1px solid lightgray; color:black">성적우수자</td>
		 					   		<td style="border:1px solid lightgray; color:black">수업료</td>
		 					   		<td style="border:1px solid lightgray; color:black"><fmt:formatNumber value="${ scholarship.schoAmount }" pattern="#,###"/> 원</td>
		 					   		<td style="border:1px solid lightgray; color:black">21</td>
		 					   		<td style="border:1px solid lightgray; color:black">4.0</td>
		 					   	</tr>
		 					</c:forEach>
	 					   	</tbody>
	 					 </table>
	 				</div>		
		</div>
		</div>
		
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>

</body>
</html>
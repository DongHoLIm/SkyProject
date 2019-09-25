<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
	<link rel="stylesheet" href="assets/css/main.css"/>
<title>장학관리</title>
<style>
		#searchInfo {
			float:left;
		}
		
		.table {
			text-align:center;
		}
	</style>
</head>
<body>
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>학생 별 장학금 신청 관리</h2>	
						
					<h4>검색</h4>
						<form action="stScholarship.sc" method="post">
							<table class="sample11" style="border:2px solid lightgray">
						<thead>
							<tr  style="text-align:center">
								<th width="6%"><p class="sipal">학번</p></th>
								<th width="39%"><input type="text" name="studentNo"/></th>
								<th width="6%"><p>년도</p></th>
								<th width="39%"><input type="text" name="schoYear"/></th>
								<th><td><button type="submit">검색</button></td></th>
							</tr>
					</table>
						</form>
						
						<hr>
					<c:if test="${ !empty beforeScholarship }">
					<div class="container">         
	  					<table class="table" text-align="center" style="border:2px solid lightgray">
	  					  <thead style="background-color:#eff1f2">
	  					  	<tr>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">상태</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">년도</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">학기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">학번</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">이름</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">소속</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">성별</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">신청장학금</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">신청일자</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">승인구분</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">승인일자</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">비고</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	 					   <c:forEach var="scholarship" items="${ beforeScholarship }">
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">지급완료</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.schoYear }"/>년도</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.schoSemester }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.studentNo }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.memberKname }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.sdeptName }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.memberGender }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.schoApplyName }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.schoApplyDate }"/></td>
	     					   <c:if test="${ scholarship.schoAggrementStatus == '미승인'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><button type="submit" onclick="location.href='scholarshipAggrement.sc'">승인</button></td>
	     					   </c:if>
	     					   <c:if test="${ scholarship.schoAggrementStatus == '승인'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">승인완료</td>
	     					   </c:if>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ scholarship.schoAggrementDate }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
	  					    </tr>
	  					    </c:forEach>
	  					  </tbody>
					  </table>
				</div>
				</c:if>
				<c:if test="${ empty beforeScholarship }">
					<h4 align="center">조회결과가 없습니다.</h4>
				</c:if>
			</div>
		</div>
		<div>
			<c:if test="${member eq '1'}">
				<jsp:include page="../../common/menubar-student.jsp" />
			</c:if>
			<c:if test="${member eq '2'}">
				<jsp:include page="../../common/menubar-professor.jsp" />
			</c:if>
			<c:if test="${member eq '3'}">
				<jsp:include page="../../common/menubar-employee.jsp" />
			</c:if>
		</div>
	</div>
</body>
</html>
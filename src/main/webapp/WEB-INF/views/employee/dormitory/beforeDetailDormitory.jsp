2<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>등록관리</title>
</head>
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
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			
			<br>
					        
	  				<h4>검색</h4>
						<form action="stDormSearch.dor" method="post">
							<table class="sample11" style="border:2px solid lightgray">
						<thead>
							<tr  style="text-align:center">
								<th width="6%"><p class="sipal">기숙사 신청번호</p></th>
								<th width="39%"><input type="text" name="applyCode"/></th>
								<th width="6%"><p>학번</p></th>
								<th width="39%"><input type="text" name="studentNo"/></th>
								<th><td><button type="submit">검색</button></td></th>
							</tr>
					</table>
						</form>
						
						<hr>

					<c:if test="${ !empty memberDormitory }">
					<div class="container">         
	  					<table class="table" text-align="center" style="border:2px solid lightgray">
	  					  <thead style="background-color:#eff1f2">
	  					  	<tr>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">년도학기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">학번</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">이름</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">이메일</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">신청생활관</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">신청일자</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">승인여부</th>
	 					    </tr>
	 					   </thead> 
	 					   <tbody>
	 					   <c:forEach var="dormitory" items="${ memberDormitory }">
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ dormitory.dorApplyYear }"/>학년도 <c:out value="${ dormitory.dorApplySemester }"/>학기</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ dormitory.studentNo }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ dormitory.memberKname }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ dormitory.email }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ dormitory.dormitoryName }"/></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ dormitory.dorApplyDate }"/></td>
	     					   <c:if test="${ dormitory.aggrementStatus == '미승인'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="stDormApply.dor">승인하기</a></td>
	     					   </c:if>
	     					   <c:if test="${ dormitory.aggrementStatus == '승인'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">승인완료</td>
	     					   </c:if>
	  					    </tr>
	  					    </c:forEach>
	   					    <!-- <tr style="background-color:white">
	    					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019년도 1학기</td>
	    					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">1,440,000 원</td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">[장학]<br> 1,440,000 원<br>[이월]<br>0 원 </td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;">0 원</td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="#" style="border-bottom: dotted 0px;">출력하기</a></td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="#" style="border-bottom: dotted 0px;">출력하기</a></td>
	      					  <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
	      	   			    </tr> -->
	  					  </tbody>
					  </table>
				</div>
				</c:if>
				<c:if test="${ empty memberDormitory }">
					<h4 align="center">조회결과가 없습니다.</h4>
				</c:if>
			</div>
		</div>
		
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
	</div>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
	<link rel="stylesheet" href="assets/css/main.css"/>
<title>등록관리</title>
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
				<h2>학생 별 등록금 관리</h2>	
						
					<h4>검색</h4>
						<form action="stEnrollment.en" method="post">
							<table class="sample11" style="border:2px solid lightgray">
						<thead>
							<tr  style="text-align:center">
								<th width="6%"><p class="sipal">학번</p></th>
								<th width="39%"><input type="text" name="studentNo"/></th>
								<th width="6%"><p>년도</p></th>
								<th width="39%"><input type="text" name="enrollYear"/></th>
								<th><td><button type="submit">검색</button></td></th>
							</tr>
					</table>
						</form>
						
						<hr>
						
					<c:if test="${ !empty memberEnrollment }">
					<div class="container">         
	  					<table class="table" text-align="center" style="border:2px solid lightgray">
	  					  <thead style="background-color:#eff1f2">
	  					  	<tr>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">년도학기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">등록금</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">감면액</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">납부한 금액</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">출력하기</th>
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">비고</th>
	 					    </tr>
	 					   </thead> 
	 					   <tbody>
	 					   <c:forEach var="enrollment" items="${ memberEnrollment }">
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><c:out value="${ enrollment.enrollYear }"/>학년도 <c:out value="${ enrollment.enrollSemester }"/>학기</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><fmt:formatNumber value="${ enrollment.tuition }" pattern="#,###"/> 원</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">[장학]<br><fmt:formatNumber value="${ enrollment.schoAmount }" pattern="#,###"/> 원</td>
	     					   <c:if test="${ enrollment.payStatus == 'Y'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><fmt:formatNumber value="${ enrollment.payAmount }" pattern="#,###"/> 원</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><a href="empPrint.en" style="border-bottom: dotted 0px;">출력하기</a></td>
	     					   </c:if>
	     					   <c:if test="${ enrollment.payStatus == 'N'}">
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><fmt:formatNumber value="${ enrollment.payAmount }" pattern="#,###"/> 원</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">해당없음</td>
	     					   </c:if>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
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
				<c:if test="${ empty memberEnrollment }">
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
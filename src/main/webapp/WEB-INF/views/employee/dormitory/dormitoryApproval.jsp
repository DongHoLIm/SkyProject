<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<hr>
						
					<c:forEach var="dormitory" items="${ memberDormitory }">     
					<div class="container">
	  					<table class="table" text-align="center">
	  					  	<tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">소속</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.sdeptName }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입사학기</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.dorApplyYear }"/>학년도 <c:out value="${ dormitory.dorApplySemester }"/>학기 </td>
	 					    </tr>
	 					   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">성명</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.memberKname }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주민등록번호</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.memberNo }"/></td>
	 					   </tr>
	     				   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">우편번호</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.postNum }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주소</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.address }"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">생활관</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.sdeptName }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">상세주소</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.sdeptName }"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">긴급연락처</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.emerPhone }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">E-Mail</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.email }"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-HP</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.parentPhone }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-TEL</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.parentTel }"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">환불은행</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.bank }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">환불계좌</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.accountNo }"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입사현황</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.dormCondition }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">흡연여부</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.smoking }"/></td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">기초생활수급자</td>
	  					      <td style="text-align:center; background-color:white;"><c:out value="${ dormitory.basicLife }"/></td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">특기사항</td>
	  					      <td style="text-align:center; background-color:white;">해당없음</td>
	 					    </tr>
					  </table>
					  </div>
					    </c:forEach>
					    
				</div>
					<div align="center">
					<button type="submit" onclick="location.href='dormitoryAggrement.dor'">승인하기</button>
				</div>
				
		</div>
		</div>
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
					        
	  				<h2>기숙사 신청내역</h2>	
						
					<div class="container" >         
	  					<table class="table" style="border:2px solid lightgray">
	  						<thead>
		  					  	<tr style="background-color:#eff1f2;">
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">신청학기</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">신청일시</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">신청자</th>
		  					      <th style="text-align:center; border:1px solid lightgray; padding:0 0 0 0;">승인여부</th>
		 					    </tr>
	 					   </thead>
	 					   <tbody>
	 					   <c:forEach var="dormitory" items="${ memberDormitory }">
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black;"><c:out value="${ dormitory.dorApplyYear }"/>학년도 <c:out value="${ dormitory.dorApplySemester }"/>학기</td>
	     					   <td style="border:1px solid lightgray; color:black;"><c:out value="${ dormitory.dorApplyDate }"/></td>
	     					   <td style="border:1px solid lightgray; color:black;"><c:out value="${ dormitory.memberKname }"/></td>
	     					   <td style="border:1px solid lightgray; color:black;"><c:out value="${ dormitory.aggrementStatus }"/></td>
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
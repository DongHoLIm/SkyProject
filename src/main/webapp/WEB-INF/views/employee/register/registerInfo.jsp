<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
	<link rel="stylesheet" href="assets/css/main.css"/>
<title>메인 페이지</title>
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
						<form>
							<!-- <table text-align="left" style="border:0px solid black">
								<tr>
									<td>학번<input type="text" name="userId"></td>
									<td>학과<input type="text" name="affiliation"></td>
									<td>이름<input type="text" name="userName"></td>
								</tr>
								<tr>
									<td></td>
									<td><button>조회하기</button></td>
									<td></td>
								</tr>
							</table> -->
							
							<div>
							<div id="searchInfo">학번<input type="text" name="userId"></div>
							<div id="searchInfo">학과<input type="text" name="affiliation"></div>
							<div id="searchInfo">이름<input type="text" name="affiliation"></div>
							</div>
						</form>
						
						<br><br>
						
						<hr>
						
					<div class="container">         
	  					<table class="table" text-align="center">
	  					  <thead>
	  					  	<tr>
	  					      <th style="text-align:center;">학번</th>
	  					      <th style="text-align:center;">학과</th>
	  					      <th style="text-align:center;">이름</th>
	  					      <th style="text-align:center;">년도학기</th>
	  					      <th style="text-align:center;">등록금</th>
	  					      <th style="text-align:center;">감면액</th>
	  					      <th style="text-align:center;">납부한 금액</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	     					 <tr>
	    					   <td>20191234</td>
	     					   <td>소프트웨어 응용</td>
	     					   <td>홍길동</td>
	     					   <td>2019년도 2학기</td>
	     					   <td>540,000 원</td>
	     					   <td>[장학] 540,000 원<br>
	     					   	   [이월] 0 원
	     					   </td>
	     					   <td>0 원</td>
	  					    </tr>
	   					    <tr>
	    					  <td>20191234</td>
	    					  <td>소프트웨어 응용</td>
	      					  <td>홍길동</td>
	      					  <td>2019년도 1학기</td>
	      					  <td>540,000 원</td>
	      					  <td>[장학] 1,440,000 원<br>
	     					      [이월] 0 원
	     					  </td>
	      					  <td>0 원</td>
	      	   			    </tr>
	  					  </tbody>
					  </table>
				</div>
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
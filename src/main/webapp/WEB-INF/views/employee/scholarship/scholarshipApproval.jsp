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
	  					      <th style="text-align:center; border:1px solid lightgray; vertical-align: middle; padding: 0em 0em 0em 0em;">장학금신청서</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">미지급</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2020년도</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">1</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">20191234</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">홍길동</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">소프트웨어 응용</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">남</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">근로장학금</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2020.03.20</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"><button>승인</button></td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019.03.21</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
	  					    </tr>
	   					    <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">지급완료</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019년도</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">20191234</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">홍길동</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">소프트웨어 응용</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">남</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">성적장학금</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019.09.20</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">승인완료</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019.09.21</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
	  					    </tr>
	  					    <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">지급완료</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019년도</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">1</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">20191234</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">홍길동</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">소프트웨어 응용</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">남</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">성적장학금</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019.03.20</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">승인완료</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;">2019.03.21</td>
	     					   <td style="border:1px solid lightgray; color:black; vertical-align: middle;"></td>
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
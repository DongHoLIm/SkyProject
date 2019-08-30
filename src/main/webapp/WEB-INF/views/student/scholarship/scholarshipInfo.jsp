<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
					        
	  				<h2>기숙사 신청</h2>	
					       
	  					<table class="table" style="border:2px solid lightgray;">
	  						<thead>
		  					  	<tr style="background-color:#f0f0f5">
		  					      <th style="text-align:center;">학번</th>
		  					      <th style="text-align:center;">성명</th>
		  					      <th style="text-align:center;">지역대학</th>
		  					      <th style="text-align:center;">학과</th>
		 					    </tr>
	 					    </thead>
	 					    <tbody>
		 					   	<tr style="background-color:white">
		 					   		<td>20191234</td>
		 					   		<td>홍길동</td>
		 					   		<td>서울</td>
		 					   		<td>컴퓨터학과</td>
		 					   	</tr>
	 					   	</tbody>
	 					 </table>
					
					<hr>
					
					<div class="container">         
	  					<table class="table" style="border:2px solid lightgray;">
	  						<thead>
		  					  	<tr style="background-color:white">
		  					      <th style="text-align:center;">년도학기</th>
		  					      <th style="text-align:center;">산정기준</th>
		  					      <th style="text-align:center;">장학유형</th>
		  					      <th style="text-align:center;">감면내역</th>
		  					      <th style="text-align:center;">감면금액</th>
		  					      <th style="text-align:center;">취득학점</th>
		  					      <th style="text-align:center;">평점평균</th>
		 					    </tr>
	 					    </thead>
	 					    <tbody>
		 					   	<tr style="background-color:white">
		 					   		<td>2019년도 2학기</td>
		 					   		<td>직전학기성적</td>
		 					   		<td>성적우수자</td>
		 					   		<td>수업료</td>
		 					   		<td>540,000 원</td>
		 					   		<td>21</td>
		 					   		<td>4.0</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td>2019년도 1학기</td>
		 					   		<td>직전학기성적</td>
		 					   		<td>성적우수자</td>
		 					   		<td>수업료</td>
		 					   		<td>1,440,000 원</td>
		 					   		<td>18</td>
		 					   		<td>4.1</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td>2018년도 2학기</td>
		 					   		<td>직전학기성적</td>
		 					   		<td>성적우수자</td>
		 					   		<td>수업료</td>
		 					   		<td>840,000 원</td>
		 					   		<td>21</td>
		 					   		<td>4.2</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td>2018년도 1학기</td>
		 					   		<td>직전학기성적</td>
		 					   		<td>성적우수자</td>
		 					   		<td>수업료</td>
		 					   		<td>180,000 원</td>
		 					   		<td>18</td>
		 					   		<td>4.3</td>
		 					   	</tr>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					        
	  				<h2>기숙사 시설 내역 조회</h2>	
					       
	  					<table class="table" style="border:2px solid lightgray;">
	  						<thead>
		  					  	<tr style="background-color:#eff1f2">
		  					      <th colspan="2" style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">구분</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">성별</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">형식</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">실수</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">수용인원</th>
		 					    </tr>
	 					    </thead>
	 					    <tbody>
		 					   	<tr style="background-color:white">
		 					   		<td rowspan="3" style="border:1px solid lightgray; color:black; vertical-align:middle;">기숙사1</td>
		 					   		<td style="border:1px solid lightgray; color:black">지상5층</td>
		 					   		<td style="border:1px solid lightgray; color:black">여학생</td>
		 					   		<td style="border:1px solid lightgray; color:black">2인 특실</td>
		 					   		<td style="border:1px solid lightgray; color:black">10실</td>
		 					   		<td style="border:1px solid lightgray; color:black">20명</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td style="border:1px solid lightgray; color:black">지상 5,4,3,2,1층</td>
		 					   		<td style="border:1px solid lightgray; color:black">여학생</td>
		 					   		<td style="border:1px solid lightgray; color:black">4인실</td>
		 					   		<td style="border:1px solid lightgray; color:black">77실</td>
		 					   		<td style="border:1px solid lightgray; color:black">338명</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td colspan="3" style="border:1px solid lightgray; color:black"></td>
		 					   		<td style="border:1px solid lightgray; color:black">92실</td>
		 					   		<td style="border:1px solid lightgray; color:black">358명</td>
		 					   	</tr>
	 					   	</tbody>
	 					 </table>
					
					<hr>
					
					<div class="container">         
	  					<table class="table" style="border:2px solid lightgray;">
	  						<thead>
		  					  	<tr style="background-color:#eff1f2">
		  					      <th colspan="2" style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">구분</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">성별</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">형식</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">실수</th>
		  					      <th style="text-align:center;border:1px solid lightgray; padding:0 0 0 0;">수용인원</th>
		 					    </tr>
	 					    </thead>
	 					    <tbody>
		 					   	<tr style="background-color:white">
		 					   		<td rowspan="4" style="border:1px solid lightgray; color:black; vertical-align:middle;">기숙사1</td>
		 					   		<td style="border:1px solid lightgray; color:black">지상8층</td>
		 					   		<td style="border:1px solid lightgray; color:black">남학생</td>
		 					   		<td style="border:1px solid lightgray; color:black">2인1실(귀빈실)</td>
		 					   		<td style="border:1px solid lightgray; color:black">6실</td>
		 					   		<td style="border:1px solid lightgray; color:black">12명</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td style="border:1px solid lightgray; color:black">지상 8,7층</td>
		 					   		<td style="border:1px solid lightgray; color:black">남학생</td>
		 					   		<td style="border:1px solid lightgray; color:black">2인 특실</td>
		 					   		<td style="border:1px solid lightgray; color:black">17실</td>
		 					   		<td style="border:1px solid lightgray; color:black">34명</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td style="border:1px solid lightgray; color:black">지상 1,2,3,4,5,6,7층</td>
		 					   		<td style="border:1px solid lightgray; color:black">남학생</td>
		 					   		<td style="border:1px solid lightgray; color:black">4인실</td>
		 					   		<td style="border:1px solid lightgray; color:black">106실</td>
		 					   		<td style="border:1px solid lightgray; color:black">454명</td>
		 					   	</tr>
		 					   	<tr style="background-color:white">
		 					   		<td colspan="3" style="border:1px solid lightgray; color:black"></td>
		 					   		<td style="border:1px solid lightgray; color:black">123실</td>
		 					   		<td style="border:1px solid lightgray; color:black">458명</td>
		 					   	</tr>
	 					   	</tbody>
	 					 </table>
	 				</div>		
		</div>
		</div>
		
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
	</div>
</div>
</body>
</html>
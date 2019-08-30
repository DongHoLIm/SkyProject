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
		  					      <th style="text-align:center; border:1px solid lightgray;">신청일시</th>
		  					      <th style="text-align:center; border:1px solid lightgray;">신청기간</th>
		  					      <th style="text-align:center; border:1px solid lightgray;">신청자</th>
		  					      <th style="text-align:center; border:1px solid lightgray;">승인여부</th>
		 					    </tr>
	 					   </thead>
	 					   <tbody>
	     					 <tr style="background-color:white">
	    					   <td style="border:1px solid lightgray; color:black;">2019년도 2학기</td>
	     					   <td style="border:1px solid lightgray; color:black;">2019.08.20 ~ 2019.08.25</td>
	     					   <td style="border:1px solid lightgray; color:black;">홍길동</td>
	     					   <td style="border:1px solid lightgray; color:black;">승인</td>
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
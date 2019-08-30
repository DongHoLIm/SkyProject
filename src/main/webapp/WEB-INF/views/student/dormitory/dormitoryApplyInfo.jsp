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
					        
	  				<h2>기숙사 신청내역</h2>	
						
					<div class="container" >         
	  					<table class="table">
	  						<thead>
		  					  	<tr style="background-color:lightgray;">
		  					      <th style="text-align:center;">신청일시</th>
		  					      <th style="text-align:center;">신청기간</th>
		  					      <th style="text-align:center;">신청자</th>
		  					      <th style="text-align:center;">승인여부</th>
		 					    </tr>
	 					   </thead>
	 					   <tbody>
	     					 <tr style="background-color:white">
	    					   <td>2019년도 2학기</td>
	     					   <td>2019.08.20 ~ 2019.08.25</td>
	     					   <td>홍길동</td>
	     					   <td>승인</td>
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
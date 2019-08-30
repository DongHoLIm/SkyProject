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
					        
	  				<h2>등록금 납부 결과 조회</h2>	
					<div style="border:1.5px solid lightgray;" height="100px">
						<ul>
							<li>입학년도 1학기부터 등록금납부확인증 발급이 가능합니다.</li>
							<li>본 화면에서 발급된 등록금납부확인증은 연말정산용 서류 제출용으로 불가합니다.</li>
							<li>연말정산 제출용 교육비납입증명서 신청은 우편발급 또는 인터넷제증명자동발급을 통하여 신청하여주시기 바랍니다.</li>
						</ul>
					</div>

					<hr>
						
					<div class="container">         
	  					<table class="table" text-align="center" style="border:2px solid gray">
	  					  <thead style="background-color:gray">
	  					  	<tr>
	  					      <th style="text-align:center;">년도학기</th>
	  					      <th style="text-align:center;">등록금</th>
	  					      <th style="text-align:center;">감면액</th>
	  					      <th style="text-align:center;">납부한 금액</th>
	  					      <th style="text-align:center;">등록금 확인증 출력</th>
	  					      <th style="text-align:center;">학생회비 확인증 출력</th>
	  					      <th style="text-align:center;">비고</th>
	 					    </tr>
	 					   </thead>
	 					   <tbody>
	     					 <tr style="background-color:white">
	    					   <td>2019년도 2학기</td>
	     					   <td>540,000 원</td>
	     					   <td>[장학]<br>540,000 원<br>
	     					   	   [이월]<br> 0 원</td>
	     					   <td>0 원</td>
	     					   <td><input type="button" width="100px" value="출력하기"></td>
	     					   <td><input type="button" width="100px" value="출력하기"></td>
	     					   <td></td>
	  					    </tr>
	   					    <tr style="background-color:white">
	    					  <td>2019년도 1학기</td>
	    					  <td>1,440,000 원</td>
	      					  <td>[장학]<br> 1,440,000 원<br>
	     					      [이월]<br> 0 원</td>
	      					  <td>0 원</td>
	      					  <td><input type="button" width="100px" value="출력하기"></td>
	      					  <td><input type="button" width="100px" value="출력하기"></td>
	      					  <td></td>
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
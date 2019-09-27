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
					        
	  				<h2>기숙사 신청</h2>	
					<h4>검색</h4>
						<form action="stDormSearch.dor" method="post">
							<table class="sample11" style="border:2px solid lightgray">
						<thead>
							<tr  style="text-align:center">
								<th width="6%"><p class="sipal">기숙사 신청번호</p></th>
								<th width="39%"><input type="text" name="applyCode"/></th>
								<th width="6%"><p>학번</p></th>
								<th width="39%"><input type="text" name="studentNo"/></th>
								<th><td><button type="submit">검색</button></td></th>
							</tr>
					</table>
						</form>
						
						<hr>
						
					<div class="container">         
	  					<table class="table" text-align="center">
	  					  	<tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">소속</td>
	  					      <td style="text-align:center; background-color:white;">소프트웨어응용</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입사학기</td>
	  					      <td style="text-align:center; background-color:white;">2</td>
	 					    </tr>
	 					   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">성명</td>
	  					      <td style="text-align:center; background-color:white;">홍길동</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주민등록번호</td>
	  					      <td style="text-align:center; background-color:white;">001234-1234567</td>
	 					   </tr>
	     				   <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">우편번호</td>
	  					      <td style="text-align:center; background-color:white;">123-456</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">주소</td>
	  					      <td style="text-align:center; background-color:white;">역삼동</td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">생활관</td>
	  					      <td style="text-align:center; background-color:white;">2인실 - 반야(C동)</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">상세주소</td>
	  					      <td style="text-align:center; background-color:white;">12-3번지 2층</td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">긴급연락처</td>
	  					      <td style="text-align:center; background-color:white;">010-1234-5678</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">E-Mail</td>
	  					      <td style="text-align:center; background-color:white;">hong@email.com</td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-HP</td>
	  					      <td style="text-align:center; background-color:white;">02-123-5678</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">보호자-TEL</td>
	  					      <td style="text-align:center; background-color:white;">010-1234-1234</td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">환불은행</td>
	  					      <td style="text-align:center; background-color:white;">국민은행</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">환불계좌</td>
	  					      <td style="text-align:center; background-color:white;">123456-78-901234</td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">입사현황</td>
	  					      <td style="text-align:center; background-color:white;">총 2학기 입사</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">흡연여부</td>
	  					      <td style="text-align:center; background-color:white;">비흡연</td>
	 					    </tr>
	 					    <tr>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">기초생활수급자</td>
	  					      <td style="text-align:center; background-color:white;">해당없음</td>
	  					      <td style="text-align:center; background-color:#eff1f2; color:black;">특기사항</td>
	  					      <td style="text-align:center; background-color:white;">해당없음</td>
	 					    </tr>
					  </table>
				</div>
					<div align="center">
					<input type="button" value="승인" style="width:125px; text-align:center">
				</div>
		</div>
		</div>
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<!-- 입력 라인  -->
			
			<div class="container">
			
  				<br>
    				<h4>복학 신청 명단</h4>
      					<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>복학예정학기</th>
        							<th>신청일자</th>
        							<th>처리상태</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>201401303</td>
        							<td>채지은</td>
        							<td>2020.09.02</td>
        							<td></td>
        							<td>휴학신청</td>
      							</tr>
      							
    						</tbody>
  						</table>
  						<br><br><br><br>
  						
  						<h4>휴학 학생 명단</h4>
  						<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>복학예정학기</th>
        							<th>처리상태</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>201401303</td>
        							<td>김은혜</td>
        							<td>2020.03.02</td>
        							<td>승인완료</td>
      							</tr>
      							
    						</tbody>
  						</table>
  				
			</div>
			
			
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</div>
</body>
</html>
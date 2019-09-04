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
			
  				<h2>휴복학관리</h2>
  				<ul class="nav nav-pills">
    				<li class="active"><a data-toggle="pill" href="#menu1">휴학관리</a></li>
    				<li><a data-toggle="pill" href="#menu2">복학관리</a></li>
  				</ul>
  
  				<div class="tab-content">
    				<div id="menu1" class="tab-pane fade in active">
    				<h4>휴학 신청 명단</h4>
      					<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>휴학신청일</th>
        							<th>복학예정일</th>
        							<th>서류</th>
        							<th>처리상태</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>201401303</td>
        							<td>채지은</td>
        							<td>2019.08.20</td>
        							<td>2020.09.02</td>
        							<td><a href="#">상세보기</a></td>
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
        							<th>휴학신청일</th>
        							<th>복학예정일</th>
        							<th>서류</th>
        							<th>처리상태</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>201401303</td>
        							<td>김은혜</td>
        							<td>2019.02.20</td>
        							<td>2020.03.02</td>
        							<td><a href="#">상세보기</a></td>
        							<td>승인완료</td>
      							</tr>
      							
    						</tbody>
  						</table>
  						
  						
    				</div>
    			
    				<div id="menu2" class="tab-pane fade">
      					<h4>복학 신청 명단</h4>
      					<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>복학학기</th>
        							<th>복학예정일</th>
        							<th>서류</th>
        							<th>처리상태</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>201401303</td>
        							<td>채지은</td>
        							<td>2019.08.20</td>
        							<td>2020.09.02</td>
        							<td><a href="#">상세보기</a></td>
        							<td>복학신청</td>
      							</tr>
      							
    						</tbody>
  						</table>
  						<br><br><br><br>
  						
  						<h4>복학 신청 완료 명단</h4>
  						<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>휴학신청일</th>
        							<th>복학예정일</th>
        							<th>서류</th>
        							<th>처리상태</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>201401303</td>
        							<td>김은혜</td>
        							<td>2019.02.20</td>
        							<td>2020.03.02</td>
        							<td><a href="#">상세보기</a></td>
        							<td>승인완료</td>
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
</div>
</body>
</html>
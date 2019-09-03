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
			
  				<h2>학사 경고 관리</h2>
  				<ul class="nav nav-pills">
    				<li class="active"><a data-toggle="pill" href="#menu1">금학기 학사경고 대상자</a></li>
    				<li><a data-toggle="pill" href="#menu2">학사경고 누적 관리</a></li>
  				</ul>
  
  				<div class="tab-content">
    				<div id="menu1" class="tab-pane fade in active">
      					<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학년</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>성적평점</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>3</td>
        							<td>201401303</td>
        							<td>채지은</td>
        							<td>1.32</td>
      							</tr>
      							<tr>
        							<td>경영대학</td>
        							<td>경영학과</td>
        							<td>4</td>
        							<td>201001243</td>
        							<td>박성래</td>
        							<td>1.42</td>
      							</tr>
      							
    						</tbody>
  						</table>
  						<br><br>
  						<button type="button" class="btn btn-primary">학사경고 처리</button>
  						
    				</div>
    			
    				<div id="menu2" class="tab-pane fade">
      					<table class="table table-bordered">
    						<thead>
      							<tr>
        							<th>단과대학</th>
        							<th>학과</th>
        							<th>학년</th>
        							<th>학번</th>
        							<th>이름</th>
        							<th>학고누적</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>공과대학</td>
        							<td>컴퓨터공학과</td>
        							<td>3</td>
        							<td>201401303</td>
        							<td>채지은</td>
        							<td>2</td>
      							</tr>
      							<tr>
        							<td>경영대학</td>
        							<td>경영학과</td>
        							<td>4</td>
        							<td>201001243</td>
        							<td>박성래</td>
        							<td>1</td>
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
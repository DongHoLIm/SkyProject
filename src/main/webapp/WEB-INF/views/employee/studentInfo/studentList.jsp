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
			<br>
			
			

			<div class="container">
				<h2>학생전체 조회</h2>
				
				<input class="form-control" id="myInput" type="text"
					placeholder="Search.."> <br>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>단과대학</th>
							<th>학과</th>
							<th>학년</th>
							<th>학번</th>
							<th>이름</th>
							<th>학적상태</th>
						</tr>
					</thead>
					<tbody id="myTable">
						<tr>
							<td>공과대학</td>
							<td>컴퓨터공학과</td>
							<td>1</td>
							<td>201901303</td>
							<td>홍길동</td>
							<td>재학</td>
						</tr>
						<tr>
							<td>공과대학</td>
							<td>컴퓨터공학과</td>
							<td>3</td>
							<td>201401303</td>
							<td>채지은</td>
							<td>휴학</td>
						</tr>
						
					</tbody>
				</table>

				
			</div>

			<script>
			$(document).ready(function(){
  				$("#myInput").on("keyup", function() {
    				var value = $(this).val().toLowerCase();
    					$("#myTable tr").filter(function() {
      						$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    					});
  					});
				});
			</script>
			
			
			
						
		</div>
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<!-- 입력 라인  -->


			<div class="container">
				<h2>다전공신청 처리</h2>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>단과대학</th>
							<th>학과</th>
							<th>학번</th>
							<th>이름</th>
							<th>제1전공</th>
							<th>다전공 분류</th>
							<th>다전공 신청 내용</th>
							<th>처리상태</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>공과대학</td>
							<td>컴퓨터공학과</td>
							<td>201401303</td>
							<td>채지은</td>
							<td>컴퓨터공학 전공</td>
							<td>복수전공</td>
							<td>산업디자인 전공</td>
							<td>신청</td>
						</tr>
						
					</tbody>
				</table>
			</div>





			<div>
				<jsp:include page="../../common/menubar-student.jsp" />
			</div>
		</div>
	</div>
</body>
</html>
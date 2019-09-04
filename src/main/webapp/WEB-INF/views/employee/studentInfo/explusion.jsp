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

				<h2>제적처리</h2>
				<ul class="nav nav-pills">
					<li class="active"><a data-toggle="pill" href="#menu1">제적대상자</a></li>
					<li><a data-toggle="pill" href="#menu2">제적자명단</a></li>
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
									<th>제적사유</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>체육대학</td>
									<td>사회체육학과</td>
									<td>3</td>
									<td>201201303</td>
									<td>임동호</td>
									<td>학사경고 3회</td>
								</tr>
							</tbody>
						</table>
						<br>
						<br>
						<button type="button" class="btn btn-primary">제적등록</button>

					</div>

					<div id="menu2" class="tab-pane fade">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>단과대학</th>
									<th>학과</th>
									<th>학번</th>
									<th>이름</th>
									<th>제적사유</th>
									<th>제적날짜</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>체육대학</td>
									<td>사회체육학과</td>
									<td>201201303</td>
									<td>임동호</td>
									<td>학사경고 3회</td>
									<td>2018.06.30</td>
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
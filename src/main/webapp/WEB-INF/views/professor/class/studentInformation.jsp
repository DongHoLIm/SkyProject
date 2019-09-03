<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
	rel="stylesheet">
<style>
#basic {
	padding: 10px 0px 0px 100px;
}

table.basicinfo td {
	background: #FFF;
}

td.td {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	width: 100px !important;
}

table.basicinfo {
	width: 85%;
	border: 1px solid #dde1e3;
	margin-left: auto;
	margin-right: auto;
}

#Change {
	text-align: center;
	border: 1px solid #dde1e3;
}

#t1 {
	background: #c7c5b7;
	border: 1px solid #dde1e3;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<form class="ba">
				<h4 id="basic">학생 학적 정보 조회</h4>
				<hr>

				<table class="basicinfo" id="Change">
					<tr>
					
						<td><select value="name">
								<option value='' selected>-- 이름 --</option>
								<option value='' >2020-10-12</option>
								<option value='' >경제 사정</option>
								<option value='' ></option>
						</select></td>
					</tr>


				</table>




				<table class="basicinfo" id="Change">

					<thead>
						<tr>
							<th style="text-align: center" id="t1">이수 구분</th>
							<th style="text-align: center" id="t1">교과목명</th>
							<th style="text-align: center" id="t1">학점</th>
							<th style="text-align: center" id="t1">성적</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>교양 필수</td>
							<td>인성과 학문</td>
							<td>2.0</td>
							<td>C</td>
						</tr>
						<tr>
							<td>교양 필수</td>
							<td>인성과 학문</td>
							<td>2.0</td>
							<td>C</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>

</body>
</html>
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
	border: 1px solid #dde1e3;강의계획서
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
				<h4 id="basic">강의계획서 입력 / 수정</h4>
				<hr>

				<table class="basicinfo" id="Change">

					<thead>
						<tr>
							<th style="text-align: center" id="t1">과먹 번호</th>
							<th style="text-align: center" id="t1">이수 구분</th>
							<th style="text-align: center" id="t1">강의명</th>
							<th style="text-align: center" id="t1">강의실/ 강의시간</th>
							<th style="text-align: center" id="t1">학점(시간)</th>
							<th style="text-align: center" id="t1">입력/수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>A1001</td>
							<td>전공필수</td>
							<td>인터넷과 홈페이지</td>
							<td>만우관/(7-10)</td>
							<td>3(3)</td>
							<td><button>입력</button></td>
						</tr>
						
						<tr>
							<td>A1001</td>
							<td>전공필수</td>
							<td>인터넷과 홈페이지</td>
							<td>만우관/(7-10)</td>
							<td>3(3)</td>
							<td><button>수정</button></td>
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
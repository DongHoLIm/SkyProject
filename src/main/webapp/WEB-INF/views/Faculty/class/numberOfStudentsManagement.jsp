<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
			<h2>수강인원 관리</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<table style="text-align: center; margin: 0 auto;">
				<thead>
					<tr>
						<th width="5%">NO</th>
						<th width="25%" style="text-align:center;">과목명</th>
						<th width="15%" style="text-align:center;">담당교수</th>
						<th width="30%" style="text-align:center;">강의 일정</th>
						<th width="10%" style="text-align:center;">수강인원</th>
						<th width="5%" style="text-align:center;">수정</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>JAVA 기초</td>
						<td>김현수</td>
						<td>2019-09-01 ~ 2019-10-01</td>
						<td>30</td>
						<td><a>수정</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
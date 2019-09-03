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
			<h2>강의폐지</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<form>
				<table style="text-align: center; margin: 0 auto;">
					<thead>
						<tr>
							<th width="5%" style="text-align:center;">NO</th>
							<th width="25%" style="text-align:center;">과목명</th>
							<th width="15%" style="text-align:center;">담당교수</th>
							<th width="15%" style="text-align:center;">신청인원</th>
							<th width="15%" style="text-align:center;">폐지사유</th>
							<th width="10%" style="text-align:center;">신청처리</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>JAVA 기초</td>
							<td>김현수</td>
							<td>3/30</td>
							<td>인원부족</td>
							<td><button>폐지</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
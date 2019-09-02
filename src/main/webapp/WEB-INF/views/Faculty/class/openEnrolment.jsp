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
			<h2>수강신청 열기</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<table style="text-align: center; margin: 0 auto;">
				<thead>
					<tr>
						<th width="5%"><input type="checkbox" value="전체선택" id="Allcheck"> <label for="Allcheck"></label></th>
						<th width="7%" style="text-align:center;">학점</th>
						<th width="10%" style="text-align:center;">강좌번호</th>
						<th width="25%" style="text-align:center;">교과목명</th>
						<th width="10%" style="text-align:center;">학과(부)</th>
						<th width="10%" style="text-align:center;">교수명</th>
						<th width="10%" style="text-align:center;">이수구분</th>
						<th width="8%" style="text-align:center;">수강인원</th>
						<th width="17%" style="text-align:center;">강의시간</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" value="선택" id="check"><label for="check"></label></td>
						<td>3.0</td>
						<td>1123123</td>
						<td>JAVA 기초</td>
						<td>정보통신</td>
						<td>김현수</td>
						<td>전공필수</td>
						<td>30</td>
						<td>09:00~09:50</td>
					</tr>
				</tbody>
			</table>
			<br><br><br><br><br>
			<button style="float:right;">수강열기</button>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
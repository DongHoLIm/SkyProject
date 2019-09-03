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
			<h2>수강인원 수정</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<table style="text-align:center; margin: 0 auto; width:70%;">
				<tbody>				
					<tr>
						<td>과목명</td>
						<td><input type="text" value="" readonly></td>
						<td>담당교수</td>
						<td><input type="text" value="" readonly></td>
					</tr>
					<tr>
						<td>강의 일정</td>
						<td><input type="text" value="" readonly></td>
						<td>수강인원</td>
						<td><input type="text" value="" readonly></td>
					</tr>
					<tr>
						<td>비고</td>
						<td colspan="3"><textarea rows="10" cols=""></textarea>
				</tbody>
			</table>
			<br>
			<br>			
				<button style="margin:0 0 0 35%;">취소</button>
				<button style="margin:0 0 0 20%;">저장</button>

		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
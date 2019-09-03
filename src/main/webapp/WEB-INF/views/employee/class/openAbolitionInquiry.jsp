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
			<h2>개설/폐지 조회</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<table style="text-align: center; margin: 0 auto;">
				<tr>
					<td class="td">상세검색</td>
					<td colspan='5'><select class="sel1">
							<option value="">선택</option>
							<option value="">과목명</option>
							<option value="">담당교수</option>
					</select></td>
					<td><input style="display:inline-block; width: 70%;"
						type="text" value="" placeholder="내용을 입력해주세요"> <input
						style="display: inline-block;" type="button" value="검색"></td>
				</tr>
			</table>
			<br>
			<div style="float:right;">
				<a href="#">개설</a>/
				<a href="#">폐지</a>
			</div>
			<br>
			<table style="text-align: center; margin: 0 auto;">
				<tbody>
					<tr>
						<th width="10%" style="text-align:center;">구분</th>
						<th width="30%" style="text-align:center;">과목명</th>
						<th width="15%" style="text-align:center;">담당교수</th>
						<th width="25%" style="text-align:center;">신청일자</th>
						<th width="25%" style="text-align:center;">처리일자</th>
					</tr>
					<tr>

					</tr>
				</tbody>
			</table>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
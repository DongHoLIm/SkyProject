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
			<h2>내 문의 내역</h2>
			<hr>
			<br>
			<form>
				<table>
					<tbody>
						<tr>
							<th width="20%" style="text-align:center;">문의일자</th>
							<th width="30%" style="text-align:center;">제목</th>
							<th width="20%" style="text-align:center;">문의유형</th>
							<th width="20%" style="text-align:center;">답변여부</th>
						</tr>
						<tr>
							<td style="text-align:center;">값 불러오기</td>
							<td style="text-align:center;">값 불러오기</td>
							<td style="text-align:center;">값 불러오기</td>
							<td style="text-align:center;">값 불러오기</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
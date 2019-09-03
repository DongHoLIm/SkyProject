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
			<h2>신규 강좌 개설</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<table class="" style="margin: 0 auto;">
				<thead>
					<tr>
						<th width="10%" style="text-align:center;">NO</th>
						<th width="35%" style="text-align:center;">과목명</th>
						<th width="15%" style="text-align:center;">담당교수</th>
						<th width="15%" style="text-align:center;">계획서</th>
						<th width="25%" style="text-align:center;">신청일</th>
						<th style="text-align:center;">신청처리</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="text-align:center;">1</td>
						<td style="text-align:center;">JAVA 프레임워크 개발자 양성 과정</td>
						<td style="text-align:center;">김진호</td>
						<td style="text-align:center;"><button>보기</button></td>
						<td style="text-align:center;">2019-08-31</td>
						<td style="text-align:center;"><button>승인</button></td>
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
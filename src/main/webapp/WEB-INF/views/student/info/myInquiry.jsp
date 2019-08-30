<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#basic {
	padding: 10px 0px 0px 100px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<h4 id="basic">내 문의 내역</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<form>
				<table style="width: 88.5%; margin: 0 auto;">
					<tbody>
						<tr>
							<th width=200>문의일자</th>
							<th width="300">제목</th>
							<th width="100">답변여부</th>
						</tr>
						<tr>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
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
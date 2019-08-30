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
			<h2>장학 공지</h2>
			<hr>
			<br>
			<form>
				<table style="text-align: center;">
					<tr>
						<td class="td">상세검색</td>
						<td colspan='5'>
							<select class="sel1">
								<option value="">선택</option>
								<option value="">작성자</option>
								<option value="">작성부서</option>
								<option value="">제목</option>
							</select>
						</td>
						<td>
							<input style="display: inline-block; width: 70%;" type="text" value="" placeholder="내용을 입력해주세요">
							<input style="display: inline-block;" type="button" value="검색">
						</td>
					</tr>
				</table>
			</form>
			<br>
			<table style="text-align: center;">
				<tbody>
					<tr>
						<th width="20%" style="text-align:center;">등록일자</th>
						<th width="25%" style="text-align:center;">제목</th>
						<th width="15%" style="text-align:center;">작성자</th>
						<th width="15%" style="text-align:center;">작성부서</th>
						<th width="7%" style="text-align:center;">조회수</th>
						<th width="20%" style="text-align:center;">게시기한</th>
					</tr>
					<tr>
						<td style="text-align:center;">값 불러오기</td>
						<td style="text-align:center;">값 불러오기</td>
						<td style="text-align:center;">값 불러오기</td>
						<td style="text-align:center;">값 불러오기</td>
						<td style="text-align:center;">1</td>
						<td style="text-align:center;">값 불러오기</td>
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
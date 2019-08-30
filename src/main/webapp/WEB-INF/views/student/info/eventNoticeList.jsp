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
			
			<h2>학생 행사</h2>
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
							<input style="display: inline-block;float:right;" type="button" value="검색">
						</td>
					</tr>
				</table>
			</form>
			<button style="float:right;">글쓰기</button>
			<br><br>
			<table style="text-align: center;">
				<tbody>
					<tr>
						<th width="10%" style="text-align:center;">글 번호</th>
						<th width="30%" style="text-align:center;">제목</th>
						<th width="15%" style="text-align:center;">등록일자</th>
						<th width="15%" style="text-align:center;">작성자</th>
						<th width="10%" style="text-align:center;">조회수</th>
					</tr>
					<tr>
						<td style="text-align:center;">1</td>
						<td style="text-align:center;">파이널 시작입니다.</td>
						<td style="text-align:center;">값 불러오기</td>
						<td style="text-align:center;">값 불러오기</td>
						<td style="text-align:center;">1</td>
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
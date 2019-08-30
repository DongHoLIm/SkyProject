<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#basic {
	padding: 10px 0px 0px 100px;
}

.sel1 { 
	width: 100%
}

</style>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<h4 id="basic">일반 공지</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tr>
					<td class="td">상세검색</td>
					<td colspan='5'><select class="sel1">
							<option value="">선택</option>
							<option value="">작성자</option>
							<option value="">작성부서</option>
							<option value="">제목</option>
					</select></td>
					<td><input style="display: inline-block; width: 70%;"
						type="text" value="" placeholder="내용을 입력해주세요"> <input
						style="display: inline-block;" type="button" value="검색"></td>
				</tr>
			</table>


			<br>
			<br>

			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tbody>
					<tr>
						<th width=150>등록일자</th>
						<th width="200">제목</th>
						<th width="100">작성자</th>
						<th width="100">작성부서</th>
						<th width="80">조회수</th>
						<th width="180">게시기한</th>
					</tr>
					<tr>

					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
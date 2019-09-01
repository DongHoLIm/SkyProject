<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
#basic {
	padding: 10px 0px 0px 100px;
}

.sel1 { 
	width: 100%
}

.nNoticeTtitle:hover{
	color: black;
	font-weight: bold;
	cursor: pointer;
}

#writeArea {
	margin: 0 auto;
	width: 88.5%;
}

#writeBtn {
	align: right;
}

</style>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">일반 공지</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tr>
					<td>상세검색</td>
					<td colspan='5'>
						<select class="sel1">
							<option value="">선택</option>
							<option value="">작성자</option>
							<option value="">작성부서</option>
							<option value="">제목</option>
						</select>
					</td>
					<td>
						<input style="display: inline-block; width: 80%;" type="text" value="" placeholder="내용을 입력해주세요">
					</td>
					<td>
						<input style="display: inline-block;" type="button" value="검색">
					</td>
				</tr>
			</table>


			<br>
			<br>
			<div id="writeArea">
				<div align="right" style="margin-bottom: 10px;">
					<button id="writeBtn">글쓰기</button>
				</div>
			</div>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tbody>
					<tr>
						<th width="10%" style="text-align: center;">등록일자</th>
						<th width="50%" style="text-align: center;">제목</th>
						<th width="10%" style="text-align: center;">작성자</th>
						<th width="10%" style="text-align: center;">작성부서</th>
						<th width="10%" style="text-align: center;">조회수</th>
						<th width="10%" style="text-align: center;">게시기한</th>
					</tr>
					<tr>
						<td style="text-align: center;">2019-08-29</td>
						<td style="text-align: center;" class="nNoticeTtitle" onclick="em_showNormalDetail()">가나다라마바사아</td>
						<td style="text-align: center;">박성래</td>
						<td style="text-align: center;">학사지원팀</td>
						<td style="text-align: center;">23</td>
						<td style="text-align: center;">2910-08-30</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>
	
	<script>
		function em_showNormalDetail(){
			location.href = "em_nNoticeDetail.bo";
		}
	</script>
</body>
</html>
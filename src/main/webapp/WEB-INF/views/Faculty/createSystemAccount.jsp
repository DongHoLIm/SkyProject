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
.sel {
	width: 10%;
	/* margin:-30px 45%; */

}
#ssbox {
	display:inline-block;
	mirgin:0 auto;
}
</style>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../common/header.jsp" />
			</div>
				<h4 id="basic">계정 발급/삭제</h4>
			<div style="width: 88.5%; margin: 0 auto;">
				<a>사용자</a>&nbsp; <a>고급</a>
			</div>
			<br>
			<hr style="width: 88.5%; margin: 0 auto;">
			<div style="width: 88.5%; margin: 0 auto;">
				<br> <input type="file" name="photo">
			</div>
				<div id="ssbox" style="width:88.5%; margin: 0 auto;">
						<select class="sel">
							<option>선택</option>
							<option>이름</option>
							<option>구분</option>
							<option>상태</option>
						</select>
						<input type="text" id="search" value="" placeholder="내용을 입력해주세요" style="width:20%;">					
				</div>
				<br>
				<button>삭제</button>
				<br>
			<form>
				<table class="table table-bordered"
					style="width: 88.5%; margin: 0 auto;">
					<thead>
						<tr>
							<th>이름</th>
							<th>이메일</th>
							<th>설명</th>
							<th>상태</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
						</tr>
					</tbody>
				</table>
			</form>
			<div>
				<jsp:include page="../common/menubar-student.jsp" />
			</div>
		</div>
	</div>
</body>
</html>
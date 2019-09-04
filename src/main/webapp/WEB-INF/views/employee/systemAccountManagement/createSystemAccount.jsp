<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.sel {
	width: 24%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
			<h2>계정 발급/삭제</h2>
				<a>사용자</a>&nbsp;/<a>고급</a>
			<hr>
			<form>
				<div id="ssbox" style="width:100%">
					<input type="file" name="photo" class="button icon solid fa-download" style="display: inline-block;">
					<div style="display:inline-block;width:50%;float:right;">
						<select class="sel" style="display: inline-block; ">
							<option>선택</option>
							<option>이름</option>
							<option>구분</option>
							<option>상태</option>
						</select>
						 <input type="text" id="search" value="" placeholder="내용을 입력해주세요" style="width: 75%; display: inline;">
					</div>	
				</div>
				<br>
				<div style="float:right">
					<button>삭제</button>
					<button>발급</button>
				</div>
				<br>
				<br>
				<br>
				<table class="" style="margin: 0 auto;">
					<thead>
						<tr>
							<th width="30"><input type="checkbox" value="전체선택" id="Allcheck"> <label for="Allcheck"></label></th>
							<th>이름</th>
							<th>이메일</th>
							<th>설명</th>
							<th>상태</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
							<td>값 불러오기</td>
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
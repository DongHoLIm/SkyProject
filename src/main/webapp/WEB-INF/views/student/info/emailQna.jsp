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

table.basicinfo td {
	background: #FFF;
}

td.td {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	width: 100px !important;
}

table.basicinfo {
	width: 85%;
	border: 1px solid #dde1e3;
	margin-left: auto;
	margin-right: auto;
}
#btn {
	margin:0 43.5%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<h4 id="basic">이메일 문의</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<form class="ba">
				<table class="basicinfo" style="width: 50%;">
					<tr>
						<td class="td">성명</td>
						<td colspan='5'><input type="text" value="박성래" readonly></td>
					</tr>
					<tr>
						<td class="td">학번/교직원 번호</td>
						<td><input type="text" value="" readonly></td>
					</tr>
					<tr>
						<td class="td">답변 E-mail</td>
						<td><input type="text" value=""></td>
					</tr>
				</table>

				<hr style="width: 88.5%; margin: 0 auto;">

				<table class="basicinfo" style="width: 50%; text-align: center;">
					<tr>
						<td class="td">문의유형</td>
						<td colspan='5'><select>
								<option>선택</option>
						</select></td>
					</tr>
					<tr>
						<td class="td">제목</td>
						<td><input type="text" placeholder="내용을 입력해주세요"></td>
					</tr>
					<tr>
						<td class="td">내용</td>
						<td><textarea class="txt1" rows="15" cols="10"
								placeholder="내용을 입력해주세요"></textarea>
					<tr>
				</table>
			</form>
			<div id="btn">
				<button type="reset" id="btn1" style="align: center;">취소</button>
				<button type="submit" id="btn2" style="align: center;">보내기</button>
			</div>
			<div>
				<jsp:include page="../../common/menubar-student.jsp" />
			</div>

		</div>
	</div>
</body>
</html>
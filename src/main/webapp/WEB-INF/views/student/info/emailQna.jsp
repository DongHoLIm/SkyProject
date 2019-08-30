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
			<h2>이메일 문의</h2>
			<hr>
			<form class="ba">
				<div style="display:inline-block; width:15%;">
					<label style="background:lightgray; text-align:center;">성명</label>
				</div>
				<div style="display:inline-block; width:80%;">
					<label>박성래</label>
				</div>
				<div style="display:inline-block; width:15%;">
					<label style="background:lightgray; text-align:center;">학번/교직원 번호</label>
				</div>
				<div style="display:inline-block; width:80%;">
					<label>201040038</label>
				</div>
				<div style="display:inline-block; width:15%;">
					<label style="background:lightgray; text-align:center;">답변 E-mail</label>
				</div>
				<div style="display:inline-block; width:80%;">
					<label>201040038@kh.com</label>
				</div>
				<hr>

				<table class="basicinfo" style="width: 100%; text-align: center;">
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
			<div style="float:right">
				<button type="reset" id="btn1" style="align: center;">취소</button>
				<button type="submit" id="btn2" style="align: center;">보내기</button>
			</div>
			</form>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
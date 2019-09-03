<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.inputbox {
	border: none;
	box-shadow: none !important;
	width: 100%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>강의 계획서 작성</h2>
				<hr>
				

				<table>
					<tr>
						<td bgcolor="E7EEE3" align="center">과목명</td>
						<td><input type="text" class="inputbox"></td>
						<td bgcolor="E7EEE3" align="center">과목번호</td>
						<td><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" align="center">교수명</td>
						<td><input type="text" class="inputbox"></td>
						<td bgcolor="E7EEE3" align="center">이수구분</td>
						<td><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" align="center">수업기간</td>
						<td><input type="text" class="inputbox"></td>
						<td bgcolor="E7EEE3" align="center">학점/이수기간</td>
						<td><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" align="center">수업목표</td>
						<td colspan="5"><textarea rows="8" cols="2" style="resize: none" placeholder="내용을 입력해주세요"></textarea>
					</tr>
					</table>
					<table>
					<tr>
						<td rowspan="2" bgcolor="E7EEE3" style="text-align:center;">평가기준</td>
						<td bgcolor="E7EEE3" style="text-align:center; width:17%">출석</td>
						<td bgcolor="E7EEE3" style="text-align:center; width:17%">중간고사</td>
						<td bgcolor="E7EEE3" style="text-align:center; width:17%">기말고사</td>
						<td bgcolor="E7EEE3" style="text-align:center; width:17%">과제물</td>
						<td bgcolor="E7EEE3" style="text-align:center; width:17%">참여도</td>
					</tr>
					<tr>
						<td><input type="text" class=""></td>
						<td><input type="text" class=""></td>
						<td><input type="text" class=""></td>
						<td><input type="text" class=""></td>
						<td><input type="text" class=""></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" style="text-align:center;">성적분포</td>
						<td colspan="5"><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" style="text-align:center;">평가기간</td>
						<td colspan="5"><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" style="text-align:center;">성적분포</td>
						<td colspan="5"><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" style="text-align:center;">이의신청기간</td>
						<td colspan="5"><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" style="text-align:center;">교재</td>
						<td colspan="5"><input type="text" class="inputbox"></td>
					</tr>
				</table>
				<button type="reset" style="margin:0 0 0 35%;">취소</button>
				<button type="submit" style="margin:0 0 0 20%;">입력하기</button>


				<br>
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-professor.jsp" />
		</div>
	</div>
</body>
</html>
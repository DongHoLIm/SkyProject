<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 계획서 작성</title>
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
				

				<table style="border: 1px solid #e3dcca">
					<tr>
						<td bgcolor="E7EEE3" align="center">강의명 / 과목 번호</td>
						<td colspan="2"><input type="text" class="inputbox"></td>
						<td bgcolor="E7EEE3" align="center">강의 시간</td>
						<td colspan="2"><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" align="center">교수명</td>
						<td colspan="2"><input type="text" class="inputbox"></td>
						<td bgcolor="E7EEE3" align="center">이수구분</td>
						<td colspan="2"><input type="text" class="inputbox"></td>
					</tr>
					<tr>
						<td bgcolor="E7EEE3" align="center">강의실</td>
						<td colspan="2"><input type="text" class="inputbox"></td>
						<td bgcolor="E7EEE3" align="center">학점</td>
						<td colspan="2"><input type="text" class="inputbox"></td>
					
					</tr>
					<tr>
						<td bgcolor="E7EEE3" align="center">수업목표</td>
						<td colspan="5"><textarea rows="8" cols="2" style="resize: none" placeholder="내용을 입력해주세요"></textarea>
					</tr>
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
						<td bgcolor="E7EEE3" style="text-align:center;">평가기간</td>
						<td colspan="5"><input type="text" class="inputbox"></td>
					</tr>
				
				
				</table>
				<button type="reset" style="margin:0 0 0 40%;">취소</button>
				<button type="submit" style="margin:0 0 0 5%;">등록</button>


				<br>
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-professor.jsp" />
		</div>
	</div>
</body>
</html>
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
			<h2>휴강 및 보강 관리</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<form>
				<table style="text-align: center; margin: 0 auto;">
					<tbody>
						<tr>
							<td>학년도</td>
							<td>
								<select>
									<option>2019</option>
								</select>
							<td>학기</td>
							<td>
								<select>
									<option>선택</option>
									<option>1학기</option>
									<option>2학기</option>
								</select>
							<td>대학(원)</td>
							<td>
								<select>
									<option>전체</option>
								</select>
						</tr>
						<tr>
							<td>학과(부)</td>
							<td colspan="3">
								<select>
									<option>전체</option>
								</select>
							</td>
							<td>교수명</td>
							<td>
								<select>
									<option>전체</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>승인여부</td>
							<td colspan="2">
								<select>
									<option>전체</option>
									<option>승인</option>
									<option>미승인</option>
								</select>
							</td>
							<td>강좌명</td>
							<td colspan="2">
								<select>
									<option>전체</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<br><br>
				<button style="float:right;">검색</button>
			</form>
			<br><br>
		
			<p>검색결과 - 휴강 및 보강 관리</p>
			<hr>
			<p>휴강 및 보강 승인처리</p>
			<form>
				<table style="text-align: center; margin: 0 auto;">
					<thead>
						<tr>
							<th width="2%"><input type="checkbox" value="전체선택" id="Allcheck"> <label for="Allcheck"></label></th>
							<th width="8%" style="text-align:center;">승인여부</th>
							<th width="10%" style="text-align:center;">교수명</th>
							<th width="10%" style="text-align:center;">교과목 번호</th>
							<th width="20%" style="text-align:center;">교과목명</th>
							<th width="12%" style="text-align:center;">강의일자</th>
							<th width="8%" style="text-align:center;">주차</th>
							<th width="10%" style="text-align:center;">요일</th>
							<th width="8%" style="text-align:center;">교실</th>
							<th width="10%" style="text-align:center;">결강사유</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" value="선택" id="check"><label for="check"></label></td>
							<td>미승인</td>
							<td>김현수</td>
							<td>12312</td>
							<td>JAVA 기초</td>
							<td>2019-09-01</td>
							<td>1주차</td>
							<td>월요일</td>
							<td>C반</td>
							<td>힘들다.</td>
						</tr>
					</tbody>
				</table>
				<br><br>
				<div style="float:right;">
					<button>승인</button>
					<button>학과승인취소</button>
				</div>
			</form>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>강의개설등록</h2>
				<hr style="margin: 0 auto;">
				<br> <br>
				<form action="" method="post">
					<table class="basicinfo">
					<tr>
						<td class="td">과목번호</td>
						<td colspan='5'><input type="text" id="subCoode" value="<c:out value="${ LectureOpen.madeDate }" />" readonly></td>
					</tr>

					<tr>
						<td class="td">한글 성명</td>
						<td><input type="text" value="홍길동" readonly></td>
						<td class="td">영문 성명</td>
						<td><input type="text" value="In Woo Kang" readonly></td>
						<td class="td">한문 성명</td>
						<td><input type="text" value="姜因遇" readonly></td>
					</tr>

					<tr>
						<td class="td">주민 번호</td>
						<td><input type="text" value="940205-*******" readonly></td>
						<td class="td">생년월일</td>
						<td><input type="text" value="2000.07.26" readonly></td>
						<td class="td">성별</td>
						<td><input type="text" value="남" readonly></td>
					</tr>

					<tr>
						<td class="td">학부(과)</td>
						<td><input type="text" value="소프트웨어 응용" readonly></td>
						<td class="td">전공</td>
						<td><input type="text" value="컴퓨터 공학" readonly></td>
						<td class="td">학년</td>
						<td><input type="text" value="1" readonly></td>
					</tr>

					<tr>
						<td class="td">학적 상태</td>
						<td><input type="text" value="재학" readonly></td>
						<td class="td">주야</td>
						<td><input type="text" value="주간" readonly></td>
						<td class="td">병역 구분</td>
						<td><input type="text" value="" readonly></td>
					</tr>
					</table>
				</form>
			</div>
		</div>
			<div>
				<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
			</div>
	</div>
	<script>
		var subCode = $("#subCode").val();
		console.log(subCode);
	</script>
</body>
</html>
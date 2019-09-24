<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table.basicinfo td{
	background: #FFF;

}
td.td	{
	text-align: center;
	background: #c7c5b7 !important;
	color:black;
	width:100px !important;
	
}


table.basicinfo {
	width:85%;
	border: 1px solid #dde1e3;
	margin-left: auto;
	margin-right: auto;
}

#modified {
	margin-left: 80%;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>강의폐지등록</h2>
				<hr>
				<br> <br>
				<div>
					<form action="insertSubjectDelete.em" method="post">
						<table class="basicinfo" style="border 1px solid lightgray;">
							<tr>
								<td class="td">과목번호</td>
								<td colspan="1">
									<input type="text" name="subCode" value="<c:out value="${ os.openSubCode }"/>" readonly>
								</td>
								<td class="td">과목명</td>
								<td>
									<input type="text" name="subName" value="<c:out value="${ os.subName }"/>" readonly>
								</td>
							</tr>

							<tr>
								<td class="td">학과</td>
								<td>
									<input type="text" name="sdeptName" value="<c:out value="${ os.sdeptName }"/>" readonly>
								</td>
								<td class="td">교수</td>
								<td>
									<input type="text" name="sdeptName" value="<c:out value="${ os.professorName }"/>" readonly>
								</td>
							</tr>
							<tr>
								<td class="td">폐지사유</td>
								<td colspan="5"><textarea rows="8" cols="2" style="resize: none" placeholder="내용을 입력해주세요" name="reason"></textarea></td>
							</tr>
						</table>
						<br>
						<div style="margin:0 0 0 38%;">					
						<button type="submit">등록</button>
						<button type="reset">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>

</body>
</html>
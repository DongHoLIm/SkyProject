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
				<h4>강의개설등록</h4>
				<hr>
				<br> <br>
				<div>
					<form action="insertCoursesOffered.em" method="post">
						<table class="basicinfo">


							<tr>
								<td class="td">과목번호</td>
								<td>
									<input type="text" name="subCode" value="<c:out value="${ lo.subCode }"/>" readonly>
								</td>
								<td class="td">과목명</td>
								<td>
									<input type="text" name="subName" value="<c:out value="${ lo.subName }"/>" readonly>
								</td>
								<td class="td">학과</td>
								<td>
									<input type="text" name="sdeptName" value="<c:out value="${ lo.sdeptName }"/>" readonly>
								</td>
							</tr>

							<tr>
								<td class="td">이수구분</td>
								<td >
									<input type="text" name="completeType" value="<c:out value="${ lo.completeType }"/>" readonly>
								</td>
								<td class="td">개설일자</td>
								<td>
									<fmt:parseDate value="${lo.madeDate}" var="madeDate" pattern="yyyy-MM-dd HH:mm:ss" />
									<input type="text" name="madeDate" value="<fmt:formatDate value="${madeDate}" pattern="yyyy/MM/dd"/>" readonly>
								</td>
								<td class="td">교수</td>
								<td colspan="2"><select name="proList">
										<c:forEach var="proList" items="${ proList }">
											<option>
												<c:out value="${ proList.professorName }/${ proList.professorNo }" />
											</option>
										</c:forEach>
								</select></td>
							</tr>

							<tr>
								<td class="td">개강년도</td>
								<td><input type="text" name="year" value="2019" readonly></td>
								<td class="td">강의인원</td>
								<td ><input type="text" name="personnel"></td>
								<td class="td">강의실정보</td>
								<td>
									<select name="room">
										<c:forEach var="room" items="${ room }">
											<option>
												<c:out value="${ room.buildingName }/${ room.roomName }"></c:out>
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td class="td">강의요일</td>
								<td>
									<select name="dayWeek">
										<option>월요일</option>
										<option>화요일</option>
										<option>수요일</option>
										<option>목요일</option>
										<option>금요일</option>
									</select>
								</td>
								<td class="td">시작교시</td>
								<td>
									<select name="period1">
										<option value="1">09:00 ~ 09:50</option>
										<option value="2">10:00 ~ 10:50</option>
										<option value="3">11:00 ~ 11:50</option>
										<option value="4">12:00 ~ 12:50</option>
										<option value="5">13:00 ~ 13:50</option>
										<option value="6">14:00 ~ 14:50</option>
										<option value="7">15:00 ~ 15:50</option>
										<option value="8">16:00 ~ 16:50</option>
									</select>
								</td>
								<td class="td">끝교시</td>
								<td>
									<select name="period2">
										<option value="1">09:00 ~ 09:50</option>
										<option value="2">10:00 ~ 10:50</option>
										<option value="3">11:00 ~ 11:50</option>
										<option value="4">12:00 ~ 12:50</option>
										<option value="5">13:00 ~ 13:50</option>
										<option value="6">14:00 ~ 14:50</option>
										<option value="7">15:00 ~ 15:50</option>
										<option value="8">16:00 ~ 16:50</option>
									</select>
								</td> 
							</tr>
							<input type="hidden" name="semester" value="2" readonly>
						</table>
						<br><br><br>
						<div style="margin:0 0 0 38%;">					
						<button type="submit">등록</button>
						<button>취소</button>
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
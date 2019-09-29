<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
			<h2>예비수강신청 열기</h2>
			<hr>
			<br> <br>
			<form action="updateOpenSubject.em" method="post">
				<table style="text-align:center;">
					<thead>
						<tr>
							<th width="10%" style="text-align:center;">과목번호</th>
							<th width="16%" style="text-align:center;">교과목명</th>
							<th width="11%" style="text-align:center;">학과(부)</th>
							<th width="8%" style="text-align:center;">교수명</th>
							<th width="6%" style="text-align:center;">학점</th>
							<th width="10%" style="text-align:center;">이수구분</th>
							<th width="7%" style="text-align:center;">수강인원</th>
							<th width="15%" style="text-align:center;">강의실</th>
							<th width="15%" style="text-align:center;">강의시간</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="OpenSubject" items="${ list }">
						<tr>
							<td>
								<input type="hidden" name="openSubCode" value="<c:out value="${OpenSubject.openSubCode}" />">
								<c:out value="${OpenSubject.openSubCode}" />
							</td>
							<td><c:out value="${OpenSubject.subName}" /></td>
							<td><c:out value="${OpenSubject.sdeptName}" /></td>
							<td><c:out value="${OpenSubject.professorName}" /></td>
							<td><c:out value="${OpenSubject.subGrade}" /></td>
							<td><c:out value="${OpenSubject.completeType}" /></td>
							<td><c:out value="${OpenSubject.studentMax}" /></td>
							<td><c:out value="${OpenSubject.buildingName}/${OpenSubject.roomName}" /></td>
							<td><c:out value="${OpenSubject.dayInfo}/${OpenSubject.timeInfo}" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<br><br><br><br><br>
				<button style="float:right;">예비수강열기</button>
			</form>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
	
</body>
</html>
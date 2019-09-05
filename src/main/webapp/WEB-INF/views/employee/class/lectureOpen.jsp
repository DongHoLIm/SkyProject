<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h2>강의개설등록</h2>
			<hr style="margin: 0 auto;">
			<br> <br>
			<table class="" style="margin: 0 auto;">
				<thead>
					<tr>
						<th width="10%" style="text-align:center;">과목번호</th>
						<th width="20%" style="text-align:center;">과목명</th>
						<th width="15%" style="text-align:center;">학과명</th>
						<th width="15%" style="text-align:center;">이수구분</th>
						<th width="15%" style="text-align:center;">인정학점</th>
						<th width="20%" style="text-align:center;">개설일자</th>
						<th style="text-align:center;">강의등록</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="LectureOpen" items="${ subjectList }">
					<tr>
						<td style="text-align:center;"><c:out value="${ LectureOpen.subCode }"/></td>
						<td style="text-align:center;"><c:out value="${ LectureOpen.subName }"/></td>
						<td style="text-align:center;"><c:out value="${ LectureOpen.sdeptName }"/></td>
						<td style="text-align:center;"><c:out value="${ LectureOpen.completeType }"/></td>
						<td style="text-align:center;"><c:out value="${ LectureOpen.subGrade }"/></td>
						<td style="text-align:center;"><c:out value="${ LectureOpen.madeDate }"/></td>
						<td style="text-align:center;"><button>등록</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
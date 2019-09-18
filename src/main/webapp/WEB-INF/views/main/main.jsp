<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>	
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../common/header.jsp" />
				<br>
				<br>
				<h2 align="center">공지 사항</h2>
				<hr />
				<br>
				<table>
					<thead>
						<tr>
							<th width="5%" style="text-align: center">번호</th>
							<th width="9%" style="text-align: center;">행사일자</th>
							<th width="50%" style="text-align: center;">제목</th>
							<th width="9%" style="text-align: center;">작성자</th>
							<th width="12%" style="text-align: center;">작성부서</th>
							<th width="7%" style="text-align: center;">조회수</th>
							<th width="9%" style="text-align: center;">게시기한</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<c:if test="${member eq '1'}">
				<jsp:include page="../common/menubar-student.jsp" />
			</c:if>
			<c:if test="${member eq '2'}">
				<jsp:include page="../common/menubar-professor.jsp" />
			</c:if>
			<c:if test="${member eq '3'}">
				<jsp:include page="../common/menubar-employee.jsp" />
			</c:if>
		</div>
	</div>
	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
</body>
</html>
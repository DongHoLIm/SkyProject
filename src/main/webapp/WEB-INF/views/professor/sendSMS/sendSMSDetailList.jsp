<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<h3>보낸명단</h3>
				<hr />
				<br />
				<table align="center">
					<tr>
						<th>학생이름</th>
						<th>핸드폰번호</th>
						<th>학과</th>
						<th>학년</th>
					</tr>
					<c:forEach var='listStu' items="${list}">
						<tr>
							<td><c:out value="${listStu.memberKName }"/></td>
							<td><c:out value="${listStu.phone }"/></td>
							<td><c:out value="${listStu.sdeptName }"/></td>
							<td><c:out value="${listStu.grade }"/>학년</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
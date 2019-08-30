<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
<c:set var="member" value="${loginUser.memberStatus}"/>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../common/header.jsp" />
			</div>
			<!-- 입력 라인  -->			
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
</body>
</html>
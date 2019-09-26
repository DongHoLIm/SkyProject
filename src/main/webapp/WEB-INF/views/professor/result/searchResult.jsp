<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
	#classList{
		text-align: center;
	}
	#classList tr th{
		text-align: center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h3>성적 조회</h3>
				<hr />
				<br />
				<br />
				<table id="classList">
					<tr>
						<th>년도/ 학기</th>
						<th>과목번호</th>
						<th>이수구분</th>
						<th>강의명</th>
						<th>강의실</th>
						<th>강의시간</th>
						<th>학점</th>
						<th>상세 확인</th>
					</tr>
					<c:forEach var="listSub" items="${list}">
						<tr>
							<td><c:out value="${listSub.openYear }년도/${listSub.openSemester }학기"/></td>
							<td><c:out value="${listSub.opensubCode }"/></td>
							<td><c:out value="${listSub.completeType }"/></td>
							<td><c:out value="${listSub.subName }"/></td>
							<td><c:out value="${listSub.buildingName }/${listSub.roomName }"/></td>
							<td><c:out value="${listSub.dayInfo }/${listSub.timeInfo }"/></td>
							<td><c:out value="${listSub.subGrade }학점"/></td>
							<td>
								<button type="button" class="insertResultView">확인</button>
							</td>
						</tr>
					</c:forEach>
				</table>	
			</div>
		</div>
		<div>			
			<jsp:include page="../../common/menubar-professor.jsp" />		
		</div>
	</div>	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	<script>
	$(function(){
			$(".insertResultView").click(function(){				
				var subject = $(this).parents().eq(1).children();
				
				var yearSemester = subject.eq(0).text();
				var opensubCode = subject.eq(1).text();
				var completeType = subject.eq(2).text();
				var subName = subject.eq(3).text();
				var buildingRoom = subject.eq(4).text();
				var dayInfoTimeInfo = subject.eq(5).text();
				var subGrade = subject.eq(6).text();			
				
			window.open("checkResultDetail.pror?opensubCode="+opensubCode,"성적조회","width:100px;");			
		});
	});
	</script>
</body>
</html>
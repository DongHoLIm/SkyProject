<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
	#subjectT{
		text-align: center;
	}
	#subjectT tr th {
		text-align: center;
	}
	#stuT{
		text-align: center;
	}
	#stuT tr th{
		text-align: center;
	}
</style>
</head>
<body>
	
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h3>학생 성적 입력</h3>
				<hr />
				<br />
				<br />
				<table id="subjectT">
					<tr>
						<th>강의명</th>
						<th>강의장</th>
						<th>강의시간</th>
					</tr>
					<tr>
						<td><c:out value = "${subjectInfo.subName }"/></td>
						<td><c:out value="${subjectInfo.buildingName }"/></td>
						<td><c:out value="${subjectInfo.dayInfo}"/></td>
					</tr>
				</table>
				<br />
				
				<br />
				<table id="stuT">
					<thead>
						<tr>
							<th>학생이름</th>
							<th>학번</th>
							<th>중간고사</th>
							<th>기말고사</th>
							<th>출석점수</th>
							<th>과제점수</th>
							<th>평점</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="insertResultlist" items="${stuList }">
						<tr>
							<td><c:out value="${insertResultlist.studentName }"/></td>
							<td><c:out value="${insertResultlist.studentNo }"/></td>
							<td><input type="text" value="${insertResultlist. middleScore}"/></td>
							<td><input type="text" value="${insertResultlist. finalScore}"/></td>
							<td><input type="text" value="${insertResultlist. attendanceScore}"/></td>
							<td><input type="text" value="${insertResultlist. workScore}"/></td>
							<td></td>
						</tr>
						</c:forEach>
					</tbody>
					<tr>
						<td colspan="4"><button style="float:right;">입력</button></td>
						<td colspan="4"><button style="float:left;">취소</button></td>
					</tr>
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
</body>
</html>
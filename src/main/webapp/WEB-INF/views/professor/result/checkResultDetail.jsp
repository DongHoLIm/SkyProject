<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<title>메인 페이지</title>
<style>
	#lectureScore{
		text-align: center;
	}
	#lectureScore tr th {
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
	<div id="wrapper">
		<div id="main">
			<div class="inner">				
				<br>
				<h3>성적 확인</h3>
				<hr />
				<br />
				<br />
				<table id="lectureScore">
					<tr>
						<th>중간고사</th>
						<th>기말고사</th>
						<th>출석점수</th>
						<th>과제점수</th>
					</tr>
					 <tr>
						<%-- <td><c:out value="${subSch.middleExam } %"/></td>
						<td><c:out value="${subSch.finalExam } %"/></td>
						<td><c:out value="${subSch.attendance } %"/></td>
						<td><c:out value="${subSch.homeWork } %"/></td> --%>
						<td>20%</td>
						<td>20%</td>
						<td>20%</td>
						<td>20%</td>
					</tr> 
				</table>
				<br />
				
				<br />
				<table id="stuT">
					<tr>
						<th>점수코드</th>
						<th>학생이름</th>
						<th>학번</th>
						<th>중간고사</th>
						<th>기말고사</th>
						<th>출석점수</th>
						<th>과제점수</th>
						<th style="width: 15%">점수</th>
						<th style="width: 20%">성적</th>
					</tr>
					<tbody>
						<c:forEach var="insertResultlist" items="${stuList }">
						<tr>
							<td><c:out value="${insertResultlist.gradeCode}"/></td>
							<td><c:out value="${insertResultlist.studentName }"/></td>
							<td><c:out value="${insertResultlist.studentNo }"/></td>
							<td><c:out value='${insertResultlist. middleScore}'/></td>
							<td><c:out value='${insertResultlist. finalScore}'/></td>
							<td><c:out value='${insertResultlist. workScore}'/></td>
							<td><c:out value='${insertResultlist. attendanceScore}'/></td>
							<td><c:out value='${insertResultlist. score}'/></td>
							<td><c:out value='${insertResultlist.grade}'/></td>
						</tr>
						</c:forEach>
					</tbody>					
				</table>
				
				
			</div>
		</div>
		<div>			
		
		</div>
	</div>	

</body>
</html>
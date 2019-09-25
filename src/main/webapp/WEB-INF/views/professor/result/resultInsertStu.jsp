<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	#lectureScore {
		text-align:  center;
	}
	#lectureScore tr th{
		text-align:center;
	}
	input[type='number']{
		width: 40%;
		
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
				<table id="stuT">
					<thead>
						<tr>
							<th>점수코드</th>
							<th>학생이름</th>
							<th>학번</th>
							<th>중간고사</th>
							<th>기말고사</th>
							<th>출석점수</th>
							<th>과제점수</th>
							<th>점수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="insertResultlist" items="${stuList }">
						<tr>
							<td><input type="hidden" value='<c:out value="${insertResultlist.gradeCode}"/>' name="gradeCode"/><c:out value="${insertResultlist.gradeCode}"/></td>
							<td><c:out value="${insertResultlist.studentName }"/></td>
							<td><c:out value="${insertResultlist.studentNo }"/></td>
							<td><input type="number" value="<c:out value='${insertResultlist. middleScore}'/>" max="100" min="0" name="middleScore"/></td>
							<td><input type="number" value="<c:out value='${insertResultlist. finalScore}'/>" max="100" min="0" name="finalScore"/></td>
							<td><input type="number" value="<c:out value='${insertResultlist. workScore}'/>" max="100"  min="0" name="attendanceScore"/></td>
							<td><input type="number" value="<c:out value='${insertResultlist. attendanceScore}'/>" max="100" min="0" name="workScore"/></td>
							<td></td>
						</tr>
						</c:forEach>
					</tbody>
					<tr>
						<td colspan="4"><button type="submit" style="float:right;">입력</button></td>
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
	<script>
 	var result = 0;
 	var result1 = 0;
 	var result2 = 0;
 	var result3 = 0;
	$("input[type='number']").on("propertychange change keyup paste input", function() {
	  
	   	
		var middlePercent = $("#lectureScore tr td").eq(0).text();
	    var finalPercent = $("#lectureScore tr td").eq(1).text();
	    var attendancePercent = $("#lectureScore tr td").eq(2).text();
	    var homeWorkPercent = $("#lectureScore tr td").eq(3).text();
	    
	    var mp = Number(middlePercent.slice(0,-1));
	   	var fp = Number( finalPercent.slice(0,-1));
	   	var ap = Number(attendancePercent.slice(0,-1));
	   	var hp = Number( homeWorkPercent.slice(0,-1));
	    
	   	console.log(mp);
		var currentVal = $(this).val();
	    var name = $(this).attr('name');
	    
	    console.log(currentVal);
	   	 if(name == "middleScore"){
	   		result = currentVal *(mp/100);	   		
	   	} else if(name=="finalScore"){
	   		result1 = currentVal *(fp/100);
	   	} else if(name=="attendanceScore"){
	   		result2 = currentVal *(ap/100);
	   	}else{
	   		result3 = currentVal *(hp/100);
	   	}
	   	var total = result+result1+result2+result3;	   	
	   	$(this).parents().children().eq(8).append($input); 
	   	$(this).parents().children().eq(8).text(total);
	});
	</script>
</body>
</html>
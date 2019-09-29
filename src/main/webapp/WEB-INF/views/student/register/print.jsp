<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>
		<div align="center" style="border:1px solid black; width:600px; height:800px; padding:1em 1em 1em 1em;">
		<h1 id="h1">등록금 납부 확인서</h1>
		<c:forEach var="Enrollment" items="${ memberEnrollment }">
		<table align="center" style="text-align:center; border-spacing: 0 50px;">
			<tr>
				<td style="text-align:left">등록상태 </td>
				<td style="text-align:left">납부완료</td> 
			</tr>
			<tr>
				<td style="text-align:left">학번 : </td>
				<td style="text-align:left">${Enrollment.studentNo}</td> 
			</tr>
			<tr>
				<td style="text-align:left">납부금액 : </td>
				<td style="text-align:left"><fmt:formatNumber value="${Enrollment.tuition }" pattern="#,###"/> 원</td> 
			</tr>
			<tr>
				<td style="text-align:left">등록년도/학기 : </td>
				<td style="text-align:left">
					${Enrollment.enrollYear}학년도 ${Enrollment.enrollSemester}학기
				</td> 
			</tr>
			<tr>
				<td colspan="2">위 사람이 본교에 등록금을 납부했음을 증명합니다.</td>
			</tr>
			<tr>
			</tr>
		</table>
		</c:forEach>
		<br>		
		<h1>K H 대 학 교 총 무 처 장</h1>
	</div>
</body>
<script>
		window.print();
</script>
</html>
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
	
	#h1 {
		align: center;
		margin-top: 5%;
	}
	
	table, td {
		border: 1px solid black;
	}
	
</style>
</head>
<body>
	<div align="center">
		<h1 id="h1">강의 평가 입력</h1>
		<form action="st_InsertLectureEvaluation.le">
			<table align="center" style="text-align:center;">
				<c:forEach var="ql" items="${list}">
					<tr>
						<td style="text-align: center; width: 50px">${ql.questionNo2}</td>
						<td style="text-align: left; width: 600px">${ql.questionContent}</td>
						<td style="text-align: center; width: 50px">
							<select class="answer" name="answer">
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>
						</td> 
					</tr>
				</c:forEach>
			</table>
			<br>
			<div>
				<input type="submit" value="입력">
			</div>
		</form>		
	</div>
</body>
</html>
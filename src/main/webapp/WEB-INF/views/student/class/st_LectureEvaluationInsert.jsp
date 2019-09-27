<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
		<form action="st_LectureEvaluationInsert.le" method="POST">
			<input type="hidden" name="lectureNo" id="lectureNo" value="${lev.lectureNo}">
			<table align="center" style="text-align:center;">
				<tr>
					<td style="text-align: center; width: 50px">1.</td>
					<td style="text-align: left; width: 600px">강의내용 및 진행은 강의계획서에 따라 진행되었다.</td>
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
				<tr>
					<td style="text-align: center; width: 50px">2.</td>
					<td style="text-align: left; width: 600px">시험 문제는 강의 내용을 잘 반영하였다.</td>
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
				<tr>
					<td style="text-align: center; width: 50px">3.</td>
					<td style="text-align: left; width: 600px">강의 교재나 부교재는 학습에 도움이 되는 것이었다.</td>
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
				<tr>
					<td style="text-align: center; width: 50px">4.</td>
					<td style="text-align: left; width: 600px">교수의 개인 사정에 의한 휴, 결강이 없었다.</td>
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
				<tr>
					<td style="text-align: center; width: 50px">5.</td>
					<td style="text-align: left; width: 600px">교수는 학생들의 질문에 성의있게 답하였다.</td>
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
			</table>
			<br>
			<div>
				<input type="submit" value="입력" id="submitBtn">
			</div>
		</form>		
	</div>
	<script>
		$("#submitBtn").click(function(){
			opener.document.location.reload();
			self.close();
		});
	</script>
</body>
</html>
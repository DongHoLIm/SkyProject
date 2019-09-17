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
	<div id="wrapper">
		<div id="main">
			<div class="inner">				
				<br>
				<h3>성적 확인</h3>
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
						<td>새천년</td>
						<td>인문관</td>
						<td>월,수/13:00~15:00</td>
					</tr>
				</table>
				<br />
				
				<br />
				<table id="stuT">
					<tr>
						<th>학생이름</th>
						<th>학번</th>
						<th>중간고사</th>
						<th>기말고사</th>
						<th>출석점수</th>
						<th>과제점수</th>
						<th>평점</th>
					</tr>
					<tr>
						<td>임동호</td>
						<td>201281065</td>
						<td><input type="text" /></td>
						<td><input type="text" /></td>
						<td><input type="text" /></td>
						<td><input type="text" /></td>
						<td>4.5</td>
					</tr>					
				</table>
				
				
			</div>
		</div>
		<div>			
		
		</div>
	</div>	

</body>
</html>
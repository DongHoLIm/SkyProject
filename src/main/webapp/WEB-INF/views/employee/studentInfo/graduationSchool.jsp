<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
#tableArea tbody tr td:last-child:hover {
	font-weight: bold;
	cursor: pointer;
}
</style>
</head>
<body>

<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<!-- 입력 라인  -->
			<br>
			<h2 style="width:85%; margin: 0 auto;">교내 졸업 인증 기준</h2>
			<br>
			
			<table id="tableArea" style="width:85%; text-align: center; margin: 0 auto;">
			<thead>
				<tr>
					<th width="10%" style="text-align:center">구분</th>
					<th width="10%" style="text-align:center">졸업인증 코드</th>
					<th width="25%" style="text-align:center">졸업인증 명칭</th>
					<th width="40%" style="text-align:center">졸업인증 내용</th>
					<th width="15%" style="text-align:center">내용 수정</th>
				</tr>
			</thead>	
			
			<tbody id="tbody">
				<c:forEach var="list" items="${list }">
					<tr>
						<td><c:out value="${list.division }"/></td>
						<td><c:out value="${list.graduationCode }"/></td>
						<td><c:out value="${list.graduationName }"/></td>
						<td><c:out value="${list.graduationContent }"/></td>
						<td class="btn">수정하기</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<script>
			/* $("#tableArea").find("td").parents().children("td").eq(4).mouseenter(function(){
				$(this).css({"font-weight":"bold", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).css({"font-weight":"normal"});
			}).click(function(){
				var code = $(this).parents().children("td").eq(1).text();
				
				console.log(code);
				
				window.open("em_changeGraduationSc.si?code="+code,'popup' ,"height=550, width=900");
				
			}); */
			$(function(){
				$(".btn").click(function(){
					
					var code = $(this).parents().children("td").eq(1).text();
					
					console.log(code);
					
					window.open("em_changeGraduationSc.si?code="+code,'changSc' ,"height=550, width=900");

				});
			});
			</script>
			
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</div>

</body>
</html>
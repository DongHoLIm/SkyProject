<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 부여페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.updateAccount{
		display: inline-block;
	}
	#employeememberlist {
		text-align: center;
	}
	#employeememberlist thead tr th{
		text-align:center;
	}
	#employeememberlist tbody tr:hover{
		color: black;
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
				<h3 class="updateAccount">권한 부여/수정</h3>
				<form action="updateAccount.me" method="post">
				<div style="float: right;">
				<input type="text" />
				<button type="reset"class="updateAccount" >취소</button>
				</div>
				<hr />
				<br />
				<br />			
				<table id="employeememberlist">
					<thead>
						<tr>
							<th>교직원 아이디</th>
							<th>교직원 이름</th>
							<th>교직원 부서</th>
							<th>직급</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var='eml' items="${list}">
						<tr>
							<td>${eml.memberId}</td>
							<td>${eml.memberKName}</td>
							<td>${eml.sdeptCode}</td>
							<td>${eml.rankCode}</td>							
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
				<c:set var = "pageInfo" value="${pi }"/>
				<ul class="pagination" align="center">
					<c:if test = "${pi.currentPage<=1 }">
						<li><span class="button disabled" >Prev</span></li>
					</c:if>
					<c:if test = "${pi.currentPage>1 }">
						<li><span class="button" id="prevBtn">Prev</span></li>
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}"> 
						<c:if test="${p eq pi.currentPage }">
							<li class="pageNumber"><p class="page active">${p}</p></li>
						</c:if>
						<c:if test ="${p ne pi.currentPage }">
							<li class="pageNumber"><a class="page">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">					
					<li><span class="button" id="nextBtn">next</span></li>
					</c:if>
					<c:if test = "${pi.currentPage ==pi.maxPage }">
					<li><span class="button disabled">Next</span></li>
					</c:if>
				</ul>
			</div>
		</div>
		
		<div>			
			<jsp:include page="../../common/menubar-employee.jsp" />		
		</div>
	</div>
	<script>
		$(function (){
			$("#employeememberlist tbody tr").click(function(){
				var  id= $(this).children().eq(0).text();
				window.open("accountDetail.me?userId="+id,"교직원 권한확인","width='150px'");
				console.log(id);
			});
		});
	</script>
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
</body>
</html>
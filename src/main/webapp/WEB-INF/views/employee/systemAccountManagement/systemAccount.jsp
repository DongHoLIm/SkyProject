<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 부여페이지</title>
<style>
	.updateAccount{
		display: inline-block;
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
				<form action="" method="post">
				<div style="float: right;">
				<button class="updateAccount" >수정</button>
				<button type="reset"class="updateAccount" >취소</button>
				</div>
				<hr />
				<table>
					<thead>
						<tr>
							<th>교직원 아이디</th>
							<th>교직원 이름</th>
							<th>교직원 부서</th>
							<th>수업관리</th>
							<th>학적관리</th>
							<th>등록관리</th>
							<th>장학관리</th>
							<th>기숙사관리</th>
							<th>정보생활</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var='eml' items="${list}">
						<tr>
							<td>${eml.memberId}</td>
							<td>${eml.memberKName }</td>
							<td>${eml.sdeptCode}</td>
							<td><input type="checkbox" value="1" id="selectOne" name="classManager"/><label
								for="selectOne"></label></td>
							<td><input type="checkbox" value="1" id="selectTwo" name="scholarlyManager"/><label
								for="selectTwo"></label></td>
							<td><input type="checkbox" value="1" id="selectThree" name="enrollManager" /><label
								for="selectThree"></label></td>
							<td><input type="checkbox" value="1" id="selectFore" name="scholManager"/><label
								for="selectFore"></label></td>
							<td><input type="checkbox" value="1" id="selectFive" name="dormitoryManager"/><label
								for="selectFive"></label></td>
							<td><input type="checkbox" value="1" id="selectSix" name="boardManager"/><label
								for="selectSix"></label></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div>
		</div>
		
		<div>			
			<jsp:include page="../../common/menubar-employee.jsp" />		
		</div>
	</div>
	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
</body>
</html>
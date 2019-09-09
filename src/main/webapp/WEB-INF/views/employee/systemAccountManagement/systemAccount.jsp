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
						<tr>
							<td>아이디</td>
							<td>이름</td>
							<td>부서</td>
							<td><input type="checkbox" value="1" id="selectOne" /><label
								for="selectOne"></label></td>
							<td><input type="checkbox" value="2" id="selectTwo" /><label
								for="selectTwo"></label></td>
							<td><input type="checkbox" value="3" id="selectThree" /><label
								for="selectThree"></label></td>
							<td><input type="checkbox" value="4" id="selectFore" /><label
								for="selectFore"></label></td>
							<td><input type="checkbox" value="5" id="selectFive" /><label
								for="selectFive"></label></td>
							<td><input type="checkbox" value="6" id="selectSix" /><label
								for="selectSix"></label></td>
						</tr>
					</tbody>
				</table>
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
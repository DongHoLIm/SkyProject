<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	#memberInfo{
		text-align: center;
	}
	#memberInfoDiv{
		width: 70%;
		margin: 0 auto;
	}
</style>
</head>
<body>
<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../common/header.jsp" />
				<br />
				<h4>회원 정보 변경</h4>				
				<hr />	
				<div id="memberInfoDiv" >			
				<table id="memberInfo">
					<tr>
						<td>한글이름 :</td>
						<td colspan="2"><input type="text" value="${user.memberKName}" name="memberKName" style="color:black;"/></td>
					</tr>
					<tr>
						<td>영어이름 :</td>
						<td colspan="2"><input type="text" value="${user.memberEName}" name="memberEName" style="color:black;"/></td>
					</tr>
					<tr>
						<td>아이디 : </td>
						<td colspan="2"><input type="text" value="${user.memberId}" name="memberId" style="background: rgb(227, 226, 222);color:black;" readonly/></td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td colspan="2"><input type="password" name="memberPwd" style="color:black;" /></td>
					</tr>
					<tr>
						<td>비밀번호 확인 : </td>
						<td colspan="2"><input type="password" style="color:black;"/></td>
					</tr>
					<tr>
						<td>주소 :</td>
						<td><input type="text" style="color:black;" value="${user.address }" name="address"/></td>
						<td><button>검색</button></td>	
					</tr>
					<tr>
						<td>이메일 :</td>
						<td colspan="2">
						<input type="text" value="${user.email }" name="email"/>						
						</td>
						
					</tr>
					<tr>
						<td>연락처 : </td>
						<td colspan="2"><input type="tel" value="${user.phone }" name="phone" style="color:black;" placeholder="-를 사용하여 기입해주세요"/></td>
					</tr>
					<tr>
						<td>비상 연락망 :</td>
						<td colspan="2"><input type="tel" style="color:black;"/></td>
					</tr>
				</table>				
				<div align="center">
				<button>수정</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button>취소</button>
				</div>
				</div>
			</div>
		</div>
		<div>
			<c:if test="${member eq '1'}">
				<jsp:include page="../common/menubar-student.jsp" />
			</c:if>
			<c:if test="${member eq '2'}">
				<jsp:include page="../common/menubar-professor.jsp" />
			</c:if>
			<c:if test="${member eq '3'}">
				<jsp:include page="../common/menubar-employee.jsp" />
			</c:if>
		</div>
	</div>	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>	
</body>
</html>
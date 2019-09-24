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
	.confirm fieldset{
		border: 2px solid lightgray;
		border-radius: 20px;
		background: rgb(227, 226, 222);
	}
	#passwordArea{
		width: 40%;
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
				<br />
				<h3>회원 정보 수정</h3>						
				<hr />
				<br />
				<form action="checkPwd.me" method="post" >
				<div class="confirm" align="center">
			        <fieldset>	
			        	<br />
			        	<h3>비밀번호 확인</h3>
			        	<br />		           
			            <p class="info"><strong>${loginUser.memberKName}</strong> 님의 회원정보를 안전하게 보호하기 위해<br />비밀번호를 한번 더 확인해 주세요.</p>
			           	 <br />
			           	<input type="password" name="password" id="passwordArea"/>
			           	<br />
			           	<button type="submit">비밀번호 확인 </button>			            
			        </fieldset>
			    </div>
			    </form>
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
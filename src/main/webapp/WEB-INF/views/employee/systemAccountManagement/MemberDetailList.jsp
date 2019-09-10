<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h3>회원 상세 정보</h3>
				<hr />
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>이름(한글)</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>이름(영문)</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>구분</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>부서/과</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>직급</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td>퇴사여부</td>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td><button>수정</button></td>
						<td><button>취소</button></td>
					</tr>
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
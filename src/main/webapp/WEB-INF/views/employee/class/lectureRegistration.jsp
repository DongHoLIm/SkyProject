<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>강의개설등록</h2>
				<hr style="margin: 0 auto;">
				<br> <br>
				<div style="width:80%; margin:0 auto;"> 
					<form action="" method="post">
						<table>
						<span>
						<label style="background:lightgray;width:11%;"><h2>과목번호</h2></label>
						<label style="background:lightgray;width:11%;"><h2><c:out value="${ lo.subCode }"/></h2></label>
								<td class="td">과목번호</td>
								<td colspan='1'><input type="text" value="<c:out value="${ lo.subCode }"/>"readonly></td>
								<td class="td">과목명</td>
								<td><input type="text" value="<c:out value="${ lo.subName }"/>" readonly></td>
								<td class="td">학과</td>
								<td><input type="text" value="<c:out value="${ lo.sdeptName }"/>" readonly></td>
								<td class="td">인정 학점</td>
								<td><input type="text" value="<c:out value="${ lo.subGrade }"/>" readonly></td>
							</tr>
		
							<tr>
								<td class="td">이수구분</td>
								<td><input type="text" value="<c:out value="${ lo.completeType }"/>" readonly></td>
								<td class="td">개설일자</td>
								<td>
									<fmt:parseDate value="${lo.madeDate}" var="madeDate" pattern="yyyy-MM-dd HH:mm:ss"/>
									<input type="text" value="<fmt:formatDate value="${madeDate}" pattern="yyyy/MM/dd"/>" readonly>
								</td>
							</tr>
		
							<tr>
								<td class="td">수강인원</td>
								<td colspan=""><input type="text" value=""></td>
							</tr>
		
							<tr>
								<td class="td">개강학기</td>
								<td><input type="text" value=""></td>
								<td class="td">교수명</td>
								<td>
									<select></select>
								</td>
								<td class="td">강의실정보</td>
								<td><input type="text" value=""></td>
							</tr>
		
							<tr>
								<td class="td">강의시간</td>
								<td><input type="text" value=""></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
			<div>
				<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
			</div>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	#SMSList {
		text-align:center;
	}
	#SMSList tr th{
		text-align:center;
	}
	#SMSList tbody tr :hover{
		color: black;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h3>SMS 전송 내역</h3>
				<hr />
				<div>
					<table id="SMSList">
						<thead>
							<tr>
								<th>번호</th>
								<th>수신인원</th>
								<th>발신일</th>
								<th>발신내용</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listMember"  items="${list}" varStatus="status">
								<tr>
									<td><c:out value="${status.count}"/></td>
									<td><c:out value="${listMember.memberCount}"/></td>
									<td><c:out value="${listMember.sendDate }"/></td>
									<td><c:out value="${listMember.SMSmessage }"/></td>
								</tr>
							
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div>		
			<jsp:include page="../../common/menubar-professor.jsp" />			
		</div>
	</div>
	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	<script>
		$(function(){
			$("#SMSList tbody tr").click(function(){
				var date = $(this).children().eq(2).text();
				window.open( "SendSMSDetail.pro?date="+date,'상세보기','width=50px;');
				
				
			});
		});
	</script>
</body>
</html>
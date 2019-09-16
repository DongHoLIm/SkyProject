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
	#basic {
		padding: 10px 0px 0px 100px;
	}
	
	th {
		width: 10%;
		background: #E5E6E7;
	}
	
	td {
		background: white;
		text-align: center;
	}
</style>	
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">시스템 문의</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
				<div align="right" style="margin: 0 auto; width:88.5%;">
					<input type="hidden" id="memberId" name="memberId" value="${loginUser.memberId}">
					<div style="margin-bottom: 10px">					
						<button id="goAnswer">답변하기</button>
					</div>
				</div>
			<input type="hidden" id="questionNo" name="questionNo" value="${sq.questionNo}">
			<table style="width: 88.5%; margin: 0 auto;">				
				<tbody>
					<tr>
						<th style="text-align: center;">문의번호</th>
						<td>${sq.questionNo}</td>
						<th style="text-align: center;">제목</th>
						<td colspan="4">${sq.questionTitle}</td>
					</tr>
					<tr>
						<th style="text-align: center;">작성자</th>
						<td>${sq.questionWriter}</td>
						<th style="text-align: center;">작성일자</th>
						<td>
							<fmt:parseDate value="${sq.questionDate}" var="questionDate" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${questionDate}" pattern="yyyy/MM/dd"/>
						</td>
						<th style="text-align: center;">조회수</th>
						<td>${sq.questionCount}</td>
					</tr>
					<tr>
						<td colspan="6" style="text-align: left; height: 100px;">
							<c:if test="${!empty uf}">
								<div align="center">
									<img src="${uf.path}" width="50%" height="70%">
								</div>
							</c:if>
							${sq.questionContent}
						</td>
					</tr>
				</tbody>									
			</table>
			<div align="right" style="margin: 0 auto; width:88.5%;">
					<input type="hidden" id="memberId" name="memberId" value="${loginUser.memberId}">
					<div style="margin-bottom: 10px">
					<c:if test="${sessionScope.loginUser.memberId == sq.memberId}">
						<button onclick="updateSystemQuestion()">수정</button>
						<button onclick="deleteSystemQuestion()">삭제</button>				
					</c:if>
						<button id="goListBtn">목록</button>
					</div>
				</div>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>
	<script>
	
		$("#goAnswer").click(function(){
			var questionNo = $("#questionNo").val();
			
			location.href = "em_showSystemQuestionAnswer.bo?questionNo=" + questionNo;
		});
		
		$("#goListBtn").click(function(){			
			location.href = "em_systemQuestionList.bo";
		})
		
		function updateSystemQuestion(){
			var questionNo = $("#questionNo").val();
			
			location.href = "em_showSystemQuestionUpdate.bo?questionNo=" + questionNo;
		}
		
		function deleteSystemQuestion(){
			var questionNo = $("#questionNo").val();
			
			alert("게시글을 삭제하시겠습니까?");
			
			location.href = "em_SystemQuestionDelete.bo?questionNo=" + questionNo;
		}
	</script>
</body>
</html>
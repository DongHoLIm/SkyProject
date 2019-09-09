<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h4 id="basic">학사 일정</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<c:if test="${sessionScope.loginUser.memberId == b.memberId}">
				<div align="right" style="margin: 0 auto; width:88.5%;">
					<div style="margin-bottom: 10px">
						<button onclick="updateBoard()">수정</button>
						<button onclick="deleteBoard()">삭제</button>				
					</div>
				</div>
			</c:if>
			<table style="width: 88.5%; margin: 0 auto;">
				<tr>
					<th style="text-align: center;">작성자</th>
					<td>${b.writer}</td>
					<th style="text-align: center;">작성부서</th>
					<td>${b.writeDept}</td>
					<th style="text-align: center;">조회수</th>
					<td>${b.count}</td>
					
				</tr>
				<tr>
					<th style="text-align: center;">시작일시</th>
					<td>
						<fmt:parseDate value="${b.startDate}" var="startDate" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${startDate}" pattern="yyyy/MM/dd"/>
					</td>
					<th style="text-align: center;">종료일시</th>
					<td>
						<fmt:parseDate value="${b.endDate}" var="endDate" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${endDate}" pattern="yyyy/MM/dd"/>
					</td>					
					<th style="text-align: center;">게시기한</th>
					<td>
						<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd HH:mm:ss"/>
						<fmt:formatDate value="${deadLine}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">제목</th>
					<td colspan="6">${b.title}</td>
				</tr>				
				<tr>
					<td colspan="6" style="text-align: left; height: 100px;">
						<c:if test="${!empty uf}">
							<div align="center">
								<img src="${uf.path}" width="50%" height="70%">
							</div>
						</c:if>
						${b.content}
					</td>
				</tr>
				<tr>
					<td colspan="6"><button onclick="em_acNoticeList()">목록으로</button>
				</tr>
			</table>
		</div>
		<div>
		<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
	</div>
	<script>
		function em_acNoticeList(){
			location.href="em_acNoticeList.bo";
		}
		
		function deleteBoard() {
			var boardNo = ${b.boardNo};
			
			alert("게시글을 삭제하시겠습니까?");
			
			location.href=".bo?boardNo="+boardNo;
		}
		
		function updateBoard(){
			var boardNo = ${b.boardNo};			
			
			location.href="em_showUpdateacNotice.bo?boardNo="+boardNo;
		}
		
		$(function(){
			var width = $("img").width();
			var height = $("img").height();
			
			console.log(width);
			console.log(height);
		});
		
	</script>
</div>
</body>
</html>
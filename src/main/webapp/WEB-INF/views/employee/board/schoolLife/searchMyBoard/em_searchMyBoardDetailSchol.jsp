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
			<h4 id="basic">장학 공지</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<input type="hidden" name="memberId" id="memberId" value="${b.memberId}">
			<input type="hidden" id="boardNo" name="boardNo" value="${b.boardNo}">
			<table style="width: 88.5%; margin: 0 auto;">
				<tr>
					<th style="text-align: center;">작성자</th>
					<td>${b.writer}</td>
					<th style="text-align: center;">작성부서</th>
					<td>${b.writeDept}</td>
					<th style="text-align: center;">게시기한</th>
					<td>
						<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd HH:mm:ss"/>
						<fmt:formatDate value="${deadLine}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">제목</th>
					<td colspan="3">${b.title}</td>
					<th style="text-align: center;">조회수</th>
					<td>${b.count}</td>
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
					<td colspan="6"><button onclick="em_sNoticeList()">목록으로</button>
				</tr>
			</table>
		</div>
		<div>
		<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
	</div>
	<script>
		function em_sNoticeList(){		
			var memberId = $("#memberId").val();
			
			location.href="em_searchMyBoardList.bo?memberId="+memberId;
		}
		
		
	</script>
</div>
</body>
</html>
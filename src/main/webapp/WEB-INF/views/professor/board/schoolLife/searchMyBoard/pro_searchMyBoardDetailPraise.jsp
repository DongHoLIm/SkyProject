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
	.updateSpan	{
		padding-left: 10px;
	}
	
	.deleteSpan:hover, .updateSpan:hover{
		cursor: pointer;
		color: black;
	}
</style>	
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">칭찬합시다</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
				<div align="right" style="margin: 0 auto; width:88.5%;">
					<div style="margin-bottom: 10px">
						<button onclick="st_freeBoardList()">목록</button>
					</div>
				</div>
			<input type="hidden" name="memberId" id="memberId" value="${b.memberId}">
			<input type="hidden" id="boardNo" name="boardNo" value="${b.boardNo}">
			<table style="width: 88.5%; margin: 0 auto;">				
				<tbody id="tbody">
					<tr>
						<th style="text-align: center;">글번호</th>
						<td>${b.boardNo}</td>
						<th style="text-align: center;">제목</th>
						<td colspan="4">${b.title}</td>
					</tr>
					<tr>
						<th style="text-align: center;">작성자</th>
						<td>${b.writer}</td>
						<th style="text-align: center;">작성일자</th>
						<td>
							<fmt:parseDate value="${b.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${enrollDate}" pattern="yyyy/MM/dd"/>
						</td>
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
							<pre>${b.content}</pre>
						</td>
					</tr>
				</tbody>									
			</table>
		</div>
		<div>
		<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
	</div>
	<script>
		function st_freeBoardList(){
			var memberId = $("#memberId").val();
			
			location.href="em_searchMyBoardList.bo?memberId="+memberId;
		}		
		
	</script>
</div>
</body>
</html>
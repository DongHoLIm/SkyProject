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
</head>
<style>
#basic {
	padding: 10px 0px 0px 100px;
}

.sel1 { 
	width: 100%
}

.nNoticeTtitle:hover{
	color: black;
	font-weight: bold;
	cursor: pointer;
}

#writeArea {
	margin: 0 auto;
	width: 88.5%;
}

#writeBtn {
	align: right;
}

.pagingArea {
	margin-top: 2%;
}

</style>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">일반 공지</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tr>
					<td>상세검색</td>
					<td colspan='5'>
						<select class="sel1">
							<option value="">선택</option>
							<option value="">작성자</option>
							<option value="">작성부서</option>
							<option value="">제목</option>
						</select>
					</td>
					<td>
						<input style="display: inline-block; width: 80%;" type="text" value="" placeholder="내용을 입력해주세요">
					</td>
					<td>
						<input style="display: inline-block;" type="button" value="검색">
					</td>
				</tr>
			</table>


			<br>
			<br>
			<div id="writeArea">
				<div align="right" style="margin-bottom: 10px;">
					<input type="hidden" name="memberId" value="${sessionScope.loginUser.memberId}">
					<button id="writeBtn" onclick="insertnNotice()">글쓰기</button>
				</div>
			</div>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
				<tbody>
					<tr>
						<th width="5%" style="text-align: center">번호</th>
						<th width="9%" style="text-align: center;">등록일자</th>
						<th width="50%" style="text-align: center;">제목</th>
						<th width="9%" style="text-align: center;">작성자</th>
						<th width="9%" style="text-align: center;">작성부서</th>
						<th width="9%" style="text-align: center;">조회수</th>
						<th width="9%" style="text-align: center;">게시기한</th>
					</tr>
					<c:forEach var="b" items="${list}">
					<tr>
						<td style="text-align: center;" class="nNoticeNo"><c:out value="${b.boardNo}"/></td>
						<td style="text-align: center;"><c:out value="${b.enrollDate}"/></td>
						<td style="text-align: center;" class="nNoticeTtitle"><c:out value="${b.title}"/></td>
						<td style="text-align: center;"><c:out value="${b.writer}"/></td>
						<td style="text-align: center;"><c:out value="${b.writeDept}"/></td>
						<td style="text-align: center;"><c:out value="${b.count}"/></td>
						<td style="text-align: center;">
							<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${deadLine}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pagingArea">
			  <ul class="pagination" style="justify-content: center; cursor: pointer;">
				<c:if test="${pi.currentPage <= 1}">
			   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
				</c:if>
				<c:if test="${pi.currentPage > 1}">
					<c:url var="blistBack" value="em_nNoticeList.bo">
						<c:param name="currentPage" value="${pi.currentPage - 1}"/>
					</c:url>
					<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
				</c:if>
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:if test="${p eq pi.currentPage}">
					    <li class="page-item"><a class="page-link">${p}</a></li>					
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="blistCheck" value="em_nNoticeList.bo">
							<c:param name="currentPage" value="${p}"/>
						</c:url>
						 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<c:url var="blistEnd" value="em_nNoticeList.bo">
						<c:param name="currentPage" value="${pi.currentPage + 1}"/>
					</c:url>
			    	<li class="page-item"><a class="page-link" href="${blistEnd}">다음</a></li>				
				</c:if>
				<c:if test="${pi.currentPage >= pi.maxPage}">
					<li class="page-item"><a class="page-link">다음</a></li>	
				</c:if>
			 </ul>
			</div>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>
	
	<script>	
		$(function(){
			 $("#boardArea").find(".nNoticeTtitle").click(function(){
				var boardNo = $(this).parents().children("td").eq(0).text(); 				
				
				location.href = "em_nNoticeDetail.bo?boardNo=" + boardNo;				
			 });
		});
		
		function insertnNotice(){
			var memberId = $("input[name=memberId]").val();			
			
			location.href = "em_showInsertnNotice.bo?memberId=" + memberId;
		}
		
	</script>
</body>
</html>
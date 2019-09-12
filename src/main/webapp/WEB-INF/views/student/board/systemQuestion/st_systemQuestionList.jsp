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
	
	.myBoardTitle:hover {
		color: black;
		font-weight: bold;
		cursor: pointer;
	}
	
	.pagingArea {
		margin-top: 2%;
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
			
			<form action="" method="get">
				<input type="hidden" name="searchflag" id="searchflag" value="true">
				<input type="hidden" name="memberId" id="memberId" value="${loginUser.memberId}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;">
					<tr>
						<td>문의종류</td>
						<td colspan='2'>
							<select id="searchCondition" name="searchCondition">
								<option value="account">계정 관련</option>
								<option value="proof">제증명 관련</option>
								<option value="school">학사 관련</option>
							</select>
						</td>
						<td>
							<input style="display: inline-block;" type="submit" value="검색">
						</td>
					</tr>
				</table>
			</form>
			<c:if test="${pi.searchflag == false}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
					<thead>
						<tr>
							<th width="20%" style="text-align: center;">문의구분</th>
							<th width="50%" style="text-align: center;">제목</th>
							<th width="10%" style="text-align: center;">작성자</th>
							<th width="10%" style="text-align: center;">게시일자</th>
						</tr>
					</thead>
					<tbody>					
						<c:forEach var="b" items="${list}">
							<tr>
								<td style="text-align: center;" class="qusetionType">계정 관련</td>
								<td style="text-align: center;" class="questionTitle">아이디는 어떻게 찾나요?</td>
								<td style="text-align: center;">박성래</td>
								<td style="text-align: center;">2019/09/09
									<%-- <fmt:parseDate value="${b.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate value="${enrollDate}" pattern="yyyy/MM/dd"/> --%>
								</td>
							</tr>
						<input type="hidden" name="boardNo" id="boardNo" value="${b.boardNo}">
						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" id="currentPage" value="${pi.currentPage}">
				<div class="pagingArea">
				  <ul class="pagination" style="justify-content: center; cursor: pointer;">
					<c:if test="${pi.currentPage <= 1}">
				   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
					</c:if>
					<c:if test="${pi.currentPage > 1}">
						<c:url var="blistBack" value="st_systemQuestionList.bo">
							<c:param name="currentPage" value="${pi.currentPage - 1}"/>
							<c:param name="memberId" value="${loginUser.memberId}"/>
						</c:url>
						<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
						<c:if test="${p eq pi.currentPage}">
						    <li class="page-item"><a class="page-link">${p}</a></li>					
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<c:url var="blistCheck" value="st_systemQuestionList.bo">
								<c:param name="currentPage" value="${p}"/>	
								<c:param name="memberId" value="${loginUser.memberId}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="st_systemQuestionList.bo">
							<c:param name="currentPage" value="${pi.currentPage + 1}"/>
							<c:param name="memberId" value="${loginUser.memberId}"/>
						</c:url>
				    	<li class="page-item"><a class="page-link" href="${blistEnd}">다음</a></li>				
					</c:if>
					<c:if test="${pi.currentPage >= pi.maxPage}">
						<li class="page-item"><a class="page-link">다음</a></li>	
					</c:if>
				 </ul>
				</div>
			</c:if>	
			
			<c:if test="${pi.searchflag == true}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
					<thead>
						<tr>
							<th width="20%" style="text-align: center;">문의구분</th>
							<th width="50%" style="text-align: center;">제목</th>
							<th width="10%" style="text-align: center;">작성자</th>
							<th width="10%" style="text-align: center;">게시일자</th>
						</tr>
					</thead>
					<tbody>					
						<c:forEach var="b" items="${list}">
							<tr>
								<td style="text-align: center;" class="qusetionType">계정 관련</td>
								<td style="text-align: center;" class="questionTitle">아이디는 어떻게 찾나요?</td>
								<td style="text-align: center;">박성래</td>
								<td style="text-align: center;">2019/09/09
									<%-- <fmt:parseDate value="${b.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate value="${enrollDate}" pattern="yyyy/MM/dd"/> --%>
								</td>
							</tr>
						<input type="hidden" name="boardNo" id="boardNo" value="${b.boardNo}">
						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" id="currentPage" value="${pi.currentPage}">
				<div class="pagingArea">
				  <ul class="pagination" style="justify-content: center; cursor: pointer;">
					<c:if test="${pi.currentPage <= 1}">
				   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
					</c:if>
					<c:if test="${pi.currentPage > 1}">
						<c:url var="blistBack" value="st_systemQuestionSearchList.bo">
							<c:param name="currentPage" value="${pi.currentPage - 1}"/>
							<c:param name="memberId" value="${loginUser.memberId}"/>
							<c:param name="searchCondition" value="${searchCondition}"/>
							<c:param name="searchflag" value="${pi.searchflag}"/>
						</c:url>
						<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
						<c:if test="${p eq pi.currentPage}">
						    <li class="page-item"><a class="page-link">${p}</a></li>					
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<c:url var="blistCheck" value="st_systemQuestionSearchList.bo">
								<c:param name="currentPage" value="${p}"/>	
								<c:param name="memberId" value="${loginUser.memberId}"/>
								<c:param name="searchCondition" value="${searchCondition}"/>
								<c:param name="searchflag" value="${pi.searchflag}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="st_systemQuestionSearchList.bo">
							<c:param name="currentPage" value="${pi.currentPage + 1}"/>
							<c:param name="memberId" value="${loginUser.memberId}"/>
							<c:param name="searchCondition" value="${searchCondition}"/>
							<c:param name="searchflag" value="${pi.searchflag}"/>
						</c:url>
				    	<li class="page-item"><a class="page-link" href="${blistEnd}">다음</a></li>				
					</c:if>
					<c:if test="${pi.currentPage >= pi.maxPage}">
						<li class="page-item"><a class="page-link">다음</a></li>	
					</c:if>
				 </ul>
				</div>
			</c:if>		
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
		</div>
	</div>
	<script>		
		/* $(".questionTitle").click(function(){
			var boardNo = $(this).parents("tr").children().eq(0).text();	
			var memberId = $("#memberId").val();
			var boardType = $(this).parents("tr").children().eq(1).text();	
			
			console.log("boardNo :::: " + boardNo);
			console.log("memberId :::: " + memberId);
			console.log("boardType :::: " + boardType);
			
			if(boardType == "자유게시판"){
				
				location.href="st_searchMyBoardDetailFree.bo?boardNo="+boardNo+"&memberId="+memberId+"&boardType="+boardType;
				
			}else if(boardType == "칭찬합시다"){
				
				location.href="st_searchMyBoardDetailPraise.bo?boardNo="+boardNo+"&memberId="+memberId+"&boardType="+boardType;
			}
			
		}); */
	</script>
</body>
</html>
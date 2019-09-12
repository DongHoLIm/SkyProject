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
			<h4 id="basic">내 게시물 조회</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			
			<form action="pro_searchMyBoardSearchList.bo" method="get">
				<input type="hidden" name="searchflag" id="searchflag" value="true">
				<input type="hidden" name="memberId" id="memberId" value="${loginUser.memberId}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;">
					<tr>
						<td>게시판 별 검색</td>
						<td colspan='2'>
							<c:if test="${loginUser.memberStatus eq 1 || loginUser.memberStatus eq 2}">
								<select id="searchCondition" name="searchCondition">
									<option value="all">전체보기</option>
									<option value="praise">칭찬합시다</option>
									<option value="free">자유게시판</option>
								</select>
							</c:if>
							<c:if test="${loginUser.memberStatus eq 3}">
								<select id="searchCondition" name="searchCondition">
									<option value="all">전체보기</option>
									<option value="normal">일반공지</option>
									<option value="schol">장학공지</option>
									<option value="schedule">학사일정</option>
									<option value="event">교내외행사</option>
									<option value="praise">칭찬합시다</option>
									<option value="free">자유게시판</option>
								</select>
							</c:if>
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
							<th width="10%" style="text-align: center;">글번호</th>
							<th width="10%" style="text-align: center;">카테고리</th>
							<th width="50%" style="text-align: center;">제목</th>
							<th width="10%" style="text-align: center;">게시일자</th>
							<th width="10%" style="text-align: center;">수정</th>
							<th width="10%" style="text-align: center;">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${list}">
							<tr>
								<td style="text-align: center;" class="myBoardNo"><c:out value="${b.boardNo}"/></td>
								<td style="text-align: center;" class="myBoardType"><c:out value="${b.boardType}"/></td>
								<td style="text-align: center;" class="myBoardTitle"><c:out value="${b.title}"/></td>
								<td style="text-align: center;">
									<fmt:parseDate value="${b.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate value="${enrollDate}" pattern="yyyy/MM/dd"/>
								</td>
								<td style="text-align: center;">
									<button class="updateBtn">수정</button>
								</td>
								<td style="text-align: center;">
									<button class="deleteBtn">삭제</button>
								</td>
							</tr>
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
						<c:url var="blistBack" value="pro_searchMyBoardList.bo">
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
							<c:url var="blistCheck" value="pro_searchMyBoardList.bo">
								<c:param name="currentPage" value="${p}"/>	
								<c:param name="memberId" value="${loginUser.memberId}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="pro_searchMyBoardList.bo">
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
							<th width="10%" style="text-align: center;">글번호</th>
							<th width="10%" style="text-align: center;">카테고리</th>
							<th width="50%" style="text-align: center;">제목</th>
							<th width="10%" style="text-align: center;">게시일자</th>
							<th width="10%" style="text-align: center;">수정</th>
							<th width="10%" style="text-align: center;">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${list}">
							<tr>
								<td style="text-align: center;" class="myBoardNo"><c:out value="${b.boardNo}"/></td>
								<td style="text-align: center;" class="myBoardType"><c:out value="${b.boardType}"/></td>
								<td style="text-align: center;" class="myBoardTitle"><c:out value="${b.title}"/></td>
								<td style="text-align: center;">
									<fmt:parseDate value="${b.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate value="${enrollDate}" pattern="yyyy/MM/dd"/>
								</td>
								<td style="text-align: center;">
									<button class="updateBtn">수정</button>
								</td>
								<td style="text-align: center;">
									<button class="deleteBtn">삭제</button>
								</td>
							</tr>
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
						<c:url var="blistBack" value="pro_searchMyBoardSearchList.bo">
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
							<c:url var="blistCheck" value="pro_searchMyBoardSearchList.bo">
								<c:param name="currentPage" value="${p}"/>	
								<c:param name="memberId" value="${loginUser.memberId}"/>
								<c:param name="searchCondition" value="${searchCondition}"/>
								<c:param name="searchflag" value="${pi.searchflag}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="pro_searchMyBoardSearchList.bo">
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
			<jsp:include page="/WEB-INF/views/common/menubar-professor.jsp" />
		</div>
	</div>
	<script>		
		$(".deleteBtn").click(function(){
			var boardNo = $(this).parents("tr").children().eq(0).text();	
			var memberId = $("#memberId").val();
			
			alert("삭제하시겠습니까?");
			
			location.href="pro_searchMyBoardDelete.bo?boardNo="+boardNo+"&memberId="+memberId;
		});
		
		$(".updateBtn").click(function(){
			var boardNo = $(this).parents("tr").children().eq(0).text();	
			var memberId = $("#memberId").val();
			var boardType = $(this).parents("tr").children().eq(1).text();	
			
			console.log("boardNo :::: " + boardNo);
			console.log("memberId :::: " + memberId);
			console.log("boardType :::: " + boardType);
			
			if(boardType == "자유게시판"){
				
				location.href="pro_showsearchMyBoardUpdateFree.bo?boardNo="+boardNo+"&memberId="+memberId+"&boardType="+boardType;
				
			}else if(boardType == "칭찬합시다"){
				
				location.href="pro_showsearchMyBoardUpdatePraise.bo?boardNo="+boardNo+"&memberId="+memberId+"&boardType="+boardType;
			}
			
		});
		
		$(".myBoardTitle").click(function(){
			var boardNo = $(this).parents("tr").children().eq(0).text();	
			var memberId = $("#memberId").val();
			var boardType = $(this).parents("tr").children().eq(1).text();	
			
			console.log("boardNo :::: " + boardNo);
			console.log("memberId :::: " + memberId);
			console.log("boardType :::: " + boardType);
			
			if(boardType == "자유게시판"){
				
				location.href="pro_searchMyBoardDetailFree.bo?boardNo="+boardNo+"&memberId="+memberId+"&boardType="+boardType;
				
			}else if(boardType == "칭찬합시다"){
				
				location.href="pro_searchMyBoardDetailPraise.bo?boardNo="+boardNo+"&memberId="+memberId+"&boardType="+boardType;
			}
			
		});
	</script>
</body>
</html>
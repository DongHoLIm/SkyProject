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
	.nNoticeTtitle:hover{
		color: black;
		font-weight: bold;
		cursor: pointer;
	}
	
	#searchValue { 
		width: 100%
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
			<h4 id="basic">일반 공지</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			
			<form action="st_searchnNotice.bo" method="get">
				<input type="hidden" name="searchflag" id="searchflag" value="true">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;">
					<tr>
						<td>상세검색</td>
						<td colspan='5'>
							<select id="searchCondition" name="searchCondition">
								<option value="writer">작성자</option>
								<option value="writeDept">작성부서</option>
								<option value="title">제목</option>
							</select>
						</td>
						<td>
							<input style="display: inline-block; width: 80%;" type="text" name="searchValue" id="searchValue" placeholder="내용을 입력해주세요">
						</td>
						<td>
							<input style="display: inline-block;" type="submit" value="검색">
						</td>
					</tr>
				</table>
			</form>
			
			<br>
			<br>
			<input type="hidden" id="checkflag" name="checkflag" value="${spi.searchflag}">
			<c:if test="${spi.searchflag == true}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
					<tbody>
						<tr>
							<th width="5%" style="text-align: center">번호</th>
							<th width="9%" style="text-align: center;">등록일자</th>
							<th width="50%" style="text-align: center;">제목</th>
							<th width="9%" style="text-align: center;">작성자</th>
							<th width="12%" style="text-align: center;">작성부서</th>
							<th width="7%" style="text-align: center;">조회수</th>
							<th width="9%" style="text-align: center;">게시기한</th>
						</tr>
						<c:forEach var="b" items="${slist}">
						<tr>
							<td style="text-align: center;" class="nNoticeNo"><c:out value="${b.boardNo}"/></td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.enrollDate}" var="enorllDate" pattern="yyyy-MM-dd HH:mm:ss"/>
								<fmt:formatDate value="${enorllDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;" class="nNoticeTtitle"><c:out value="${b.title}"/></td>
							<td style="text-align: center;"><c:out value="${b.writer}"/></td>
							<td style="text-align: center;"><c:out value="${b.writeDept}"/></td>
							<td style="text-align: center;"><c:out value="${b.count}"/></td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd HH:mm:ss"/>
								<fmt:formatDate value="${deadLine}" pattern="yyyy/MM/dd"/>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" id="currentPage" value="${spi.currentPage}">
				<div class="pagingArea">
				  <ul class="pagination" style="justify-content: center; cursor: pointer;">
					<c:if test="${spi.currentPage <= 1}">
				   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
					</c:if>
					<c:if test="${spi.currentPage > 1}">
						<c:url var="blistBack" value="st_searchnNotice.bo">
							<c:param name="searchCondition" value="${searchCondition}"/>																					
							<c:param name="searchValue" value="${searchValue}"/>
							<c:param name="currentPage" value="${spi.currentPage - 1}"/>
							<c:param name="searchflag" value="${spi.searchflag}"/>
						</c:url>
						<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
					</c:if>
					<c:forEach var="p" begin="${spi.startPage}" end="${spi.endPage}">
						<c:if test="${p eq spi.currentPage}">
						    <li class="page-item"><a class="page-link">${p}</a></li>					
						</c:if>
						<c:if test="${p ne spi.currentPage}">
							<c:url var="blistCheck" value="st_searchnNotice.bo">
								<c:param name="searchCondition" value="${searchCondition}"/>													
								<c:param name="searchValue" value="${searchValue}"/>
								<c:param name="currentPage" value="${p}"/>	
								<c:param name="searchflag" value="${spi.searchflag}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${spi.currentPage < spi.maxPage }">
						<c:url var="blistEnd" value="st_searchnNotice.bo">
							<c:param name="searchCondition" value="${searchCondition}"/>														
							<c:param name="searchValue" value="${searchValue}"/>
							<c:param name="currentPage" value="${spi.currentPage + 1}"/>
							<c:param name="searchflag" value="${spi.searchflag}"/>
						</c:url>
				    	<li class="page-item"><a class="page-link" href="${blistEnd}">다음</a></li>				
					</c:if>
					<c:if test="${spi.currentPage >= spi.maxPage}">
						<li class="page-item"><a class="page-link">다음</a></li>	
					</c:if>
				 </ul>
				</div>
			</c:if>
			
			<c:if test="${empty spi.searchflag}">
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
				<tbody>
					<tr>
						<th width="5%" style="text-align: center">번호</th>
						<th width="9%" style="text-align: center;">등록일자</th>
						<th width="50%" style="text-align: center;">제목</th>
						<th width="9%" style="text-align: center;">작성자</th>
						<th width="12%" style="text-align: center;">작성부서</th>
						<th width="7%" style="text-align: center;">조회수</th>
						<th width="9%" style="text-align: center;">게시기한</th>
					</tr>
					<c:forEach var="b" items="${list}">
					<tr>
						<td style="text-align: center;" class="nNoticeNo"><c:out value="${b.boardNo}"/></td>
						<td style="text-align: center;">
								<fmt:parseDate value="${b.enrollDate}" var="enorllDate" pattern="yyyy-MM-dd HH:mm:ss"/>
								<fmt:formatDate value="${enorllDate}" pattern="yyyy/MM/dd"/>
						</td>
						<td style="text-align: center;" class="nNoticeTtitle"><c:out value="${b.title}"/></td>
						<td style="text-align: center;"><c:out value="${b.writer}"/></td>
						<td style="text-align: center;"><c:out value="${b.writeDept}"/></td>
						<td style="text-align: center;"><c:out value="${b.count}"/></td>
						<td style="text-align: center;">
							<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${deadLine}" pattern="yyyy/MM/dd"/>
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
					<c:url var="blistBack" value="st_nNoticeList.bo">
						<c:param name="currentPage" value="${pi.currentPage - 1}"/>
					</c:url>
					<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
				</c:if>
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:if test="${p eq pi.currentPage}">
					    <li class="page-item"><a class="page-link">${p}</a></li>					
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="blistCheck" value="st_nNoticeList.bo">
							<c:param name="currentPage" value="${p}"/>
						</c:url>
						 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<c:url var="blistEnd" value="st_nNoticeList.bo">
						<c:param name="currentPage" value="${pi.currentPage + 1}"/>
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
		$(function(){
			 $("#boardArea").find(".nNoticeTtitle").click(function(){
				var boardNo = $(this).parents().children("td").eq(0).text(); 				
				
				location.href = "st_nNoticeDetail.bo?boardNo=" + boardNo;				
			 });
		});		
	</script>
</body>
</html>
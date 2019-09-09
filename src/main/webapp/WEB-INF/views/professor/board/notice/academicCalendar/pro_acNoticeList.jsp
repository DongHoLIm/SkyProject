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
<link href="resources/dist/css/datepicker.min.css" rel="stylesheet" type="text/css">
<script src="resources/dist/js/datepicker.min.js"></script>
<script src="resources/dist/js/i18n/datepicker.kr.js"></script>
<style>
	#basic {
		padding: 10px 0px 0px 100px;
	}
	
	#calArea {
		margin: 0 auto;
		width: 88.5%;		
	}
	
	#searchValue { 
		width: 100%
	}
	
	.acNoticeTitle:hover{
		color: black;
		font-weight: bold;
		cursor: pointer;
	}
	
	#writeBtn {
		align: right;
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
			<h4 id="basic">학사 일정</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			
			<form action="pro_searchacNotice.bo" method="get">
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
			<div id="calArea">
				<div style="margin-bottom: 10px; float:left">
					<div style="margin-bottom: 10px; float:left">
						<select id="searchDate" name="searchDate">
							<option value="clear">날짜별 일정검색</option>
							<option value="allDate">전체일정</option>
							<option value="Month">월간일정</option>
						</select>
					</div>
					<input type="hidden" name="monthflag" id="monthflag" value="true">
					<div id="allsearchBtn" style="margin-bottom: 10px; margin-left: 10px; float:left">
						<button onclick="searchAllDate()">검색</button>
					</div>
					<div id="monthSearch" style="margin-bottom: 10px; margin-left: 10px; float:left">
						<input id="mSearch" type="text" class="datepicker-here" data-language='kr' data-min-view="months" data-view="months" data-date-format="yyyy/MM" placeholder="날짜를 선택해주세요.">
					</div>
					<div id="msearchBtn" style="margin-bottom: 10px; margin-left: 10px; float:left">
						<button onclick="searchMonth()">검색</button>
					</div>
				</div>
					<c:if test="${sessionScope.loginUser.memberStatus == 3}">
						<div align="right" style="margin-bottom: 10px;">
							<input type="hidden" name="memberId" value="${sessionScope.loginUser.memberId}">
							<button id="writeBtn" onclick="insertacNotice()">글쓰기</button>
						</div>
					</c:if>
			</div>			
			<c:if test="${pi.searchflag == false and pi.monthflag == false}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
					<thead>
						<tr>
							<th width="7%" style="text-align: center">글번호</th>
							<th width="9%" style="text-align: center">시작일시</th>
							<th width="9%" style="text-align: center;">종료일시</th>
							<th width="45%" style="text-align: center;">제목</th>
							<th width="12%" style="text-align: center;">작성부서</th>
							<th width="9%" style="text-align: center;">작성자</th>
							<th width="7%" style="text-align: center;">조회수</th>
							<th width="9%" style="text-align: center;">게시기한</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${list}">
						<tr>
							<td style="text-align: center;">${b.boardNo}</td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.startDate}" var="startDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${startDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.endDate}" var="endDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${endDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;" class="acNoticeTitle"><c:out value="${b.title}"/></td>
							<td style="text-align: center;"><c:out value="${b.writeDept}"/></td>
							<td style="text-align: center;"><c:out value="${b.writer}"/></td>
							<td style="text-align: center;"><c:out value="${b.count}"/></td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd"/>
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
						<c:url var="blistBack" value="pro_acNoticeList.bo">
							<c:param name="currentPage" value="${pi.currentPage - 1}"/>
						</c:url>
						<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
						<c:if test="${p eq pi.currentPage}">
						    <li class="page-item"><a class="page-link">${p}</a></li>					
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<c:url var="blistCheck" value="pro_acNoticeList.bo">
								<c:param name="currentPage" value="${p}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="pro_acNoticeList.bo">
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
			
			<c:if test="${pi.searchflag == true and pi.monthflag == false}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
					<thead>
						<tr>
							<th width="7%" style="text-align: center">글번호</th>
							<th width="9%" style="text-align: center">시작일시</th>
							<th width="9%" style="text-align: center;">종료일시</th>
							<th width="45%" style="text-align: center;">제목</th>
							<th width="12%" style="text-align: center;">작성부서</th>
							<th width="9%" style="text-align: center;">작성자</th>
							<th width="7%" style="text-align: center;">조회수</th>
							<th width="9%" style="text-align: center;">게시기한</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${list}">
						<tr>
							<td style="text-align: center;">${b.boardNo}</td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.startDate}" var="startDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${startDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.endDate}" var="endDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${endDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;" class="acNoticeTitle"><c:out value="${b.title}"/></td>
							<td style="text-align: center;"><c:out value="${b.writeDept}"/></td>
							<td style="text-align: center;"><c:out value="${b.writer}"/></td>
							<td style="text-align: center;"><c:out value="${b.count}"/></td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd"/>
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
						<c:url var="blistBack" value="pro_searchacNotice.bo">
							<c:param name="searchCondition" value="${searchCondition}"/>																					
							<c:param name="searchValue" value="${searchValue}"/>
							<c:param name="currentPage" value="${pi.currentPage - 1}"/>
							<c:param name="searchflag" value="${pi.searchflag}"/>
						</c:url>
						<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
						<c:if test="${p eq pi.currentPage}">
						    <li class="page-item"><a class="page-link">${p}</a></li>					
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<c:url var="blistCheck" value="pro_searchacNotice.bo">
								<c:param name="searchCondition" value="${searchCondition}"/>													
								<c:param name="searchValue" value="${searchValue}"/>
								<c:param name="currentPage" value="${p}"/>	
								<c:param name="searchflag" value="${pi.searchflag}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="pro_searchacNotice.bo">
							<c:param name="searchCondition" value="${searchCondition}"/>														
							<c:param name="searchValue" value="${searchValue}"/>
							<c:param name="currentPage" value="${pi.currentPage + 1}"/>
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
			
			<c:if test="${pi.monthflag == true and pi.searchflag == false}">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
					<thead>
						<tr>
							<th width="7%" style="text-align: center">글번호</th>
							<th width="9%" style="text-align: center">시작일시</th>
							<th width="9%" style="text-align: center;">종료일시</th>
							<th width="45%" style="text-align: center;">제목</th>
							<th width="12%" style="text-align: center;">작성부서</th>
							<th width="9%" style="text-align: center;">작성자</th>
							<th width="7%" style="text-align: center;">조회수</th>
							<th width="9%" style="text-align: center;">게시기한</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${list}">
						<tr>
							<td style="text-align: center;">${b.boardNo}</td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.startDate}" var="startDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${startDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.endDate}" var="endDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${endDate}" pattern="yyyy/MM/dd"/>
							</td>
							<td style="text-align: center;" class="acNoticeTitle"><c:out value="${b.title}"/></td>
							<td style="text-align: center;"><c:out value="${b.writeDept}"/></td>
							<td style="text-align: center;"><c:out value="${b.writer}"/></td>
							<td style="text-align: center;"><c:out value="${b.count}"/></td>
							<td style="text-align: center;">
								<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd"/>
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
						<c:url var="blistBack" value="pro_acNoticeSearchMonth.bo">
							<c:param name="currentPage" value="${pi.currentPage - 1}"/>
							<c:param name="month" value="${month}"/>
							<c:param name="monthflag" value="${pi.monthflag}"/>
						</c:url>
						<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
						<c:if test="${p eq pi.currentPage}">
						    <li class="page-item"><a class="page-link">${p}</a></li>					
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<c:url var="blistCheck" value="pro_acNoticeSearchMonth.bo">
								<c:param name="currentPage" value="${p}"/>
								<c:param name="month" value="${month}"/>
								<c:param name="monthflag" value="${pi.monthflag}"/>
							</c:url>
							 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="pro_acNoticeSearchMonth.bo">
							<c:param name="currentPage" value="${pi.currentPage + 1}"/>
							<c:param name="month" value="${month}"/>
							<c:param name="monthflag" value="${pi.monthflag}"/>
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
		$("#monthSearch").hide();
		$("#msearchBtn").hide();
		$("#allsearchBtn").hide();
		
		$("#searchDate").change(function(){
			var searchDate = $(this).val();			
			
			if(searchDate == "allDate"){
				$("#monthSearch").hide();
				$("#msearchBtn").hide();
				$("#allsearchBtn").show();
			}else if(searchDate == "Month"){
				$("#monthSearch").show();
				$("#msearchBtn").show();
				$("#allsearchBtn").hide();
			}else if(searchDate == "clear"){
				$("#monthSearch").hide();
				$("#msearchBtn").hide();
				$("#allsearchBtn").hide();
			}
		});
		
		function searchAllDate(){
			location.href="pro_acNoticeList.bo";
		}
		
		function searchMonth(){
			var month = $("#mSearch").val();
			var monthflag = $("#monthflag").val();
			
			location.href="pro_acNoticeSearchMonth.bo?month=" + month + "&monthflag=" + monthflag;
		}
		
		$(function(){
			 $("#boardArea").find(".acNoticeTitle").click(function(){
				var boardNo = $(this).parents().children("td").eq(0).text(); 	
				
				console.log(boardNo);
				
				location.href = "pro_acNoticeDetail.bo?boardNo=" + boardNo;				
			 });
		});
		
		
	</script>
</body>
</html>
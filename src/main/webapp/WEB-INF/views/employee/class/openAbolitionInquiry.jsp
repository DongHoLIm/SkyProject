<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
	
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
			<h4>개설/폐지 조회</h4>
			<hr style="margin: 0 auto;">
			<br> <br>
			
			<br>
			<div style="float:right;">
				<a href="lectureAbolitionSelect.em">개설</a>/
				<a href="abolitionSelect.em">폐지</a>
			</div>
			<br>
			<table style="text-align: center; margin: 0 auto;">
				<thead>
					<tr>
						<th width="10%" style="text-align:center;">과목번호</th>
						<th width="20%" style="text-align:center;">과목명</th>
						<th width="10%" style="text-align:center;">학과</th>
						<th width="15%" style="text-align:center;">담당교수</th>
						<th width="20%" style="text-align:center;">강의실</th>
						<th width="30%" style="text-align:center;">개강년도/학기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="OpenSubject" items="${ list }">
						<tr>
							<td>
								<input type="hidden" name="openSubCode" value="<c:out value="${OpenSubject.openSubCode}" />">
								<c:out value="${OpenSubject.openSubCode}" />
							</td>
							<td><c:out value="${OpenSubject.subName}" /></td>
							<td><c:out value="${OpenSubject.sdeptName}" /></td>
							<td><c:out value="${OpenSubject.professorName}" /></td>
							<td><c:out value="${OpenSubject.buildingName}/${OpenSubject.roomName}" /></td>
							<td><c:out value="${OpenSubject.openYear}년도${OpenSubject.openSemester}학기" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br><br>
				<input type="hidden" id="currentPage" value="${pi.currentPage}">
			<div class="pagingArea">
			  <ul class="pagination" style="justify-content: center; cursor: pointer;">
				<c:if test="${pi.currentPage <= 1}">
			   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
				</c:if>
				<c:if test="${pi.currentPage > 1}">
					<c:url var="blistBack" value="lectureAbolitionSelect.em">
						<c:param name="currentPage" value="${pi.currentPage - 1}"/>
					</c:url>
					<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
				</c:if>
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:if test="${p eq pi.currentPage}">
					    <li class="page-item"><a class="page-link">${p}</a></li>					
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="blistCheck" value="lectureAbolitionSelect.em">
							<c:param name="currentPage" value="${p}"/>
						</c:url>
						 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<c:url var="blistEnd" value="lectureAbolitionSelect.em">
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
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
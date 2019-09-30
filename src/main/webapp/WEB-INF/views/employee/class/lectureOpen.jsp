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
<style>
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h4>강의개설등록</h4>
				<hr style="margin: 0 auto;">
				<br> <br>
				
				<form action="goLectureRegistration.em" method="post">
					<table class="" style="margin: 0 auto;">
						<thead>
							<tr>
								<th width="10%" style="text-align: center;">과목번호</th>
								<th width="20%" style="text-align: center;">과목명</th>
								<th width="15%" style="text-align: center;">학과명</th>
								<th width="15%" style="text-align: center;">이수구분</th>
								<th width="15%" style="text-align: center;">인정학점</th>
								<th width="20%" style="text-align: center;">개설일자</th>
								<th style="text-align: center;">강의등록</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="LectureOpen" items="${ subjectList }">
								
								<tr>
									<td style="text-align: center;">
										<input type="hidden" name="subCode" class="subCode" value="<c:out value="${ LectureOpen.subCode }" />"readonly>
										<c:out value="${ LectureOpen.subCode }" />
									</td>
									<td style="text-align: center;">
										<input type="hidden" name="subName" id="subName" value="<c:out value="${ LectureOpen.subName }" />"readonly>
										<c:out value="${ LectureOpen.subName }" />
									</td>
									<td style="text-align: center;">
										<input type="hidden" name="sdeptName" value="<c:out value="${ LectureOpen.sdeptName }" />"readonly>
										<c:out value="${ LectureOpen.sdeptName }" />
									</td>
									<td style="text-align: center;">
										<input type="hidden" name="completeType" value="<c:out value="${ LectureOpen.completeType }" />"readonly>
										<c:out value="${ LectureOpen.completeType }" />
									</td>
									<td style="text-align: center;">
										<input type="hidden" name="subGrade" value="<c:out value="${ LectureOpen.subGrade }" />"readonly>
										<c:out value="${ LectureOpen.subGrade }" />
									</td>
									<td style="text-align: center;">
										<fmt:parseDate value="${LectureOpen.madeDate}" var="madeDate" pattern="yyyy-MM-dd HH:mm:ss"/>
										<fmt:formatDate value="${madeDate}" pattern="yyyy/MM/dd"/>
									</td>
									<td style="text-align: center;"><button type="button" class="submitBtn">등록</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>	
				<br><br>
				<input type="hidden" id="currentPage" value="${pi.currentPage}">
			<div class="pagingArea">
			  <ul class="pagination" style="justify-content: center; cursor: pointer;">
				<c:if test="${pi.currentPage <= 1}">
			   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
				</c:if>
				<c:if test="${pi.currentPage > 1}">
					<c:url var="blistBack" value="lectureOpen.em">
						<c:param name="currentPage" value="${pi.currentPage - 1}"/>
					</c:url>
					<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
				</c:if>
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:if test="${p eq pi.currentPage}">
					    <li class="page-item"><a class="page-link">${p}</a></li>					
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="blistCheck" value="lectureOpen.em">
							<c:param name="currentPage" value="${p}"/>
						</c:url>
						 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<c:url var="blistEnd" value="lectureOpen.em">
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
				<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
			</div>
	</div>
	<script>
		/* function lectureRegistration(subCode){

			console.log(subCode);
			
			$.ajax({
				url:"lectureRegistration.em",
				type:"post",
				data:{subCode:subCode},
				success:function(data){
					
					var obj = JSON.parse(data);
					console.log(lecture);
					location.href="goLectureRegistration.em?lectureOpen="+encodeURI(obj);
					
				},
				error:function(err){
					console.log("실패!");
				}
			});
			return false;
		} */
		
		$(function(){
			$(".submitBtn").click(function(){
				var $subCode = $(this).parent().siblings().eq(0).children().val();
				
				location.href="lectureRegistration.em?subCode="+$subCode;
			})
		})
	</script>
</body>
</html>
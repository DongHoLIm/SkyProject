<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="resources/dist/css/datepicker.min.css" rel="stylesheet" type="text/css">
<script src="resources/dist/js/datepicker.min.js"></script>
<script src="resources/dist/js/i18n/datepicker.kr.js"></script>
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
	#txtDate { 
		margin:2px 2px; 
		height:15px; 
		width:75px;
		vertical-align:center
	}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">교내외행사</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<form action="em_searchMyBoardUpdateEvent.bo" method="post" enctype="multipart/form-data">
				<input type="hidden" name="boardNo" value="${b.boardNo}">
				<input type="hidden" name="memberId" id="memberId" value="${b.memberId}">
				<table style="width: 88.5%; margin: 0 auto;">
					<tr>
						<th style="text-align: center;">카테고리</th>
						<td>일반공지</td>
						<th style="text-align: center;">작성자</th>
						<td><input type="text" name="writer" value="${b.writer}" readonly></td>
						<th style="text-align: center;">작성부서</th>
						<td style="border-right: 1px solid #E5E6E7"><input type="text" name="writeDept" value="${b.writeDept}" readonly></td>
					</tr>
					<tr>
						<th style="text-align: center;">시작일시</th>
						<td width="100px;">
							<fmt:parseDate value="${b.startDate}" var="startDate" pattern="yyyy-MM-dd HH:mm:ss"/>
							<input type='text' class='datepicker-here' data-language='kr' id="dateInput" name="startDate" value="<fmt:formatDate value="${startDate}" pattern="yyyy/MM/dd"/>"/>
						</td>
						<th style="text-align: center;">종료일시</th>
						<td width="100px;">
							<fmt:parseDate value="${b.endDate}" var="endDate" pattern="yyyy-MM-dd HH:mm:ss"/>
							<input type='text' class='datepicker-here' data-language='kr' id="dateInput" name="endDate" value="<fmt:formatDate value="${endDate}" pattern="yyyy/MM/dd"/>"/>
						</td>
						<th style="text-align: center;">게시기한</th>
						<td width="100px;">
							<fmt:parseDate value="${b.deadLine}" var="deadLine" pattern="yyyy-MM-dd HH:mm:ss"/>
							<input type='text' class='datepicker-here' data-language='kr' id="deadLine" name="deadLine" value="<fmt:formatDate value="${deadLine}" pattern="yyyy/MM/dd"/>"/>
						</td>											
					</tr>
					<tr>
						<th style="text-align: center;">제목</th>
						<td colspan="6" style="border-right: 1px solid #E5E6E7">
							<input type="text" name="title" value="${b.title}">
						</td>	
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;">내용</th>
						<td colspan="6" style="text-align: left; height: 100px; border-right: 1px solid #E5E6E7;">
							<textarea name="content" rows="13" cols="40" style="resize: none;">${b.content}</textarea>
						</td>
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;">파일 첨부</th>
						<td colspan="5" style="border-right: 1px solid #E5E6E7">
							<c:if test="${!empty uf}">
								<div align="left">
									<img style="cursor: pointer;" id="Img" width="120" height="120" src="${uf.path}">
									<input type="file" name="photo" id="photo1" onchange="loadImg(this, 1)">
								</div>
							</c:if>
							<c:if test="${empty uf}">
								<div align="left">
									<input type="file" name="photo">							
								</div>
							</c:if>
						</td>
					</tr>
				</table>
				<div align="center" style="margin-top: 2%;">
					<button type="reset" onclick="updateCancel()">취소</button>
					&nbsp;&nbsp;&nbsp;
					<button type="submit">수정</button>
				</div>
			</form>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>
	<script>
		function updateCancel(){
			alert("수정을 취소 하시겠습니까?");
			
			var boardNo = ${b.boardNo};
			
			location.href = "em_searchMyBoardDetailEvent.bo?boardNo=" + boardNo;
		}
		
		$(function(){
			$("#photo1").hide();
			
			$("#Img").click(function(){
				$("#photo1").click();
			});
		});
		
		function loadImg(value, num){
			if(value.files && value.files[0]){
				var reader = new FileReader();
				
				reader.onload = function(e) {
					switch(num){
						case 1: $("#Img").attr("src", e.target.result); break; 
					}
				}
				reader.readAsDataURL(value.files[0]);
			}
		}
		
		
		
	</script>
</body>
</html>
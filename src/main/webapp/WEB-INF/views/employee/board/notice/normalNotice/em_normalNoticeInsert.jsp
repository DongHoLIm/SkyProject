<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	#dateInput {
		width: 100px;
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
			<form action="em_nNoticeInsert.bo?memberId=${sessionScope.loginUser.memberId}&writer=${writerInfo.memberName}&writeDept=${writerInfo.edeptName}" method="post" enctype="multipart/form-data">
				<table style="width: 88.5%; margin: 0 auto;">
					<tr>
						<th style="text-align: center;">카테고리</th>
						<td>일반공지</td>
						<th style="text-align: center;">작성자</th>
						<td><c:out value="${writerInfo.memberName}"/></td>
						<th style="text-align: center;">작성부서</th>
						<td style="border-right: 1px solid #E5E6E7"><c:out value="${writerInfo.edeptName}"/></td>
					</tr>
					<tr>
						<th style="text-align: center;">게시기한</th>
						<td width="100px;">
							<input type='text' class='datepicker-here' data-language='kr' id="dateInput" name="deadLine"/>
						</td>
						<th style="text-align: center;">제목</th>
						<td colspan="3" style="border-right: 1px solid #E5E6E7">
							<input type="text" name="title">
						</td>					
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;">내용</th>
						<td colspan="6" style="text-align: left; height: 100px; border-right: 1px solid #E5E6E7;">
							<textarea name="content" rows="13" cols="40" style="resize: none;"></textarea>
						</td>
					</tr>
					<tr>
						<th style="text-align: center;">파일 첨부</th>
						<td colspan="5" style="border-right: 1px solid #E5E6E7">
							<input type="file" name="photo">
						</td>
					</tr>
				</table>
				<div align="center" style="margin-top: 2%;">
					<button type="reset" onclick="writeCancel()">취소</button>
					&nbsp;&nbsp;&nbsp;
					<button type="submit">글쓰기</button>
				</div>
			</form>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>
	<script>
		function writeCancel(){
			location.href = "em_nNoticeList.bo";
		}
		
	</script>
</body>
</html>
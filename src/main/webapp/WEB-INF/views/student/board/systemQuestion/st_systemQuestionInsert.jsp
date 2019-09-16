<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h4 id="basic">시스템 문의</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			<form action="st_SystemQuestionInsert.bo?memberId=${writerInfo.memberId}&questionWriter=${writerInfo.memberName}" method="post" enctype="multipart/form-data">
				<table style="width: 88.5%; margin: 0 auto;">
					<tr>
						<th style="text-align: center;">문의구분</th>
						<td>
							<select id="questionType" name="questionType">
								<option value="계정 관련">계정 관련</option>
								<option value="제증명 관련">제증명 관련</option>
								<option value="학사 관련">학사 관련</option>
							</select>
						</td>
						<th style="text-align: center;">제목</th>
						<td colspan="4" style="border-right: 1px solid #E5E6E7">
							<input type="text" name="questionTitle">
						</td>
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;">내용</th>
						<td colspan="6" style="text-align: left; height: 100px; border-right: 1px solid #E5E6E7;">
							<textarea name="questionContent" rows="13" cols="40" style="resize: none;"></textarea>
						</td>
					</tr>
					<tr>
						<th style="text-align: center;">파일 첨부</th>
						<td colspan="5" style="border-right: 1px solid #E5E6E7">
							<div align="left">
								<input type="file" name="photo">
							</div>
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
			<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
		</div>
	</div>
	<script>
	function writeCancel(){
		alert("게시글 작성을 취소하시겠습니까?");
		
		location.href = "st_systemQuestionList.bo";	
	</script>
</body>
</html>
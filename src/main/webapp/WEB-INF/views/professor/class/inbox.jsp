
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
function messageSendOpen(){
	console.log("123");
	window.open("/finalProject/message.pro", "쪽지보내기", width="700px", height="500px");
};
function sendMessageListOpen(){
	window.open("/finalProject/outbox.pro", "보낸쪽지함", width="700px", height="500px");
};
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	margin: auto;
	padding: 40px;
}

#note1 {
	width: 700PX;
	text-align: center;
	display: inline-block;
	height: 100px;
}

body {
    text-align: center;
	background: beige;
}

td.td1 {
	text-align: right;
}

td {
	padding: 5px;
}

#note2 {
	background: #fff;
	padding: 20px;
	border: 1px solid black;
	width: 700px;
	margin-right: auto;
	margin-left: auto;
}

label {
	font-weight: bold;
}

h4 {
	text-align: left;
	font-size: large;
}


.btn-secondary:hover {
	color: #fff;
    background-color: #5a6268;
    border-color: #545b62;
    background: #5a6268;
}

.btn-secondary {
	background: #5a6268;
	color: #fff;
 	text-align: le
}



</style>
</head>
<body>

	<div class="note" id="note1">
		<h4>받은 쪽지함</h4>
		<hr>
	</div>

	<form action="" method="">
		<div class="note" id="note2">

			<table class="Inbox">
				<tr>
					<td><input onclick="sendMessageListOpen();" class="btn btn-secondary" type="button" value="보낸쪽지함"></td>
				</tr>
			</table>
			<table class="table table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"><input type="checkbox"></th>
						<th style="text-align: center;">No</th>
						<th style="text-align: center;">제목</th>
						<th style="text-align: center;">발신인</th>
						<th style="text-align: center;">받은날짜</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="message" items="${messageList }">
					<tr>
						<td><input type="checkbox"></td>
						<td>${ message.messageCode }</td>
						<td>${ message.messageTitle }</td>
						<td>${ message.memberId}</td>
						<td>${ message.receDate}</td>
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
					<c:url var="blistBack" value="inbox.pro">
						<c:param name="currentPage" value="${pi.currentPage - 1}"/>
					</c:url>
					<li class="page-item"><a class="page-link" href="${blistBack}">이전</a></li>	
				</c:if>
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:if test="${p eq pi.currentPage}">
					    <li class="page-item"><a class="page-link">${p}</a></li>					
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="blistCheck" value="inbox.pro">
							<c:param name="currentPage" value="${p}"/>
						</c:url>
						 <li class="page-item"><a class="page-link" href="${blistCheck}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<c:url var="blistEnd" value="inbox.pro">
						<c:param name="currentPage" value="${pi.currentPage + 1}"/>
					</c:url>
			    	<li class="page-item"><a class="page-link" href="${blistEnd}">다음</a></li>				
				</c:if>
				<c:if test="${pi.currentPage >= pi.maxPage}">
					<li class="page-item"><a class="page-link">다음</a></li>	
				</c:if>
			 </ul>
				</div>
			<table class="outbox">
				<tr>
					<td><input type="button" value="선택삭제" class="btn btn-secondary"></td>
					<td><a href="#" onclick="messageSendOpen();"><input type="button" value="쪽지보내기" class="btn btn-secondary"></a></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>
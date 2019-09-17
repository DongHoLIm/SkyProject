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
<script type="text/javascript">

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

}
</style>
</head>
<body>

	<div class="note" id="note1">
		<h4>보낸 쪽지함</h4>
		<hr>
	</div>

	<form action="" method="">
		<div class="note" id="note2">

		
			<table class="table table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"><input type="checkbox"></th>
						<th style="text-align: center;">No</th>
						<th style="text-align: center;">제목</th>
						<th style="text-align: center;">수신인</th>
						<th style="text-align: center;">보낸날짜</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="message" items="${sendMessageList }">
					<tr>
						<td><input type="checkbox"></td>
						<td>${ message.messageCode }</td>
						<td>${ message.messageTitle }</td>
						<td>${ message.receMember}</td>
						<td>${ message.sendDate}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<table class="outbox">
				<tr>
					<td><input type="button" value="선택삭제" class="btn btn-secondary"></td>
					<td><input type="button" value="받은쪽지함" class="btn btn-secondary"></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>
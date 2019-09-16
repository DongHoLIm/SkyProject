<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	margin: auto;
	padding: 40px;
}

h3 {
	text-align: center;
}

h5 {
	text-align: center;
}

#note1 {
	width: 700PX;
	text-align: center;
	display: inline-block;
	height: 100px;
}

body {
	text-align: center;
}

td.td1 {
	text-align: right;
}

td {
	padding: 5px;
}

#note2 {
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

.form-control {
	border-radius:
}

.Inbox {
	
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
					<td><input type="button" value="보낸쪽지함"></td>
				</tr>
			</table>
			<table class="table table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"><input type="checkbox"></th>
						<th style="text-align: center;">No</th>
						<th style="text-align: center;">제목</th>
						<th style="text-align: center;">발신인</th>
						<th style="text-align: center;">수신인</th>
						<th style="text-align: center;">보낸날짜</th>
						<th style="text-align: center;">수신날짜</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox"></td>
						<td>1</td>
						<td>기말고사</td>
						<td>김현수</td>
						<td>강인우</td>
						<td>2019.09.18</td>
						<td>2019.09.20</td>

					</tr>
				</tbody>
			</table>
			<table class="outbox">
				<tr>
					<td><input type="button" value="선택삭제"></td>
					<td><a href="message.pro"><input type="button" value="쪽지보내기"></a></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>
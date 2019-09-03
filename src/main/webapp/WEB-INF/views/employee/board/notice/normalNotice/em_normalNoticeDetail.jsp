<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<table style="width: 88.5%; margin: 0 auto;">
				<tr>
					<th style="text-align: center;">작성자</th>
					<td>${b.writer}</td>
					<th style="text-align: center;">작성부서</th>
					<td>${b.writeDept}</td>
					<th style="text-align: center;">게시기한</th>
					<td>${b.deadLine}</td>
				</tr>
				<tr>
					<th style="text-align: center;">제목</th>
					<td colspan="3">${b.title}</td>
					<th style="text-align: center;">조회수</th>
					<td>${b.count}</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left; height: 100px;">
						${b.content}
					</td>
				</tr>
				<tr>
					<td colspan="6"><button onclick="em_nNoticeList()">목록으로</button>
				</tr>
			</table>
		</div>
		<div>
		<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
	</div>
	<script>
		function em_nNoticeList(){
			location.href="em_nNoticeList.bo";
		}
	</script>
</div>
</body>
</html>
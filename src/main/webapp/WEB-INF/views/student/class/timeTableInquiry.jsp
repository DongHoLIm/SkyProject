<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({
		url:"timeTableInquiry.st",
		type:"post",
		success:function(data){
			var list = new Array();
			for(var i=0;i<data.list.length;i++){
				list[i] = data.list[i];
			}
			for(var i=0;i<list.length;i++){
				console.log(list[i].dayInfo);
				console.log(list[i].timeInfo);
				
			}
			var tr = $('#tr').text();
			var td1 = $('#td1').text();
			console.log(td1);
			console.log(tr);
			
		},
		error:function(err){
			console.log("실패!");
		}
	});
});

</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>시간표조회</h2>
				<hr style="margin: 0 auto;">
				<br> <br>

				<table cellspacing="5" align="center" style="border:1;
					bordercolor:#5CD1E5; width:550; height:600; font-color:black;">
					<tr align="center" id="tr">
						<td width="50"></td>
						<td width="100" bgcolor="#5CD1E5" id="mon">월</td>
						<td width="100" bgcolor="#5CD1E5" id="tue">화</td>
						<td width="100" bgcolor="#5CD1E5" id="wed">수</td>
						<td width="100" bgcolor="#5CD1E5" id="thu">목</td>
						<td width="100" bgcolor="#5CD1E5" id="fir">금</td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td1">1</td>
						<td ></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td2">2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td3">3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td4">4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center" >
						<td bgcolor="#5CD1E5" id="td5">5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td6">6</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td7">7</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr align="center">
						<td bgcolor="#5CD1E5" id="td8">8</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

				</table>
				<br>
				<br>
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>
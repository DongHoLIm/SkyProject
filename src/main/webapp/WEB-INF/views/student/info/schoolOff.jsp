<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title> 
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="resources/dist/css/datepicker.min.css" rel="stylesheet" type="text/css">
<script src="resources/dist/js/datepicker.min.js"></script>
<script src="resources/dist/js/i18n/datepicker.kr.js"></script>

<style>
#basic {
	padding: 10px 0px 0px 100px;
}

table.basicinfo td {
	background: #FFF;
}

.td {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	
	}
	
.tdd {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	width:15%;
	}

table.basicinfo {
	width: 85%;
	border: 1px solid #dde1e3;
	margin-left: auto;
	margin-right: auto;
}

#Change {
	text-align: center;
	border: 1px solid #dde1e3;
}

.notice {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	width: 30%;
}

#t1 {
	background: #c7c5b7;
	border: 1px solid #b3afafb3;
}

.tbody {
	text-align: center;
}
#modified {
	margin-left: 80%;
}
</style>


</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>

			<jsp:include page="../info/common.jsp" />

			

			
				<h4 id="basic">휴학 신청</h4>
				<form action="st_schoolOffApply.si" method="post">
				<table class="basicinfo">
				<tr>
					<td class="tdd">휴학 구분</td>
					<td width="35%">
					<select id="offType" name="offType">
							<option value='선택'>-- 선택 --</option>
							<option value='일반휴학'>일반휴학</option>
							<option value='군휴학'>군휴학</option>
					</select>
					</td>

					<td class="tdd">휴학 사유</td>
					<td>
					<select id="offReason" name="offReason">
							<option value='선택'>-- 선택 --</option>
							<option value='개인사정'>개인 사정</option>
							<option value='경제사정'>경제 사정</option>
							<option value='경제사정'>군입대</option>
					</select>
					</td>
				</tr>
				

				<tr>
					<td class="tdd">휴학신청 학기</td>
					<td>
						<input type="text" id="offStart" name="offStart" value="${start }" readonly>
					</td>
					
					<td class="tdd">희망 휴학 기간</td>
					<td>
					<select id="offTerm" name="offTerm">
							<option value='선택'>-- 선택 --</option>
							<option value='1'>1</option>
							<option value='2'>2</option>
					</select>
					</td>

					
				</tr>
					
				<tr>
					<td class="tdd">휴학기간</td>
					<td>
						<input type="text" id="offTermT" name="offTermT" value=" " readonly>
					</td>
					
					<td class="tdd">복학 예정</td>
					<td>
						<input type="text" id="returnDate" name="returnDate" value=" " readonly>
					</td>	
				
				</tr>

				<tr>
					<td class="tdd">입대 일자</td>
					<td>
						<input type='text' id="enlistmentDate" name="enlistmentDate" class='datepicker-here' data-language='kr' id="datepicker1" name="startDate" value=""/>	
					</td>

					<td class="tdd">전역 예정</td>
					<td>
						<input type='text' id="demobilizationDate" name="demobilizationDate" class='datepicker-here' data-language='kr' id="datepicker2" name="ENDDate" value=""/>
					</td>
				</tr>
				
				<tr>
					<td class="tdd">제출 서류</td>
					<td colspan="3" style="border: solid 1px; color: #dde1e3;">
						<input type="text" id="requiredDoc" name="requiredDoc" value="">
					</td>	
				</tr>
			
			<table id="modified">
				<button type="submit" id="modified">신청하기</button> 
			</table>
			</table>

			</form>
				
			<br>
			<br>
			
			<h4 id="basic">신청 내역</h4>
			<table class="basicinfo">
				<thead>
					<tr>
						<th style="text-align: center" id="t1">순번</th>
						<th style="text-align: center" id="t1">휴학 구분</th>
						<th style="text-align: center" id="t1">휴학 사유</th>
						<th style="text-align: center" id="t1">휴학 기간</th>
						<th style="text-align: center" id="t1">복학예정</th>
						<th style="text-align: center" id="t1">신청일</th>
						<th style="text-align: center" id="t1">상태</th>
					</tr>
				<thead>
				<tbody class="tbody">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<script>
			$(function(){
				$("#offTerm").change(function(){
					var change = $(this).val();
					console.log("change::"+change);
					
					var offTerm = $("#offTerm").val();
					console.log("offTerm::" + offTerm);
					
					var start = $("#offStart").val();
					console.log("start::"+start);
					
					$.ajax({
						url:"st_selectOffTerm.si",
						type:"get",
						data:{offTerm:offTerm,
							  start:start},
						success:function(data){
							console.log("접속성공");
							console.log("offTerm::" + offTerm);
							console.log("start::" + start);
							console.log("offTermm::" + data.offTermm);
							console.log("returnDay::" + data.returnDay);
							
							var $input1 = $("#offTermT");
							var $input2 = $("#returnDate");
							
							$input1.val(data.offTermm);
							$input2.val(data.returnDay);
							
							
						}
					})
					
				});
			});
			
			
			</script>
			

		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>



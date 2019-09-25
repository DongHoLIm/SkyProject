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

table.basicinfo td {
	background: #FFF;
}

td.td {
	text-align: center;
	background: #c7c5b7 !important;
	color: black;
	width: 100px !important;
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



</style>

</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
				
				<jsp:include page="../info/common.jsp" />

						<h4 id="basic">복학 신청</h4>
					
						<table class="basicinfo">
							<tr>
								<td class="td">복학구분</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>2019-09-12</option>
										<option value='' disabled>경제 사정</option>
										<option value='' label=''></option>
								</select></td>
					
								<td class="td">복학일자</td>
             				     <td><input type="text" value="" ></td>
							</tr>
							
							<tr>
								 <td class="td">복학학년</td>
             				     <td><input type="text" value="" ></td>
								 <td class="td">변동 적용일</td>
             				     <td><input type="text" value="" >
             				     </td>
             				 
							</tr>
							   				
					</table>
             			<input type="button" value="신청하기" id="modified" style="float: right; margin-right: 50px;">
					
							
						
						
						<br><br>
						<table class="basicinfo">
						<h4 id="basic">신청 내역</h4>
						<thead>
							<tr>
								<th style="text-align: center" id="t1">순번</th>
								<th style="text-align: center" id="t1">복학 구분</th>
								<th style="text-align: center" id="t1">복학 일자</th>
								<th style="text-align: center" id="t1">복학 학년</th>
								<th style="text-align: center" id="t1">변동 적용일</th>
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
							
							</tr>
							</tbody>
						</table>
					
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
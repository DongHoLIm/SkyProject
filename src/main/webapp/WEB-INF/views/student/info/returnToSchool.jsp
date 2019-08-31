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

			<h4 id="basic">기본 정보</h4>
			<form class="ba">
				<table class="basicinfo">
					<tr>
						<td class="td">학번</td>
						<td colspan='5'><input type="text" value="123456789" readonly></td>
					</tr>

					<tr>
						<td class="td">한글 성명</td>
						<td><input type="text" value="홍길동" readonly></td>
						<td class="td">영문 성명</td>
						<td><input type="text" value="In Woo Kang" readonly></td>
						<td class="td">한문 성명</td>
						<td><input type="text" value="姜因遇" readonly></td>
					</tr>

					<tr>
						<td class="td">주민 번호</td>
						<td><input type="text" value="940205-*******" readonly></td>
						<td class="td">생년월일</td>
						<td><input type="text" value="2000.07.26" readonly></td>
						<td class="td">성별</td>
						<td><input type="text" value="남" readonly></td>
					</tr>

					<tr>
						<td class="td">학부(과)</td>
						<td><input type="text" value="소프트웨어 응용" readonly></td>
						<td class="td">전공</td>
						<td><input type="text" value="컴퓨터 공학" readonly></td>
						<td class="td">학년</td>
						<td><input type="text" value="1" readonly></td>
					</tr>

					<tr>
						<td class="td">학적 상태</td>
						<td><input type="text" value="재학" readonly></td>
						<td class="td">주야</td>
						<td><input type="text" value="주간" readonly></td>
						<td class="td">병역 구분</td>
						<td><input type="text" value="" readonly></td>
					</tr>



					<table>
						<tr>
							<td
								style="text-align: center; border: 1px solid #FFF; background: #FFF;">
								<button type="button" class="btn btn-primary">휴학 신청</button>
								<button type="button" class="btn btn-primary">복학 신청</button>
								<button type="button" class="btn btn-primary">휴학 취소</button>
								<button type="button" class="btn btn-primary">복학 취소</button>
							</td>
						</tr>
					</table>

					<table class="basicinfo">
						<h4 id="basic">휴학 신청</h4>
						<tr>
							<td class="notice">공지사항</td>
							<td><input type="text" value="" readonly></td>
						</tr>
						</table>

						<table class="basicinfo">
					
							<tr>
								<td class="td">휴학 구분</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>일반휴학</option>
										<option value='' selected>군휴학</option>

								</select></td>

								<td class="td">휴학 사유</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>개인 사정</option>
										<option value='' disabled>경제 사정</option>
										<option value='' label=''></option>
								</select></td>
							</tr>

							<tr>
								<td class="td">희망 휴학<br>기간</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>2019-09-12</option>
										<option value='' disabled>경제 사정</option>
										<option value='' label=''></option>
								</select></td>

								<td class="td">복학 예정</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>2020-10-12</option>
										<option value='' disabled>경제 사정</option>
										<option value='' label=''></option>
								</select></td>
							</tr>
							
							<tr>
								<td class="td">입대 일자</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>2019-09-12</option>
										<option value='' disabled>경제 사정</option>
										<option value='' label=''></option>
								</select></td>

								<td class="td">전역 예정</td>
								<td><select name='mulitple'>
										<option value=''>-- 선택 --</option>
										<option value='' selected>2020-10-12</option>
										<option value='' disabled>경제 사정</option>
										<option value='' label=''></option>
								</select></td>
							</tr>
							
							<tr>
								 <td class="td">연락처</td>
             				     <td><input type="text" value="" ></td>
								 <td class="td">주소</td>
             				     <td><input type="text" value="" >
             				     </td>
             				 
							</tr>
							
							<tr>
								 <td class="td">제출 서류</td>
             				 	 <td style="border: solid 1px; color:#dde1e3; "><input type="text" value="" ></td>
							</tr>
						             				
					</table>
							
             				         <input type="button" value="신청하기" id="modified"
                  					style="float: right; margin-right: 50px;">
					
							
						
						
						<br><br>
						<table class="basicinfo">
						<h4 id="basic">신청 내역</h4>
						<thead>
							<tr>
								<th style="text-align: center" id="t1">순번</th>
								<th style="text-align: center" id="t1">휴학 구분</th>
								<th style="text-align: center" id="t1">휴학 사유</th>
								<th style="text-align: center" id="t1">휴학 기간</th>
								<th style="text-align: center" id="t1">휴학 학기수</th>
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
						
				</table>
			</form>


		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
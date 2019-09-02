<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	font-family: "돋움", "돋움체";
	font-size: 12px;
	color: #666666;
	text-decoration: none;
}
/*검색 테이블*/
table.tableList1 {
	table-layout: fixed;
	border-top: 1px #C0C0C0 solid;
	border-bottom: 1px #C0C0C0 solid;
	border-left: 1px #C0C0C0 solid;
	border-right: 1px #C0C0C0 solid;
}

table.tableList1 th, table.tableList1 td {
	padding: 7px 3px 3px 3px;
	font-size: 9pt;
}
/* table.tableList1 th {
		border-right:1px #F3D7D7 solid;
		border-bottom:1px #CFCFCF solid;
		color:#000000;
		background:#E3F2FF;
	} */
table.tableList1 td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList1 td.dot {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList1 td.left {
	text-align: left;
}

table.tableList1 td.right {
	text-align: right;
}

table.tableList1 td img {
	vertical-align: middle;
}

table.tableList1 th.end, table.tableList2 td.end {
	border-right: none
}
/*조회 테이블*/
table.tableList2 {
	table-layout: fixed;
	border-top: 2px #A6D9DC solid;
	border-bottom: 1px #CFCFCF solid;
}

table.tableList2 tr.even {
	background: #FFFFEA;
} /* CSS2 나 CSS3 에 even 은 없다 */
table.tableList2 tr:hover {
	background: #FCEFEF;
} /* 마우스 커서가 올려진 경우라서 모바일에선 무용. :focus 가 아님에 유의 */
table.tableList2 th, table.tableList2 td {
	padding: 7px 3px 3px 3px;
	text-align: center;
	font-size: 9pt;
}

table.tableList2 th {
	border-right: 1px #F3D7D7 solid;
	border-bottom: 1px #CFCFCF solid;
	color: #000000;
	background: #E3F2FF;
}

table.tableList2 th.end, table.tableList2 td.end {
	border-right: none;
}

table.tableList2 td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList2 td.dot {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList2 td.left {
	text-align: left;
}

table.tableList2 td.right {
	text-align: right;
}

table.tableList2 td img {
	vertical-align: middle;
}
#menu ul, #menu ul li, #menu ul li a {
	padding: 0;
	margin: 0;
	line-height: 1;
	font-family: '돋움', '돋움체';
}

#munu {
	width: auto;
	zoom: 1;
	height: 49px;
	background: #cecdce;
	border-radius: 2px;
}

#menu ul {
	background: black;
	height: 49px;
	padding-top: 0px;
}

#menu ul li {
	float: left;
	list-style: none;
	padding: 0 0px;
}

#menu ul li a {
	display: block;
	height: 35px;
	padding: 15px 30px 0;
	border-radius: 2px 2px 0 0;
	text-decoration: none;
	font-size: 14px;
	color: white;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);
	font-weight: bold;
	opacity: .9;
}

#menu ul li:first-child a {
	margin: 0px 2px 0 0;
}

#menu ul li a:hover, #menu ul li.active a {
	background: darkgray;
	display: block;
	height: 49;
	margin-top: 0px;
	padding-top: 15px;
	color: #000000;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.55);
	opacity: 1;
}
</style>
</head>
<body>
	<div id="menu" class="menu">
		<ul>
			<li style="width: 23.0%; text-align: center;" class=""><a
				href="goNotice.st">공지사항</a></li>
			<li style="width: 23.0%; text-align: center;" class=""><a
				href="goCourseInquiry.st">교과목조회</a></li>
			<li style="width: 23.0%; text-align: center;" class="active"><a
				href="goPreliminaryCourse.st">예비수강신청목록</a></li>
			<li style="width: 23.0%; text-align: center;" class=""><a
				href="goCourseApply.st">수강신청</a></li>
		</ul>
	</div>
	<table class="tableList1" width="100%">
		<tbody>
			<tr id="choice">
				<td>
					<span> &nbsp;&nbsp;
						<b>이름 : </b>
						<input type="text" value="" readonly style="width:5%;">
					</span> 
					<span id="choice1" name="choice1">
						<span>
							<strong>학과 : </strong>
							<input type="text" value="" readonly>						
						</span>
					</span>
					<span>
						<span>
							<strong>학년 : </strong>
							<input type="text" value="" readonly style="width:5%;">
						</span>
					</span>
				</td>
				<td>
					<span>
						<strong>이수구분</strong>
						<select name="allIsu" id="allIsu" class="Layer1">
								<option value="">* 전체 *</option>
								<option value="">교필</option>
								<option value="">교선</option>
								<option value="">평생</option>
						</select>
					</span>
					<button type="submit" style="background: red;">조회</button>
					<button type="submit" style="background: red;">수강신청</button></td>
			</tr>
		</tbody>
	</table>
	<table class="tableList2" style="width: 100%">
		<tbody>
			<tr>
				<th width="35"><input type="checkbox" class="Allcheck"></th>
				<th width="35">No</th>
				<th width="45">학년</th>
				<th width="60">이수구분</th>
				<th width="80">학수번호</th>
				<th width="180">교과목명</th>
				<th width="40">학점</th>
				<th width="70">교수</th>
				<th>교시</th>
				<th>강의실(건물명)</th>
				<th width="60">인원</th>
				<th width="50">계획서</th>
				<th width="50">강의평가</th>
				<th>비고</th>
			</tr>
			<tr>
				
			</tr>
		</tbody>
	</table>
</body>
</html>
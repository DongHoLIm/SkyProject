<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	<style>
body {
	font-family: 돋움;
	font: 12px "Trebuchet MS", sans-serif;
}
/*일반 텍스트*/
table {
	font-family: "돋움", "돋움체";
	font-size: 12px;
	color: #666666;
	text-decoration: none;
}

table.tableList {
	table-layout: fixed;
	border-top: 2px #A6D9DC solid;
	border-bottom: 1px #CFCFCF solid;
}

table.tableList tr.even {
	background: #FFFFEA
} /* CSS2 나 CSS3 에 even 은 없다 */
table.tableList tr:hover {
	background: #E3F2FF
} /* 마우스 커서가 올려진 경우라서 모바일에선 무용. :focus 가 아님에 유의 */
table.tableList th, table.tableList td {
	padding: 7px 3px 3px 3px;
	text-align: center;
	font-size: 9pt;
}

table.tableList th {
	border-right: 1px #F3D7D7 solid;
	border-bottom: 1px #CFCFCF solid;
	color: #000000;
	background: #FCEFEF;
}

table.tableList th.end, table.tableList td.end {
	border-right: none
}

table.tableList td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList td.dot {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList td.left {
	text-align: left;
}

table.tableList td.right {
	text-align: right;
}

table.tableList td img {
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
			<li style="width: 25.0%; text-align: center;" class="active"><a
				href="goNotice.st">공지사항</a></li>
			<li style="width: 25.0%; text-align: center;" class=""><a
				href="goCourseInquiry.st">교과목조회</a></li>
			<li style="width: 25.0%; text-align: center;" class=""><a
				href="goPreliminaryCourse.st">예비수강신청목록</a></li>
			<li style="width: 25.0%; text-align: center;" class=""><a
				href="goCourseApply.st">수강신청</a></li>
		</ul>
	</div>
	<br><br>
	<table width="95%" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tbody>
			<tr>
				<td>
					<div id="menu1" style="display:;">
						<!--첫번째텝시작-->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td colspan="7">
										<!--내용-->
										<table width="100%" cellspacing="0" cellpadding="0"
											style="border: #cdcdcd 1px solid;">
											<tbody>
												<tr>
													<td colspan="3" height="20"></td>
												</tr>
												<tr>
													<td colspan="3">
														<!-- 수강신청기간 -->
														<div>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">★★★</span>&nbsp;<span
																	style="color: rgb(255, 0, 0); font-weight: bold;">교양과목은
																	강의실 수용인원</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">최대&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">90</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">명</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">이하로
																	수강인원을 제한하며 별도의 수강신청서를 받지 않으니&nbsp;</span><span
																	style="color: rgb(9, 0, 255); font-weight: bold;">해당
																	수강신청기간에 반드시 수강신청 하시기 바랍니다</span><span
																	style="color: rgb(9, 0, 255); letter-spacing: 0pt; font-weight: bold;">.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">★★★</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span style="color: rgb(9, 0, 255);">교과목 담당교수가
																	미정으로 되어 있는 과목은 현재 교수님을 초빙하는 과정이기 때문에 강의계획서가 입력되지 않은
																	상황입니다. 해당 과목이 2학기 마다 개설되는 과목의 경우는 2018-2학기, 2017-2학기에
																	동일과목명의 강의계획서가 등록되어 있으니 이를 참고하실 수 있습니다. 강사법 시행으로
																	2019-2학기부터 외래교수 제도에서 강사제도로 변경이 되었기 때문에 강사 초빙이 진행되고 있어
																	초빙이 끝나지 않은 과목의 경우는 담담교수가 미정 상태로 되어 있는 점 양해를 부탁드립니다.</span>
															</p>
															<p
																style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">※&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">학사
																	운영의 공정성 및 투명성 제고를 위하여 수강하고자 하는 강좌의 담당 교원이 부모인 경우 학부</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">과</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">에
																	신고 후 수강지도를 받으시기 바랍니다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">교과목을
																	수강할 경우 교수</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">-</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">자녀간
																	수강신청서를 학과</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">부</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">에
																	반드시 제출하여야 합니다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">문의</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">:
																	031-379-0024</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">※&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">신입생</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(2019</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">학번</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">부터는
																	핵심역량별 균형있는 교양교육을 하기 위하여 배분이수제도를 도입하였습니다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">따라서&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">2019</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">학번은
																	교양필수과목 포함하여 대학 인재상별&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">5</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">학점
																	이상을 이수하여야 합니다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">인재상별
																	교양과목 확인은 강의시간표책자를 참조하시기 바랍니다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span
																	style="color: rgb(255, 0, 0); font-size: 12pt; font-weight: bold;">강의시간표
																	책자 학사안내</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">(2019.08.22.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">PDF)-&gt;&nbsp;</span><b><span
																	style="letter-spacing: 0pt; font-size: 12pt; color: rgb(9, 0, 255);"><a
																		href="http://www.hs.ac.kr/bbs/kor/274/37603/download.do"
																		target="_blank" title="" class="" id=""
																		style="color: rgb(9, 0, 255);">클릭</a></span></b>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 12pt; font-weight: bold;"><span
																	style="letter-spacing: 0pt; font-size: 12pt;"><span
																		style="font-size: 12pt;">강의변경 안내&nbsp;</span><span
																		style="letter-spacing: 0pt; font-size: 12pt;">-&gt;&nbsp;<a
																			href="http://www.hs.ac.kr/kor/4956/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjc0JTJGMTE5Njg0JTJGYXJ0Y2xWaWV3LmRvJTNGcGFnZSUzRDElMjZzcmNoQ29sdW1uJTNEJTI2c3JjaFdyZCUzRCUyNmJic0NsU2VxJTNEJTI2YmJzT3BlbldyZFNlcSUzRCUyNnJnc0JnbmRlU3RyJTNEJTI2cmdzRW5kZGVTdHIlM0QlMjZpc1ZpZXdNaW5lJTNEZmFsc2UlMjZwYXNzd29yZCUzRCUyNg%3D%3D"
																			target="_blank" title="" class=""
																			style="color: rgb(9, 0, 255);">클릭</a></span></span></span>
															</p>
															<p class="0"
																style="line-height: 17.6px; margin-top: 0px; margin-bottom: 4pt; color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">★★&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-size: 12pt; font-weight: bold;">폐강
																	및 강의변경 안내&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">★★</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span style="font-size: 11pt; font-weight: bold;">교과목
																	담당교수의 사정에 따라 수강신청 중 또는 수강신청 후에 폐강 및 강의시간</span><span
																	style="letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">(</span><span
																	style="font-size: 11pt; font-weight: bold;">교시</span><span
																	style="letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">)</span><span
																	style="font-size: 11pt; font-weight: bold;">이
																	변동될 수 있습니다</span><span
																	style="letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 4pt;">
																<span style="font-size: 11pt; font-weight: bold;">강의시간
																	변동으로 타 과목과 강의시간이 중복된 경우 학생이 취소과목을 선택하여 수강취소 하여야 합니다</span><span
																	style="letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">[</span><span
																	style="font-size: 12pt; font-weight: bold;">교필
																	진로와상담 수강신청안내</span><span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">(2016</span><span
																	style="font-size: 12pt; font-weight: bold;">학번부터
																	필수</span><span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">)]</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">1.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학과</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">부</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">)</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">로부터
																	상담지도교수 안내 받음</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<u><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">2.&nbsp;</span></u>
																<u><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학생
																		본인이 수강 신청</span></u> <u><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">(</span></u>
																<u><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">변경</span></u>
																<u><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">)</span></u>
																<u><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">함</span></u>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">진로와
																	상담 수강 신청</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">:&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">배정
																	교수</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-
																	2016</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학번부터는
																	총&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">4</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">회
																	수강신청 및 이수</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">(P)</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-
																	1</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학년</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-2</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학기&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">/
																	2</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학년</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-1</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학기&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">/
																	3</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학년</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-1</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학기&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">/
																	3</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학년</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 11pt; font-weight: bold;">-2</span><span
																	style="color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">학기</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span style="letter-spacing: 0pt; font-size: 11pt;">3.&nbsp;</span><span
																	style="font-size: 11pt;">상담 신청 및 상담 실시</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<span style="font-size: 11pt;">수강 신청</span><span
																	style="letter-spacing: 0pt; font-size: 11pt;">(</span><span
																	style="font-size: 11pt;">변경</span><span
																	style="letter-spacing: 0pt; font-size: 11pt;">)&nbsp;</span><span
																	style="font-size: 11pt;">후 홈피의&nbsp;</span><span
																	style="letter-spacing: 0pt; font-size: 11pt;">QUICK
																	MENU</span><span style="font-size: 11pt;">의 학생역량개발에
																	상담신청하고 최소&nbsp;</span><span
																	style="letter-spacing: 0pt; font-size: 11pt;">1</span><span
																	style="font-size: 11pt;">회 이상 상담 실시</span>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">[</span><span
																	style="font-size: 12pt; font-weight: bold;">재수강
																	안내</span><span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">]</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-size: 11pt;">1.&nbsp;</span><span
																	style="font-size: 11pt;">재수강</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt;">-&nbsp;</span>재수강이란
																이미 취득한 교과목을 본인의 신청에 의하여 동일한 교과목을 다시 수강하여 성적을 취득하는 제도를
																말한다<span style="letter-spacing: 0pt;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">학수번호가
																	같은 경우 동일과목임</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">분반제외</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-weight: bold;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">교과목명이
																	변경되어 학수번호가 변경이 된 과목은 재수강이</span>&nbsp;<span
																	style="color: rgb(255, 0, 0); font-weight: bold;">아님</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-weight: bold;">-</span>&nbsp;<span
																	style="color: rgb(255, 0, 0); font-weight: bold;">예</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">교과목명</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">학수번호</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">변경</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">:&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">교육이란무엇인가</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(KY772)
																	-&gt;&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">인간과교육</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(KYA22)</span>
															</p>
															<p class="0"
																style="line-height: 17.6px; margin-top: 0px; margin-bottom: 0px; color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-size: 11pt;">2.&nbsp;</span><span
																	style="font-size: 11pt;">조건</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">재학
																	중인 학생은&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">C+&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">이하인
																	과목에 한하여 재수강을 신청할 수 있다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-weight: bold;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">재수강
																	신청은 본 대학이 정한 수강신청 기간 내에 한다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 17.6px; margin-top: 0px; margin-bottom: 0px; font-size: 11pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-size: 11pt;">3.&nbsp;</span><span
																	style="font-size: 11pt;">유의사항</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt;">-&nbsp;</span>재수강
																신청으로 학점포기 된 교과목은 복원할 수 없다<span
																	style="letter-spacing: 0pt;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">재수강시에는&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">A0</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">까지의
																	성적을 취득할 수 있다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt;">-&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">동일과목
																	재수강은&nbsp;</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">2</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">회를
																	초과할 수 없다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">단</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">,&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">필수과목은
																	제외한다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 17.6px; margin-top: 0px; margin-bottom: 0px; color: rgb(255, 0, 0); font-size: 11pt; font-weight: bold;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-size: 11pt;">4.&nbsp;</span><span
																	style="font-size: 11pt;">관련규정</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<span style="letter-spacing: 0pt; font-size: 11pt;">-&nbsp;</span><span
																	style="font-size: 11pt;">학사에 관한 내규 제</span><span
																	style="letter-spacing: 0pt; font-size: 11pt;">22</span><span
																	style="font-size: 11pt;">조의&nbsp;</span><span
																	style="letter-spacing: 0pt; font-size: 11pt;">3</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin-top: 0px; margin-bottom: 0px;">
																<br>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt;">
																<span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">[</span><span
																	style="font-size: 12pt; font-weight: bold;">전공필수과목
																	전공자</span><span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">(</span><span
																	style="font-size: 12pt; font-weight: bold;">복수전공자</span><span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">)</span><span
																	style="font-size: 12pt; font-weight: bold;">우선
																	수강신청 학과안내</span><span
																	style="letter-spacing: 0pt; font-size: 12pt; font-weight: bold;">]</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																국어국문<span style="letter-spacing: 0pt;">,&nbsp;</span>영어영문<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>독어독문<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>철학<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>문예창작<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>종교문화<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>디지털문화콘텐츠<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>중국어문화<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>한중문화콘텐츠,
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																미디어영상광고홍보<span style="letter-spacing: 0pt;">,&nbsp;</span>사회복지<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>재활<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>특수체육<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>심리아동<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>글로벌비즈니스<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>중국<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>경영<span
																	style="letter-spacing: 0pt;">, e-</span>비즈니스<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>수리금융,
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																응용통계<span style="letter-spacing: 0pt;">,&nbsp;</span>컴퓨터공학<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>정보통신<span
																	style="letter-spacing: 0pt;">, IT</span>콘텐츠<span
																	style="letter-spacing: 0pt;">,&nbsp;</span>인문콘텐츠학부
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;"><br></span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">※&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">상기
																	학과의 전공필수과목</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">심리아동학부</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">,&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">미디어영상광고홍보학부는
																	전공선택 포함</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">의
																	경우 전공자</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">복수전공자</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">에게
																	우선 수강신청 할 수 있도록 합니다</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">.</span>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																<br>
															</p>
															<p class="0"
																style="line-height: 19.2px; margin: 0px 1pt;">
																따라서 전공자가 아닌 타과 학생의 경우 상기학과의 전공필수과목을 수강신청 하고자 할 경우에는
																전체학년&nbsp;수강신청기간<span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">(2019.
																	8. 9(</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">금</span><span
																	style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-weight: bold;">)
																	10:00 ~ 23:00) 또는 수강신청 변경기간에&nbsp;</span><span
																	style="color: rgb(255, 0, 0); font-weight: bold;">수강신청이
																	가능</span>합니다<span style="letter-spacing: 0pt;">.</span>
															</p>
															<p class="0"
																style="line-height: 24.2px; margin: 0px 1pt; font-size: 11pt;">
																<br>
															</p>
															<table
																style="border: 0px rgb(0, 0, 0); width: 819.41px; height: 741.76px; border-collapse: collapse; table-layout: fixed;">
																<tbody>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 71px; height: 53px;"><p
																				class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">예비</span>
																			</p>
																			<p class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">수강신청</span>
																			</p></td>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 53px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">전체학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 53px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2019.
																					7.30(</span><span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">화</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)
																					10:00 ~</span>
																			</p>
																			<p class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">8.
																					1(</span><span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">목</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)
																					23:00</span>
																			</p></td>
																		<td valign="middle" rowspan="9" colspan="2"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 431px; height: 732px;"><p
																				class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<u><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-.&nbsp;</span></u><u><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">예비수강신청
																						후 학년별 수강 신청 가능 인원 여석이 허용되는 것은 본 수강신청에 자동이관 됨</span></u><u><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.&nbsp;</span></u><u><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">자동이관
																						되지 않는 과목은 본 수강신청기간에 직접 수강신청 해야 합니다</span></u><u><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.</span></u>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<br>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-.&nbsp;</span><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">개강
																					첫 주 수강변경으로 인한 결석은 출석으로 인정되지 않습니다</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.
																					(</span><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">첫
																					수업부터 출석여부 체크함</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<br>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">※&nbsp;</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">전공
																					수강신청 기준</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-&nbsp;</span><span
																					style="color: rgb(254, 17, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">타
																					학년 전공과목은 전체학년 수강신청기간에만 수강신청이 가능합니다</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.(</span><span
																					style="color: rgb(254, 17, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">예비수강에
																					담아 두셔도 타 학년 과목은 수강으로 자동이관 되지 않습니다</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.)</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-
																					1</span><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					전공과목의 경우는&nbsp;</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">1</span><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 후</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">(</span><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">전체학년</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)&nbsp;</span><span
																					style="color: rgb(0, 0, 255); font-family: 굴림; font-size: 9pt; font-weight: bold;">수강신청이
																					가능합니다</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-&nbsp;</span><span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">학년별
																					수강신청기간에는 학년별 수강신청 가능인원비율 내에서 선착순 수강신청 됩니다</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<br>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<br>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 12pt; font-weight: bold;">&lt;</span><span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 12pt; font-weight: bold;">학년별
																					전공수업 수강신청 가능인원비율</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 12pt; font-weight: bold;">&gt;</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">-
																					1</span><span style="font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					1</span><span style="font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">80%,&nbsp;</span><span
																					style="font-size: 9pt; font-weight: bold;">전체학년수강
																					시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">20%</span><br>
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">-
																					2</span><span style="font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					2</span><span style="font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">80%,&nbsp;</span><span
																					style="font-size: 9pt; font-weight: bold;">전체학년수강
																					시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">20%</span><br>
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">-
																					3</span><span style="font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					3</span><span style="font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">80%,&nbsp;</span><span
																					style="font-size: 9pt; font-weight: bold;">전체학년수강
																					시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">20%</span><br>
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">-
																					4</span><span style="font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					4</span><span style="font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">80%,&nbsp;</span><span
																					style="font-size: 9pt; font-weight: bold;">전체학년수강
																					시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">20%</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">ex)
																					2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">70</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">명
																					정원일 경우&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					전공 수강 가능인원</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">?</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2</span><span
																					style="font-size: 9pt; font-weight: bold;">학년
																					기간&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					56</span><span style="font-size: 9pt; font-weight: bold;">명</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">,&nbsp;</span><span
																					style="font-size: 9pt; font-weight: bold;">전체기간&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					14</span><span style="font-size: 9pt; font-weight: bold;">명</span><br>
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">※&nbsp;</span><span
																					style="font-size: 9pt; font-weight: bold;">예비
																					수강신청기간 상기 과목을 예비수강신청 한 해당학년학생이&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">52</span><span
																					style="font-size: 9pt; font-weight: bold;">명을
																					넘지 않으면 수강신청으로 자동 이관됩니다</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">.(</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">단</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">,&nbsp;</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">타
																					학년 예비수강신청과목은 전체 학년 수강신청 시 수강 신청해야 합니다</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">.)</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-
																					2,3,4</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">:
																					3,4</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">55%,
																					2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">25%,&nbsp;</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">전체학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">20%</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-
																					2,3</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">:
																					3</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">40%,
																					2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">40%,</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">전체학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">20%</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-
																					1,2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					교과목&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">:
																					2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">40%,
																					1</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					수강신청 시&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">40%,</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="color: rgb(0, 0, 255); font-size: 9pt; font-weight: bold;">전체학년
																					수강신청 시&nbsp;</span><span
																					style="color: rgb(0, 0, 255); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">20%</span><br>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<br>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 12pt; font-weight: bold;">&lt;</span><span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 12pt; font-weight: bold;">교양수업
																					수강신청 가능인원비율</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-family: 굴림; font-size: 12pt; font-weight: bold;">&gt;</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">※&nbsp;</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">교양수업은
																					학년에 관계없이 아래의 수강일정비율로 수강신청이 가능합니다</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">.</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">1</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-50%,
																					2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-20%,
																					3,4</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-20%,&nbsp;</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">전체학년수강
																					시</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">-10%</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">ex)
																					90</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">명
																					정원의 교양 수업 수강 가능인원</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">3,4</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					기간&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">:
																					18</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">명</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">,
																					2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					기간&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">:
																					18</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">명</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">,
																					1</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년
																					기간&nbsp;</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">:
																					45</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">명</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span style="font-size: 9pt; font-weight: bold;">전체기간&nbsp;</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">:
																					9</span><span style="font-size: 9pt; font-weight: bold;">명</span><br>
																				<span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">(</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">단</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">,&nbsp;</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">글쓰기의기초</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">,&nbsp;</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">영어</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2&nbsp;</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">교과목은&nbsp;</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">1</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">학년
																					기간에 수강가능인원의&nbsp;</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">80%</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">가
																					열리며 사회생활길잡이는&nbsp;</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">학년
																					기간에 수강가능인원의&nbsp;</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">80%</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">가
																					열립니다</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">.&nbsp;</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">나머지&nbsp;</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">20%</span><span
																					style="color: rgb(254, 17, 0); font-size: 9pt; font-weight: bold;">는
																					전체기간에 열립니다</span><span
																					style="color: rgb(254, 17, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">.)</span>
																			</p>
																			<p class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="color: rgb(254, 17, 0); font-weight: 700; background-color: rgb(255, 255, 255);">※
																					90명 교양수업은 수강신청기간에는 80명까지 열리며, 개강후 수강신청변경기간에 나머지
																					10명이 열립니다.</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle" rowspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 71px; height: 99px;"><p
																				class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">자동수강</span>
																			</p>
																			<p class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">과목조회</span>
																			</p></td>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">3,4</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2019.
																					8. 6(</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">화</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)
																					09:30 ~ 09:50</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2019.
																					8. 7(</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">수</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)
																					09:30 ~ 09:50</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">1</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2019.
																					8. 8(</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">목</span><span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">)
																					09:30 ~ 09:50</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle" rowspan="4"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 71px; height: 132px;"><p
																				class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">본</span>
																			</p>
																			<p class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="color: rgb(255, 0, 0); font-family: 굴림; font-size: 9pt; font-weight: bold;">수강신청</span>
																			</p></td>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">3,4</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2019.
																					8. 6(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">화</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					10:00 ~&nbsp;</span><br> <span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">8.
																					7(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">수</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					09:00</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">2</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2019.
																					8. 7(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">수</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					10:00 ~</span><br> <span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">8.
																					8(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">목</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					09:00</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="letter-spacing: 0pt; font-family: 굴림; font-size: 9pt; font-weight: bold;">1</span><span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2019.
																					8. 8(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">목</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					10:00 ~&nbsp;</span><br> <span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">8.
																					9(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">금</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					09:00</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">전체학년</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 33px;"><p
																				class="0"
																				style="line-height: 20.8px; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2019.
																					8. 9(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">금</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					10:00 ~&nbsp;</span><br> <span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">8.
																					9(</span><span
																					style="color: rgb(255, 0, 0); font-size: 9pt; font-weight: bold;">금</span><span
																					style="color: rgb(255, 0, 0); letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					23:00</span>
																			</p></td>
																	</tr>
																	<tr>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 71px; height: 332px;"><p
																				class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">수강신청</span>
																			</p>
																			<p class="0"
																				style="line-height: 24px; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">변경기간</span>
																			</p></td>
																		<td valign="middle"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 85px; height: 332px;"><p
																				class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; text-align: center;">
																				<span
																					style="font-family: 굴림; font-size: 9pt; font-weight: bold;">학년제한
																					없음</span>
																			</p></td>
																		<td valign="middle" colspan="3"
																			style="padding: 1.41pt 5.1pt; border: 3px solid rgb(0, 0, 0); width: 163px; height: 332px;"><p
																				class="0"
																				style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px; font-family: 굴림;">
																				<span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">2019.
																					9. 2(</span><span
																					style="font-size: 9pt; font-weight: bold;">월</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					10:00 ~&nbsp;</span><br> <span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">9.
																					6(</span><span style="font-size: 9pt; font-weight: bold;">금</span><span
																					style="letter-spacing: 0pt; font-size: 9pt; font-weight: bold;">)
																					23:00</span>
																			</p></td>
																	</tr>
																</tbody>
															</table>
															<p class="0"
																style="line-height: 26.4px; margin: 0px 1pt 4pt;">
																<br>
															</p>
															<p
																style="line-height: 1.2; margin-top: 0px; margin-bottom: 0px;">
																<br style="font-family: 굴림; font-size: 16px;">
															</p>
															<p class="0">
																<font face="굴림" size="3"><o:p></o:p></font>
															</p>
														</div>
														<p class="0">
															<font face="굴림" size="3"> </font>
														</p> <!-- 수강신청기간 -->
													</td>
												</tr>
												<tr>
													<td colspan="3" height="20"></td>
												</tr>
											</tbody>
										</table> <!--내용-->
									</td>
								</tr>
							</tbody>
						</table>

					</div>


					<div id="menu2" style="display: none;">
						<!--두번째텝시작-->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td class="tap_01" width="25%" onclick="DisplayMenu(1)"
										style="cursor: pointer;">수강신청 일정 및 주요사항</td>
									<td>&nbsp;</td>

									<td class="tap_01_ov" width="25%" onclick="DisplayMenu(2)"
										style="cursor: pointer;">시스템사용 유의사항</td>
									<td width="50%">&nbsp;</td>
								</tr>

								<tr>
									<td colspan="7" height="2" bgcolor="#124680"></td>
								</tr>

								<tr>
									<td colspan="7">
										<!--내용-->
										<table width="100%" cellspacing="0" cellpadding="0"
											style="border: #cdcdcd 1px solid;">
											<tbody>
												<tr>
													<td colspan="3" height="20"></td>
												</tr>
												<tr>
													<td colspan="3">

														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">


															<tbody>
																<tr height="24">
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="Orange"><img
																		src="/html/images/icon.gif">&nbsp;매크로 방지</td>
																	<td width="2%">&nbsp;</td>
																</tr>

																<tr>
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="pd20_L">
																		<ul>
																			<li>매크로프로그램 방지하기 위하여 저장 및 조회를 일정한 횟수 이상 시도하면 화면에
																				나타나는 문자열을 입력하고 계속 사용</li>
																		</ul>
																	</td>
																	<td width="2%">&nbsp;</td>
																</tr>


																<tr>
																	<td colspan="3" height="10"></td>
																</tr>



																<tr height="24">
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="Orange"><img
																		src="/html/images/icon.gif">&nbsp;팝업차단 해제</td>
																	<td width="2%">&nbsp;</td>
																</tr>

																<tr>
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="pd20_L">
																		<ul>
																			<li>팝업차단 설정이 해제 되지 않았을 경우 팝업차단을 해제</li>
																			<li>팝업차단 해제 방법으로 브라우저에서 “도구/인터넷옵션/팝업차단설정/” 현재
																				사이트의 팝업을 항상 “허용”</li>
																		</ul>
																	</td>
																	<td width="2%">&nbsp;</td>
																</tr>



																<tr height="24">
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="Orange"><img
																		src="/html/images/icon.gif">&nbsp;멀티로그인시 처리기능 방지</td>
																	<td width="2%">&nbsp;</td>
																</tr>

																<tr>
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="pd20_L">
																		<ul>
																			<li>동일한 학번으로 동시에 두 군데 이상의 PC에서 로그인을 했을 경우 조회 기능은
																				가능하나 수강신청 저장을 시도하면 마지막으로 로그인 한 사용자만 저장 가능하고 나머지는
																				로그아웃 처리</li>
																		</ul>
																	</td>
																	<td width="2%">&nbsp;</td>
																</tr>



																<tr height="24">
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="Orange"><img
																		src="/html/images/icon.gif">&nbsp;모니터 해상도</td>
																	<td width="2%">&nbsp;</td>
																</tr>

																<tr>
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="pd20_L">
																		<ul>
																			<li>수강신청시스템은 1280*800 해상도에 최적화 되어 있으며 그 이상의 해상도로
																				화면 설정</li>

																		</ul>
																	</td>
																	<td width="2%">&nbsp;</td>
																</tr>






																<tr height="24">
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="Orange"><img
																		src="/html/images/icon.gif">&nbsp;인터넷 익스플로러 버전</td>
																	<td width="2%">&nbsp;</td>
																</tr>

																<tr>
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="pd20_L">
																		<ul>
																			<li>인터넷 익스플로러 6.x 이하 버전을 사용하시는 분들은 정상적으로 동작하지
																				않을수 있으며, 보안상의 이유로도 7.0 버전이상으로 업그레이드 하시기를 권장합니다.</li>

																		</ul>
																	</td>
																	<td width="2%">&nbsp;</td>
																</tr>


																<tr height="24">
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="Orange"><img
																		src="/html/images/icon.gif">&nbsp;주의사항</td>
																	<td width="2%">&nbsp;</td>
																</tr>

																<tr>
																	<td width="2%">&nbsp;</td>
																	<td width="96%" class="pd20_L">
																		<ul>
																			<li>F5번(새로고침) 키를 누르시면 로그아웃 됩니다.</li>
																			<li>모바일 환경에서는 수강신청 앱으로 수강신청 하셔야 합니다. 모바일인터넷으로
																				수강신청 페이지로 이동하시면 정상적인 수강신청이 불가능 합니다.</li>
																			<li>장바구니 기능은 수강신청이 된것이 아닙니다. 반드시 수강신청기간중 최종수강신청을
																				하셔야 합니다.</li>
																		</ul>
																	</td>
																	<td width="2%">&nbsp;</td>
																</tr>


																<tr>
																	<td colspan="3">
																		<li>&nbsp;&nbsp;&nbsp;※ 개인정보보호를 위하여 학사시스템에서 비밀번호를
																			변경하십시요.</li>
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
												<tr>
													<td colspan="3" height="20"></td>
												</tr>
											</tbody>
										</table> <!--내용-->
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
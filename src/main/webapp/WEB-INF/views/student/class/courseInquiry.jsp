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
			<li style="width: 23.0%; text-align: center;" class="active"><a
				href="goCourseInquiry.st">교과목조회</a></li>
			<li style="width: 23.0%; text-align: center;" class=""><a
				href="goPreliminaryCourse.st">예비수강신청목록</a></li>
			<li style="width: 23.0%; text-align: center;" class=""><a
				href="goCourseApply.st">수강신청</a></li>
		</ul>
	</div>
	<table class="tableList1" width="100%">
		<tbody>
			<tr id="choice">
				<td><span> &nbsp;&nbsp;<b>카테고리</b> <select
						name="category" id="category">
							<option value="">학과조회</option>
							<option value="">과목 검색</option>
							<option value="">교수 검색</option>
					</select>&nbsp;&nbsp;
				</span> <span id="choice1" name="choice1"> <span> <strong>학과</strong>
							<select name="allMajor" id="allMajor" class="Layer1">
								<option value="">!!</option>
						</select> &nbsp;&nbsp;&nbsp; <strong>이수구분</strong> <select name="allIsu"
							id="allIsu" class="Layer1">
								<option value="">* 전체 *</option>
								<option value="">교필</option>
								<option value="">교선</option>
								<option value="">평생</option>
						</select> &nbsp;&nbsp;&nbsp; <strong>학년</strong> <select name="allHakyun"
							id="allHakyun" class="Layer1">
								<option value="">1학년</option>
								<option value="">2학년</option>
								<option value="">3학년</option>
								<option value="">4학년</option>
						</select> <strong>과목</strong> <select name="allLecture" id="allLecture"
							class="Layer1">
								<option value="">!!</option>
								<option value="">3D콘텐츠제작 [KY700]</option>
								<option value="">4차산업혁명과사회디자인 [KYA58]</option>
								<option value="">Creative Thinking [KY979]</option>
								<option value="">NCS직업기초능력다지기 [KY603]</option>
								<option value="">결혼과가족 [KY961]</option>
								<option value="">고급한국어문법1 [*KY111]</option>
								<option value="*KY109">고급한국어회화1 [*KY109]</option>
								<option value="KY771">고급회화:토론과발표 [KY771]</option>
								<option value="KY728">공동체감성과실천적말하기 [KY728]</option>
								<option value="KY675">과학의선구자들 [KY675]</option>
								<option value="KY895">교회음악II [KY895]</option>
								<option value="KY800">구급과안전교육 [KY800]</option>
								<option value="KYA57">글로벌리더십과이노베이션 [KYA57]</option>
								<option value="KY720">글쓰기의기초 [KY720]</option>
								<option value="KY313">기독교와문화(기독) [KY313]</option>
								<option value="KY209">기업가정신및창업실무 [KY209]</option>
								<option value="KYA31">기초독일어실습II [KYA31]</option>
								<option value="KY992">기초영어회화2 [KY992]</option>
								<option value="KY863">꿈과유토피아 [KY863]</option>
								<option value="KY431">나를찾아떠나는여행 [KY431]</option>
								<option value="KYA51">남북한통일문제와미디어환경 [KYA51]</option>
								<option value="KY723">내삶을바꿀소설세편 [KY723]</option>
								<option value="KY876">노동과인간 [KY876]</option>
								<option value="KY471">논리와비판적사고 [KY471]</option>
								<option value="KY786">뉴턴과근대과학탄생의비밀 [KY786]</option>
								<option value="KYA44">돈과인간 [KYA44]</option>
								<option value="KYA55">돈의메카니즘 [KYA55]</option>
								<option value="KYA64">동남아경제 [KYA64]</option>
								<option value="KYA50">동아시아120년전쟁과한반도의평화 [KYA50]</option>
								<option value="KYA62">디지털시대자기표현 [KYA62]</option>
								<option value="KY208">러시아어회화및실습Ⅱ [KY208]</option>
								<option value="KYA61">만화,애니메이션창작 [KYA61]</option>
								<option value="KY984">멀티미디어영어 [KY984]</option>
								<option value="KY689">모바일앱개발 [KY689]</option>
								<option value="KY977">문화콘텐츠로만나는정조 [KY977]</option>
								<option value="KYA21">물리란무엇인가 [KYA21]</option>
								<option value="KY699">물리로보는세계 [KY699]</option>
								<option value="KY650">미디어와사회 [KY650]</option>
								<option value="KY974">미술과사회 [KY974]</option>
								<option value="KY746">민족해방과분단,그리고그너머 [KY746]</option>
								<option value="KY697">민주시민교육 [KY697]</option>
								<option value="KYA45">발성과가곡부르기 [KYA45]</option>
								<option value="KY819">배구 [KY819]</option>
								<option value="KY822">배드민턴 [KY822]</option>
								<option value="KYA63">베트남어2 [KYA63]</option>
								<option value="KY836">봉사활동Ⅱ [KY836]</option>
								<option value="KYA47">북한의문화와일상생활 [KYA47]</option>
								<option value="KY731">사랑할때와헤어질때:고전속의스무장면 [KY731]</option>
								<option value="KY736">사진예술의이해 [KY736]</option>
								<option value="KY921">사회생활길잡이 [KY921]</option>
								<option value="KY472">생활법률 [KY472]</option>
								<option value="KY309">생활속의실용금융 [KY309]</option>
								<option value="KY953">서양미술의감상과이해 [KY953]</option>
								<option value="KY290">성서와문학(성서) [KY290]</option>
								<option value="KY894">성서와여성(성서) [KY894]</option>
								<option value="KY803">성서와영성(성서) [KY803]</option>
								<option value="KY893">성서와예술(성서) [KY893]</option>
								<option value="KY886">성서와음악(성서) [KY886]</option>
								<option value="KYA54">성서와평화 [KYA54]</option>
								<option value="KY217">성서의세계(성서) [KY217]</option>
								<option value="KY754">세계사속의혁명 [KY754]</option>
								<option value="KY502">세계음악여행 [KY502]</option>
								<option value="KYA38">세상보기와글읽기 [KYA38]</option>
								<option value="KY868">소비와마케팅 [KY868]</option>
								<option value="KYA56">소통과의사결정과정 [KYA56]</option>
								<option value="KY850">수원의역사와문화 [KY850]</option>
								<option value="KY698">수학과문명 [KY698]</option>
								<option value="KY676">수학으로세상읽기 [KY676]</option>
								<option value="KY099">스타트업실전사업계획서 [KY099]</option>
								<option value="KY983">시사영어 [KY983]</option>
								<option value="KY613">신학입문 [KY613]</option>
								<option value="KYA37">심리와교육 [KYA37]</option>
								<option value="KY678">연극과뮤지컬의이해 [KY678]</option>
								<option value="KYA59">연기예술2:관찰 [KYA59]</option>
								<option value="KYA60">연기와마음치료 [KYA60]</option>
								<option value="*KY015">영상으로보는한국사회 [*KY015]</option>
								<option value="KY722">영어Ⅱ [KY722]</option>
								<option value="KYA49">영화로보는남북통일문제 [KYA49]</option>
								<option value="KY942">영화로이해하는아시아 [KY942]</option>
								<option value="KY864">영화와사회심리 [KY864]</option>
								<option value="KY973">예술로공동체만들기 [KY973]</option>
								<option value="KY972">예술로말하기2 [KY972]</option>
								<option value="KY499">오르간연주법2 [KY499]</option>
								<option value="KS411">원격교육론 [KS411]</option>
								<option value="KY825">유도 [KY825]</option>
								<option value="KY949">유럽속의독일문화 [KY949]</option>
								<option value="KY862">인간관계와예절 [KY862]</option>
								<option value="KY553">인권과법 [KY553]</option>
								<option value="KYA48">인물로보는평화와통일 [KYA48]</option>
								<option value="KY891">인물로읽는성서(성서) [KY891]</option>
								<option value="KY750">일본근현대와동아시아 [KY750]</option>
								<option value="KY951">일본문학길잡이 [KY951]</option>
								<option value="KY668">일상생활과기록 [KY668]</option>
								<option value="KY931">재미있는정신분석이야기 [KY931]</option>
								<option value="KY703">정보기술법률 [KY703]</option>
								<option value="KY832">정의란무엇인가 [KY832]</option>
								<option value="KY950">제3세계문학길잡이 [KY950]</option>
								<option value="KY827">조깅과워킹 [KY827]</option>
								<option value="KY647">조선왕실의삶과문화 [KY647]</option>
								<option value="KY843">중국어Ⅱ [KY843]</option>
								<option value="KY845">중국어회화Ⅱ [KY845]</option>
								<option value="KY994">중급영어회화2 [KY994]</option>
								<option value="KY781">중급일본어II [KY781]</option>
								<option value="*KY040">중급한국어문법1 [*KY040]</option>
								<option value="*KY041">중급한국어회화1 [*KY041]</option>
								<option value="KYA52">직업기초능력과현장실습 [KYA52]</option>
								<option value="KY410">진로와상담 [KY410]</option>
								<option value="KY658">진로탐색과미래설계 [KY658]</option>
								<option value="KY406">진화심리학으로읽는소비문화 [KY406]</option>
								<option value="KY990">창업경영의이해 [KY990]</option>
								<option value="KY100">채플 [KY100]</option>
								<option value="KY101">채플 [KY101]</option>
								<option value="KY201">채플 [KY201]</option>
								<option value="KY304">채플 [KY304]</option>
								<option value="KY509">채플 [KY509]</option>
								<option value="KY660">청년창업과기업가정신 [KY660]</option>
								<option value="KS207">청소년교육론 [KS207]</option>
								<option value="KY780">초급일본어ll [KY780]</option>
								<option value="KY205">초급일본어회화Ⅱ [KY205]</option>
								<option value="*KY038">초급한국어문법1 [*KY038]</option>
								<option value="*KY039">초급한국어회화1 [*KY039]</option>
								<option value="KY878">취업과이미지메이킹 [KY878]</option>
								<option value="KY831">취창업스쿨2 [KY831]</option>
								<option value="KY585">컴퓨팅적사고 [KY585]</option>
								<option value="KY821">탁구 [KY821]</option>
								<option value="KS306">평생교육방법론 [KS306]</option>
								<option value="KS308">평생교육프로그램개발론 [KS308]</option>
								<option value="KY656">프랑스어회화및실습Ⅱ [KY656]</option>
								<option value="KY590">프로그래밍기초 [KY590]</option>
								<option value="*KY02">한국문화지리 [*KY02]</option>
								<option value="KY952">한국미술의감상과이해 [KY952]</option>
								<option value="*KY120">한국생활배우기1 [*KY120]</option>
								<option value="*KY113">한국어듣기기초1 [*KY113]</option>
								<option value="*KY118">한국어말하기기초1 [*KY118]</option>
								<option value="*KY116">한국어쓰기기초1 [*KY116]</option>
								<option value="KY674">한국의세계문화유산 [KY674]</option>
								<option value="*KY020">한국의전통문화 [*KY020]</option>
								<option value="KY841">한문Ⅱ [KY841]</option>
								<option value="KYA46">합창과화음 [KYA46]</option>
								<option value="KY206">현대서양사상의길잡이 [KY206]</option>
								<option value="KY447">현대세계정치의이해 [KY447]</option>
								<option value="KY777">현대인의정신건강 [KY777]</option>
								<option value="KY806">현대환경문제의이해 [KY806]</option>
								<option value="KY607">현장으로이해하는아시아 [KY607]</option>
						</select>&nbsp;&nbsp;&nbsp;
					</span>
				</span> <!-- 과목조회 -->
					<button type="submit" style="background: red;">조회</button>
					<button type="submit" style="background: red;">예비신청</button></td>
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
				<td colspan="14"><font color="red">☞ 조회버튼을 클릭하세요.</font></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function change_cate(){
		var category = $("#category").val();
		console.log(category);
		if(category == "0"){
			$("#choice0").show();
			$("#choice1").hide();
			$("#choice2").hide();
		}else if(category == "1"){
			$("#choice0").hide();
			$("#choice1").show();
			$("#choice2").hide();
		}else if(category == "2"){	
			$("#choice0").hide();
			$("#choice1").hide();
			$("#choice2").show();
		}
	}
	
</script>
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
	<form action="inquiry.st" method="post">
		<table class="tableList3" width="100%">
			<input type="hidden" name="sbjt_cd">
			<tbody>
				<tr id="choice">
					<td>
						<span> &nbsp;&nbsp;&nbsp;<b>카테고리</b> : 
							<select
								name="category" id="category" onchange="change_cate()"
								style="background-color: #FFD9EC;">
									<option value="0">학과 조회</option>
									<option value="1">과목 검색</option>
									<option value="2">교수 검색</option>
							</select>&nbsp;&nbsp;&nbsp;
					</span>
					 <!-- 개설강좌 --> 
					 <span id="choice0" name="choice0" style="display: inline;"> 
					 	<span> <strong>학과</strong> : 
					 		<select name="allMajor" id="allMajor" class="Layer1" onchange="javascript:setIsu();">
					 		<c:forEach var="Sdepartment" items="${ sdList }">
					 			<option value="<c:out value="${Sdepartment.sdeptCode}" />"><c:out value="${Sdepartment.sdeptName}"/></option>
							</c:forEach>
							</select>
							&nbsp;&nbsp;&nbsp; <strong>이수구분</strong> : 
							<select name="allIsu" id="allIsu" class="Layer1" onchange="javascript:setLecture();">
								<option value="ALL">* 전체 *</option>
								<option value="교필">교필</option>
								<option value="교선">교선</option>
								<option value="전필">전필</option>
								<option value="전선">전선</option>
							</select>
							
							&nbsp;&nbsp;&nbsp; <strong>과목</strong> : 
							<select name="allLecture" id="allLecture" class="Layer1" style="background-color: #FFD9EC;">
								<option value="SUB100">1인미디어만들기 [KY508]</option>
								<option value="SUB101">1인미디어만들기 [KY508]</option>
								<option value="SUB102">1인미디어만들기 [KY508]</option>
								<option value="SUB103">1인미디어만들기 [KY508]</option>
								<option value="SUB104">1인미디어만들기 [KY508]</option>
								<option value="SUB105">1인미디어만들기 [KY508]</option>
								<option value="SUB106">1인미디어만들기 [KY508]</option>
								<option value="SUB107">1인미디어만들기 [KY508]</option>
								<option value="SUB108">1인미디어만들기 [KY508]</option>
								<option value="SUB109">1인미디어만들기 [KY508]</option>
								<option value="SUB110">1인미디어만들기 [KY508]</option>
								<option value="SUB111">1인미디어만들기 [KY508]</option>
								<option value="SUB112">1인미디어만들기 [KY508]</option>
								<option value="SUB113">1인미디어만들기 [KY508]</option>
								<option value="SUB114">1인미디어만들기 [KY508]</option>
								<option value="SUB115">1인미디어만들기 [KY508]</option>
								<option value="SUB116">1인미디어만들기 [KY508]</option>
								<option value="SUB117">1인미디어만들기 [KY508]</option>
								<option value="SUB118">1인미디어만들기 [KY508]</option>
								<option value="SUB119">1인미디어만들기 [KY508]</option>
								<option value="SUB120">1인미디어만들기 [KY508]</option>
								<option value="SUB121">1인미디어만들기 [KY508]</option>
								<option value="SUB122">1인미디어만들기 [KY508]</option>
								<option value="SUB123">1인미디어만들기 [KY508]</option>
								<option value="SUB124">1인미디어만들기 [KY508]</option>
								<option value="SUB125">1인미디어만들기 [KY508]</option>
								<option value="SUB126">1인미디어만들기 [KY508]</option>
								<option value="SUB127">1인미디어만들기 [KY508]</option>
								<option value="SUB128">1인미디어만들기 [KY508]</option>
								<option value="SUB129">1인미디어만들기 [KY508]</option>
								<option value="SUB130">1인미디어만들기 [KY508]</option>
								<option value="SUB131">1인미디어만들기 [KY508]</option>
								<option value="SUB132">1인미디어만들기 [KY508]</option>
								<option value="SUB133">1인미디어만들기 [KY508]</option>
								<option value="SUB134">1인미디어만들기 [KY508]</option>
								<option value="SUB135">1인미디어만들기 [KY508]</option>
								<option value="SUB136">1인미디어만들기 [KY508]</option>
								<option value="SUB137">1인미디어만들기 [KY508]</option>
								<option value="SUB138">1인미디어만들기 [KY508]</option>
								<option value="SUB139">1인미디어만들기 [KY508]</option>
								<option value="SUB140">1인미디어만들기 [KY508]</option>
								<option value="SUB141">1인미디어만들기 [KY508]</option>
								<option value="SUB142">1인미디어만들기 [KY508]</option>
								<option value="SUB143">1인미디어만들기 [KY508]</option>
								<option value="SUB144">1인미디어만들기 [KY508]</option>
								<option value="SUB145">1인미디어만들기 [KY508]</option>
								<option value="SUB146">1인미디어만들기 [KY508]</option>
								<option value="SUB147">1인미디어만들기 [KY508]</option>
								<option value="SUB148">1인미디어만들기 [KY508]</option>
								<option value="SUB149">1인미디어만들기 [KY508]</option>
								<option value="SUB150">1인미디어만들기 [KY508]</option>
								<option value="SUB151">1인미디어만들기 [KY508]</option>
								<option value="SUB152">1인미디어만들기 [KY508]</option>
								<option value="SUB153">1인미디어만들기 [KY508]</option>
								<option value="SUB154">1인미디어만들기 [KY508]</option>
								<option value="SUB155">1인미디어만들기 [KY508]</option>
								<option value="SUB156">1인미디어만들기 [KY508]</option>
								<option value="SUB157">1인미디어만들기 [KY508]</option>
								<option value="SUB158">1인미디어만들기 [KY508]</option>
								<option value="SUB159">1인미디어만들기 [KY508]</option>
								
								
								
							</select>&nbsp;&nbsp;&nbsp;
						</span>
					</span>
					 <!-- 과목조회 -->
					 <span id="choice1" name="choice1" style="display: none;">
					 	<span>
					 		<span class="ui-widget"> 
					 			<label for="gwamok_nm">조회 : </label>
					 			<input type="text" name="gwamok_nm" id="gwamok_nm" size="20" value="과목명(코드)을 입력하세요.">
								과목 : <select name="gwamok_cd" id="gwamok_cd" class="Layer1"
									style="width: 200; background-color: #FFD9EC;">
									</select>
									&nbsp;&nbsp;&nbsp;
							</span>
						</span>
					</span>
					<!-- 교수조회 -->
					<span id="choice2" name="choice2" style="display: none">
						<span>
							<span class="ui-widget"> <label for="prof_nm">조회 : </label>
							<input type="text" name="prof_nm" id="prof_nm" size="20" value="교수명을 입력하세요.">
							교수 : <select name="allProf" id="allProf" class="Layer1"
									style="width: 150;" onchange="javascript:setProfLecture();">
								</select>&nbsp;&nbsp;&nbsp; 
							과목 : <select name="profLecture" id="profLecture" class="Layer1" style="width: 200; background-color: #FFD9EC;">
								</select>&nbsp;&nbsp;&nbsp;
							</span>
						</span>
					</span>
					<span>
						<button type="submit" style="background: red;">조회</button>
						<button type="submit" style="background: red;">예비신청</button>
					</span>
					</td>				
				</tr>
			</tbody>
		</table>
	</form>
	<table class="tableList2" style="width: 100%">
		<tbody>
			<tr>
				<th width="2%"><input type="checkbox" class="Allcheck"></th>
				<th width="3%">No</th>
				<th width="6%">이수구분</th>
				<th width="6%">학수번호</th>
				<th width="20%">교과목명</th>
				<th width="5%">학점</th>
				<th width="8%">교수</th>
				<th width="7%">교시</th>
				<th width="13%">강의실(건물명)</th>
				<th width="5%">인원</th>
				<th width="7%">계획서</th>
				<th width="7%">강의평가</th>
				<th width="11%">비고</th>
			</tr>
			<tr>
				<td colspan="14"><font color="red">☞ 조회버튼을 클릭하세요.</font></td>
			</tr>
		</tbody>
	</table>


</body>
</html>
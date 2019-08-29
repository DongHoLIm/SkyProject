<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
	rel="stylesheet">
<style>
#basic {
	padding: 10px 0px 0px 100px;
}

table.basicinfo td {
	background: #FFF;
	border: 1px solid #b3afafb3;
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
}

#t1 {
	background: #c7c5b7;
	border: 1px solid #b3afafb3;
}
</style>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.jsp" class="logo"><img
						src="resources/images/logo.png" width="150px;" height="30px;"></a>
					<ul class="icons">
						<li><a href="#" class=""><span class="label">로그인</span></a></li>
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>
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

					<table class="basicinfo">
						<h4 id="basic">복수(부) 전공</h4>
						<tr>
							<td class="td">대전공<br>분류
							</td>
							<td><select name='mulitple'>
									<option value=''>-- 선택 --</option>
									<option value='' selected>제2전공(복수전공)</option>
									<option value='' disabled>경영</option>
									<option value='' label=''>영문</option>
							</select></td>

							<td class="td">신청날짜</td>
							<td><select name='mulitple'>
									<option value=''>-- 선택 --</option>
									<option value='' selected>2019-08-28</option>
									<option value='' disabled></option>
									<option value='' label=''></option>
							</select></td>


						</tr>


						<tr>
							<td class="td">단과대학</td>
							<td><select name='mulitple'>
									<option value=''>-- 선택 --</option>
									<option value='' selected>인문대학</option>
									<option value='' disabled>공과대학</option>
									<option value='' label=''></option>
							</select></td>


							<td class="td">학부(과)</td>
							<td><select name='mulitple'>
									<option value='' selected>-- 선택 --</option>
									<option value='' selected>경영</option>
									<option value='' disabled>영문</option>
									<option value='' label=''></option>
							</select></td>

							<td class="td">전공</td>
							<td><select name='mulitple'>
									<option value=''>-- 선택 --</option>
									<option value='' selected>제2전공(복수전공)</option>
									<option value='' disabled>경영</option>
									<option value='' label=''>영문</option>
							</select></td>

						</tr>


					</table>

					<input type="button" value="신청 하기" id="modified"
						style="float: right; margin-right: 50px;">
					
					<br><br><br>
					<table class="basicinfo" id="Change">

						<h4 id="basic">신청 내역</h4>

						<thead>
							<tr>
								<th style="text-align: center" id="t1">다전공 분류</th>
								<th style="text-align: center" id="t1">단과 대학</th>
								<th style="text-align: center" id="t1">학부(과)</th>
								<th style="text-align: center" id="t1">전공</th>
								<th style="text-align: center" id="t1">신청 날짜</th>
								<th style="text-align: center" id="t1">처리 결과</th>
							</tr>
						<thead>
							<tobody>
							<tr>
								<td>경영</td>
								<td>글로벌</td>
								<td>인문</td>
								<td>영문</td>
								<td>2019-09-12</td>
								<td>승인</td>
							</tr>
							</tobody>
					</table>
				</table>
			</form>
		</div>





		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->
				<section id="search" class="alt">
					<form method="post" action="#">
						<input type="text" name="query" id="query" placeholder="Search" />
					</form>
				</section>

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2 style="font-family: 'Karla', sans-serif; font-size: 30px;">Menu</h2>
					</header>
					<ul style="font-family: 'Karla', sans-serif; font-size: 20px;">
						<li><span class="opener">학적관리</span>
							<ul style="font-family: 'Karla', sans-serif; font-size: 15px;">
								<li><a href="#">학적정보 조회</a></li>
								<li><a href="#">신상 관리</a></li>
								<li><a href="#">학적 변동 조회</a></li>
								<li><a href="#">복수(부)전공 신청</a></li>
								<li><a href="#">성적 관리</a></li>
								<li><a href="#">졸업 관리</a></li>
								<li><a href="#">휴복학 관리</a></li>
							</ul></li>
						<li><span class="opener">수업관리</span>
							<ul style="font-family: 'Karla', sans-serif; font-size: 15px;">
								<li><a href="#">수강신청</a></li>
								<li><a href="#">전체 수강과목 조회</a></li>
								<li><a href="#">병결신청</a></li>
							</ul></li>
						<li><span class="opener">등록관리</span>
							<ul style="font-family: 'Karla', sans-serif; font-size: 15px;">
								<li><a href="#">등록금 납부 결과 조회</a></li>
							</ul></li>
						<li><span class="opener">장학관리</span>
							<ul style="font-family: 'Karla', sans-serif; font-size: 15px;">
								<li><a href="#">장학금 신청</a></li>
								<li><a href="#">장학금 수혜내역 조회</a></li>

							</ul></li>
						<li><span class="opener">기숙사관리</span>
							<ul style="font-family: 'Karla', sans-serif; font-size: 15px;">
								<li><a href="#">기숙사 이용 신청</a></li>
								<li><a href="#">기숙사 신청 내역</a></li>

							</ul></li>

						<li><span class="opener">정보생활</span>

							<ul style="font-family: 'Karla', sans-serif; font-size: 15px;">

								<h4 style="font-family: 'Karla', sans-serif; font-size: 15px;">공지사항</h4>

								<li><a href="#">일반 공지</a></li>
								<li><a href="#">장학 공지</a></li>
								<li><a href="#">학사 일정</a></li>
								<li><a href="#">교내외 행사</a></li>

								<hr>

								<h4 style="font-family: 'Karla', sans-serif; font-size: 15px;">학교
									생활</h4>
								<li><a href="#">학교 행사</a></li>
								<li><a href="#">자유게시판 </a></li>
								<li><a href="#">내 게시물 조회 </a></li>

								<hr>

								<h4 style="font-family: 'Karla', sans-serif; font-size: 15px;">메일함</h4>
								<li><a href="#">웹 메일</a></li>

								<hr>

								<h4 style="font-family: 'Karla', sans-serif; font-size: 15px;">인터넷
									제증명</h4>
								<li><a href="#">재학 증명서 출력</a></li>

								<hr>

								<h4 style="font-family: 'Karla', sans-serif; font-size: 15px;">시스템
									문의</h4>
								<li><a href="#">이메일 문의 </a></li>
								<li><a href="#">내 문의 내역 조희 </a></li>


							</ul></li>


					</ul>
				</nav>


				<section>
					<header class="major">
						<h2>Get in touch</h2>
					</header>
					<p>Sed varius enim lorem ullamcorper dolore aliquam aenean
						ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin
						sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
						tempus aliquam.</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
						<li class="icon solid fa-phone">(000) 000-0000</li>
						<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
							Nashville, TN 00000-0000
						</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">
						&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a
							href="https://html5up.net">HTML5 UP</a>.
					</p>
				</footer>

			</div>
		</div>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>
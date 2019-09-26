<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>ㅇㅇ</title>
		<meta charset="utf-8" />
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					
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
										<h2>Menu</h2>
									</header>
									<ul>
										<li>
											<span class="opener">학적관리</span>
											<ul>
												<li><a href="st_studentInfo.si">학적정보 조회</a></li>
												<li><a href="st_personalInfo.si">신상 관리</a></li>
												<li><a href="#">학적 변동 조회</a></li>
												<li><a href="#">성적 관리</a></li>
												<li><a href="st_graduation.si">졸업 관리</a></li>
												<li><a href="st_schoolOff.si">휴학신청 관리</a></li>
												<li><a href="st_schoolOn.si">복학신청 관리</a></li>
												<li><a href="st_showSecondMajor.si">다전공 신청</a></li>
												<li><a href="st_showChangeMajor.si">전과 신청</a></li>
												<li><a href="st_showDropOut.si">자퇴 신청</a></li>
											</ul>
										</li>
											<li>
											<span class="opener">수업관리</span>
											<ul>
												<li><a href="#" onclick="window.open('goSugang.st', 'SKY 수강신청'); return false">과목조회, 수강신청</a></li>
												<li><a href="#">병결신청</a></li>
												<li><a href="st_showLectureEvaluationOpen.le">강의평가</a></li>
											</ul>
										</li>
											<li>
											<span class="opener">등록관리</span>
											<ul>
												<li><a href="enrollment.en">등록금 납부 결과 조회</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">장학관리</span>
											<ul>
												<li><a href="applyView.sc">장학금 신청</a></li>
												<li><a href="scholarship.sc">장학금 수혜내역 조회</a></li>
											
											</ul>
										</li>
											<li>
											<span class="opener">기숙사관리</span>
											<ul>
												<li><a href="apply.dor">기숙사 이용 신청</a></li>
												<li><a href="dormitory.dor">기숙사 신청 내역</a></li>
											
											</ul>
										</li>
						
										<li>
											<span class="opener">정보생활</span>
										
											<ul>
									
												<h4>공지사항</h4>
												
												<li><a href="st_nNoticeList.bo">일반 공지</a></li>
												<li><a href="st_showsNoticeList.bo">장학 공지</a></li>
												<li><a href="st_acNoticeList.bo">학사 일정</a></li>
												<li><a href="st_eNoticeList.bo">교내외 행사</a></li>
												
												<hr>
												
												<h4>학교 생활</h4>
												<li><a href="st_praiseBoardList.bo">칭찬합시다</a></li>
												<li><a href="st_freeBoardList.bo">자유게시판</a></li>
												<li><a href="st_searchMyBoardList.bo?memberId=${sessionScope.loginUser.memberId}">내 게시물 조회</a></li>
												
												<hr>												
												
												<h4>인터넷 제증명</h4>
												<li><a href="showProof.pf">증명서 발급 신청</a></li>
												<li><a href="showProofPrint.pf">증명서 발급 내역</a></li>
										
												<hr>
												
												<h4>시스템 문의</h4>
												<li><a href="st_systemQuestionList.bo?memberId=${sessionScope.loginUser.memberId}">시스템 문의 하기</a></li>
												
												
											</ul>
										</li>
					
							
									</ul>
								</nav>
							<!-- Section -->
								<section>
									<header class="major">
										<h2>Get in touch</h2>
									</header>
									<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
										<li class="icon solid fa-phone">(000) 000-0000</li>
										<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>
				
				
			</div>

		<!-- Scripts -->
			<script src="resources/js/jquery.min.js"></script>
			<script src="resources/js/browser.min.js"></script>
			<script src="resources/js/breakpoints.min.js"></script>
			<script src="resources/js/util.js"></script>
			<script src="resources/js/main.js"></script>

	</body>
</html>
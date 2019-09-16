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
	<c:set var="ac" value="${sessionScope.Account}"/>	
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
										<c:if test="${ac.classManager eq '0'}">
										<li>
											<span class="opener">수업관리</span>
											<ul>
												<li><h4>강의관리</h4></li>
												<li><a href="lectureOpen.em" >강의 개설</a></li>
												<li><a href="#">강의 폐지</a></li>
												<li><a href="#">개설/폐지 조회</a></li>
												<li><a href="#">수강인워관리</a></li>
												<li><a href="#">시간표조정</a></li>
												<li><a href="#">강의계획서조회</a></li>
												<li><a href="#">강의평가서작성</a></li>
												<li><a href="#">강의평가 조회</a></li>
												<li><a href="#">휴강 및 보강 관리</a></li>
												<li><h4>수강신청관리</h4></li>
												<li><a href="openCourseRegistration.em">수강신청열기</a></li>
											</ul>
										</li>
										</c:if>
										<c:if test="${ac.scholarlyManager eq '0' }">
											<li>
											<span class="opener">학적관리</span>
											<ul>
												<li><h4>학생관리</h4></li>
												<li><a href="em_studentInfoList.si">학생 전체 조회</a></li>
												<li><a href="#">학사경고 관리</a></li>
												<li><a href="#">자퇴처리</a></li>
												<li><a href="#">제적처리</a></li>
												<li><a href="#">휴,복학 처리</a></li>
												<li><a href="#">학적부 정정</a></li>												
												<li><h4>졸업관리</h4></li>
												<li><a href="#">졸업 기준 수정</a></li>
												<li><a href="#">학과별 졸업 기준 수정</a></li>
												<li><h4>전공관리</h4></li>
												<li><a href="">전공신청 처리</a></li>
												<li><a href="">다전공 신청 처리</a></li>
											</ul>
										</li>
										</c:if>
										<c:if test="${ac.enrollManager eq '0'}">
											<li>
											<span class="opener">등록관리</span>
											<ul>
												<li><a href="#">학생 별 등록금 관리</a></li>
											</ul>
										</li>
										</c:if>
										<c:if test="${ac.scholManager eq '0'}">
										<li>
											<span class="opener">장학관리</span>
											<ul>
												<li><a href="#">학생 별 장학금 내역관리</a></li>
												<li><a href="#">학생 별 장학금 신청관리</a></li>
											
											</ul>
										</li>
										</c:if>
										<c:if test="${ac.dormitoryManager eq '0' }">
											<li>
											<span class="opener">기숙사관리</span>
											<ul>
												<li><a href="#">기숙사 신청 관리</a></li>
												<li><a href="#">기숙사 시설 관리</a></li>
											
											</ul>
										</li>
										</c:if>
										<c:if test="${ac.boardManager eq '0'}">
										<li>
											<span class="opener">정보생활</span>										
											<ul>
									
												<li><h4>공지사항</h4></li>
												
												<li><a href="em_nNoticeList.bo">일반 공지</a></li>
												<li><a href="em_showsNoticeList.bo">장학 공지</a></li>
												<li><a href="em_acNoticeList.bo">학사 일정</a></li>
												<li><a href="em_eNoticeList.bo">교내외 행사</a></li>
												
												<li><hr></li>
												
												<li><h4>학교 생활</h4></li>
												<li><a href="em_praiseBoardList.bo">칭찬합시다</a></li>
												<li><a href="em_freeBoardList.bo">자유게시판</a></li>
												<li><a href="em_searchMyBoardList.bo?memberId=${sessionScope.loginUser.memberId}">내 게시물 조회</a></li>
												
												<li><hr></li>
												
												<li><h4>메일함</h4></li>
												<li><a href="#">웹 메일</a></li>							
											
												<li><hr></li>
												
												<h4>시스템 문의</h4>
												<li><a href="em_systemQuestionList.bo?memberId=${sessionScope.loginUser.memberId}">시스템 문의</a></li>
												
												
											</ul>
										</li>
										</c:if>
										<c:if test="${ac.employeeNo eq 'emp'}">
										<li>
											<span class="opener">시스템 계정관리</span>
											<ul>
												<li><h4>시스템 계정관리</h4></li>
												<li><a href="MemberListview.me">계정 조회및 수정</a></li>
												<li><a href="insert.me">계정 발급</a></li>
												<li><a href="account.me">권한부여/수정</a></li>
											</ul>
										</li>
										</c:if>
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
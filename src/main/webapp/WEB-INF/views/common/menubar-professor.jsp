
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
							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h1>Menu</h1>
									</header>
									<ul>
										<li>
											<span class="opener">공통관리</span>
											<ul>
												<li><h4>문자보내기</h4></li>
												<li><a href="sendSMS.pro">SMS 보내기</a></li>
												<li><a href="SMSList.pro">SMS 전송내역 조회</a></li>												
											</ul>
										</li>
											<li>
											<span class="opener">학적관리</span>
											<ul>
												<li><h4>학적정보조회</h4></li>
												<li><a href="stuInfo.pro">정보조회하기</a></li>
												<li><h4>자퇴관리</h4></li>												
												<li><a href="pro_showDropOut.si">자퇴 신청 관리</a></li>
											</ul>
										</li>
											<li>
											<span class="opener">수업관리</span>
											<ul>
												<li><a href="opensubject.pro">강의 계획서 입력,수정</a></li>												
												<li><a href="pro_showLectureEvaluation.le">강의 평가 조회</a></li>																							
											</ul>
										</li>
										<li>
											<span class="opener">성적관리</span>
											<ul>
												<li><a href="resultInsert.pror">성적입력/수정</a></li>												
												<li><a href="searchResult.pror">성적조회</a></li>
											</ul>
										</li>					
										<li>
											<span class="opener">정보생활</span>										
											<ul>
									
												<li><h4>공지사항</h4></li>
												
												<li><a href="pro_nNoticeList.bo">일반 공지</a></li>
												<li><a href="pro_showsNoticeList.bo">장학 공지</a></li>
												<li><a href="pro_acNoticeList.bo">학사 일정</a></li>
												<li><a href="pro_eNoticeList.bo">교내외 행사</a></li>
												
												<li><hr></li>
												
												<li><h4>학교 생활</h4></li>
												<li><a href="pro_praiseBoardList.bo">칭찬합시다</a></li>
												<li><a href="pro_freeBoardList.bo">자유게시판</a></li>
												<li><a href="pro_searchMyBoardList.bo?memberId=${sessionScope.loginUser.memberId}">내 게시물 조회</a></li>
												
												<li><hr></li>									
												
												<li><h4>시스템 문의</h4></li>
												<li><a href="pro_systemQuestionList.bo?memberId=${sessionScope.loginUser.memberId}">시스템 문의 하기</a></li>
												
												
											</ul>
										</li>
					
							
									</ul>
								</nav>
							<!-- Section -->
								<section>
									<header class="major">
									<img src="resources/images/logo.png" width="200x;" height="50px;">										
										<!--  <h2>KH UNIVERCITY</h2>  -->
									</header>						
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">KH.UNIVERCITY@KH.COM</a></li>
										<li class="icon solid fa-phone">1544-9970</li>
										<li class="icon solid fa-home">서울특별시 강남구 테헤란로14길 6 남도빌딩 2F, 3F, 4F, 5F<br />
										</li>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
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

#menu ul li a:hover, #menu ul li.Notice a {
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
			<li style="width: 23.0%; text-align: center;" class="Notice"><a
				href="goNotice.st">공지사항</a></li>
			<li style="width: 23.0%; text-align: center;" class="CourseInquiry"><a
				>교과목조회</a></li>
			<li style="width: 23.0%; text-align: center;" class="SpareEnrolMent"><a
				href="#">예비수강신청목록</a></li>
			<li style="width: 23.0%; text-align: center;" class="EnrolMent"><a
				href="#">수강신청</a></li>
		</ul>
	</div>
	<br><br>
	<div class="tab_content">
	
	</div>
</body>

	<script>
		$(function() {
			$(".Notice").click(function(){
				$(".Notice").css("background","darkgray");
				$(".CourseInquiry").css("background","");
				$(".tab_content").load("Notice.jsp");
			});
		});
		$(function() {
			$(".CourseInquiry").click(function(){
				$(".CourseInquiry").css("background","darkgray");
				$(".Notice").css("background","");
				$(".tab_content").load("courseInquiry.jsp");
			});
		});
	</script>
</html>
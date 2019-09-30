<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	background: lightgray;
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
	color: black;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	/* $('ul li a').click(function() {
	   /*  $(this).parent().addClass('active').siblings().removeClass('active');
	    return false;
	    console.log(asd); 
	    console.log("들어옴??");
	}); */
	
		
	$("#menu ").on("click","ul li",function(){
		console.log($(this).parent());
		$(this).addClass('active').siblings().removeClass('active');
	});
	
</script>
</head>
<body>
	<div id="menu" class="menu">
		<ul>
			<li style="width: 25.0%; text-align: center;"><a
				href="goNotice.st">공지사항</a></li>
			<li style="width: 25.0%; text-align: center;" ><a
				href="goCourseInquiry.st">교과목조회</a></li>
			<li style="width: 25.0%; text-align: center;"><a
				href="goPreliminaryCourse.st">예비수강신청목록</a></li>
			<li style="width: 25.0%; text-align: center;"><a
				href="goCourseApply.st">수강신청</a></li>
		</ul>
	</div>
</body>
</html>
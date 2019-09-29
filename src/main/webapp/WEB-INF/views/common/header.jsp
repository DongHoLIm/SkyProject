<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
function messageOpen(){
	console.log("123");
	window.open("/finalProject/inbox.pro", "쪽지함", width="700px", height="500px");
};
function vCTM(){	
	location.href="viewChangToMain.me";
}
</script>
<style>
	#headerImg{
		width: 20%;
	}
	#imgHeader{
		cursor: pointer;
	}
</style>
<title>header</title>
</head>
<body>

	<header id="header">
		<div id="headerImg">
		<img src="resources/images/logo.png" id="imgHeader"onclick="vCTM();">
		</div>
		<ul class="icons">
			<li><h4><a href="checkPwd.me">${loginUser.memberKName}</a></h4></li>
			<li><a href="#" onclick="messageOpen();" class="icon solid fa-paper-plane" id="message"></a><span class="label"></span></li>
			<li><a href="logOut.me" class="button primary ">LogOut</a></li>		
		</ul>
	</header>

</body>

</html>
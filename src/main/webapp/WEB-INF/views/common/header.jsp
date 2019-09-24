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

function goCheckPwd(){
	
}
</script>
<title>header</title>
</head>
<body>

	<header id="header">
		<a href="viewChangToMain.me" class="logo"><img
			src="resources/images/logo.png" width="150px;" height="30px;"></a>
		<ul class="icons">
			<li><a href="checkPwd.me">${loginUser.memberKName}</a></li>
			<li><a href="#" onclick="messageOpen();" class="icon solid fa-paper-plane" id="message"></a><span class="label"></span></li>
			<li><a href="logOut.me" class="button primary small">LogOut</a></li>		
		</ul>
	</header>

</body>

</html>
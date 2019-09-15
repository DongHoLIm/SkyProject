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
<title>header</title>
</head>
<body>

	<header id="header">
		<a href="index.jsp" class="logo"><img
			src="resources/images/logo.png" width="150px;" height="30px;"></a>
		<ul class="icons">
			<li><a href="#">${loginUser.memberKName}</a></li>
			<li><a href="#" class="icon solid fa-paper-plane"></a><span class="label"></span></li>
			<li><a href="logOut.me" class="button primary small">LogOut</a></li>		
		</ul>
	</header>
</body>
</html>
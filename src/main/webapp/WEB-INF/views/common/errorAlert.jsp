<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>에러 메세지</title>
</head>
<body>
<input type="hidden" value="${msg}" id="errorMessage"/>
<script>
$(function(){
	var errorMessage = $("#errorMessage").val();
	alert(errorMessage);
	history.back();
});
	
</script>

</body>
</html>
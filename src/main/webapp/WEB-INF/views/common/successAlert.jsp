<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>신청성공</title>
</head>
<body>
<input type="hidden" value="완료" id="successMessage"/>
<script>
$(function(){
	var successMessage = $("#successMessage").val();
	alert(successMessage);
	location.href="applyCancle.dor"
});
</script>

</body>
</html>
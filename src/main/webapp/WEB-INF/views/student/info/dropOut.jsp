<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사 관리 시스템</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
	#basic {
	   padding: 10px 0px 0px 100px;
	}
	
	table.basicinfo td {
	   background: #FFF;
	}
	
	td.td {
	   text-align: center;
	   background: #c7c5b7 !important;
	   color: black;
	   width: 100px !important;
	}
	
	.basicinfo{
	   width: 85%;
	   border: 1px solid #dde1e3;
	   margin-left: auto;
	   margin-right: auto;
	}
	
	#Change {
	   text-align: center;
	   border: 1px solid #dde1e3;
	}
	
	#t1 {
	   background: #c7c5b7;
	   border: 1px solid #dde1e3;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
						
			<jsp:include page="../info/common.jsp"/>			

			</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>
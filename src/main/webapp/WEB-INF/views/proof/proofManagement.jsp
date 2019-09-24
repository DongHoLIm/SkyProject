<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	th {
		background: #E5E6E7;
		text-align: center;
	}
	
	td {
		background: white;
		text-align: center;
	}
	
	.applyArea {
		width: 88.5%;
		text-align: center;
		margin: 0 auto;
	}
	
	.showSpan:hover {
		cursor: pointer;
		color: red;
	}
	
	.printSpan:hover {
		cursor: pointer;
		color: red;
	}
</style>
<script>
	$(function(){
		$.ajax({
			url:"selectProofList.pf",
			type:"POST",
			success:function(data){
				var $tbody = $("#tbody");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>");
					var $span2 = $("<span>");
					
					$td1.text(data.list[i].printCode);
					$td2.text(data.list[i].certiName);
					$td3.text(data.list[i].printCount);
					$td4.text(data.list[i].printDate);
					
					$span1.text("조회");
					$span1.addClass("showSpan");
					
					$span2.text("발급");
					$span2.addClass("printSpan");
					
					$td5.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					
					if(data.list[i].printStatus == 'N'){
						$td6.html($span2);
						$tr.append($td6);						
					}else if(data.list[i].printStatus == 'Y'){
						$td6.text("발급완료");
						$tr.append($td6);
					}
					
					$tbody.append($tr);
				}
				
				$(".showSpan").click(function(){
					var certiName = $(this).parent().parent().children().eq(1).text();	
					var printCode = $(this).parent().parent().children().eq(0).text();	
					var location ="showPrintCerti.pf?certiName=" + certiName + "&printCode=" + printCode;
					
					window.open(location, "_blank", "width=700, height=800");
				});
				
				$(".printSpan").click(function(){
					var certiName = $(this).parent().parent().children().eq(1).text();	
					var printCode = $(this).parent().parent().children().eq(0).text();	
					var location ="printProof.pf?certiName=" + certiName + "&printCode=" + printCode;
					
					window.open(location, "_blank", "width=700, height=800");
					
					$(this).html("");
					$(this).removeClass();
					$(this).text("발급완료");
				});
			}
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<input type="hidden" name="memberId" id="memberId" value="${loginUser.memberId}">
			<h4 style="padding: 10px 0px 0px 100px;">제증명 발급 내역</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
				
			<br><br>
			<div class="infoArea">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;">
					<thead>
						<tr>
							<th style="text-align: center">발급 번호</th>
							<th style="text-align: center">증명서 </th>
							<th style="text-align: center">부수</th>
							<th style="text-align: center">발급일</th>
							<th style="text-align: center"></th>
							<th style="text-align: center"></th>
						</tr>
					</thead>
					<tbody id="tbody">
							
					</tbody>
				</table>
			</div>
			<div>
				<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
			</div>
		</div>
	</div>		
</body>
</html>
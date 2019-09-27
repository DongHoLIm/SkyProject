<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학적 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.updateAccount{
		display: inline-block;
	}
	#stuList{
		text-align: center;
	}
	#stuList thead tr th{
		text-align:center;
	}
	#stuList tbody tr:hover{
		color:black;
	}
	.page {
		cursor: pointer;
	}
</style>
<script>

	$(function() {
		$("#searchConditionController").change(function() {
			var value = $(this).val();
			if (value == 'etc') {
			$("#searchBar").remove();
			var $select = $("<select name='searchCondition' id='searchBar'>");
			var $option1 = $("<option value='재학생'>").text("재학생");
		  	var $option2 = $("<option value='졸업생'>").text("졸업생");										
			var $option3 = $("<option value='휴학생'>").text("휴학생");
				$select.append($option1);
				$select.append($option2);								
				$select.append($option3);
				$("#inputArea").append($select);
			} else {
				$("#searchBar").remove();
			var $input = $("<input type='text' name='searchValue' id='searchBar'>")
			$("#inputArea").append($input);
			}
		});
});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br />
				<h3 class="updateAccount">학적 조회</h3>
				<div style="float: right;" class="updateAccount">			
				<span class="updateAccount">
					<select name="searchCondition" id="searchConditionController" >
						<option value="name">이름으로 검색</option>
						<option value="etc">상태 검색</option>
					</select>
				</span>			
				<span class="updateAccount" id="inputArea">
					<input type="text" name="searchValue" id="searchBar"/>
				</span>
				<span class="updateAccount">
					<button onclick="searchBtn();">SEARCH</button>
				</span>				
				</div>
				<hr />
				<br />
				<table id="stuList">
					<thead>
						<tr>
							<th>번호</th>
							<th>학번</th>
							<th>이름(한글)</th>
							<th>이름(영어)</th>
							<th>학년</th>
							<th>상태</th>
						</tr>
					</thead>
					 <tbody>
					 	<c:forEach var="listStu" items="${list }" varStatus="status">
					 		<tr>
					 			<td><c:out value="${status.count}"></c:out></td>
					 			<td><c:out value="${listStu.memberId }"/></td>
					 			<td><c:out value="${listStu.memberKName }"/></td>
					 			<td><c:out value="${listStu.memberEName }"/></td>
					 			<td><c:out value="${listStu.grade }학년"></c:out></td>
					 			<td><c:out value="${listStu.stuStatus }"/></td>
					 		</tr>
					 	</c:forEach>
					 </tbody>
					 <tfoot>
					 	<tr>
					 		<td colspan="6">
					 		<c:set var="pageInfo" value="${pi }" />
						<ul class="pagination" align="center">
							<c:if test="${pi.currentPage<=1 }">
								<li><span class="button disabled">Prev</span></li>
							</c:if>
							<c:if test="${pi.currentPage>1 }">
								<li><span class="button" id="prevBtn" onclick="goPre()">Prev</span></li>
							</c:if>
							<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
								<c:if test="${p eq pi.currentPage }">
									<li class="pageNumber"><p class="page active">${p}</p></li>
								</c:if>
								<c:if test="${p ne pi.currentPage }">
									<li class="pageNumber"><a class="page">${p}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pi.currentPage < pi.maxPage }">
								<li><span class="button" id="nextBtn" onclick="goNext()">next</span></li>
							</c:if>
							<c:if test="${pi.currentPage ==pi.maxPage }">
								<li><span class="button disabled">Next</span></li>
							</c:if>
						</ul></td>
					 	</tr>
					 </tfoot>
				</table>
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-professor.jsp" />
		</div>
	</div>
	<script>
	$(".page").click(function(){
			var currentPage = $(this).text();
		$.ajax({
			url:"ajaxStuPaging.pro",
			type:"post",
			data:{"currentPage":currentPage},
			success:function(data){
					
				$("#stuList >tbody ").empty();	
			for(var i =0;i<data.list.length;i++){				
				var $tr = $("<tr>");
				var $td = $("<td>");
				var $td1 = $("<td>");
				var $td2 = $("<td>");
				var $td3 = $("<td>");
				var $td4 = $("<td>");
				var $td5 = $("<td>")
					$td.text(i+1);
					$td1.text(data.list[i].memberId);
					$td2.text(data.list[i].memberKName);
					$td3.text(data.list[i].memberEName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].stuStatus);
					$tr.append($td);
 					$tr.append($td1);
 					$tr.append($td2);
 					$tr.append($td3);
 					$tr.append($td4);
 					$tr.append($td5);
 					$("#stuList>tbody").append($tr); 	
					}
			
			$("#stuList > tfoot tr").eq(0).empty();
				var $td6 = $("<td colspan='6'>");
				var $ul  =$("<ul class='pagination' align='center'>");
				var $li =$("<li>");
				var $li1 =$("<li>");
				var $li2=$("<li>");	 					 					
				var $li3 =$("<li>");
				var $disabledPrevspan = $("<span class='button disabled' >").text('Prev');
				var $abledPrevSpan = $("<span class='button' id='prevBtn' onclick='goPre()'>").text("Prev");
				var $disabledNextSpan=$("<span class='button disabled'>").text("Next");
				var $abledNextSpan= $("<span class='button' id='nextBtn' onclick='goNext()'>").text("Next");
				
				if(data.pi.currentPage<=1){
					$li.append($disabledPrevspan);
					$ul.append($li);
				}else {
					$li1.append($abledPrevSpan);
					$ul.append($li1);
				}
				for(var i= data.pi.startPage;i<=data.pi.endPage;i++){
					var $a =$("<a class='page' onclick='reajax("+i+")'>").text(i);
					var $p =$("<p class='page active'>").text(i);
					var $li4 =$("<li class='pageNumber'>");	
					if(i==data.pi.currentPage){
						$li4.append($p);
						$ul.append($li4);
					}else{	 							
						$li4.append($a);
						$ul.append($li4);
					}
				}
				if(data.pi.currentPage<data.pi.maxPage){
					$li2.append($abledNextSpan);
					$ul.append($li2);
				}else{
					$li3.append($disabledNextSpan);
					$ul.append($li3);
				}
				$td6.append($ul);
				$("#stuList > tfoot tr").eq(0).append($td6);
				$("#stuList tbody tr").click(function(){
					var memberId = $(this).children().eq(1).text();	
					window.open("em_selectStudent.si?id="+memberId,"학적상세조회","width='120px'")
				});
				}

			});

		});
	function reajax(index){
		 var currentPage = index;
		 $.ajax({
				url:"ajaxStuPaging.pro",
				type:"post",
				data:{"currentPage":currentPage},
				success:function(data){
				
					$("#stuList >tbody ").empty();	
				for(var i =0;i<data.list.length;i++){				
					var $tr = $("<tr>");
					var $td = $("<td>");
					var $td1 = $("<td>");
					var $td2 = $("<td>");
					var $td3 = $("<td>");
					var $td4 = $("<td>");
					var $td5 = $("<td>")
						$td.text(i+1);
						$td1.text(data.list[i].memberId);
						$td2.text(data.list[i].memberKName);
						$td3.text(data.list[i].memberEName);
						$td4.text(data.list[i].grade);
						$td5.text(data.list[i].stuStatus);
						$tr.append($td);
	 					$tr.append($td1);
	 					$tr.append($td2);
	 					$tr.append($td3);
	 					$tr.append($td4);
	 					$tr.append($td5);
	 					$("#stuList>tbody").append($tr); 	
						}
				
				$("#stuList > tfoot tr").eq(0).empty();
					var $td6 = $("<td colspan='6'>");
					var $ul  =$("<ul class='pagination' align='center'>");
					var $li =$("<li>");
					var $li1 =$("<li>");
					var $li2=$("<li>");	 					 					
					var $li3 =$("<li>");
					var $disabledPrevspan = $("<span class='button disabled' >").text('Prev');
					var $abledPrevSpan = $("<span class='button' id='prevBtn' onclick='goPre()'>").text("Prev");
					var $disabledNextSpan=$("<span class='button disabled'>").text("Next");
					var $abledNextSpan= $("<span class='button' id='nextBtn' onclick='goNext()'>").text("Next");
					
					if(data.pi.currentPage<=1){
						$li.append($disabledPrevspan);
						$ul.append($li);
					}else {
						$li1.append($abledPrevSpan);
						$ul.append($li1);
					}
					for(var i= data.pi.startPage;i<=data.pi.endPage;i++){
						var $a =$("<a class='page' onclick='reajax("+i+")'>").text(i);
						var $p =$("<p class='page active'>").text(i);
						var $li4 =$("<li class='pageNumber'>");	
						if(i==data.pi.currentPage){
							$li4.append($p);
							$ul.append($li4);
						}else{	 							
							$li4.append($a);
							$ul.append($li4);
						}
					}
					if(data.pi.currentPage<data.pi.maxPage){
						$li2.append($abledNextSpan);
						$ul.append($li2);
					}else{
						$li3.append($disabledNextSpan);
						$ul.append($li3);
					}
					$td6.append($ul);
					$("#stuList > tfoot tr").eq(0).append($td6);
					$("#stuList tbody tr").click(function(){
						var memberId = $(this).children().eq(1).text();	
						window.open("em_selectStudent.si?id="+memberId,"학적상세조회","width='120px'")
					});
					}

				});
		
	}
	function goNext(){			
			var currentPage = $("p[class='page active']").text();
			var nextPage = Number(currentPage);
			console.log(nextPage+1);
			reajax(nextPage+1);	
	}
	function goPre(){		
			var currentPage = $("p[class='page active']").text();
			var prePage = Number(currentPage);
			console.log(prePage-1);
			reajax(prePage-1);	
	}
	function searchBtn(){
		var standard =$("#searchConditionController").val();
		var value = $("#searchBar").val();
		$.ajax({
			url:"searchStuList.pro",
			type:"post",
			data:{"value":value,"standard":standard},
			success:function(data){
				$("#stuList >tbody ").empty();	
				for(var i =0;i<data.list.length;i++){				
					var $tr = $("<tr>");
					var $td = $("<td>");
					var $td1 = $("<td>");
					var $td2 = $("<td>");
					var $td3 = $("<td>");
					var $td4 = $("<td>");
					var $td5 = $("<td>")
						$td.text(i+1);
						$td1.text(data.list[i].memberId);
						$td2.text(data.list[i].memberKName);
						$td3.text(data.list[i].memberEName);
						$td4.text(data.list[i].grade);
						$td5.text(data.list[i].stuStatus);
						$tr.append($td);
	 					$tr.append($td1);
	 					$tr.append($td2);
	 					$tr.append($td3);
	 					$tr.append($td4);
	 					$tr.append($td5);
	 					$("#stuList>tbody").append($tr); 	
						}
				
				$("#stuList > tfoot tr").eq(0).empty();
					var $td6 = $("<td colspan='6'>");
					var $ul  =$("<ul class='pagination' align='center'>");
					var $li =$("<li>");
					var $li1 =$("<li>");
					var $li2=$("<li>");	 					 					
					var $li3 =$("<li>");
					var $disabledPrevspan = $("<span class='button disabled' >").text('Prev');
					var $abledPrevSpan = $("<span class='button' id='prevBtn' onclick='goPre1()'>").text("Prev");
					var $disabledNextSpan=$("<span class='button disabled'>").text("Next");
					var $abledNextSpan= $("<span class='button' id='nextBtn' onclick='goNext1()'>").text("Next");
					
					if(data.pi.currentPage<=1){
						$li.append($disabledPrevspan);
						$ul.append($li);
					}else {
						$li1.append($abledPrevSpan);
						$ul.append($li1);
					}
					for(var i= data.pi.startPage;i<=data.pi.endPage;i++){
						var $a =$("<a class='page' onclick='reajax1("+i+")'>").text(i);
						var $p =$("<p class='page active'>").text(i);
						var $li4 =$("<li class='pageNumber'>");	
						if(i==data.pi.currentPage){
							$li4.append($p);
							$ul.append($li4);
						}else{	 							
							$li4.append($a);
							$ul.append($li4);
						}
					}
					if(data.pi.currentPage<data.pi.maxPage){
						$li2.append($abledNextSpan);
						$ul.append($li2);
					}else{
						$li3.append($disabledNextSpan);
						$ul.append($li3);
					}
					$td6.append($ul);
					$("#stuList > tfoot tr").eq(0).append($td6);
					$("#stuList tbody tr").click(function(){
						var memberId = $(this).children().eq(1).text();	
						window.open("em_selectStudent.si?id="+memberId,"학적상세조회","width='120px'")
					});
			}
		});
	}
	function goNext1(){			
		var currentPage = $("p[class='page active']").text();
		var nextPage = Number(currentPage);
		console.log(nextPage+1);
		reajax1(nextPage+1);	
	}
	function goPre1(){		
			var currentPage = $("p[class='page active']").text();
			var prePage = Number(currentPage);
			console.log(prePage-1);
			reajax1(prePage-1);	
	}
	function reajax1(index){
		 var currentPage = index;
		 var standard =$("#searchConditionController").val();
			var value = $("#searchBar").val();
		 $.ajax({
				url:"searchStuList.pro",
				type:"post",
				data:{"currentPage":currentPage,"value":value,"standard":standard},
				success:function(data){
				
					$("#stuList >tbody ").empty();	
				for(var i =0;i<data.list.length;i++){				
					var $tr = $("<tr>");
					var $td = $("<td>");
					var $td1 = $("<td>");
					var $td2 = $("<td>");
					var $td3 = $("<td>");
					var $td4 = $("<td>");
					var $td5 = $("<td>")
						$td.text(i+1);
						$td1.text(data.list[i].memberId);
						$td2.text(data.list[i].memberKName);
						$td3.text(data.list[i].memberEName);
						$td4.text(data.list[i].grade);
						$td5.text(data.list[i].stuStatus);
						$tr.append($td);
	 					$tr.append($td1);
	 					$tr.append($td2);
	 					$tr.append($td3);
	 					$tr.append($td4);
	 					$tr.append($td5);
	 					$("#stuList>tbody").append($tr); 	
						}
				
				$("#stuList > tfoot tr").eq(0).empty();
					var $td6 = $("<td colspan='6'>");
					var $ul  =$("<ul class='pagination' align='center'>");
					var $li =$("<li>");
					var $li1 =$("<li>");
					var $li2=$("<li>");	 					 					
					var $li3 =$("<li>");
					var $disabledPrevspan = $("<span class='button disabled' >").text('Prev');
					var $abledPrevSpan = $("<span class='button' id='prevBtn' onclick='goPre1()'>").text("Prev");
					var $disabledNextSpan=$("<span class='button disabled'>").text("Next");
					var $abledNextSpan= $("<span class='button' id='nextBtn' onclick='goNext1()'>").text("Next");
					
					if(data.pi.currentPage<=1){
						$li.append($disabledPrevspan);
						$ul.append($li);
					}else {
						$li1.append($abledPrevSpan);
						$ul.append($li1);
					}
					for(var i= data.pi.startPage;i<=data.pi.endPage;i++){
						var $a =$("<a class='page' onclick='reajax1("+i+")'>").text(i);
						var $p =$("<p class='page active'>").text(i);
						var $li4 =$("<li class='pageNumber'>");	
						if(i==data.pi.currentPage){
							$li4.append($p);
							$ul.append($li4);
						}else{	 							
							$li4.append($a);
							$ul.append($li4);
						}
					}
					if(data.pi.currentPage<data.pi.maxPage){
						$li2.append($abledNextSpan);
						$ul.append($li2);
					}else{
						$li3.append($disabledNextSpan);
						$ul.append($li3);
					}
					$td6.append($ul);
					$("#stuList > tfoot tr").eq(0).append($td6);
					$("#stuList tbody tr").click(function(){
						var memberId = $(this).children().eq(1).text();	
						window.open("em_selectStudent.si?id="+memberId,"학적상세조회","width='120px'")
					});
					}

				});
		
	}
	$("#stuList tbody tr").click(function(){
		var memberId = $(this).children().eq(1).text();	
		window.open("em_selectStudent.si?id="+memberId,"학적상세조회","width='120px'")
	});
	</script>
</body>
</html>
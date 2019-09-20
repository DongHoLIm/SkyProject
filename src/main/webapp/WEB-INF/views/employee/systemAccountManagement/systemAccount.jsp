<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 부여페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.updateAccount{
		display: inline-block;
	}
	#employeememberlist {
		text-align: center;
	}
	#employeememberlist thead tr th{
		text-align:center;
	}
	#employeememberlist tbody tr:hover{
		color: black;
	}
</style>
</head>
<body>
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h3 class="updateAccount">권한 부여/수정</h3>			
				<div style="float: right;">
				<input type="text" />
				<button type="reset"class="updateAccount" >취소</button>
				</div>
				<hr />
				<br />
				<br />			
				<table id="employeememberlist">
					<thead>
						<tr>
							<th>교직원 아이디</th>
							<th>교직원 이름</th>
							<th>교직원 부서</th>
							<th>직급</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var='eml' items="${list}">
						<tr>
							<td>${eml.memberId}</td>
							<td>${eml.memberKName}</td>
							<td>${eml.sdeptCode}</td>
							<td>${eml.rankCode}</td>							
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
							<tr>
								<td colspan="4">
									<c:set var="pageInfo" value="${pi }" />
									<ul class="pagination" align="center">
										<c:if test="${pi.currentPage<=1 }">
											<li><span class="button disabled">Prev</span></li>
										</c:if>
										<c:if test="${pi.currentPage>1 }">
											<li><span class="button" id="prevBtn">Prev</span></li>
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
											<li><span class="button" id="nextBtn">next</span></li>
										</c:if>
										<c:if test="${pi.currentPage ==pi.maxPage }">
											<li><span class="button disabled">Next</span></li>
										</c:if>
									</ul>
								</td>
							</tr>
						</tfoot>
				</table>							
			</div>
		</div>
		
		<div>			
			<jsp:include page="../../common/menubar-employee.jsp" />		
		</div>
	</div>
	<script>
		$(function (){
			$("#employeememberlist tbody tr").click(function(){
				var  id= $(this).children().eq(0).text();
				window.open("accountDetail.me?userId="+id,"교직원 권한확인","width='150px'");
				
			});
			$(".page").click(function(){
				var currentPage = $(this).text();
	 			console.log(currentPage);
	 			 $.ajax({
	 				url:"ajaxPagingMemberList.me",
	 				type:"get",	 				
	 				data:{"currentPage":currentPage},
	 				success:function(data){
	 					console.log(data);
	 					$("#employeememberlist tbody").empty();
	 					for(var i =0;i<data.list.length;i++){
	 						var $tr = $("<tr>");
	 						var $td1 = $("<td>").text(data.list[i].memberId);
	 						var $td2 = $("<td>").text(data.list[i].memberKName);
	 						var $td3 = $("<td>").text(data.list[i].sdeptCode);
	 						var $td4 = $("<td>").text(data.list[i].rankCode);
	 						
	 						$tr.append($td1);
	 						$tr.append($td2);
	 						$tr.append($td3);
	 						$tr.append($td4);
	 						$("#employeememberlist tbody").append($tr);	 						
	 					}
	 					$("#employeememberlist > tfoot tr").eq(0).empty();
	 					var $td6 = $("<td colspan='4'>");
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
	 					$("#employeememberlist > tfoot tr").eq(0).append($td6);
	 					$("#employeememberlist tbody tr").click(function(){
	 						var  id= $(this).children().eq(0).text();
	 						window.open("accountDetail.me?userId="+id,"교직원 권한확인","width='150px'");
	 						
	 					});
	 				}
				});
			});
		});
		function reajax (index){	 			
			 var currentPage = index;
			console.log(currentPage);
			 $.ajax({
				url:"ajaxPagingMemberList.me",
				type:"get",	 				
				data:{"currentPage":currentPage},
				success:function(data){					
					$("#employeememberlist tbody").empty();
 					for(var i =0;i<data.list.length;i++){
 						var $tr = $("<tr>");
 						var $td1 = $("<td>").text(data.list[i].memberId);
 						var $td2 = $("<td>").text(data.list[i].memberKName);
 						var $td3 = $("<td>").text(data.list[i].sdeptCode);
 						var $td4 = $("<td>").text(data.list[i].rankCode);
 						
 						$tr.append($td1);
 						$tr.append($td2);
 						$tr.append($td3);
 						$tr.append($td4);
 						$("#employeememberlist tbody").append($tr);	 						
 					}					
					
					$("#employeememberlist > tfoot tr").eq(0).empty();
					var $td6 = $("<td colspan='4'>");
					var $ul  =$("<ul class='pagination' align='center'>");
					var $li =$("<li>");
					var $li1 =$("<li>");
					var $li2=$("<li>");	 					 					
					var $li3 =$("<li>");
					var $disabledPrevspan = $("<span class='button disabled' >").text('Prev');
					var $abledPrevSpan = $("<span class='button' id='prevBtn'  onclick='goPre()'>").text("Prev");
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
					$("#employeememberlist > tfoot tr").eq(0).append($td6);	
					$("#employeememberlist tbody tr").click(function(){
						var  id= $(this).children().eq(0).text();
						window.open("accountDetail.me?userId="+id,"교직원 권한확인","width='150px'");
						
					});
				}
			}); 	 			
		}
		function goNext(){
			
	 			var currentPage = $("p[class='page active']").text();
	 			var nextPage = Number(currentPage);
	 			
	 			reajax(nextPage+1);
	 	
		}
		function goPre(){
			
	 			var currentPage = $("p[class='page active']").text();
	 			var prePage = Number(currentPage);
	 			
	 			reajax(prePage-1);
	 	
		}
	</script>
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	#SMSList {
		text-align:center;
	}
	#SMSList tr th{
		text-align:center;
	}
	#SMSList tbody tr :hover{
		color: black;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h3>SMS 전송 내역</h3>
				<hr />
				<div>
					<table id="SMSList">
						<thead>
							<tr>
								<th>번호</th>
								<th>수신인원</th>
								<th>발신일</th>
								<th>발신내용</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listMember"  items="${list}" varStatus="status">
								<tr>
									<td><c:out value="${status.count}"/></td>
									<td><c:out value="${listMember.memberCount}"/></td>
									<td><c:out value="${listMember.sendDate }"/></td>
									<td><c:out value="${listMember.SMSmessage }"/></td>
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
		</div>
		<div>		
			<jsp:include page="../../common/menubar-professor.jsp" />			
		</div>
	</div>
	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	<script>
		$(function(){
			$("#SMSList tbody tr").click(function(){
				var date = $(this).children().eq(2).text();
				window.open( "SendSMSDetail.pro?date="+date,'상세보기','width=50px;');			
			});
			$(".page").click(function(){
				var currentPage = $(this).text();
	 			console.log(currentPage);
	 			 $.ajax({
	 				url:"ajaxPagingSMSList.pro",
	 				type:"get",	 				
	 				data:{"currentPage":currentPage},
	 				success:function(data){
	 					console.log(data);
	 					$("#SMSList tbody").empty();
	 					for(var i =0;i<data.list.length;i++){
	 						var $tr = $("<tr>");
	 						var $td1 = $("<td>").text(i+1);
	 						var $td2 = $("<td>").text(data.list[i].memberCount);
	 						var $td3 = $("<td>").text(data.list[i].sendDate);
	 						var $td4 = $("<td>").text(data.list[i].SMSmessage);
	 						
	 						$tr.append($td1);
	 						$tr.append($td2);
	 						$tr.append($td3);
	 						$tr.append($td4);
	 						$("#SMSList tbody").append($tr);	 						
	 					}
	 					$("#SMSList > tfoot tr").eq(0).empty();
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
	 					$("#SMSList > tfoot tr").eq(0).append($td6);
	 					$("#SMSList tbody tr").click(function(){
	 						var date = $(this).children().eq(2).text();
	 						window.open( "SendSMSDetail.pro?date="+date,'상세보기','width=50px;');			
	 					});
	 				}
	 			 });
			});
		});
		function reajax (index){	 			
			 var currentPage = index;
			console.log(currentPage);
			 $.ajax({
				url:"ajaxPagingSMSList.pro",
				type:"get",	 				
				data:{"currentPage":currentPage},
				success:function(data){					
					$("#SMSList tbody").empty();
					for(var i =0;i<data.list.length;i++){
						var $tr = $("<tr>");
						var $td1 = $("<td>").text(i+1);
 						var $td2 = $("<td>").text(data.list[i].memberCount);
 						var $td3 = $("<td>").text(data.list[i].sendDate);
 						var $td4 = $("<td>").text(data.list[i].SMSmessage);
						
						$tr.append($td1);
						$tr.append($td2);
						$tr.append($td3);
						$tr.append($td4);
						$("#SMSList tbody").append($tr);	 						
					}					
					
					$("#SMSList > tfoot tr").eq(0).empty();
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
					$("#SMSList > tfoot tr").eq(0).append($td6);	
					$("#SMSList tbody tr").click(function(){
 						var date = $(this).children().eq(2).text();
 						window.open( "SendSMSDetail.pro?date="+date,'상세보기','width=50px;');			
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
</body>
</html>
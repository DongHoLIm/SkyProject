<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#original {
		text-align: center;
	}
	#original thead tr  th{
		text-align:center;
	}
	#original tbody tr:hover{
		color:black;
	}
	#sendMemberList {
		text-align: center;
	}
	#sendMemberList thead tr  th{
		text-align:center;
	}
	#sendMemberList tbody tr:hover{
		color:black;
	}
</style>

</head>
<body>
	<div>
		<table id="searSubject">
			<tr>
				<td align="center">강의장명 :</td>
				<td><select name="demo-category" id="subject" style="width:120%;">
					<option value="">-강의명</option>
				</select></td>
				<td align="center"><button class="button small">Search</button></td>
			</tr>
		</table>
		 <table id="original" align="center">
			<thead>
				<tr>
														
					<th>학번</th>
					<th>이름</th>
					<th>핸드폰번호</th>
					<th>학과</th>
					<th>학년</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sl" items="${list}" >
				<tr>					
					<td>${sl.memberId }</td>
					<td>${sl.memberKName }</td>
					<td>${sl.phone}</td>
					<td>${sl.sdeptName}</td>
					<td>${sl.grade }</td>					
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" id="paging">
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
		<hr />
		<table id="sendMemberList" align="center">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>핸드폰번호</th>
					<th>학과</th>
					<th>학년</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
			<tfoot>				
				<tr>
					<td colspan="4" align="center"><input type="button" class="button small" value="확인" id="SendSMSList"/></td>
				</tr>
			</tfoot>
		</table>
	 </div>
	 <script type="text/javascript">
	 		$(".page").click(function(){
	 			var currentPage = $(this).text();
	 			console.log(currentPage);
	 			 $.ajax({
	 				url:"ajaxPaging.pro",
	 				type:"get",	 				
	 				data:{"currentPage":currentPage},
	 				success:function(data){
	 					
	 					console.log('data 타입'+typeof data);
	 					console.log(data.pi);
	 					$("#original >tbody ").empty();	
	 					for(var i =0;i<data.list.length;i++){
	 					var $tr =$("<tr>");
	 					var $td = $("<td>");
	 					var $td1 = $("<td>");
	 					var $td2 = $("<td>");
	 					var $td3 =$("<td>");
	 					var $td4 =$("<td>");
	 					
	 					$td.text(data.list[i].memberId);
	 					$td1.text(data.list[i].memberKName);
	 					$td2.text(data.list[i].phone);
	 					$td3.text(data.list[i].sdeptName);
	 					$td4.text(data.list[i].grade);
	 					$tr.append($td);
	 					$tr.append($td1);
	 					$tr.append($td2);
	 					$tr.append($td3);
	 					$tr.append($td4);
	 					$("#original>tbody").append($tr); 						
	 					}
	 					
	 					$("#original > tfoot tr").eq(0).empty();
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
	 					$("#original > tfoot tr").eq(0).append($td6);
	 					
	 					$("#original tbody tr").click(function(){
	 			 			console.log(this);
	 			 			$("#sendMemberList > tbody").append(this);
	 			 		});
	 				}
	 			}); 
	 			
	 		});
	 		
	 		function reajax (index){	 			
	 			 var currentPage = index;
	 			console.log(currentPage);
	 			 $.ajax({
	 				url:"ajaxPaging.pro",
	 				type:"get",	 				
	 				data:{"currentPage":currentPage},
	 				success:function(data){
	 					
	 					console.log('data 타입'+typeof data);
	 					console.log(data.pi);
	 					$("#original >tbody ").empty();	
	 					for(var i =0;i<data.list.length;i++){
	 					var $tr =$("<tr>");
	 					var $td = $("<td>");
	 					var $td1 = $("<td>");
	 					var $td2 = $("<td>");
	 					var $td3 =$("<td>");	 					
						var $td4 =$("<td>");
	 					
	 					$td.text(data.list[i].memberId);
	 					$td1.text(data.list[i].memberKName);
	 					$td2.text(data.list[i].phone);
	 					$td3.text(data.list[i].sdeptName);
	 					$td4.text(data.list[i].grade);
	 					$tr.append($td);
	 					$tr.append($td1);
	 					$tr.append($td2);
	 					$tr.append($td3);
	 					$tr.append($td4);
	 					$("#original>tbody").append($tr); 						
	 					}
	 					
	 					$("#original > tfoot tr").eq(0).empty();
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
	 					$("#original > tfoot tr").eq(0).append($td6);
	 					
	 					$("#original tbody tr").click(function(){
	 			 			console.log(this);
	 			 			$("#sendMemberList > tbody").append(this);
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
	 		$(function(){
		 		$("#original").on("click","tbody tr",function(){
		 			$(this).closest("tr").clone().prependTo("#sendMemberList tbody");
		 		});
		 		
		 		 $("#sendMemberList").on("click","tbody tr",function(){
		 			$(this).closest("tr").remove(); 
		 		 });
	 			$("#SendSMSList").click(function(){
	 				var studentInfo = new Object();
	 				var studentlist = new Array();
	 				
	 				var tr = $("#sendMemberList tbody tr");
	 				 for(var i =0;i<tr.length;i++){
	 					 var memberId = tr.eq(i).children().eq(0).text();
	 					 var memberKName = tr.eq(i).children().eq(1).text();
	 					 var phone = tr.eq(i).children().eq(2).text();
	 					 var sdeptName = tr.eq(i).children().eq(3).text();
	 					 var grade = tr.eq(i).children().eq(4).text();
	 					studentInfo={
	 							memberId:memberId,
	 							memberKName:memberKName,
	 							phone:phone,
	 							sdeptName:sdeptName,
	 							grade:grade
	 					}
	 					studentlist.push(studentInfo); 					
	 				 }
	 				 window.opener.getReturnValue(JSON.stringify(studentlist));
	 				 window.close();
	 			});
	 		});
	 		
	 			
	 	
	 		
	 		</script>
</body>
</html>
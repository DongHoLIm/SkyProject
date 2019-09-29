<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정조회및 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.updateAccount{
		display: inline-block;
	}
	#MemberList tr th{
		text-align: center;
	}
	#MemberList tr td{
		text-align: center;
	}
	#search{
		width: 200px;
	}
	.searchArea{
		display: inline-block;
	}
	#MemberList tbody tr:hover{		
		color : black;
	}
	.pagination li a{
		background:white;
		border:0.5px solid #f56a6a;			
		cursor: pointer;
	}	
</style>
</head>
<body>
	<c:set var="member" value="${loginUser.memberStatus}" />
	<c:set var="memberList" value="${requestScope.MemberList }"/>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>				
				<h3 class="updateAccount">계정조회및 수정</h3>
				<div style="float: right;" class="updateAccount">			
				<span class="updateAccount">
					<select name="searchCondition" id="searchConditionController" >
						<option value="name">이름으로 검색</option>
						<option value="etc">비고로 검색</option>
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
				<table id="MemberList">					
					<thead>
						<tr>							
							<th>아이디</th>							
							<th>이름</th>
							<th>이메일</th>						
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${memberList }">
						<tr>							
							<td>${a.memberId}</td>							
							<td>${a.memberKName }</td>
							<td>${a.email }</td>
							<c:if test="${a.memberStatus==3 }">
							<td>교직원</td>
							</c:if>
							<c:if test="${a.memberStatus==2 }">
							<td>교수</td>
							</c:if>
							<c:if test="${a.memberStatus==1 }">
							<td>학생</td>
							</c:if>							
						</tr>						
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="5">
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
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	<script>
	$(function(){
		$("a[class='page']").click(function(){
			var currentPage =$(this).text();
			 	location.href ="MemberListview.me?currentPage="+currentPage;
		});
		$("#nextBtn").click(function(){
			var currentPage =$("p[class='page active']").text();
			var nextPage =Number(currentPage);
			var nextPageNum = nextPage+1;
			location.href ="MemberListview.me?currentPage="+nextPageNum;
		});
		$("#prevBtn").click(function(){
			var currentPage =$("p[class='page active']").text();
			var prePage = Number(currentPage);
			var prePageNum = prePage-1;
			
			location.href ="MemberListview.me?currentPage="+prePageNum;
		});
		$("#MemberList tbody tr").click(function(){
			var test = $(this);
			var userId = test.children().eq(0).text();
			location.href = "MemberDetailList.me?userId="+userId;
		});
		$("#searchConditionController").change(function(){
			var value = $(this).val();				
			if(value=='etc'){
				$("#searchBar").remove();
				var $select = $("<select name='searchCondition' id='searchBar'>");
				var $option1 =$("<option value='3'>").text("교직원");
				var $option2 =$("<option value='2'>").text("교수");
				var $option3 =$("<option value='1'>").text("학생");				
				
				$select.append($option1);
				$select.append($option2);
				$select.append($option3);
				
				$("#inputArea").append($select);
				
			}else{
				$("#searchBar").remove();
				var $input =$("<input type='text' name='searchValue' id='searchBar'>")
				$("#inputArea").append($input);
			}
		});
	});
		function searchBtn(){
			var searchValue =$("#searchBar").val();
			console.log(searchValue);
			$.ajax({
				url:"searchMember.me",
				data: {"searchValue":searchValue},
				type:"post",
				success: function(data){
					console.log(data);
					$("#MemberList tbody").empty();
 					for(var i =0;i<data.list.length;i++){
 						var $tr = $("<tr>");
 						var $td1 = $("<td>").text(data.list[i].memberId); 					
 						var $td3 = $("<td>").text(data.list[i].memberKName);
 						var $td4 = $("<td>").text(data.list[i].email);
 						var $td5 = $("<td>");
 						if(data.list[i].memberStatus == 1){
 							$td5.text("학생");
 						}else if(data.list[i].memberStatus==2){
 							$td5.text("교수");
 						}else{
 							$td5.text("교직원");
 						}
 						$tr.append($td1); 					
 						$tr.append($td3);
 						$tr.append($td4);
 						$tr.append($td5);
 						$("#MemberList tbody").append($tr);	 						
 					}
 					$("#MemberList > tfoot tr").eq(0).empty();
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
 					$("#MemberList > tfoot tr").eq(0).append($td6);
 					$("#MemberList tbody tr").click(function(){
 						var test = $(this);
 						var userId = test.children().eq(0).text();
 						location.href = "MemberDetailList.me?userId="+userId;
 					});
				}
				
			});
		}
		function reajax(index){
			var searchValue =$("#searchBar").val();
			var currentPage = index;
			$.ajax({
				url:"searchMember.me",
				data: {"searchValue":searchValue,"currentPage":currentPage},
				type:"post",
				success: function(data){
					console.log(data);
					$("#MemberList tbody").empty();
 					for(var i =0;i<data.list.length;i++){
 						var $tr = $("<tr>");
 						var $td1 = $("<td>").text(data.list[i].memberId); 						
 						var $td3 = $("<td>").text(data.list[i].memberKName);
 						var $td4 = $("<td>").text(data.list[i].email);
 						var $td5 = $("<td>");
 						if(data.list[i].memberStatus == 1){
 							$td5.text("학생");
 						}else if(data.list[i].memberStatus==2){
 							$td5.text("교수");
 						}else{
 							$td5.text("교직원");
 						}
 						$tr.append($td1); 					
 						$tr.append($td3);
 						$tr.append($td4);
 						$tr.append($td5);
 						$("#MemberList tbody").append($tr);	 						
 					}
 					$("#MemberList > tfoot tr").eq(0).empty();
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
 					$("#MemberList > tfoot tr").eq(0).append($td6);
 					$("#MemberList tbody tr").click(function(){
 						var test = $(this);
 						var userId = test.children().eq(0).text();
 						location.href = "MemberDetailList.me?userId="+userId;
 					});
				}
				
			});
		}

		function goNext() {

			var currentPage = $("p[class='page active']").text();
			var nextPage = Number(currentPage);

			reajax(nextPage + 1);

		}
		function goPre() {

			var currentPage = $("p[class='page active']").text();
			var prePage = Number(currentPage);

			reajax(prePage - 1);

		}
	</script>
</body>
</html>
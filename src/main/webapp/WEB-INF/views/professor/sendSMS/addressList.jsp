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
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sl" items="${list}" >
				<tr>					
					<td>${sl.memberId }</td>
					<td>${sl.memberKName }</td>
					<td>${sl.phone}</td>
					<td>${sl.sdeptName}</td>					
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
						</ul></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" class="button small" value="추가"/></td>
				</tr>
			</tfoot>
		</table>
		<hr />
		<table align="center">
			<thead>
				<tr>
					<th><input type="checkbox" value="selectAll" id="Allcheck"><label for="Allcheck"></label></th>									
					<th>학번</th>
					<th>이름</th>
					<th>핸드폰번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" value="selectAll" id="selectOne"><label for="selectOne"></label></td>
					<td></td>
					<td></td>
					<td></td>
					
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan = "4">
						
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" class="button small" value="확인"/></td>
				</tr>
			</tfoot>
		</table>
	 </div>
	 <script type="text/javascript">
	 	$(function(){
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
	 					
	 					$td.text(data.list[i].memberId);
	 					$td1.text(data.list[i].memberKName);
	 					$td2.text(data.list[i].phone);
	 					$td3.text(data.list[i].sdeptName);
	 					$tr.append($td);
	 					$tr.append($td1);
	 					$tr.append($td2);
	 					$tr.append($td3);
	 					$("#original>tbody").append($tr); 						
	 					}
	 					
	 					$("#original > tfoot tr").eq(0).empty();
	 					var $ul  =$("<ul>");
	 					var $li =$("<li>");
	 					var $li1 =$("<li>");
	 					var $li2=$("<li>");
	 					var $li3 =$("<li class='pageNumber'>");
	 					var $li4 =$("<li class='pageNumber'>");
	 					var $li5 =$("<li>");
	 					var $disabledPrevspan = $("<span class='button disabled' >").text('Prev');
	 					var $abledPrevSpan = $("<span class='button' id='prevBtn'>").text("Prev");
	 					var $disabledNextSpan= $("<span class='button' id='nextBtn'>").text("Next");
	 				}
	 			}); 
	 			
	 		});
	 		
	 	});
	 
	 </script>
</body>
</html>
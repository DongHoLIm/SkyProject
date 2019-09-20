<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function change_cate(){
		var category = $("#category").val();
		console.log(category);
		if(category == "0"){
			$("#choice0").show();
			$("#choice1").hide();
			$("#choice2").hide();
			$(".btn1").show();
			$(".btn2").hide();
			$(".btn3").hide();
			$('#gwamok').val("");
			$('#professor').val("");
		}else if(category == "1"){
			$("#choice0").hide();
			$("#choice1").show();
			$("#choice2").hide();
			$(".btn1").hide();
			$(".btn2").show();
			$(".btn3").hide();
			$('#gwamok').val("");
			$('#professor').val("");
		}else if(category == "2"){	
			$("#choice0").hide();
			$("#choice1").hide();
			$("#choice2").show();
			$(".btn1").hide();
			$(".btn2").hide();
			$(".btn3").show();
			$('#gwamok').val("");
			$('#professor').val("");
		}
	}
	function goSubJect(){
		var sdeptCode = $(".Sdepartment").val();
		var completeType = $(".Isu").val();
		
			$.ajax({
				url:"goSubject.st",
				type:"post",
				data:{sdeptCode:sdeptCode, completeType:completeType},
				success:function(data){
					
					var osList = new Array();
					for(var i=0;i<data.osList2.length;i++){
						osList[i] = data.osList2[i];
					}
			
					$('#subJect').empty();
					for(var i=0;i<data.osList2.length;i++){
						var option = $("<option value='"+osList[i].openSubCode+"'>"+osList[i].subName+"</option>");
						$("#subJect").append(option);
						console.log("!!!!!:" + osList[i].openSubCode)
					}
				},
				error:function(err){
					console.log("실패!");
				}
			});
		}
	function deptSearch(){
		
		var subCode = $(".subJect").val();
		
		$.ajax({
			url:"selectOpensubject.st",
			type:"post",
			data:{subCode:subCode},
			success:function(data){		
				var list = new Array();
				for(var i=0;i<data.list.length;i++){
					list[i] = data.list[i];
				}
				var count = 1;
				 $('#search').empty();
				 $( '.tableList2 > tbody').empty(); 
				for(var i=0;i<data.list.length;i++){
					 var table = $("<tr>"+
										"<td>"+"<input name='chk' type='checkbox' value='"+list[i].openSubCode+"'>"+"</td>"+
										"<td>"+count+"</td>"+
										"<td>"+list[i].completeType+"</td>"+
										"<td>"+list[i].openSubCode+"</td>"+
										"<td>"+list[i].subName+"</td>"+
										"<td>"+list[i].subGrade+"</td>"+
										"<td>"+list[i].professorName+"</td>"+
										"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
										"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
										"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
										"<td>"+"<a>"+'조회'+"</a>"+"</td>"+
										"<td>"+"</td>"+
										"<td>"+"</td>"+
									"</tr>");
					$(".tableList2").append(table);  				
					count++;
				} 
			},
			error:function(err){
				console.log("실패!");
			}
		});
		
	}
	
	function gwamokSearch(){
		var gwamok = $("#gwamok").val();
		if(!gwamok){
			alert('과목명(과목코드)을 입력하세요');
		}else{
			$.ajax({
				url:"selectgwamok.st",
				type:"post",
				data:{gwamok:gwamok},
				success:function(data){
					var list = new Array();
					for(var i=0;i<data.list.length;i++){
						list[i] = data.list[i];
					}	
					var count = 1;
					 $('#search').empty();
					 $( '.tableList2 > tbody').empty();
					for(var i=0;i<data.list.length;i++){
						 var table = $("<tr>"+
								 		"<td>"+"<input name='chk' type='checkbox' value='"+list[i].openSubCode+"'>"+"</td>"+
											"<td>"+count+"</td>"+
											"<td>"+list[i].completeType+"</td>"+
											"<td>"+list[i].openSubCode+"</td>"+
											"<td>"+list[i].subName+"</td>"+
											"<td>"+list[i].subGrade+"</td>"+
											"<td>"+list[i].professorName+"</td>"+
											"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
											"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
											"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
											"<td>"+"<a>"+'조회'+"</a>"+"</td>"+
											"<td>"+"</td>"+
											"<td>"+"</td>"+
										"</tr>");
						$(".tableList2").append(table);  
						count++;
					} 
				},
				error:function(err){
					console.log("실패!");
				}
			});
		}
	}
	function professorSearch(){
		var professor = $("#professor").val();
		
		console.log(professor);
		
		if(!professor){
			alert("교수명(교수코드)을 입력하세요!");
		}else{
			$("#professorS").empty();
			$("#proGwamok").empty();
			$.ajax({
				url:"selectProfessor.st",
				type:"post",
				data:{professor:professor},
				success:function(data){
					var list1 = new Array();
					var list2 = new Array();
					for(var i=0;i<data.list2.length;i++){
						list1[i] = data.list2[i];
						list2[i] = data.list[i];
					}
					for(var i=0;i<data.list2.length;i++){
						var option1 = $("<option id='proList' value='"+list1[i].professorNo+"'>"+list1[i].professorName+"</option>");
						$("#professorS").append(option1);
					}
					for(var i=0;i<data.list.length;i++){
						var option2 = $("<option id='gwamokList' value='"+list2[i].openSubCode+"'>"+list2[i].subName+"</option>");
						$("#proGwamok").append(option2);
					}
				},
				error:function(err){
					console.log("실패!");
				}
			});
		}
	}
	function searchGwamok(){
		var professorNo = $("#professorS").val();
		
		$("#proGwamok").empty();
		$.ajax({
			url:"selectGwamok.st",
			type:"post",
			data:{professorNo:professorNo},
			success:function(data){
				console.log(data);
				
				var list = new Array();
				for(var i=0;i<data.list.length;i++){
					list[i] = data.list[i];
				}
				for(var i=0;i<data.list.length;i++){
					var option = $("<option id='gwamokList' value='"+list[i].openSubCode+"'>"+list[i].subName+"</option>");
					$("#proGwamok").append(option);
				}
			},
			error:function(err){
				console.log("실패!");
			}
		});
	}
	function professorGwamokSearch(){
		var subCode = $(".proGwamok").val();
		
		$.ajax({
			url:"selectOpensubject.st",
			type:"post",
			data:{subCode:subCode},
			success:function(data){			
				var list = new Array();
				for(var i=0;i<data.list.length;i++){
					list[i] = data.list[i];
				}
				var count = 1;
				 $('#search').empty();
				 $( '.tableList2 > tbody').empty(); 
				for(var i=0;i<data.list.length;i++){
					 var table = $("<tr>"+
								 		"<td>"+"<input name='chk' type='checkbox' value='"+list[i].openSubCode+"'>"+"</td>"+
										"<td>"+count+"</td>"+
										"<td>"+list[i].completeType+"</td>"+
										"<td>"+list[i].openSubCode+"</td>"+
										"<td>"+list[i].subName+"</td>"+
										"<td>"+list[i].subGrade+"</td>"+
										"<td>"+list[i].professorName+"</td>"+
										"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
										"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
										"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
										"<td>"+"<a>"+'조회'+"</a>"+"</td>"+
										"<td>"+"</td>"+
										"<td>"+"</td>"+
									"</tr>");
					$(".tableList2 tbody").append(table);  	
					count++;					
				} 
			},
			error:function(err){
				console.log("실패!");
			}
		});
	}
	$(function(){
		$('.tableList2').on('click','tbody tr',function(){
			 var checkbox = $(this).find('td:first-child :checkbox');
	            checkbox.attr('checked', !checkbox.is(':checked'));
		 });

	});
	function insertSubjectApply(){
		var subCodeArr = new Array();
		var input = $("input[name=chk]:checked");
		input.each(function() {
			subCodeArr += $(this).val()+",";
		});
		var subCode = subCodeArr.split(',');
		subCode.pop();
		
		
		$.ajax({
			url:"insertPreliminaryCourseRegistration.st",
			type:"post",
			data:{subCode:subCode},
			success:function(data){
				var key = data.modelAndView.modelMap;
				if(key.check == 'no'){
					alert('이미 신청한 과목이 있습니다.');
				}else{
					alert('수강 신청이 완료되었습니다.');
					location.reload();
				}
			},
			error:function(err){
				console.log("실패!");
			}
		});
			  

	}
	
	
</script>
<style>
table {
	font-family: "돋움", "돋움체";
	font-size: 12px;
	color: #666666;
	text-decoration: none;
}
/*검색 테이블*/
table.tableList3 {
	table-layout: fixed;
	border-top: 1px #C0C0C0 solid;
	border-bottom: 1px #C0C0C0 solid;
	border-left: 1px #C0C0C0 solid;
	border-right: 1px #C0C0C0 solid;
}

table.tableList3 th, table.tableList3 td {
	padding: 7px 3px 3px 3px;
	font-size: 9pt;
}
/* table.tableList1 th {
		border-right:1px #F3D7D7 solid;
		border-bottom:1px #CFCFCF solid;
		color:#000000;
		background:#E3F2FF;
	} */
table.tableList3 td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList3 td.dot {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList3 td.left {
	text-align: left;
}

table.tableList3 td.right {
	text-align: right;
}

table.tableList3 td img {
	vertical-align: middle;
}

table.tableList3 th.end, table.tableList2 td.end {
	border-right: none
}
/*조회 테이블*/
table.tableList2 {
	table-layout: fixed;
	border-top: 2px #A6D9DC solid;
	border-bottom: 1px #CFCFCF solid;
}

table.tableList2 tr.even {
	background: #FFFFEA;
} /* CSS2 나 CSS3 에 even 은 없다 */
table.tableList2 tr:hover {
	background: #FCEFEF;
} /* 마우스 커서가 올려진 경우라서 모바일에선 무용. :focus 가 아님에 유의 */
table.tableList2 th, table.tableList2 td {
	padding: 7px 3px 3px 3px;
	text-align: center;
	font-size: 9pt;
}

table.tableList2 th {
	border-right: 1px #F3D7D7 solid;
	border-bottom: 1px #CFCFCF solid;
	color: #000000;
	background: #E3F2FF;
}

table.tableList2 th.end, table.tableList2 td.end {
	border-right: none;
}

table.tableList2 td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList2 td.dot {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList2 td.left {
	text-align: left;
}

table.tableList2 td.right {
	text-align: right;
}

table.tableList2 td img {
	vertical-align: middle;
}
</style>
</head>
<body>
	<div id="menu" class="menu">
		<jsp:include page="common/menubar-CourseApply.jsp" />
	</div>
	<form action="inquiry.st" method="post">
		<table class="tableList3" width="100%">
			<tbody>
				<tr id="choice">
					<td>
						<span> &nbsp;&nbsp;&nbsp;<b>카테고리</b> : 
							<select
								name="category" id="category" onchange="change_cate()"
								style="background-color: #FFD9EC;"> 
									<option value="0">학과 조회</option>
									<option value="1">과목 검색</option>
									<option value="2">교수 검색</option>
							</select>&nbsp;&nbsp;&nbsp;
						</span>
						 <!-- 개설강좌 --> 
						 <span id="choice0" name="choice0" style="display: inline;"> 
						 	<span> <strong>학과</strong> : 
						 		<select name="Sdepartment" id="Sdepartment" class="Sdepartment" onchange="goSubJect();">
						 		<c:forEach var="Sdepartment" items="${ sdList }">
						 			<option value="<c:out value="${Sdepartment.sdeptCode}" />"><c:out value="${Sdepartment.sdeptName}"/></option>
								</c:forEach>
								</select>
								&nbsp;&nbsp;&nbsp; <strong>이수구분</strong> : 
								<select name="Isu" id="Isu" class="Isu" onchange="goSubJect();">
									<option value="ALL">* 전체 *</option>
									<option value="교필">교필</option>
									<option value="교선">교선</option>
									<option value="전필">전필</option>
									<option value="전선">전선</option>
								</select>
								
								&nbsp;&nbsp;&nbsp; <strong>과목</strong> : 
								<select name="subJect" id="subJect" class="subJect" style="background-color: #FFD9EC;">
								<c:forEach var="openSubject" items="${ osList }">
						 			<option value="<c:out value="${openSubject.openSubCode}" />"><c:out value="${openSubject.subName}"/></option>
								</c:forEach>
								</select>&nbsp;&nbsp;&nbsp;
							</span>
						</span>
						 <!-- 과목조회 -->
						 <span id="choice1" name="choice1" style="display: none;">
						 	<span>
						 		<span class="ui-widget"> 
						 			<label for="gwamok">조회 : </label>
						 			<input type="text" name="gwamok" id="gwamok" size="25" placeholder="과목명(과목코드)을 입력하세요." onkeypress="if(event.keyCode==13) {gwamokSearch(); return false;}">	
										&nbsp;&nbsp;&nbsp;
								</span>
							</span>
						</span>
						<!-- 교수조회 -->
						<span id="choice2" name="choice2" style="display: none">
							<span>
								<span class="ui-widget"> <label for="prof_nm">조회 : </label>
								<input type="text" name="professor" id="professor" size="25" placeholder="교수명(교수코드)을 입력하세요" onkeypress="if(event.keyCode==13) {professorSearch(); return false;}">
								교수 : <select name="professorS" id="professorS" class="professorS"
										style="width: 150;" onchange="searchGwamok();">
									</select>&nbsp;&nbsp;&nbsp; 
								과목 : <select name="proGwamok" id="proGwamok" class="proGwamok" style="width: 200; background-color: #FFD9EC;">
									</select>&nbsp;&nbsp;&nbsp;
								</span>
							</span>
						</span>
						<span>
							<span class="btn1" onclick="deptSearch();" name="search_btn" id="search_btn" style="background:red">조 회</span>
							<span class="btn2" onclick="gwamokSearch();" name="search_btn" id="search_btn" style="background:red; display:none;">조 회</span>
							<span class="btn3" onclick="professorGwamokSearch();" name="search_btn" id="search_btn" style="background:red; display:none;">조 회</span>
							&nbsp;&nbsp;&nbsp;
							<span class="apply" onclick="insertSubjectApply();" style="background:skyblue;"> 신 청 </span>
						</span>
					</td>				
				</tr>
			</tbody>
		</table>
	</form>
	<table class="tableList2" style="width: 100%">
		<thead>	
			<tr>
				<th width="2%"><input type="checkbox" class="Allcheck"></th>
				<th width="3%">No</th>
				<th width="6%">이수구분</th>
				<th width="6%">과목번호</th>
				<th width="15%">교과목명</th>
				<th width="5%">학점</th>
				<th width="8%">교수</th>
				<th width="12%">교시</th>
				<th width="13%">강의실(건물명)</th>
				<th width="5%">인원</th>
				<th width="7%">계획서</th>
				<th width="7%">강의평가</th>
				<th width="11%">비고</th>
			</tr>
		</thead>
		<tbody>
			<tr id="search">
				<td colspan="14"><font color="red">☞ 조회버튼을 클릭하세요.</font></td>
			</tr>
		</tbody>
	</table>


</body>
</html>
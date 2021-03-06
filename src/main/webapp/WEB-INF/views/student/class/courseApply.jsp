<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/*수강신청*/
	table {
	font-family: "돋움", "돋움체";
	font-size: 12px;
	color: #666666;
	text-decoration: none;
}
table {
	font-family: "돋움", "돋움체";
	font-size: 12px;
	color: #666666;
	text-decoration: none; 
}
/*검색 테이블*/
table.tableList1, table.tableList3{
	table-layout: fixed;
	border-top: 1px #C0C0C0 solid;
	border-bottom: 1px #C0C0C0 solid;
	border-left: 1px #C0C0C0 solid;
	border-right: 1px #C0C0C0 solid;
}

table.tableList1 th, table.tableList1 td, table.tableList3 th, table.tableList3 td {
	padding: 7px 3px 3px 3px;
	font-size: 9pt;
}
/* table.tableList1 th {
		border-right:1px #F3D7D7 solid;
		border-bottom:1px #CFCFCF solid;
		color:#000000;
		background:#E3F2FF;
	} */
table.tableList1 td, table.tableList3 td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList1 td.dot, table.tableList3 td.dot{
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList1 td.left, table.tableList3 td left {
	text-align: left;
}

table.tableList1 td.right, table.tableList3 td.right{
	text-align: right;
}

table.tableList1 td img, table.tableList3 td img{
	vertical-align: middle;
}

table.tableList1 th.end, table.tableList2 td.end, table.tableList3 td.end {
	border-right: none
}
/*조회 테이블*/
table.tableList2, table.tableList4 {
	table-layout: fixed;
	border-top: 2px #A6D9DC solid;
	border-bottom: 1px #CFCFCF solid;
}

table.tableList2 tr.even, table.tableList4 tr.even{
	background: #FFFFEA;
} /* CSS2 나 CSS3 에 even 은 없다 */
table.tableList2 tr:hover {
	background: #FCEFEF;
} /* 마우스 커서가 올려진 경우라서 모바일에선 무용. :focus 가 아님에 유의 */
table.tableList2 th, table.tableList2 td, table.tableList4 th, table.tableList4 td{
	padding: 7px 3px 3px 3px;
	text-align: center;
	font-size: 9pt;
}

table.tableList2 th, table.tableList4 th{
	border-right: 1px #F3D7D7 solid;
	border-bottom: 1px #CFCFCF solid;
	color: #000000;
	background: #E3F2FF;
}

table.tableList2 th.end, table.tableList2 td.end,  table.tableList4 th.end,  table.tableList4 td.end{
	border-right: none;
}

table.tableList2 td, table.tableList4 td{
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList2 td.dot, table.tableList4 td.dot{
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList2 td.left, table.tableList4 td.left {
	text-align: left;
}

table.tableList2 td.right, table.tableList4 td.right {
	text-align: right;
}

table.tableList2 td img, table.tableList4 td img {
	vertical-align: middle;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
// 수강신청 과목조회
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
	function change_cate2(){
		var category2 = $("#category2").val();
		console.log(category2);
		
		if(category2 == "4"){
			$(".btn4").show();
			$(".btn5").hide();
			$(".btn6").hide();
			$("#gwamok2").show();
			$("#professor2").hide();
			$("#complete2").hide();
			$('#gwamok2').val("");
			$('#professor2').val("");
			$('#complete2').val("");
		}else if(category2 == "5"){
			console.log("in!!!!");
			$(".btn4").hide();
			$(".btn5").show();
			$(".btn6").hide();
			$("#gwamok2").hide();
			$("#professor2").show();
			$("#complete2").hide();
			$('#gwamok2').val("");
			$('#professor2').val("");
			$('#complete2').val("");
		}else if(category2 == "6"){
			$(".btn4").hide();
			$(".btn5").hide();
			$(".btn6").show();
			$("#gwamok2").hide();
			$("#professor2").hide();
			$("#complete2").show();
			$('#gwamok2').val("");
			$('#professor2').val("");
			$('#complete2').val("");
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
									"<td>"+"<button id='openSubCode' onclick='insertFinishSubjectApply();' value='"+list[i].openSubCode+"' style='cursor:pointer;'>"+"신청"+"</button>"+"</td>"+
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
										"<td>"+"<button id='openSubCode' onclick='insertFinishSubjectApply();' value='"+list[i].openSubCode+"' style='cursor:pointer;'>"+"신청"+"</button>"+"</td>"+
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
									"<td>"+"<button id='openSubCode' onclick='insertFinishSubjectApply();' value='"+list[i].openSubCode+"' style='cursor:pointer;'>"+"신청"+"</button>"+"</td>"+
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

function insertFinishSubjectApply(){
	
	var subCode = $("#openSubCode").val();
	console.log(subCode);
	
	$.ajax({
		url:"insertFinishSubjectApply.st",
		type:"post",
		data:{subCode:subCode},
		success:function(data){
			var key = data.modelAndView.modelMap;
			
			var val = key.check;
			switch(val){
				case "x" : alert('수강 신청 기간에 신청해주세요.'); break;
				case "ok" : alert('최종 수강 신청이 완료되었습니다.'); break;
				case "no" : alert('이미 신청한 과목이 있습니다.'); break;
				case "nono" : alert('이수 학점을 초과하였습니다.'); break;
				case "max" : alert('신청 인원을 초과하였습니다.'); break;
			}
			
		},
		error:function(err){
			console.log("실패!");
		}
	});
}
function gwamokSearch2(){
	var subName = $("#gwamok2").val();
	console.log(subName);
	$.ajax({
		url:"prliminaryGwamokSearch.st",
		type:"post",
		data:{subName:subName},
		success:function(data){
			var list = new Array();
			for(var i=0;i<data.list.length;i++){
				list[i] = data.list[i];
			}
			var count = 1;
			$( '.tableList4 > tbody').empty(); 
			for(var i=0;i<data.list.length;i++){
				 var table = $("<tr>"+
									"<td>"+count+"</td>"+
									"<td>"+list[i].completeType+"</td>"+
									"<td>"+list[i].openSubCode+"</td>"+
									"<td>"+list[i].subName+"</td>"+
									"<td>"+list[i].subGrade+"</td>"+
									"<td>"+list[i].professorName+"</td>"+
									"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
									"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
									"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
									"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"<button id='openSubCode' onclick='updateFinishSubjectApply();' value='"+list[i].openSubCode+"' style='cursor:pointer;'>"+"신청"+"</button>"+"</td>"+
								"</tr>");
				$(".tableList4").append(table);  				
				count++;
			} 	
		},
		error:function(err){
			console.log("실패!");
		}
	});
}

function professorSearch2(){
	var professor = $("#professor2").val();
	
	$.ajax({
		url:"prliminaryProfessorSearch.st",
		type:"post",
		data:{professor:professor},
		success:function(data){
			var list = new Array();
			for(var i=0;i<data.list.length;i++){
				list[i] = data.list[i];
			}
			var count = 1;
			$( '.tableList4 > tbody').empty(); 
			for(var i=0;i<data.list.length;i++){
				 var table = $("<tr>"+
									"<td>"+count+"</td>"+
									"<td>"+list[i].completeType+"</td>"+
									"<td>"+list[i].openSubCode+"</td>"+
									"<td>"+list[i].subName+"</td>"+
									"<td>"+list[i].subGrade+"</td>"+
									"<td>"+list[i].professorName+"</td>"+
									"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
									"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
									"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
									"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"<button id='openSubCode' onclick='updateFinishSubjectApply();' value='"+list[i].openSubCode+"' style=' cursor:pointer;'>"+"신청"+"</button>"+"</td>"+
								"</tr>");
				$(".tableList4").append(table);  				
				count++;
			} 	
		},
		error:function(err){
			console.log("실패!");
		}
	});
}
function completeSearch2(){
	var complete = $("#complete2").val();
	
	$.ajax({
		url:"prliminaryCompleteSearch.st",
		type:"post",
		data:{complete:complete},
		success:function(data){
			var list = new Array();
			for(var i=0;i<data.list.length;i++){
				list[i] = data.list[i];
			}
			var count = 1;
			$( '.tableList2 > tbody').empty(); 
			for(var i=0;i<data.list.length;i++){
				 var table = $("<tr>"+
									"<td>"+count+"</td>"+
									"<td>"+list[i].completeType+"</td>"+
									"<td>"+list[i].openSubCode+"</td>"+
									"<td>"+list[i].subName+"</td>"+
									"<td>"+list[i].subGrade+"</td>"+
									"<td>"+list[i].professorName+"</td>"+
									"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
									"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
									"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
									"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"<button id='openSubCode' onclick='updateFinishSubjectApply();' value='"+list[i].openSubCode+"' style='cursor:pointer;'>"+"신청"+"</button>"+"</td>"+
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
function updateFinishSubjectApply(){
	console.log("in!!!!!!");
	var subCode = $("#openSubCode").val();
	console.log(subCode);
	
	$.ajax({
		url:"updateFinishSubjectApply.st",
		type:"post",
		data:{subCode:subCode},
		success:function(data){
			var key = data.modelAndView.modelMap;
			var val = key.check;
			switch(val){
				case "x" : alert('수강 신청 기간에 신청해주세요.'); break;
				case "ok" : alert('최종 수강 신청이 완료되었습니다.'); break;
				case "no" : alert('이미 신청한 과목이 있습니다.'); break;
				case "nono" : alert('이수 학점을 초과하였습니다.'); break;
			}
		},
		error:function(err){
			console.log("실패!");
		}
	});
}
function finishSubjectApplyList(){
	$.ajax({
		url:"selectFinishSubjectApplyList.st",
		type:"post",
		success:function(data){
			var list = new Array();
			for(var i=0;i<data.list.length;i++){
				list[i] = data.list[i];
			}
			var count = 1;
			$( '.tableList2 > tbody').empty(); 
			for(var i=0;i<data.list.length;i++){
				 var table = $("<tr>"+
									"<td>"+count+"</td>"+
									"<td>"+list[i].completeType+"</td>"+
									"<td>"+list[i].openSubCode+"</td>"+
									"<td>"+list[i].subName+"</td>"+
									"<td>"+list[i].subGrade+"</td>"+
									"<td>"+list[i].professorName+"</td>"+
									"<td>"+list[i].dayInfo+'/'+list[i].timeInfo+"</td>"+
									"<td>"+list[i].roomName+'('+list[i].buildingName+')'+"</td>"+
									"<td>"+list[i].studentCount+'/'+list[i].studentMax+"</td>"+
									"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"</td>"+
									"<td>"+"<button id='openSubCode' onclick='deleteFinishSubjectApply();' value='"+list[i].openSubCode+"' style='cursor:pointer;'>"+"취소"+"</button>"+"</td>"+
								"</tr>");
				$(".tableList2").append(table);  				
				count++;
			}
			$("#str").empty();
			$("#str").append('<수강신청목록>');
			$("#search").empty();
			$("#search2").empty();
			$(".tableList3").empty();
			$(".tableList1").empty();
			$(".tableList4").remove();
			$("#str2").empty();
			$("#sa").remove();
			$("#br").remove();
		},
		error:function(err){
			console.log("실패!");
		}
	});
}
function deleteFinishSubjectApply(){
	var subCode = $("#openSubCode").val();
	
	console.log(subCode);
}
</script>
</head>
<body>
	<div id="menu" class="menu">
		<jsp:include page="common/menubar-CourseApply.jsp" />
	</div>
	<strong id="str"><수강신청></strong>
	<button onclick="finishSubjectApplyList();" style="float:right">수강신청 신청목록</button>
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
						 	<span><strong>학과</strong> : 
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
							<span class="btn1" onclick="deptSearch();" name="search_btn" id="search_btn" style="background:red; cursor:pointer;">조 회</span>
							<span class="btn2" onclick="gwamokSearch();" name="search_btn" id="search_btn" style="background:red; display:none; cursor:pointer;">조 회</span>
							<span class="btn3" onclick="professorGwamokSearch();" name="search_btn" id="search_btn" style="background:red; display:none; cursor:pointer;">조 회</span>
							&nbsp;&nbsp;&nbsp;
							<span class="apply" onclick="insertFinishSubjectApply();" style="background:skyblue; cursor:pointer;"> 신 청 </span>
						</span>
					</td>				
				</tr>
			</tbody>
		</table>
	<table class="tableList2" style="width: 100%">
		<thead>	
			<tr>
				<th width="2%">No</th>
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
				<th width="9%">비고</th>
				<th width="5%">신청</th>
			</tr>
		</thead>
		<tbody>
			<tr id="search">
				<td colspan="14"><font color="red">☞ 조회버튼을 클릭하세요.</font></td>
			</tr>
		</tbody>
	</table>
	<br id="br"><br id="br"><br id="br"><br id="br"><br id="br"><br id="br"><br id="br"><br id="br">
	<hr id="sa"><strong id="str2"><예비수강신청목록></strong>
	<table class="tableList1" width="100%">
		<tbody>
			<tr id="choice">
				<td>
					<span> &nbsp;&nbsp;&nbsp;<b>카테고리</b> : 
							<select name="category2" id="category2" onchange="change_cate2()" style="background-color: #FFD9EC;">
									<option value="4">과목 검색</option>
									<option value="5">교수 검색</option>
									<option value="6">이수구분</option>
							</select>&nbsp;&nbsp;&nbsp;
					</span>
					<span id="choice4" name="choice4" style="display:inline;"> 
						<span>
							<input type="text" id=gwamok2 size="25" placeholder="과목명을 입력하세요" onkeypress="if(event.keyCode==13) {gwamokSearch(); return false;}" >
							<input type="text" id="professor2" size="25" placeholder="교수명을 입력하세요" onkeypress="if(event.keyCode==13) {professorSearch(); return false;}" style="display:none;">
							<input type="text" id="complete2" size="25" placeholder="이수구분을 입력하세요" onkeypress="if(event.keyCode==13) {completeSearch(); return false;}" style="display:none;">
						</span>
					</span>&nbsp;&nbsp;&nbsp;
					<span class="btn4" onclick="gwamokSearch2();" id="search_btn" style="background:red; cursor:pointer;">조 회</span>
					<span class="btn5" onclick="professorSearch2();" id="search_btn" style="background:red; display:none; cursor:pointer;">조 회</span>
					<span class="btn6" onclick="completeSearch2();" id="search_btn" style="background:red; display:none; cursor:pointer;">조 회</span>
					&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</tbody> 
	</table>
	<table class="tableList4" style="width: 100%">
		<thead>	
			<tr>
				<th width="2%">No</th>
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
				<th width="9%">비고</th>
				<th width="5%">신청</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="openSubject" items="${ list2 }" varStatus="status">
			<tr id="search2">
				<td><c:out value="${ status.count }" /></td>
				<td><c:out value="${ openSubject.completeType }" /></td>
				<td><c:out value="${ openSubject.openSubCode }" /></td>
				<td><c:out value="${ openSubject.subName }" /></td>
				<td><c:out value="${ openSubject.subGrade }" /></td>
				<td><c:out value="${ openSubject.professorName }" /></td>
				<td><c:out value="${ openSubject.dayInfo }" /> / <c:out value="${ openSubject.timeInfo }" /></td>
				<td><c:out value="${ openSubject.roomName }" /> / <c:out value="${ openSubject.buildingName }" /></td>
				<td><c:out value="${ openSubject.studentCount }" /> / <c:out value="${ openSubject.studentMax }" /></td>
				<td><a style="color:red;">조회</a></td>
				<td></td>
				<td></td>
				<td><button id="openSubCode" onclick="updateFinishSubjectApply();" value="${ openSubject.openSubCode }" style="cursor:pointer;">신청</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
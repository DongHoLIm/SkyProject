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
/*예비수강신청*/
table {
	font-family: "돋움", "돋움체";
	font-size: 12px;
	color: #666666;
	text-decoration: none;
}
/*검색 테이블*/
table.tableList1 {
	table-layout: fixed;
	border-top: 1px #C0C0C0 solid;
	border-bottom: 1px #C0C0C0 solid;
	border-left: 1px #C0C0C0 solid;
	border-right: 1px #C0C0C0 solid;
}

table.tableList1 th, table.tableList1 td {
	padding: 7px 3px 3px 3px;
	font-size: 9pt;
}
/* table.tableList1 th {
		border-right:1px #F3D7D7 solid;
		border-bottom:1px #CFCFCF solid;
		color:#000000;
		background:#E3F2FF;
	} */
table.tableList1 td {
	border-right: 1px #F0F0F0 solid;
	border-bottom: 1px #CFCFCF dotted;
	vertical-align: center;
}

table.tableList1 td.dot {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
} /* 말줄임 */
table.tableList1 td.left {
	text-align: left;
}

table.tableList1 td.right {
	text-align: right;
}

table.tableList1 td img {
	vertical-align: middle;
}

table.tableList1 th.end, table.tableList2 td.end {
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<div id="menu" class="menu">
		<jsp:include page="common/menubar-CourseApply.jsp" />
	</div>
	<table class="tableList1" width="100%">
		<tbody>
			<tr id="choice">
				<td>
					<span> &nbsp;&nbsp;&nbsp;<b>카테고리</b> : 
							<select name="category" id="category" onchange="change_cate()" style="background-color: #FFD9EC;">
									<option value="0">과목 검색</option>
									<option value="1">교수 검색</option>
									<option value="2">이수구분</option>
							</select>&nbsp;&nbsp;&nbsp;
					</span>
					<span id="choice0" name="choice0" style="display:inline;"> 
						<span>
							<input type="text" id=gwamok size="25" placeholder="과목명을 입력하세요" onkeypress="if(event.keyCode==13) {gwamokSearch(); return false;}" >
							<input type="text" id="professor" size="25" placeholder="교수명을 입력하세요" onkeypress="if(event.keyCode==13) {professorSearch(); return false;}" style="display:none;">
							<input type="text" id="complete" size="25" placeholder="이수구분을 입력하세요" onkeypress="if(event.keyCode==13) {completeSearch(); return false;}" style="display:none;">
						</span>
					</span>&nbsp;&nbsp;&nbsp;
					<span class="btn1" onclick="gwamokSearch();" id="search_btn" style="background:red; cursor:pointer;">조 회</span>
					<span class="btn2" onclick="professorSearch();" id="search_btn" style="background:red; display:none; cursor:pointer;">조 회</span>
					<span class="btn3" onclick="completeSearch();" id="search_btn" style="background:red; display:none; cursor:pointer;">조 회</span>
					&nbsp;&nbsp;&nbsp;
					<span class="delete" onclick="deleteSubjectApply();" style="background:skyblue; cursor:pointer;"> 삭 제 </span>
				</td>
			</tr>
		</tbody> 
	</table>
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
			<c:forEach var="openSubject" items="${ list2 }" varStatus="status">
			<tr id="search">
				<td><input name='chk' type='checkbox' value="<c:out value="${ openSubject.openSubCode }" />"></td>
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
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function change_cate(){
			var category = $("#category").val();
			console.log(category);
			if(category == "0"){
				$(".btn1").show();
				$(".btn2").hide();
				$(".btn3").hide();
				$("#gwamok").show();
				$("#professor").hide();
				$("#complete").hide();
				$('#gwamok').val("");
				$('#professor').val("");
				$('#complete').val("");
			}else if(category == "1"){
				$(".btn1").hide();
				$(".btn2").show();
				$(".btn3").hide();
				$("#gwamok").hide();
				$("#professor").show();
				$("#complete").hide();
				$('#gwamok').val("");
				$('#professor').val("");
				$('#complete').val("");
			}else if(category == "2"){	
				$(".btn1").hide();
				$(".btn2").hide();
				$(".btn3").show();
				$("#gwamok").hide();
				$("#professor").hide();
				$("#complete").show();
				$('#gwamok').val("");
				$('#professor').val("");
				$('#complete').val("");
			}
		}
		
		function gwamokSearch(){
			var subName = $("#gwamok").val();
			
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
											"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
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
		$(function(){
			$('.tableList2').on('click','tbody tr',function(){
				 var checkbox = $(this).find('td:first-child :checkbox');
		            checkbox.attr('checked', !checkbox.is(':checked'));
			 });

		});
		function professorSearch(){
			var professor = $("#professor").val();
			
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
											"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
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
		function completeSearch(){
			var complete = $("#complete").val();
			
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
											"<td>"+"<a style='color:red;'>"+'조회'+"</a>"+"</td>"+
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
		function deleteSubjectApply(){
			var subCodeArr = new Array();
			var input = $("input[name=chk]:checked");
			input.each(function() {
				subCodeArr += $(this).val()+",";
			});
			var subCode = subCodeArr.split(',');
			subCode.pop();
			
			
			$.ajax({
				url:"deletePreliminaryCourseRegistration.st",
				type:"post",
				data:{subCode:subCode},
				success:function(data){
					alert('선택한 과목이 삭제되었습니다.');
					location.reload();
				},
				error:function(err){
					console.log("실패!");
				}
			});
		}
		
	</script>
</body>
</html>
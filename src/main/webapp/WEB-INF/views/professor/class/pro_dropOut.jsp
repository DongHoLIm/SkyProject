<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	.basic {
		padding: 10px 0px 0px 100px;
	}
	
	.dropOutInfo {
	   width: 85%;
	   text-align: center; 
	   margin: 0 auto;
	   border: 1px solid #dde1e3;
	}
	
	.enrollSpan:hover {
		cursor: pointer;
		color: red;
	}
	
	.pagingArea, .pagingArea2 {
		margin-top: 2%;
	}	
	
	.search {
		width: 85%;
		text-align: center;
		margin: 0 auto;
	}
	
	.searchArea {
		width: 14%;
		float: right;
		margin-bottom: 1%;
	}
	
	.searchArea2 {
		width: 14%;
		float: right;
		margin-bottom: 1%;
	}
	
	.inputArea {
		width: 20%;
		float: right;
		padding-left: 1%;
	}
	
	.inputArea2 {
		width: 20%;
		float: right;
		padding-left: 1%;
	}
	
	.btnArea {
		float: right;
		padding-left: 1%;
	}
	
	.btnArea2 {
		float: right;
		padding-left: 1%;
	}
	
	.h4Area {
		float: left;
		padding-left: 1%;
	}
</style>
<script>
	$(function(){
		var pdeptCode = $("#pdeptCode").val();
		
		$.ajax({
			url:"pro_DropOutList.si",
			type:"POST",
			data:{
				"pdeptCode":pdeptCode
			},
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
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>")
					
					$td1.text(data.list[i].dropNo);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].studentName);
					$td4.text(data.list[i].dropReason);
					$td5.text(data.list[i].dropDate);
					$td6.text(data.list[i].dropInterview);
					$td7.text(data.list[i].dropStatus);
					
					$span1.text("승인");
					$span1.addClass("enrollSpan");					
					
					$td8.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea").children().remove();
				$(".pagingArea").append($ul);
				
				$(".enrollSpan").click(function(){
					var dropNo = $(this).parents("tr").children().eq(0).text();
					
					if(confirm("[신청번호 : " + dropNo + "] 자퇴 승인 처리 하시겠습니까?") == true){
						$.ajax({
							url:"pro_DropOutEnroll.si",
							type:"POST",
							data:{
								"dropNo":dropNo,
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				}); // enrollSpan click 끝
			} // success 끝
		}); // 1번 ajax 끝
		
		$.ajax({
			url:"pro_DropOutList2.si",
			type:"POST",
			data:{
				"pdeptCode":pdeptCode
			},
			success:function(data){
				var $tbody = $("#tbody2");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].dropNo);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].studentName);
					$td4.text(data.list[i].dropReason);
					$td5.text(data.list[i].dropDate);
					$td6.text(data.list[i].dropInterview);
					$td7.text(data.list[i].interviewDate);
					$td8.text(data.list[i].dropStatus);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax2("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax2("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax2("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea2").children().remove();
				$(".pagingArea2").append($ul);
			} // success 끝
		}); // 2번 ajax 끝
	}); // onload function 끝
	
	function loadAjax(curr){
		var currentPage = curr;
		var pdeptCode = $("#pdeptCode").val();
		
		$.ajax({
			url:"pro_DropOutList.si",
			type:"POST",
			data:{
				"pdeptCode":pdeptCode,
				"currentPage":currentPage
			},
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
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>")
					
					$td1.text(data.list[i].dropNo);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].studentName);
					$td4.text(data.list[i].dropReason);
					$td5.text(data.list[i].dropDate);
					$td6.text(data.list[i].dropInterview);
					$td7.text(data.list[i].dropStatus);
					
					$span1.text("승인");
					$span1.addClass("enrollSpan");					
					
					$td8.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea").children().remove();
				$(".pagingArea").append($ul);
				
				$(".enrollSpan").click(function(){
					var dropNo = $(this).parents("tr").children().eq(0).text();
					
					if(confirm("[신청번호 : " + dropNo + "] 자퇴 승인 처리 하시겠습니까?") == true){
						$.ajax({
							url:"pro_DropOutEnroll.si",
							type:"POST",
							data:{
								"dropNo":dropNo,
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				}); // enrollSpan click 끝
			} // success 끝
		}); // 1번 ajax 끝
	} // loadAjax 끝
	
	function loadAjax2(curr){
		var currentPage = curr;
		var pdeptCode = $("#pdeptCode").val();
		
		$.ajax({
			url:"pro_DropOutList2.si",
			type:"POST",
			data:{
				"pdeptCode":pdeptCode,
				"currentPage":currentPage
			},
			success:function(data){
				var $tbody = $("#tbody2");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].dropNo);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].studentName);
					$td4.text(data.list[i].dropReason);
					$td5.text(data.list[i].dropDate);
					$td6.text(data.list[i].dropInterview);
					$td7.text(data.list[i].interviewDate);
					$td8.text(data.list[i].dropStatus);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax2("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax2("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax2("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea2").children().remove();
				$(".pagingArea2").append($ul);
			} // success 끝
		}); // 2번 ajax 끝
	} // loadAjax2 끝
	
	function successList(){
		var pdeptCode = $("#pdeptCode").val();
		
		$.ajax({
			url:"pro_DropOutList.si",
			type:"POST",
			data:{
				"pdeptCode":pdeptCode
			},
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
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>")
					
					$td1.text(data.list[i].dropNo);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].studentName);
					$td4.text(data.list[i].dropReason);
					$td5.text(data.list[i].dropDate);
					$td6.text(data.list[i].dropInterview);
					$td7.text(data.list[i].dropStatus);
					
					$span1.text("승인");
					$span1.addClass("enrollSpan");					
					
					$td8.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea").children().remove();
				$(".pagingArea").append($ul);
				
				$(".enrollSpan").click(function(){
					var dropNo = $(this).parents("tr").children().eq(0).text();
					
					if(confirm("[신청번호 : " + dropNo + "] 자퇴 승인 처리 하시겠습니까?") == true){
						$.ajax({
							url:"pro_DropOutEnroll.si",
							type:"POST",
							data:{
								"dropNo":dropNo,
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				}); // enrollSpan click 끝
			} // success 끝
		}); // 1번 ajax 끝
	} // successList 끝
	
	function successList2(){		
		var pdeptCode = $("#pdeptCode").val();
		
		$.ajax({
			url:"pro_DropOutList2.si",
			type:"POST",
			data:{
				"pdeptCode":pdeptCode
			},
			success:function(data){
				var $tbody = $("#tbody2");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].dropNo);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].studentName);
					$td4.text(data.list[i].dropReason);
					$td5.text(data.list[i].dropDate);
					$td6.text(data.list[i].dropInterview);
					$td7.text(data.list[i].interviewDate);
					$td8.text(data.list[i].dropStatus);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax2("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax2("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax2("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea2").children().remove();
				$(".pagingArea2").append($ul);
			} // success 끝
		}); // 2번 ajax 끝
	} // successList2 끝
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<br><br>
			<input type="hidden" id="pdeptCode" name="pdeptCode" value="${proInfo.pdeptCode}">
			
			<div class="search">
				<div class="h4Area">
					<h4>자퇴 신청 내역</h4>
				</div>
				<div class="btnArea">
					<button id="firstBtn">검색</button>
				</div>
				<div class="inputArea">
					<input type="text" id="searchValue" name="searchValue">	
				</div>
				<div class="searchArea">
					<select id="searchCondition" name="searchCondition">
						<option value="all">전체보기</option>
						<option value="dropNo">신청번호</option>
						<option value="studentNo">학번</option>
						<option value="studentName">이름</option>
					</select>		
				</div>				
			</div>
			<table class="dropOutInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">신청번호</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">사유</th>
						<th style="text-align: center">신청일자</th>
						<th style="text-align: center">면담여부</th>
						<th style="text-align: center">처리상태</th>
						<th style="text-align: center">관리</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagingArea">
			
			</div>	
			
			<br><br>
					
			<div class="search">
				<div class="h4Area">
					<h4>자퇴 처리 내역</h4>
				</div>
				<div class="btnArea2">
					<button id="secondBtn">검색</button>
				</div>
				<div class="inputArea2">
					<input type="text" id="searchValue2" name="searchValue2">	
				</div>
				<div class="searchArea2">
					<select id="searchCondition2" name="searchCondition2">
						<option value="all">전체보기</option>
						<option value="dropNo">신청번호</option>
						<option value="studentNo">학번</option>
						<option value="studentName">이름</option>
					</select>		
				</div>
			</div>
			<table class="dropOutInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">신청번호</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">사유</th>
						<th style="text-align: center">신청일자</th>
						<th style="text-align: center">면담여부</th>
						<th style="text-align: center">면담일자</th>
						<th style="text-align: center">처리상태</th>
					</tr>
				</thead>
				<tbody id="tbody2">
					
				</tbody>
			</table>
			<div class="pagingArea2">
			
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-professor.jsp" />
		</div>
	</div>
	<script>
	$(function(){
		$(".btnArea").hide();
		$(".inputArea").hide();
		$(".btnArea2").hide();
		$(".inputArea2").hide();
		
		$("#searchCondition").change(function(){
			var searchCondition = $(this).val();
			
			if(searchCondition == "all"){
				$(".btnArea").hide();
				$(".inputArea").hide();
				
				successList();
				
			}else if(searchCondition == "dropNo"){
				$(".btnArea").show();
				$(".inputArea").show();
			}else if(searchCondition == "studentNo"){
				$(".btnArea").show();
				$(".inputArea").show();
			}else if(searchCondition == "studentName"){
				$(".btnArea").show();
				$(".inputArea").show();
			}
			
			$("#firstBtn").click(function(){
				var searchCondition = $("#searchCondition").val();
				var searchValue = $("#searchValue").val();					
				
				$.ajax({
					url:"searchDropOut.si",
					type:"GET",
					data:{
						"searchCondition":searchCondition,
						"searchValue":searchValue
					},
					success:function(data){
						$("#searchValue").val("");
						
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
							var $td7 = $("<td style='text-align: center;'>");
							var $td8 = $("<td style='text-align: center;'>");
							var $span1 = $("<span>")
							
							$td1.text(data.list[i].dropNo);
							$td2.text(data.list[i].studentNo);
							$td3.text(data.list[i].studentName);
							$td4.text(data.list[i].dropReason);
							$td5.text(data.list[i].dropDate);
							$td6.text(data.list[i].dropInterview);
							$td7.text(data.list[i].dropStatus);
							
							$span1.text("승인");
							$span1.addClass("enrollSpan");					
							
							$td8.html($span1);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);
							
							$tbody.append($tr);
						}		
						
						$(".enrollSpan").click(function(){
							var dropNo = $(this).parents("tr").children().eq(0).text();
							
							if(confirm("[신청번호 : " + dropNo + "] 자퇴 승인 처리 하시겠습니까?") == true){
								$.ajax({
									url:"pro_DropOutEnroll.si",
									type:"POST",
									data:{
										"dropNo":dropNo,
									},
									success:function(data){
										successList();
										successList2();
									}
								})
							}
						}); // enrollSpan click 끝					
						
						$(".pagingArea").children().remove();						
					}
				});
			});
		});
		
		$("#searchCondition2").change(function(){
			var searchCondition = $(this).val();
			
			if(searchCondition == "all"){
				$(".btnArea2").hide();
				$(".inputArea2").hide();
				
				successList2();
				
			}else if(searchCondition == "dropNo"){
				$(".btnArea2").show();
				$(".inputArea2").show();
			}else if(searchCondition == "studentNo"){
				$(".btnArea2").show();
				$(".inputArea2").show();
			}else if(searchCondition == "studentName"){
				$(".btnArea2").show();
				$(".inputArea2").show();
			}
			
			$("#secondBtn").click(function(){
				var searchCondition = $("#searchCondition2").val();
				var searchValue = $("#searchValue2").val();					
				
				$.ajax({
					url:"searchDropOut2.si",
					type:"GET",
					data:{
						"searchCondition":searchCondition,
						"searchValue":searchValue
					},
					success:function(data){
						$("#searchValue2").val("");
						
						var $tbody = $("#tbody2");
						
						$tbody.children().remove();
						
						for(var i = 0; i < data.list.length; i++){
							var $tr = $("<tr>");
							var $td1 = $("<td style='text-align: center;'>");
							var $td2 = $("<td style='text-align: center;'>");
							var $td3 = $("<td style='text-align: center;'>");
							var $td4 = $("<td style='text-align: center;'>");
							var $td5 = $("<td style='text-align: center;'>");
							var $td6 = $("<td style='text-align: center;'>");
							var $td7 = $("<td style='text-align: center;'>");
							var $td8 = $("<td style='text-align: center;'>");
							
							$td1.text(data.list[i].dropNo);
							$td2.text(data.list[i].studentNo);
							$td3.text(data.list[i].studentName);
							$td4.text(data.list[i].dropReason);
							$td5.text(data.list[i].dropDate);
							$td6.text(data.list[i].dropInterview);
							$td7.text(data.list[i].interviewDate);
							$td8.text(data.list[i].dropStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);
							
							$tbody.append($tr);
						}						
						
						$(".pagingArea2").children().remove();						
					}
				});
			});
		});
	});
	</script>
</body>
</html>
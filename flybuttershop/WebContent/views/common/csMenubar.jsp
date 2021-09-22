<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.flybutter.member.model.vo.Member" %>
 
 <%
 	Member loginUser = (Member)session.getAttribute("loginMember");
	
	String contextPath = request.getContextPath();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style type="text/css">

#cslogo {
	font-weight: bold;
}

#container {
	background-color: lightgray;
	width: 1200px;
	height: 70px;
	padding: 10px;
}

#container1 {
	width: 1200px;
	height: 60px;
	padding: 10px;
}

#keyword {
	margin-right: 0px;
	padding-right: 0px;
	width: 600px;
}

#livechat {
	align: right;
}

.cs {
	margin-left: 20px;
}

.search {
	margin-left: 40px;
	margin-right: 0px;
	display: inline-flex;
}

.live {
	margin-left: 40px;
}

.searchbtn {
	margin-left: 0px;
}


</style>
</head>
<body style="margin: 0 auto">

<!-- 	<div class="container" id="container">

		<form class="form-inline">
			<div class="cs">
				<button class="btn btn-light btn-lg" id="cslogo"
					onclick="goCustomerService();" type="button">고객센터</button>
			</div>
			<div class="search">
				<input class="form-control mr-sm-2" id="keyword" name="sWord" type="text"
					placeholder="Search">
			</div>
	
			<div class="searchbtn">
				<button class="btn btn-light btn-lg btn-success" id="btnSearch" name="btnSearch" type="submit" onclick="goSearch();">Search</button>

			</div>
			
		</form>
	</div>
 -->
	<script>
		
		
	</script>


	<br>


	<div class="btn-group" id="container1">
		<button type="button" class="btn btn-outline-dark"
			onclick="goNotice();">공지사항</button>
		<button type="button" class="btn btn-outline-dark" onclick="goFAQ();">자주
			묻는 질문</button>
			
	<% if(loginUser.getUserNo() == 0){ %>  
		<button type="button" class="btn btn-outline-dark"
			onclick="goNoticeWrite();">글쓰기</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="goHelpAllList();">문의내역</button>
	<%}else { %>  
		<button type="button" class="btn btn-outline-dark"
			onclick="goHelpWrite();">1대1문의</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="goHelpList();">문의내역</button>
	<%} %> 
		
	</div>

	<script>
		$('#btnSearch').click(function() {
			if($('#keyword').val().length == -1 ){
				alert("검색할 단어를 입력해주세요");
			}else{
				$('#keyword').submit();
			}
		
		})
		
		function goSearch(){
			location.href="<%=request.getContextPath()%>/search.faq";
		}
		function goCustomerService(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
	
		function golivechat(){
			location.href="<%=request.getContextPath()%>/livechat";
			
		}
		function goNotice(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function goFAQ(){
			location.href="<%=request.getContextPath()%>/deliveryList.faq";
		}
		function goHelpWrite(){
			location.href="<%=request.getContextPath()%>/insertForm.help";
		}
		function goNoticeWrite(){
			location.href="<%=request.getContextPath()%>/insertForm.no";
		}
		function goHelpAllList(){
			location.href="<%=request.getContextPath()%>/listAll.help";
		}
		function goHelpList(){
			location.href="<%=request.getContextPath()%>/list.help";
		}
		
		$(function() {
			
			$('#mainCategory').css('box-sizing','unset');
		})
		      $(function() {
         
         $('#userSearch').css('box-sizing','unset');
      })
	</script>

	<hr>
	
</body>
</html>
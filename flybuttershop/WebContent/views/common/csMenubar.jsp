<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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

#searchbar {
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

hr {
	width: 1200px;
}

</style>
</head>
<body>

	<div class="container" id="container">

		<form class="form-inline">
			<div class="cs">
				<button class="btn btn-light btn-lg" id="cslogo"
					onclick="gocustomerservice" type="submit">고객센터</button>
			</div>
			<div class="search">
				<input class="form-control mr-sm-2" id="searchbar" type="text"
					placeholder="Search">
			</div>
			<div class="searchicon">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path
						d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
</svg>
			</div>

			<div class="searchbtn">
				<button class="btn btn-light btn-lg btn-success" type="submit">Search</button>

			</div>
			<div class="live">
				<button type="button" class="btn btn-dark btn-lg" id="livechat"
					onclick="golivechat();">실시간 채팅상담</button>
			</div>
		</form>
	</div>
	<script>
		function goNotice(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function golivechat(){
			location.href="<%=request.getContextPath()%>/livechat";
			
		}
		
	</script>


	<br>


	<div class="btn-group" id="container1">
		<button type="button" class="btn btn-outline-dark"
			onclick="goNotice();">공지사항</button>
		<button type="button" class="btn btn-outline-dark" onclick="goFAQ();">자주
			묻는 질문</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="goHelpWrite();">1대1문의</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="goHelpList();">문의내역</button>
	</div>

	<script>
		function goNotice(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function goFAQ(){
			location.href="<%=request.getContextPath()%>/deliveryList.faq";
		}
		function goHelpWrite(){
			location.href="<%=request.getContextPath()%>/write.help";
		}
		function goHelpList(){
			location.href="<%=request.getContextPath()%>/entireList.help";
		}
	</script>

	<hr>
	<script>
		function goEntireNoticeList(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function goNoticeList(){
			location.href="<%=request.getContextPath()%>/noticeList.no";
		}
		function goEventList(){
			location.href="<%=request.getContextPath()%>/eventList.no";
			}
		</script>

	<div class="btn-group" id="container1">


		<button type="button" class="btn btn-outline-dark"
			onclick="goEntireNoticeList();">전체</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="goNoticeList();">공지</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="goEventList();">이벤트</button>
	</div>


	<hr>
</body>
</html>
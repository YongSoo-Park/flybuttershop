<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.flybutter.notice.model.vo.*"%>

<%
ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
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

.outer {
	width: 1200px;
	height: 500px;
	color: black;
	margin: auto;
	margin-top: 50px;
}

.listArea {
	border: 1px solid black;
	text-align: center;
}

.searchArea {
	margin-top: 50px;
}

.listArea>tbody>tr:hover {
	background: black;
	cursor: pointer
}
</style>


</head>
<body>

	<!-- <%@ include file="../common/csMenubar.jsp" %> -->

	<section>
		<div class="container" id="container">

			<form class="form-inline" action="/action_page.php">
				<div class="cs">
					<button class="btn btn-light btn-lg" id="cslogo" type="submit">고객센터</button>
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

		<div class="btn-group" id="container1">


			<button type="button" class="btn btn-outline-dark"
				onclick="goEntireNoticeList();">전체</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goNoticeList();">공지</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goEventList();">이벤트</button>
		</div>

		<script>
		function goEntireNoticeList(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function goNoticeList(){
			location.href="<%=request.getContextPath()%>/noticeList.no";
		}
		function goEventList(){
			location.href="<%=request.getContextPath()%>
			/eventList.no";
			}
		</script>

		<hr>




		<div class="outer">

			<table class="listArea" align="center">
				<thead>
					<tr>
						<th width="100">글번호</th>
						<th width="300">글제목</th>
						<th width="100">작성자</th>
					</tr>
				</thead>
				<tbody>

					<%
					if (list.isEmpty()) {
					%>
					<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
					<%
					} else {
					%>
					<%
					for (Notice n : list) {
					%>
					<tr>
						<div>
							<a href=#none id="show"
								onclick="if(hide.style.display=='none') {hide.style.display='';show.innerText='▲'} else {hide.style.display='none';show.innerText='▼'}">▼</a>
							<div id="hide" style="display: none">
								펼치면 보이는 내용을 적어줍니다. <br /> 아무 내용이나 적어주세요. <br />
							</div>
						</div>

					</tr>
					<%
					}
					%>
					<%
					}
					%>
				</tbody>

			</table>

			<form class="searchArea" align="center">
				<select id="condition" name="condition">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select> <input type="search" name="search">
				<button type="submit">검색하기</button>
			</form>
			<br>
			<br>
			<div align="center"></div>

		</div>
		<script>
	
		
	</script>


	</section>

</body>
</html>
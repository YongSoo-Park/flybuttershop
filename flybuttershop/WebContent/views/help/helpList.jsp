<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.flybutter.help.model.vo.*"%>
<%@ page import="com.flybutter.member.model.vo.Member" %>
<%
Member loginUser = (Member)session.getAttribute("loginMember");
ArrayList<Help> list = (ArrayList<Help>) request.getAttribute("list");
PageInfo pi = (PageInfo)request.getAttribute("pi");

int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
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
<body style="margin: 0 auto">


<jsp:include page="../header_footer/header.jsp" flush="true"/>

	<section>
	<jsp:include page="../common/csMenubar.jsp" flush="true"/>
	
<div class="outer">
		
		        
		<table class="listArea" align="center">
			<thead>
				<tr>
					 <th width="100">번호</th>
					<th width="100">제목</th>
					<th width="300">날짜</th>
			
				</tr>
			</thead>
			<tbody>
				
				 <% if(list.isEmpty()){ %>
				 	<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
				 <% }else{  %>
				 	<% for(Help h : list){ %>
				 		<tr>
				 			<td ><%= h.getHelp_No()%></td>
				 			<td><%= h.getHelp_Title() %></td>
							<td><%= h.getHelp_Date() %></td>
							<td style="visibility:hidden;" ><%= h.getUser_No() %></td>
					
				 		</tr>
				 	<% } %>
				 <% } %>
			</tbody>
			
		</table>
	
		<br><br>
		<div align="center">
			
			<button onclick="goHelpInsertForm();">문의글작성</button> 
	
		</div>
	
	<script>
		

	
		
		
	
		function goHelpInsertForm(){
			location.href="<%=request.getContextPath()%>/insertForm.help";
		}
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var no = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.help?no="+no;
			})
		})
		<%}%>
		
		</script>
		
		<br><br>
		
		<!-- 페이징바 만들기 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.help?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/list.help?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath() %>/list.help?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= request.getContextPath() %>/list.help?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.help?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
		
	
	<script>
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var no = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.help?no="+no;
			})
		})
		<%}%>
	</script>
		
		
		
		
		
		
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.review.model.vo.*"%>
    
<%
	ArrayList<Review> list  = (ArrayList<Review>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 리뷰</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
<style>
	.outer{
		width:1200px;
		height:500px;
		margin:auto;
		margin-top:50px;
	}
	.listArea{
		border:1px solid white;
		text-align:center;
	}
	.listArea>tbody>tr:hover{
		background:darkgrey;
		cursor:pointer
	}
</style>
	
</head>
<body>
	 <jsp:include page="../header_footer/header.jsp" flush="true"/>
	
	     <div class="outer">
		<br>
		
        <h2 align="center">내가 작성한 리뷰</h2>
		<br>
		
		<table class="listArea" align="center">
			<thead>
				<tr>
                    <th width="100">번호</th>
                    <th width="200">상품명</th>
					<th width="300">제목</th>
					<th width="100">작성자</th>
					<th width="150">작성일</th>
				</tr>
			<thead>
			<tbody>
				<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="5">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Review r : list){ %>
					<tr>
						<td><%= r.getRe_no() %></td>
						<td><%= r.getpCode() %></td>
						<td><%= r.getRe_title() %></td>
						<td><%= r.getUser_no() %></td>
						<td><%= r.getRe_date() %></td>
					</tr>
					<%} %>
				<%} %>
			</tbody>
		</table>
		
		<br><br>
		
		<!-- 페이징바 만들기 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=contextPath%>/reviewList.rv?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= contextPath %>/reviewList.rv?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath %>/reviewList.rv?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= contextPath %>/reviewList.rv?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=contextPath%>/reviewList.rv?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
		<br><br>
		<div align="center">

		<button onclick="location.href='enrollForm.rv'">작성하기</button>

		</div>
	</div>
	<script>
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var bno = $(this).children().eq(0).text();
				location.href="<%= contextPath%>/reviewDetail.rv?rno="+rno;
			})
		})
		<%}%>
	</script>
</body>
</html>
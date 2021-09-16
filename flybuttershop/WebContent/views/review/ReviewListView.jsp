<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.review.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
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
		background: #F5D042;
		cursor:pointer
	}
</style>
	
</head>
<body style="margin: 0 auto">
	 <jsp:include page="../header_footer/header.jsp" flush="true"/>
	
	     <div class="outer">
		<br>
		
        <h2 align="center">내가 작성한 리뷰</h2>
		<br>
		
		<table class="listArea" align="center">
			<thead>
				<tr>
					<th width="200">글 번호</th>
                    <th width="200">상품명</th>
					<th width="300">제목</th>
					<th width="100">별점</th>
					<th width="150">작성일</th>
				</tr>
			<thead>
			<tbody>
				<%if(list.isEmpty()){ %>
				<tr>
					
					<td colspan="5"><b>아직 작성 된 리뷰가 없습니다</b></td>
					
				</tr>
				<%}else{ %>
					<% for(Review r : list){ %>
					<tr>
						<td><%= r.getRe_no() %></td>
						<td><%= r.getpName() %></td>
						<td><%= r.getRe_title() %></td>
						<td>
							<% int score =  r.getScore(); 
								pageContext.setAttribute("score", score);
							%>
							<c:choose>
  							<c:when test="${score == '1'}">★</c:when>
  							<c:when test="${score == '2'}">★★</c:when>
  							<c:when test="${score == '3'}">★★★</c:when>
  							<c:when test="${score == '4'}">★★★★</c:when>
  							<c:when test="${score == '5'}">★★★★★</c:when>
  							<c:otherwise>오류</c:otherwise>
							</c:choose>
						
						</td>
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

		<!-- <button onclick="location.href='enrollForm.rv'">작성하기</button> -->

		</div>
	</div>
	<script>
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var no = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.rv?no="+no;
			})
		})
		<%}%>
	</script>
	
	<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.review.model.vo.Review, com.flybutter.product.model.vo.* "%>
    
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int listCountR = pi.getListCount();
	int currentPageR = pi.getCurrentPage();
	int maxPageR = pi.getMaxPage();
	int startPageR = pi.getStartPage();
	int endPageR = pi.getEndPage();

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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
	.reviewList{
		border: 1px solid black;
		text-align: center;
	}
</style>
<script>
	$(function(){
		$(".reviewList>tbody>tr").click(function(){
			var rNo = $(this).children().eq(0).text();
			location.href="<%= request.getContextPath() %>/reviewDetail.sl?rNo="+rNo;
		})
	})
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2 align="center">판매 상품 후기 목록</h2><br>
	
	<table class="reviewList table-hover" align="center">
		<thead class="table-primary">
			<tr>
				<th>글번호</th>
				<th>상품코드</th>
				<th>작성자</th>
				<th>제목</th>
				<th>별점</th>
				<th>등록일</th>
				<th>답변여부</th>
			</tr>
		</thead>
		<tbody>
			<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="5">등록된 후기가 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(Review r : list){  %>
					<tr>
						<td><%= r.getRe_no() %></td>
						<td><%= r.getpCode() %></td>
						<td><%= r.getUserName()%></td>
						<td><%=r.getRe_title()%></td>
						<td><%=r.getScore()%></td>
						<td><%=r.getRe_date()%></td>
						<td><%=r.getRe_status()%></td>
					</tr>
				 	<% } %>
				 <% } %>	
		</tbody>
		
	</table>
	
	<br><br>
	
	<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/reviewManager.sl?currentPage=<%=currentPageR - 1%>'" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<!-- 이전페이지로(<) -->
				<%if (currentPageR == 1) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&lt;</a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/reviewManager.sl?currentPage=<%=currentPageR - 1%>'">&lt;</a></li>

				<%}%>


				<%for (int p = startPageR; p <= endPageR; p++) {%>

					<%if (p == currentPageR) {%>
						<button disabled><%=p%></button>
					<%} else {%>
						<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/reviewManager.sl?currentPage=<%=p%>'"><%=p%></a></li>
					<%}%>

				<%}%>
				<!-- 다음페이지로(>) -->
				<%if (currentPageR == maxPageR) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&gt; </a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/reviewManager.sl?currentPage=<%=currentPageR + 1%>'">&gt; </a></li>

				<%}%>
					<a class="page-link" onclick="location.href='<%=request.getContextPath()%>/reviewManager.sl?currentPage=<%=currentPageR + 1%>'" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
		
	<jsp:include page="../header_footer/footer.jsp" flush="true" />
	
</body>
</html>
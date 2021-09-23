<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.qna.model.vo.*, com.flybutter.product.model.vo.*"%>
    
<%
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");

	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int listCountQ = pi.getListCount();
	int currentPageQ = pi.getCurrentPage();
	int maxPageQ = pi.getMaxPage();
	int startPageQ = pi.getStartPage();
	int endPageQ = pi.getEndPage();

	
	String qCategory = null;
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
	.qnaList{
		border: 1px solid black;
		text-align: center;
	}
</style>
<script>
$(function(){
	$(".qnaList>tbody>tr").click(function(){
		var qNo = $(this).children().eq(0).text();
		location.href="<%= request.getContextPath() %>/qnaDetail.sl?qNo="+qNo;
	})
})
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2 align="center">판매 상품 Q&A 목록</h2><br>
	
	<table class="qnaList table-hover" align="center">
		<thead class="table-primary">
			<tr>
				<th>no</th>
				<th>상품코드</th>
				<th>문의유형</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>
				<th>답변여부</th>
			</tr>
		</thead>
		<tbody>
			<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="5">등록된 Q&A가 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(Qna q : list){  
					if(q.getQna_Category()==1){
						qCategory = "상품";
					}else if(q.getQna_Category()==2){
						qCategory = "배송";
					}else if(q.getQna_Category()==2){
						qCategory = "교환";
					}else if(q.getQna_Category()==2){
						qCategory = "반품";
					}else {
						qCategory = "기타";
					}
				%>
					<tr>
						<td><%=q.getQna_No() %></td>
						<td><%=q.getpCode() %></td>
						<td><%=qCategory %></td>
						<td><%=q.getQna_Writer()%></td>
						<td><%=q.getQna_Title()%></td>
						<td><%=q.getQna_Date()%></td>
						<td><%=q.getQna_Status()%></td>
					</tr>
				 	<% } %>
				 <% } %>	
		</tbody>
		
	</table>
	
	<br><br>
	
	<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/qnaManager.sl?currentPage=<%=currentPageQ - 1%>'" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<!-- 이전페이지로(<) -->
				<%if (currentPageQ == 1) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&lt;</a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/qnaManager.sl?currentPage=<%=currentPageQ - 1%>'">&lt;</a></li>

				<%}%>


				<%for (int p = startPageQ; p <= endPageQ; p++) {%>

					<%if (p == currentPageQ) {%>
						<button disabled><%=p%></button>
					<%} else {%>
						<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/qnaManager.sl?currentPage=<%=p%>'"><%=p%></a></li>
					<%}%>

				<%}%>
				<!-- 다음페이지로(>) -->
				<%if (currentPageQ == maxPageQ) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&gt; </a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/qnaManager.sl?currentPage=<%=currentPageQ + 1%>'">&gt; </a></li>

				<%}%>
					<a class="page-link" onclick="location.href='<%=request.getContextPath()%>/qnaManager.sl?currentPage=<%=currentPageQ + 1%>'" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
		
	<jsp:include page="../header_footer/footer.jsp" flush="true" />
	
</body>
</html>
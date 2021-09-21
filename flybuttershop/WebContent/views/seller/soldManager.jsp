<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.*, com.flybutter.product.model.vo.*"%>
    
<%
	ArrayList<ArrayList<SoldList>> purList = (ArrayList<ArrayList<SoldList>>)request.getAttribute("purList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%> 

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$(".pList>tbody>tr").click(function(){
			var pNo = $(this).children().eq(0).text();
			location.href="<%= request.getContextPath() %>/soldDetail.sl?pNo="+pNo;
		})
	})
$(function(){
	
})	

</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	<h2 align="center">접수된 주문 내역</h2><br>
	
	<table class="pList table table-hover"" aline="center">
		<thead>
			<tr class="table-primary">
				<th>주문번호</th>
				<th>주문일자</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<% if(purList.isEmpty()){ %>
				<tr>
					<td colspan="3">접수된 주문내역이 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(ArrayList<SoldList> s : purList){ 
					
					String satatus = String.valueOf(s.get(0).getpStatus());
					if(satatus.equals("1")){
						satatus = "결제완료";
					}else if(satatus.equals("2")){
						satatus = "배송전";
					}else if(satatus.equals("3")){
						satatus = "배송중";
					}else if(satatus.equals("4")){
						satatus = "배송완료";
					}else if(satatus.equals("5")){
						satatus = "소비자취소";
					}else if(satatus.equals("6")){
						satatus = "판매자취소";
					}else if(satatus.equals("7")){
						satatus = "구매후기 작성완료";
					}else if(satatus.equals("8")){
						satatus = "환불요청";
					}else if(satatus.equals("9")){
						satatus = "환불완료";
					}else{
						satatus = "오류";
					} %>
				<tr>
					<td><%=s.get(0).getPno()%></td>
					<td><%=s.get(0).getpDate()%></td>
					<td><%=satatus%></td>
				</tr>
			 	<% } %>
			 <% } %>	
			  
		</tbody>
	</table>
	
	<br><br>
	
	<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/purchaseManager.sl?currentPage=<%=currentPage - 1%>'" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<!-- 이전페이지로(<) -->
				<%if (currentPage == 1) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&lt;</a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/purchaseManager.sl?currentPage=<%=currentPage - 1%>'">&lt;</a></li>

				<%}%>


				<%for (int p = startPage; p <= endPage; p++) {%>

					<%if (p == currentPage) {%>
						<button disabled><%=p%></button>
					<%} else {%>
						<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/purchaseManager.sl?currentPage=<%=p%>'"><%=p%></a></li>
					<%}%>

				<%}%>
				<!-- 다음페이지로(>) -->
				<%if (currentPage == maxPage) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&gt; </a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/purchaseManager.sl?currentPage=<%=currentPage + 1%>'">&gt; </a></li>

				<%}%>
					<a class="page-link" onclick="location.href='<%=request.getContextPath()%>/purchaseManager.sl?currentPage=<%=currentPage + 1%>'" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
	
<jsp:include page="../header_footer/footer.jsp" flush="true"/>

</body>
</html>
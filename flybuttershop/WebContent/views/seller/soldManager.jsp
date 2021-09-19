<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.*, com.flybutter.purchase.model.vo.*"%>
    
<%
	ArrayList<SoldList> soldList = (ArrayList<SoldList>)request.getAttribute("soldList");
	ArrayList<Purchase> pList = (ArrayList<Purchase>)request.getAttribute("pList");
	
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
	
	<table class="pList" aline="center">
		<thead>
			<th>주문번호</th>
			<th>주문일자</th>
			<th>상태</th>
		</thead>
		<tbody>
			<% if(soldList.isEmpty()){ %>
				<tr>
					<td colspan="3">접수된 주문내역이 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(SoldList s : soldList){ 
					String satatus = null;
					if(s.getpStatus().equals("1")){
						satatus = "결제완료";
					}else if(s.getpStatus().equals("2")){
						satatus = "배송전";
					}else if(s.getpStatus().equals("3")){
						satatus = "배송중";
					}else if(s.getpStatus().equals("4")){
						satatus = "배송완료";
					}else if(s.getpStatus().equals("5")){
						satatus = "소비자취소";
					}else{
						satatus = "판매자취소";
					}
					
				%>
				<tr>
						<td><%=s.getPno()%></td>
						<td><%=s.getpDate()%></td>
						<td><%=satatus%></td>
					</tr>
				 	<% } %>
				 <% } %>	
		</tbody>
	</table>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>

</body>
</html>
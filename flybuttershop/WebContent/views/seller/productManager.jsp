<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.product.model.vo.Product"%>
	
	<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");

	%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.pList{
		border: 1px solid black;
		text-align: center;
	}
</style>
<script>
	$(function(){
		$(".pList>tbody>tr").click(function(){
			var pcode = $(this).children().eq(0).text();
			location.href="<%= request.getContextPath() %>/productDetail.sl?pcode="+pcode;
		})
	})
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2 align="center">판매 상품 목록</h2><br>
	
	<button type="button" class="btn btn-outline-dark" onclick="location.href='<%=request.getContextPath()%>/insertProduct.pr'">상품등록</button>
	
	<table class="pList" align="center">
		<thead>
			<tr>
				<th>상품코드</th>
				<th>대분류</th>
				<th>중분류</th>
				<th>상품명</th>
				<th>상품옵션</th>
				<th>가격</th>
				<th>재고수량</th>
				<th>등록일</th>
				<th>상태</th>
				<th>세일여부</th>
			</tr>
		</thead>
		<tbody>
			<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="5">등록한 상품이 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(Product p : list){ %>
					<tr>
						<td><%= p.getpCode() %></td>
						<td><%= p.getpCategory() %></td>
						<td><%= p.getpCategory2() %></td>
						<td><%= p.getpName() %></td>
						<td><%= p.getpOption() %></td>
						<td><%= p.getPrice() %></td>
						<td><%= p.getpStock() %></td>
						<td><%= p.getpDate() %></td>
						<td><%= p.getpStatus() %></td>
						<td><%= p.getSale_Flag() %></td>
					</tr>
				 	<% } %>
				 <% } %>		
		</tbody>
		
	</table>
	
	

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
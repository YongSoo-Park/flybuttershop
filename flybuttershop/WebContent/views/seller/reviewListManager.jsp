<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.review.model.vo.*"%>
    
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
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
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2 align="center">판매 상품 후기 목록</h2><br>
	
	<table class="reviewList" align="center">
		<thead>
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
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
				<% for(Review r : list){  
					
				%>
					<tr>
						<td><%= r.getpCode() %></td>
						<td><%= r.getUser_no()%></td>
						<td><%=%></td>
						<td><%=%></td>
						<td><%=%></td>
					</tr>
				 	<% } %>
				 <% } %>	
		</tbody>
		
	</table>
		
	<jsp:include page="../header_footer/footer.jsp" flush="true" />
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.qna.model.vo.*"%>
    
<%
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
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
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2 align="center">판매 상품 Q&A 목록</h2><br>
	
	<table class="qnaList" align="center">
		<thead>
			<tr>
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
						<td><%=qCategory %></td>
						<td><%=q.getUser_No()%></td>
						<td><%=q.getQna_Title()%></td>
						<td><%=q.getQna_Date()%></td>
						<td><%=q.getQna_Status()%></td>
					</tr>
				 	<% } %>
				 <% } %>	
		</tbody>
		
	</table>
		
	<jsp:include page="../header_footer/footer.jsp" flush="true" />
	
</body>
</html>
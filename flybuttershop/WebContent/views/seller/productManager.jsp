<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.product.model.vo.Product"%>
	
	<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	String c1 = null;
	String c2 = null;
	String option = null;
	String status = null;
	String sale = null;
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

	<h2 align="center">상품 목록</h2><br>
	
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
				<% for(Product p : list){ 
					if(p.getpCategory()==1){
						c1 = "의류"; 
						if(p.getpCategory2()==1) { 
							c2 = "여성상의"; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "원피스"; 
						}else if(p.getpCategory2() == 3) {
							c2 = "여성하의"; 
						}else if(p.getpCategory2() == 4) {
							c2 = "남성상의";
						}else{
							c2 = "남성하의";
						}
					}else if(p.getpCategory()==2){
						if(p.getpCategory2()==1) { 
							c2 = "모자 "; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "가방 "; 
						}else if(p.getpCategory2() == 3) {
							c2 = "시계 "; 
						}else if(p.getpCategory2() == 4) {
							c2 = "신발";
						}else{
							c2 = "벨트";
						}
					}else if(p.getpCategory()==3){
						c1 = "뷰티 "; 
						if(p.getpCategory2()==1) { 
							c2 = "기초 "; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "베이스메이크업"; 
						}else if(p.getpCategory2() == 3) {
							c2 = "아이메이크업 "; 
						}else if(p.getpCategory2() == 4) {
							c2 = "립메이크업";
						}else{
							c2 = "바디";
						}
					}else if(p.getpCategory()==4){
						c1 = "식/음료"; 
						if(p.getpCategory2()==1) { 
							c2 = "차/음료"; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "커피 "; 
						}else if(p.getpCategory2() == 3) {
							c2 = "스낵 "; 
						}else if(p.getpCategory2() == 4) {
							c2 = "운동보조식품";
						}else{
							c2 = "영양제";
						}
					}else if(p.getpCategory()==5){
						c1 = "가구"; 
						if(p.getpCategory2()==1) { 
							c2 = "가구커버 "; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "걸이용품"; 
						}else if(p.getpCategory2() == 3) {
							c2 = "악세서리"; 
						}
					}else if(p.getpCategory()==6){
						c1 = "전자기기 "; 
						if(p.getpCategory2()==1) { 
							c2 = "주방기기"; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "생활가전 "; 
						}else if(p.getpCategory2() == 3) {
							c2 = "음향기기 "; 
						}else if(p.getpCategory2() == 4) {
							c2 = "컴퓨터 주변기기";
						}else{
							c2 = "웨어러블기기";
						}
					}else if(p.getpCategory()==7){
						c1 = "생필품 "; 
						if(p.getpCategory2()==1) { 
							c2 = "세탁세제 "; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "주방세제 "; 
						}else if(p.getpCategory2() == 3) {
							c2 = "욕실용품"; 
						}else if(p.getpCategory2() == 4) {
							c2 = "구강/위생용품";
						}else{
							c2 = "기타";
						}
					}else if(p.getpCategory()==8){
						c1 = "반려동물"; 
						if(p.getpCategory2()==1) { 
							c2 = "사료"; 
						}else if(p.getpCategory2() == 2) { 
							c2 = "장난감"; 
						}else if(p.getpCategory2() == 3) {
							c2 = "영양간식"; 
						}else if(p.getpCategory2() == 4) {
							c2 = "산책용품";
						}else{
							c2 = "미용용품";
						}
					}
					
					
					if(p.getpOption() == null){
						option = "없음";
					}else{
						option = p.getpOption();
					}
					if(p.getpStatus().equalsIgnoreCase("IN")){
						status = "판매중";
					}else{
						status = "품절";
					}
					if(p.getSale_Flag()==1){
						sale = "세일적용";
					}else{
						sale = "세일미적용";
					}
					 %>
				
					<tr>
						<td><%= p.getpCode() %></td>
						<td><%= c1 %></td>
						<td><%= c2 %></td>
						<td><%= p.getpName() %></td>
						<td><%= option %></td>
						<td><%= p.getPrice() %></td>
						<td><%= p.getpStock() %></td>
						<td><%= p.getpDate() %></td>
						<td><%=status%></td>
						<td><%=sale%></td>
					</tr>
				 	<% } %>
				 <% } %>		
		</tbody>
		
	</table>
	
	

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
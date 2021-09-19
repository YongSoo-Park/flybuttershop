<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.product.model.vo.Product"
    %>
<%
	Product p = (Product)request.getAttribute("p");	
	
String c1 = null;
String c2 = null;
String option = null;
String status = null;
String sale = null;
	
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

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
        .pimage{
            width: 200px;
            text-align: center;
        }
        .index{
            width: 80px;
            text-align: center;
        }
        .info{
            width: 500px;
            text-align: center;
        }
        .infoImg{
        	 text-align: center;
        }
       
  </style>
<script>
function updateProduct(){
	$("#postForm").attr("action", "<%=request.getContextPath()%>/updateForm.pr")
	$("#postForm").submit();
			
}

function deleteProduct(){
	const result = confirm("상품을 정말 삭제하시겠습니까?");
	
	if(result){
		$("#postForm").attr("action", "<%=request.getContextPath()%>/deleteProduct.pr");
		$("#postForm").submit();
	}
}

</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
		
		<h2>상품 상세 관리</h2>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<button type="button" class="btn btn-outline-primary me-md-2" onclick="updateProduct();">상품 수정</button>
			<button type="button" class="btn btn-outline-danger" onclick="deleteProduct();">상품 삭제</button>
		</div>
		<br>
		
		<div class="topInfo">
		<table border="1">
        <tr>
            <td colspan="2" rowspan="11" class="pimage"><img src="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}"></td>
            <td class="index">상품코드</td>
             <td class="info" name="pCode" value="<%=p.getpCode() %>"><%=p.getpCode() %></td>
        </tr>
        <tr>
            <td class="index">대분류</td>
            <td class="info" name="pCategory" value="<%=p.getpCategory() %>"><%=c1 %></td>
        </tr>
        <tr>
            <td class="index">중분류</td>
            <td class="info" name="pCategory2" value="<%=p.getpCategory2() %>"><%=c2 %></td>
        </tr>
        <tr>
            <td class="index">상품명</td>
            <td class="info" name="pName"><%=p.getpName() %></td>
        </tr>
        <tr>
            <td class="index">상품옵션</td>
            <td class="info" name="pOption" value="<%=p.getpOption()%>"><%=option%></td>
        </tr>
        <tr>
            <td class="index">가격</td>
            <td class="info" name="price"><%=p.getPrice()%></td>
        </tr>
        <tr>
            <td class="index">재고</td>
            <td class="info" name="pStock"><%=p.getpStock() %></td>
        </tr>
        <tr>
            <td class="index">상태</td>
            <td class="info" name="pStatus" value="<%=p.getpStatus() %>"><%=status%></td>
        </tr>
        <tr>
            <td class="index">세일여부</td>
            <td class="info" name="sale" value="<%=p.getSale_Flag() %>"><%=sale%></td>
        </tr>
        <tr>
            <td class="index">등록일</td>
            <td class="info" name="pDate"><%=p.getpDate() %></td>
        </tr>
        <tr>
            <td class="index">별점</td>
            <td class="info"><%=p.getScore_Avg() %></td>
        </tr>
        <tr>
        	<td colspan="4" class="infoImg">
        		<img src="${pageContext.request.contextPath}${requestScope.p.pExp_Image_Origin}">
        	</td>
        </tr>
        

    </table>
	</div>
	
		<form action="" id="postForm" method="post">
			<input type="hidden" name="pCode" value="<%= p.getpCode() %>">
			<input type="hidden" name="pName" value="<%= p.getpName() %>">
		</form>
	


<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.product.model.vo.Product"%>
	
	<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");

	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>판매 상품 목록</h2>
	
	<table border="1px">
		<tr>
			<td>상품코드</td>
			<td>상품명</td>
			<td>상품옵션</td>
			<td>상품가격</td>
			<td>상품재고</td>
		</tr>
		<tr>
			<td>상품코드</td>
			<td>상품명</td>
			<td>상품옵션</td>
			<td>상품가격</td>
			<td>상품재고</td>
		</tr>
	
	</table>


</body>
</html>
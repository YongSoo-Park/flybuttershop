<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>상품 정보 수정</h2>
	
	<form id="productInsert" action="<%= request.getContextPath() %>/update.pr">
		상품코드 : <input type="text" name="pCode"><br><br>
		상품명 : <input type="text" name="pName"><br><br>
		상품 카테고리 : 
		<select id="category" name="category">
			<option value="1">1.의류</option>
			<option value="2">2.잡화</option>
			<option value="3">3.뷰티</option>
			<option value="4">4.식품</option>
			<option value="5">5.가구</option>
			<option value="6">6.전자기기</option>
			<option value="7">7.생필품</option>
			<option value="8">8.반려동물</option>
		</select><br><br>
		상품수량 : <input type="text" name="pStock"><br><br>
		상품가격 : <input type="text" name="price"><br><br>
		상품옵션 : <input type="text" name="option"><br><br> 
		상품이미지 : <input type="file" name="pimg_origin"><br><br>
		상품설명이미지 : <input type="file" name="pexpimg_origin"><br><br>
		상품세일여부 : 
		<select name="saleFlag">
			<option value="">세일안함</option>
			<option value="">세일적용</option>
		</select><br><br>
		
		<button type="submit">수정하기</button>
		<button type="reset" onclick="">취소</button>
	
	</form>

</body>
</html>
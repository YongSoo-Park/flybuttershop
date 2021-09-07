<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.seller.model.vo.Seller"%>
    
    <%
	Seller sel = ((Seller)request.getAttribute("loginSeller"));

	String storeName = sel.getStore_Name();
	String phone = sel.getPhone();
	String address = sel.getAddress();
	String email = sel.getEmail();
	String storeExp = sel.getStore_Exp();

%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>상점 정보 수정</h2>
	
	<form id="sellerUpdate" action="<%= request.getContextPath() %>/update.sl" method="post">
		
		상점이름 : <input type="text" name="storeName" value="<%=storeName%>"> <br><br>
		연락처 : <input type="text" name="phone" value="<%= phone %>"><br><br>
		이메일 : <input type="text" name="email" value="<%= email %>"><br><br>
		소재지 : <input type="text" name="address" value="<%= address %>"><br><br>
		상점소개 : <input type="text" name="stoewExp" value="<%= storeExp %>"><br><br>

		<button type="submit" id="updateBtn">수정하기</button> 
	
	</form>

</body>
</html>
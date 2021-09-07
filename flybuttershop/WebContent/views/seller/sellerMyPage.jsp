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

	<%@ include file="../common/sellerMenuBar.jsp" %>
	
	상점이름 : <p><%= storeName %></p><br><br>
	대표자 : <p><%= storeName %><br><br>
	연락처 : <p><%= phone %><br><br>
	이메일 : <p><%= email %><br><br>
	소재지 : <p><%= address %><br><br>
	상점소개 : <p><%= storeExp %><br><br>
	
	
	




</body>
</html>
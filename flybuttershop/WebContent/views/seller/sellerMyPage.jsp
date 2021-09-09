<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	
	상점이름 : <p name="storeName">${requestScope.seller.store_Name}</p> <br><br>
	소재지 : ${requestScope.seller.store_Address}<br><br>
	사업자번호 : ${requestScope.seller.seller_No}<br><br>
	계좌번호 : ${requestScope.seller.store_Account}<br><br>
	상점소개 : ${requestScope.seller.store_Exp}<br><br>
	
	<button type="button" class="btn btn-outline-dark" onclick="location.href='<%=request.getContextPath()%>/updateForm.sl'">정보 수정</button>
	
	

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
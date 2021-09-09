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

	<h2>상점 정보 수정</h2>
	
	<form id="sellerUpdate" action="<%= request.getContextPath() %>/updateStore.sl" method="post">
		
		상점이름 : <input type="text" name="storeName" value="${requestScope.seller.store_Name}" readonly="readonly"> <br><br>
		소재지 : <input type="text" name="address" value="${requestScope.seller.store_Address}"><br><br>
		사업자번호 : <input type="text" name="sellerNo" value="${requestScope.seller.seller_No}"><br><br>
		계좌번호 : <input type="text" name="account" value="${requestScope.seller.store_Account}"><br><br>
		상점소개 : <textarea class="form-control" id="storeExp" cols="10" row="5" name="storeExp">${requestScope.seller.store_Exp}</textarea><br><br>

		<button type="submit" class="btn btn-outline-primary">수정하기</button>
		<button type="button" class="btn btn-outline-secondary" onclick="cancelUpdateStore();">취소</button>
	
	</form>

</body>
</html>
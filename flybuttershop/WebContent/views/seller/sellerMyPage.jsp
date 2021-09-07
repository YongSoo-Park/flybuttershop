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
	
	
	상점이름 : ${requestScope.seller.store_Name} <br><br>
	
	대표자 : <br><br>
	연락처 : <br><br>
	이메일 : <br><br>
	소재지 : <br><br>
	상점소개 : <br><br>
	
	
	



<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
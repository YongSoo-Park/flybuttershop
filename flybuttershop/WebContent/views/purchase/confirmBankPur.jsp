<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<style>
.lb2{
	position: relative;
    left: 300px;
}
</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<div class="outer">
    <div class="logo">
		<br>
		<h2 id="basketlogo"><b id="free">결제가 완료되었습니다!</b></h2>
		<br><br>
	<h3>결제정보</h3>
	<hr>
	<label class = "lb1">결제수단</label><label class = "lb2" id="ll1">무통장입금</label><br>
	<label class = "lb1">입금하실 은행</label><label class = "lb2" id="ll2"></label><br>
	<label class = "lb1">입금하실 계좌번호</label><label class = "lb2" id="ll3"></label><br>
	<label class = "lb1">가상계좌 입금마감시간</label><label class = "lb2" id="ll4"></label><br>
	<br><br>
	<h3>주문정보</h3>
	<hr>
	<label class = "lb1">주문번호</label><label class = "lb2" id="ll5"></label><br>
	<label class = "lb1">결제금액</label><label class = "lb2" id="ll6"></label><br>
	<label class = "lb1">상품명</label><label class = "lb2" id="ll7"></label><br>
	
	</div>
</div>

</body>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
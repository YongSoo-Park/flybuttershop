<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String bank = (String)request.getAttribute("bank");
String dTime = (String)request.getAttribute("dTime");
String accNo = (String)request.getAttribute("accNo");
int purPrice = (int)request.getAttribute("purPrice");
String purName = (String)request.getAttribute("purName");
int plusMoney = (int)request.getAttribute("plusMoney");
int moneyDc = (int)request.getAttribute("moneyDc");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>무통장입금 결제확인</title>
<style>
.lb2{
	position: relative;
    left: 300px;
}
#ll1{
position: relative;
    left: 300px;
}
#ll2{
position: relative;
    left: 265px;
}
#ll3{
position: relative;
    left: 235px;
}
#ll4{
position: relative;
    left: 205px;
}
#ll5{
position: relative;
    left: 300px;
}
#ll6{
position: relative;
    left: 312px;
}
#purBtn{
position: relative;
    left: 550px;
 	padding: 20px;
      font-size: 20px;
      border-radius: 5px;
    border: unset;
    color: white;
    background-color: rgb(37, 37, 37);
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
	<label class = "lb1">입금하실 은행</label><label class = "lb2" id="ll2"><%=bank %>은행</label><br>
	<label class = "lb1">입금하실 계좌번호</label><label class = "lb2" id="ll3"><%=accNo %></label><br>
	<label class = "lb1">가상계좌 입금마감시간</label><label class = "lb2" id="ll4"><%=dTime %></label><br>
	<br><br>
	<h3>주문정보</h3>
	<hr>
	<label class = "lb1">결제금액</label><label class = "lb2" id="ll5"><%=purPrice %>원</label><br>
	<label class = "lb1">상품명</label><label class = "lb2" id="ll6"><%=purName %></label><br>
	<br><br>
	<button id="purBtn" onclick="end();">쇼핑 계속하기</button>
	</div>
	<form id="purForm">
	<input type="hidden" name="plusMoney" value="<%=plusMoney%>">
	<input type="hidden" name="moneyDc" value="<%=moneyDc%>">
	</form>
</div>

</body>
<script>
function end(){
	
	$("#purForm").attr("action", "<%=request.getContextPath()%>/changePurStatus.hy");
	$("#purForm").submit();
			
};
</script>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
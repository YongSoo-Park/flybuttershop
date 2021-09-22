<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.util.ArrayList, com.flybutter.seller.model.vo.*"%>

<%
ArrayList<SoldList> sList = (ArrayList<SoldList>)request.getAttribute("sList");
SoldList s = (SoldList)request.getAttribute("s");

String pt = null;
if(s.getPurType()==1){
	pt = "무통장입금";
}else{
	pt = "카드결제";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
<style>
	
</style>
<script>
	function updateDel(){
		$("#postForm").attr("action", "<%=request.getContextPath()%>/insertDel.sl");
		$("#postForm").submit();
				
	}
	function cancelPur(){
		 const result = confirm("주문을 취소하시겠습니까? 승인 후에는 취소할 수 없습니다.")
		 if(result){
			$("#postForm").attr("action", "<%=request.getContextPath()%>/cancelPur.sl");
			$("#postForm").submit();
		 }
	}
	function refund(){
		 const result = confirm("환불을 승인하시겠습니까? 승인 후에는 취소할 수 없습니다.")
		 if(result){
			$("#postForm").attr("action", "<%=request.getContextPath()%>/refund.sl");
			$("#postForm").submit();
		 }
	}
	function confirmPur(){
		 const result = confirm("주문을 승인하시겠습니까? 승인 후에는 취소할 수 없습니다.")
		 if(result){
			 $("#postForm").attr("action", "<%=request.getContextPath()%>/confirmPur.sl");
			 $("#postForm").submit();
		 }
		
				
	}
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	<h2>주문 내역</h2>
	<h3>주문 번호 : <%=s.getPno()%></h3>
	<div>
		<button type="button" class="btn btn-outline-secondary" onclick="history.go(-1)">목록으로</button>
	<% int status = sList.get(0).getpStatus();
	   if(status == 1){ %>
	    <button type="button" class="btn btn-outline-danger" onclick="cancelPur();">판매취소</button>
	    <button type="button" class="btn btn-outline-success" onclick="confirmPur();">주문접수</button>
	<% }else if(status == 2){%>
		<button type="button" class="btn btn-outline-primary" onclick="updateDel();">배송정보입력</button>
	<% }else if(status == 8){ %>
		<button type="button" class="btn btn-outline-primary" onclick="refund();">환불완료</button>
	<%} %>
	 </div>
	
	 <form action="" id="postForm" method="post">
	
	<table border="1" id="soldInfo" class="soldInfo">
        <tr class="table-primary">
            <td colspan="4">주문자 정보</td>
        </tr>
        <tr>
            <td>이름</td>
            <td colspan="3"><%=s.getUserName()%></td>
        </tr>
        <tr>
            <td>연락처</td>
            <td colspan="3"><%=s.getPhone() %></td>
        </tr>
        <tr>
            <td>주소</td>
            <td colspan="3"><%=s.getPurAddress() %></td>
        </tr>
        <tr>
            <td>결제정보</td>
            <td colspan="3"><%=pt %></td>
        </tr>
        <tr>
            <td>배송정보</td>
            
            <td colspan="3">
            	<%=s.getDelNo()%>
            </td>
           
        </tr>
        <tr class="table-primary">
            <td colspan="4">판매 상품 내역</td>
        </tr>
        <table>
        	<thead>
        		<th>상품명</th>
        		<th>상품옵션</th>
        		<th>수량</th>
        	</thead>
        	<tbody>
        	<% if(sList.isEmpty()){ %>
				<tr>
					<td colspan="3">접수된 주문내역이 없습니다.</td>
				</tr>
			<% }else{ %>
        		<%for(SoldList sl : sList) {
        			
        		%>
        			<tr>
						<td><%=sl.getpName()%></td>
						<td><%=sl.getpOption()%></td>
						<td><%=sl.getpAmount()%></td>
					</tr>
        		<%} %>
        	<%} %>
        	</tbody>
        	
        	<tfoot>
        		<tr class="table-warning">
        			<td></td>
        			<td></td>
        			<td>총 금액</td>
        			<td><%=s.getPurPrice()%>원</td>
        		</tr>
        	</tfoot>
        </table>
    </table>
   		<input type="hidden" name="pNo" value="<%=s.getPno()%>">
   		<input type="hidden" name="price" value="<%=s.getPurPrice()%>">
   		<input type="hidden" name="userNo" value="<%=s.getUserNo()%>">
	</form>
	
	
    
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
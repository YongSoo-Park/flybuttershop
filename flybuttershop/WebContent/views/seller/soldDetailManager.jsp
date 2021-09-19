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
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	<h2>주문 내역</h2>
	<h3>주문 번호 : <%=s.getPno()%></h3>
	
	
	<table border="1" id="soldInfo" class="soldInfo">
        <tr>
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
            	<button type="button" onclick="updateDel();">배송정보입력</button>
            </td>
           
        </tr>
        <tr>
            <td colspan="4">판매 상품 내역</td>
        </tr>
        <table>
        	<thead>
        		<th>상품코드</th>
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
						<td><%=sl.getpCode()%></td>
						<td><%=sl.getpOption()%></td>
						<td><%=sl.getpAmount()%></td>
					</tr>
        		<%} %>
        	<%} %>
        	</tbody>
        	
        	<tfoot>
        		<tr>
        			<td></td>
        			<td>총 금액</td>
        			<td><%=s.getPurPrice()%></td>
        		</tr>
        	</tfoot>
        </table>
    </table>
    
    <form action="" id="postForm" method="post">
   		<input type="hidden" name="pNo" value="<%=s.getPno()%>">
	</form>
	
	
    
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
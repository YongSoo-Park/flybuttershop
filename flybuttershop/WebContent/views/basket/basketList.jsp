<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.basket.model.vo.*, 
    java.util.ArrayList, com.flybutter.product.model.vo.*"%>
<%
ArrayList<Basket> list = (ArrayList<Basket>) request.getAttribute("list"); 
ArrayList<Product> pList = (ArrayList<Product>) request.getAttribute("pList"); 
//Member loginUser = (Member)request.getSession().getAttribute("loginUser");
int resultPrice = 0;
int shipPrice = 0;
//System.out.println(pList);
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/BasketList.css">
</head>
<body style="margin: 0 auto">
    
    <jsp:include page="../header_footer/header.jsp" flush="true"/>
    
    <div class="outer">
    <div class="logo">
		<br>
		<h2 id="basketlogo">장바구니</h2>
	</div>
	<br>
    <br clear="left">
    <br>            
    
    <%if(list.isEmpty()){%>
            <img id="eb" src="resources/icon/empty_basket.png"/>
			<div class="emptyList">
				
       			<h3 id="e1">장바구니에 담긴 상품이 없습니다.</h3>
        		<h4 id="e2">원하시는 상품을 장바구니에 담아보세요!</h4>
   			 </div>
	<%}else{%>
		<form id="basketlist" method="POST" action="<%=request.getContextPath()%>/basket.do">
		<div class="btn">
        <button type="submit" id="deleteProductBtn" onclick="deleteProduct()" >선택상품 삭제</button>
   		 </div>
   		 <div class="basketTable">
			<div class="basketTB">
				 <table id="productlist">
                    <tr>
                        <th id="tc"><input type="checkbox" id="allCk" name="allCk"></th>
                        <th id="t1" name="test">상품정보</th>
                        <th id="t2">옵션</th>
                        <th id="t3">배송비</th>
                        <th id="t4">상품금액</th>
                    </tr>
                    <%--<% for(Product p : pList) {
					System.out.println(pList);
					<%} %>--%>
				<% for(Basket b : list){ %>
					
                    <tr>
                     	<td id="btc"><input type="checkbox" class="ckPd" name="ckPd"></td>
                     	<td id="bt1" style="visibility:hidden;"><%=b.getpCode()%></td> <%--상품 정보를 담는 공간 (사진, 상품 이름) --%>
                        <td id="bt2"><%=b.getbOption()%> / <%=b.getbAmount()%>개</td>
                        <td id="bt3"><%=shipPrice%>원</td>
                        <td id="bt4"><%=b.getPrice()%>원</td>
                       
                    </tr>
                	<%}%>
                	
                	</table>
                	<hr>
                	<div id="resultDiv">
                	<table id="resultTB">
                		<tr>
                			<th id="th1">총 상품금액</th>
                			<th id="th2">배송비</th>
                			<th id="th3">할인예상금액</th>
                			<th rowspan = "2" id="th4">총 주문금액</th>
                		</tr>
                		<tr>
                			<td id="td1">1</td>
                			<td id="td2">2</td>
                			<td id="td3">3</td>
                		</tr>
                	</table>
                	
                	<hr>
                	
                	<button type="button" id="continueBtn" onclick="location='main.ma'">쇼핑 계속하기</button>
                	<button type="submit" id="purBtn">주문하기</button>
                	</div>
                	</div>
                	</div>
                	</form> 
                	</div>
                
			 <%}%>           
    
    
    <%--user_No값이 로그인한 유저의 user_No와 동일하면 띄우는 걸로 if조건문 만들어야함 / 로그인 안 했을 때 띄워지는 창 or alert(확인 누르면 메인) 
    <%if(loginUser == null){ %>
    	<script>
    		alert("로그인 후 이용하시기 바랍니다.");
    		document.location.href="main.ma";
    	</script>
    <%}else { %>
    	<%if(list.contains(loginUser.getUserNo())) {%>
    	<form method="POST" action="<%=request.getContextPath()%>/basket.do">
		<div class="btn">
        <button type="submit" id="deleteProductBtn" onclick="deleteProduct();">선택상품 삭제</button>
   		 </div>
   		 <div class="basketTable">
			<div class="basketTB">
				 <table id="productlist">
                    <tr>
                        <th id="tc"><input type="checkbox" name="allDelete" id="deleteCheck"></th>
                        <th id="t1">상품정보</th>
                        <th id="t2">옵션</th>
                        <th id="t3">배송비</th>
                        <th id="t4">상품금액</th>
                    </tr>
                    
				<% for(Basket b : list){ %>
					<%if(b.equals(loginUser.getUserNo())) {%>
                    <tr>
                     	<td id="btc"><input type="checkbox" id="deleteCheck"></td>
                     	<td id="bt1"></td> 
                        <td id="bt2"><%=b.getbOption()%> / <%=b.getbAmount()%>개</td>
                        <td id="bt3"><%=shipPrice%>원</td>
                        <td id="bt4"><%=b.getPrice()%>원</td>
                    </tr>
                       <%} %>
                	<%}%>
                	</table>
                	<hr>
                	<div id="resultDiv">
                	<table id="resultTB">
                		<tr>
                			<th id="th1">총 상품금액</th>
                			<th id="th2">배송비</th>
                			<th id="th3">할인예상금액</th>
                			<th rowspan = "2" id="th4">총 주문금액</th>
                		</tr>
                		<tr>
                			<td id="td1">1</td>
                			<td id="td2">2</td>
                			<td id="td3">3</td>
                		</tr>
                	</table>
                	</div>
                	<hr>
                	</form> 
                	</div>
                </div>
			 <%}else {%>    
            <img id="eb" src="resources/icon/empty_basket.png"/>
			<div class="emptyList">
				
       			<h3 id="e1">장바구니에 담긴 상품이 없습니다.</h3>
        		<h4 id="e2">원하시는 상품을 장바구니에 담아보세요!</h4>
   			 </div>  
		<%} %> 
	<%} %>
	
	
    </div>--%>
    
   <script>
    $(function(){ $("#allCk").click(function(){ 
    	 if($("#allCk").prop("checked")) { 
    		  $("input[type=checkbox]").prop("checked",true); 
		} else { $("input[type=checkbox]").prop("checked",false); } 
    	 }); 
    });

    function deleteProduct() {
    	
    	var confirm_val = confirm("정말 삭제하시겠습니까?");
    	 
        if (confirm_val) {
        	
        	var rowData = new Array();
            var checkArr = new Array();
			var checkbox = $("input[class=ckPd]:checked");
            
            checkbox.each(function(i){
            	
            	var tr = checkbox.parent().parent().eq(i);
            	var td = tr.children();
            	
            	rowData.push(tr.text());
            	
            	var pCode = td.eq(1).text();
            	
            	checkArr.push(pCode);
            	
            })
            	alert(checkArr)
            	location.href="<%=request.getContextPath()%>/deleteBasket.hy?checkArr="+checkArr;
        }
         return false;
	}	
   	</script>
</body>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
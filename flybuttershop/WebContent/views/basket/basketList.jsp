<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.basket.model.vo.*, 
    com.flybutter.dummy.model.vo.*"%>
<%
ArrayList<Basket> list = (ArrayList<Basket>) request.getAttribute("list"); 
Member loginM = (Member)request.getSession().getAttribute("loginMember");
int resultPrice = 0;
int shipPrice = 0;
%>
 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/BasketList.css?after">
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
       
    <%if(loginM == null){ %>
    	<script>
    		alert("로그인 후 이용하시기 바랍니다.");
    		document.location.href="main.ma";
    	</script>
    <%}else { %>
    	<%if(list.isEmpty()){%>
            <img id="eb" src="resources/icon/empty_basket.png"/>
			<div class="emptyList">
				
       			<h3 id="e1">장바구니에 담긴 상품이 없습니다.</h3>
        		<h4 id="e2">원하시는 상품을 장바구니에 담아보세요!</h4>
   			 </div>
		<%}else{%>
    	<form method="POST" action="<%=request.getContextPath()%>/basket.do">
		<div class="btn">
        <button type="submit" id="deleteProductBtn" onclick="deleteProduct();">선택상품 삭제</button>
   		 </div>
   		 <div class="basketTable">
			<div class="basketTB">
				 <table id="productlist">
                    <tr>
                        <th id="tc"><input type="checkbox" id="allCk" name="allCk"></th>
                        <th id="t1" colspan="3">상품정보</th>
                        <th id="t2">옵션</th>
                        <th id="t3">배송비</th>
                        <th id="t4">상품금액</th>
                    </tr>
                    
				<% for(Basket b : list){ %>
                    <tr>
                     	<td id="btc"><input type="checkbox" class="ckPd" name="ckPd"></td>
                     	<td id="bt1" style="visibility:hidden;"><%=b.getpCode()%></td> 
                     	<td id="bt2"><img id="pImg" src="${pageContext.request.contextPath}<%=b.getBasket_PImg() %>"/></td>
                     	<td id="bt3"><%=b.getBasket_Pname() %></td>
                        <td id="bt4"><%=b.getbOption()%> / <%=b.getbAmount()%>개</td>
                        <td id="bt5"><%=shipPrice%>원</td>
                        <td id="bt6"><%=b.getPrice()%>원</td>
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
                	<button type="submit" id="purBtn" onclick="purchase()">주문하기</button>
                	</div>
                	</div>
                	</div>
                	</form> 
                	</div>
              
   			 <%} %> 
		<%} %> 

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
            	location.href="<%=request.getContextPath()%>/deleteBasket.hy?checkArr="+checkArr;
            	alert("성공적으로 삭제되었습니다.");
        }
         return false;
	}	
    
    function purchase() {
    		var isck=false;
    		var cnt=0;
	    	var checked = document.getElementsByName("ckPd");
	   
    		for(var i=0;i<checked.length;i++){	
    			if(checked[i].checked==true){
	    			isck=true;
	    			cnt++;
    			}
    		}
   			if(!isck){
   				alert("주문하실 상품을 체크해주세요");
   				return false;
   			}
   			
   			var confirm_val = confirm(cnt+"개의 상품이 선택되었습니다. 주문하시겠습니까?");
       	 
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
   	            	location.href="<%=request.getContextPath()%>/basketPur.hy?checkArr="+checkArr;
   	       
   	        }
   	         return false;
			
   			
    }
   	</script>
</body>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
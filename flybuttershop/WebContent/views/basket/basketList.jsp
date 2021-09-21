<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.basket.model.vo.*, 
    com.flybutter.member.model.vo.*"%>
<%
ArrayList<Basket> list = (ArrayList<Basket>) request.getAttribute("list"); 
Member loginM = (Member)request.getSession().getAttribute("loginMember");
int lastPrice = 0;
int sumPrice = 0;
int shipPrice = 0;
int amount = 0;
int delPrice = 0;
%>
 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/BasketList.css?afterw">
</head>
<body style="margin: 0 auto">
    
    <jsp:include page="../header_footer/header.jsp" flush="true"/>
    
    <div class="outer">
    <div class="logo">
		<br>
		<h2 id="basketlogo">장바구니 <b id="free">5만원 이상 구입시 배송비 무료!</b></h2>
	</div>
	<br>
    <br clear="left">
    <br>            
       
    <%if(loginM == null){ %>
    	<script>
    		alert("로그인 후 이용하시기 바랍니다.");
    		document.location.href="<%=request.getContextPath()%>/mainpage.ma";
    	</script>
    <%}else { %>
    	<%if(list.isEmpty()){%>
            <img id="eb" src="resources/icon/empty_basket.png"/>
			<div class="emptyList">
				
       			<h3 id="e1">장바구니에 담긴 상품이 없습니다.</h3>
        		<h4 id="e2">원하시는 상품을 장바구니에 담아보세요!</h4>
   			 </div>
		<%}else{%>
    	<form method="POST" name="basketInfo" id="basketInfo" >
		<div class="btn">
        <button type="submit" id="deleteProductBtn" onclick="deleteProduct();">선택상품 삭제</button>
   		 </div>
   		 <div class="basketTable">
			<div class="basketTB">
				 <table id="productlist">
                    <tr>
                        <th id="tc"><input type="checkbox" id="allCk" name="allCk" onclick="allCheck(event)"></th>
                        <th id="t1" colspan="3">상품정보</th>
                        <th id="t2"colspan="2">옵션</th>
                        <th id="t3">배송비</th>
                        <th id="t4">상품금액</th>
                    </tr>
                    
				<% if(list.size() > 0){%>
				
				
					<%for(Basket b : list){ %>
                    <tr><% 			
                        	if(b.getPrice() < 50000){
                        		shipPrice = 2500;
                        	}else if(b.getPrice() >= 50000){
                        		shipPrice = 0;
                        	}%>
                     	<td id="btc"><input type="checkbox" class="ckPd" name="ckPd" onclick="checkAllList(event)"></td>
                     	<td id="bt1" style="visibility:hidden;"><%=b.getpCode()%></td> 
                     	<td id="bt2"><img id="pImg" src="${pageContext.request.contextPath}<%=b.getBasket_PImg() %>"/></td>
                     	<td id="bt3"><%=b.getBasket_Pname() %></td>
                     	<td id="amount" style="visibility:hidden;"><%=b.getbAmount()%></td>
                        <td id="bt4"><%=b.getbOption()%> / <%=b.getbAmount()%>개 <br> 
                        <td id="bt5"><%=shipPrice%>원</td>
                        <td id="bt6"><%=b.getPrice()%>원</td>
                        <%sumPrice += b.getPrice(); delPrice += shipPrice; %>
                    </tr>
                	<%}%>
                	<%} %>
                	</table>
                	<%if (sumPrice >= 50000){
                		delPrice = 0;
                	}%>
                	<input type="hidden" name="delPrice" value="<%=delPrice%>">
                	<hr>
                	<div id="resultDiv">
                	<table id="resultTB">
                		<tr>
                			<th id="th1">총 상품금액</th>
                			<th id="th2">배송비</th>
                			<th rowspan = "2" id="th3">총 주문금액</th>
                		</tr>
                		<tr>
                			<td id="td1"><%=sumPrice %>원</td>
                			<td id="td2"><%=delPrice %>원</td>
                			<%lastPrice = sumPrice + delPrice; %>
                			<td id="td3"><b id="sum"><%=lastPrice %>원</b></td>
                		</tr>
                	</table>
                	<br>
                	<hr>
                	<button type="button" id="continueBtn" onclick="location='<%=request.getContextPath()%>/mainpage.ma'">쇼핑 계속하기</button>
                	<button type="submit" id="purBtn" onclick="purchase()">주문하기</button>
                	</div>
                	</div>
                	</div>
                	</form> 
                	</div>
              
   			 <%} %> 
		<%} %> 

   <script>
    $(document).ready(function(){
    	
    });
   function allCheck(e) { 
		if(e.target.checked) {
			document.querySelectorAll(".ckPd").forEach(function(v, i) {
				v.checked = true;
			});
		} else {
			document.querySelectorAll(".ckPd").forEach(function(v, i) {
				v.checked = false;
			});
		}
	}
	function checkAllList(e) {
		let checkCount = 0;
		document.querySelectorAll(".ckPd").forEach(function(v, i) {
			if(v.checked === false){
				checkCount++;
			}
		});
		if(checkCount>0) {
			document.getElementById("allCk").checked = false;
		} else if(checkCount === 0) {
			document.getElementById("allCk").checked = true;
		}
	}

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
    		var isck = false;
    		var cnt = 0;
	    	var checked = document.getElementsByName("ckPd");
	   
    		for(var i= 0; i < checked.length; i++){	
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
   	            	var amount = td.eq(4).text();
   	            	
                    checkArr.push(pCode);
                    
                 })
                 
   	           
                 var form = document.getElementById("basketInfo");
  
              form.setAttribute('action', 'basketPur.hy');
              var hInput = document.createElement('input');
              hInput.setAttribute('type','hidden');
              hInput.setAttribute('name', 'checkArr');
              hInput.setAttribute('value', checkArr);
              form.appendChild(hInput);
              
              
            
   	        
   	        }
   	        
    }
    
    
   	</script>
</body>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
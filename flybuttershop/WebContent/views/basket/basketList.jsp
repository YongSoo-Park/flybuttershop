<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.basket.model.vo.*, 
    java.util.ArrayList, com.flybutter.member.model.vo.*"%>
<%
ArrayList<Basket> list = (ArrayList<Basket>) request.getAttribute("list"); 
//Member loginUser = (Member)request.getSession().getAttribute("loginUser");
int resultPrice = 0;
int shipPrice = 0;
//System.out.println(loginUser.getUserNo());
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

    #deleteProductBtn{
        float: right;
        padding: 10px;
        border-radius: 5px;
        border: unset;
        background-color: lightgray;
        position: relative;
        top: -30px; 
        left: 600px;
        
    }
    .logo{
        width: 600px;
        height: 50px;
        float: left;
    }
    .btn{
        width: 600px;
        height: 50px;
        float: left;
    }
    .basketTB{
        width: 1200px;
        height: 80px;
        background-color: midnightblue;
        position: relative;
        top: 30px; 
    }
    .outer{
        display: inline-block;
    }
    #allCk{
        width: 20px;
        height: 20px;
        position: relative;
        top: 5px;
        left: 10px;
    }
    #tc{
    	width: 40px;
    	background-color: midnightblue;
        position: relative;
        top: 18px;
        font-size: 18px;
    }
    #t1{
        width: 490px;
        color: white;
        background-color: midnightblue;
        position: relative;
        top: 20px;
        font-size: 18px;
    }
    #t2{
        width: 350px;
        color: white;
         background-color: midnightblue;
        position: relative;
        top: 20px;
        font-size: 18px;
    }
    #t3{
        width: 150px;
        color: white;
         background-color: midnightblue;
        position: relative;
        top: 20px;
        font-size: 18px;
    }
    #t4{
        width: 150px;
        color: white;
         background-color: midnightblue;
        position: relative;
        top: 20px;
        font-size: 18px;
    }
    #pDCheck{
        width: 20px;
        height: 20px;
        position: relative;
        top: 28px;
        left: 50px;
    }
    .list{
        background-color: blue;
        width: 1200px;
        height: 200px;
        margin: 4%;
    }
    #btc{
    	height: 180px;
        position: relative;
        top: 20px;
        font-size: 18px;
        text-align: center;
    }
    #bt1{
    	height: 180px;
        position: relative;
        top: 20px;
        font-size: 18px;
        text-align: center;
    }
    #bt2{
    	height: 180px;
        position: relative;
        top: 20px;
        font-size: 18px;
        text-align: center;
    }
    #bt3{
    	height: 180px;
        position: relative;
        top: 20px;
        font-size: 18px;
        text-align: center;
    }
    #bt4{
    	height: 180px;
        position: relative;
        top: 20px;
        font-size: 18px;
        text-align: center;
    }
    #e1{
   		text-align: center;
  	}
  	#e2{
    	text-align: center;
    	color: gray;
  	}
  	.emptyList{
  		position: relative;
        top: 150px;
      	width: 1200px;
     	height: 500px;
  	}
  	#eb{
  		position: relative;
        top: 180px;
        left: 500px;
  		width: 200px;
  		height: 200px;
  	}
  	#productlist{
  		position: relative;
        top: -48px;
        
  	}
  	.basketTable{
    	height:auto;	
  	}
  	#resultDiv{
  		width: 1200px;
  		height: 280px;
  		float: left;
  	}
  	#th1{
  		width: 15%;
  		height: 80px;
  	}
  	#th2{
  		width: 10%;
  	}
  	#th3{
  		width: 20%;
  	}
  	#th4{
  		position: relative;
  		left: -50px;
  	}
  	#td1{
  		text-align: center;
  		height: 40px;
  	}
  	#td2{
  		text-align: center;
  	}
  	#td3{
  		text-align: center;
  	}
  	#continueBtn{
  		position: relative;
  		left: 400px;
  		 padding: 30px;
  		 font-size: 20px;
  		 border-radius: 5px;
        border: unset;
        background-color: lightgray;
  	}
  	#purBtn{
  		position: relative;
  		left: 450px;
  		padding: 30px;
  		font-size: 20px;
  		border-radius: 5px;
        border: unset;
        background-color: skyblue;
  	}
</style>
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
        <button type="submit" id="deleteProductBtn" form="basketlist" onclick="deleteProduct();">선택상품 삭제</button>
   		 </div>
   		 <div class="basketTable">
			<div class="basketTB">
				 <table id="productlist">
                    <tr>
                        <th id="tc"><input type="checkbox" id="ckBtn" name="allCk"></th>
                        <th id="t1">상품정보</th>
                        <th id="t2">옵션</th>
                        <th id="t3">배송비</th>
                        <th id="t4">상품금액</th>
                    </tr>
                    
				<% for(Basket b : list){ %>
                    <tr>
                     	<td id="btc"><input type="checkbox" id="allCk"></td>
                     	<td id="bt1"></td> <%--상품 정보를 담는 공간 (사진, 상품 이름) --%>
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
    	 }) 
    })

    $(function deleteProduct() {
		
	})	
   	</script>
</body>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.basket.model.vo.*"%>
<%
ArrayList<Basket> list = (ArrayList<Basket>) request.getAttribute("list");
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
        top: -20px;
        
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
    .basketTable{
        width: 1200px;
        height: 80px;
        background-color: midnightblue;
    }
    .outer{
        display: inline-block;
    }
    #deleteCheck{
        width: 20px;
        height: 20px;
        position: relative;
        top: 5px;
        left: 10px;
    }
    #tc{
    	width: 40px;
    }
    #t1{
        width: 490px;
        color: white;
    }
    #t2{
        width: 350px;
        color: white;
    }
    #t3{
        width: 150px;
        color: white;
    }
    #t4{
        width: 150px;
        color: white;
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
    th{
        background-color: midnightblue;
        position: relative;
        top: 20px;
        font-size: 18px;
    }
    td{
        height: 200px;
        position: relative;
        top: 20px;
        font-size: 18px;
        text-align: center;
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
    <div class="btn">
		<br>
        <br>
        <button type="button" id="deleteProductBtn" onclick="deleteProduct();">선택상품 삭제</button>
    </div>
    <br clear="left">
    <br>
    <div class="basketTable">
        <form method="POST">
            <form method="POST" action="<%=request.getContextPath()%>/basket.do">
                <table id="productlist">
                    <tr>
                        <th id="tc"><input type="checkbox" id="deleteCheck"></th>
                        <th id="t1">상품정보</th>
                        <th id="t2">옵션</th>
                        <th id="t3">배송비</th>
                        <th id="t4">상품금액</th>
                    </tr>
            <%if(list.isEmpty()){%>
				
			<%}else{%>
				<% for(Basket b : list){ %>
                    <tr>
                     	<td><input type="checkbox" id="deleteCheck"></td>
                     	<td></td>
                        <td><%=b.getbOption()%> / <%=b.getbAmount()%>개</td>
                        <td>2500원</td>
                        <td><%=b.getPrice()%>원</td>
                    </tr>
                	<%}%>
				 <%}%>
                </table>
            </form> 
        </form>
    </div>
    </div>
</body>
</html>
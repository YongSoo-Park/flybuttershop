<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #basketlogo{
        margin: 8%;
    }
    #deleteProductBtn{
        float: right;
        padding: 10px;
        border-radius: 5px;
        border: unset;
        background-color: lightgray;
        position: relative;
        top: 20px;
        left: 40px;
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
    .bar{
        width: 1200px;
        height: 80px;
        background-color: midnightblue;
        margin: 4%;
    }
    .outer{
        display: inline-block;
    }
    #deleteCheck{
        width: 20px;
        height: 20px;
        position: relative;
        top: 28px;
        left: 10px;
    }
    #t1{
        position: relative;
        top: -19px;
        left: 250px;
        color: white;
        float: left;
    }
    #t2{
        position: relative;
        top: -19px;
        left: 600px;
        color: white;
        float: left;
    }
    #t3{
        position: relative;
        top: -19px;
        left: 800px;
        color: white;
        float: left;
    }
    #t4{
        position: relative;
        top: -19px;
        left: 900px;
        color: white;
        float: left;
    }
</style>
<body>
    
    <div class="outer">
    <div class="logo">
		<br>
		<h2 id="basketlogo">장바구니</h2>
	</div>
    <div class="btn">
		<br>
        <br>
        <button type="button" id="deleteProductBtn" onclick="deleteProduct();">선택상품 삭제</button>
    </div>
	
    <br clear="left">
    <br>
    <div class="bar">
        <form method="POST">
            <input type="checkbox" id="deleteCheck">      
        </form>
        <h3 id="t1" >상품정보</h3>
        <h3 id="t2" >옵션</h3>
        <h3 id="t3" >배송비</h3>
        <h3 id="t4" >상품금액</h3>
    </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.purchase.model.vo.*, 
    com.flybutter.dummy.model.vo.*"%>
<%
//ArrayList<Purchase> list = (ArrayList<Purchase>) request.getAttribute("list"); 
Member loginM= (Member)request.getSession().getAttribute("loginMember");
Purchase p = (Purchase)request.getAttribute("purInfo");
//int pNo = ((Integer)(request.getSession().getAttribute("pNo"))).intValue();
int resultPrice = 0;
int shipPrice = 0;
//System.out.println(pList);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#outer{
  width: 1200px;
  display: inline-block;
}
#purPTB{
    height: 80px;
    background-color: midnightblue;
    position: relative;
    top: 30px; 
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
    width: 130px;
    color: white;
    background-color: midnightblue;
    position: relative;
    top: 20px;
    font-size: 18px;
}
#t3{
    width: 100px;
    color: white;
     background-color: midnightblue;
    position: relative;
    top: 20px;
    font-size: 18px;
}
#t4{
    width: 100px;
    color: white;
     background-color: midnightblue;
    position: relative;
    top: 20px;
    font-size: 18px;
}
#t5{
    width: 150px;
    color: white;
     background-color: midnightblue;
    position: relative;
    top: 20px;
    font-size: 18px;
}
#t6{
    width: 200px;
    color: white;
     background-color: midnightblue;
    position: relative;
    top: 20px;
    font-size: 18px;
}
#pt1{
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
}
#pt2{
	weith: 10px;
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
    padding: 10px;
}
#pt3{
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
}
#pt4{
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
}
#pt5{
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
}
#pt6{
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
}
#pt7{
    height: 180px;
    position: relative;
    top: 20px;
    font-size: 18px;
    text-align: center;
}
#pImg{
	 width: 100px;
	 height: 100px;
}
#ship{
	 width: 1200px;
	 height: 1000px;	
	 float: left;
	 text-align: left;
}
#ptb{
	height:auto;	
}
#mtb{
	 width: 1200px;
	 height: 700px;
	 
}
#d1{
	background-color: lightgray;
	width: 700px;	
}
#d2{
	background-color: rgb(169, 169, 170);
}
#purInfo{
	text-align: left;
}
#consent{
	text-align: center;
}
#ck{
	 width: 25px;
    height: 25px;
}
#purBtn{
 	padding: 27px;
      font-size: 20px;
      border-radius: 5px;
    border: unset;
    color: white;
    background-color: rgb(37, 37, 37);
}
.text1{
	position: relative;
    top: -30px;
    left: 20px;
}
.text2{
	position: relative;
    top: -30px;
    left: 30px;
}
.text3{
	position: relative;
    top: -30px;
    left: 40px;
}
</style>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<div id="outer">
    <%--로그인한 상태인지만 검사 --%>
    <%--  <%if(loginM == null){ %>
     	<script>
    		alert("로그인 후 이용하시기 바랍니다.");
    		document.location.href="main.ma";
    	</script>
      <%}else{ %>--%>
     
     <div id="purPTB">
     <div id="ptb">
    <table id="purInfoTB">
      <tr>
     	<th></th>
          <th id="t1">상품정보</th>
          <th id="t2">판매자</th>
          <th id="t3">배송비</th>
          <th id="t4">수량</th>
          <th id="t5">할인</th>
          <th id="t6">상품금액</th>
      </tr>
      <tr>
        <td id="pt1"> <img id="pImg" src="${pageContext.request.contextPath}<%=p.getPur_Image() %>"/></td>
        <td id="pt2"><%=p.getPur_Pname() %></td> 
         <td id="pt3"><%=p.getPur_SName() %></td>
         <td id="pt4"><%=shipPrice%>원</td>
         <td id="pt5"><%=p.getPur_Amount()%>개</td>
         <td id="pt6"></td>
         <td id="pt7"><%=p.getPur_Price()%>원</td>
     </tr>
  </table>
  </div>
  <div id="ship">
  <table id="mtb">
  	<tr>
  		<th></th>
  		<th id="d1">
  		<h3 class="text1">배송지 정보</h3>
  		<label class="text2">배송지 선택
  		<input type="radio">기본배송지
  		<input type="radio">신규배송지</label>
  		<h4 class="text3"><%=loginM.getMEM_USER_NAME() %></h4>
  		<h4 class="text3"><%=loginM.getMEM_PHONE() %></h4>
  		<h4 class="text3"><%=loginM.getMEM_ADDRESS() %></h4>
  		<h3 class="text1">할인 정보</h3>
  		<h4 class="text2">쿠폰 할인</h4>
  		<label>보유 쿠폰</label>	
  		<table>		
  			<tr>
  				<td>쿠폰이름</td>
  				<td>n장</td>
  				<td><button>사용</button></td>
  			</tr>
  		</table>
  		<h4 class="text2">적립금</h4>
  		<label>보유 적립금</label>
  		<table>	
  			<tr>
  				<td>n원</td>
  				<td><button>사용</button></td>
  			</tr>
  		</table>
  		<h3 class="text1">결제수단</h3>
  		<input class="text2" type="radio">무통장 입금
  		<input class="text2" type="radio">신용카드 결제
  		<input class="text2" type="radio">휴대폰 결제
  		</th>
  		<th id="d2">
  		<h3 class="text1">주문자 정보</h3>
  		<h4 class="text3"><%=loginM.getMEM_USER_NAME() %></h4>
  		<h4 class="text3"><%=loginM.getMEM_PHONE() %></h4>
  		<h4 class="text3"><%=loginM.getMEM_EMAIL() %></h4>
  		<h3 class="text1">결제 상세</h3>
  		<label class="text2">주문금액</label><br>
  		<label class="text3">상품금액    n원</label><br>
  		<label class="text3">배송비    n원</label><br>
  		<label class="text3">쿠폰할인    n원</label>
  		</th>
  	</tr>
  </table>
  <div id="consent">
  <br><br>
  <input type="checkbox" id="ck">주문 내용을 확인하였으며, 정보 제공등에 동의합니다.
  <br><br><br>
  <button id="purBtn">결제하기</button>
  </div>
  </div>
  </div>
 </div>
 <br><br>
</body>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
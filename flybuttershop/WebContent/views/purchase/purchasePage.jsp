<%@page import="com.sun.javafx.geom.CubicApproximator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.purchase.model.vo.*, 
    com.flybutter.member.model.vo.*, com.flybutter.consumer.model.vo.*, com.flybutter.coupon.model.vo.*,
    com.flybutter.product.model.vo.*"%>
<%
//ArrayList<Purchase> list = (ArrayList<Purchase>) request.getAttribute("list"); 
Member loginM= (Member)request.getSession().getAttribute("loginMember");
Purchase p = (Purchase)request.getAttribute("purInfo");
Consumer c = (Consumer)request.getAttribute("consumer");
ArrayList<Coupon> list = (ArrayList<Coupon>) request.getAttribute("list");
Member m = (Member)request.getAttribute("m");
//ArrayList<Product> pList = (ArrayList<Product>) request.getAttribute("pList"); 
//ArrayList<Purchase> sNameList = (ArrayList<Purchase>) request.getAttribute("sNameList"); 

int resultPrice = 0;
int shipPrice = 0;
String empty = "";
int couponDc = 0;

if(p.getPur_Price() < 50000){
	shipPrice = 2500;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/PurchasePage.css?afterw">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<div id="outer">
     <%if(loginM == null){ %>
     	<script>
    		alert("로그인 후 이용하시기 바랍니다.");
    		document.location.href="main.ma";
    	</script>
      <%}else{ %>
     <form id="purForm" action="" method="post">
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
  		<h3 class="text1" id="tt1">배송지 정보</h3>
  		<label class="text2">배송지 선택
  		<label><input type="radio" id="sType1" name="ship" style="cursor:pointer;" value="0" checked>기본배송지</label>
  		<label><input type="radio" id="sType2" name="ship" style="cursor:pointer;" value="1" onclick="div_OnOff(this.value,'new');">신규배송지</label></label>
  		
  		<h4 class="text3"><%=m.getUserName() %></h4>
  		<h4 class="text3"><%=m.getPhone() %></h4>
  		<div id="origin"><h4 class="text3" style="display:block;"><%=m.getAddress() %></h4></div><br>
  		
  		<div id="new" style="display:none;"><input class="text3" id="newi" name="newAdr" placeholder="새로운 주소를 입력하세요  " type="text" ></div>
  		
  		<h3 class="text1">할인 정보</h3>
  		<h4 class="text2">쿠폰 할인</h4>
  		<label id="lb1">사용가능 쿠폰</label>	
  		<table id="ct">		
  		<%for(Coupon cu : list) {%>
  			
  			<tr>
  				<td id="ctd1"><%=cu.getCp_name() %></td>
  				<td id="ctd2"><%=cu.getCp_count() %>장</td>
  				<td id="ctd3"><button id="cub" value="<%=cu.getCp_no() %>" name="coupon" style="cursor:pointer;" 
  				onclick="useCoupon()">사용</button></td>  			
  			</tr>
  			
  		<%} %>
  		</table>
  		<h4 class="text2">적립금</h4>
  		<label id="lb2">보유 적립금</label>
  		<table id="mt">	
  			<tr>
  				<td id="mtd1"><%=c.getMoney() %>원</td>
  				<td id="mtd2"><button id="mub" value="<%=c.getMoney() %>" name="money" style="cursor:pointer;" 
  				onclick="window.open('views/purchase/moneyUse.jsp','적립금 사용','width=430,height=500,location=no,status=no,scrollbars=yes');">사용</button></td>
  			</tr>
  		</table>
  		<h3 class="text1">결제수단</h3>
  		<ul type="none">
  		<li class="menu"> <input class="text2" id="pType1" type="radio" name="purType" value="1" style="cursor:pointer;">
  		<label id="ptl1">무통장 입금</label></li>
  		 <ul class="hide" type="none"><li>
  		 <label>은행선택&nbsp;&nbsp;
  		 <select name="bank">
    		<option selected>선택해주세요</option>
    		<option value="하나">하나</option>
    		<option value="신한">신한</option>
    		<option value="국민">국민</option>
    		<option value="우리">우리</option>
    		<option value="농협">농협</option>
    		<option value="기업">기업</option>
		</select></label>
		</li>
		</ul>
  		</ul> <br>
  		<ul type="none">
  		<li class="menu">
  		<input class="text2" id="pType2" type="radio" name="purType" value="2" style="cursor:pointer;">
  		<label id="ptl2">신용카드 결제</label></li>
  		<ul class="hide" type="none" data-collapsed="true">
  		<li><label>카드 구분</label>&nbsp;&nbsp;
  		<input id="cType1" type="radio" name="cardType" style="cursor:pointer;">
  		<label for="cType1">개인카드</label>
  		<input id="cType2" type="radio" name="cardType" style="cursor:pointer;">
  		<label for="cType2">법인카드</label>
  		</li>
  		<li>
  		<label>카드선택</label>&nbsp;&nbsp;
  		<select name="card">
    		<option selected>선택해주세요</option>
    		<option value="하나">하나</option>
    		<option value="신한">신한</option>
    		<option value="국민">국민</option>
    		<option value="우리">우리</option>
    		<option value="농협">농협</option>
    		<option value="기업">기업</option>
		</select>
  		</li>
  		<li>
  		<label>할부기간</label>&nbsp;&nbsp;
  		<select name="cDate">
    		<option selected>선택해주세요</option>
    		<option value="일시불">일시불</option>
    		<option value="2개월">2개월</option>
    		<option value="4개월">4개월</option>
    		<option value="6개월">6개월</option>
    		<option value="12개월">12개월</option>
		</select>
  		</li>
  		<label>카드번호</label>&nbsp;&nbsp;
  		<input id="cn" name="cardNo" placeholder="입력해주세요.  " type="text" maxlength='16' onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"><br>
  		<label>카드검증번호</label>&nbsp;&nbsp;
  		<input id="cn" name="cardcvc" placeholder="서명란 3자리 숫자  " type="text" maxlength='3' onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"><br>
  		<label>카드결제번호</label>&nbsp;&nbsp;
  		<input id="cn" name="cardPw" placeholder="입력해주세요.  " type="text" maxlength='4' onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"><br>
  		</ul>
  		</ul><br>
  		</th>
  		<th id="d2">
  		<h3 class="text1" id="tt2">주문자 정보</h3>
  		<%-- <h4 class="text3" id="tt2"><%=m.getUserName() %></h4>
  		<h4 class="text3" id="tt2"><%=m.getPhone() %></h4>
  		<h4 class="text3" id="tt2"><%=m.getEmail() %></h4>--%>
  		<h3 class="text1" id="tt3">결제 상세</h3>
  		<label class="text2" id="tt3">주문금액<b id="b1">n원</b></label><br>
  		<input type="hidden" name="resultPrice" value="<%=resultPrice%>">
  		<label class="text3" id="tt4">상품금액<b id="b2"><%=p.getPur_Price() %>원</b></label><br>
  		<label class="text3" id="tt5">배송비<b id="b3"><%=shipPrice%>원</b></label><br>
  		<label class="text3" id="tt6">쿠폰할인<b id="bcu">0원</b></label><br>
  		<label class="text3" id="tt7">적립금사용<b id="bmo">0원</b></label>
  		</th>
  	</tr>
  </table>
  <input type="hidden" name="pCode" value="<%=p.getpCode()%>">
  <input type="hidden" name="pName" value="<%=p.getPur_Pname()%>">
  <input type="hidden" name="pImg" value="<%=p.getPur_Image()%>">
  <input type="hidden" name="pAmount" value="<%=p.getPur_Amount()%>">
  <input type="hidden" name="pOption" value="<%=p.getPur_POption()%>">
  <input type="hidden" name="price" value="<%=p.getPur_Price()%>">
  <input type="hidden" name="sName" value="<%=p.getPur_SName()%>">
  </form>
  <div id="consent">
  <br><br>
  <label><input type="checkbox" id="ck" style="cursor:pointer;">주문 내용을 확인하였으며, 정보 제공등에 동의합니다.</label>
  <br><br><br>
  <button id="purBtn" onclick="purchase();">결제하기</button>
  </div>
  </div>
  </div>
 </div> 
 <br><br>
<%} %>
</body>
<script>
	
    $(document).ready(function(){
        $(".menu").click(function(){
        	var submenu = $(this).next("ul");
        	
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
    });
    
    function div_OnOff(v,id){
    	 if(v == "1"){
    	  document.getElementById(id).style.display = ""; 
    	 }else{
    	  document.getElementById(id).style.display = "none"; 
    	 }
    };
 
    function purchase(){
    		
    		if(! jQuery('input[name="purType"]:checked').val()){
    			alert('결제수단을 선택해주세요.');
        		return false;
    		}else if ($(ck).is(":checked") == false){
    			alert("약관에 동의해주세요.")
    		
    			return false;
    		}else{
    			$("#purForm").attr("action", "<%=request.getContextPath()%>/insertPur.hy");
    			$("#purForm").submit();
    			return true;
    		}
   			
    };
    
    function useCoupon(){
    	if(confirm('쿠폰을 사용하시겠습니까?')){
            <%--var dc = document.getElementById("bcu");

            dc.innerText = "<%=couponDc%>";--%>
 
    	}
    };
    
</script>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
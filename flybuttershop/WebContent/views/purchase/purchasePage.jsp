<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.purchase.model.vo.*, 
    com.flybutter.dummy.model.vo.*"%>
<%
//ArrayList<Purchase> list = (ArrayList<Purchase>) request.getAttribute("list"); 
Member loginM= (Member)request.getSession().getAttribute("loginMember");
Purchase p = (Purchase)request.getAttribute("purInfo");
//Member m = (Member)request.getAttribute("m");
int resultPrice = 0;
int shipPrice = 0;
//System.out.println(pList);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/PurchasePage.css?after">
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
  		
  		<%-- <h4 class="text3"><%=m.getUserName() %></h4>
  		<h4 class="text3"><%=m.getPhone() %></h4>
  		<div id="origin"><h4 class="text3" style="display:block;"><%=m.getAddress() %></h4></div><br>--%>
  		
  		<div id="new" style="display:none;"><input class="text3" id="newi" name="newAdr" placeholder="새로운 주소를 입력하세요  " type="text" ></div>
  		
  		<h3 class="text1">할인 정보</h3>
  		<h4 class="text2">쿠폰 할인</h4>
  		<label id="lb1">보유 쿠폰</label>	
  		<table id="ct">		
  			<tr>
  				<td id="ctd1">쿠폰이름</td>
  				<td id="ctd2">n장</td>
  				<td id="ctd3"><button id="ub" style="cursor:pointer;">사용</button></td>
  			</tr>
  		</table>
  		<h4 class="text2">적립금</h4>
  		<label id="lb2">보유 적립금</label>
  		<table id="mt">	
  			<tr>
  				<td id="mtd1">n원</td>
  				<td id="mtd2"><button id="ub" style="cursor:pointer;">사용</button></td>
  			</tr>
  		</table>
  		<h3 class="text1">결제수단</h3>
  		<ul type="none">
  		<li class="menu"> <input class="text2" id="pType1" type="radio" name="purType" value="무통장" style="cursor:pointer;">
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
  		<input class="text2" id="pType2" type="radio" name="purType" value="신용카드" style="cursor:pointer;">
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
  		<select name="job">
    		<option selected>선택해주세요</option>
    		<option value="일시불">일시불</option>
    		<option value="2개월">2개월</option>
    		<option value="4개월">4개월</option>
    		<option value="6개월">6개월</option>
    		<option value="12개월">12개월</option>
		</select>
  		</li>
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
  		<label class="text3" id="tt4">상품금액<b id="b2">n원</b></label><br>
  		<label class="text3" id="tt5">배송비<b id="b3">n원</b></label><br>
  		<label class="text3" id="tt6">쿠폰할인<b id="b2">n원</b></label>
  		</th>
  	</tr>
  </table>
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
    	if($(ck).is(":checked") == false){
    		alert("약관에 동의해주세요.")
    		document.location.href="/views/purchase/purchasePage.jsp"
    		return false;
    	}else{
    	$("#purForm").attr("action", "<%=request.getContextPath()%>/insertPur.hy");
    	$("#purForm").submit();
    	
    	return true;
    	}
    }
</script>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</html>
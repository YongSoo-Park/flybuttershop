<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String userName = String.valueOf(request.getSession().getAttribute("MEM_USER_NAME")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
    <style>

        .menu{
            width: 200px;
            height: 200px;
            background-color: lightgrey;
            margin: 30px;
            text-align: center;
            display: inline-block;
            line-height: 200px;
            
        }

        #wrap{

            text-align: center;
            width: 1200px;
            position: absolute;
            

        }

        #infoWrap{
            display: inline-block;
            width: 1000px;
            margin: 0px auto;
            
            background-color: lightgrey;
            text-align: center;
            align-items: center;
            padding: 40px 0;
            
            
        }

        /*#info{

            vertical-align: middle;
            text-align: center;

        }*/

    </style>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	
<body>

 <jsp:include page="../header_footer/header.jsp" flush="true"/>

    <div id="wrap">

        <h3>MY PAGE</h3>

        <div id="infoWrap">


                <c:out value="${sessionScope.loginMember.MEM_USER_NAME}"/> 님의 등급은 
                <c:choose>
  				<c:when test="${sessionScope.loginMember.MEM_LEV == '1'}">애벌레</c:when>
  				<c:when test="${sessionScope.loginMember.MEM_LEV == '2'}">번데기</c:when>
  				<c:when test="${sessionScope.loginMember.MEM_LEV == '3'}">나비</c:when>
  				<c:otherwise>오류</c:otherwise>
				</c:choose>
				입니다 <br>
                300,000 원 이상 구매 시 프리미엄으로 업그레이드
            

        </div>


    <div class="navWrap">
        <div class="nav">
            <div class="menu" onclick="goUpdateMember();">회원정보수정</div>
            <div class="menu" onclick="goReviewList();">내 후기 관리</div>
            <div class="menu" onclick="goOrderCheck();">주문내역확인</div>
            <div class="menu" onclick="goCoupon();">쿠폰/적립금확인</div>
            <div class="menu" onclick="goRecentlyView();">최근 본 상품</div>
            <div class="menu" onclick="goWishList();">위시리스트</div>
            
        </div>
    </div>
    
    <script>
        function goUpdateMember(){
            location.href="/checkPass.mp";
        }
    
        function goReviewList(){
            location.href="/reviewList.rv";
        }
        
        function goOrderCheck(){
            location.href="/orderList.mp";
        }
        
        function goCoupon(){
            location.href="/couponList.mp";
        }

        function goRecentlyView(){
            location.href="/recentlyList.mp";
        }

        function goWishList(){
            location.href="/wishlist.mp";
        }
    
    
    </script>


    </div>

<div>
<!--<jsp:include page="../header_footer/footer.jsp" flush="true"/>-->

</div>


    
</body>
</html>
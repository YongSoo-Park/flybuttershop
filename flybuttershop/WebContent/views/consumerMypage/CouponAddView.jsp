<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.coupon.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 

	String msg = (String)request.getAttribute("msg");
	Coupon c = (Coupon)request.getAttribute("coupon");
	String contextPath = request.getContextPath();


%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠폰 등록</title>

    <style>

        #outer{
            width: 1200px;
            text-align: center;
          
        }


        #wrap{

            text-align: center;
            width: 800px;
            border: 1px black solid;
            padding: 40px;
            display: inline-block;
            margin: 60px;
        }

    </style>
    


</head>
<body style="margin: 0 auto">
   
    <jsp:include page="../header_footer/header.jsp" flush="true"/>
    
    <div id="outer">


        <div id="wrap">
        <form id = "CheckCoupon" action="<%=contextPath %>/checkCoupon.mp" method="post">
        <h2>쿠폰 조회</h2>
		
        쿠폰 번호 입력 &nbsp; &nbsp;
        <input type="number" name="number" required="required">
        <br><br>
        <input type="submit" value="확인하기">
        <br><br>
        </form>
        </div>
        
        <% if (c != null){ %>
        	

            <div id="wrap">
            
            <h2>조회 된 쿠폰</h2>
            
    		<br><br>
    		쿠폰명 : <%= c.getCp_name() %><br>
    		사용기한 : <%= c.getCp_date() %><br>
    		쿠폰 금액 : <%= c.getCp_discount() %> 원<br>
    		최소 사용 가능 금액 : <%= c.getMinPrice() %>
    		
            <br><br>
             <input type="button" value="쿠폰 등록하기" onclick="location.href='<%=contextPath %>/addCoupon.mp?cpNum=<%=c.getCp_no()%>'">
     	 <br><br>

            </div>
        	
      <%  } else{%>
      
      		<div id="wrap">
            
            <h2>조회 된 쿠폰</h2>
            
    		<br><br>
    		<%= msg %>
            <br><br>
            
     	 <br><br>

            </div>
      	
      
      <%} %>
        
        
        
    </div>


 <jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
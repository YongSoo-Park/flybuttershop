<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 

	String originPhone = (String)request.getAttribute("originPhone");
	String msg = (String)request.getAttribute("msg");
	
	String contextPath = request.getContextPath();


%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>본인 인증</title>

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
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body style="margin: 0 auto">
   
    <jsp:include page="../header_footer/header.jsp" flush="true"/>
    
    <div id="outer">


        <div id="wrap">
        <form id = "CheckCoupon" action="<%=contextPath %>/checkPhone.mp" method="post">
        <h2>본인 인증</h2>
		
        본인 인증 받을 전화 번호를 숫자로만 입력해주세요 <br><br>
        <input type="number" id="number" name="number" required="required">
        <br><br>
        <input type="submit" value="인증번호 받기" id="checkPhone">
        <br><br>
        </form>
        </div>
        
       
    
        <%if(originPhone != null){ %>	
      
      		<div class="wrap" id="success">
            
            <h2>인증번호 입력</h2>
            
    		<br><br>
    		<input type="number" id="number" required="required">
    		<br><br>
	 		<input type="button" value="인증하기" onclick="location.href='<%=contextPath %>/checkMember.mp'">
            <br><br>
            
     	 <br><br>

            </div>
      	   <%}else  {%>	

            <div class="wrap" id="alert">
            
            <%= msg %>
            
    		<br><br>
    		
    		
          
     	 <br><br>

            </div>
            
            <%} %>

        
    </div>


 <jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
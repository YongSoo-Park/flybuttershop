<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int userNo = (int)request.getAttribute("userNo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
    <style>

        #wrap{
            width: 1200px;
            display: inline-block;
            text-align: center;
        
        }

        #wrapCheck{

            width: 500px;
            display: inline-block;
            border: 1px solid black;
            

        }

    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>

	function loginValidate(){
	
	if(“#checkPass”).val().trim.length==0){
	alert(“비밀번호를 입력하세요”);
	$(“#checkPass”).focus();
	return false;
	}
	return true;
	}


</script>
</head>
<body>

 <jsp:include page="../header_footer/header.jsp" flush="true"/>
    <div id="wrap">

    <div id="wrapCheck">

        <h3>비밀번호 확인</h3>
        <br>
        <form id = "CheckForm" action="<%=request.getContextPath()%>/checkPassInv.mp" method="post" onsubmit="return loginValidate();">
            
            <input id="checkPass" type="password">

            <br><br><br>

            <input type="submit" value="확인">
            
            
            
        </form>
    
        <br>

    </div>    
   
    

    </div>


	

</body>
</html>
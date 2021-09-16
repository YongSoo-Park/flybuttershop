<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
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

	var pass = document.getElementById("checkPass");
    console.log(pass)
	if(pass.value.length==0){
		alert('비밀번호를 입력하세요');
		pass.focus();
		return false;
		}
		return true;
		


    /*var pass = document.getElementById("checkPass");
    if(pass.value == ""){
    alert('비밀번호를 입력하세요');
    pass.focus();

    }else{
	
	 location.href="checkPassInv.mp";*/


}

</script>
</head>
<body style="margin: 0 auto">

 <jsp:include page="../header_footer/header.jsp" flush="true"/>
    <div id="wrap">
	<br>
    <div id="wrapCheck">

        <h3>비밀번호 확인</h3>
        <br>
        <form id = "CheckForm" action="checkPassInv.mp" method="post" onsubmit="return loginValidate();" >
            
            <input id="checkPass" type="password" name="checkPass">

            <br><br><br>

            <input type="submit" value="확인">
            
            
            
        </form>
    
        <br>

    </div>    
   
    

    </div>
	
	<br>

	 <jsp:include page="../header_footer/footer.jsp" flush="true"/>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<style>
	#loginForm,
	#userInfo{
	float:center;
	}
	
	.btns{
	border-radius:5px;
	}


	#enrollBtn1{
	width: 150px;
    height: 40px;
    font-size: 20px;
    border-style: solid;
    border-radius: 8px;
	background-color:mistyrose;
	transition-duration: 1s;
	}
	#enrollBtn1:hover{
    background:mediumblue;
     color:white;
	}
	
	#enrollBtn2{
	width: 150px;
    height: 40px;
    font-size: 20px;
    border-style: solid;
    border-radius: 8px;
	background-color:cornsilk;
	transition-duration: 1s;
	}
	#enrollBtn2:hover{
    background:mediumblue;
    color:white;
	}

	
	#loginMenu{
	 background-color: mediumpurple;
	 font-size: 20px;
	 border-radius:5px;
	 }

    #FlyButter{
	font-family: 'Lobster', cursive;
	font-size:100px;
	padding :40px;

	}

	#goMain{
	width: 200px;
    height: 50px;
    margin :5px;
    font-size: 20px;
	background-color:bisque;
	transition-duration: 1s;
	}
	#goMain:hover{
    background:mediumblue;
    color:white;
	}


</style>

</head>

<body>
	<h1 id = "FlyButter" align = "center" style="color:skyblue;">Membership</h1>
	<div class= "loginArea">
		

<%-- 	<form id = "loginForm" action="<%=request.getContextPath()%>/userInsert.jsp" method="post" onsubmit="return loginValidate();">
 --%>
 		<form id = "loginForm" method="post" onsubmit="return loginValidate();">
		<div class ="btns" align="center">
			<div>
				<table id ="loginMenu" border="1" >

				<tr width = "300px"height = "130">
				
					<td ><b>상품 판매자 회원가입</b></td>
					<td >
					<button id = "enrollBtn1" type="button" onclick="sEnrollPage();">판매자가입</button>
					</td>
					
					<td ><b>상품  구매자 회원가입</b></td>
					<td >
					<button id = "enrollBtn2" type="button" onclick="cEnrollPage();">구매자가입</button></td>	
				 </tr>	  
					
				<tr>
					
					<td colspan = "4" align = "center"><button type="button" id="goMain" onclick="history.go(-1)">메인으로</button></td>
				</td>	

				</table>
			</div>

		</div>
	</form>

	</div>
	
	<script type="text/javascript">
	function cEnrollPage(){
		location.href = "<%=request.getContextPath() %>/cEnrollForm.me";
	}
	</script>
	
	<script type="text/javascript">
	function sEnrollPage(){
		location.href = "<%=request.getContextPath() %>/sEnrollForm.me";
	}
	</script>
		
</body>
</html>




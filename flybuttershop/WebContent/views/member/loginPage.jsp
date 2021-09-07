<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.flybutter.member.model.vo.Member" %>

<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	
	String msg = (String)session.getAttribute("msg");
	
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<style>
	body{
		background:url('<%=request.getContextPath() %>/resources/images/semi.jpg') no-repeat; 
		background-size:cover;
	}
	
	/* 로그인 폼 관련 스타일	*/
	#loginForm,
	#userInfo{

	float:center;

	}
	
	.btns{
	border-radius:5px;
	
	}
	
	#loginBtn{
	width: 300px;
    height: 50px;
    margin :40px;
    color: lightyellow;
    font-size: 25px;
    border-style: solid;
    border-radius: 8px;
    font-family: 'Consolas', cursive;
	background-color:lightsalmon;
	transition-duration: 1s;
	}
	#loginBtn:hover{
    background:mediumblue;
    color:white;
	}
	
	#findIdBtn,
	#findPwdBtn{
	width: 150px;
    height: 25px;
    font-size: 15px;
    border-style: solid;
    border-radius: 8px;
	background-color:lavender;
	}

	
	#userInfo a{
	text-decoration:none;
	color:white;
	}
	
	#loginMenu{
	 background-color: mediumpurple;
	 font-size: 20px;
	 border-radius:5px;
	 }
	 
	 #userId,
	 #userPwd{
	 font-family: 'Lobster', cursive;
	 width: 250px;
	 height: 30px;
	 }
	 
	 
    #FlyButter{
	
	font-family: 'Lobster', cursive;
	
	font-size:100px;
	padding :40px;

	}
	#logoutBtn{
	width: 200px;
    height: 50px;
    margin :5px;
    font-size: 20px;
	background-color:thistle;
    transition-duration: 1s;
	}
	#logoutBtn:hover{
    background:mediumblue;
    color:white;
	}
	 
	#nextPageBtn{
	width: 200px;
    height: 50px;
    margin :5px;
    font-size: 20px;
	background-color:bisque;
	transition-duration: 1s;
	}
	#nextPageBtn:hover{
    background:mediumblue;
    color:white;
	}


</style>
<script>
	$(function(){
		var msg = "<%=msg%>";
		if(msg != "null"){
			
			alert(msg);
			<%session.removeAttribute("msg");%>
		}
	})


 	function loginValidate(){
		if($("#userId").val().trim().length==0){
			alert("아이디를 입력하세요");
			$("#userId").focus();
			return false;
		}
		if($("#userPwd").val().trim().length==0){
			alert("비밀번호를 입력하세요");
			$("#userPwd").focus();
			return false;
		}
		return true;
	} 
</script>

</head>

<body>
	<h1 id = "FlyButter" align = "center" style="color:white;">FlyButterShop</h1>
	<div class= "loginArea">
		
		<% if(loginUser == null) {%>
	<form id = "loginForm" action="<%=request.getContextPath()%>/loginPage.me" method="post" onsubmit="return loginValidate();">

		<div class ="btns" align="center">
			<div>
				<table id ="loginMenu" >
				<tr>
					<th><label for = "userId" style="color:white;">ID</label></th>
					<td><input id="userId" type="text" name="userId"></td>
				</tr>
				<tr>
					<th><label for = "userPwd" style="color:white;">PASSWORD</label></th>
					<td><input id="userPwd" type="text" name="userPwd"></td>
				</tr>
				</table>
			</div>
			
			<button id = "loginBtn" type="submit">LOGIN</button>
			
			<div>
				<button id = "findIdBtn" type="button" onclick="findIdPage();">아이디 찾기</button>
				<button id = "findPwdBtn" type="button" onclick="findPwdPage();">비밀번호 찾기</button>
			</div>
			<!-- <br> -->
	
			<button type="button" id="goMain" onclick="history.go(-1)">메인으로</button>
		</div>
	</form>
		<%}else {%>
			<div id = "userInfo"  align="center">
				<h1><b style = "color:white;"><%=loginUser.getUserName() %> 님 </b>
				 의 방문을 환영합니다.</h1>
				<br><br>
				<div class ="btns" align="center">
					 <a href = "<%=request.getContextPath() %>/nextpage.me"><button id="nextPageBtn">다음페이지</button></a>
					<div>
					 <a href = "<%=request.getContextPath() %>/logout.me"><button id = "logoutBtn">로그아웃</button></a>
					</div>
				</div>
			
			</div>
			  <%} %>
	</div>
	

	
 	<script type="text/javascript">
	function findIdPage(){
		location.href = "<%=request.getContextPath() %>/findIdForm.me"; 
	}
	</script>
	
	<script type="text/javascript">
	function findPwdPage(){
		location.href = "<%=request.getContextPath() %>/findPwdForm.me";
	}
	</script>
	
</body>
</html>




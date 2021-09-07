<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.flybutter.member.model.vo.Member" %>
<%
	Member member = (Member)session.getAttribute("member");
	
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
		background:url('<%=request.getContextPath() %>/resources/images/semi3.jpg') no-repeat; 
		background-size:cover;
	}


	#userIdfindText{
	font-family: 'gulim', cursive;
	font-size:70px;
	padding :40px;
	
	}

	.btns{
	border-radius:5px;	
	}
	
	#goMain{
	width: 150px;
    height: 40px;
    font-size: 20px;
    border-style: solid;
    border-radius: 8px;
	background-color:mistyrose;
	transition-duration: 1s;
	}
	#goMain:hover{
    background:mediumblue;
     color:white;
	}
	
	#goLogin{
	width: 160px;
    height: 40px;
    font-size: 15px;
	background-color:cornsilk;
	border-style: solid;
    border-radius: 8px;
    transition-duration: 1s;
	}
	#goLogin:hover{
    background:mediumblue;
    color:white;
	}
</style>
</head>
<body>
	<h1 id = "userIdfindText" align = "center" style="color:white; ">당신의 아이디는</h1>
	<div class="outer">
	
		<div align="center">
			<h1><b style = "color:white;"><%=member.getUserId()%> 입니다</h1> </b>
		</div>
		
		<div class="btns" align="center">
		
			<button type="button" id="goLogin" onclick = "location.href='<%=request.getContextPath()%>/views/cs/member/loginPage.jsp'" >홈으로 돌아가기</button>
			<button type="button" id="goMain" onclick="history.go(-1)">취소</button>
			
		</div> 
	</div>
</body>
</html>

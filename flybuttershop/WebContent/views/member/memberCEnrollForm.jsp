
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	#enrollForm{
 	height: 200px;
	float:center;
	border-size: 50px;
	}

	.btns{
	border-radius:5px;
	}
	
	#idCheckBtn{
	width: 90px;
    height: 40px;
    font-size: 18px;
	background-color:lavender;
    border-style: outset;
    border-radius: 10px;
    transition-duration: 1s;
    }  
    #idCheckBtn:hover{
    background:cornflowerblue;
     color:white
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
	
	#joinBtn{
	width: 150px;
    height: 40px;
    font-size: 20px;
	background-color:cornsilk;
	border-style: solid;
    border-radius: 8px;
    transition-duration: 1s;
	}
	#joinBtn:hover{
    background:mediumblue;
     color:skyblue;
	}

	#userJoinText{
	font-family: 'Consolas', cursive;
	font-size:70px;
	padding :40px;
	}
	
	td{
	text-align: center;
	}
	
	#inputbox{
	border-style: solid;
    border-radius: 8px;
	width: 230px;
	height: 30px;
	margin :5px;
	}
	#joinId{
	color:skyblue;
	width: 150px;
	height: 20px;
	}
	
</style>

</head>
<body>

	<h1 id = "userJoinText" align = "center" style="color:skyblue; ">Consumer</h1>
	<div class="outer">
		<form id="enrollForm" action="<%=request.getContextPath() %>/cInsert.me" method="post" onsubmit="return joinValidate();">
			<table align="center">
				<tr>
					<td  id="joinId">* ???????????????</td>
					<td><input id ="inputbox" type="text" maxlength="13" name="userId" placeholder="ID" required></td>
					<td width="10px">
						<button type="button" id="idCheckBtn" onclick="checkId();">????????????</button>
					</td>
				</tr>
				<tr>
					<td id="joinId">* ??????????????????</td>
					<td><input id ="inputbox" type="password" maxlength="15" name="userPwd" placeholder="(15??????)" required></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* ????????????????????????</td>
					<td><input id ="inputbox" type="password" maxlength="15" name="checkPwd" placeholder="(?????? ????????????)" required></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td id="joinId">* ??????</td>
					<td><input id ="inputbox" type="text" maxlength="5" name="userName" placeholder="name" required></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* ?????????</td>
					<td><input id ="inputbox" type="tel" maxlength="11" name="phone" placeholder="(-??????)01012345678"></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* ?????????</td>
					<td><input id ="inputbox" type="email" name="email" placeholder="....@...."></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* ??????</td>
					<td><input id ="inputbox" type="text" name="address" placeholder="address"></td>
					<td></td>
				</tr>

			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit" id="joinBtn">????????????</button>
				<button type="button" id="goMain" onclick="history.go(-1)">??????</button>
				
			</div>
		</form>
	
	</div>
	
	<script>
	function joinValidate(){
		
		if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#enrollForm input[name=userId]").val()))){
			$("#enrollForm input[name=userId]").focus();
	        return false;
		}
		
		if($("#enrollForm input[name=userPwd]").val() != $("#enrollForm input[name=checkPwd]").val()){
			$("#pwdResult").text("???????????? ?????????").css("color", "red");
			return false;			
		}
		
		 if(!(/^[???-???]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
			 $("#enrollForm input[name=userName]").focus();
	        return false;
		 }
		 
		 return true;
	}
	function checkId(){
		var userId = $("#enrollForm input[name=userId]");
		if(userId.val()==""){
			alert("???????????? ??????????????????");
			return false;
		}
		$.ajax({
			
			url: "idCheck.me",
			type:"post",
			data:{userId : userId.val()},
			success:function(result){
				if(result == "fail"){
					alert("???????????? ?????? ????????? ?????????.");
					userId.focus();
				}else{
					if(confirm("??????????????? ????????? ?????????. ?????????????????????????")){
						userId.attr("readonly","true");
						$("#joinBtn").removeAttr("disabled");
					}else{
						userId.focus();
					}
				}
				
			},
			error:function(){
				console.log("??????????????????");
			}
		})
	}
	</script>

</body>
</html>

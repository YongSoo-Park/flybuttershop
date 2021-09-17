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
    height: 35px;
    font-size: 15px;
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
     color:white;
	}

	#userJoinText{
	font-family: 'Consolas', cursive;
	font-size:80px;
	
	}
	
	td{
	text-align: center;
	}
	
	#userId,#userPwd,#userName,#checkPwd,#phone,#email,
	#address,#storeName,#storeAddress,#storeAccount,
	#storeExp,#storeCall,#ceo,#storeEmail,#sellerNo{
	border-style: solid;
    border-radius: 8px;
	width: 230px;
	height: 25px;
	margin :2px;
	}
	#joinId{
	color:black;
	width: 150px;
	height: 20px;
	}
	
</style>

</head>
<body>

	<h1 id = "userJoinText" align = "center" style="color:skyblue; ">회원가입</h1>
	<div class="outer">
		<form id="enrollForm" action="<%=request.getContextPath() %>/sInsert.me" method="post" onsubmit="return joinValidate();">
			<table align="center">
				<tr>
					<td  id="joinId">* 회원아이디</td>
					<td><input id ="userId" type="text" minlength="5" maxlength="15" name="userId" placeholder="(5자 이상 15자 이하)" required></td>
					<td width="10px">
						<button type="button" id="idCheckBtn" onclick="checkId();">중복확인</button>
					</td>
				</tr>
				<tr>
					<td id="joinId">* 회원비밀번호</td>
					<td><input id ="userPwd" type="password" minlength="5" maxlength="15" name="userPwd" placeholder="(5자 이상 15자 이하)" required></td>
					<td><label id="pwdinsert"></label></td>
					
				</tr>
				<tr>
					<td id="joinId">* 회원비밀번호확인</td>
					<td><input id ="checkPwd" type="password" maxlength="15" name="checkPwd" placeholder="(위와 동일하게)" required></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td id="joinId">* 이름</td>
					<td><input id ="userName" type="text" maxlength="5" name="userName" placeholder="name" required></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* 연락처</td>
					<td><input id ="phone" type="text" maxlength="11" name="phone" placeholder="(-없이)01012345678"></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* 이메일</td>
					<td><input id ="email" type="text" name="email" placeholder="....@...."></td>
					<td></td>
				</tr>
				<tr>
					<td id="joinId">* 주소</td>
					<td><input id ="address" type="text" name="address" placeholder="address"></td>
					<td></td>
				</tr>
				<tr>
				<td></td>
				  <td id="joinId">
				<p> <input type="checkbox" id="chkSellerYn" value="N"> <label for="test-1">판매자로도 가입하기</label> </p>
					<input type="hidden" name="sellerYn" id="sellerYn" value="N" />
				  </td>
				
				</tr>
				<tr name="sellerInfo">
					<td id="joinId">* 스토어 이름</td>
					<td><input id ="storeName" type="text" name="storeName" placeholder="스토어 이름"></td>
					<td></td>
				</tr>
				<tr name="sellerInfo">
					<td id="joinId">* 스토어 주소</td>
					<td><input id ="storeAddress" type="text" name="storeAddress" placeholder="스토어 주소"></td>
					<td></td>
				</tr>
				 <tr name="sellerInfo">
					<td id="joinId">* 판매자 번호</td>
					<td><input id ="sellerNo" type="text" maxlength="10" name="sellerNo" placeholder="판매자(사업자) 번호"></td>
					<td></td>
				</tr> 
				<tr name="sellerInfo">
					<td id="joinId">* 스토어 계좌</td>
					<td><input id ="storeAccount" type="text" maxlength="15"  name="storeAccount" placeholder="스토어 계좌"></td>
					<td></td>
				</tr >
				<tr name="sellerInfo">
					<td id="joinId">* 스토어 설명</td>
					<td><input id ="storeExp" type="text" name="storeExp" placeholder="스토어 설명"></td>
					<td></td>
				</tr>
				<tr name="sellerInfo">
					<td id="joinId">* 스토어 전화번호</td>
					<td><input id ="storeCall" type="text"  maxlength="12"name="storeCall" placeholder="스토어 전화번호"></td>
					<td></td>
				</tr>
				<tr name="sellerInfo">
					<td id="joinId">* 대표성명</td>
					<td><input id ="ceo" type="text" name="ceo" placeholder="대표성명"></td>
					<td></td>
				</tr>
				<tr name="sellerInfo">
					<td id="joinId">* 스토어 이메일</td>
					<td><input id ="storeEmail" type="text" name="storeEmail" placeholder="스토어 이메일"></td>
					<td></td>
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="button" id="joinBtn" onclick="regInfo()">가입완료</button>
				<button type="button" id="goMain" onclick="history.go(-1)">취소</button>
				
			</div>
		</form>
	
	</div>
	
	
	
	<script>
	function joinValidate(){
		
 		if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#enrollForm input[name=userId]").val()))){
			$("#enrollForm input[name=userId]").focus();
			console.log("name=userId")
	        return false;
		}
 		
 		if($("#enrollForm input[name=userPwd]").val() == ""){
			alert("비밀번호를 입력하세요");
			$("#enrollForm input[name=userPwd]").focus();
			console.log("name=입력하세요")
			return false;			
		}
 		
		if($("#enrollForm input[name=userPwd]").val() != $("#enrollForm input[name=checkPwd]").val()){
			alert("비밀번호 불일치");
			$("#enrollForm input[name=checkPwd]").focus();
			console.log("name=checkPwd")
			return false;			
		}
		
		 if(!(/^[가-힣]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
			 $("#enrollForm input[name=userName]").focus();
			console.log("name=userName")

	        return false;
		 }  
		 
		 return true;
	}
	function checkId(){
		var userId = $("#enrollForm input[name=userId]");
		if(userId.val()==""){
			alert("아이디를 입력해주세요");
			return false;
		}
		$.ajax({
			
			url: "idCheck.me",
			type:"post",
			data:{userId : userId.val()},
			success:function(result){
				if(result == "fail"){
					alert("사용할수 없는 아이디 입니다.");
					userId.focus();
				}else{
					if(confirm("사용가능한 아이디 입니다. 사용하시겠습니까?")){
						userId.attr("readonly","true");
						$("#joinBtn").removeAttr("disabled");
					}else{
						userId.focus();
					}
				}
				
			},
			error:function(){
				console.log("서버통신실패");
			}
		})
	}
	
	$(document).ready(function() { 
		$('[name="sellerInfo"]').attr('style', "display:none;");
	$("#chkSellerYn").on('click', function() { 
		if ( $(this).prop('checked') ) { 
			$('#sellerYn').val('Y');
			console.log("체크 됨 : " + $('#sellerYn').val());
			$('[name="sellerInfo"]').attr('style', "display:'';");

			//$(this).parent().addClass("selected");  
		}else { 
			$('#sellerYn').val('N');
			console.log("체크 해제 : " + $('#sellerYn').val());
			$('[name="sellerInfo"]').attr('style', "display:none;");

			//$(this).parent().removeClass("selected"); 
			} 
		}); 
	});

 	function regInfo(){
 		
 		if(!joinValidate()){
 			return;
 		}
 		var param = {
			"userId":$("#userId").val(),
			"userPwd":$("#userPwd").val(),
			"userName":$("#userName").val(),
			"phone":$("#phone").val(),
			"email":$("#email").val(),
			"address":$("#address").val(),
			"sellerYn":$("#sellerYn").val(),
			"storeName":$("#storeName").val(),
			"storeAddress":$("#storeAddress").val(),
			"sellerNo":$("#sellerNo").val(),
			"storeAccount":$("#storeAccount").val(),
			"storeExp":$("#storeExp").val(),
			"storeCall":$("#storeCall").val(),
			"ceo":$("#ceo").val(),
			"storeEmail":$("#storeEmail").val()	
		}
		console.log("param : " +JSON.stringify(param));

		$.ajax({
			
			url: "sInsert.me",
			type:"post",
			data:param,
			success:function(result){
				
				if(result == "member"){
					
					alert("축하합니다 ! 회원가입에 성공하셨습니다!");
					location.href="/flybuttershop/main.ma";
				}else if(result == "seller"){
					
					alert("축하합니다 !회원가입과 판매자 가입에 성공하셨습니다!");
					location.href="/flybuttershop/main.ma";
					
				} else {
					alert("회원가입에 실패했습니다.잠시 후 다시 시도해주세요");
				}
				
			},
			error:function(){
				console.log("서버통신실패");
			}
		})
		
	}
	</script>

</body>
</html>
	
		


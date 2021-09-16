<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.dummy.model.vo.*"%>
<% 
	Member m = (Member)request.getAttribute("m");	
	
%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
 <title>회원정보 수정</title>

    <style>

        #wrap{

            text-align: center;
        }

        #loginForm{

            text-align: center;
            line-height: 30px;

        }
    </style>

<script>

function checkPass(){

	if($("#pass1").val() != $("#pass2").val()){
		$("#pwdResult").text("비밀번호 불일치").css("color", "red");
		return false;			
	}
	$("#pwdResult").text("비밀번호 일치").css("color", "blue");
	
}

function loginValidate() {
	if($("#pass1").val() != $("#pass2").val()){
		$("#pwdResult").text("비밀번호 불일치").css("color", "red");
		return false;			
	}
	return true;
}

</script>
</head>
<body style="margin: 0 auto">
    
    <jsp:include page="../header_footer/header.jsp" flush="true"/>

    <div id="wrap">


        <h2>회원정보 수정</h2>

        <div id="loginForm">
        <form name="login" action="updateMem.mp" method="post" onsubmit="return loginValidate();">
            <label>아이디</label>
            <input type="text" name="user_ID" value=<%= m.getMEM_USER_ID() %> readonly>
            
            <br>
             <label>비밀번호</label>
            <input type="password" id ="pass1" name="user_PW1" required><label id="pwdResult"></label><br>
             <label>비밀번호 재확인 </label>
            <input type="password" id ="pass2" name="user_PW2" required>
            <input type="button" name="user_PWcheck" value="비밀번호 확인" onclick="checkPass();">
            <br>
            <label>이름 </label>
            <input type="text" name="name" value=<%= m.getMEM_USER_NAME()%> required> <br>
             <label>이메일</label>
            <input type="email" name="email" value=<%= m.getMEM_EMAIL()%> required><br>
             <label>휴대전화 </label>
            <input type="text" name="phone" value=<%=m.getMEM_PHONE() %> required><br>
             <label>주소 </label>
            <textarea id="address" name = "address" required><%= m.getMEM_ADDRESS() %></textarea>


            <br><br>
            <input type="submit" name="submit" value="변경하기">
            
          </form>
        
        </div>

    </div>

	 <jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
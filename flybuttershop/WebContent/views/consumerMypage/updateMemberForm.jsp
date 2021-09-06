<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

</head>
<body>
    

    <div id="wrap">


        <h2>회원정보 수정</h2>

        <div id="loginForm">
        <form name="login" action="#" method="post">
            아이디
            <input type="text" name="user_ID" placeholder="ID" readonly>
            
            <br>
            비밀번호
            <input type="password" name="user_PW1"><br>
            비밀번호 재확인 
            <input type="password" name="user_PW2">
            <input type="button" name="user_PWcheck" value="비밀번호 재확인">
            <br>
            이름
            <input type="text" name="user_name" value=""> <br>
            이메일
            <input type="email" name="user_email" placeholder="email@gmail.com"><br>
            휴대전화 
            <input type="text" name="user_phone" placeholder="010-****-****"><br>
            주소 
            <textarea id="user_Address"></textarea>


            <br><br><br>
            <input type="submit" name="" value="제출">
            
          </form>
        
        </div>

    </div>

</body>
</html>
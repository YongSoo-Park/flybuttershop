<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.qna.model.vo.*"%>

<%
Qna q = (Qna)request.getAttribute("q");
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 비밀번호 확인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  <!--스타일 cdn?-->
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> <!--jQuery연결하는 CDN-->
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
function pwdValidate(){
	if(!(/^[0-9]{1,10}$/.test($("#qnaPwd input[name=pwd]").val()))){
		 alert("비밀번호에는 숫자만 입력가능합니다.")
		 $("#qnaPwd input[name=pwd]").focus();
       return false;
	 }
	 
}
</script>
<style type="text/css">
.check{
	width:400px;
	height:300px
}

</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
  
  <br><br>
  
  <h3 align="center">Q&A 비밀번호를 입력해 주세요</h3>
  <div align="center">
	<div class="check">
		<form id="qnaPwd" action="<%=request.getContextPath()%>/checkPwd.na" method="post" onsubmit="return pwdValidate();">
			<input type="hidden" name="qNo" value="<%=q.getQna_No()%>">
			<input type="password" id="pwd" name="pwd">
			<button type="submit" class="btn btn-outline-secondary">비밀번호 확인</button>		
			
		</form>
	
	</div>
	
	</div>
	
	
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
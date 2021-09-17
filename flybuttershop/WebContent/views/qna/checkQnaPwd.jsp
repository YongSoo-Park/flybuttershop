<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.qna.model.vo.*"%>

<%
Qna q = (Qna)request.getAttribute("q");
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	text-align:center;
}
</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
  
	<div class="check">
		<form id="qnaPwd" action="<%=request.getContextPath()%>/checkPwd.na" method="post" onsubmit="return pwdValidate();">
			<input type="hidden" name="qNo" value="<%=q.getQna_No()%>">
			<input type="password" id="pwd" name="pwd">
			<button type="submit">비밀번호 확인</button>		
			
		</form>
	
	</div>
	
	
	
	
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
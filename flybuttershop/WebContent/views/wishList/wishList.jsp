<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "com.flybutter.consumerMyPage.model.service.MypageService"%>
<%@ page import = "com.flybutter.member.model.vo.Member" %>
<%
int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();

String pCode = request.getParameter("pCode");



	
	int result = new MypageService().addWishList(userNo, pCode);
	
	if(result > 0) {
		
		request.setAttribute("msg", "위시리스트에 등록 되었습니다");
		
		
	}else {
		
		request.setAttribute("msg", "위시리스트 등록 실패");
		
	}





%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function() {
	var isMsg = 1;
	sessionStorage.setItem("isMsg", isMsg ); 
	
	 var msg = '<%=request.getAttribute("msg")%>';
	alert(msg); 
	history.back(); 
})


</script>
</head>
<body>

</body>
</html>
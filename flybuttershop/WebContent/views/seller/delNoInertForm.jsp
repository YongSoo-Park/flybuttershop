<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.flybutter.seller.model.vo.*, com.flybutter.purchase.model.vo.*"%>
    
<%
SoldList s = (SoldList)request.getAttribute("s");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function delValidate(){
	if(!(/^[0-9]{1,10}$/.test($("#delNo input[name=number]").val()))){
		 alert("운송장번호에는 숫자만 입력가능합니다.")
		 $("#delNo input[name=number]").focus();
       return false;
	 }
	 
}
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>  
	
	<h2>운송장 번호 등록</h2>
	
	
<div class="insertDelNo">
	<form id="delNo" action="<%=request.getContextPath()%>/updateDel.sl" method="post" onsubmit="return delValidate();">
		<input type="text" id="number" name="number">
		<input type="hidden" id="pNo" name="pNo" value="<%=s.getPno()%>">
		<br>
		<button type="submit">운송장 번호 등록</button>
	</form>
</div>

</body>
</html>
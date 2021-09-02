<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.notice.model.vo.*"%>
    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");

%>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- <%@ include file="../common/csMenubar.jsp" %> -->
	
	<div class="csMenu">
		<div class="">
				<div class="menu" onclick="goNotice();">공지사항</div>
				<div class="menu" onclick="goFAQ();">자주 묻는 질문</div>
				<div class="menu" onclick="goHelpWrite();">1대1문의</div>
				<div class="menu" onclick="goHelpList();">문의내역</div>
				
			</div>
	</div>

	<script>
		function goNotice(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function goFAQ(){
			location.href="<%=request.getContextPath()%>/deliveryList.faq";
		}
		function goHelpWrite(){
			location.href="<%=request.getContextPath()%>/write.help";
		}
		function goHelpList(){
			location.href="<%=request.getContextPath()%>/entireList.help";
		}
	</script>

	<div>
	
	
	</div>




</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flybutter.faq.model.vo.FAQ" %>
<%
	FAQ f = (FAQ)request.getAttribute("f");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
	.outer {
	width: 1200px;
	height: auto;
	color: black;
	margin: auto;
	margin-top: 50px;
}
	.outer>table, .outer>table tr>*{
		border:1px solid black;
	}
	 
	.outer>table{
		width:1200px;
		height:auto;
	}
	
	.outer>table p{
		height:auto;
		margin:0;
	}
</style>
</head>
<body style="margin: 0 auto">


<jsp:include page="../header_footer/header.jsp" flush="true"/>

	<section>
	<jsp:include page="../common/csMenubar.jsp" flush="true"/>
	<div class="outer">
	
		<table align="center">
			<tr>
				<td width="150" align="center" >카테고리</td>
				<td width="100" align="center"><%= f.getFaq_Category() %></td>
				<td width="150" align="center">제목</td>
				<td width="800"><%= f.getFaq_Title()%></td>
				
			</tr>
			
			<tr>
					<td colspan="4">
					<p><%= f.getFaq_Content() %></p>
				</td>
			</tr>
		</table>
		
		<br>
		
		<div class="btns" align="center">
		
			<a href="deliveryList.faq">목록으로</a> &nbsp;&nbsp;
				
			
			
			<a href="updateForm.faq?no=<%=f.getFaq_No()%>">수정하기</a> &nbsp;&nbsp;
			<a href="delete.faq?no=<%=f.getFaq_No()%>">삭제하기</a>
		
		
		</div>
		<form action="" id="postForm" method="post">
			<input type="hidden" name="no" value="<%= f.getFaq_No() %>">
		</form>
		<script>
			function updateForm(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/updateForm.faq");
				$("#postForm").submit();
			}
			
			function deleteBoard(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/deleteF.faq");
				$("#postForm").submit();
			}
		</script>
	</div>
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
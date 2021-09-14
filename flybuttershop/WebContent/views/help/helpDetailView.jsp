<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flybutter.help.model.vo.Help" %>
<%
	Help h = (Help)request.getAttribute("h");
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
	height: 1500px;
	color: black;
	margin: auto;
	margin-top: 50px;
}
	.outer>table, .outer>table tr>*{
		border:1px solid black;
	}
	 
	.outer>table{
		width:1200px;
		height:1000px;
	}
	
	.outer>table p{
		height:230px;
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
				<td>카테고리</td>
				<td colspan="2"><%= h.getHelp_Category() %></td>
				<td>제목</td>
				<td colspan="2"><%= h.getHelp_Title() %></td>
				<td>작성일</td>
				<td colspan="2"><%= h.getHelp_Date() %></td>
			</tr>
			<tr>
				<td colspan="9">
					<% if(h.getHelp_File_System() != null){ %>
					<div class="detailImgArea" align="center">
						<img width="600px" height="450px" src="<%=request.getContextPath()%>/resources/help/<%=h.getHelp_File_System()%>"><br>
												
					</div>
					
					<% }else{ %>
					첨부파일이 없습니다.
					<% } %>
				
			</tr>	
			<tr>
					<td colspan="9">내용
					<p><%= h.getHelp_Content() %></p>
				</td>
			</tr>
		</table>
		
		<br>
		
		<div class="btns" align="center">
		
			<a href="list.help">목록으로</a> &nbsp;&nbsp;
				
			
			
			<a href="updateForm.help?no=<%=h.getHelp_No()%>">수정하기</a> &nbsp;&nbsp;
			<a href="delete.help?no=<%=h.getHelp_No()%>">삭제하기</a>
		
		
		</div>
		<form action="" id="postForm" method="post">
			<input type="hidden" name="no" value="<%= h.getHelp_No() %>">
		</form>
		<script>
			function updateForm(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/updateForm.help");
				$("#postForm").submit();
			}
			
			function deleteBoard(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/deleteH.help");
				$("#postForm").submit();
			}
		</script>
	</div>
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
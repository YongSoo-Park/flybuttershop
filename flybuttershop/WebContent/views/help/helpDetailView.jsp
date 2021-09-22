<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flybutter.help.model.vo.*" %>
<%
	Help h = (Help)request.getAttribute("h");
 HelpReply hr = (HelpReply)request.getAttribute("hr");
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
	.replyArea{
		width:800px;
		color:white;
		background:black;
		margin:auto;
		height:auto;
	}
	p{
	width:1200px;
	height:auto;
		
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
				<td width="100" align="center" ><%= h.getHelp_Category() %></td>
				<td width="150" align="center" >제목</td>
				<td width="550" align="center" ><%= h.getHelp_Title() %></td>
				<td width="100" align="center" >작성일</td>
				<td width="200" align="center" ><%= h.getHelp_Date() %></td>
			</tr>
			<tr>
				<td colspan="6">
					<% if(h.getHelp_File_System() != null){ %>
					<div class="detailImgArea" align="center">
						<img width="600px" height="450px" src="<%=request.getContextPath()%>/resources/help/<%=h.getHelp_File_System()%>"><br>
												
					</div>
					
					<% }else{ %>
					첨부파일이 없습니다.
					<% } %>
				
			</tr>	
			<tr>
					<td colspan="6">
					<p><%= h.getHelp_Content() %></p>
				</td>
			</tr>
		</table>
		
		<br>
	
		<% if(h.getHelp_status().equals("Y")){ %>
			<h6>답변</h6>
					<p 	style="border:1px solid black"><%= hr.getReply_Content() %></p>
				
				<input type="hidden"  name="no" <%= hr.getHelp_No() %>>
			
		
		<% } %>
		
		<br>
		
		<div class="btns" align="center">
		
			<a href="list.help">목록으로</a> &nbsp;&nbsp;
				
			
			
			<a href="updateForm.help?no=<%=h.getHelp_No()%>">수정하기</a> &nbsp;&nbsp;
			<a href="delete.help?no=<%=h.getHelp_No()%>">삭제하기</a> &nbsp;&nbsp;
			<br>
			<a href="replyForm.help?no=<%=h.getHelp_No()%>">답글달기</a> 
			
			<% if(hr != null){ %>
			<a href="replyUpdateForm.help?no=<%=hr.getHelp_No() %>">답글수정</a>
			<a href="replyDelete.help?no=<%=hr.getHelp_No() %>">답글삭제</a>
			<% } %>
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
			function replyForm(){
				$("#postForm").attr("action", "<%=request.getContextPath()%>/replyForm.help");
				$("#postForm").submit();
			}
			
		     


			
		</script>
	</div>
	
	
	
	
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
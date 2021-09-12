<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flybutter.notice.model.vo.*" %>
<%
	Notice n = (Notice)request.getAttribute("n");
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
	#updateForm>table{ 
		border:1px solid black;
	}
	
	#updateForm>table input, #updateForm>table textarea{
		width:100%;
		box-sizing:border-box;
	}
	
	#deleteBtn{color:gray;}
	#deleteBtn:hover{cursor:pointer}
</style>
</head>
<body style="margin: 0 auto">
	<jsp:include page="../header_footer/header.jsp" flush="true" />

	<section>
		<jsp:include page="../common/csMenubar.jsp" flush="true" />

			<div class="outer">
<h1>수정수정</h1>
			<!--  action=" <%--<%= contextPath %> --%> /insert.no" method="post" -->
			<form id="updateForm" action="<%= request.getContextPath() %>/update.no" method="post" enctype="multipart/form-data">
				<table align="center">
					<tr>
						<td colspan="1">
						<input type="hidden" name="no" value="<%= n.getNotice_No() %>">
						</td>
						<td colspan="1">
							<form class="searchArea" align="center" >
								<select id="condition" name="category" value="<%= n.getNotice_Category()%>">
									<option >유형선택</option>
									<option value="1">[공지]</option>
									<option value="2">[이벤트]</option>
								</select>
							</form>
						</td>
						<td colspan="2">제목</td>
						<td colspan="6"><input type="text" name="title" value="<%= n.getNotice_Title() %>"></td>
					</tr>

					<tr>
						<td>내용</td>
						<td colspan="9" ></td>
					</tr>
					<tr>
						<td colspan="10"> <textarea cols="120" rows="15"
								style="resize: none;" name="content"  ><%= n.getNotice_Content() %></textarea></td>
					</tr>
					<tr>
						<td colspan="3">첨부파일</td>
						
						<td colspan="7" >
						<% if(n.getNotice_File_Origin() != null){ %> <!-- 기존의 첨부파일이 있었을 경우 -->
							<%= n.getNotice_File_Origin() %> <br>
							<input type='hidden' name='upfile' value='<%=n.getNotice_File_System()%>'>
							<input type='hidden' name='upfile2' value='<%=n.getNotice_File_Origin()%>'>
						<% }%>
						<input type="file" name="new_upFile">
						
						
						
						
						
						</td>
					</tr>
				</table>
				<br>

				<div class="btns" align="center">
					<button type="submit">수정</button>
					<button type="reset">취소</button>

				</div>
			</form>
		</div>

	</section>

	<jsp:include page="../header_footer/footer.jsp" flush="true" />

</body>
</html>
		
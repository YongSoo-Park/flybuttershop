<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.review.model.vo.*" %>
    
<%
	Review r = (Review)request.getAttribute("r");
%>    
<!DOCTYPE html>
<html> 
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
	table{
		width: 600px;
	}
	.outer>table, .outer>table tr>*{
		border:1px solid black;
	}
	
	.outer>table{
		width:600px;
		height:300px;
	}
	
	.outer>table p{
		height:230px;
		margin: 0;
	}
	.reply>form>table{
		width:600px;
		height:200px;
		text-align:center;
	}
	.reView>table{
		width:600px;
		height:150px;
		text-align:center;
	}

</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2 align="center">상품 후기</h2><br>
	
	<div class="outer">
		<table align="center">
				<tr>
					<th width="100">별점</th>
					<td><%=r.getScore()%></td>
					<th width="100">제목</th>
					<td colspan="2"><%=r.getRe_title()%></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=r.getUserName()%></td>
					<th>작성일</th>
					<td><%=r.getRe_date()%></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<p><%=r.getRe_content()%></p>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td colspan="3">
						<p><%=r.getRe_originFile()%></p>
					</td>
				</tr>
		</table>
	</div>	
	
	<div class="reView">
		<table border="1" align="center">
			<% if(r.getRere_content() == null){ %>
			<tr>
				<td colspan="5">등록된 답변이 없습니다.</td>
			</tr>
			<%}else{ %>
				<tr>
					<td rowspan="2" width="100px">답변</td>
					<td colspan="4"><%=r.getRere_content()%></td>
				</tr>
				<tr>
					
					<td colspan="3" align="right"><%=r.getRere_date()%></td>
				</tr>
			<% } %>
		</table>
	
	</div>
	
	<br>
		<div class="text-center">
			<button id="btn" class="btn btn-outline-secondary" onclick="history.go(-1)">목록으로</button>
		</div>
	<br>
	
	<div class="reply">
		<form id="reply" action="<%= request.getContextPath() %>/reInsert.sl" method="post">
			<table  border="1" align="center">
				<tr>
					<th>답변작성<input type="hidden" name="rNo" value="<%=r.getRe_no()%>"></th>
					<td><textarea name="comment" rows="10" cols="60" id="replyContent" style="resize:none;"></textarea></td>
					<td><button type="submit" id="addReply">댓글등록</button></td>
				</tr>
			</table>
		</form>
	</div>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
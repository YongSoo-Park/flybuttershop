<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.qna.model.vo.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
    <%
    Qna q = (Qna)request.getAttribute("q");
	String qCategory = null;
	if(q.getQna_Category()==1){
		qCategory = "상품";
	}else if(q.getQna_Category()==2){
		qCategory = "배송";
	}else if(q.getQna_Category()==2){
		qCategory = "교환";
	}else if(q.getQna_Category()==2){
		qCategory = "반품";
	}else {
		qCategory = "기타";
	}
	 
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>상품 Q&A</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  <!--스타일 cdn?-->
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> <!--jQuery연결하는 CDN-->
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

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
	.reView>tbody>tr:hover{
		background: #0A174E;
		cursor:pointer
	}

</style>
<script type="text/javascript">
$(function() {
	   
   $('#mainCategory').css('box-sizing','unset');
})
$(function() {
   
   $('#userSearch').css('box-sizing','unset');
})
</script>
<title>Insert title here</title>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>

	<h2 align="center">상품 Q&A</h2><br>
	
	<div class="outer">
		<table align="center">
				<tr>
					<th width="100">문의유형</th>
					<td><%=qCategory%></td>
					<th>제목</th>
					<td colspan="2"><%=q.getQna_Title()%></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=q.getQna_Writer()%></td>
					<th>작성일</th>
					<td><%=q.getQna_Date()%></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<p><%=q.getQna_Content()%></p>
					</td>
				</tr>
		</table>
	</div>	
	
	<div class="reView">
		<table border="1" align="center">
			<% if(q.getQna_Comment() == null){ %>
			<tr>
				<td colspan="5">등록된 답변이 없습니다.</td>
			</tr>
			<%}else{ %>
				<tr>
					<td rowspan="2" width="100px">답변</td>
					<td colspan="4" width="300px"><%=q.getQna_Comment() %></td>
				</tr>
				<tr>
					
					<td colspan="3" align="right"><%=q.getQna_Comment_Date()%></td>
				</tr>
			<% } %>
		</table>
		<div class="btns" align="center">
			<form action="<%=request.getContextPath()%>/detail.pr"  method="post" >
				<input type="hidden" name="pCode" value="<%=q.getpCode()%>">
				<button type="submit" class="btn btn-outline-secondary">목록으로</button>
			</form>
		</div>
	</div>
		
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.qna.model.vo.*" %>

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
	#btn{
	align:center;
	}

</style>
<script type="text/javascript">
$(document).ready(function() {
    $('#replyContent').on('keyup', function() {
        if($(this).val().length > 150) {
            $(this).val($(this).val().substring(0, 150));
            alert("답변 글자수가 초과하였습니다.")
        }
    });

});
$(function(){
    $("textarea").keydown(function(){
        var inputLength = $(this).val().length;
        var remain = 150-inputLength;

        $("#count").html(remain)
        if(remain >= 0){
            $("#count").css("color", "black")

        }else{
            $("#count").css("color", "red")
        }

    })
})


</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
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
					<td colspan="4"><%=q.getQna_Comment() %></td>
				</tr>
				<tr>
					
					<td colspan="3" align="right"><%=q.getQna_Comment_Date()%></td>
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
		<form id="reply" action="<%= request.getContextPath() %>/rInsert.na" method="post" onsubmit="return insertValidate();">
			<table  border="1" align="center">
				<tr>
					<th>답변작성<input type="hidden" name="qNo" value="<%=q.getQna_No()%>"></th>
					<td><textarea name="comment" rows="10" cols="58" id="replyContent" placeholder="답변을 입력해주세요." style="resize:none;"></textarea>
						<p type="text" id="count"">150</p>
					</td>
					<td><button type="submit" id="addReply" class="btn btn-outline-primary">댓글등록</button></td>
				</tr>
			</table>
		</form>
	</div>
	

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
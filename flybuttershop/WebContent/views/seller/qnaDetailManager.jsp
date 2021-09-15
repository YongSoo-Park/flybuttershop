<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.flybutter.seller.model.vo.Seller"
	import="com.flybutter.qna.model.vo.*" %>

<%
	Qna q = (Qna)request.getAttribute("q");
	String qCategory = null;
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


</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true" />
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	<h2 align="center">상품 Q&A</h2><br>
	
	<table align="center">
			<tr>
				<th width="100">분야</th>
				<td><%=q.getQna_Category()%></td>
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
		
	

</body>
</html>
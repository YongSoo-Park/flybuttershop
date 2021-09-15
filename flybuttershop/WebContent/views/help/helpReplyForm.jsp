<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
	height: 500px;
	color: black;
	margin: auto;
	margin-top: 50px;
}

#enrollForm {
	width: 70%;
	margin: auto;
} 

#enrollForm>table {
	border: 1px solid white;
}

#enrollForm>table input {
	width: 70%;
	box-sizing: border-box;
}
</style>
</head>
<body style="margin: 0 auto">
	<jsp:include page="../header_footer/header.jsp" flush="true" />

	<section>
		<jsp:include page="../common/csMenubar.jsp" flush="true" />
		<div class="outer">

			<!--  action=" <%--<%= contextPath %> --%> /insert.no" method="post" -->
			<form id="enrollForm" action="<%= request.getContextPath() %>/insert.help" method="post" enctype="multipart/form-data">
				<table align="center">
					<tr>
						<td colspan="2">
							<form class="searchArea" align="center">
								<select id="condition" name="category">
									<option >유형선택</option>
									<option value="1">[배송문의]</option>
									<option value="2">[반품/교환/환불]</option>
									<option value="3">[주문/결제]</option>
									<option value="4">[회원서비스]</option>
									<option value="5">[판매자문의]</option>
									<option value="6">[기타문의]</option>
								</select>
							</form>
						</td>
						<td colspan="2">제목</td>
						<td colspan="6"><input type="text" name="title"></td>
					</tr>

					<tr>
						<td>내용</td>
						<td colspan="9"></td>
					</tr>
					<tr>
						<td colspan="10"> <textarea name="content" cols="120" rows="15"
								style="resize: none;"></textarea></td>
					</tr>
					<tr>
						<td colspan="3">첨부파일</td>
						<td colspan="7" ><input type="file" name="upfile"></td>
					</tr>
				</table>
				<br>

				<div class="btns" align="center">
					<button type="submit">등록</button>
					<button type="reset">취소</button>

				
				
				
			</form>
		</div>

	</section>

	<jsp:include page="../header_footer/footer.jsp" flush="true" />

</body>
</html>
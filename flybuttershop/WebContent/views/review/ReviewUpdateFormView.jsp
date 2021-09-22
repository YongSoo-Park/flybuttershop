<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.flybutter.review.model.vo.*"%>
    
<%
	
	Review r = (Review)request.getAttribute("r");
	String contextPath = request.getContextPath();


 %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>리뷰 수정</title>

<style>
	.outer{
		width:1200px;
		height:700px;
		margin:auto;
		margin-top:50px;
	}
	
	th, td{
		
        padding: 10px;
        padding-top: 20px;
        padding-right: 20px;
        

	}
	
	#insertForm>table input, #insertForm>table textarea{
		width:95%;
		box-sizing:border-box;
	}
</style>

</head>
<body style="margin: 0 auto">

    <jsp:include page="../header_footer/header.jsp" flush="true"/>
	
	<div class="outer">
		<br>
		
		<h2 align="center">리뷰 수정</h2>
		<br>
		
		<form id="insertForm" action="<%= contextPath %>/update.rv?rNo=<%= r.getRe_no()%>" method="post" enctype="multipart/form-data">
			<table align="center" rules="none" border="1px">
                <tr>
                    <th width="100">상품명</th>
                    <td width="700"><%= r.getpName() %></td>
                </tr>
				<tr>
					<th width="100">별점</th>
					<td width="700">
						<select name="score" required="required">
							<option value="5">★★★★★</option>
							<option value="4">★★★★☆</option>
							<option value="3">★★★☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="1">★☆☆☆☆</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" required="required" maxlength="20" value="<%= r.getRe_title() %>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="15" name="content" style="resize:none;" required="required" maxlength="1000">
						<%= r.getRe_content() %>
						</textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"></td>
                    
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit">등록하기</button>
			</div>

			
		</form>
	</div>
	


	<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.flybutter.review.model.vo.*"%>
    
<%
	
	int pNo = (int)request.getAttribute("pNo");
	String pName = (String)request.getAttribute("pName");
	String contextPath = request.getContextPath();


 %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>리뷰작성</title>

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
		
		<h2 align="center">리뷰 작성</h2>
		<br>
		
		<form id="insertForm" action="<%= contextPath %>/insert.rv" method="post" enctype="multipart/form-data">
			<table align="center" rules="none" border="1px">
                <tr>
                    <th width="100">상품명</th>
                    <td width="700"><%= pName %></td>
                </tr>
				<tr>
					<th width="100">별점</th>
					<td width="700">
						<select name="category">
							<option value="1">★★★★★</option>
							<option value="2">★★★★☆</option>
							<option value="3">★★★☆☆</option>
							<option value="4">★★☆☆☆</option>
							<option value="5">★☆☆☆☆</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="15" name="content" style="resize:none;"></textarea>
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
	
	<div name="pNo" style="display:none">숨길 내용</div>
	<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
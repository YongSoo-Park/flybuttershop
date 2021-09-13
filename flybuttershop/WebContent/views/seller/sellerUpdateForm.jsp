<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.outer{
		width:900px;
		height:700px;
		margin-top:50px;
		margin-left:auto;
		margin-right:auto;
	}
    #sellerUpdate td:nth-child(1){text-align:right;}
    #sellerUpdate input{margin:10px;}
    #sellerUpdate img{margin:10px;}
</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>

	<h2>상점 정보 수정</h2>
	<div class="outer">
	<form id="sellerUpdate" action="<%= request.getContextPath() %>/updateStore.sl" method="post">
		
		<table>
            
            <tr>
                <td>상점이름</td>
                <td><input type="text" name="storeName" value="${requestScope.seller.store_Name}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>대표자</td>
                <td><input type="text" name="address" value="${requestScope.seller.ceo}"></td>
            </tr>
            <tr>
                <td>소재지</td>
                <td><input type="text" name="address" value="${requestScope.seller.store_Address}"></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" name="address" value="${requestScope.seller.storeCall}"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="address" value="${requestScope.seller.email}"></td>
            </tr>
            <tr>
                <td>사업자등록번호</td>
                <td><input type="text" name="sellerNo" value="${requestScope.seller.seller_No}"></td>
            </tr>
            <tr>
                <td>계좌번호</td>
                <td><input type="text" name="account" value="${requestScope.seller.store_Account}"></td>
            </tr>
            <tr>
                <td>상점소개</td>
                <td><textarea class="form-control" id="storeExp" cols="10" row="5" name="storeExp">${requestScope.seller.store_Exp}</textarea></td>
            </tr>
        </table>
        <br><br><br>
		<div class="btns" align="center">
		<button type="submit" class="btn btn-outline-primary">수정하기</button>
		<button type="button" class="btn btn-outline-secondary" onclick="location.href=<%=request.getContextPath()%>">취소</button>
		</div>
	</form>
	</div>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.flybutter.product.model.vo.*"
	import="com.flybutter.seller.model.vo.*"%>

<%
	Product p = (Product)request.getAttribute("p");	
	Seller s = (Seller)request.getAttribute("s");
	String option = null;
	if(p.getpOption()==null){
		option = "없음";
	}else{
		option = p.getpOption();
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
.proInfo {
	text-align: center;
}


.bottom {
	text-align: center;
}

</style>
<script>
function orderValidate(){
	if(!(/^[0-9]{1,10}$/.test($("#proOrder input[name=pAmount]").val()))){
		 alert("주문수량에는 숫자만 입력가능합니다.")
		 $("#proOrder input[name=pAmount]").focus();
        return false;
	 }
	return true;
}
function orderProduct(){
	if(!(/^[0-9]{1,10}$/.test($("#proOrder input[name=pAmount]").val()))){
		 alert("주문수량에는 숫자만 입력가능합니다.")
		 $("#proOrder input[name=pAmount]").focus();
        return false;
	 }
	$("#proOrder").attr("action", "<%=request.getContextPath()%>/insertPurInfo.hy");
	$("#proOrder").submit();
	
	return true;
}

function basketProduct(){
	if(!(/^[0-9]{1,10}$/.test($("#proOrder input[name=pAmount]").val()))){
		 alert("주문수량에는 숫자만 입력가능합니다.")
		 $("#proOrder input[name=pAmount]").focus();
        return false;
	 }
	$("#proOrder").attr("action", "<%=request.getContextPath()%>/insertBasket.hy");
	$("#proOrder").submit();
	
	return true;
}

function qnaInsert(){
	$("#proOrder").attr("action", "<%=request.getContextPath()%>/qnaForm.sl");
	$("#proOrder").submit();
	
	return true;
	
}
function showDiv(element){
    var tag = document.getElementsByClassName("bottom");

    for(var i = 0; i < tag.length; i++){
        if(element.id+"Box" == tag[i].id){
            tag[i].style.display = "block";
        }else{
            tag[i].style.display = "none"
        }
    }

}

</script>
</head>
<body style="margin: 0 auto">
	<jsp:include page="../header_footer/header.jsp" flush="true" />

	<div class="outer">

	<div class="row justify-content-center" id="proInfo">

		<form id="proOrder" action="" method="post">
			<div class="productInfo" id="pImg">
				<table>
					<tr>
						<td rowspan="6"><img
							src="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}"
							width="400px" height="400px" name="pImg"
							value="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}"></td>
						<td><label id="pName" name="pName"
							value="${requestScope.p.pName}"><%=p.getpName() %></label></td>
					</tr>
					<tr>
						<td><label id="price" name="price" value="<%=p.getPrice()%>"><%=p.getPrice() %></label></td>
					</tr>
					<tr>
						<td><select class="form-select"
							aria-label="Default select example" name="pOption">
								<option selected>옵션선택</option>
								<option value="<%=option%>"><%=option%></option>
						</select></td>
					</tr>
					<tr>
						<td><label>수량 : </label><input type="text" name="pAmount"
							id="pAmount" /></td>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-outline-primary"
								onclick="basketProduct();">장바구니 담기</button>
							<button type="button" class="btn btn-outline-danger">찜하기</button>
						</td>
					</tr>
					<tr>
						<td><button type="button" class="btn btn-primary"
								onclick="orderProduct();">상품 주문</button></td>
					</tr>
				</table>
			</div>
			<input type="hidden" name="price" value="<%= p.getPrice() %>">
			<input type="hidden" name="storeNo" value="<%= s.getStore_No() %>">
			<input type="hidden" name="pCode" value="<%= p.getpCode() %>">
			<input type="hidden" name="sName" value="<%= s.getStore_Name() %>">
			<input type="hidden" name="pImg" value="<%= p.getpImage_Origin()%>">
			<input type="hidden" name="pName" value="<%= p.getpName() %>">
		</form>
	</div>

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" aria-current="page"
			onclick="showDiv(this);" id="info">상품 설명</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);"
			id="review">상품 후기</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);"
			id="qna">상품 Q&A</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);"
			id="store">상점 정보</a></li>
	</ul>

	<div id="infoBox" class="bottom">
		<div>
			<img
				src="${pageContext.request.contextPath}${requestScope.p.pExp_Image_Origin}">
		</div>
	</div>

	<div id="reviewBox" class="bottom">
	
	
	</div>

	<div id="qnaBox" class="bottom">
		<br> <br>
		<button type="button" class="btn btn-outline-dark"
			onclick="qnaInsert();">상품 문의하기</button>
		<br> <br>
		<table>
			<thead>
				<th>
				<%--잠금 이미지--%>
				</th>
				<th>글번호</th>
				<th>문의유형</th>
				<th>작성자</th>
				<th>제목</th>
				<th>답변여부</th>
				<th>작성일</th>
			</thead>

			<tbody>

			</tbody>
		</table>

	</div>

	<div id="storeBox" class="bottom">
		<br> <br>
		<table border="1">
			<tr>
				<th width="200px"><%=s.getStore_Name()%></th>
				<th width="200px"><%=s.getStore_Lev() %></th>
			</tr>
			<tr>
				<td>대표자</td>
				<td><%=s.getCeo() %></td>
			</tr>
			<tr>
				<td>소재지</td>
				<td><%=s.getStore_Address()%></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><%=s.getStoreCall() %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=s.getEmail() %></td>
			</tr>
			<tr>
				<td>사업자등록번호</td>
				<td><%=s.getSeller_No() %></td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><%=s.getStore_Account() %></td>
			</tr>
		</table>
		<br> <br>
		<button type="submit" class="btn btn-outline-primary">상점 상세 정보 보기</button>

	</div>
</div>


	<jsp:include page="../header_footer/footer.jsp" flush="true" />
</body>
</html>
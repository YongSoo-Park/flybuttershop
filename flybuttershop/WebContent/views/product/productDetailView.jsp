<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.flybutter.product.model.vo.Product, com.flybutter.product.model.vo.PageInfo"
	import="com.flybutter.seller.model.vo.*, com.flybutter.review.model.vo.*"
	import="java.util.ArrayList, com.flybutter.qna.model.vo.*"%>

<%
	Product pr = (Product)request.getAttribute("pr");	
	Seller s = (Seller)request.getAttribute("s");
	ArrayList<Qna> qList = (ArrayList<Qna>)request.getAttribute("qList");
	ArrayList<Review> rList = (ArrayList<Review>)request.getAttribute("rList");
	PageInfo piQna = (PageInfo) request.getAttribute("piQna");
	PageInfo pire = (PageInfo) request.getAttribute("pire");
	
	int listCountQ = piQna.getListCount();
	int currentPageQ = piQna.getCurrentPage();
	int maxPageQ = piQna.getMaxPage();
	int startPageQ = piQna.getStartPage();
	int endPageQ = piQna.getEndPage();
	
	int listCountR = pire.getListCount();
	int currentPageR = pire.getCurrentPage();
	int maxPageR = pire.getMaxPage();
	int startPageR = pire.getStartPage();
	int endPageR = pire.getEndPage();

	
	String qCategory = null;
	
	String option = null;
	if(pr.getpOption()==null){
		option = "없음";
	}else{
		option = pr.getpOption();
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
.none{
	display: none;
}

</style>
<script>
$(function() {
   $('#mainCategory').css('box-sizing','unset');
})
$(function() {
   
   $('#userSearch').css('box-sizing','unset');
})

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

function whishList(){
	$("#proOrder").attr("action", "<%=request.getContextPath()%>/addWish.mp");
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
$(function(){
	$(".qnaList>tbody>tr").click(function(){
		var qLock = $(this).children().eq(0).text();
		var qNo = $(this).children().eq(1).text();
		
		if(qLock == 2){
			location.href="<%= request.getContextPath() %>/checkQnaPwd.pr?qNo="+qNo;
		}else{
			location.href="<%= request.getContextPath() %>/qnaDetail.pr?qNo="+qNo;
		}
	})
})
	$(function(){
		$(".reviewList>tbody>tr").click(function(){
	 		var rNo = $(this).children().eq(0).text();
			location.href="<%= request.getContextPath() %>/reviewDetail.pr?rNo="+rNo;
		})
	})
	

</script>
<style type="text/css">
.product{
	text-align:center;		
}
</style>
</head>
<body style="margin: 0 auto">
	<jsp:include page="../header_footer/header.jsp" flush="true" />

	<div class="outer">

	<div class="row justify-content-center" id="proInfo">

		<form id="proOrder" action="" method="post">
			<div class="productInfo justify-content-center" id="pImg">
				<table class="product justify-content-center" align="center">
					<tr>
						<td rowspan="6"><img class="rounded float-start" src="${pageContext.request.contextPath}${requestScope.pr.pImage_Origin}" width="400px" height="400px" name="pImg" value="${pageContext.request.contextPath}${requestScope.pr.pImage_Origin}"></td>
						
						<td><label id="pName" name="pName" value="${requestScope.pr.pName}"><%=pr.getpName() %></label></td>
					</tr>
					<tr>
						<td><label id="price" name="price" value="<%=pr.getPrice()%>"><%=pr.getPrice() %></label></td>
					</tr>
					<tr>
						<td><select class="form-select"
							aria-label="Default select example" name="pOption">
								<option selected>옵션선택</option>
								<option value="<%=option%>"><%=option%></option>
						</select></td>
					</tr>
					<tr>
						<td><label>수량  </label><input type="text" name="pAmount"
							id="pAmount" /></td>
					</tr>
					<tr>
						<td>
							
								<button type="button" class="btn btn-outline-primary"
									onclick="basketProduct();">장바구니 담기</button>
								<button type="button" class="btn btn-outline-danger mx-auto" onclick="whishList();">찜하기</button>
					
						</td>
					</tr>
					<tr>
						<td><button type="button" class="btn btn-primary mx-auto"
								onclick="orderProduct();">상품 주문</button></td>
					</tr>
				</table>
			</div>
			<input type="hidden" name="price" value="<%= pr.getPrice() %>">
			<input type="hidden" name="storeNo" value="<%= s.getStore_No() %>">
			<input type="hidden" name="pCode" value="<%= pr.getpCode() %>">
			<input type="hidden" name="sName" value="<%= s.getStore_Name() %>">
			<input type="hidden" name="pImg" value="<%= pr.getpImage_Origin()%>">
			<input type="hidden" name="pName" value="<%= pr.getpName() %>">
		</form>
	</div>
	<br><br>
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
	<br><br>
		<div>
			<img
				src="${pageContext.request.contextPath}${requestScope.pr.pExp_Image_Origin}">
		</div>
	</div>

	<div id="reviewBox" class="bottom none">
		<br><br>
		<table class="reviewList" align="center">
		<thead>
			<tr>
				<th>글번호</th>
				<th>상품코드</th>
				<th>작성자</th>
				<th>제목</th>
				<th>별점</th>
				<th>등록일</th>
				<th>답변여부</th>
			</tr>
		</thead>
		<tbody>
			<% if(rList.isEmpty()){ %>
				<tr>
					<td colspan="5">등록된 후기가 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(Review r : rList){  %>
					<tr>
						<td><%= r.getRe_no() %></td>
						<td><%= r.getpCode() %></td>
						<td><%= r.getUserName()%></td>
						<td><%=r.getRe_title()%></td>
						<td><%=r.getScore()%></td>
						<td><%=r.getRe_date()%></td>
						<td><%=r.getRe_status()%></td>
					</tr>
				 	<% } %>
				 <% } %>	
		</tbody>
	</table>
	<br><br>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageR - 1%>'" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<!-- 이전페이지로(<) -->
				<%if (currentPageR == 1) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&lt;</a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageR - 1%>'">&lt;</a></li>

				<%}%>


				<%for (int p = startPageR; p <= endPageR; p++) {%>

					<%if (p == currentPageR) {%>
						<button disabled><%=p%></button>
					<%} else {%>
						<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=p%>'"><%=p%></a></li>
					<%}%>

				<%}%>
				<!-- 다음페이지로(>) -->
				<%if (currentPageR == maxPageR) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&gt; </a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageR + 1%>'">&gt; </a></li>

				<%}%>
					<a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageR + 1%>'" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
	
	</div>
	
	</div>



	<div id="qnaBox" class="bottom none">
		<br> <br>
		<button type="button" class="btn btn-outline-dark"
			onclick="qnaInsert();">상품 문의하기</button>
		<br> <br>
		
		<table class="qnaList table table-hover" align="center">
			<thead class="table-primary">
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
			<% if(qList.isEmpty()){ %>
				<tr>
					<td colspan="7">등록된 Q&A가 없습니다.</td>
				</tr>
			<% }else{ %>
				<% for(Qna q : qList){  
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
				<tr>
					<td>
					<%if(q.getLock_Flag()==1){ %>
						
					<%}else{ %>
						2
					<%} %>
					<input type="hidden" name="lock" value="<%=q.getLock_Flag()%>">
					<input type="hidden" name="pwd" value="<%=q.getQna_Pwd()%>">
					</td>
					<td><%=q.getQna_No() %></td>
					<td><%=qCategory %></td>
					<td><%=q.getQna_Writer()%></td>
					<td><%=q.getQna_Title()%></td>
					<td><%=q.getQna_Status()%></td>
					<td><%=q.getQna_Date()%></td>
				</tr>
			 	<% } %>
			 <% } %>	
		</tbody>
		</table>
		<br><br>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageQ - 1%>'" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<!-- 이전페이지로(<) -->
				<%if (currentPageQ == 1) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&lt;</a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageQ - 1%>'">&lt;</a></li>

				<%}%>


				<%for (int p = startPageQ; p <= endPageQ; p++) {%>

					<%if (p == currentPageQ) {%>
						<button disabled><%=p%></button>
					<%} else {%>
						<li class="page-item"><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=p%>'"><%=p%></a></li>
					<%}%>

				<%}%>
				<!-- 다음페이지로(>) -->
				<%if (currentPageQ == maxPageQ) {%>
					<li class="page-item" disabled><a class="page-link" disabled>&gt; </a></li>
				<%} else {%>
					<li class="page-item" disabled><a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageQ + 1%>'">&gt; </a></li>

				<%}%>
					<a class="page-link" onclick="location.href='<%=request.getContextPath()%>/detail.pr?currentPage=<%=currentPageQ + 1%>'" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
		

	</div>

	<div id="storeBox" class="bottom none">
		<br> <br>
		<table border="1">
			<tr>
				<th width="200px"><%=s.getStore_Name()%></th>
				<th width="200px">
				<%if(s.getStore_Lev()==1){ %>
                	<a>새싹 등급</a>
                	<%}else if(s.getStore_Lev()==2) {%>
                	<a>줄기 등급</a>
                	<%}else if(s.getStore_Lev()==3){ %>
                	<a>꽃 등급</a>
                	<%}else {%>
                	<a>상점 등급 없음</a>
                	<%} %>
				</th>
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
		
	</div>
</div>


	<jsp:include page="../header_footer/footer.jsp" flush="true" />
</body>
</html>
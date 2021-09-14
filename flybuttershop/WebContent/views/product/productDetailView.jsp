<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.product.model.vo.*" import="com.flybutter.seller.model.vo.*"%>
    
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
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
	.proInfo{
		text-align: center;
	}
	
	.productInfo{
		display: inline-block;
		text-align: center;
		border: 1px solid blue;
	}
	.bottom{
		text-align: center;
	}
</style>
<script>
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
<jsp:include page="../header_footer/header.jsp" flush="true"/>		


	<div class="row justify-content-center" id="proInfo">
        
        
        <form id="proOrder" action="<%= request.getContextPath() %>/insertBasket.hy"  method="post" onsubmit="return orderValidate();">
        
        	<div class="productInfo" id="pImg" >
            	<img src="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}" width="400px" height="400px" name="pImg">
       		</div>
        
	        <div class="productInfo" id="pInfo" aline="center">
	        	
	            <label id="pName" name="pName">${requestScope.p.pName}</label><br><br>
	            <label id="price" name="price">${requestScope.p.price}</label><br><br>
	            
	            <select class="form-select" aria-label="Default select example" name="pOption">
				  <option selected>옵션선택</option>
				  <option value="<%=option%>"><%=option%></option>
				</select><br><br>
				
				<label>수량 : </label><input type="text" name="pAmount" id="pAmount"/><br><br>
				
	            <button type="submit" class="btn btn-outline-primary">장바구니 담기</button>
	            <button type="button" class="btn btn-outline-danger">찜하기</button>
	            <br><br>
	            <button type="button" class="btn btn-primary" onclick="orderProduct();">상품 주문</button>
	    
	        </div>
	        
		</form>
    </div>

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link"
			aria-current="page" onclick="showDiv(this);" id="info">상품 설명</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);" id="review">상품 후기</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);" id="qna">상품 Q&A</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);" id="store">상점 정보</a></li>
	</ul>
	
	<div id="infoBox" class="bottom">
		<div>
			<img src="${pageContext.request.contextPath}${requestScope.p.pExp_Image_Origin}">
		</div> 
	</div>
	
	<div id="reviewBox" class="bottom">
		
	</div>
	
	<div id="qnaBox" class="bottom">
		<br><br>
		<button type="button" class="btn btn-outline-dark" onclick="qnaInsert();">상품 문의하기</button>
		<br><br>
	    <table>
        <thead>
            <th><%--잠금 이미지--%></th>
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
		<br><br>
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
		<br><br>
		<button type="submit" class="btn btn-outline-primary">상점 상세 정보 보기</button>
		
	</div>
	
	<form action="" id="postForm" method="post">
			<input type="hidden" name="pCode" value="<%= p.getpCode() %>">
			<input type="hidden" name="pImg" value="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}">
			<input type="hidden" name="price" value="<%= p.getPrice() %>">
			<input type="hidden" name="pOption" value="<%= p.getpOption() %>">
			<input type="hidden" name="pName" value="<%= p.getpName() %>">
			<input type="hidden" name="sName" value="<%= s.getStore_Name() %>">
			<input type="hidden" name="pAmount" value="#pAmount.val()">
			<input type="hidden" name="storeNo" value="<%= s.getStore_No() %>">
		</form>
	
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
			$("#postForm").attr("action", "<%=request.getContextPath()%>/insertPurInfo.hy");
			$("#postForm").submit();
			
			
			return true;
			
		}
		
		function qnaInsert(){
			
			$("#postForm").attr("action", "<%=request.getContextPath()%>/qnaForm.sl");
			$("#postForm").submit();
			
			
			return true;
			
		}
	</script>




<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
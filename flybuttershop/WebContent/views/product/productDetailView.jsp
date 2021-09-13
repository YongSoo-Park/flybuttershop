<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.product.model.vo.*"%>
    
<%
	Product p = (Product)request.getAttribute("p");	
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
        <div class="productInfo" id="pImg" >
            <img src="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}" width="400px" height="400px" name="pImg">
        </div>
        
        <form id="proOrder" action="<%= request.getContextPath() %>/insertBasket.hy" method="post">
	        <div class="productInfo" id="pInfo" aline="center">
	            <label id="pName" name="pName">${requestScope.p.pName}</label><br>
	            <label id="price" name="price">${requestScope.p.price}</label><br>
	            <select class="form-select" aria-label="Default select example" name="pOption">
				  <option selected>옵션선택</option>
				  <option value="<%=p.getpOption()%>"><%=p.getpOption()%></option>
				</select><br>
				<label>수량 : </label><input type="text" name="bAmount"/><br>
	            <button type="submit" class="btn btn-primary">장바구니 담기</button>
	            <button type="button" class="btn btn-danger">찜하기</button>
	        </div>
		</form>
    </div>
    
    <%-- 
			>주문하기 버튼 눌렀을 때 
			/insertPurInfo.hy--%>
    
    

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link"
			aria-current="page" onclick="showDiv(this);" id="info">상품 설명</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);" id="review">상품 후기</a></li>
		<li class="nav-item"><a class="nav-link" onclick="showDiv(this);" id="qna">상품 Q&A</a></li>
	</ul>
	
	<div id="infoBox" class="bottom">
		<div>
			<img src="${pageContext.request.contextPath}${requestScope.p.pExp_Image_Origin}">
		</div> 
	</div>
	
	<div id="reviewBox" class="bottom">
		
	</div>
	
	<div id="qnaBox" class="bottom">
		
	</div>




<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
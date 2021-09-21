<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.product.model.vo.*"%>
<%
	Product p = (Product)request.getAttribute("p");	
	
	String[] category = new String[8];

	String category1 = String.valueOf(p.getpCategory());
	switch(category1){
	case "1": category[0] = "checked"; break;
	case "2": category[1] = "checked"; break;
	case "3": category[2] = "checked"; break;
	case "4": category[3] = "checked"; break;
	case "5": category[4] = "checked"; break;
	case "6": category[5] = "checked"; break;
	case "7": category[6] = "checked"; break;
	case "8": category[7] = "checked"; break;
	}
	
	String[] subCategory = new String[5];
	String category2 = String.valueOf(p.getpCategory2());
	switch(category2){
	case "1": subCategory[0] = "checked"; break;
	case "2": subCategory[1] = "checked"; break;
	case "3": subCategory[2] = "checked"; break;
	case "4": subCategory[3] = "checked"; break;
	case "5": subCategory[4] = "checked"; break;
	}
	
	String[] sale = new String[2];
	String saleFlag = String.valueOf(p.getSale_Flag());
	switch(saleFlag){
	case "1": sale[0] = "checked"; break;
	case "2": sale[1] = "checked"; break;
	}
%>    
    
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
    div.box{display: none;}
    #productUpdate td:nth-child(1){text-align:right;}
    #productUpdate input{margin:10px;}
    #productUpdate img{margin:10px;}
</style>
<script>
function showDiv(element){
    
    var tag = document.getElementsByClassName("box");

    for(var i = 0; i < tag.length; i++){
        if(element.id+"Box" == tag[i].id){
            tag[i].style.display = "block";
        }else{
            tag[i].style.display = "none"
        }
    }

}
function updateValidate(){
	if(!(/^[a-z][a-z\d]{3,50}$/i.test($("#productUpdate input[name=pName]").val()))){
		alert("상품명에는 영어, 한글, 숫자만 입력가능합니다.");
		$("#productUpdate input[name=pName]").focus();
        return false;
	}
	
	 if(!(/^[0-9]{1,10}$/.test($("#productUpdate input[name=pStock]").val()))){
		 alert("상품재고에는 숫자만 입력가능합니다.")
		 $("#productUpdate input[name=pStock]").focus();
        return false;
	 }
	 
	 if(!(/^[0-9]{1,10}$/.test($("#productUpdate input[name=price]").val()))){
		 alert("상품가격에는 숫자만 입력가능합니다.")
		 $("#productUpdate input[name=price]").focus();
        return false;
	 }
	 if(!(/^[a-z][a-z\d]{3,20}$/i.test($("#productUpdate input[name=pOption]").val()))){
			alert("상품옵션에는 영어, 한글, 숫자만 입력가능합니다.");
			$("#productUpdate input[name=pOption]").focus();
	        return false;
		}
	 
	 return true;
}

	
	$(function(){
		$("#fileArea").hide();
		
		$("#pImg").click(function(){
			$("#file1").click();
		});
		
		$("#pExpImg").click(function(){
			$("#file2").click();
		});
	});
	
	function loadImg(inputFile, num){//이미지 미리보기
		
		if(inputFile.files.length == 1){
			var reader = new FileReader();
			
			reader.readAsDataURL(inputFile.files[0]);
			
			reader.onload = function(e){
				console.log(e);
				switch(num){
				case 1 : $("#pImg").attr("src", e.target.result); break; 
				case 2 : $("#pExpImg").attr("src", e.target.result); break;
				}
			};
			
		}
	}
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	<h2 class="text-center">상품 정보 수정</h2>
	
	<div class="outer">
	<form id="productUpdate" action="<%= request.getContextPath() %>/update.pr" method="post" enctype="multipart/form-data" onsubmit="return updateValidate();">
		<table>
			<tr>
				<td>상품코드</td>
				<td>
					<input type="text" class="form-control" name="pCode" value="<%=p.getpCode()%>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" class="form-control" name="pName" value="<%=p.getpName()%>"></td>
			</tr>
			<tr>
				<td>대분류</td>
				<td>
					<input type="radio" class="category1" onclick="showDiv(this);" id="cloth" name="category1" value="1" <%=category[0]%>>1. 의류
				    <input type="radio" class="category1" onclick="showDiv(this);" id="fancy" name="category1" value="2" <%=category[1] %>>2. 잡화
				    <input type="radio" class="category1" onclick="showDiv(this);" id="buety" name="category1" value="3" <%=category[2] %>>3. 뷰티
				    <input type="radio" class="category1" onclick="showDiv(this);" id="food" name="category1" value="4" <%=category[3] %>>4. 식/음료
				    <input type="radio" class="category1" onclick="showDiv(this);" id="home" name="category1" value="5" <%=category[4] %>>5. 가구
				    <input type="radio" class="category1" onclick="showDiv(this);" id="digital" name="category1" value="6" <%=category[5] %>>6. 전자기기
				    <input type="radio" class="category1" onclick="showDiv(this);" id="life" name="category1" value="7" <%=category[6] %>>7. 생필품
				    <input type="radio" class="category1" onclick="showDiv(this);" id="pet" name="category1" value="8" <%=category[7] %>>8. 반려동물
				</td>
			</tr>
			<tr>
				<td>중분류</td>
				<td>
					<div id="clothBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 여성상의
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 원피스
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 여성하의
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 남성상의
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 남성하의
				    </div>
				    <div id="fancyBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 모자
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 가방
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 시계
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 신발
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 벨트
				    </div>
				    <div id="buetyBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 기초
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 베이스메이크업
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 아이메이크업
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 립메이크업
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 바디
				    </div>
				    <div id="foodBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 차/음료
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 커피
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 스낵
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 운동보조식품
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 영양제
				    </div>
				    <div id="homeBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 가구커버
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 걸이용품
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 악세서리
				    </div>
				    <div id="digitalBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 주방기기
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 생활가전
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 음향기기
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 컴퓨터 주변기기
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 웨어러블기기
				    </div>
				    <div id="lifeBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 세탁세제
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 주방세제
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 욕실용품
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 구강/위생용품
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 기타
				    </div>
				    <div id="petBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1" <%=subCategory[0]%>>1. 사료
				        <input type="radio" class="category2" id="2" name="category2" value="2" <%=subCategory[1]%>>2. 장난감
				        <input type="radio" class="category2" id="3" name="category2" value="3" <%=subCategory[2]%>>3. 영양간식
				        <input type="radio" class="category2" id="4" name="category2" value="4" <%=subCategory[3]%>>4. 산책용품
				        <input type="radio" class="category2" id="5" name="category2" value="5" <%=subCategory[4]%>>5. 미용용품	
			        </div>			
				</td>
			</tr>
			<tr>
				<td>상품수량</td>
				<td><input type="text" class="form-control" name="pStock" value="<%=p.getpStock()%>">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><input type="text" class="form-control" name="price" value="<%=p.getPrice()%>">
				</td>
			</tr>
			<tr>
				<td>상품옵션</td>
				<td><input type="text" class="form-control" name="option" value="<%= p.getpOption()%>">
				</td>
			</tr>
			<tr>
				<td>상품세일여부</td>
				<td>
					<input type="radio" name="sale" value="2" <%=sale[1] %>>세일안함
					<input type="radio" name="sale" value="1" <%=sale[0] %>>세일적용
				</td>
			</tr>
			<tr>
				<td>상품이미지</td>
				<td>
					<img id="pImg" width="150" height="120" name="pImg" src="<%=p.getpImage_Origin()%>">
					
				</td>
			</tr>
			<tr>
				<td>상품설명이미지</td>
				<td>
					<img id="pExpImg" width="150" height="120" name="pExpImg" src="<%=p.getpExp_Image_Origin()%>">
					
				</td>
			</tr>
		</table>
		
		<div id="fileArea">
			<input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
			<input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
		</div>
		
		<div class="btns" align="center">
			<button type="submit" class="btn btn-outline-primary mb-3">수정하기</button>
			<button type="reset" class="btn btn-outline-danger mb-3" onclick="">취소</button>
		</div>
	</form>
	</div>
	


<jsp:include page="../header_footer/footer.jsp" flush="true"/>
	
</body>
</html>
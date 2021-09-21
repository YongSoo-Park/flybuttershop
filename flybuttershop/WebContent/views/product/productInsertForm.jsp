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
		height:1000px;
		margin-top:50px; 
		margin-left:auto;
		margin-right:auto;
	}
    div.box{display: none;}
    #productInsert td:nth-child(1){text-align:right;}
    #productInsert input{margin:10px;}
    #productInsert img{margin:10px;}
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

    </script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	<h2 class="text-center">상품 등록</h2>
	
	<div class="outer">
	<form id="productInsert" action="<%= request.getContextPath() %>/insert.pr" method="post" enctype="multipart/form-data" onsubmit="return insertValidate();">
		<table>
			<tr>	
				<td>상품코드</td>
				<td>
					<input type="text" class="form-control" name="pCode" required>
					<button type="button" class="btn btn-outline-primary mb-3" id="codeCheckBtn" onclick="checkCode();">중복확인</button>
				</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" class="form-control" name="pName"></td>
			</tr>
			<tr>
				<td>대분류</td>
				<td>
					<input type="radio" class="category1" onclick="showDiv(this);" id="cloth" name="category1" value="1">1. 의류
				    <input type="radio" class="category1" onclick="showDiv(this);" id="fancy" name="category1" value="2">2. 잡화
				    <input type="radio" class="category1" onclick="showDiv(this);" id="buety" name="category1" value="3">3. 뷰티
				    <input type="radio" class="category1" onclick="showDiv(this);" id="food" name="category1" value="4">4. 식/음료
				    <input type="radio" class="category1" onclick="showDiv(this);" id="home" name="category1" value="5">5. 가구
				    <input type="radio" class="category1" onclick="showDiv(this);" id="digital" name="category1" value="6">6. 전자기기
				    <input type="radio" class="category1" onclick="showDiv(this);" id="life" name="category1" value="7">7. 생필품
				    <input type="radio" class="category1" onclick="showDiv(this);" id="pet" name="category1" value="8">8. 반려동물
				</td>
			</tr>
			<tr>
				<td>중분류</td>
				<td>
					<div id="clothBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 여성상의
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 원피스
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 여성하의
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 남성상의
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 남성하의
				    </div>
				    <div id="fancyBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 모자
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 가방
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 시계
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 신발
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 벨트
				    </div>
				    <div id="buetyBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 기초
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 베이스메이크업
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 아이메이크업
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 립메이크업
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 바디
				    </div>
				    <div id="foodBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 차/음료
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 커피
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 스낵
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 운동보조식품
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 영양제
				    </div>
				    <div id="homeBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 가구커버
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 걸이용품
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 악세서리
				    </div>
				    <div id="digitalBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 주방기기
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 생활가전
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 음향기기
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 컴퓨터 주변기기
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 웨어러블기기
				    </div>
				    <div id="lifeBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 세탁세제
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 주방세제
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 욕실용품
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 구강/위생용품
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 기타
				    </div>
				    <div id="petBox" class="box">
				        <input type="radio" class="category2" id="1" name="category2" value="1">1. 사료
				        <input type="radio" class="category2" id="2" name="category2" value="2">2. 장난감
				        <input type="radio" class="category2" id="3" name="category2" value="3">3. 영양간식
				        <input type="radio" class="category2" id="4" name="category2" value="4">4. 산책용품
				        <input type="radio" class="category2" id="5" name="category2" value="5">5. 미용용품	
			        </div>			
				</td>
			</tr>
			<tr>
				<td>상품수량</td>
				<td><input class="form-control" type="text" name="pStock">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><input class="form-control" type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>상품옵션</td>
				<td><input class="form-control" type="text" name="option">
				</td>
			</tr>
			<tr>
				<td>상품세일여부</td>
				<td>
					<input type="radio" name="sale" value="2" checked>세일안함
					<input type="radio" name="sale" value="1">세일적용
				</td>
			</tr>
			<tr>
				<td>상품이미지</td>
				<td>
					<img id="pImg" width="150" height="150" name="pImg">
					
				</td>
			</tr>
			<tr>
				<td>상품설명이미지</td>
				<td>
					<img id="pExpImg" width="150" height="150" name="pExpImg">
					
				</td>
			</tr>
		</table>
		
		<div id="fileArea">
			<input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
			<input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
		</div>
		
		<div class="btns" align="center">
			<button type="submit">등록하기</button>
			<button type="button" onclick="history.go(-1)">취소</button>
		</div>
	</form>
	</div>
	
	<script>
	
	$(function(){
		$("#fileArea").hide();
		
		$("#pImg").click(function(){
			$("#file1").click();
		});
		
		$("#pExpImg").click(function(){
			$("#file2").click();
		});
	});
	
	function checkCode(){
		var pCode = $("#productInsert input[name=pCode]");
		if(pCode.val()==""){
			alert("상품코드를 입력해주세요.")
			return false;
		}
		$.ajax({
			url : "codeCheck.pr",
			type : "post",
			data : {pCode : pCode.val()},
			success : function(result){
				if(result == "fail"){
					alert("사용할 수 없는 상품코드입니다.")
					pCode.focus();
				}else{
					if(confirm("사용 가능한 상품코드입니다. 사용하시겠습니까?")){
						pCode.attr("readonly", "true");
					}else{
						pCode.focus();
					}	
				}
			},
			error : function(){
				console.log("서버통신실패");
			}
		})
	}
	
	function insertValidate(){
		if(!(/^[a-z][a-z\d]{3,50}$/i.test($("#productInsert input[name=pName]").val()))){
			alert("상품명에는 영어, 한글, 숫자만 입력가능합니다.");
			$("#productInsert input[name=pName]").focus();
	        return false;
		}
		
		 if(!(/^[0-9]{1,10}$/.test($("#productInsert input[name=pStock]").val()))){
			 alert("상품재고에는 숫자만 입력가능합니다.")
			 $("#productInsert input[name=pStock]").focus();
	        return false;
		 }
		 
		 if(!(/^[0-9]{1,10}$/.test($("#productInsert input[name=price]").val()))){
			 alert("상품가격에는 숫자만 입력가능합니다.")
			 $("#productInsert input[name=price]").focus();
	        return false;
		 }
		 if(!(/^[a-z][a-z\d]{3,20}$/i.test($("#productInsert input[name=pOption]").val()))){
				alert("상품옵션에는 영어, 한글, 숫자만 입력가능합니다.");
				$("#productInsert input[name=pOption]").focus();
		        return false;
			}
		 
		 return true;
	}
	
	
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


<jsp:include page="../header_footer/footer.jsp" flush="true"/>
	
</body>
</html>
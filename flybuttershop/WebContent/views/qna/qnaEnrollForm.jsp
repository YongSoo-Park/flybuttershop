<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.product.model.vo.Product"
    import="com.flybutter.seller.model.vo.*"%>

<%
Product p = (Product)request.getAttribute("p");		
Seller s = (Seller)request.getAttribute("s");	
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
<title>Insert title here</title>
<style> 
	.outer {
	width: 1200px;
	height: 1000px;
	color: black;
	margin: auto;
	margin-top: 50px;
}
#qnaForm {
	width: 70%;
	margin: auto;
}
#qna>table {
	border: 1px solid white;
}

#qna>table input {
	width: 500px;
	box-sizing: border-box;
}
#qnaForm>img{
	height: 200px;
	width: 200px;
}
#pInfo{
	height: 70%;
}

</style>
<script>

function checkedChange(){

    if($("#qnaForm input[name=lock]").prop("checked")){
    	$("#qnaForm input[name=pwd]").attr("type", "password");
    }else{
    	$("#qnaForm input[name=pwd]").attr("type", "hidden");
    }
}
function insertValidate(){
	if(!(/^[0-9]{1,10}$/.test($("#qnaForm input[name=pwd]").val()))){
		 alert("비밀번호에는 숫자만 입력가능합니다.")
		 $("#qnaForm input[name=pwd]").focus();
       return false;
	 }
}
$(function(){
    $("textarea").keydown(function(){
        var inputLength = $(this).val().length;
        var remain = 300-inputLength;

        $("#count").html(remain)
        if(remain >= 0){
            $("#count").css("color", "black")

        }else{
            $("#count").css("color", "red")
        }

    })
})
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>


	<div class="outer">
	
	<h2>상품 Q&A 작성</h2>
	
           <form id="qnaForm" action="<%= request.getContextPath() %>/insertQna.pr" method="post" onsubmit="return insertValidate();">
            <table id="pInfo" align="center">
                <tr>
                    <th colspan="2">문의 상품 정보</th>
                </tr>
                <tr>
                    <td rowspan="3"><img src="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}" width="200px" height="200px" align="top"></td>
                    <td><%=p.getpName() %></td>
                </tr>
                <tr>
                    
                    <td><%=p.getPrice() %></td>
                </tr>
                <tr>
                    
                    <td><%=s.getStore_Name() %></td>
                </tr>
                
            </table>
           	<br><br>
            <table align="center">
                <tr>
                    <td>
                        <form class="category" align="center">
                            <select id="category" name="category">
                                <option >문의유형선택</option>
                                <option value="1">상품</option>
                                <option value="2">배송</option>
                                <option value="3">교환</option>
                                <option value="4">반품</option>
                                <option value="5">기타</option>
                            </select>
                        </form>
                    </td>
                    <td colspan="2">제목</td>
                    <td colspan="6"><input type="text" name="title"></td>
                </tr>

                <tr>
                    <td>내용</td>
                    <td ><input type="checkbox" id="lock" class="box" name="lock" value="2" onclick="checkedChange()">비밀글</td>
                    <td colspan="8"><input type="hidden" class="pwdBox" name="pwd">
                    	<input type="hidden" class="storeNo" name="storeNo" value="<%=s.getStore_No()%>">
                    </td>
            
                </tr>
                <tr>
                    <td colspan="10"> <textarea name="content" cols="120" rows="15"
                            style="resize: none;">
                            
                            </textarea>
                            <p type="text" id="count"">300</p>
                            </td>
                            
                </tr>
                 
            </table>
            <br>

            <div class="btns" align="center">
                <button type="submit" class="btn btn-outline-primary">문의 등록</button>
                <button type="reset" class="btn btn-outline-dark" onclick="history.go(-1)">취소</button>

            </div>
        </form>
    </div>

	
<jsp:include page="../header_footer/footer.jsp" flush="true"/>	
</body>
</html>
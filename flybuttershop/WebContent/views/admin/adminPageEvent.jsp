<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
#adminWrap{
display: flex;
}
#adminPage{
width: 200px;
border-right: solid 1px;
display: table;
}
#adminPageTitle{
display: table-cell;
 text-align: center;
 font-family: 맑은 명조;
 font-size: 23px;
 font-weight: bold;
}
#adminPageTitle a{
text-decoration: none;
color: black;
}
#MPEventWrap{

width: 1000px;
border-left: solid 1px;
}
#nowEventImgWrap{
 text-align: center;
width: 1000px;
}

.Img_Rate_Tile{
margin-top : 50px;
margin-left : 10px;
margin-bottom : 20px;
width: 980px;
height: 100px;
text-align: center;
font-weight: bold;
font-size: 35px;
font-family: 맑은 고딕;
}
#memberControl{
display : inline-block;
width: 980px;
height: 800px;
border: solid 1px;
border-top: none;
}

</style>
<script type="text/javascript">
$(function() {
	var msg = "<c:out value='${requestScope.upResultMsg}'/>"
	if(msg != ""){
		alert(msg);
	}
	
})

function checkRate() {
	var saleRate = document.getElementById("saleRate").value;
	if(saleRate>100){
		document.getElementById("saleRate").value="";
		alert("일괄 할인율 설정은 0% ~ 100% 까지만 가능합니다.");
		document.getElementById("saleRate").focus();
	}
	 
}

function saleRateChange() {
	var saleRate = document.getElementById("saleRate").value;
	if(saleRate==""){
		document.getElementById("saleRate").value="";
		alert("일괄 할인율 설정은 0 ~ 100 숫자를 넣어주셔야합니다.");
		document.getElementById("saleRate").focus();
	}else if(confirm("일괄 할인율을 "+saleRate+"%로 변경하시겠습니까?")){
		$('#saleRateChangeForm').submit();
	}
}


function doNotReload(){
    if( (event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82)) || (event.keyCode == 116) ) {
        event.keyCode = 0;
        event.cancelBubble = true;
        event.returnValue = false;
    } 
}
document.onkeydown = doNotReload;
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<div id="adminWrap">
<div id="adminPage">
<div id="adminPageTitle">
<p style="margin-top: 20px; font-size: 35px">관리 페이지</p><hr>
<p style="margin-top: 150px"><a href="adminevent.ad">이벤트&할인율<br>관리---></a></p>
<p style="margin-top: 150px"><a href="adminconfirm.ad">판매자 신청<br>승인</a></p>
<p style="margin-top: 150px"><a href="adminpage.ad">회원 관리</a></p>

</div>
</div>
<div id="MPEventWrap">

<div id="nowEventImgWrap">
<div id="nowEventImgTitle" class="Img_Rate_Tile">메인페이지 이벤트 이미지 설정</div>
현재 설정된 이벤트 이미지 입니다.<br><br><br>
<div id="nowEventImgView" style="display: flex;">
<div id="nowEventImg1">1번 이벤트 이미지
<img src="${requestScope.mainPageList.f_Event_Img_Sys}" style="cursor: pointer; width: 400px; height: 240px;"/></div>
<div id="nowEventImg2">2번 이벤트 이미지
<img src="${requestScope.mainPageList.s_Event_Img_Sys}" style="cursor: pointer; width: 400px; height: 240px;"/></div>
</div>
<br>
<span style="font-weight: bold; font-family: 맑은 명조; font-size: 20px;">이벤트 이미지는 업로드는 png와 jpg 확장자, 파일 크기는 20메가 이하만 가능합니다. <br><br>이미지 해상도는 600px X 350px 이 가장 정확하게 표현됩니다</span><br><br><br>
<form action="mainpageEventSet.ad" method="post" enctype="multipart/form-data" style="width: 980px;">
<div id="nowEventImgForm" style="display: flex; text-align: center; width: 980px;">
<div style="width: 490px; padding-left: 50px; ">1번 이벤트 이미지 파일 교체 : <input type="file" name="eventImg1"></div>
<div style="width: 490px; padding-left: 50px; ">2번 이벤트 이미지 파일 교체 : <input type="file" name="eventImg2"></div>
</div>
<br><br><br><input type="submit" value="이미지 업로드">
</form>
</div>
<br>
<hr>

<div id="discountRateWrap">

<div id="discountRateTitle" class="Img_Rate_Tile">
세일 상품 일괄 할인율 설정
</div>

<div style="text-align: center;">
현재 설정되어 있는 일괄 할인율은 <span style="font-size: 25px; font-weight: bold;"><c:out value="${requestScope.mainPageList.discount_Rate}"/>% </span> 입니다.<br><br><br>
<form action="discountRate.ad" method="post" id="saleRateChangeForm">
<span style="font-weight: bold; font-family: 맑은 명조; font-size: 20px;">일괄 할인율은 0% ~ 100% 까지 설정하실 수 있습니다.<br><br>
새롭게 적용할 일괄 할인율 : 
<input type="text" id="saleRate" name="newSaleRate" oninput="this.value=this.value.replace(/[^0-9]/g,'');" onkeyup="checkRate();" maxlength="3" style="width: 50px; height: 20px;">%</span> &nbsp;&nbsp;&nbsp;
<input type="button" value="할인율 변경" onclick="saleRateChange()"><br><br><br><br><br>
</form>

</div>
</div>
</div>




</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
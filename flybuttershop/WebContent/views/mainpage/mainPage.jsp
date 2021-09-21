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
#bestTitle{
position: absolute;
top: 650px;
left: 0px
}
#saleTitle{
position: absolute;
top: 1150px;
left: 0px
}
#newTitle{
position: absolute;
top: 2000px;
left: 0px
}
.titles{
text-align: center;
width: 1200px;
font-size: 40px;
}
#bestPWrap{
position: absolute;
top :750px;
left: 0px;
border : solid 1px;
background-color: white;
width: 1200px;
height: 280px;
display: flex;
}
#hiddenDiv{
position: absolute;
top : 0px;
right: 0px;
visibility: hidden;
opacity: 0;
display: flex;
}
.bestItems{
text-align: center;
margin : 4px;
border: solid 0.5px #48BAE4;
}
#salePWrap{
position : absolute;
top : 1250px;
 border: solid 1px; 
 padding-top: 10px;
 text-align: center;
 
}
.salePBtn{
width: 132px;
border : solid 0.5px #48BAE4;
height: 35px;
background-color: white;
font-size: 20px;
cursor: pointer;
}
#salePBtn0{
border-bottom: none;
}
.saleListCategory{
display: block;
opacity: 0;
  visibility: hidden;
  position: absolute;
top:50px;
left: 0px;
}
.saleListItemsWrap{

display: flex;
}
.saleListItems{
text-align: center;
margin : 4px;
border: solid 0.5px #48BAE4;
}
#saleListCategory0{
visibility: visible;
opacity: 1;
}
#newListWrap{
position : absolute;
top : 2100px;
 border: solid 1px; 
 text-align: center;
width: 1200px;
}
.newList{

display: flex;
}
.newListItems{
text-align: center;
margin : 4px;
margin-left : 55px;
margin-right : 55px;
border: solid 0.5px #48BAE4;
}
</style>
<script type="text/javascript">
$(function() {

	var start = 0;
	var end = 5;
	var sumsub = 0;
	setInterval(() => {
		if(start == 0){
			sumsub = 1;
		}
		if(end == 15){
			sumsub = 2;
		}
		if(sumsub == 1){
			start = start+1;
			end = end+1;
		}
		if(sumsub == 2){
			start = start-1;
			end = end-1;
		}
		var strStart = String(start);
		var strEnd = String(end);
		var saleitemsview = $('#bestPWrap');
 		saleitemsview.empty();
		for(var i = start; i < end+1 ; i++ ){			
			saleitemsview.append($('#bestItems'+String(i)).clone()); 
		}
		$('#bestTitle').append($('#bestItems16').clone())
	}, 3000);
	$('.salePBtn').click(function() {
		var num = $(this).val();
		var thisSaleCategory = $('#saleListCategory'+num);

		$(this).css("border-bottom","none")
		$('.salePBtn').not(this).css("border-bottom","solid 0.5px #48BAE4")
		thisSaleCategory.css({"visibility" : "visible","opacity" : "1"});
		$('.saleListCategory').not(thisSaleCategory).css({"visibility" : "hidden","opacity" : "0"});
	})
})



</script>

</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>

<main>

<div style="display: flex; position: absolute; top : 180px;">
<img src="${requestScope.mainPageList.f_Event_Img_Sys}" style="cursor: pointer; width: 600px; height: 350px;" onclick="location.href='noticeList.no'"/>
<img src="${requestScope.mainPageList.s_Event_Img_Sys}" style="cursor: pointer; width: 600px; height: 350px;" onclick="location.href='noticeList.no'"/>

</div>
<br>
<br>
<br>
<div id="bestTitle" class="titles"><b>FlyButterShop`s Best!!</b><br></div>
<div id="bestPWrap">

<c:forEach items="${requestScope.bestList}" var="list" end="5">
	<div id="bestItems" class="bestItems">
		<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCODE}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/><br><c:out value="${list.price}"/>원
		</div>
		
</c:forEach>
</div>
<div id="saleTitle" class="titles"><b>FlyButterShop`s On Sale For <c:out value="${requestScope.mainPageList.discount_Rate}"></c:out>% Off!!!</b><br></div>
<div id="salePWrap">
<button id="salePBtn0" class="salePBtn" value="0">통합</button><button id="salePBtn1" class="salePBtn" value="1">의류</button><button id="salePBtn2" class="salePBtn" value="2">잡화</button><button id="salePBtn3" class="salePBtn" value="3">뷰티</button><button id="salePBtn4" class="salePBtn" value="4">식품</button><button id="salePBtn5" class="salePBtn" value="5">가구</button><button id="salePBtn6" class="salePBtn" value="6">전자기기</button><button id="salePBtn7" class="salePBtn" value="7">생필품</button><button id="salePBtn8" class="salePBtn" value="8">반려동물</button>
<div id="saleItems0" style="width: 1186px; height : 550px;  display: inline-block;" ></div>

<c:forEach items="${requestScope.saleTotalList}" varStatus="status" var="list">

<div id="saleListCategory${status.index}" class="saleListCategory">
<div class="saleListItemsWrap">
<c:forEach items="${list}" var="items" varStatus="subStatus" end="5">
<div class="saleListItems">
<img alt="" src="${pageContext.request.contextPath}${items.pImage_Origin}" width="190px" height="190px" onclick="detailP('${items.pCODE}')" style="cursor: pointer;"><br>
		<c:out value="${items.pName}"/><br><c:out value="${items.price}"/>원
		</div>
</c:forEach>
</div>

<div class="saleListItemsWrap">
<c:forEach items="${list}" var="items" varStatus="subStatus" begin="6">
<div class="saleListItems">
<img alt="" src="${pageContext.request.contextPath}${items.pImage_Origin}" width="190px" height="190px" onclick="detailP('${items.pCODE}')" style="cursor: pointer;"><br>
		<c:out value="${items.pName}"/><br><c:out value="${items.price}"/>원
		</div>
</c:forEach>
</div>
</div>
</c:forEach>
</div>
<div id="newTitle" class="titles"><b>FlyButterShop`s New Collection!!</b><br></div>
<div id="newListWrap">
<div id="newList1" class="newList">
<c:forEach items="${requestScope.newList}" var="list" end="3">
<div class="newListItems">
<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCODE}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/><br><c:out value="${list.price}"/>원
</div>
</c:forEach>

</div>
<div id="newList2" class="newList">

<c:forEach items="${requestScope.newList}" var="list" begin="4">
<div class="newListItems">
<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCODE}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/><br><c:out value="${list.price}"/>원
</div>
</c:forEach>
</div>
</div>

<div style="position: absolute; top : 2700px;">
<form action="dummyLoginA.ma" method="post">
<input type="hidden" value="0" name="no">
<input type="submit" value="관리자로그인">
</form>
<br>
<br>
<form action="dummyLoginA.ma" method="post">

<input type="hidden" value="1" name="no">
<input type="submit" value="일반회원로그인">
</form>
<br>
<br>
<form action="dummyLoginA.ma" method="post">
<input type="hidden" value="4" name="no">
<input type="submit" value="판매자로그인">
</form>

<br>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div id="hiddenDiv">
<c:forEach items="${requestScope.bestList}" var="list" varStatus="status"><div id="bestItems${status.index}" class="bestItems">
	<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCODE}')" style="cursor: pointer;"><br>
	<c:out value="${list.pName}"/><br><c:out value="${list.price}"/>원</div></c:forEach>
</div>



</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>

</body>
</html>
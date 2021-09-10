<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
#bestTitle{
text-align: center;
width: 1200px;
font-size: 40px;
position: absolute;
top: 550px;
left: 0px
}
#bestPWrap{
position: absolute;
top :650px;
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
})


</script>

</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>

<main>
<br>
<br>
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

<br>
<div id="bestTitle"><b>FlyButterShop`s Best!!</b><br></div>
<div id="bestPWrap">

<c:forEach items="${sessionScope.saleList}" var="list" end="5">
	<div id="bestItems" class="bestItems">
		<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCODE}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/>
		</div>
		
</c:forEach>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<div id="hiddenDiv">
<c:forEach items="${sessionScope.saleList}" var="list" varStatus="status"><div id="bestItems${status.index}" class="bestItems">
	<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCODE}')" style="cursor: pointer;"><br>
	<c:out value="${list.pName}"/><c:out value="${status.index}"/></div></c:forEach>
</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>

</body>
</html>
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
#bestPWrap{
position: absolute;
top :530px;
left: 0px;
background-color: blue;
width: 1200px;
height: 500px;
display: flex;
}

</style>
<script type="text/javascript">
$(function() {
	console.log("11111")
	<c:set var="start" value="0" />
	<c:set var="end" value="6" />
	<c:set var="sumsub" value="0" />
	<c:set var="name" value="홍길동" />
	setInterval(() => {

		console.log(${start})
		<c:if test="${start eq 0}">
		<c:set var="sumsub" value="1" />
		console.log("asfasfsf")
		</c:if>
		<c:if test="${end == 16}">
		<c:set var="sumsub" value="2" />
		</c:if>
		<c:if test="${sumsub eq 1}">
		<c:set var="start" value="${start+1}" />

		console.log(${start})
		<c:set var="end" value="${end+1}" />
		</c:if>
		<c:if test="${sumsub == 2}">
		<c:set var="start" value="${start-1}" />
		<c:set var="end" value="${end-1}" />
		</c:if>
		var opo = <c:out value="${sessionScope.loginMember.MEM_USER_NO}"/>;
		var saleitemsview = $('#bestPWrap');

		console.log($('#bestItems'))
 		saleitemsview.empty(); 
		var str = '<c:forEach items="${sessionScope.saleList}" var="list" varStatus="status"><div id="bestItems${status.index}">'+
			'<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" style="margin: 5px"><br>'+
			'<c:out value="${list.pName}"/></div></c:forEach>';
			$('#hiddenDiv').append(str);
			console.log($('#bestItems0'));
			saleitemsview.append($('#bestItems0')); 
			saleitemsview.append($('#bestItems6')); 
			saleitemsview.append($('#bestItems2')); 
			saleitemsview.append($('#bestItems3')); 
			saleitemsview.append($('#bestItems4')); 
			saleitemsview.append($('#bestItems5')); 
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

<div id="bestPWrap">
<c:forEach items="${sessionScope.saleList}" var="list" end="5">
	<div id="bestItems">
		<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" style="margin: 5px"><br>
		<c:out value="${list.pName}"/>
		</div>
		
</c:forEach>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div style="visibility: hidden; opacity: 0" id="hiddenDiv"></div>

</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
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
#searchSalePTitle{
font-family: 맑은 명조;
font-size: 30px;
margin-bottom: 20px;
font-weight: bold;
}
#searchSalePWrap{
border : solid 1px;
background-color: white;
width: 1200px;
height: 300px;
display: flex;
}


.searchSaleItems{
width : 190px;
text-align: center;
margin : 4px;
border: solid 0.5px #48BAE4;
}
#wrongWord{
position: absolute;
top: 500px;
left: 0px;
width: 1200px;
font-family: 맑은 명조;
font-size: 50px;
text-align: center;
}
</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<c:if test="${requestScope.searchListEmpty == 0}">
<div id="searchSalePTitle">세일중인 '<c:out value="${requestScope.sWord}"/>' 상품</div>
<div id="searchSalePWrap">

<c:forEach items="${requestScope.searchSaleList}" var="list" end="5">
	<div id="searchSaleItems" class="searchSaleItems">
		<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCode}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/><br><span style="line-height: 20%"><br></span><c:out value="${list.price}원"/>
		</div>
	
</c:forEach>
</div>
</c:if>
<c:if test="${requestScope.searchListEmpty == 1}">
<div id="wrongWord">
검색하신 단어 '<c:out value="${requestScope.sWord}"/>' 에 <br>관련된 상품을 찾지 못했습니다.
</div>

</c:if>
</body>
</html>
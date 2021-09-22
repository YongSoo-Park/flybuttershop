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
#categorySalePTitle{
font-family: 맑은 명조;
font-size: 30px;
margin-bottom: 20px;
font-weight: bold;
}
#categorySalePWrap{
border : solid 1px;
background-color: white;
width: 1200px;
height: 300px;
display: flex;
}


.categorySaleItems{
width : 190px;
text-align: center;
margin : 4px;
border: solid 0.5px #48BAE4;
}
#wrongWord{
margin-top : 200px;
margin-bottom : 400px;
width: 1200px;
font-family: 맑은 명조;
font-size: 50px;
text-align: center;
}
#categoryListPWrap{
margin-top: 100px;
}
#categoryListPTitle{
font-family: 맑은 명조;
font-size: 30px;
margin-bottom: 50px;
font-weight: bold;
}
#selectSKind{
height: 30px;
width: 350px;
font-size: 20px;
font-family: 맑은 명조;
border : solid 0.5px #48BAE4;
margin-left: 850px;
margin-bottom: 30px;
}
.categoryList{
display: flex;
border: solid 0.5px #48BAE4;
margin-bottom: 20px;
width: 1200px;
font-family: 맑은 명조;;
}
.categoryListItem1{
width: 180px;
margin: 10px;

}
.categoryListItem2{
width: 700px;
}
.categoryListItem3{
width: 100px;
display: flex;
align-items: center;
}
.categoryListItem4{
width: 200px;
border-left: solid 0.5px #48BAE4;
display: table;
}
.categoryListItem4child{
display: table-cell;
    vertical-align: middle;

text-align: center;
}
#pageNumber{
font-size: 25px;
text-align: center;
}
</style>
<script type="text/javascript">

$(function() {
	
	
	var isMsg = sessionStorage.getItem("isMsg");
	if(isMsg == 1){
	console.log(isMsg);
	sessionStorage.removeItem("isMsg");
	location.reload();
	}
	
	
})
function listPageMove(movingPage,mCategory,sCategory,total,sKind) {
	console.log(mCategory);
	var form = document.createElement('form');
	form.setAttribute('method','post');  
	form.setAttribute('action', 'CListPageM.ca');
	var hInput = document.createElement('input');
	var hInput2 = document.createElement('input');
	var hInput3 = document.createElement('input');
	var hInput4 = document.createElement('input');
	var hInput5 = document.createElement('input');
	hInput.setAttribute('type','hidden');
	hInput.setAttribute('name', 'nowPage');
	hInput.setAttribute('value', movingPage);
	hInput2.setAttribute('type','hidden');
	hInput2.setAttribute('name', 'mCategory');
	hInput2.setAttribute('value', mCategory);
	hInput3.setAttribute('type','hidden');
	hInput3.setAttribute('name', 'sCategory');
	hInput3.setAttribute('value', sCategory);
	hInput4.setAttribute('type','hidden');
	hInput4.setAttribute('name', 'total');
	hInput4.setAttribute('value', total);
	hInput5.setAttribute('type','hidden');
	hInput5.setAttribute('name', 'sKind');
	hInput5.setAttribute('value', sKind);
	form.appendChild(hInput);
	form.appendChild(hInput2);
	form.appendChild(hInput3);
	form.appendChild(hInput4);
	form.appendChild(hInput5);
	document.body.appendChild(form);
	form.submit();
	
}

function wishListAdd(pCode,pName) {
	if(confirm("["+pName + "] 상품을 위시리스트에 등록하시겠습니까?")){
		var form = document.createElement('form');
		form.setAttribute('method','post');  
		form.setAttribute('action', 'views/wishList/wishList.jsp');
		var hInput = document.createElement('input');
		hInput.setAttribute('type','hidden');
		hInput.setAttribute('name', 'pCode');
		hInput.setAttribute('value', pCode);
		form.appendChild(hInput);
		document.body.appendChild(form);
		form.submit();
	}
}
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<c:if test="${requestScope.categoryListEmpty == 0}">
<div id="categorySalePTitle">할인중인 <span style="font-size: 35px;">'${requestScope.categoryName}'</span> 상품</div>
<div id="categorySalePWrap">

<c:forEach items="${requestScope.categorySaleList}" var="list">
	<div id="categorySaleItems" class="categorySaleItems">
		<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCode}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/><br><span style="line-height: 20%"><br></span><c:out value="${list.price}원"/>
		</div>
	
</c:forEach>
</div>

<div id="categoryListPWrap">

<div id="categoryListPTitle"><span style="font-size: 35px;">'${requestScope.categoryName}'</span> 카테고리</div>
<div>
<select onchange="listPageMove(1,${requestScope.mCategory},${requestScope.sCategory},${requestScope.paging.total},this.value)" id="selectSKind">
  <option>카테고리 정렬 방식을 선택해주세요</option>
  <option value="1">평점 높은 순서</option>
  <option value="2">가격 높은 순서</option>
  <option value="3">가격 낮은 순서</option>
  <option value="4">신규 등록 순석</option>
</select>

</div>
<c:forEach items="${requestScope.categoryList}" var="list">
<div class="categoryList">
<div class="categoryListItem1"><img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="130px" height="130px" onclick="detailP('${list.pCode}')" style="cursor: pointer;"></div>
<div class="categoryListItem2"><br>
		<span style="font-size: 23px; font-weight: bold;"><a onclick="detailP('${list.pCode}')" style="cursor: pointer;"><c:out value="${list.pName}"/></a></span><br><br><c:out value="${list.price}원"/><br><br>
		<span style="font-size: 13px;"><c:out value="평점 : ${list.score_Avg} 점"/>  <c:out value="재고 : ${list.pStock}"/> </span>
		</div>
<div class="categoryListItem3">
<c:choose>
<c:when test="${list.wishList == 1}">
<img src="${pageContext.request.contextPath}/resources/icon/favHeart.png" style="margin: 10px"/>
</c:when>
<c:otherwise>
<img src="${pageContext.request.contextPath}/resources/icon/eHeart.jpg" style="margin: 10px; cursor: pointer;" onclick="wishListAdd('${list.pCode}','${list.pName}')"/>
</c:otherwise>
</c:choose>
</div>
<div class="categoryListItem4">
<div class="categoryListItem4child"><span style="font-size: 20px; font-weight: bold; line-height: 200%">
<c:out value="${list.store_Name}"/> </span><br>
<c:choose>
<c:when test="${list.store_Lev == 1}">새싹 등급</c:when>
<c:when test="${list.store_Lev == 2}">줄기 등급</c:when>
<c:otherwise>꽃 등급</c:otherwise>
</c:choose></div></div>


</div>

</c:forEach>

</div>

<br>
<div id="pageNumber">
<c:if test="${requestScope.paging.prePage == 1}">
<a href="#" onclick="listPageMove(${requestScope.paging.startPage - requestScope.paging.cntPage},${requestScope.mCategory},${requestScope.sCategory},${requestScope.paging.total},${requestScope.sKind})"><</a>
&nbsp;
<a href="#" onclick="listPageMove(1,${requestScope.mCategory},${requestScope.sCategory},${requestScope.paging.total},${requestScope.sKind})">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach varStatus="status" begin="${requestScope.paging.startPage}" end="${requestScope.paging.endPage}">

<c:choose>
<c:when test="${status.index eq requestScope.paging.nowPage}">
<c:out value="${status.index}"/>
</c:when>

<c:otherwise>
<a href="#" onclick="listPageMove(${status.index},${requestScope.mCategory},${requestScope.sCategory},${requestScope.paging.total},${requestScope.sKind})"><c:out value="${status.index}"/></a>
</c:otherwise>

</c:choose>
&nbsp;
</c:forEach>
<c:if test="${requestScope.paging.nextPage == 1}">
···&nbsp;
<a href="#" onclick="listPageMove(${requestScope.paging.lastPage},${requestScope.mCategory},${requestScope.sCategory},${requestScope.paging.total},${requestScope.sKind})"><c:out value="${requestScope.paging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="listPageMove(${requestScope.paging.startPage + requestScope.paging.cntPage},${requestScope.mCategory},${requestScope.sCategory},${requestScope.paging.total},${requestScope.sKind})">></a>
&nbsp;
</c:if>

</div>

<br>
<br>
</c:if>
<c:if test="${requestScope.categoryListEmpty == 1}">
<div id="wrongWord">
검색하신 카테고리 '<c:out value="${requestScope.categoryName}"/>' 에 <br>관련된 상품을 찾지 못했습니다.<br>
</div>

</c:if>
</main>
<br>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>

</html>
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
margin-top : 200px;
margin-bottom : 400px;
width: 1200px;
font-family: 맑은 명조;
font-size: 50px;
text-align: center;
}
#searchListPWrap{
margin-top: 100px;
}
#searchListPTitle{
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
.serachList{
display: flex;
border: solid 0.5px #48BAE4;
margin-bottom: 20px;
width: 1200px;
font-family: 맑은 명조;;
}
.serachListItem1{
width: 180px;
margin: 10px;

}
.serachListItem2{
width: 700px;
}
.serachListItem3{
width: 100px;
display: flex;
align-items: center;
}
.serachListItem4{
width: 200px;
border-left: solid 0.5px #48BAE4;
display: table;
}
.serachListItem4child{
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
function listPageMove(movingPage,sWord,total,sKind) {
	console.log(movingPage);
	console.log(sWord);
	console.log(total);
	var form = document.createElement('form');
	form.setAttribute('method','post');  
	form.setAttribute('action', 'SListPageM.se');
	var hInput = document.createElement('input');
	var hInput2 = document.createElement('input');
	var hInput3 = document.createElement('input');
	var hInput4 = document.createElement('input');
	hInput.setAttribute('type','hidden');
	hInput.setAttribute('name', 'nowPage');
	hInput.setAttribute('value', movingPage);
	hInput2.setAttribute('type','hidden');
	hInput2.setAttribute('name', 'sWord');
	hInput2.setAttribute('value', sWord);
	hInput3.setAttribute('type','hidden');
	hInput3.setAttribute('name', 'total');
	hInput3.setAttribute('value', total);
	hInput4.setAttribute('type','hidden');
	hInput4.setAttribute('name', 'sKind');
	hInput4.setAttribute('value', sKind);
	form.appendChild(hInput);
	form.appendChild(hInput2);
	form.appendChild(hInput3);
	form.appendChild(hInput4);
	document.body.appendChild(form);
	form.submit();
}

</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<c:if test="${requestScope.searchListEmpty == 0}">
<div id="searchSalePTitle">할인중인 <span style="font-size: 35px;">'<c:out value="${requestScope.sWord}"/>'</span> 상품</div>
<div id="searchSalePWrap">

<c:forEach items="${requestScope.searchSaleList}" var="list">
	<div id="searchSaleItems" class="searchSaleItems">
		<img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="190px" height="190px" onclick="detailP('${list.pCode}')" style="cursor: pointer;"><br>
		<c:out value="${list.pName}"/><br><span style="line-height: 20%"><br></span><c:out value="${list.price}원"/>
		</div>
	
</c:forEach>
</div>

<div id="searchListPWrap">

<div id="searchListPTitle"><span style="font-size: 35px;">'<c:out value="${requestScope.sWord}"/>'</span> 검색 결과</div>
<div>
<select onchange="listPageMove(1,'${requestScope.sWord}',${requestScope.paging.total},this.value)" id="selectSKind">
  <option>검색 결과 정렬 방식을 선택해주세요</option>
  <option value="1">평점 높은 순서</option>
  <option value="2">가격 높은 순서</option>
  <option value="3">가격 낮은 순서</option>
  <option value="4">신규 등록 순석</option>
</select>

</div>
<c:forEach items="${requestScope.searchList}" var="list">
<div class="serachList">
<div class="serachListItem1"><img alt="" src="${pageContext.request.contextPath}${list.pImage_Origin}" width="130px" height="130px" onclick="detailP('${list.pCode}')" style="cursor: pointer;"></div>
<div class="serachListItem2"><br>
		<span style="font-size: 23px; font-weight: bold;"><a onclick="detailP('${list.pCode}')" style="cursor: pointer;"><c:out value="${list.pName}"/></a></span><br><br><c:out value="${list.price}원"/><br><br>
		<span style="font-size: 13px;"><c:out value="평점 : ${list.score_Avg} 점"/>  <c:out value="재고 : ${list.pStock}"/> </span>
		</div>
<div class="serachListItem3"><img src="${pageContext.request.contextPath}/resources/icon/favHeart.png" style="margin: 10px"/></div>
<div class="serachListItem4">
<div class="serachListItem4child"><span style="font-size: 20px; font-weight: bold; line-height: 200%">
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
<a href="#" onclick="listPageMove(${requestScope.paging.startPage - requestScope.paging.cntPage},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})"><</a>
&nbsp;
<a href="#" onclick="listPageMove(1,'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach varStatus="status" begin="${requestScope.paging.startPage}" end="${requestScope.paging.endPage}">

<c:choose>
<c:when test="${status.index eq requestScope.paging.nowPage}">
<c:out value="${status.index}"/>
</c:when>

<c:otherwise>
<a href="#" onclick="listPageMove(${status.index},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})"><c:out value="${status.index}"/></a>
</c:otherwise>

</c:choose>
&nbsp;
</c:forEach>
<c:if test="${requestScope.paging.nextPage == 1}">
···&nbsp;
<a href="#" onclick="listPageMove(${requestScope.paging.lastPage},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})"><c:out value="${requestScope.paging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="listPageMove(${requestScope.paging.startPage + requestScope.paging.cntPage},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})">></a>
&nbsp;
</c:if>

</div>

<br>
<br>
</c:if>
<c:if test="${requestScope.searchListEmpty == 1}">
<div id="wrongWord">
검색하신 단어 '<c:out value="${requestScope.sWord}"/>' 에 <br>관련된 상품을 찾지 못했습니다.<br>
</div>

</c:if>
</main>
<br>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>

</html>
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
height: 1000px;
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
#memberControlWrap{
 text-align: center;
width: 1000px;
height: 1000px;
border-left: solid 1px;
}
#memberControlTitle{
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
}

.memberList{
position : absolute;
top : 420px;
left : 215px;
width: 970px;
}
.memberList table{

border: solid 1px #48BAE4;
}
.memberList th, td{
height : 80px;
border: solid 1px #48BAE4;
}
.memberList th{
font-size: 18px;
height : 50px;
}

</style>
<script type="text/javascript">
$(function() {
		
	
})

function movingAdminSearchPage(nowPage,sKind,sWord) {
	var form = document.createElement('form');
	form.setAttribute('method','post');  
	form.setAttribute('action', 'adminS_C_Search.ad');
	var hInput = document.createElement('input');
	var hInput2 = document.createElement('input');
	var hInput4 = document.createElement('input');
	hInput.setAttribute('type','hidden');
	hInput.setAttribute('name', 'nowPage');
	hInput.setAttribute('value', nowPage);
	hInput2.setAttribute('type','hidden');
	hInput2.setAttribute('name', 'sWord');
	hInput2.setAttribute('value', sWord);
	hInput4.setAttribute('type','hidden');
	hInput4.setAttribute('name', 'sKind');
	hInput4.setAttribute('value', sKind);
	form.appendChild(hInput);
	form.appendChild(hInput2);
	form.appendChild(hInput4);
	document.body.appendChild(form);
	form.submit();
}

function sellerConfirm(userNo,storeName) {
if(confirm("주의!!! \n수락하시면 "+storeName+" 상점의 판매 자격을 승인하게됩니다.")){
		
		if(confirm("정말 "+storeName+" 상점의 판매 자격을 승인하시겠습니까?")){
			
			var form = document.createElement('form');
			form.setAttribute('method','post');  
			form.setAttribute('action', 'adminPageCommand.ad');
			var hInput = document.createElement('input');
			var hInput3 = document.createElement('input');
			var hInput4 = document.createElement('input');
			hInput.setAttribute('type','hidden');
			hInput.setAttribute('name', 'userNo');
			hInput.setAttribute('value', userNo);
			hInput3.setAttribute('type','hidden');
			hInput3.setAttribute('name', 'memkind');
			hInput3.setAttribute('value', 0);
			hInput4.setAttribute('type','hidden');
			hInput4.setAttribute('name', 'pKind');
			hInput4.setAttribute('value', 2);
			form.appendChild(hInput);
			form.appendChild(hInput3);
			form.appendChild(hInput4);
			document.body.appendChild(form);
			form.submit();
		}
	}
}

</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<div id="adminWrap">
<div id="adminPage">
<div id="adminPageTitle">
<p style="margin-top: 20px; font-size: 35px">관리 페이지</p><hr>
<p style="margin-top: 150px"><a href="adminevent.ad">이벤트&할인율<br>관리</a></p>
<p style="margin-top: 150px"><a href="adminconfirm.ad">판매자 신청<br>승인---></a></p>
<p style="margin-top: 150px"><a href="adminpage.ad">회원 관리</a></p>

</div>
</div>

<div id="memberControlWrap">
<div id="memberControlTitle">판매자 신청 회원 관리</div>


<div id="memberControl">
<div id="sellerFMember" class="memberList">
<form action="adminS_C_Search.ad" method="post"><input type="radio" value="1" name="sKind" checked="checked">사업자번호 검색&nbsp;<input type="radio" value="2" name="sKind">상점이름 검색
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="sWordNomal" name="sWord" width="300px;"><button>검색</button>
<input type="hidden" value="1" name="nowPage"></form><br>
<table>
<thead>
<tr>
	<th style="width: 100px;">사업자번호</th>
	<th style="width: 100px;">상점이름</th>
	<th style="width: 300px;">상점 설명</th>
	<th style="width: 90px;">CEO</th>
	<th style="width: 250px;">상점이메일</th>
	<th style="width: 100px;">판매자승인</th>
</tr>
<tr>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.sellerFList}" var="list">
<tr>

<td><c:out value="${list.sellerNo}"></c:out></td>
<td><c:out value="${list.storeName}"></c:out></td>
<td><c:out value="${list.store_Exp}"></c:out></td>
<td><c:out value="${list.ceo}"></c:out></td>
<td><c:out value="${list.storeEmail}"></c:out></td>
<td><button onclick="sellerConfirm(${list.userNo},'${list.storeName}')">판매자 승인</button></td>
</tr>
</c:forEach>

</tbody>
<tfoot>
<tr>
<td colspan="7" style="height: 30px; font-size: 20px;">
<c:if test="${requestScope.sellerFListPaging.prePage == 1}">
<a href="#" onclick="movingAdminSearchPage(${requestScope.sellerFListPaging.startPage - requestScope.sellerFListPaging.cntPage},${requestScope.sKind},'${requestScope.sWord}')"><</a>
&nbsp;
<a href="#" onclick="movingAdminSearchPage(1,${requestScope.sKind},'${requestScope.sWord}')">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach begin="${requestScope.sellerFListPaging.startPage}" end="${requestScope.sellerFListPaging.endPage}" varStatus="status" >
<c:choose>
<c:when test="${status.index == requestScope.sellerFListPaging.nowPage}"><c:out value="${status.index}"></c:out></c:when>

<c:otherwise>

<a href="#" onclick="movingAdminSearchPage(${status.index},${requestScope.sKind},'${requestScope.sWord}')"><c:out value="${status.index}"></c:out></a>
</c:otherwise>

</c:choose>
&nbsp;

</c:forEach>
<c:if test="${requestScope.sellerFListPaging.nextPage == 1}">
···&nbsp;
<a href="#" onclick="movingAdminSearchPage(${requestScope.sellerFListPaging.lastPage},${requestScope.sKind},'${requestScope.sWord}')"><c:out value="${requestScope.sellerFListPaging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="movingAdminSearchPage(${requestScope.sellerFListPaging.startPage + requestScope.sellerFListPaging.cntPage},${requestScope.sKind},'${requestScope.sWord}')">></a>
&nbsp;
</c:if>
</td>
</tr>


</tfoot>
</table>
</div>

</div>
</div>
</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
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
border-top: none;
}
#hiddenBtn{
border-top-color : white;
border-right : none;
width: 683px;
height : 50px;
margin-bottom: -2px;
border-bottom: solid 1px;
background-color: white;
font-family: 맑은 명조;

}
.mcBtn{
width: 150px;
height : 50px;
margin-bottom: -2px;
border-bottom: solid 1px;
background-color: white;
font-family: 맑은 명조;
font-weight: bold;
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
height : 40px;
border: solid 1px #48BAE4;
}
.memberList th{
font-size: 18px;
height : 50px;
}

</style>
<script type="text/javascript">
$(function() {
	var defaultMemInfo = "<c:out value='${requestScope.memkind}'/>";
	if(defaultMemInfo == 1){
		$('#nomalMemberBtn').css({"border-bottom": "none"});
		$('#sellerMemberBtn').css({"border-bottom": "solid 1px"});
		$('#nomalMember').css({"visibility": "visible", "opacity": "1"});
		$('#sellerMember').css({"visibility": "hidden", "opacity": "0"});
	}else{
		$('#sellerMemberBtn').css({"border-bottom": "none"});
		$('#nomalMemberBtn').css({"border-bottom": "solid 1px"});
		$('#sellerMember').css({"visibility": "visible", "opacity": "1"});
		$('#nomalMember').css({"visibility": "hidden", "opacity": "0"});
		
	}

	$('#nomalMemberBtn').click(function() {		
		console.log("afasf")
		$('#nomalMemberBtn').css({"border-bottom": "none"});
		$('#sellerMemberBtn').css({"border-bottom": "solid 1px"});
		$('#nomalMember').css({"visibility": "visible", "opacity": "1"});
		$('#sellerMember').css({"visibility": "hidden", "opacity": "0"});
	})
	
	$('#sellerMemberBtn').click(function() {		
		console.log("afasf")
		$('#sellerMemberBtn').css({"border-bottom": "none"});
		$('#nomalMemberBtn').css({"border-bottom": "solid 1px"});
		$('#sellerMember').css({"visibility": "visible", "opacity": "1"});
		$('#nomalMember').css({"visibility": "hidden", "opacity": "0"});
	})
	
	
})

function movingAdminSearchPage(nowPage,memkind,sKind,sWord) {
	var form = document.createElement('form');
	form.setAttribute('method','post');  
	form.setAttribute('action', 'adminsearch.ad');
	var hInput = document.createElement('input');
	var hInput2 = document.createElement('input');
	var hInput3 = document.createElement('input');
	var hInput4 = document.createElement('input');
	hInput.setAttribute('type','hidden');
	hInput.setAttribute('name', 'nowPage');
	hInput.setAttribute('value', nowPage);
	hInput2.setAttribute('type','hidden');
	hInput2.setAttribute('name', 'sWord');
	hInput2.setAttribute('value', sWord);
	hInput3.setAttribute('type','hidden');
	hInput3.setAttribute('name', 'memkind');
	hInput3.setAttribute('value', memkind);
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

function sellerMemberDel(storeNo,userNo,storeName) {
	if(confirm("주의!!! "+storeName+" 상점의 판매 자격을 중지하려고 하고있습니다. \n확인해주세요.")){
		
		if(confirm("정말 "+storeName+" 상점의 판매 자격을 중지하시겠습니까?")){
			
			var form = document.createElement('form');
			form.setAttribute('method','post');  
			form.setAttribute('action', 'adminPageCommand.ad');
			var hInput = document.createElement('input');
			var hInput2 = document.createElement('input');
			var hInput3 = document.createElement('input');
			var hInput4 = document.createElement('input');
			hInput.setAttribute('type','hidden');
			hInput.setAttribute('name', 'userNo');
			hInput.setAttribute('value', userNo);
			hInput2.setAttribute('type','hidden');
			hInput2.setAttribute('name', 'storeNo');
			hInput2.setAttribute('value', storeNo);
			hInput3.setAttribute('type','hidden');
			hInput3.setAttribute('name', 'memkind');
			hInput3.setAttribute('value', 2);
			hInput4.setAttribute('type','hidden');
			hInput4.setAttribute('name', 'pKind');
			hInput4.setAttribute('value', 3);
			form.appendChild(hInput);
			form.appendChild(hInput2);
			form.appendChild(hInput3);
			form.appendChild(hInput4);
			document.body.appendChild(form);
			form.submit();
		}
	}
}

function memberDel(userNo,category,userName) {
	if(confirm("주의!!! "+userName+" 회원님의 회원 자격을 중지하려고 하고있습니다. \n확인해주세요.")){
		
		if(confirm("정말 "+userName+" 회원님의 회원 자격을 중지하시겠습니까? \n판매회원일 경우 판매 자격도 같이 중지됩니다.")){
			var form = document.createElement('form');
			form.setAttribute('method','post');  
			form.setAttribute('action', 'adminPageCommand.ad');
			var hInput = document.createElement('input');
			var hInput2 = document.createElement('input');
			var hInput3 = document.createElement('input');
			var hInput4 = document.createElement('input');
			hInput.setAttribute('type','hidden');
			hInput.setAttribute('name', 'userNo');
			hInput.setAttribute('value', userNo);
			hInput2.setAttribute('type','hidden');
			hInput2.setAttribute('name', 'category');
			hInput2.setAttribute('value', category);
			hInput3.setAttribute('type','hidden');
			hInput3.setAttribute('name', 'memkind');
			hInput3.setAttribute('value', 1);
			hInput4.setAttribute('type','hidden');
			hInput4.setAttribute('name', 'pKind');
			hInput4.setAttribute('value', 3);
			form.appendChild(hInput);
			form.appendChild(hInput2);
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
<p style="margin-top: 150px"><a href="adminconfirm.ad">판매자 신청<br>승인</a></p>
<p style="margin-top: 150px"><a href="adminpage.ad">회원 관리---></a></p>

</div>
</div>
<div id="memberControlWrap">
<div id="memberControlTitle">회원 관리</div>
<button class="mcBtn" id="nomalMemberBtn">일반회원 관리</button><button class="mcBtn" id="sellerMemberBtn">판매회원 관리</button><button id="hiddenBtn" >.</button>

<div id="memberControl">
<div id="nomalMember" class="memberList">
<form action="adminsearch.ad" method="post"><input type="radio" value="1" name="sKind" checked="checked">ID 검색&nbsp;<input type="radio" value="2" name="sKind">이름 검색
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="sWordNomal" name="sWord" width="300px;"><button>검색</button>
<input type="hidden" value="1" name="nowPage"> <input type="hidden" value="1" name="memkind"></form><br>
<table>
<thead>
<tr>
	<th style="width: 90px;">회원등급</th>
	<th style="width: 100px;">회원아이디</th>
	<th style="width: 100px;">회원이름</th>
	<th style="width: 300px;">회원이메일</th>
	<th style="width: 100px;">본인인증</th>
	<th style="width: 100px;">비고</th>
	<th style="width: 150px;">회원자격정지</th>
</tr>
<tr>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.memberList}" var="list">
<tr>
<td><c:out value="${list.lev}"></c:out></td>
<td><c:out value="${list.userId}"></c:out></td>
<td><c:out value="${list.userName}"></c:out></td>
<td><c:out value="${list.email}"></c:out></td>
<td><c:out value="${list.userCel}"></c:out></td>
<td>
<c:if test="${list.category == 2}">
판매회원</c:if>
</td>
<td><button onclick="memberDel(${list.userNo},${list.category},'${list.userName}')">자격 정지</button></td>
</tr>
</c:forEach>

</tbody>
<tfoot>
<tr>
<td colspan="7" style="height: 30px; font-size: 20px;">
<c:if test="${requestScope.memberListPaging.prePage == 1}">
<a href="#" onclick="movingAdminSearchPage(${requestScope.memberListPaging.startPage - requestScope.memberListPaging.cntPage},1,${requestScope.sKind},'${requestScope.sWord}')"><</a>
&nbsp;
<a href="#" onclick="movingAdminSearchPage(1,1,${requestScope.sKind},'${requestScope.sWord}')">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach begin="${requestScope.memberListPaging.startPage}" end="${requestScope.memberListPaging.endPage}" varStatus="status" >
<c:choose>
<c:when test="${status.index == requestScope.memberListPaging.nowPage}"><c:out value="${status.index}"></c:out></c:when>

<c:otherwise>

<a href="#" onclick="movingAdminSearchPage(${status.index},1,${requestScope.sKind},'${requestScope.sWord}')"><c:out value="${status.index}"></c:out></a>
</c:otherwise>

</c:choose>
&nbsp;

</c:forEach>
<c:if test="${requestScope.memberListPaging.nextPage == 1}">
···&nbsp;
<a href="#" onclick="movingAdminSearchPage(${requestScope.memberListPaging.lastPage},1,${requestScope.sKind},'${requestScope.sWord}')"><c:out value="${requestScope.memberListPaging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="movingAdminSearchPage(${requestScope.memberListPaging.startPage + requestScope.memberListPaging.cntPage},1,${requestScope.sKind},'${requestScope.sWord}')">></a>
&nbsp;
</c:if>
</td>
</tr>


</tfoot>
</table>
<br>
</div>

<div id="sellerMember" class="memberList">
<form action="adminsearch.ad" method="post"><input type="radio" value="1" name="sKind" checked="checked">사업자번호 검색&nbsp;<input type="radio" value="2" name="sKind">상점이름 검색
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="sWordNomal" name="sWord" width="300px;"><button>검색</button>
<input type="hidden" value="1" name="nowPage"> <input type="hidden" value="2" name="memkind"></form><br>
<table>
<thead>
<tr>
	<th style="width: 90px;">상점등급</th>
	<th style="width: 100px;">사업자번호</th>
	<th style="width: 100px;">상점이름</th>
	<th style="width: 100px;">CEO</th>
	<th style="width: 300px;">상점이메일</th>
	<th style="width: 100px;">총판매금액</th>
	<th style="width: 150px;">판매자격정지</th>
</tr>
<tr>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.sellerList}" var="list">
<tr>

<td><c:out value="${list.storeLev}"></c:out></td>
<td><c:out value="${list.sellerNo}"></c:out></td>
<td><c:out value="${list.storeName}"></c:out></td>
<td><c:out value="${list.ceo}"></c:out></td>
<td><c:out value="${list.storeEmail}"></c:out></td>
<td><c:out value="${list.totalSales}"></c:out></td>
<td><button onclick="sellerMemberDel(${list.storeNo},${list.userNo},'${list.storeName}')">자격 정지</button></td>
</tr>
</c:forEach>

</tbody>
<tfoot>
<tr>
<td colspan="7" style="height: 30px; font-size: 20px;">
<c:if test="${requestScope.sellerListPaging.prePage == 1}">
<a href="#" onclick="movingAdminSearchPage(${requestScope.sellerListPaging.startPage - requestScope.sellerListPaging.cntPage},2,${requestScope.sKind},'${requestScope.sWord}')"><</a>
&nbsp;
<a href="#" onclick="movingAdminSearchPage(1,2,${requestScope.sKind},'${requestScope.sWord}')">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach begin="${requestScope.sellerListPaging.startPage}" end="${requestScope.sellerListPaging.endPage}" varStatus="status" >
<c:choose>
<c:when test="${status.index == requestScope.sellerListPaging.nowPage}"><c:out value="${status.index}"></c:out></c:when>

<c:otherwise>

<a href="#" onclick="movingAdminSearchPage(${status.index},2,${requestScope.sKind},'${requestScope.sWord}')"><c:out value="${status.index}"></c:out></a>
</c:otherwise>

</c:choose>
&nbsp;

</c:forEach>
<c:if test="${requestScope.sellerListPaging.nextPage == 1}">
···&nbsp;
<a href="#" onclick="movingAdminSearchPage(${requestScope.sellerListPaging.lastPage},2,${requestScope.sKind},'${requestScope.sWord}')"><c:out value="${requestScope.sellerListPaging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="movingAdminSearchPage(${requestScope.sellerListPaging.startPage + requestScope.sellerListPaging.cntPage},2,${requestScope.sKind},'${requestScope.sWord}')">></a>
&nbsp;
</c:if>
</td>
</tr>


</tfoot>
</table>
<br>
</div>
</div>
</div>
</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
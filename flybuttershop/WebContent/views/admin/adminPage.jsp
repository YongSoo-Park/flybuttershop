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
#nomalMemberBtn{
	border-bottom: none;
}
#sellerMember{
	visibility: hidden;
	opacity: 0;
}
</style>
<script type="text/javascript">
$(function() {

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



</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<div id="adminWrap">
<div id="adminPage">
aasfasf
</div>
<div id="memberControlWrap">
<div id="memberControlTitle">회원 관리</div>
<button class="mcBtn" id="nomalMemberBtn">일반회원 관리</button><button class="mcBtn" id="sellerMemberBtn">판매회원 관리</button><button id="hiddenBtn" >.</button>

<div id="memberControl">
<div id="nomalMember" class="memberList">
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
<td><button onclick="memberDel(${list.userNo},${list.category})">자격 정지</button></td>
</tr>
</c:forEach>

</tbody>
<tfoot>
<tr>
<td colspan="7" style="height: 30px; font-size: 20px;">
<c:if test="${requestScope.memberListPaging.prePage == 1}">
<a href="#" onclick=""><</a>
&nbsp;
<a href="#" onclick="">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach begin="${requestScope.memberListPaging.startPage}" end="${requestScope.memberListPaging.endPage}" varStatus="status" >
<c:choose>
<c:when test="${status.index == requestScope.memberListPaging.nowPage}"><c:out value="${status.index}"></c:out></c:when>

<c:otherwise>

<a href="#"><c:out value="${status.index}"></c:out></a>
</c:otherwise>

</c:choose>


</c:forEach>
<c:if test="${requestScope.memberListPaging.nextPage == 1}">
···&nbsp;
<a href="#" onclick=""><c:out value="${requestScope.memberListPaging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="">></a>
&nbsp;
</c:if>
</td>
</tr>


</tfoot>
</table>
xxx님에 회원자격이 정지되었습니다.<br>
</div>

<div id="sellerMember" class="memberList">
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
<td><button onclick="sellerMemberDel(${list.storeNo},${list.userNo})">자격 정지</button></td>
</tr>
</c:forEach>

</tbody>
<tfoot>
<tr>
<td colspan="7" style="height: 30px; font-size: 20px;">
<c:if test="${requestScope.sellerListPaging.prePage == 1}">
<a href="#" onclick=""><</a>
&nbsp;
<a href="#" onclick="">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach begin="${requestScope.sellerListPaging.startPage}" end="${requestScope.sellerListPaging.endPage}" varStatus="status" >
<c:choose>
<c:when test="${status.index == requestScope.sellerListPaging.nowPage}"><c:out value="${status.index}"></c:out></c:when>

<c:otherwise>

<a href="#"><c:out value="${status.index}"></c:out></a>
</c:otherwise>

</c:choose>
&nbsp;

</c:forEach>
<c:if test="${requestScope.sellerListPaging.nextPage == 1}">
···&nbsp;
<a href="#" onclick=""><c:out value="${requestScope.sellerListPaging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="">></a>
&nbsp;
</c:if>
</td>
</tr>


</tfoot>
</table>
판매스토어 xxx에 판매자격이 정지되었습니다.<br>
</div>
</div>
</div>
</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
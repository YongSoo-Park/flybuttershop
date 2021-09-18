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
body{
position : relative;
width: 1200px;
height: 160px;
background-color: white;
}
#header{
display: flex;
width: 1200px;
height: 150px;
background-color: white;
}
#header > div{
	margin-left : 25px;
	display: flex;
    align-items: center;

}
#searchForm {
	display: flex;
    align-items: center;
}
#userSearch{
border: solid 1px;
border-right : none;
height: 41px;
width: 450px;
}
#imgLogo{
margin-left: 15px;
margin-right: 20px;
}
.header2DivItem45{
margin-left: 7.5px;
margin-right: 7.5px;
cursor: pointer;
}
.header2DivItem35{
margin-left: 5px;
margin-right: 5px;

cursor: pointer;
}

#mainCategoryDiv{
width: 200px;
height: 350px;
position: absolute;
top: 180px;
left: -40px;
opacity: 0;
  visibility: hidden;
background-color: white;
display: flex;
z-index: 5;
}

#recentlyViewedItems{
position: fixed;
top: 180px;
left: 50%;
transform:translateX(650px);


}

.RVItemsView{
position : absolute;
top : 0px;
left : 0px;
width: 180px;

border : solid 1px #48BAE4;

font-size: 12px;
display: inline-block;
text-align: center;
}
#RVItemsView2{
visibility: hidden;
opacity : 0;
}
#mainCategory{
margin-top: 0;
width: 160px;
}
#mainCategory > li{
 margin: 0; list-style: none;
}
#mainCategory > li > a{
  font-family: 맑은 고딕;
  font-weight : bold;
  color: black;
  background-color : white;
  text-align: center;
  text-decoration: none;
  letter-spacing: 0.15em;
  display: block;
  padding: 10px;
  border: solid black 2px;
  z-index: 5;
}
#categoryBack{
  position: absolute;
  background-color: #48BAE4;
  width : 440px;
  height : 350px;
  top : 0px;
  left: 200px;
}
.subCategoty {
  position: absolute;
  background-color: #48BAE4;
  opacity: 0;
  visibility: hidden;
  transition: all 0.15s ease-in;
  width : 440px;
  height : 350px;
  top : 0px;
  left: 200px;
  z-index: 5;
  font-family : 맑은 명조;
  font-size: 25px;

}

#mainCategory > li:hover > a{
  background-color : #48BAE4;
  color: black;
}
#mainCategory > li:hover .subCategoty {
  opacity: 1;
  visibility: visible;
}
.subCategotyItems{

 display: flex;
 align-items: center;
 height: 350px; 
 padding-left: 30px;
}
.subCategotyItems a{
  text-decoration: none;
  color: black;
}
</style>


<script>
function movingPage(url) {
	var form = document.createElement('form');
	form.setAttribute('method','post');
	form.setAttribute('action', url);
	document.body.appendChild(form);
	form.submit();
	
}
function detailP(pCode) {
	var form = document.createElement('form');
	var hInput = document.createElement('input');
	form.setAttribute('method','post');  
	form.setAttribute('action', 'detail.pr');
	hInput.setAttribute('type','hidden');
	hInput.setAttribute('name', 'pCode');
	hInput.setAttribute('value', pCode);
	form.appendChild(hInput);
	document.body.appendChild(form);
	form.submit();
	
}


</script>
<script type="text/javascript">
$(function() {
	
	$('#mainCategoryOpen').click(function() {
		var mainCategoryToggle = $('#mainCategoryDiv').css('visibility');
		
		if(mainCategoryToggle=='hidden'){
			$('#mainCategoryDiv').css('visibility','visible');
			$('#mainCategoryDiv').css('opacity','1');
		}else{
			$('#mainCategoryDiv').css('visibility','hidden');
			$('#mainCategoryDiv').css('opacity','0');
		}
		
	})
	
	$('.rivViewBtn').click(function() {
		

		let rviView1 = $('#RVItemsView1').css('visibility');
		if(rviView1 == 'hidden'){
			$('#RVItemsView1').css('visibility','visible');
			$('#RVItemsView1').css('opacity','1');
			$('#RVItemsView2').css('visibility','hidden');
			$('#RVItemsView2').css('opacity','0');
			console.log("222");
		}else{
			$('#RVItemsView1').css('visibility','hidden');
			$('#RVItemsView1').css('opacity','0');
			$('#RVItemsView2').css('visibility','visible');
			$('#RVItemsView2').css('opacity','1');
		}
	})
	
	$('#searBtn').click(function() {
		if($('#userSearch').val().length == -1 ){
			alert("검색할 단어를 입력해주세요");
		}else{
			$('#searchForm').submit();
		}
	
	
	})
	
	
	
	
})

function categoryChoce(mCategory, sCategory) {
	var form = document.createElement('form');
	form.setAttribute('method','post');  
	form.setAttribute('action', 'categoryList.ca');
	var hInput = document.createElement('input');
	var hInput2 = document.createElement('input');
	hInput.setAttribute('type','hidden');
	hInput.setAttribute('name', 'mCategory');
	hInput.setAttribute('value', mCategory);
	hInput2.setAttribute('type','hidden');
	hInput2.setAttribute('name', 'sCategory');
	hInput2.setAttribute('value', sCategory);
	form.appendChild(hInput);
	form.appendChild(hInput2);
	document.body.appendChild(form);
	form.submit();
}
</script>
</head>
<body>
<c:if test="${!empty sessionScope.loginMember.MEM_USER_NO}">
<div style="float: right;"><a href="logout.ma" style="margin-right: 30px"><b>로그아웃</b></a></div>
</c:if>
<header id="header">

<div id="header1Div"><img src="${pageContext.request.contextPath}/resources/icon/categoryPopIcon.png"  id="mainCategoryOpen" style="cursor: pointer;"/>
<img src="${pageContext.request.contextPath}/resources/icon/flybutterLogo.png" alt="로고 이미지" id="imgLogo" onclick="movingPage('mainpage.ma')" style="cursor: pointer;"/>


<form action="search.ma" id="searchForm" method="post"><input type="text" id="userSearch" name="sWord"/><img src="${pageContext.request.contextPath}/resources/icon/search1.png" alt="이미지파일" id="searBtn" style="cursor: pointer;"/></form></div>

<div id="header2Div">
<c:choose>
<c:when test="${0==sessionScope.loginMember.MEM_CATEGORY}">
<img src="${pageContext.request.contextPath}/resources/icon/cart35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('basket.do')"/>
<img src="${pageContext.request.contextPath}/resources/icon/mypageicon35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('main.mp')"/>
<img src="${pageContext.request.contextPath}/resources/icon/cs35.png" alt="이미지파일" class="header2DivItem35"  onclick="movingPage('entireList.no')"/>
<img src="${pageContext.request.contextPath}/resources/icon/admin35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('adminevent.ad')"/>
</c:when>
<c:when test="${2==sessionScope.loginMember.MEM_CATEGORY}">
<img src="${pageContext.request.contextPath}/resources/icon/cart35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('basket.do')"/>
<img src="${pageContext.request.contextPath}/resources/icon/mypageicon35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('main.mp')"/>
<img src="${pageContext.request.contextPath}/resources/icon/cs35.png" alt="이미지파일" class="header2DivItem35"  onclick="movingPage('entireList.no')"/>
<img src="${pageContext.request.contextPath}/resources/icon/seller35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('sellerMyPage.sl')"/>
</c:when>
<c:otherwise>
<img src="${pageContext.request.contextPath}/resources/icon/cart45.png" alt="이미지파일" class="header2DivItem45" onclick="movingPage('basket.do')"/>
<img src="${pageContext.request.contextPath}/resources/icon/mypageicon45.png" alt="이미지파일" class="header2DivItem45" onclick="movingPage('main.mp')"/>
<img src="${pageContext.request.contextPath}/resources/icon/cs45.png" alt="이미지파일" class="header2DivItem45"  onclick="movingPage('entireList.no')"/>
</c:otherwise>
</c:choose>
</div>
<div>
<c:choose>
<c:when test="${!empty sessionScope.loginMember.MEM_USER_NO}">
<c:choose>
<c:when test="${2==sessionScope.loginMember.MEM_CATEGORY}">
<img src="${pageContext.request.contextPath}/resources/icon/sellericon25.png" style="margin-right: 10px"/>
</c:when>
<c:otherwise>
<img src="${pageContext.request.contextPath}/resources/icon/grade${sessionScope.loginMember.MEM_LEV}.png" style="margin-right: 10px"/>
</c:otherwise>
</c:choose>
<c:out value="${sessionScope.loginMember.MEM_USER_NAME}님"/>
<br>
<c:out value="${sessionScope.loginMember.MONEY}pt"/>
</c:when>
<c:otherwise>
<span style="line-height:180%;">
<a href="login.me"><b>로그인</b></a><br>
<a href="insert.me"><b>회원가입</b></a>
</span>
</c:otherwise>
</c:choose>

</div>
</header>
<hr>
<div id="mainCategoryDiv">
<div id="categoryBack">
</div>
<ul id="mainCategory" >
<li><a href="#" onclick="categoryChoce(1,0)">의류</a>

	<div class="subCategoty">
	<div class="subCategotyItems">
<p>
	<a href="#" onclick="categoryChoce(1,1)">여성상의</a><br><br>
	<a href="#" onclick="categoryChoce(1,2)">원피스</a><br><br>
	<a href="#" onclick="categoryChoce(1,3)">여성하의</a><br><br>
	<a href="#" onclick="categoryChoce(1,4)">남성상의</a><br><br>
	<a href="#" onclick="categoryChoce(1,5)">남성하의</a>
	</p></div>
	</div>
</li>
<li><a href="#" onclick="categoryChoce(2,0)">잡화</a>
<div class="subCategoty">
<div class="subCategotyItems">
<p>
	<a href="#" onclick="categoryChoce(2,1)">모자</a><br><br>
	<a href="#" onclick="categoryChoce(2,2)">가방</a><br><br>
	<a href="#" onclick="categoryChoce(2,3)">시계</a><br><br>
	<a href="#" onclick="categoryChoce(2,4)">신발</a><br><br>
	<a href="#" onclick="categoryChoce(2,5)">벨트</a></p></div>
	</div>
</li>
<li><a href="#" onclick="categoryChoce(3,0)">뷰티</a>
<div class="subCategoty">
<div class="subCategotyItems">
<p>
	<a href="#" onclick="categoryChoce(3,1)">기초</a><br><br>
	<a href="#" onclick="categoryChoce(3,2)">베이스메이크업</a><br><br>
	<a href="#" onclick="categoryChoce(3,3)">아이메이크업</a><br><br>
	<a href="#" onclick="categoryChoce(3,4)">립메이크업</a><br><br>
	<a href="#" onclick="categoryChoce(3,5)">바디</a></p></div>
	</div>
</li>
<li><a href="#" onclick="categoryChoce(4,0)">식품</a>
<div class="subCategoty">
<div class="subCategotyItems">
<p>
	<a href="#" onclick="categoryChoce(4,1)">차/음료</a><br><br>
	<a href="#" onclick="categoryChoce(4,2)">커피</a><br><br>
	<a href="#" onclick="categoryChoce(4,3)">스낵</a><br><br>
	<a href="#" onclick="categoryChoce(4,4)">운동보조식품</a><br><br>
	<a href="#" onclick="categoryChoce(4,5)">영양제</a></p></div>
	</div>
</li>
<li><a href="#" onclick="categoryChoce(5,0)">가구</a>
<div class="subCategoty">
<div class="subCategotyItems">
<p>
	<a href="#" onclick="categoryChoce(5,1)">가구커버</a><br><br>
	<a href="#" onclick="categoryChoce(5,2)">걸이용품</a><br><br>
	<a href="#" onclick="categoryChoce(5,3)">악세서리</a></p>
	</div></div>
</li>
<li><a href="#" onclick="categoryChoce(6,0)">전자기기</a>
<div class="subCategoty">
<div class="subCategotyItems">	
<p> <a href="#" onclick="categoryChoce(6,1)">주방기기</a><br><br>
	<a href="#" onclick="categoryChoce(6,2)">활가전</a><br><br>
	<a href="#" onclick="categoryChoce(6,3)">음향기기</a><br><br>
	<a href="#" onclick="categoryChoce(6,4)">컴퓨터 주변기기</a><br><br>
	<a href="#" onclick="categoryChoce(6,5)">웨어러블기기</a></p>
	</div></div>
</li>
<li><a href="#" onclick="categoryChoce(7,0)">생필품</a>
<div class="subCategoty">
<div class="subCategotyItems">
	<p>	
	<a href="#" onclick="categoryChoce(7,1)">세탁세제</a><br><br>
	<a href="#" onclick="categoryChoce(7,2)">주방세제</a><br><br>
	<a href="#" onclick="categoryChoce(7,3)">욕실용품</a><br><br>
	<a href="#" onclick="categoryChoce(7,4)">구강/위생용품</a><br><br>
	<a href="#" onclick="categoryChoce(7,5)">건강용품</a></p>
	</div></div>
</li>
<li><a href="#" onclick="categoryChoce(8,0)">반려동물</a>
<div class="subCategoty">
<div class="subCategotyItems">
	<p>
	<a href="#" onclick="categoryChoce(8,1)">사료</a><br><br>
	<a href="#" onclick="categoryChoce(8,2)">장난감</a><br><br>
	<a href="#" onclick="categoryChoce(8,3)">영양간식</a><br><br>
	<a href="#" onclick="categoryChoce(8,4)">산책용품</a><br><br>
	<a href="#" onclick="categoryChoce(8,5)">미용용품</a></p>
	</div>
	</div>
</li>

</ul>

<div style="position: absolute; left: 640px;">
<img src="${pageContext.request.contextPath}/resources/event/event1.png" style="cursor: pointer; width: 600px; height: 350px;"/>

</div>
</div>

<div id="recentlyViewedItems">
 <c:if test="${!empty sessionScope.RVItemsList}">
 <div class="RVItemsView" id="RVItemsView1">
 <b style="font-size: 20px"><br>최근 본 상품<br><br></b><hr>
 <c:forEach items="${sessionScope.RVItemsList}" var="list" end="4">
 <c:forEach items="${list.key}" var="item">
 <img src="${pageContext.request.contextPath}${sessionScope.RVItemsList[item].pImage_Origin}" width="60px" height="60px" onclick="detailP('${list.key}')" style="cursor: pointer;"><br>
 ${sessionScope.RVItemsList[item].pName}${list.key}<hr><br>
</c:forEach>
</c:forEach>
<c:if test="${sessionScope.RVItemsList.size() > 5}">
<button id="rviNext" class="rivViewBtn">NEXT ></button><br><br>
</c:if>
</div>
 <div class="RVItemsView" id="RVItemsView2">
 <b style="font-size: 20px"><br>최근 본 상품<br><br></b><hr>
 <c:forEach items="${sessionScope.RVItemsList}" var="list" begin="5">
 <c:forEach items="${list.key}" var="item">
 <img src="${pageContext.request.contextPath}${sessionScope.RVItemsList[item].pImage_Origin}" width="60px" height="60px" onclick="detailP('${list.key}')" style="cursor: pointer;"><br>
 ${sessionScope.RVItemsList[item].pName}${list.key}<hr><br>
</c:forEach>
</c:forEach>
<button id="rviPrev" class="rivViewBtn">< PREV</button><br><br>
</div>
 
 </c:if>
</div>
</body>
</html>
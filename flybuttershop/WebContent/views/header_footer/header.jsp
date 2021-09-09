<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String userName = String.valueOf(request.getSession().getAttribute("MEM_USER_NAME")); %>
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
display: block;
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

border : solid 1px blue;

font-size: 13px;
display: inline-block;
text-align: center;
}
#RVItemsView2{
visibility: hidden;
opacity : 0;
}
#mainCategory{
margin-top: 0;
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

.subCategoty {
  position: absolute;
  background-color: oldlace;
  opacity: 0;
  visibility: hidden;
  transition: all 0.15s ease-in;
  width : 1040px;
  height : 350px;
  top : 0px;
  left: 200px;
  z-index: 5;
}

#mainCategory > li:hover > a{
  background-color : oldlace;
  color: black;
}
#mainCategory > li:hover .subCategoty {
  opacity: 1;
  visibility: visible;
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
	form.setAttribute('action', '/detail.pr');
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
	
	
	
})
</script>
</head>
<body>
<c:if test="${!empty sessionScope.loginMember.MEM_USER_NO}">
<div style="float: right;"><a href="logout.ma" style="margin-right: 30px"><b>로그아웃</b></a></div>
</c:if>
<header id="header">

<div id="header1Div"><img src="${pageContext.request.contextPath}/resources/icon/categoryPopIcon.png"  id="mainCategoryOpen" style="cursor: pointer;"/>
<img src="${pageContext.request.contextPath}/resources/icon/flybutterLogo.png" alt="로고 이미지" id="imgLogo" onclick="movingPage('main.ma')" style="cursor: pointer;"/>


<form action="search.ma" id="searchForm"><input type="text" id="userSearch" name="userSearch"/><img src="${pageContext.request.contextPath}/resources/icon/search1.png" alt="이미지파일"/></form></div>

<div id="header2Div">
<c:choose>
<c:when test="${0==sessionScope.loginMember.MEM_CATEGORY}">
<img src="${pageContext.request.contextPath}/resources/icon/cart35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('basket.do')"/>
<img src="${pageContext.request.contextPath}/resources/icon/mypageicon35.png" alt="이미지파일" class="header2DivItem35" onclick="movingPage('main.mp')"/>
<img src="${pageContext.request.contextPath}/resources/icon/cs35.png" alt="이미지파일" class="header2DivItem35"  onclick="movingPage('entireList.no')"/>
<img src="${pageContext.request.contextPath}/resources/icon/admin35.png" alt="이미지파일" class="header2DivItem35" />
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
<ul id="mainCategory" >
<li><a href="#">의류</a>

	<div class="subCategoty">
	의류 서브카테고리<br>
	의류 서브카테고리<br>
	의류 서브카테고리<br>
	의류 서브카테고리<br>
	의류 서브카테고리
	</div>
</li>
<li><a href="#">잡화</a>
<div class="subCategoty">
	잡화 서브카테고리<br>
	잡화 서브카테고리<br>
	잡화 서브카테고리<br>
	잡화 서브카테고리<br>
	잡화 서브카테고리
	</div>
</li>
<li><a href="#">뷰티</a>
<div class="subCategoty">
	뷰티 서브카테고리<br>
	뷰티 서브카테고리<br>
	뷰티 서브카테고리<br>
	뷰티 서브카테고리<br>
	뷰티 서브카테고리
	</div>
</li>
<li><a href="#">식품</a>
<div class="subCategoty">
	식품 서브카테고리<br>
	식품 서브카테고리<br>
	식품 서브카테고리<br>
	식품 서브카테고리<br>
	식품 서브카테고리
	</div>
</li>
<li><a href="#">가구</a>
<div class="subCategoty">
	가구 서브카테고리<br>
	가구 서브카테고리<br>
	가구 서브카테고리<br>
	가구 서브카테고리<br>
	가구 서브카테고리
	</div>
</li>
<li><a href="#">전자기기</a>
<div class="subCategoty">
	전자기기 서브카테고리<br>
	전자기기 서브카테고리<br>
	전자기기 서브카테고리<br>
	전자기기 서브카테고리<br>
	전자기기 서브카테고리
	</div>
</li>
<li><a href="#">생필품</a>
<div class="subCategoty">
	생필품 서브카테고리<br>
	생필품 서브카테고리<br>
	생필품 서브카테고리<br>
	생필품 서브카테고리<br>
	생필품 서브카테고리
	</div>
</li>
<li><a href="#">반려동물</a>
<div class="subCategoty">
	반려동물 서브카테고리<br>
	반려동물 서브카테고리<br>
	반려동물 서브카테고리<br>
	반려동물 서브카테고리<br>
	반려동물 서브카테고리
	</div>
</li>
</ul>
</div>

<div id="recentlyViewedItems">
 <c:if test="${!empty sessionScope.RVItemsList}">
 <div class="RVItemsView" id="RVItemsView1">
 <b style="font-size: 25px"><br>최근 본 상품<br><br></b><hr>
 <c:forEach items="${sessionScope.RVItemsList}" var="list" end="4">
 <c:forEach items="${list.key}" var="item">
 <img src="${pageContext.request.contextPath}${sessionScope.RVItemsList[item].pImage_Origin}" width="80px" height="80px" onclick="detailP('${list.key}')"><br>
 ${sessionScope.RVItemsList[item].pName}${list.key}<hr><br>
</c:forEach>
</c:forEach>
<c:if test="${sessionScope.RVItemsList.size() > 5}">
<button id="rviNext" class="rivViewBtn">NEXT ></button><br><br>
</c:if>
</div>
 <div class="RVItemsView" id="RVItemsView2">
 <b style="font-size: 25px"><br>최근 본 상품<br><br></b><hr>
 <c:forEach items="${sessionScope.RVItemsList}" var="list" begin="5">
 <c:forEach items="${list.key}" var="item">
 <img src="${pageContext.request.contextPath}${sessionScope.RVItemsList[item].pImage_Origin}" width="80px" height="80px" onclick="detailP('${list.key}')"><br>
 ${sessionScope.RVItemsList[item].pName}${list.key}<hr><br>
</c:forEach>
</c:forEach>
<button id="rviPrev" class="rivViewBtn">< PREV</button><br><br>
</div>
 
 </c:if>
</div>
</body>
</html>
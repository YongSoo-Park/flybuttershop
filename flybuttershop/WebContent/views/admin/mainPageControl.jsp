<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#adminWrap{
display: flex;
}
#adminPage{
width: 200px;
height: 1000px;
border-right: solid 1px;
}
#mainControlWrap{
 text-align: center;
width: 1000px;
height: 1000px;
border-left: solid 1px;
}
#mainControlTitle{
margin-top : 50px;
margin-left : 50px;
width: 700px;
height: 100px;
text-align: left;
font-weight: bold;
font-size: 35px;
font-family: 맑은 고딕;
}
#mainControl{
display : inline-block;
width: 897px;
height: 800px;
border: solid 1px;
border-top: none;
}
.mcBtn{
width: 300px;
height : 50px;
margin-left: -3px;
margin-right: -3px;
margin-bottom: -2px;
border-bottom: none;
border-top-left-radius: 30px;
border-top-right-radius: 30px;
background-color: white;
font-weight: bold;
font-size: 20px;
font-family: 맑은 고딕;
}
</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<div id="adminWrap">
<div id="adminPage">
aasfasf
</div>
<div id="mainControlWrap">
<div id="mainControlTitle">메인페이지 관리</div>
<button class="mcBtn">이벤트 관리 메뉴</button>
<button class="mcBtn">신상품 관리 메뉴</button>
<button class="mcBtn">세일상품 관리 메뉴</button>
<div id="mainControl">
asfasfasfsf
</div>

</div>
</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
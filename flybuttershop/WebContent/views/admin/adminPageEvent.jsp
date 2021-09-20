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
	var msg = "<c:out value='${requestScope.upResultMsg}'/>"
	if(msg != ""){
		alert(msg);
	}
	
})
</script>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<main>
<div id="adminWrap">
<div id="adminPage">
<div id="adminPageTitle">
<p style="margin-top: 20px; font-size: 35px">관리 페이지</p><hr>
<p style="margin-top: 150px"><a href="adminevent.ad">이벤트&할인율<br>관리---></a></p>
<p style="margin-top: 150px"><a href="adminconfirm.ad">판매자 신청<br>승인</a></p>
<p style="margin-top: 150px"><a href="adminpage.ad">회원 관리</a></p>

</div>
</div>
<div id="MPEventWrap">

<div id="nowEventImgWrap">
<div id="nowEventImgTitle" style="width: 1000px; text-align: center; font-size: 35px; font-family: 맑은 명조; font-weight: bold;">메인페이지 이벤트 이미지 설정</div>
현재 설정된 이벤트 이미지 입니다.
<div id="nowEventImgView" style="display: flex;">
<div id="nowEventImg1">1번 이벤트 이미지
<img src="${pageContext.request.contextPath}/resources/event/event0.png" style="cursor: pointer; width: 500px; height: 290px;"/></div>
<div id="nowEventImg2">2번 이벤트 이미지
<img src="${pageContext.request.contextPath}/resources/event/event1.png" style="cursor: pointer; width: 500px; height: 290px;"/></div>
</div>
</div>
<br><br>




<form action="mainpageEventSet.ad" method="post" enctype="multipart/form-data">
1번 이벤트 이미지 파일 : <input type="file" name="eventImg1"><br>
2번 이벤트 이미지 파일 : <input type="file" name="eventImg2"><br>
<input type="submit" value="이미지 업로드">
</form>
</div>
</div>
<c:set var="upResultMsg" scope="request" value="1"/>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
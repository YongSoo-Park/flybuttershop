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

</div>
</main>
<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
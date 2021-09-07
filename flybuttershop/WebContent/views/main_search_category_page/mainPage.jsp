<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


</style>

</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>

<main>
<br>
<br>
<form action="dummyLoginA.ma" method="post">

<input type="hidden" value="0" name="no">
<input type="submit" value="관리자로그인">
</form>
<br>
<br>
<form action="dummyLoginA.ma" method="post">

<input type="hidden" value="1" name="no">
<input type="submit" value="일반회원로그인">
</form>
<br>
<br>
<form action="dummyLoginA.ma" method="post">
<input type="hidden" value="4" name="no">
<input type="submit" value="판매자로그인">
</form>

<br>

<br>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</main>

</body>
</html>
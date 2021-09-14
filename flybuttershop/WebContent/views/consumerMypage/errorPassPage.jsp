<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

	<script type="text/javascript">
		$(document).ready(function() {
			alert('비밀번호가 틀립니다. 다시 확인해주세요.');
			location.href="checkPass.mp";
		})
	</script>

</body>
</html>
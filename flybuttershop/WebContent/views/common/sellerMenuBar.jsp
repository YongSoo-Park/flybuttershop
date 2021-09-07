<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>마이페이지</h2>
	
			<div class="selMenu">
			<div class="sel">
				<div class="menu" onclick="goProduct();">상품관리</div>
				<div class="menu" onclick="goPurchase();">판매관리</div>
				<div class="menu" onclick="goQna();">Q&A관리</div>
				<div class="menu" onclick="goReview();">후기관리</div>
				<div class="menu" onclick="goAdminQna();">판매문의</div>
			</div>
		</div>
		
		<script>
		function goProduct(){
			location.href="<%=request.getContextPath()%>/productManager.sl";
		}
		function goPurchase(){
			location.href="<%=request.getContextPath()%>/purchaseManager.sl";
		}
		function goQna(){
			location.href="<%=request.getContextPath()%>/qnaManager.sl";
		}
		function goReview(){
			location.href="<%=request.getContextPath()%>/reviewManager.sl";
		}
		function goAdminQna(){
			location.href="<%=request.getContextPath()%>/adminQna.sl";
		}
		
		</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>판매자 마이페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  <!--스타일 cdn?-->
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> <!--jQuery연결하는 CDN-->
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</head>
<body>

	<h2 align="center">My Page</h2>
	
			<div class="selMenu">
			<div class="sel">
			
				<ul class="nav nav-pills justify-content-center">
				  <li class="nav-item">
				    <a class="nav-link" aria-current="page" href="<%=request.getContextPath()%>/productManager.sl">상품관리</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="<%=request.getContextPath()%>/purchaseManager.sl">판매관리</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="<%=request.getContextPath()%>/qnaManager.sl">Q&A관리</a>
				  </li>
				  <li class="nav-item" >
				    <a class="nav-link" href="<%=request.getContextPath()%>/reviewManager.sl">후기관리</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="<%=request.getContextPath()%>/adminQna.sl">판매문의</a>
				  </li>
				</ul>
			</div>
		</div>
		
	

</body>
</html>
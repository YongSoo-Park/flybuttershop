<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.product.model.vo.*"
    %>
<%
	Product p = (Product)request.getAttribute("p");	
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>Insert title here</title>
<style>
        .pimage{
            width: 200px;
            text-align: center;
        }
        .index{
            width: 80px;
            text-align: center;
        }
        .info{
            width: 500px;
            text-align: center;
        }
        .infoImg{
        	 text-align: center;
        }
    </style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
		
		<h2>상품 상세 관리</h2>
		
		<div class="topInfo">
		<table border="1">
        <tr>
            <td colspan="2" rowspan="11" class="pimage"><img src="${pageContext.request.contextPath}${requestScope.p.pImage_Origin}"></td>
            <td class="index">상품코드</td>
            <td class="info"><%=p.getpCode() %></td>
        </tr>
        <tr>
            <td class="index">대분류</td>
            <td class="info"><%=p.getpCategory() %></td>
        </tr>
        <tr>
            <td class="index">중분류</td>
            <td class="info"><%=p.getpCategory2() %></td>
        </tr>
        <tr>
            <td class="index">상품명</td>
            <td class="info"><%=p.getpName() %></td>
        </tr>
        <tr>
            <td class="index">상품옵션</td>
            <td class="info"><%=p.getpOption()%></td>
        </tr>
        <tr>
            <td class="index">가격</td>
            <td class="info"><%=p.getPrice()%></td>
        </tr>
        <tr>
            <td class="index">재고</td>
            <td class="info"><%=p.getpStock() %></td>
        </tr>
        <tr>
            <td class="index">상태</td>
            <td class="info"><%=p.getpStatus() %></td>
        </tr>
        <tr>
            <td class="index">세일여부</td>
            <td class="info"><%=p.getSale_Flag() %></td>
        </tr>
        <tr>
            <td class="index">등록일</td>
            <td class="info"><%=p.getpDate() %></td>
        </tr>
        <tr>
            <td class="index">별점</td>
            <td class="info"><%=p.getScore_Avg() %></td>
        </tr>
        <tr>
        	<td colspan="4" class="infoImg">
        		<img src="${pageContext.request.contextPath}${requestScope.p.pExp_Image_Origin}">
        	</td>
        </tr>
        

    </table>
	</div>
	
		
		<script>
		function deleteProduct(){
			
			
		}
		function updateProduct(){
			
					
		}
		
		</script>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
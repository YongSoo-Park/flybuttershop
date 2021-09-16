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
<style>
    div{
        display: inline;
    }
    table{
    	width: 500px;
    	text-align: center;
    }
    .outer{
    }
</style>
</head>
<body style="margin: 0 auto">
<jsp:include page="../header_footer/header.jsp" flush="true"/>
<jsp:include page="../common/sellerMenuBar.jsp" flush="true"/>
	<br><br>
	
	
        <div class="storeInfo">
        <table border='1'>
            <tr>
                <th colspan="3">${requestScope.seller.store_Name}</th>
            </tr>
            <tr>
                <td rowspan="5"><img src="resources/product/의류_15_러브이즈트루 원숄더 슬리브리스.jpg"></td>
                <td>대표자</td>
                <td>${requestScope.seller.ceo}</td>
            </tr>
            <tr>
                <td>소재지</td>
                <td>${requestScope.seller.store_Address}</td>
            </tr>
            <tr>
                <td>연락처</td>
                <td>${requestScope.seller.storeCall}</td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>${requestScope.seller.email}</td>
            </tr>
            <tr>
                <td>사업자등록번호</td>
                <td>${requestScope.seller.seller_No}</td>
            </tr>
            <tr>
            	<td rowspan="2">
            		
            	
            	</td>
                <td>계좌번호</td>
                <td>${requestScope.seller.store_Account}</td>
            </tr>
            <tr>
                <td colspan="2">${requestScope.seller.store_Exp}</td>
                
            </tr>
        </table>
        <br><br>
        <button type="button" class="btn btn-outline-dark" onclick="location.href='<%=request.getContextPath()%>/updateForm.sl'">정보 수정</button>
        
       
    </div>

	

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
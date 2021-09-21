<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.seller.model.vo.*"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%
	Seller seller = (Seller)request.getAttribute("seller");
	int totalPur = seller.getTotalSales();
%>

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
         <br><br>
        <button type="button" class="btn btn-outline-dark" onclick="location.href='<%=request.getContextPath()%>/updateForm.sl'">정보 수정</button>
        
        <table border='1'>
            <tr>
                <th class="h3" colspan="3">${requestScope.seller.store_Name}</th>
            </tr>
            <tr>
                <td rowspan="7">
                	<%if(seller.getStore_Lev()==1){ %>
                	<a>현재 상점은 새싹등급입니다.</a>
                	<%}else if(seller.getStore_Lev()==2) {%>
                	<a>현재 상점은 줄기등급입니다.</a>
                	<%}else if(seller.getStore_Lev()==3){ %>
                	<a>현재 상점은 꽃등급입니다.</a>
                	<%}else {%>
                	<a>상점 등급을 산출할 수 없습니다.</a>
                	<%} %>
                	<br>
                	<br>
                	<p><%=1000000 - seller.getTotalSales() %>원 이상 판매시</p>
                	              	
                	<%if(seller.getStore_Lev()==1){ %>
                	<a>줄기등급이 될 수 있습니다.</a>
                	<%}else if(seller.getStore_Lev()==2) {%>
                	<a>꽃등급이 될 수 있습니다.</a>
                	<%}else if(seller.getStore_Lev()==3){ %>
                	<a>꽃등급이 유지 됩니다.</a>
                	<%}else {%>
                	
                	<%} %>
                	
                </td>
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
                <td>계좌번호</td>
                <td>${requestScope.seller.store_Account}</td>
            </tr>
            <tr>
                <td colspan="2">${requestScope.seller.store_Exp}</td>
                 
            </tr>
        </table>
    </div>
    
    <script>
    $(document).ready(function(){
    	var totalPur = ${totalPur};
        var price;
        if(totalPur < 100000){
            price = 100000 - totalPur;
            $("#upGrade").prepend(price);
        }

    });
    </script>

	

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
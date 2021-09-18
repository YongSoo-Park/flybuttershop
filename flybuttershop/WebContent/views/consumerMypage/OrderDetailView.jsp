<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.purchase.model.vo.*, com.flybutter.review.model.vo.*, com.flybutter.consumerMyPage.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<% 
	ArrayList<ArrayList<OrderInfo>>  list  = (ArrayList<ArrayList<OrderInfo>>)request.getAttribute("list");

	String contextPath = request.getContextPath();

%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>주문 내역 조회</title>

<style>

        #outer{

            text-align: center;
            width: 1200px;
        }

        #purWrap{

            padding: 30px ;

        }

    </style>
</head>
<body style="margin: 0 auto">
	
<jsp:include page="../header_footer/header.jsp" flush="true"/>



    <div id="outer">

        <h2>주문 내역 조회</h2>
        <br>

        <table align="center" id="productWrap">

           <tr height="200px">

            <td width="200px">사진자리</td>
            <td width="550px" align="left">&nbsp;&nbsp;&nbsp;<b>상품명</b><br>&nbsp;&nbsp;&nbsp;옵션명</td>
            <td width="250px">배송상태<br><input type="button" value="후기작성"></td>

           </tr>
            
                
          


        </table>
        <hr width="1000px"> 
        <table id="purWrap" align="center" border="1px">
            <tr height="150px">
                <td width="900px" align="right">결제수단<br>총결제금액</td>
            </tr>
        </table>

    </div>



<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
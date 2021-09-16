<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.purchase.model.vo.*, com.flybutter.review.model.vo.*"%>
    
<% 
	ArrayList<Purchase> list  = (ArrayList<Purchase>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

	String contextPath = request.getContextPath();

%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>주문 목록 조회</title>
</head>
<body style="margin: 0 auto">
	
<jsp:include page="../header_footer/header.jsp" flush="true"/>

	   <div id="outer">


        <h2>주문 내역 확인</h2>


      
        <table align="center" rules="none" border="1px">

            <tr>
                <td rowspan="4" witdth="150px" height="150px">사진</td>
                <td align="left">&nbsp;&nbsp; 주문번호</td>
                <td align="right">배송상태&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="left">&nbsp;&nbsp; 상품명</td>
            </tr>
            <tr>
                <td align="left">&nbsp;&nbsp; 주문일시</td>
                <td align="right"><button class="btn">후기작성</button></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><button class="btn">상세조회</button></td>
            </tr>

        </table>


    </div>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
	
</body>
</html>
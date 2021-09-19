<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.consumerMyPage.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<% 
	ArrayList<OrderInfo>  list  = (ArrayList<OrderInfo>)request.getAttribute("list");

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

          padding: 40px

        }

    </style>
</head>
<body style="margin: 0 auto">
	
<jsp:include page="../header_footer/header.jsp" flush="true"/>


    <div id="outer">
		<br><br>
        <h2>주문 내역 조회</h2>
        <br>
        <h3>주문 번호 : <%= list.get(0).getPurNo()%></h3>
        <h3>주문 일시 : <%= list.get(0).getPurDate()%></h3>

        <table align="center" id="productWrap">
			<% for(OrderInfo o : list){ %>
           <tr height="200px">

            <td width="200px"><img src="<%=o.getpImage() %>" border="1px" width="200px"></td>
            <td width="550px" align="left">&nbsp;&nbsp;&nbsp;<b><%=o.getpName() %></b><br>&nbsp;&nbsp;&nbsp;옵션명</td>
            <td width="250px">
                <% int state =  o.getState(); 
								pageContext.setAttribute("state", state);
				%>	
							<c:choose>
  							<c:when test="${state == '1'}">결제완료</c:when>
  							<c:when test="${state == '2'}">배송전</c:when>
  							<c:when test="${state == '3'}">배송중</c:when>
  							<c:when test="${state == '4'}">배송완료</c:when>
  							<c:when test="${state == '5'}">소비자 취소</c:when>
  							<c:when test="${state == '6'}">판매자 취소</c:when>
  							<c:otherwise>오류</c:otherwise>
							</c:choose>
            <br>
            <% if (state == 4){ %>
            <input type="button" value="후기작성" onclick="location.href='<%=contextPath%>/insertForm.rv?purNo=<%=o.getPurNo()%>&&pCode=<%=o.getpCode() %>'"></td>
			<%} %>
           </tr>
            
          <%} %>      
          


        </table>
        <hr width="1000px"> 
        <table id="purWrap" align="center" >
            <tr height="150px">
                <td width="900px" align="right">결제수단<br>총결제금액</td>
            </tr>
        </table>
    </div>




<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
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
        
        #refundWrap{
        	
        	text-align: right;
        }
        
         #refund{
        	
        	background: lightgrey;
        	width: 100px;
        	height: 50px;
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

            <td width="200px"><img src="<%= contextPath %><%=o.getpImage() %>" border="1px" width="200px"></td>
            <td width="550px" align="left">&nbsp;&nbsp;&nbsp;<b><%=o.getpName() %></b><br>&nbsp;&nbsp;&nbsp;옵션명 <%=o.getOption() %></td>
            <td width="250px"><b>
                <% int state =  o.getState(); 
								pageContext.setAttribute("state", state);
				%>	
							<c:choose>
  							<c:when test="${state == '1'}">결제 완료</c:when>
  							<c:when test="${state == '2'}">배송 전</c:when>
  							<c:when test="${state == '3'}">배송 중</c:when>
  							<c:when test="${state == '4'}">배송 완료</c:when>
  							<c:when test="${state == '5'}">소비자 취소</c:when>
  							<c:when test="${state == '6'}">판매자 취소</c:when>
  							<c:when test="${state == '7'}">배송완료</c:when>
  							<c:when test="${state == '8'}">환불 요청</c:when>
  							<c:when test="${state == '9'}">환불 완료</c:when>
  							<c:otherwise>오류</c:otherwise>
							</c:choose>
							</b>
            <br>
            <% if (state == 4){ %>
            <input type="button" value="후기작성" onclick="location.href='<%=contextPath%>/insertForm.rv?purNo=<%=o.getPurNo()%>&&pCode=<%=o.getpCode() %>'">
			<%} else if(state == 3){%>
				운송장 번호 : <%= o.getDelNo() %>
			<%} %>   
			</td>   
           </tr>
            
          <%} %>      
          


        </table>
        <hr width="1200px"> 
        <table id="purWrap" align="center" >
            <tr height="150px">
                <td width="900px" align="right"><b>결제수단</b>&nbsp;&nbsp;&nbsp; 
                <% int type = list.get(0).getPurType();
								pageContext.setAttribute("state", type);
				%>	
							<c:choose>
  							<c:when test="${state == '1'}">무통장 입금</c:when>
  							<c:when test="${state == '2'}">카드 결제</c:when>
  							<c:otherwise>오류</c:otherwise>
							</c:choose>
                <br>
                <b>총결제금액</b>&nbsp;&nbsp;&nbsp; <%= list.get(0).getPurPrice()%> 원</td>
            </tr>
        </table>
        <% if(list.get(0).getState() == 4){%>
        <div id="refundWrap">
        <input type="button" value="환불신청" id="refund" onclick="location.href='<%= request.getContextPath()%>/refundConsumer.mp?pno=<%=list.get(0).getPurNo()%>'">
        </div>
        <%} %>     
    </div>




<jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
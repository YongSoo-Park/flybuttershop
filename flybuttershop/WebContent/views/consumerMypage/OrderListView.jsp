<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.purchase.model.vo.*, com.flybutter.review.model.vo.*, com.flybutter.consumerMyPage.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<% 
	ArrayList<ArrayList<OrderInfo>>  list  = (ArrayList<ArrayList<OrderInfo>>)request.getAttribute("list");
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

<style>

    #outer{

        text-align: center;

    }


    #outer>table{

        width: 850px;
        padding: 20px;

    }

    th,td{

        padding: 20px;
           
    }

    .btn{

        width: 100px;
        height: 50px;

    }



   

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body style="margin: 0 auto">
	
<jsp:include page="../header_footer/header.jsp" flush="true"/>

	   <div id="outer">

		<br>
        <h2>주문 내역 확인</h2>
		<br>
	<%if(list.isEmpty()){ %>
      
      <br><br>
      <h3>주문 내역이 없습니다</h3>
      <br><br>
      <%} else{ %>
      		<% for( ArrayList<OrderInfo> o : list) {%>
				
        <table align="center" rules="none" border="1px">

            <tr>
                <td rowspan="4" width="200px" height="200px"><img src="<%=o.get(0).getpImage() %>" border="1px"></td>
                <td align="left" id="pNo">&nbsp;&nbsp; <b>주문번호</b><br>&nbsp;&nbsp; <%=o.get(0).getPurNo() %></td>
                <td align="right"><b>
                <% int state =  o.get(0).getState(); 
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
                	&nbsp;&nbsp;
                	</b>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left">&nbsp;&nbsp; <b>상품명</b><br>&nbsp;&nbsp; <%=o.get(0).getpName() %>
                <br>&nbsp;&nbsp; 외 <%=list.size()-1 %> 건
                </td>
            </tr>
            <tr>
                <td align="left">&nbsp;&nbsp; <b>주문일시</b><br>&nbsp;&nbsp; <%=o.get(0).getPurDate() %></td>
                <td align="right">
                <% if(state == 4) {%>
                <!--  <button class="btn" onclick="location.href='<%= request.getContextPath()%>/insertForm.rv?pno=<%=o.get(0).getPurNo()%>?pcode=<%=o.get(0).getpCode()%>'">후기작성</button>-->
                <%} else if(state == 1 || state == 2){%>
                <button class="btn" onclick="location.href='<%= request.getContextPath()%>/cancelOrder?pno=<%=o.get(0).getPurNo()%>'">주문취소</button>
                <%} %>
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="right">
                <button class="btn" onclick="location.href='<%= request.getContextPath()%>/detailOrder.mp?pno=<%=o.get(0).getPurNo()%>'">상세조회</button>
                </td>
            </tr>
            
            </table>
            <br><br>
            <%} %>
			<%} %>
		
     

	<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=contextPath%>/orderList.mp?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= contextPath %>/orderList.mp?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath %>/orderList.mp?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= contextPath %>/orderList.mp?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=contextPath%>/orderList.mp?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
	
	
	
    </div>
    
    <script type="text/javascript">
    
    $("#detailOrder").click(function(){ 


		var checkBtn = $(this);

		var tr = checkBtn.parent().parent().parent();
		var td = tr.children().children();
		var pno = td.eq(1).text();
		location.href="<%= request.getContextPath()%>/detailOrder.mp?pno="+pno;
		
})
    
    
    </script>
    
    

<jsp:include page="../header_footer/footer.jsp" flush="true"/>
	
</body>
</html>
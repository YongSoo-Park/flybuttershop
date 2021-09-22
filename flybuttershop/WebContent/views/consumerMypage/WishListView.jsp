<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.flybutter.wishlist.model.vo.*, com.flybutter.review.model.vo.*"%>
    
<% 
	ArrayList<Wishlist>  list  = (ArrayList<Wishlist>)request.getAttribute("list");
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
<title>위시리스트</title>
   <style>

        #outer{

            width: 1200px;
            text-align: center;

        }

        #wishWrap{

            width: 900px;
            height: 250px;
            

        }

        .info{

            padding: 30px;

        }

        #btn{

            width: 100px;
            height: 50px;

        }

        #btnWrap{

            padding-right: 30px;

        }

    </style>
</head>
<body style="margin: 0 auto">

 <jsp:include page="../header_footer/header.jsp" flush="true"/>

	 
    <div id="outer">


        <h2>
            위시리스트
        </h2>
	
		<br>
		
		<%if(list.isEmpty()) {%>
		
			<h3>아직 찜한 상품이 없습니다</h3>
			<br>
		
		<%} else{ %>
		
			<%for(Wishlist w : list){ %>

        <table id="wishWrap" align="center" rules="none" border="1px">

            <tr>
                <td rowspan="3"><img src="<%= contextPath %><%=w.getpImage() %>" width="150px"></td>
                <td align="left" class="info" width="450px"><%= w.getpName() %></td>
                
            </tr>
            <tr>
                <td align="left" class="info"><%= w.getPrice() %> 원</td>
                <td align="right" width="50px" id="btnWrap"><input type="button" value="삭제하기" id="btn" onclick="location.href='<%= request.getContextPath()%>/deleteWish.mp?no=<%=w.getWish_no()%>'"></td>
            </tr>
            <tr>
                <td align="left" class="info"><%= w.getScore() %></td>
            </tr>
            
           

        </table>
        
        <br><br>
        <div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=contextPath%>/wishlist.mp?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= contextPath %>/wishlist.mp?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath %>/wishlist.mp?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= contextPath %>/wishlist.mp?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=contextPath%>/wishlist.mp?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
	
        
         <%} %>

		
			
		<%} %>
    </div>
    
    
 <jsp:include page="../header_footer/footer.jsp" flush="true"/>
	
</body>
</html>
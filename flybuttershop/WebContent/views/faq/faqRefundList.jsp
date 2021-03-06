<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.flybutter.faq.model.vo.*"%>

<%@ page import="com.flybutter.member.model.vo.Member" %>
<%
Member loginUser = (Member)session.getAttribute("loginMember");
ArrayList<FAQ> list = (ArrayList<FAQ>) request.getAttribute("list");
PageInfo pi = (PageInfo)request.getAttribute("pi");

int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<style type="text/css">
#cslogo {
	font-weight: bold;
}

#container { 
	background-color: lightgray;
	width: 1200px;
	height: 70px;
	padding: 10px;
}

#container1 {
	width: 1200px;
	height: 60px;
	padding: 10px;
}

#searchbar {
	margin-right: 0px;
	padding-right: 0px;
	width: 600px;
}

#livechat {
	align: right;
}

.cs {
	margin-left: 20px;
}

.search {
	margin-left: 40px;
	margin-right: 0px;
	display: inline-flex;
}

.live {
	margin-left: 40px;
}

.searchbtn {
	margin-left: 0px;
}



.outer {
	width: 1200px;
	height: 500px;
	color: black;
	margin: auto;
	margin-top: 50px;
}

.listArea {
	border: 1px solid black;
	text-align: center;
}

.searchArea {
	margin-top: 50px;
}

.listArea>tbody>tr:hover {
	background: black;
	cursor: pointer
}
</style>


</head>
<body style="margin: 0 auto">


<jsp:include page="../header_footer/header.jsp" flush="true"/>

	<section>
	<jsp:include page="../common/csMenubar.jsp" flush="true"/>
		
		<div class="btn-group" id="container1">


			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQDeliveryList();">????????????</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQRefundList();">??????/??????/??????</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQOrderList();">??????/??????</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQMemberList();">???????????????</button>
			<% if(loginUser.getUserNo() == 0 || loginUser.getCategory() == 2){ %>  
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQSellerList();">???????????????</button>
				
			<%}%>	
		</div>

	
		<hr>
					

<div class="outer">
		
		        
		<table class="listArea" align="center">
			<thead>
				<tr>
					  <th  width="150">?????????</th>
					<th width="150">????????????</th>
					<th width="900">?????????</th>
			
				</tr>
			</thead>
			<tbody>
				
				 <% if(list.isEmpty()){ %>
				 	<tr>
						<td colspan="5">???????????? ??????????????? ????????????.</td>
					</tr>
				 <% }else{  %>
				 	<% for(FAQ f : list){ %>
				 		<tr>
				 			<td ><%= f.getFaq_No() %></td>
				 				 <td>[??????/??????/??????]</td>
							<td><%= f.getFaq_Title() %></td>
					
				 		</tr>
				 	<% } %>
				 <% } %>
			</tbody>
			
		</table>
	
		<br>
		<div align="center">
		<% if(loginUser.getUserNo() == 0){ %>  
			
			<button onclick="goFaqInsertForm();">????????????</button> 
			<%} %> 
	
		</div>
	<br>
	<script>
		

		function goFAQDeliveryList(){
			location.href="<%=request.getContextPath()%>/deliveryList.faq";
		}
		function goFAQRefundList(){
			location.href="<%=request.getContextPath()%>/refundList.faq";
		}
		function goFAQOrderList(){
			location.href="<%=request.getContextPath()%>/orderList.faq";
			}
		function goFAQMemberList(){
			location.href="<%=request.getContextPath()%>/memberList.faq";
		}
		function goFAQSellerList(){
			location.href="<%=request.getContextPath()%>/sellerList.faq";
			}
		
		
	
		function goFaqInsertForm(){
			location.href="<%=request.getContextPath()%>/insertForm.faq";
		}
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var no = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.faq?no="+no;
			})
		})
		<%}%>
		
		</script>
		<!-- ???????????? ????????? -->
		<div class="pagingArea" align="center">
			<!-- ??? ???????????? (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/refundList.faq?currentPage=1'"> &lt;&lt; </button>
		
			<!-- ??????????????????(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/refundList.faq?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- ????????? ?????? -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath() %>/refundList.faq?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- ??????????????????(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= request.getContextPath() %>/refundList.faq?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- ??? ????????? (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/refundList.faq?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
		
	
	<script>
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var bno = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.faq?bno="+bno;
			})
		})
		<%}%>
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.flybutter.faq.model.vo.*"%>

<%
ArrayList<FAQ> list = (ArrayList<FAQ>) request.getAttribute("list");
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

hr {
	width: 1200px;
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
				onclick="goFAQDeliveryList();">배송문의</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQRefundList();">반품/교환/환불</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQOrderList();">주문/결제</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQMemberList();">회원서비스</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goFAQSellerList();">판매자문의</button>
		</div>

	
		<hr>
					

<div class="outer">
		
		        
		<table class="listArea" align="center">
			<thead>
				<tr>
					 <th style="visibility:hidden;" width="100">글번호</th>
					<th width="100">카테고리</th>
					<th width="300">글제목</th>
			
				</tr>
			</thead>
			<tbody>
				
				 <% if(list.isEmpty()){ %>
				 	<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
				 <% }else{  %>
				 	<% for(FAQ f : list){ %>
				 		<tr>
				 			<td style="visibility:hidden;" ><%= f.getFaq_No() %></td>
				 			<td><%= f.getFaq_Category() %></td>
							<td><%= f.getFaq_Title() %></td>
					
				 		</tr>
				 	<% } %>
				 <% } %>
			</tbody>
			
		</table>
	
		<form class="searchArea" align="center">
			<select id="condition" name="condition">
				<option value="number">글번호</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search" name="search">
			<button type="submit">검색하기</button>
		</form>
		<br><br>
		<div align="center">
			<%--<% if(loginUser != null && loginUser.getUserId().equals("admin")) { --%>
			
			<button onclick="goFaqEnrollForm();">작성하기</button> 
	<%--<% } %> --%>	
		</div>
	
						<div>
							<a href=#none id="show"
								onclick="if(hide.style.display=='none') {hide.style.display='';show.innerText='▲'} else {hide.style.display='none';show.innerText='▼'}">▼</a>
							<div id="hide" style="display: none">
								펼치면 보이는 내용을 적어줍니다. <br /> 아무 내용이나 적어주세요. <br />
							</div>
						</div>
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
		
		
	
		function goFaqEnrollForm(){
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
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>


</body>
</html>
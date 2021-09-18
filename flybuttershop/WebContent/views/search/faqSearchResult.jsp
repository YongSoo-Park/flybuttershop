<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.flybutter.faq.model.vo.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<jsp:include page="../header_footer/header.jsp" flush="true" />

	<section>
		<jsp:include page="../common/csMenubar.jsp" flush="true" />
		<c:if test="${requestScope.searchListEmpty == 0}">
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
		<div id="searchListPWrap">

<div id="searchListPTitle"><span style="font-size: 35px;">'<c:out value="${requestScope.sWord}"/>'</span> 검색 결과</div>

<c:forEach items="${requestScope.searchList}" var="list">
<div class="searchList">
<div class="searchListCategory"><br>
	<span style="font-size: 23px; font-weight: bold;">
	<a onclick="detailF('${list.faq_Category }')" style="cursor: pointer;">
	<c:out value="${list.faq_Title}"/>
	</a></span>
</div>


</c:forEach>

</div>

<br>			
		<div class="outer">
		
		        
		<table class="listArea" align="center">
			<thead>
				<tr>
					
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
		
		
	
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var no = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.faq?no="+no;
			})
		})
		<%}%>
		
		</script>
	<div id="pageNumber">
<c:if test="${requestScope.paging.prePage == 1}">
<a href="#" onclick="listPageMove(${requestScope.paging.startPage - requestScope.paging.cntPage},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})"><</a>
&nbsp;
<a href="#" onclick="listPageMove(1,'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})">1</a>
&nbsp;···&nbsp;
</c:if>
<c:forEach varStatus="status" begin="${requestScope.paging.startPage}" end="${requestScope.paging.endPage}">

<c:choose>
<c:when test="${status.index eq requestScope.paging.nowPage}">
<c:out value="${status.index}"/>
</c:when>

<c:otherwise>
<a href="#" onclick="listPageMove(${status.index},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})"><c:out value="${status.index}"/></a>
</c:otherwise>

</c:choose>
&nbsp;
</c:forEach>
<c:if test="${requestScope.paging.nextPage == 1}">
···&nbsp;
<a href="#" onclick="listPageMove(${requestScope.paging.lastPage},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})"><c:out value="${requestScope.paging.lastPage}"/></a>
&nbsp;
<a href="#" onclick="listPageMove(${requestScope.paging.startPage + requestScope.paging.cntPage},'${requestScope.sWord}',${requestScope.paging.total},${requestScope.sKind})">></a>
&nbsp;
</c:if>

</div>

<br>
<br>
</c:if>
<c:if test="${requestScope.searchListEmpty == 1}">
<div id="wrongWord">
검색하신 단어 '<c:out value="${requestScope.sWord}"/>' 에 <br>관련된 상품을 찾지 못했습니다.<br>
</div>

</c:if>
		
			</section>

	<jsp:include page="../header_footer/footer.jsp" flush="true" />

</body>
</html>
		
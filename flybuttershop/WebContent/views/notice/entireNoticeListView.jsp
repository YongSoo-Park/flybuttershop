<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.flybutter.notice.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.flybutter.member.model.vo.Member" %>
 
 <%
 	Member loginUser = (Member)session.getAttribute("loginMember");
ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
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





<style type="text/css">

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
				onclick="goEntireNoticeList();">전체</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goNoticeList();">공지</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="goEventList();">이벤트</button>
		</div>

	
<hr>
					

<div class="outer">
		
		        
		<table class="listArea" align="center">
			<thead>
				<tr>
					 <th  width="70">글번호</th>
					<th width="70">카테고리</th>
					<th width="400">글제목</th>
			
				</tr>
			</thead>
			<tbody>
				
				 <% if(list.isEmpty()){ %>
				 	<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
				 <% }else{  %>
				 	<% for(Notice n : list){ %>
				 		<tr>
				 			<td ><%= n.getNotice_No() %></td>
				 			<% if(n.getNotice_Category() == 1){ %>
				 			<td>[공지]</td>
				 			 <% }else if(n.getNotice_Category() == 2){  %>
				 			 <td>[이벤트]</td>
				 			 <% } %>
							<td><%= n.getNotice_Title() %></td>
					
				 		</tr>
				 	<% } %>
				 <% } %>
			</tbody>
			
		</table>
	
		
	
						
	<script>
		

		function goEntireNoticeList(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
		function goNoticeList(){
			location.href="<%=request.getContextPath()%>/noticeList.no";
		}
		function goEventList(){
			location.href="<%=request.getContextPath()%>/eventList.no";
			}
		function goEntireNoticeList(){
			location.href="<%=request.getContextPath()%>/entireList.no";
		}
	
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var no = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.no?no="+no;
			})
		})
		<%}%>
		
		</script>
			<br><br>
		
		<!-- 페이징바 만들기 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/entireList.no?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/entireList.no?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath() %>/entireList.no?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= request.getContextPath() %>/entireList.no?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/entireList.no?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
		
	
	<script>
		<%if(!list.isEmpty()){%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var bno = $(this).children().eq(0).text();
				location.href="<%= request.getContextPath()%>/detail.no?no="+no;
			})
		})
		<%}%>
	</script>
		
	</section>

<jsp:include page="../header_footer/footer.jsp" flush="true"/>


</body>
</html>
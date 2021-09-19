<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flybutter.review.model.vo.*" %>  
<%@ page import="com.flybutter.dummy.model.vo.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	Member loginMember= (Member)request.getSession().getAttribute("loginMember");
	Review r = (Review)request.getAttribute("review");
	String contextPath = request.getContextPath();
%>  


    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>리뷰 조회</title>
<style>
	
    <style>

        #outer{
            width: 1200px;
            text-align: center;
        }

        #outer>table{
            width: 800px;
            border-collapse: separate;
            border-spacing: 10px;
        }
        
        .btn{
            width: 1200px;
            text-align: center;

        }
        
        #content{
            width: 800px;
            border: 1px solid black;
            padding: 30px;
        }


		

</style>
</head>
<body style="margin: 0 auto">

 <jsp:include page="../header_footer/header.jsp" flush="true"/>


 <div id="outer">

        <h2 align="center">내가 작성한 리뷰</h2>
		<br>
		

        <table align="center">

            <tr>
                <th id="pImage" rowspan="3" width="150px" height="150px">
               	<img src="<%=contextPath%><%= r.getpImage_origin() %>" width="150px">
             
                </th>
                <th id="title" colspan="2"><%= r.getRe_title()%></th>
            </tr>
            <tr>
                <th><%= r.getUserName() %></th>
                <th><%= r.getRe_date() %></th>
            </tr>
            <tr>
                <th colspan="2"><%= r.getpName() %></th>
            </tr>
            <tr>
                <td colspan="3"><%= r.getScore()%></td>
            </tr>
           
           </table>
            <table id="content" align="center">
            	<%if (r.getRe_originFile() != null){ %>
             <tr>
             	
                <td colspan="3">
                <img src="<%=contextPath %><%= r.getRe_originFile()%>">
                </td>
            </tr>
            <%} %>
            <tr>
                <td><%= r.getRe_content() %></td>
            </tr>
        </table>
		<br><br>
        <div class="btn">

            <button type="button" onclick="location.href='<%=contextPath%>/reviewList.rv?currentPage=1';">목록으로</button>
			
			<% if(loginMember != null && loginMember.getMEM_USER_NO() == r.getUser_no()){ %>
				
				<button type="button" onclick="updateForm();">수정하기</button>
				<button type="button" onclick="deleteBoard();">삭제하기</button>
			<% } %>

        </div>

    </div>
 <jsp:include page="../header_footer/footer.jsp" flush="true"/>
	

</body>
</html>
	
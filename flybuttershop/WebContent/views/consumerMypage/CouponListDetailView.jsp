<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.coupon.model.vo.*, java.util.ArrayList"%>
    
<% 

	String msg = (String)request.getAttribute("msg");
	ArrayList<Coupon> list = (ArrayList<Coupon>)request.getAttribute("list");
	String contextPath = request.getContextPath();


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠폰 목록 조회</title>

 <style>

        #outer{

            width: 1200px;
            text-align: center;
        }


    </style>

</head>
<body style="margin: 0 auto">

 <jsp:include page="../header_footer/header.jsp" flush="true"/>
 	<br><br>
	  <div id="outer">

        <h2>쿠폰 목록 조회</h2>
        <br>

		<% if (list != null){ %>
		

        <table align="center" rules="none" border="1px">


            <tr>

                <th width="150px" height="100px" >쿠폰번호</th>
                <th width="200px">쿠폰이름</th>
                <th width="150px">할인금액</th>
                <th width="150px">최소금액</th>
                <th width="150px">사용기한</th>
                <th width="100px">사용여부</th>
               
            </tr>
		<% for(Coupon c : list) {%>
            <tr>

                <td height="70px"><%= c.getCp_no() %></td>
                <td><%= c.getCp_name() %></td>
                <td><%= c.getCp_discount() %>원</td>
                <td><%= c.getMinPrice() %>원</td>
                <td><%= c.getCp_date() %></td>
                <td>
                
                <% if(c.getCp_count() > 0){ %>
                사용
                <% }else{%>
                미사용
                 <%} %>
                </td>

            </tr>

       <%} %>



        </table>
        
        <br><br>
	<%} else{ %>
	
	<div>
		
		조회 된 쿠폰이 없습니다. 
	
	</div>
	
	
	<%} %>

    </div>
    <br><br>
     <jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
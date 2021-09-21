<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.flybutter.money.model.vo.*, java.util.ArrayList"%>
    
<% 

	//String msg = (String)request.getAttribute("msg");
	ArrayList<Money> plus = (ArrayList<Money>)request.getAttribute("plus");
	ArrayList<Money> minus = (ArrayList<Money>)request.getAttribute("minus");
	String contextPath = request.getContextPath();


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>적립금 내역 조회</title>

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

        <h2>적립금 내역 조회</h2>
        <br>
		<h3>적립 내역</h3>
		<br>
		<% if (plus != null){ %>
		

       
        <table align="center" rules="none" border="1px">


            <tr>

                <th width="300px" height="100px" >적립일시</th>
                <th width="700px">적립금액</th>
               
               
            </tr>
		<% for(Money m : plus) {%>
         <tr>

                <td height="70px"><%= m.getDate() %></td>
                <td><%= m.getMoney() %> 원</td>
             

            </tr>

       <%} %>



        </table>
        
        <br><br>
	<%} else{ %>
	
	<div>
		
		조회 된 적립금이 없습니다. 
	
	</div>
	
	
	<%} %>
	
	 <h3>사용 내역</h3>
	 <br>
	<% if (minus != null){ %>
	
		<table align="center" rules="none" border="1px">


            <tr>

                <th width="300px" height="100px" >사용일시</th>
                <th width="700px">사용금액</th>
               
               
            </tr>
	
		<% for(Money m : minus) {%>
	
		 <tr>

                <td height="70px"><%= m.getDate() %></td>
                <td><%= m.getMoney() %> 원</td>
        

            </tr>
		
	
	
	<%} %>
	
	</table>
	<%} else{ %>
	
	<div>
		
		조회 된 사용 내역이 없습니다. 
	
	</div>

	<%} %>
    </div>
    <br><br>
     <jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
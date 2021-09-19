<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠폰/적립금 조회</title>


   <style>
        #outer{
            width: 1200px;
            text-align: center;
            display: inline-block;
            position: absolute;
        }

        .wrap{
          
            background-color: lightgray;
            text-align: center;
            padding-left: 100px;
           
        }

        .btn{

            background: gray;
            color: white;
            width: 150px;
            height: 70px;
            margin: 10px;

        }
    </style>
</head>
<body style="margin: 0 auto">
	


 <jsp:include page="../header_footer/header.jsp" flush="true"/>
	
    <div id="outer">

        <h2>쿠폰 / 적립금 조회</h2>
        <br>
        <table class="wrap" align="center">

          
            <tr>
                <td width="800px" height="150px" align="left">

                    <h3>사용가능한 적립금은 10000원입니다</h3>

                </td>
            </tr>
            <tr>
                <td align="right">
                    <input type="button" class="btn" value="적립금 조회">
          
                </td>
            </tr>
            
         
        </table>


        <br>
        <br>
        <br>

        <table class="wrap" align="center">

          
            <tr>
                <td width="800px" height="150px" align="left">

                    <h3>사용가능한 가능한 쿠폰은 3개 입니다</h3>

                </td>
            </tr>
            <tr>
                <td align="right">  
                <input type="button" class="btn" value="쿠폰 등록">
                    <input type="button" class="btn" value="쿠폰 조회">
  
                </td>
            </tr>
            
         
        </table>
	
	

    </div>
    <br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br>
 <jsp:include page="../header_footer/footer.jsp" flush="true"/>
</body>
</html>
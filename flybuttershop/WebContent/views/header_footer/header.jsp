<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%String userName = String.valueOf(request.getSession().getAttribute("MEM_USER_NAME")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style type="text/css">
#header{
width: 1200px;
height: 150px;
background-color: red;
}

</style>
<script>
    window.onload = function() {

    	var uName = new Vue({
    		el : "#uname",
    		data : {
    			userName : 'sss'
    		}
    	})
        var exam1 = new Vue({
            el : '#exam1', <!-- el : 관리할 태그 / id의 경우 "#" -->
            data:{ <!-- 객체 안에서 사용 가능한 데이터  -->
                str1 : '1번',
                int1 : 100,
                float1 : 1.23
            }
        })
        var exam2 = new Vue({
            el : '.exam2', <!-- el : 관리할 태그  / 클래스의 경우 "." -->
            data:{ <!-- 객체 안에서 사용 가능한 데이터  -->
                str2 : '2번',
                int2 : 200,
                float2 : 2.23
            }
        })
        var exam3 = new Vue({
            el : '#exam3', <!-- el : 관리할 태그  / 클래스의 경우 "#" -->
            data:{ <!-- 객체 안에서 사용 가능한 데이터  -->
                str3 : '3번',
                int3 : 300,
                float3 : 3.23,
                boolean3 : true,
                array3 : [1,2,3],
                object3 :{
                    a1: 'a1 object 출력',
                    a2:'a2 object 출력'
                }
            }
        })    
        console.log(exam3.float3)<!-- 같은 자바스크립트 내에서 사용 가능. 확인 결과 : 하단의 사진첨부-->
        console.log(exam3.$data)<!-- 같은 자바스크립트 내에서 전체 접근도 가능. 확인 결과 : 하단의 사진첨부 -->
        
        var exam4 = new Vue({
            el : '#exam4',
            data:{
                name: '머신건',
                age:27
            },
            methods : {
                user_info : function(){
                    return '이름 : ' + this.name + ' 나이 : '+ this.age
                }
            }
        })
 
    }
</script>
</head>
<body>
<header id="header"></header>
	<div id = uname>
		<h3>{{userName}}</h3>
	</div>
    <div id="exam1">
        <h3>{{str1}}</h3>
        <h3>{{int1}}</h3>
        <h3>{{float1}}</h3>
    </div>
 
    <hr />
 
    <div class="exam2">
        <h3>class의 경우 한번만 적용. 적용된 경우</h3>
        <h3>{{str2}}</h3>
        <h3>{{int2}}</h3>
        <h3>{{float2}}</h3>
    </div>
 
    <hr />
 
    <div class="exam2">
        <h3>class의 경우 한번만 적용. 적용되지 않은 경우</h3>
        <h3>{{str2}}</h3>
        <h3>{{int2}}</h3>
        <h3>{{float2}}</h3>
    </div>
 
    <hr />
 
    <div id="exam3">
        <h3>모든 경우 사용 가능.</h3>
        <h3>{{str3}}</h3>
        <h3>{{int3}}</h3>
        <h3>{{float3}}</h3>
        <h3>{{boolean3}}</h3>
        <h3>{{array3[0]}}</h3>
        <h3>{{array3[1]}}</h3>
        <h3>{{array3[2]}}</h3>
        <h3>{{object3.a1}}</h3>
        <h3>{{object3.a2}}</h3>
    </div>
 
    <hr />
 
    <div id='exam4'>
        <h3>{{user_info()}}</h3>
    </div>
 
</body>
</html>
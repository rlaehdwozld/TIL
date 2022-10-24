<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
접속한 client 가 가지고 있는 (domain)별로 기록되어 있는 cookie read
 -->
 <%
 	Cookie[] cs= request.getCookies();
 	//웹 브라우져가 가지는 모든 쿠키들을 다 가지고와서

String cookieName = "";
String cookieValue = "";
String cookieMaxAge = "";

if(cs!=null||cs.length>0){
    for(int i=0;i<cs.length;i++){
        if(cs[i].getName().equals("cookieName")){
            cookieName = cs[i].getName();
            cookieValue = cs[i].getValue();
  
            
        }
    }
}
 %>
</body>
</html>
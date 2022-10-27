<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //EL 자체가 <%= 을 대체하는 것이다. (write하는 것)
    //EL을 사용한다고해서 java api를 사용은 못한다!
    //if 날짜 객체가 필요하다면 자바코드로 가져와야한다..
    
    Date today= new Date();
    request.setAttribute("day", today);
    request.setAttribute("day2", today);
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL화면 출력(서버쪽 자원을))</h3>
EL : ${requestScope.day}<br>
EL : ${day }<br><!--requsetScope이라는 객체 명을 생략해도 출력해주지만 가독성이 안좋으니 기왕이면 쓰자  -->
EL : ${day2 }<br><!--이렇게 쓰면 세션에 담긴애인지 리퀘스트에 담긴애인지 파악이 힘들다...  -->
</body>
</html>
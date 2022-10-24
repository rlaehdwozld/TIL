<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="/error/commonError.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  
Error (에외상황) 처리페이지
최종 배포전에 만들어서 처리하면된다.

1. 페이지만다 설정하지
2. 전역설정하기 

페이지에 지역 설정되있으면 그 놈이 우선...
-->
<%
	String data= request.getParameter("name");
	
	String data2=data.toLowerCase();//null인경우
%>

전달받은 내용 : <%=data %>
</body>
</html>
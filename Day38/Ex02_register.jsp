<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//POST 방식 한글 처리 ... 페이지 상단 
request.setCharacterEncoding("UTF-8");

/* 
1. 클라이언트 데이터 받기
2. Tomcat(내장 객체) : 클라이트가 요청 보내면 : 요청 하나에  대해서 서버는 request객체 자동 생성
2.1 request 객체 (요청) : 객체안에 요청한 정보 (입력 데이터 + IP + 브라우져 버전)
2.2 response 객체 (응답) : 서버가 가지는 자원을 클라이언트 출력

HttpServletRequest request = new HttpServletRequest(); ...자동 코드 생성

http://localhost:8090/WebJSP/Ex02_register.jsp?userid=kglim&pwd=1004

*/
	String uid= request.getParameter("userid");
	String pwd= request.getParameter("pwd");
    //hobby input 태그 name이 동일
    //배열
    String[] hobbyarray = request.getParameterValues("hobby");

    
    /* 
      get 방식 전송 (한글깨짐)
      >> Tomcat9버전 부터 (GET)  >> 한글처리 자동 지원

      post 방식 전송 (한글깨짐)
      >>별도의 한글 처리
      >>페이지 상단에 인코딩 (들어오는 데이터 ....)
      >>페이지 상단에 : request.setCharacterEncoding("UTF-8");
    */
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	서버가 클라이언트에게 응답<br>
	ID값 : <%=uid %><br>
	PWD값 : <%=pwd%><br>
	당신의 취미는
	<%
		for(String str : hobbyarray){
	%>	
	   <b>hobby:<%=str %></b><br>	
	<%		
	    }
	%>
</body>
</html>
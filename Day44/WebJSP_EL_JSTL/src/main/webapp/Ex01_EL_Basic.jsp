<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //자바코드 사용가능
    request.setCharacterEncoding("UTF-8");
    
    String id= request.getParameter("userid");
    
    request.setAttribute("name", "korea");
    request.setAttribute("user","kosa");
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSP 출력</h3>
<b><%=id %></b><br>
<b><%=request.getAttribute("name") %></b><br>
<b><%=request.getParameter("userid") %></b><br>
<!--
EL(출력 표현식) : JSP 페이지에서 사용되는 전용 스크립트 언어( 화면에 출력)> [서버에서 해석되는 스크립트] 스크립트가 붙었다고 브라우져에서 해석되는게 아님
이유 : 스파게티 코드가 싫어서 (% 영역과 UI 영역이 혼재되어 있어서 유지보수 측면에서 너무 힘들다!>> 코드의 가독성( 해석)
문제해결 : html 과도 잘 놀고 서버자원도 잘 출력하고 script>> EL>>JSP 페이지에서 사용가능 그래서 쉽다!!

EL : tomcat 서버가 내장하고 있는 객체 (자원) (별도의 참조없이 사용가능)

EL 이 가지고 있는 객체 
1. param
2. paramValues
3. requestScope
4. sessionScope
5. applicationScope



  -->
  <h3>EL 출력하기</h3>
  기존코드<%=1+5 %><br>
  EL : ${100+500}<br>
  EL : ${"1"+1}<br>
  EL : ${1==1 }<br>
  EL : ${false }<br>
  EL : ${!false }<br>
  EL : ${empty x }<br>
  
</body>
</html>
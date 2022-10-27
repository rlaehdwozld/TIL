<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL 출력 -EL 출력</h3>
	<c:out value="<p>문단태그입니다</p>"></c:out>
	<p>문단태그</p>
	<hr>
	<p></p>
	태그는 문단태그입니다. &lt;p&gt; 태그는 설명.....

	<hr>
	<h3>예외처리</h3>
	<!--
c:catch> 안에 구문이 예외가 발생하면 예외 객체가 생성되고 
예외 객체 주소를 받아서 처리 할 수 있다.

var="msg" 자바에서는 Exception msg
  -->
	<c:catch var="msg">
		name:<%=request.getParameter("name")%>
		<%
		if (request.getParameter("name").equals("hong")) {
			out.print("당신으 이름은 : " + request.getParameter("name"));
		}
		%>

	</c:catch>
	<c:if test="${ msg !=null}"></c:if>
	<h3>예외발생</h3>
	오류 메시지 : ${msg }<br>

</body>
</html>
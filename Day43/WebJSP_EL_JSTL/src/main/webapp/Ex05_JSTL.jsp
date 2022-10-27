<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/* 
JSTL구문 (WAS 해석 ( 서버쪽 스크립트 자원))
**<c:set> 변수 생성, 값을 저장
<c:remove> 변수 삭제
**<c:if test=""> 조건문 test= "조건식 true, false"
**<c:choose>여러가지 조건 처리(if 활용도가 높다)
**<c:forEach>반복문 ( 자바 : 개선된 for문 ) >>javascript >> foreach 
	<c:forTokens>for문 split 결합 
	<c: out> 출력식 하지만 우리는 EL ${}사용할거다.
*<c: catch> 예외 처리도 가능

*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL & EL</h3>
	EL parameter : ${param.id }-${param.pwd }
	<br>

	<h3>EL값을 변수 저장</h3>
	<c:set var="userid" value="${param.id }" />
	<c:set var="userpwd" value="${param.pwd }" />

	<hr>
	<h3>JSTL변수값 출력</h3>
	id: ${userid}
	<br> pwd:${userpwd}
	<br>
	<hr>
	<c:if test="${!empty userpwd }">
		<!--userpwd 가 비어있지 않다면 , 비번이 존재한다면  -->
		<h3>not empty userpwd</h3>
		<c:if test="${userpwd=='1004' }">
			<h3>welcome admin page</h3><!--else가 없으니깐 계속 if 걸어야한다.  -->
		</c:if>
	</c:if>
<!-- http://localhost:8090/WebJSP_EL_JSTL/Ex_05_JSTL.jsp?id=kim&pwd=1007
	   http://localhost:8090/WebJSP_EL_JSTL/Ex_05_JSTL.jsp?id=kim&pwd=1004
 -->
</body>
</html>
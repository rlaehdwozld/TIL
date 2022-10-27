<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
위 코드를 EL 과 JSTL 변환 하세요
-->
<c:set var="name" value="${param.name }" />
	<c:choose>
		<c:when test="${name eq 'kglim' }">
			<b>${name }</b>
		</c:when>
		<c:when test="${name eq 'hong'}">
			<i>${name }</i>
		</c:when>
		<c:otherwise>
			<h3>${name }</h3>
		</c:otherwise>
	</c:choose>
	<hr>

</body>
</html>
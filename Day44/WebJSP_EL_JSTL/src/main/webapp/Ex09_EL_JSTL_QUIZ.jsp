<%@page import="kr.or.kosa.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.EmpDao"%>
<%@page import="UTILS.SingletonHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
/*
종합 퀴즈 (조별 퀴즈)

EMP 테이블에서 사원전체 데이터를 출력하는 DTO , DAO 를 작성하세요 (JDBC 참고)
그리고 그 데이터 14건을 
EL & JSTL 을 사용해서 출력하세요
단)부트템플릿 사용하세요
*/


request.setAttribute("list", new EmpDao().getEmpAllList());
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<table border="1">
			<thead>
				<tr>
					<th scope="col">empno</th>
					<th scope="col">ename</th>
					<th scope="col">job</th>
					<th scope="col">mgr</th>
					<th scope="col">hiredate</th>
					<th scope="col">sal</th>
					<th scope="col">comm</th>
					<th scope="col">deptno</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${requestScope.list}">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td>${emp.mgr}</td>
						<td>${emp.hiredate}</td>
						<td>${emp.sal}</td>
						<td>${emp.comm}</td>
						<td>${emp.deptno}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<style>
.container {
	width: 100vw;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

table {
	border-collapse: collapse;
	width: 50vw;
}

th, td {
	padding-top: 2vh;
	padding-bottom: 2vh;
	text-align: center;
}

tbody>th, td {
	border-bottom: 1px solid #444444;
}

thead {
	background-color: #D5DEDC;
	color: #5F7065;
}
</style>
</html>
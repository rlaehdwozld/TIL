<%@page import="DTO.Emp"%>
<%@page import="DAO.EmpDao"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" />


<script type="text/javascript">
	window.onload = function() {
		document.getElementById("emp").addEventListener('change', sendData);
	}

	let httpReq = null;

	function getInstance() {
		if (window.XMLHttpRequest) {
			httpReq = new XMLHttpRequest(); //현재 브라우져 XMLHttpRequest 내장
		} else if (window.ActiveXObject) { //IE6 이하   //지금 필요없어요
			httpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} else {
			throw new Error("AJAX 지원하지 않습니다");
		}
		return httpReq;
	}
	function handlerStateChange() {
		if (httpReq.readyState == 4) { //1. 서버에서 응답이 왔다면
			if (httpReq.status >= 200 && httpReq.status < 300) {

				console.log(httpReq.responseText);

				document.getElementById("datatext").innerHTML = httpReq.responseText;

			} else {
				alert("status Text : " + httpReq.status);
			}
		}
	}
	function sendData() {
		httpReq = getInstance();
		httpReq.onreadystatechange = handlerStateChange;

		let empno = document.getElementById("emp").value;

		console.log(empno);

		httpReq.open("POST", "EmpServlet?empno=" + empno);

		httpReq.send();
	}
</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<jsp:include page="/common/sidebar.jsp"></jsp:include>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<jsp:include page="/common/navigation.jsp"></jsp:include>
			<label>
			<h3>empno</h3>
			 <select name="emp" id="emp"
				class="dataTable-selector">
					<option value="0000">ename</option>
					<option value=7521>WARD</option>
					<option value=7566>JONES</option>
					<option value=7839>KING</option>
					<option value=7876>ADAMS</option>
					<option value=7934>MILLER</option>
					<option value=7698>BLAKE</option>
					<option value=7654>MARTIN</option>
					
			</select>
			<div class="dataTable-container" id="datatext">DATA LOAD</div>

		</div>
		</div>
	</div>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
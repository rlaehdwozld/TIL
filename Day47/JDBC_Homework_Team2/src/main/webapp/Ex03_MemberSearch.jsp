<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}
    
	request.setCharacterEncoding("UTF-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<link href="css/style.css" rel="stylesheet" />
<link href="css/loginForm.css" rel="stylesheet" />
</head>
<body>
<div class="d-flex" id="wrapper">
		 <!-- Left 수정 완료 -->
		 <jsp:include page="/common/Left.jsp"></jsp:include>
		 
	     <div id="page-content-wrapper">
	       	 <!-- Top 수정 완료 -->
			 <jsp:include page="/common/Top.jsp"></jsp:include>
			 <table class="memberlist">
					<tr>
						<th colspan="4">회원리스트</th>
					</tr>
					<c:choose>
						<c:when test="${ empty requestScope.list }">
							<tr>
								<td colspan='3'><b>[" + name + "] 조회결과가 없습니다</b></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="km" items="${ requestScope.list }">
								<tr>
									<td>${km.id}</td>
									<td>${km.name}</td>
									<td>${km.email}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table> 
				<a href="managepage.do" class="move-list">회원 목록 페이지</a> 
	     </div>	        
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script> 
</body>
</html>

<%-- <table
					style="width: 400px; height: 100px; margin-left: auto; margin-right: auto">
					<tr>
						<th colspan="4">회원리스트</th>
					</tr>
					<c:choose>
						<c:when test="${ empty requestScope.list }">
							<tr>
								<td colspan='3'><b>[" + name + "] 조회결과가 없습니다</b></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="km" items="${ requestScope.list }">
								<tr>
									<td>${km.id}</td>
									<td>${km.name}</td>
									<td>${km.email}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table> 
				<a href="managepage.do">회원 목록 페이지</a> --%>
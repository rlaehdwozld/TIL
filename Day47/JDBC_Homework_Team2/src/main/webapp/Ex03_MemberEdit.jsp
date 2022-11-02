<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			 <h3 class="registerInfo">회원가입</h3>
			 <form action="memberEditok.do" method="post">
						<table class="memberlist">
							<tr>
								<td>아이디</td>
								<td>
								  	<input type="text" name="id" value="${requestScope.member.id}" readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
								<td>${ requestScope.member.pwd }</td>				
							</tr>
							<tr>
								<td>이름</td>
								<td>
									<input type="text" name="name" value="${ requestScope.member.name }">
								</td>
							</tr>
							<tr>
								<td>나이</td>
								<td>
									<input type="text" name="age" value="${ requestScope.member.age }">
								</td>
							</tr>
							<tr>
								<td>성별</td>
		                        <td>
		                     <%--       [${ requestScope.member.gender }] --%>
		                           <input type="radio" name="gender" id="gender" value="여" <c:if test="${fn:contains(requestScope.member.gender, '여')}">checked</c:if>>여자
		                           <input type="radio" name="gender" id="gender" value="남" <c:if test="${fn:contains(requestScope.member.gender, '남')}">checked</c:if>>남자
		                        </td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
									<input type="text" name="email" value="${ requestScope.member.email }">
								</td>
							</tr>
	
						</table>
						<input type="submit" value="수정하기" class="update-dtn">
                        <a href='managepage.do' class="move-list">리스트이동</a>
				</form>
	     </div>	        
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script> 
</body>
</html>
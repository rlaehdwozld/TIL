<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	 <div class="d-flex" id="wrapper">
		 <!-- Left 수정 완료 -->
		 <jsp:include page="/common/Left.jsp"></jsp:include>
		 
	     <div id="page-content-wrapper">
	       	 <!-- Top 수정 완료 -->
			 <jsp:include page="/common/Top.jsp"></jsp:include>
			 
			 <div class="container-fluid">
				<c:choose>
	               <c:when test="${ sessionScope.userid eq null }">
	                  <span>사이트 방문을 환영합니다 ^^ <br>회원가입 좀 하지 ...</span>
	               </c:when>
	               <c:when test="${ sessionScope.userid eq 'admin'}">
	                  <a href='managepage.do'>회원관리</a>
	               </c:when>
	               <c:otherwise>
	                  <span>사이트 방문을 환영합니다 ^^</span>
	               </c:otherwise>
	            </c:choose>
				</div>
	     </div>	        
     </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script>   
</body>
</html>



<%-- 	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<!-- Top 수정 완료 -->
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<!-- Left 수정 완료 -->
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
	
				<c:choose>
					<c:when test="${ sessionScope.userid eq 'admin'}">
						<a href='managepage.do'>회원관리</a>
					</c:when>
					<c:otherwise>
						<span>사이트 방문을 환영합니다 ^^ <br>회원가입 좀 하지 ...</span>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table> --%>







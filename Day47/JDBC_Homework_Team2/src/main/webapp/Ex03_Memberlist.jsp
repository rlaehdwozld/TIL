<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	/* 
	*************** 스크립트릿 부분 필요 업음 
	 1.관리자만 접근 가능한 페이지
	 2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
	 3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
	*/
	 if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
		response.sendRedirect("Ex02_JDBC_Login.jsp");
	} 
%> --%>	

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
     <jsp:include page="/common/Left.jsp"></jsp:include>
          <div id="page-content-wrapper"> 
            <jsp:include page="/common/Top.jsp"></jsp:include>
            
            <table class="memberlist">
	            <c:forEach var="km" items="${ requestScope.list }">
					<tr>
						<td>					
							<a href='memberDetail.do?id=${km.id}'>${km.id}</a>
						</td>
						<td>${km.ip}</td>
						<td>
		
							<a href="memberDelete.do?id=${km.id}">[삭제]</a>
						</td>
						<td>
							<a href="memberEditPage.do?id=${km.id}">[수정]</a>
						</td>
					</tr> 
			   </c:forEach>
           </table>
           
		<!-- <form action="Ex03_MemberSearch.jsp" method="post"> -->

		<form class="login-form memberlist-form" action="memberSearch.do" method="post">
			<input type="text" name="search" placeholder ="회원명">
			<button type="submit">이름검색하기</button>
		</form>
     </div>
 </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script> 
</body>
</html>
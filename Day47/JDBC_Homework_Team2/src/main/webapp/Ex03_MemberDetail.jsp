<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/*  
	회원 상세 페이지 (id 컬럼 PK)
	1.권한 검사
	2.id 값 받기 (request.getparameter("id")) >> 한글처리
	3.select id,pwd,name,age,gender,email from koreamember where id=?
	4.id primary key (데이터 1건 보장)
	5.화면 출력 UI 구성
*/	
/*  
1.관리자만 접근 가능한 페이지
2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
*/
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}

%>
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
			<tr>
				<td>아이디</td>
				<td>${ requestScope.member.id }</td>
			</tr>
			<tr>
				<td>비번</td>
				<td>${ requestScope.member.pwd }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${ requestScope.member.name }</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${ requestScope.member.age }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${ requestScope.member.gender }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${ requestScope.member.email }</td>
			</tr>
		</table> 
		<a href="managepage.do" class="go-to-list">목록가기</a>
    </div>
   
 </div>
       
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script> 
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servelt 요청하기</title>
</head>
<body>
	<h3>요청 처리하기</h3>
	<h3>getContextPath</h3>
	<%= request.getContextPath()%>
	<hr>
	<a href="<%= request.getContextPath()%>/simple">simple요청하기(GET)</a>
	<br>
	<a href="<%= request.getContextPath()%>/simple?type=date">날짜_요청하기(GET)</a>
	<br>
	<a href="<%= request.getContextPath()%>/simple?type=abcd">비정상_요청하기(GET)</a>
	<br>
	<hr>
	<h3>FrontServletController</h3>
	<a href="<%= request.getContextPath()%>/action.do?cmd=greeting">요청하기(GET)</a>
	
	<hr>
	<h3>FrontBoardController : 게시판에 관련된 모든 요청을 servlet 하나가 처리</h3>
	<a href="<%= request.getContextPath()%>/Board?cmd=boardlist">게시판 목록보기</a>
	<br>
	<a href="<%= request.getContextPath()%>/Board?cmd=boardwrite">게시판 글쓰기</a>
	<br>
	<a href="<%= request.getContextPath()%>/Board">cmd null Error 유도하기</a>
	<br>
	<a href="<%= request.getContextPath()%>/Board?cmd=boarddelete">게시판 삭제하기</a>
	<br>
	<a href="<%= request.getContextPath()%>/Board?cmd=login">보안 페이지 로그인 보여주기</a>
	<br>
</body>
</html>







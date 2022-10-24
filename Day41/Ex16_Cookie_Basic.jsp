<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
정보 (자료)데이터>저장 > 장소(where)

웹이라는 관점에 데이터 어느 장소에 저장 
클라이언트(개인 로컬 pc:) : 서버 ( 웹서버 or DB서버)

어디에 저장 (보관)

고민 ( 기준점) : 보안 요소( 데이터 중요성), 소멸(일시적, 영속적)

보안 : 클라이언트<>서버
소멸: 메모리와 DB or 파일 

클라이언트( local pc : 웹브라우져)
1. Cookie( 메모리 쿠키와 파일 쿠키 (local 디스크에 txt저장> 암호화))>>소멸시기	
	단점) 크기 제한적 (4096byte), 보안( 사용자 삭제..  암호화 해독 해커..)
2. local storage(key,value) 형태
	장점) 크기, value(객체 사용 가능 : JSON)
	
	server(웹서버 (메모리) +DB 서버) 
	1. server memory : session 객체(사이트 접속하는 사용자마다 고유하게 부여하는 메모리(객체))> 서버 리부팅, 개발코드변경
	2. server memory: : application 객체(사이트 접속하는 모든 사용자에게 부여하는 메모리(객체))> 서버 리부팅, 개발코드변경
	3. server영속적 		: 파일.txt(관리자 힘들다)
	4. DB server 			: 보안, 영속적인 데이터 관리>> 비용은 추가>> 클라우드 사용

 -->
<%
Cookie mycookie= new Cookie("cname","1004");
//서버 쿠키 객체 생성
//내 웹 서버에 접속한 브라우져에게 cookie 전달(write)>> response

response.addCookie(mycookie);// 이 한줄로 쿠키를 클라이언트로 전송



%>
<a href="Ex16_Cookie_read.jsp">Cookie read</a>
</body>
</html>
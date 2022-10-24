<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //JAVA 코드를 쓰는 영역
  //JSP 파일에서 우리가 원하는 모든 작업 가능 (DB 연결 , DB 실행 , 결과 ,화면 출력)
  //장점 : 쉬워요 ...
  //단점 : 분업화 , 유지보수 (코드 한곳에 ) >> 관심사의 분리 안되어 있어요 

  Date dat = new Date();
  /*  
  	JSP 페이지 : UI(html+css+javascript) + JAVA코드 (<% 스크립트릿 안에 구현 )
  	>> 디자인 코드 + 서버로의 로직 코드 : 혼재된 방식 (협업 ...문제 , 유지....)
  	
  			
  	servlet(웹 전용 java파일)(형) + jsp(동생)
  	>>java 웹 기반 기술 아니예요 >> 계산기 , 그림판 , 원도우 프로그램 >> 웹 (web.java) > 웹 전용(request,response)
  	>>java 페이지로 Web서비스 하자 >> login.java >> 단점	 >> 배우기 어렵다 ,	디자인 작업(협업 x)
  	>>디자인 >>jsp탄생
  	
  	[ 서블릿에서 디자인 코드 ]
  	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.print("<html>");
		out.print("<head><title>HELLO</title></head>");
		out.print("<body>");
			out.print("현재 날짜 : " + new Date() + "<br>");
			out.print("<script>alert('경고')</script>");
		out.print("</body>");
	out.print("</html>");
	
	>> JSP 탄생 >> 장점 >> UI 작업 >> Page >> Html기반 >> 디자인 작업 (0) >> 단점 JAVA <% 안에 ..
	>> 혼재(java + UI )
	
	정리)
	서로의 장점을 살리자 (현대적인 프로그래밍은 잘하는 것을 기반 .업무를 ) >> MVC 대두 ....
	>> JSP(UI) + JAVA(순수한 자바 코드) + Servlet(웹용 자바)
	결국
	Model (DAO , DTO(VO))     >>  순수한 JAVA
	View  (UI)                >>  JSP
	Controller (응답,요청 제어)    >>  Servlet
	
	MVC 패턴 으로 개발 진행 (현재 까지 현업에서 ...)
	>>중간 프로젝트 : model2 기반의 MVC패턴  >> model2 (servlet 모든 요청과 처리 담당)
	
	>>model1 >> JSP > 모든 요청과 처리 담당 >> 간단한 프로젝트  + Model 사용
	
	JSP + HTML 차이점
	서비스하기 위해서  
	공통점 : 웹서버
	1 html : web server (아파치) : 클라이언트 요청 (ex: http://www.it.co.kr/login.html)
	>> web server >> 요청을 받아서 >> login.html 있다면 >> 클라이언트에게 전달 (응답)
	
	2.jsp : was(tomcat)을 통해서 컴파일 >> class 파일 생성 >> 생성 파일 실행 (정적데이터 + 동적데이터) >> 응답
	(ex: http://www.it.co.kr/login.jsp)
	
	2.1 WAS(jsp) > compile(login.jsp.java) > login.jsp.class > 실행 (정적데이터 + 동적데이터) >> 응답
	
	//컴파일된 소스 : 
	//C:\KOSA_IT\Web(Back)\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\
	//C:\KOSA_IT\Web(Back)\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WebJSP\org\apache\jsp
    
	문제)상식  ASP , ASPX , PHP , JSP 공통적인 장점은 무었일까요 ?
			코드 노출이 안되요 ... >> 보안상 좋아요 >> 클라이언트는 실행된 결과만 보아요 (text)
			
	서버구성 : default.jsp
	2022년 14:10 서버 오픈
	홍길동 최초 요청자 -> http://www.it.or.kr/default.jsp -> was (처음,기존 실행 된 적이 있는지)
	처음(실행파일이 없다면) >> 컴파일 >> default.jsp.class >> 실행 (메모리) >> 정적+동적 >> 결과 >>서비스
	
	김유신 두번째 요청자 -> http://www.it.or.kr/default.jsp -> was (처음,기존 실행 된 적이 있는지)
	>> 실행 (메모리) >> 정적+동적 >> 결과 >>서비스
	
	>>질문) 다시 컴파일하고 실행 단계는 어떤 상황
    >>1. 개발자가 코드를 수정했을때 ... 
    >>2. 웹서버 재시작 ...
	
	*/
    
%>  

<%
	/*
	 JSP 구성요소
	 1. 선언부 : page 지시자 >> 사용언어 , 인코딩 , import 
     <%@  page language="java" ....
     
     
     2.스크립트 요소 
     2.1 스크립트 릿 <%  java 코드
     2.2 표현식 (출력방법) : 출력하는 대상(Client 브라우져) : <%=  >> response.write 
     2.3 선언부(공통자원: 공통함수 : page scope) : <%!
	*/

%>

<%
  //이안에 JAVA 코드 
  String name="hello world";
%>
<%!
  //공통함수 영역 
  //page 안에서만 사용
  public int add(int i , int j ){
	return i+j;
}
  

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP 실행하기</h3>
	<%=name%><br>
	<%=add(10,20)%><br>
	<%
		int result = add(100,200);
	%>
	<hr>
	<%=result%>
</body>
</html>
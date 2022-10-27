<%@page import="java.util.HashMap"%>
<%@page import="kr.or.kosa.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jsp 파일이 외부 라이브러리를 받는 방법  -->
    
    <%
    Emp e= new Emp(2000,"kosauser");
    
    HashMap<String, String>hp= new HashMap<>();
    hp.put("data", "1004");
    
    request.setAttribute("emp", e);// 이렇게 하면 EL이 사용할 수 있다!
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 기존 방식대로 출력하려고 할 때  -->
<h3>기존방식</h3>
<%=e %><br>
<%=e.getEmpno()	 %><br>
<%=e.getEname() %><br>

<h3>EL 출력</h3>
 EL(x) 자바 객체 출력( 자바객체에 대한 직접 접근불가):${e }<br>
 EL (x): ${e.getEmpno() }<br>
 <!-- EL 출력
EL :
EL :
 이렇게 출력된다. 
 -->
 <h3>해결사</h3>
 1.  request 객체 또는 session 객체에 담는다.**** <br><!--어짜피 포워드 할 껀데  굳이 ?? 이런 마인드로 안만들지 않았을까?  -->
 EL :${requestScope.emp }<br>
 2. JSTL 사용해서 처리<br>
 
 <h3>JSTL(core) : 변수생성, 제어문( 자바코드 도움 없이): 이렇게 만든 JSTL은 서버에서 실행되고 해석되는 자원이다. 서버스크립트다 스크립트가 아니다!</h3>
 <c:set var="m" value="<%=e %>"/>
 JSTL 사용해서 변수 m을 생성 ( EL을 사용해서 접근 가능하다.) :${m }<br>
 getter 함수(권장 방법은 아님):${m.getEmpno() }<br>
 
 EL 출력 ( m.memberfield 명 : 자동으로 getter 호출한다.): ${m.empno }<br><!--굳이 getter setter 할 필요 없다.  -->
  EL 출력 ( m.memberfield 명 : 자동으로 getter 호출한다.): ${m.empno=1000 }<br>
   EL 출력 ( m.memberfield 명 : 자동으로 getter 호출한다.): ${m.ename}<br>
  
 <!--
 EL : 출력목적>> 변수, 제어구조 없어요
 JSTL : EL을 도와서 변수, 제어구조 , 출력을 도와준다.
 
   -->
 <c:set var="username" value="${m.ename }"/><!--마치 자바의 변수를 만드는 것과 똑같다.  -->
 변수값 출력 :${username}<br>
 <h3>JSTL 변수 만들고 Scope정의하기</h3>
 <c:set var="job" value="농구선수" scope="request"/>
 당신의 직업은 : ${job }<br>
 만약에 당신이 include, forward 통해서 페이지를 제어하면 그 페이지에서 EL 통해서 job이라는 변수 값을 출력 할 수 있다. 
 
 <hr>
 <!--잘 안쓰지만 재밌는 기능 --> 
 <c:set var="job2" value="야구선수"/>
 값출력 : ${job2 }<br>
 만든변수를 삭제할 수 있는 기능(잘쓰지 않는다. )<br>
 <c:remove var="job2"/>
 값출력(삭제된 값) : ${job2 }<br><!--삭제된 값을 출력해도 예외가 발생하지 않고 결과가 안나오고 만다.   -->
 
 <hr>
 java api 가 제공하는 객체도 접근 가능할까?? : ${hp }<br>
 1. request 또는 session에다가 담느다.(권장사항)<br>
 2. JSTL 사용한다.<br>
 
 <c:set var="vhp" value="<%=hp %>"/><!--value 값에다가 스크립트 블럭스크립트 블럭을 쓸 수 밖에 없기때문에 최대한 쓰지 말자-->
 hp 객체 : ${vhp }<br>
 hp 객체 : ${vhp.data}<br>
 
 <hr>
 값을 write (hp.put{"color","red")): 그냥 구경만...
 <c:set target="${vhp }" property="color" vlaue="red"/>
 hp 객체 : ${vhp }<br><!--jstl이 java의 영역을 침범할 필요가 없다.  -->
</body>
</html>
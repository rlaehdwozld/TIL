package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
SimpleController extends HttpServlet

SimpleController는 HttpServlet 하고 있어요 

SimpleController.java 파일 >> 서블릿(일반 자바파일을 웹에서 사용할 수 있게 만들었어요)


HttpServletRequest request = new HttpServletRequest();
자동 실행 ...request 클라이언트 정보를 담아서 .... 필용한 정보를 사용


jsp 파일 같은 경우
주소창에 : http://..... /login.jsp 

servlet 파일 같은 경우
주소창에 : http://..... /SimpleController.java ...(x)
 
web.xml 파일에서 설정
[어떤 요청]이 들어오면  SimpleController 자바파일을 컴파일하고 실행하게 할 거냐 ....
[어떠한 주소로 요청 되면] ...SimpleController 자바파일을 컴파일하고 실행하게 할 거냐 ....

        <servlet-name>simplecontroller</servlet-name>
  		<url-pattern>/simple</url-pattern>

        1. http://192.168.0.26:8090/WebServlet_1/simple 요청이 되면
        2. com.SimpleController 패키지 안에 있는 ..
        3. SimpleController.java 컴파일하고 실행
  

 서블릿 조건 : 일반 java 파일이 extends HttpServlet 상속 >> 웹 요청(request),응답(response) 객체 사용
 -servlet은 url에 바로 요청이 안되요 >> 특정요청 >> mapping >> 매핑된 객체 실행
 
 설정
 1. web.xml  (구방식)
 2. @WebServlet (현재 ....) 매핑작업 .....
 
 -extends HttpServlet
 -SimpleController 서블릿 (웹 전용이라)
 -servlet  이벤트 기반 동작( 다양한 함수는 특정사건(이벤트) 가 발생하면 자동호출
 
 -자동 호출 함수
 protected void doGet 
 >> http://192.168.0.26:8090/WebServlet_1/simple 요청방식 GET 방식 doGet 자동호출

 
 protected void doPost
 >> http://192.168.0.26:8090/WebServlet_1/simple 요청방식 POST 방식 doPost 자동호출
 >> <form action=""  method="POST" ....

 doGet() 함수와 doPost()
 1. request, response 객체를 받을 수 있게
    doGet(HttpServletRequest request, HttpServletResponse response)
    함수안에서 request 와 response 사용해서 ....
*/
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자 함수 실행 : 초기화");
    }

    //요청이 GET 방식인 경우 [자동] 실행되는 함수
    //요청에 어떠한 것도 지정하지 않으면 모든 요청은  GET 판단
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 : GET");
		//로직코드
		
		//JSP 에서 사용했던 방식 그대로
		
		//1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		//2. 데이터 받기(요청 의도 파악) ^^ 회원가입 or 게시판 글을 or 로그아웃 파악
		String type = request.getParameter("type");
		
		//3. 로직(업무수행) >> service 수행
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			 resultobj = "hello world";
		}else if(type.equals("date")) {
			 resultobj = new Date();
		}else {
			 resultobj = "invalid String type";
		}
		
		//4. 요청 완료에 따른 결과를 저장
		//MVC 패턴   >> JSP(화면) >> 서블릿 요청 파악 처리 >> View전달 (JSP)
		//결과를 저장 : application , session , request (include , forward)
		//내가 만든 자원이 모든 페이지이 필요하지 않다면 .... application , session 탈락
		//답안)  request
		request.setAttribute("result", resultobj);
		
		//5.저장한 결과를 JSP 페이지 전달 (UI 구성)
		//forward 방식으로  JSP 까지
		//요청한 주소는 변하지 않고 다른 페이지 내용을 서비스 가능
		
		//getRequestDispatcher >> VIEW 페이지 주소 지정
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		
		
		//특정 페이지에 원하는 정보를 전달
		dis.forward(request, response); //request 객체 주소를 같이 ...parameter로
		//servlet 가지고 있는 request 객체의 주소 와 response  객체의 주소를 전달
		
	}

	//요청이 POST 방식인 경우 [자동] 실행되는 함수
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 : POST");
		//로직코드 
	}

}

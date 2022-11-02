package kr.or.kosa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.KoreaMemberDao;
import kr.or.kosa.dto.KoreaMember;

@WebServlet({ "/KoreaMemberController", "*.do" })
public class KoreaMemberController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public KoreaMemberController() {
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       String requestURI = request.getRequestURI();
      String conntextPath = request.getContextPath();
      String urlcommand = requestURI.substring(conntextPath.length());
      
      /*
       * System.out.println("requestURI : " + requestURI);
       * System.out.println("conntextPath : " + conntextPath);
       * System.out.println("urlcommand : " + urlcommand);
       */
      
      request.setCharacterEncoding("UTF-8");
      
      String viewPage = "";
      
      if (urlcommand.equals("/managepage.do")) { // 관리 페이지 가기
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null || !session.equals("admin")) {
            viewPage = "Ex02_JDBC_Login.jsp";
         } else { // 회원 리스트 페이지
            List<KoreaMember> list = new KoreaMemberDao().findAll();
            request.setAttribute("list", list);
            viewPage = "Ex03_Memberlist.jsp";
         }
      } else if (urlcommand.equals("/mainpage.do")) { // 메인페이지 가기
         viewPage = "Ex02_JDBC_Main.jsp";
      } else if (urlcommand.equals("/loginpage.do")) { // 로그인 페이지 가기
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null) { //로그인 페이지 가기!!
            viewPage = "Ex02_JDBC_Login.jsp";
         } else { // 메인 페이지로 가기
            //viewPage = "Ex02_JDBC_Main.jsp";
            response.sendRedirect(request.getContextPath() + "/mainpage.do");
            return;
         }
      } else if (urlcommand.equals("/joinformpage.do")) { // 가입 페이지 가기
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null) { // 가입 페이지로 가기
            viewPage = "Ex02_JDBC_JoinForm.jsp";
         } else { // 메인 페이지로 가기
            //viewPage = "Ex02_JDBC_Main.jsp";
            response.sendRedirect(request.getContextPath() + "/mainpage.do");
            return;
         }
      } else if (urlcommand.equals("/joinok.do")) { // 회원가입 요청
         String id = request.getParameter("id"); 
         String pwd = request.getParameter("pwd"); 
         String name = request.getParameter("mname"); 
         int age = Integer.parseInt(request.getParameter("age")); 
         String gender = request.getParameter("gender"); 
         String email = request.getParameter("email"); 
         String ip = request.getRemoteAddr().toString();
         KoreaMember koreaMember = new KoreaMember(id, pwd, name, age, gender, email, ip);
         int result = new KoreaMemberDao().saveOne(koreaMember);
         if (result > 0) {
            viewPage = "Ex02_JDBC_Login.jsp";
         } else {
            viewPage = "Ex02_JDBC_JoinForm.jsp";
         }
      } else if (urlcommand.equals("/loginok.do")) { // 로그인 요청
         String id = request.getParameter("id");
         String pwd = request.getParameter("pwd");
         KoreaMember koreaMember = new KoreaMemberDao().findOne(id);
         if (koreaMember == null) { // 없는 사용자 혹은 아이디 다른 경우
            viewPage = "Ex02_JDBC_JoinForm.jsp";
         } else {
            if (pwd.equals(koreaMember.getPwd())) { // 로그인 성공 && 비번 동일
               request.getSession().setAttribute("userid", id);
               viewPage = "Ex02_JDBC_Main.jsp";
            } else { // 비번 다름
               System.out.println(pwd + " /// " + koreaMember.getPwd());
               viewPage = "Ex02_JDBC_Login.jsp";
            }
         }
      } else if(urlcommand.equals("/logout.do")) { // 로그아웃 요청
         request.getSession().invalidate();
         //response.sendRedirect("Ex02_JDBC_Login.jsp");
         viewPage = "Ex02_JDBC_Login.jsp";
      } else if(urlcommand.equals("/memberDetail.do")) { // 멤버 상세 페이지 요청
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null || !session.equals("admin")) {
            viewPage = "Ex02_JDBC_Login.jsp";
         } else {
            String id = request.getParameter("id");
            KoreaMember koreaMember = new KoreaMemberDao().findOne(id);
            request.setAttribute("member", koreaMember);
            viewPage = "Ex03_MemberDetail.jsp";
         }
      } else if(urlcommand.equals("/memberDelete.do")) { // 회원 삭제
         String id = request.getParameter("id");
         int result = new KoreaMemberDao().deleteOne(id);
         //viewPage = "Ex03_Memberlist.jsp";
         response.sendRedirect(request.getContextPath() + "/managepage.do");
         return;
      } else if(urlcommand.equals("/memberEditPage.do")) { // 수정 페이지 요청
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null || !session.equals("admin")) {
            viewPage = "Ex02_JDBC_Login.jsp";
         } else {
            String id = request.getParameter("id");
            KoreaMember km = new KoreaMemberDao().findOne(id);
            request.setAttribute("member", km);
            viewPage = "Ex03_MemberEdit.jsp";
         }
      } else if(urlcommand.equals("/memberEditok.do")) { // 회원 수정
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null || !session.equals("admin")) {
            viewPage = "Ex02_JDBC_Login.jsp";
         } else {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            KoreaMember km = new KoreaMember();
            km.setId(id);
            km.setName(name);
            km.setAge(age);
            km.setEmail(email);
            km.setGender(gender);
            int result = new KoreaMemberDao().updateOne(km);
            response.sendRedirect(request.getContextPath() + "/managepage.do");
            return;
         }
      } else if (urlcommand.equals("/memberSearch.do")) { // 회원검색
         String session = (String) request.getSession().getAttribute("userid");
         if (session == null || !session.equals("admin")) {
            viewPage = "Ex02_JDBC_Login.jsp";
         } else {
            String name = request.getParameter("search");
            List<KoreaMember> list = new KoreaMemberDao().findAllByKeyword(name);
            request.setAttribute("list", list);
            request.setAttribute("name", name);
            viewPage = "Ex03_MemberSearch.jsp";
         }
      }
      
      // view 지정
      RequestDispatcher dis = request.getRequestDispatcher(viewPage);

      // forward
      dis.forward(request, response);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

}
package kr.or.kosa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MemoList() {
      super();
   }

   private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
      // memo 전체 데이터 조회
      // 화면 구성 출력
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();

      // select 문을 이용해서 memo 테이블에 있는
      // 레코드들을 가져와 table형태로 꾸며 보여준다.

      // [1] DB와 연결하여 select문 전송

      try {
         Class.forName("oracle.jdbc.OracleDriver");
         Connection conn = null;
         PreparedStatement ps = null;
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "kosa", "1004");

         String sql = "select * from memo";
         ps = conn.prepareStatement(sql);

         ResultSet rs = ps.executeQuery();

         out.println("<body><div align=center>");
         out.println("<hr color=green width=400><h2> Line Memo List </h2><hr color=green width=400>");
         out.println("<table width='500' border='1'>" + "<tr bgcolor='gold'><th width='25%'>Writer</th>"
               + "<th width='50%'>MemoContent</th><th width='25%'>Email</th></tr>");
         while (rs.next()) {// -------------------------
            String id = rs.getString("id");
            String str = rs.getString("content");
            String email = rs.getString("email");

            out.println("<tr><td>" + id + "</td>"); // 작성자
            out.println("<td>" + str + "</td>"); // 메모내용
            out.println("<td>" + email + "</td></tr>"); // 이메일
         } // while-------------------------------------

         out.println("</table></div><center><a href='memo.html'>글쓰기</a></center></body>");

         rs.close();
         ps.close();
         conn.close();

      } catch (Exception e) {

         out.println("<font color=red> 오류 : ");
         out.println(e.getMessage() + "<br/>");
         out.println("</font>");
      }

      out.close();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response, "GET");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response, "POST");
   }

}
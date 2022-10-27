
package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;


@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  //1.한글처리
    	  //2.데이터 받기
    	  //3.DB연결
    	  //4.Insert 실행
    	  //5.응답구성
    		 
    		 
    		 
    	  request.setCharacterEncoding("UTF-8");
    	  response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
    	  PrintWriter out = response.getWriter();
    	  
    	  String id = request.getParameter("id");
    	  String email = request.getParameter("email");
    	  String memo = request.getParameter("content");
    	  //out.print(id + "," + email + "," + content);
    	  
    	  
    	  try{
    	        //DAO//
    		  	MemoDao dao = new MemoDao();
    		  	int n = dao.insertMemo(new Memo(id,email,memo));
    		    ///
    		  
    	   if(n>0){
    		    out.print("<script>");
    	     	out.print("alert('등록성공..');");
    	     	out.print("location.href='MemoList';");  //jsp  >>   /MemoList
    	     	out.print("</script>");
    	   }else{ //insert 에서 현실적으로 경우 ...
    		  
    	   }
    	  }catch(Exception e){
    		out.print("<script>");
  		    out.print("alert('등록실패..');");
  		    out.print("location.href='memo.html';");
  		    out.print("</script>");
  		    e.printStackTrace();
    	   
    	  }
 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.MemoDao;


@WebServlet("/MemoId")
public class MemoId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemoId() {
        super();
       
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비동기 요청을 받아서...
    	//전달한 id 값을 받아서 request
    	
    	//Db연결
    	//select id from memo where id=?
    	//isCheckById(String id)
    	
    	//isCheckById 호출해서 return 값 받아서
    	
    	//view 페이지 만들지 말고
    	//out.print()
    	System.out.println(request.getParameter("id"));
    	//out.print("true");
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	String id = request.getParameter("id");
    	MemoDao dao = new MemoDao();
    	String idcheck= dao.isCheckById(id);
    	
    	//request.setAttribute(idcheck, idcheck);
    	
    	//request.getRequestDispatcher("idcheck.jsp")
    	//out.print(idcheck);
    	
    	 request.setAttribute("idcheck", idcheck);
		 //view 지정
		 RequestDispatcher dis = request.getRequestDispatcher("/check.jsp");
		 //forward
		 dis.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
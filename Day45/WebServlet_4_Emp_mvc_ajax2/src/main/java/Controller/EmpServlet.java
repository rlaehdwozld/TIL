package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmpDao;
import DTO.Emp;


@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmpServlet() {
        super();
       
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성

		String empno = request.getParameter("empno");

		EmpDao dao = new EmpDao();

		try {

			Emp emp = dao.getEmpListByEmpno(Integer.parseInt(empno));

			// 데이터 저장
			request.setAttribute("emp", emp);
			// view 지정
			RequestDispatcher dis = request.getRequestDispatcher("/ui.jsp");
			// forward
			dis.forward(request, response);

		} catch (Exception e) {
			e.getMessage();
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

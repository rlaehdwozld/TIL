<%@page import="kr.or.kosa.utils.ConnectionHelper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	/*  
	********************* 필요없음 ******************************
		1. 권한검사
		2. id 값 받기
		3. DB > delete from koreamember where id=?
		4. 이동처리 >> 삭제 완료시 >> 목록페이지로 이동		
	*/
	if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
		//강제로 다른 페이지 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}

	String id = request.getParameter("id");

	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = ConnectionHelper.getConnection("oracle");
		String sql = "delete from koreamember where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		int row = pstmt.executeUpdate();
		if (row > 0) {
			out.print("<script>");
			out.print("location.href='Ex03_Memberlist.jsp'");
			out.print("</script>");

		} else {
			//필요에 따라 추가
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionHelper.close(pstmt);
	}
%> --%>



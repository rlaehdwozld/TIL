<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="Ex02_JDBC_Main.jsp">Main</a>&nbsp;&nbsp;&nbsp;||
<a href="Ex02_JDBC_Login.jsp">Login</a>&nbsp;&nbsp;&nbsp;||
<a href="Ex02_JDBC_JoinForm.jsp">Register</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;

<%
	if(session.getAttribute("userid") != null){
		out.print("<b>[ " + session.getAttribute("userid") +" ]</b> 로그인 상태");
		out.print("<a href='Ex02_JDBC_Logout.jsp'>[ 로그아웃 ]</a>");
	}else{
		out.print("<b>[로그인 하지 않으셨네요]</b>");
		out.print("<a href='Ex02_JDBC_Login.jsp'>[ 로그인 ]</a>");
	}
%>

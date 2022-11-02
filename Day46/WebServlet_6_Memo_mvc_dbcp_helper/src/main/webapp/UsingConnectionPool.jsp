<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool 사용하기</title>
</head>
<body>
	<%
		Connection conn = null;
		
		//JNDI
		Context context = new InitialContext();
		//현재 [프로젝트]에서 특정 이름을 가진 객체를 검색 (사용 : 이름기반 검색)
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); //  정해진 약속 : java:comp/env/ + jdbc/oracle
	    //lookup 된 객체의 타입이 DataSource
	    
	    //ds  >> 튜브를 가지고 있는 가게의 주소 (...쉽게 ...)
		conn = ds.getConnection();
	    //튜브 주세요 
	    
	    out.print("db 연결여부 :" + conn.isClosed() + "<br>");
	    
	    //반드시 집에 가실때 ... 튜부 반환 ....
	    conn.close(); // POOL close() 반환하는 것 
	    
	    out.print("db 연결여부 :" + conn.isClosed() + "<br>");
	    
	    //그래서 POOL 객체의 scope >> method 로 한정 ....>> 사용하고 반환하자 ...
	%>
</body>
</html>





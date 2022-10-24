<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb"  autoFlush="true"%>    
<%
/*  
JAVA:IO >> Buffer >> default(8kb) >> flush (close)

WEB : Buffer (8kb) 


구현하지 않아도 : page buffer="8kb"  autoFlush="true"
*/

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//out 객체 (WAS) >> java >> System.out.println() 동일 
		for(int i = 0; i < 10 ; i++){
			out.print("<b>" + i + "</b><br>");
		}
		//Buffer 활용해서 페이지에 서비스를 한다
	%>
</body>
</html>
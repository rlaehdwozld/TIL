<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.kosa.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL</h3>
	<!-- 
   java 코드
   int sum=0;
   for(int i = 0 ; i <= 10 ; i++){sum+=1}
   
   for(String str : list){ }
   -->
   
	<c:forEach var="i" begin="0" end="10">
		<c:set var="sum" value="${sum+i}" />
		<b>${i}</b>
		<br>
	</c:forEach>
	sum : 누적값 ${sum}
		<hr>
	<br>

	<h3>구구단 5단을 출력(forEach)</h3>
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>5*${i}=${5*i}</li>
		</c:forEach>
	</ul>
	<hr>
	<h3>EL & JSTL 구구단 출력하기 (중첩 forEach)</h3>
	<table border="1">
		<c:forEach var="i" begin="2" end="9">
			<c:forEach var="j" begin="0" end="9">
				<c:choose>
					<c:when test="${j == 0}">
						<tr bgcolor="gold">
							<th>${i}단</th>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${i}*${j}=${i*j}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:forEach>
	</table>

	<h3>h3 JSTL forEach 사용하기</h3>
	<%
	int[] arr = new int[] { 10, 20, 30, 40, 50 };
	for (int i : arr) {
		out.print("출력값:<b><i>" + i + "</i></b><br>");
	}
	%>
	<h3>EL에서 java 객체 접근 불가(1.request, 2. JSTL)</h3>
	<c:set var="intarr" value="<%=arr%>" />
	EL접근 : ${intarr }
	<br>
	<hr>
	<h3>******for Each(items)개선된 for문*****</h3>
	<c:forEach var="arr" items="${intarr }">
배열값 : ${arr }<br>
	</c:forEach>
	<h3>단순하게</h3>
	<c:forEach var="i" items="<%=arr%>">
배열값 : ${i}<br>
	</c:forEach>
	<h3>재미삼아서</h3>
	<c:forEach var="i" items="<%=new int[] { 1, 2, 3, 4, 5 }%>">
배열값3 : ${i}<br>
	</c:forEach>

	<h3>forEach 속성 활용하기(옵션)</h3>
	<c:forEach var="i" items="${intarr }" varStatus="status">
index: ${ status.index }&nbsp;&nbsp;&nbsp;
count : ${status.count }&nbsp;&nbsp;&nbsp;
value : ${i}<br>
	</c:forEach>
	 <hr>
	 <h3>TODAY POINT (데이터는 한건 이상 : 게시판 )</h3>
	 <%
	 //우리가 다루는 데이터는 1건 이상
	 //select ... 여러건
	 //public List<Emp> getEmpList(){ .... }
	 //JSP 출력 목적 (게시판 처리)
	 List<Emp> emplist = new ArrayList<>();
	 emplist.add(new Emp(100,"A"));
	 emplist.add(new Emp(200,"B"));
	 emplist.add(new Emp(300,"C"));
	 //3건의 데이터가 ArrayList안에 .... 출력 목적
	 
	//자바라면
	for (Emp e : emplist) {
		out.print(e.getEmpno() + " / " + e.getEname() + "<br>");
	}

	//UI JSP(EL JSTL을 쓰는게 목적이다!!)
	//1. request 에 담는다. 나중에는 servlet이 하는일이다.

	request.setAttribute("list", emplist);

	//forward 가정하고
	//jsp 페이지에서
	%>
	<h3>회원 데이터 출력하기(EL&JSTL) 중요하다!!!!!!!</h3>
	<c:set var="elist" value="<%=emplist%>" />
	<!-- 이미 위에서 request.set 처리 했다면 위 코드는 안해도 돼요 -->

	<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
		</tr>
		<c:forEach var="emp" items="${requestScope.list}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
			</tr>
		</c:forEach>
	</table>

	<h3>JAVA Map 객체 EL & JSTL 사용해서 출력</h3>
	<%
	Map<String, Object> hm = new HashMap<>();
	hm.put("name", "hong");
	hm.put("pwd", "1004");
	hm.put("date", new Date());

	//view
	request.setAttribute("hmobj", hm);
	%>
	<c:set var="hm" value="<%=hm%>" />
	<c:forEach var="obj" items="${hm}">
	 	 ${obj.key} -> ${obj.value}<br>
	</c:forEach>
<!--각각을 뽑으려면  -->
	key:name > ${hm.name}
	<br> key:pwd > ${hm.pwd}
	<br> key:date > ${hm.date}
	<br>
	<hr>

	<h3>기타 옵션</h3>
	<h3>JSTL 구분자 기준 처리</h3>
	<c:forTokens var="token" items="A.B.C.D" delims=".">
	 	${token}<br>
	</c:forTokens>


	<h3>JSTL 복합구분자 기준 처리</h3>
	<c:forTokens var="token" items="A.B/C-D" delims="./-">
	 	${token}<br>
	</c:forTokens>
	<br>
	<!--
	 	forEach step = -1
	 	편법
	 	기타
	   -->
	   <h3>순서를 거꾸로 출력해라!</h3>
	<c:set var="nownum" value="10" />
	<c:forEach var="i" begin="0" end="${nownum}" step="1">
	   		${nownum - i}<br>
	</c:forEach>
</body>
</html>
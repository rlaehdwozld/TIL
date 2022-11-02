<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />
<link href="css/loginForm.css" rel="stylesheet" />
</head>
<body>
 <div class="d-flex" id="wrapper">
		 <!-- Left 수정 완료 -->
		 <jsp:include page="/common/Left.jsp"></jsp:include>
		 
	     <div id="page-content-wrapper">
	       	 <!-- Top 수정 완료 -->
			 <jsp:include page="/common/Top.jsp"></jsp:include>
			 
			 <!-- <div class="container-fluid"> -->
					<%-- <form action="${pageContext.request.contextPath}/loginok.do" method="post" name="loginForm" id="joinForm">

					<h3 style="text-align: center;">Login Page</h3>
					<div>
						<table
							style="width: 400px; height: 100px; margin-left: auto; margin-right: auto;">
							<tr>
								<th>아이디:</th>
								<td><input type="text" name="id" id="id"></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="pwd" id="pwd"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="로그인"> <input
									type="reset" value="취소"></td>
							</tr>
						</table>

					</div>
				    </form> --%>
				    
				    <div class="login-page">
				    
			        <div class="form">
			<!-- 		    <form class="register-form">
					      <input type="text" placeholder="name"/>
					      <input type="password" placeholder="password"/>
					      <input type="text" placeholder="email address"/>
					      <button>create</button>
					      <p class="message">Already registered? <a href="#">Sign In</a></p>
					    </form> -->
					    <form action="${pageContext.request.contextPath}/loginok.do" method="post" name="loginForm" id="joinForm">
					      <h3 style="text-align: center;">로그인</h3>
					      <input type="text" name="id" id="id" placeholder="username"/>
					      <input type="password" name="pwd" id="pwd" placeholder="password"/>
					      <button type="submit">로그인</button>
					     <!--  <button>login</button> -->
					      <!-- <p class="message">Not registered? <a href="#">Create an account</a></p> -->
					    </form>
		           </div>
				</div>
			 <!-- </div> -->
	     </div>	        
     </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script> 
</body>
</html>



	<!-- <form action="Ex02_JDBC_loginok.jsp" method="post" name="loginForm" id="joinForm"> -->
				<%-- <form action="${pageContext.request.contextPath}/loginok.do" method="post" name="loginForm" id="joinForm">

					<h3 style="text-align: center;">Login Page</h3>
					<div>
						<table
							style="width: 400px; height: 100px; margin-left: auto; margin-right: auto;">
							<tr>
								<th>아이디:</th>
								<td><input type="text" name="id" id="id"></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="pwd" id="pwd"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="로그인"> <input
									type="reset" value="취소"></td>
							</tr>
						</table>

					</div>
				</form> --%>
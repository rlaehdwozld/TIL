<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<form action="Ex02_JDBC_loginok.jsp" method="post" name="loginForm"
					id="joinForm">

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
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>
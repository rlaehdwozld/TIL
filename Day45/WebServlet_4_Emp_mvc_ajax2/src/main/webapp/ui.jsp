<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped">
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>직업</th>
		<th>매니저</th>
		<th>고용일</th>
		<th>급여</th>
		<th>보너스</th>
		<th>부서번호</th>
	</tr>
	<tr>
		<td>${emp.empno}</td>
		<td>${emp.ename}</td>
		<td>${emp.job}</td>
		<td>${emp.mgr}</td>
		<td>${emp.hiredate}</td>
		<td>${emp.sal}</td>
		<td>${emp.comm}</td>
		<td>${emp.deptno}</td>
	</tr>
</table>
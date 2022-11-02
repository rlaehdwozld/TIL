<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Top navigation-->
  <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <div class="container-fluid">
           <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
           <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
           <div class="collapse navbar-collapse" id="navbarSupportedContent">
	           <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
	            <c:choose>
					<c:when test="${ sessionScope.userid ne null}">
					   <li class="nav-item active">
					       <b class="nav-link"> ${sessionScope.userid} 로그인 상태</b>						
					   </li>
					   <li class="nav-item active">				       
					        <a class="nav-link" href="logout.do">[ 로그아웃 ]</a>
					   </li>		
					</c:when>
					<c:otherwise>
					    <li class="nav-item active">
							<b class="nav-link">[로그인 하지 않으셨네요]</b>
				        </li>	
				        <li class="nav-item active">
				            <a class="nav-link" href='loginpage.do'>[ 로그인 ]</a> 
				        </li>	
					</c:otherwise>
				</c:choose>
			</ul>
			</div>
        </div>
  </nav>	
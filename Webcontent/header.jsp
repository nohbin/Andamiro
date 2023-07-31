<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.css?ver=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
<script src="resources/js/bootstrap.bundle.min.js?ver=1"></script>
<style>
li {
	list-style: none;
}
a {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<header>
		<div class="px-3 py-2 mt-3 mb-3">
			<div class="container d-flex flex-wrap justify-content-center">

			<form class="d-flex" role="search" action=RecipeServlet method="get">
					<input type="hidden" name="command" value="main_search"> 
					<input class="form-control me-2 " type="text" placeholder="검색창"aria-label="Search" name="recipename">
					<button class="btn btn-outline-success" type="submit" style="background-color: #fac279; color: black;">
						<i class="bi bi-search"></i>
					</button>
				</form>

			</div>
			<c:if test="${not empty loginUser.subscribe }">
			<div class="text-end container h5">
				<a href='<c:url value ="/SubscribeServlet?command=save_recipe_view&subNumber=${loginUser.subscribe }"/>'>저장레시피</a>
			</div>
			</c:if>
		</div>
		<nav class="py-2  border-bottom" style="background-color: #fac279;">
			<div class="container d-flex flex-wrap">
				<ul class="nav me-auto">
					<li class="nav-item">
						<a href="<c:url value="/BestMainServlet?command=main"/>" class="nav-link link-dark px-2 active" aria-current="page">Home</a>
					</li>
					<li class="nav-item">
						<a href="<c:url value="/RecipeServlet?command=recipe_list"/>" class="nav-link link-dark px-2">레시피</a>
					</li>
					<li class="nav-item">
						<a href='<c:url value="/SubDietServlet?command=rec_diet"/>' class="nav-link link-dark px-2">식단</a>
					</li>													
					<li class="nav-item">
						<a href="<c:url value="/EventServlet?command=EventMainViewForm"/>" class="nav-link link-dark px-2">이벤트</a>
					</li>
					<li class="nav-item">
						<a href='<c:url value="/subscribe/subscribe.jsp"/>'					
					 class="nav-link link-dark px-2">구독</a>
					  <li class="nav-item">
						<a href="<c:url value="/AnnouncementServlet?command=announcement_list"/>" class="nav-link link-dark px-2">게시판</a>
					</li>
				</ul>
				<div class="text-end">
					<c:choose>
						<c:when test="${loginUser.adminCode eq '999'}">
							<b>[${loginUser.id }]님 환영합니다. 관리자 모드 입니다.</b>
							<a href="<c:url value="/BoardServlet?command=board_paging&page=1"/>" class="btn btn-light text-dark me-2" style="background-color: #fac279;">관리자 페이지</a>
							<a href='<c:url value="/MemberServlet?command=member_logout"/>' class="btn btn-light text-dark me-2" style="background-color: #fac279;">로그아웃</a>
						</c:when>
						<c:when test="${not empty loginUser}">
							<b>[${loginUser.id }]님 환영합니다.</b>
							<a href='<c:url value="/MemberServlet?command=member_logout"/>' class="btn btn-light text-dark me-2" style="background-color: #fac279;">로그아웃</a>
							<a href='<c:url value="/RecipeServlet?command=recipe_write_form"/>' class="btn btn-light text-dark me-2" style="background-color: #fac279;">레시피등록</a>
							<a href='<c:url value="/MemberServlet?command=member_mypage&memberNumber=${loginUser.memberNumber }"/>' class="btn btn-light text-dark me-2" style="background-color: #fac279;">마이페이지</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/MemberServlet?command=member_login_form"/>" class="btn btn-light text-dark me-2" style="background-color: #fac279;">로그인</a>
							<a href='<c:url value="/MemberServlet?command=member_join_form"/>' class="btn btn-light text-dark me-2" style="background-color: #fac279;">회원가입</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</nav>
	</header>


</body>
</html>
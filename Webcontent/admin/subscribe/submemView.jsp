<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/bootstrap.css">
<link rel="stylesheet" href="../../resources/css/join.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
<jsp:include page="../adminheader.jsp"></jsp:include>
	<div class="container" align="left">
	   <div style="height: 1rem;"></div>
		<div class="fs-3 fw-bolder">구독회원 상세정보</div>
		 <div style="height: 1rem;"></div>
		<table class="table table align-middle table-bordered border-warning border-opacity-50" style="width: 60rem; border-radius: 10px;">
			<tr><th>구독회원 번호</th>
				<td>${subscribe.subNumber}</td>
			</tr>
			<tr><th>회원 번호</th>
				<td>${subscribe.memberNumber}</td>
			</tr>
			<tr><th>회원 아이디</th>
				<td>${subscribe.userId}</td>
			</tr>
			<tr>	
				<th>구독 시작일</th>
				<td>${subscribe.sub_start}</td>
			</tr>
			<tr><th>구독 종료일</th>
				<td>${subscribe.sub_end}</td>
			</tr>
		</table>
		</div>
		<br> <br> 
		<div class="container" align="center">
		<input type="button" value="구독 해지하기"
			onclick="location.href='SubscribeServlet?command=submem_delete&subNumber=${subscribe.subNumber}'"> 		
		<input type="button" value="구독회원 목록"
			onclick="location.href='AdminServlet?command=submem_list&page=1'">
		</div>
	<div style="height: 10rem;"></div>
<jsp:include page="../../footer.jsp"></jsp:include>	
</body>
</html>
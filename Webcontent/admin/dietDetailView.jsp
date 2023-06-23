<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/join.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container" align="center">
	   <div style="height: 7rem;"></div>
		<h1 class="mb-5 fw-bolder">식단 상세정보</h1>
		 <div style="height: 3rem;"></div>
		<table class="table table align-middle table-bordered border-warning border-opacity-50" style="width: 60rem; border-radius: 10px;">
			<tr><th>음식명</th>
				<td>${dietDetail.foodName}</td>
			</tr>
			<tr>	
				<th>칼로리</th>
				<td>${dietDetail.kcal}</td>
			</tr>
			<tr><th>영양성분</th>
				<td>${dietDetail.component}</td>
			</tr>
		</table>
		<br> <br> <input type="button" value="식단정보 수정"
			onclick="location.href='DietServlet?command=dietDetail_update_form&dietDetailID=${dietDetail.dietDetailID}'"> 
		<input type="button" value="식단정보 삭제"
			onclick="location.href='DietServlet?command=dietDetail_delete&dietDetailID=${dietDetail.dietDetailID}'"> 		
		<input type="button" value="식단상세 리스트"
			onclick="location.href='DietServlet?command=dietDetail_list'"> 
		<input type="button" value="식단정보 등록"
			onclick="location.href='DietServlet?command=dietDetail_write_form'">
	</div>
	<div style="height: 10rem;"></div>
<jsp:include page="../footer.jsp"></jsp:include>	
</body>
</html>
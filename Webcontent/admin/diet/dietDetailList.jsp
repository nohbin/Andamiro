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
	<div class="container" align="right">
	<div style="height: 1rem;"></div>
		<input type="button" value="식단상세 등록" class="btn btn-outline-warning" onclick="location.href='DietServlet?command=dietDetail_write_form'"> 
	</div>	
	<div class="container" align="center">
		<table class="table table-hover">
			<tr class="text-center">
				<th>상세식단번호</th><th>식단번호</th><th>음식명</th><th>칼로리</th><th>영양성분</th>
			</tr>
			<c:forEach var="dietDetail" items="${dietDetailList }">
				<tr class="record text-center">
					<td>${dietDetail.dietDetailID }</td>
					<td>${dietDetail.dietNumber}</td>
					<td><a href="DietServlet?command=dietDetail_view&dietDetailID=${dietDetail.dietDetailID}">${dietDetail.foodName}</a></td>
					<td>${dietDetail.kcal}</td>
					<td>${dietDetail.component}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="height: 7rem;"></div>
<jsp:include page="../../footer.jsp"></jsp:include>	
</body>
</html>
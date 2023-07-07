<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/bootstrap.css">
<link rel="stylesheet" href="../../resources/css/join.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
	<div class="container" align="center">
	   <div style="height: 7rem;"></div>
		<h1 class="mb-3"> 식단상세 등록</h1>
		<form name="frm" method="post"  action="DietServlet" >
		<input type="hidden" name="command" value="dietDetail_write"> 	
			<div style="height: 5rem;"></div>
			<table class="table">
				<tr>
					<th>식단번호</th>
					<td><input type="text" name="dietNumber"></td>
				</tr>
				<tr>
					<th>음식명</th>
					<td><input type="text" name="foodName"></td>
				</tr>
				<tr>
					<th>칼로리</th>
					<td><input type="text" name="kcal"></td>
				</tr>
				<tr>
					<th>영양성분</th>
					<td><input type="text" name="component"></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록" onclick="return dietCheck()">
			 	 <input type="reset"  value="다시 작성">
			 	 <input type="button" value="목록" onclick="location.href='AdminServlet?command=dietDetail_list&page=1'">
		</form>
	</div>
	<div style="height: 7rem;"></div>
<jsp:include page="../../footer.jsp"></jsp:include>		
</body>
</html>




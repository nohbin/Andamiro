<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/bootstrap.css">
<link rel="stylesheet" href="../../resources/css/join.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script>
	function dietWriteCheck(){
		if (document.frm.diet_kind.value.length == 0) {
			alert("식단 종류를 입력하세요.");
			return false;
		}
		if (document.frm.diet_picture.value == 0) {
			alert("식단 이미지를 첨부하세요.");
			return false;
		}
		if (document.frm.diet_menu.value.length == 0) {
			alert("식단 메뉴를 입력하세요.");
			return false;
		}
		alert("식단이 등록되었습니다.");
		return true;
	}
</script>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
	<div class="container" align="center">
	   <div style="height: 7rem;"></div>
		<h1 class="mb-3"> 식단 등록</h1>
		<form name="frm" method="post" action="DietServlet" > 	
		<input type="hidden" name="command" value="diet_write"> 
			<div style="height: 5rem;"></div>
			<table class="table">
				<tr>
					<th>식단종류</th>
					<td><input type="text" name="diet_kind"></td>
				</tr>
				<tr>
					<th>식단이미지</th>
					<td><input type="file" name="diet_picture"></td>
				</tr>
				<tr>
					<th>식단메뉴</th>
					<td><input type="text" name="diet_menu"></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록" onclick="function submitForm()">
			 	 <input type="reset"  value="다시 작성">
			 	 <input type="button" value="목록" onclick="location.href='DietServlet?command=diet_list'">
		</form>
	</div>
	<div style="height: 7rem;"></div>
<jsp:include page="../../footer.jsp"></jsp:include>		
</body>
</html>




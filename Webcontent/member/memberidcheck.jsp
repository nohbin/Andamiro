<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.css?ver=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	<div align="center" class="mt-3">
		<h1>아이디 중복 검사</h1>
		<form action="MemberServlet" name="frm" method="get">
			<input type="hidden" name="command" value="member_Idcheck">
			<table style="width: 80%">
				<tr>
					<th>아이디 입력</th>
					<td><input type="text" name="id" size="20" class="form-control"></td>
				</tr>
			</table>
			<br> <input type="submit" class="btn" style="background-color: #fac279;" value=" 확 인 " onclick="return idCheck()"> <br> <br>
			<b style="color: red">[${id }]  ${message}</b>
			<script>
			function idCheck() {
				if (document.frm.id.value.length == 0) {
					alert("아이디를 입력하세요.");
					return false;
				}
				return true;
			}
			
			</script>
		</form>
		
	</div>
</body>
</html>
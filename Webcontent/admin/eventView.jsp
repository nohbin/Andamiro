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
<script type="text/javascript" src="script/board.js">
</script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container" align="center">
	   <div style="height: 7rem;"></div>
		<h1 class="mb-5 fw-bolder">이벤트 보기</h1>
		 <div style="height: 3rem;"></div>
		<table class="table align-middle table-bordered border-warning border-opacity-50" style="width: 50rem;" >
			<tbody class="border-3 rounded-3">
			<tr><th class="text-center" style="width: 10rem;" >기간 </th>
				<td style="width: 40rem;">${eventview.evstart}~${eventview.evend}</td>
			</tr>
			<tr><th class="text-center" style="width: 10rem;">진행여부</th>
				<td style="width: 40rem;">${eventview.ing}</td>
			</tr>
			<tr>	
				<th class="text-center" style="width: 10rem;">이벤트썸네일</th>
				<td style="width: 40rem;"><img src="upload/${eventview.imgsum}" style="width:15rem; height:10rem;"></td>
			</tr>
			<tr>	
				<th class="text-center" style="width: 10rem;">이벤트포스터</th>
				<td style="width: 40rem;"><img src="upload/${eventview.poster}" style="width:15rem; height:10rem;"></td>
			</tr>
			
			
			</tbody>
		</table>
		<br> <br> <input type="button" value="이벤트 수정"
			onclick="location.href='EventServlet?command=event_update_form&eventno=${eventview.eventno}'"> 
		<input type="button" value="이벤트 삭제"
			onclick="location.href='EventServlet?command=event_delete&eventno=${eventview.eventno}'"> 		
		<input type="button" value="이벤트 리스트"
			onclick="location.href='./eventList.jsp'"> 
		<input type="button" value="이벤트 등록"
			onclick="location.href='../EventServlet?command=event_write_form'">
	</div>
	<div style="height: 10rem;"></div>
<jsp:include page="../footer.jsp"></jsp:include>	
</body>
</html>
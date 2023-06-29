<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
<jsp:include page="../adminheader.jsp"></jsp:include>

	



	<div class="container" align="center">
		 <div style="height: 1rem;"></div>
		 <table class="table table-hover">
			<tr>
				<td colspan="10" style="border: white; text-align: right">
			</tr>
			<tr class="text-center">
				<th>구독번호</th>
				<th>회원번호</th>
				<th>회원 아이디</th>
				<th>구독시작일</th>
				<th>구독종료일</th>
			</tr>
			<c:forEach var="subscribe" items="${submemList }">
				<tr class="record text-center">
					<td>${subscribe.subNumber }</td>
					<td>${subscribe.memberNumber}</td>  
					<td><a href="SubscribeServlet?command=submem_view&subNumber=${subscribe.subNumber}">${subscribe.userId }</a></td>
					<td>${subscribe.sub_start}</td>
					<td>${subscribe.sub_end }</td>
				</tr>
			</c:forEach>
		 </table>
	</div>
	<div style="height: 7rem;"></div>
<jsp:include page="../../footer.jsp"></jsp:include>		
</body>
</html>
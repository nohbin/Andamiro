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
	<div id="wrap" align="center">
		<h1>안다미로 구독 회원 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="10" style="border: white; text-align: right">
				<a href="AndamiroServlet?command=subscribe_write_form">회원 등록</a></td>
			</tr>
			<tr>
				<th>구독번호</th><th>회원번호</th><th>구독시작일</th><th>구독종료일</th>
			</tr>
			<c:forEach var="subscribe" items="${submemList }">
				<tr class="record">
					<td>${subscribe.subNumber }</td>
					<td><a href="AndamiroServlet?command=subscribe_view&num=${subscribe.memberNumber}">${subscribe.memberNumber}</a></td>  
					<td>${subscribe.sub_start}</td>
					<td>${subscribe.sub_end }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
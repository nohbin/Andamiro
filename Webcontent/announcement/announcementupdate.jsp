<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/join.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
label[for=name] button {
	color: rebeccapurple;
}
</style>
</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<form action="AnnouncementServlet" method="post">
		<input type="hidden" name="command" value="announcement_update">
		<input type="hidden" name="annNum" value="${announcement.annNum}">
		<div class="text-center">
			<h1>게시글 수정</h1>
		</div>

		<div class="container text-center border mt-3 rounded-3">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label"><h3>게시글
						제목</h3></label> <input type="text"
					class="mt-3 form-control position-relative top-50 start-50 translate-middle"
					id="exampleFormControlInput1" placeholder="${announcement.annTitle}"
					style="width: 50%;" name="annTitle"
					value="${announcement.annTitle}" required>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label"><h3>게시글
						내용</h3></label>
				<textarea
					class="mt-5 form-control position-relative top-50 start-50 translate-middle"
					id="exampleFormControlTextarea1" rows="3"
					placeholder="${announcement.announcement}" name="announcement"
					style="width: 70%; height: 50%;" required>${announcement.announcement}</textarea>

			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput2" class="form-label"><h3>작성자
						아이디</h3></label> <input type="text"
					class="mt-3 form-control position-relative top-50 start-50 translate-middle"
					id="exampleFormControlInput1" placeholder="${loginUser.id } "
					name="id" style="width: 50%;" value="${loginUser.id }" required>
				<c:if test="${empty announcement.id}">
				</c:if>
			</div>

			<div class="d-grid gap-2 col-6 mx-auto">
				<button class="btn btn-warning" type="submit">수정</button>
				<button class="btn btn-warning" type="button">목록</button>
			</div>
		</div>
	</form>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>

</html>

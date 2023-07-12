<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container mt-4">
		<form action="AnnouncementServlet">
			<input type="hidden" name="command" value="announcement_detail">
			<input type="hidden" name="annNum" value="${announcement.annNum }">
			<input type="hidden" name="authorId" value="${announcement.id}">
			<input type="hidden" name="userID" value="${loginUser }">

			<h1>�Խñ� ����: ${announcement.annTitle}</h1>
			<hr>

			<div class="card mb-4">
				<div class="card-body">
					<h5 class="card-title">�ۼ���: ${announcement.id}</h5>
				</div>
			</div>
			<div class="mb-4">
				<h3>�Խñ� ����</h3>
				<hr>
			</div>
			<div class="card mt-2">
				<div class="card-body">
					<p class="card-text">
						<b>${announcement.announcement } ${loginUser.id}</b>
					</p>
				</div>
			</div>

			<c:choose>
				<c:when test="${not empty loginUser }">
			<button class="btn btn-primary  mt-3" type="button" value="delete"
				onclick="window.location.href='AnnouncementServlet?command=announcement_delete&annNum=${announcement.annNum}'">����</button>
			<button class="btn btn-primary mt-3" type="button" value="update"
				onclick="goToUpdatePage()">����</button>
			<button class="btn btn-primary  mt-3" type="button" value="list"
				onclick="window.location.href='AnnouncementServlet?command=announcement_list'">���</button>
				</c:when>
				<c:otherwise>
				<button class="btn btn-primary  mt-3" type="button" value="delete"
				onclick="window.location.href='AnnouncementServlet?command=announcement_delete&annNum=${announcement.annNum}'">����</button>
			<button class="btn btn-primary mt-3" type="button" value="update"
				onclick="goToUpdatePage()">����</button>
			<button class="btn btn-primary  mt-3" type="button" value="list"
				onclick="window.location.href='AnnouncementServlet?command=announcement_list'">���</button>			
				</c:otherwise>
			</c:choose>	
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="../footer.jsp"></jsp:include>

	<script type="text/javascript">
		function goToUpdatePage() {
			var authorId = "${announcement.id}";
			var userId = "${loginUser.id}";

			if (userId === authorId) {
				window.location.href = 'AnnouncementServlet?command=announcement_update_form&annNum=${announcement.annNum}';
			} else {
				alert("�ش� �Խñ��� ������ ������ �����ϴ�.");
			}
		}
	</script>

</body>
</html>


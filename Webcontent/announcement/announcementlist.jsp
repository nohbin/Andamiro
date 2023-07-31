<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="UTF-8">

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
li {
	list-style: none;
}

a {
	color: black;
	text-decoration: none;
}

label[for=name] button {
	color: rebeccapurple;
}

/* 한글 인코딩 설정 */
@charset "UTF-8";
</style>
</head>

<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="text-center">
		<h1>게시판</h1>
	</div>

	<div class="container text-center border mt-3 rounded-3">
		<table class="table">
			<thead class="table-light">
				<tr>
					<th>게시글 번호</th>
					<th>게시글 제목</th>
					<th>작성자</th>
					<th>열람횟수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
					<c:when test="${empty annList}">
						<tr>
							<td colspan="5">게시글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="list" items="${annList}">
							<tr>
								<td>${list.annNum}</td>
								<td><a href="AnnouncementServlet?command=announcement_detail&annNum=${list.annNum }">${list.annTitle}</a></td>
								<td>${list.id}</td>
								<td>${list.viewCount}</td>
								<td>${list.joindate}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			
		</table>

		<button class="btn btn-primary" type="button" value="delete"
										onclick="window.location.href='AnnouncementServlet?command=announcement_write_form'">등록</button>
 <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pagingUtil.getStartPage() > 1}">
                    <li class="page-item">
                        <a class="page-link" href="AnnouncementServlet?command=announcement_list&nowPage=${pagingUtil.getStartPage() - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach var="pageNum" begin="${pagingUtil.getStartPage()}" end="${pagingUtil.getEndPage()}">
                    <c:choose>
                        <c:when test="${pageNum == pagingUtil.getNowPage()}">
                            <li class="page-item active">
                                <span class="page-link">${pageNum}</span>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="AnnouncementServlet?command=announcement_list&nowPage=${pageNum}">${pageNum}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${pagingUtil.getEndPage() < pagingUtil.getLastPage()}">
                    <li class="page-item">
                        <a class="page-link" href="AnnouncementServlet?command=announcement_list&nowPage=${pagingUtil.getEndPage() + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
        <nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <form class="d-flex"  action="AnnouncementServlet" method="get"  >
    <input type="hidden"  name="command"  value="announcement_search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="annTitle" >
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
    </div>
</body>

</html>
	

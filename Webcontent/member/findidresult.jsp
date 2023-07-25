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
<link rel="stylesheet" href="resources/css/join.css?ver=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">
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
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	
	<div class="container my-5">
        <ul class="nav nav-tabs">
            <li class="nav-item mynav-item">
                <a class="nav-link" aria-current="page" href="<c:url value="MemberServlet?command=member_find"/>" style="text-decoration: none;  color: inherit">아이디 찾기</a>
            </li>
            <li class="nav-item  mynav-item">
                <a class="nav-link" href="<c:url value="MemberServlet?command=member_find_password"/>" style="text-decoration: none; color: inherit">비밀번호 찾기</a>
            </li>
        </ul>
    </div>
    <c:choose>
	    <c:when test="${not empty id }">
		    <div class="container my-5">
				<div class="input-form-backgroud row mx-auto text-center">
					<b class="h5"> 회원님의 아이디 : [${id }] </b>
					<div class="custom-control custom-checkbox text-center my-5">
						<a class="btn btn-lg btn-block mt-3" style="background-color: #fac279;" href="<c:url value = 'MemberServlet?command=member_login_form&id=${id }'/>">로그인</a>
						<a class="btn btn-lg btn-block mt-3" style="background-color: #fac279;" >비밀번호 찾기</a>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			 <div class="container my-5">
				<div class="input-form-backgroud row mx-auto text-center">
					<b class="h5"> 이름 또는 이메일이 잘못 입력되거나 또는 없는 회원 입니다. </b>
					<div class="custom-control custom-checkbox text-center my-5">
						<a class="btn btn-lg btn-block mt-3" style="background-color: #fac279;" onclick="goBack()">돌아가기</a>
						<script type="text/javascript">
							function goBack(){
								history.back();
							}
						</script>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	
	
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
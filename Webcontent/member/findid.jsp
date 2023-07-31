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
                <a class="nav-link" aria-current="page" href="<c:url value="MemberServlet?command=member_findid"/>" style="text-decoration: none;  color: inherit">아이디 찾기</a>
            </li>
            <li class="nav-item  mynav-item">
                <a class="nav-link" href="<c:url value="MemberServlet?command=member_findpwd"/>" style="text-decoration: none; color: inherit">비밀번호 찾기</a>
            </li>
        </ul>
    </div>
    
    <div class="container mt-5">
		<div class="input-form-backgroud row mx-auto" style="width: 300px;">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3 text-center">아이디 찾기</h4>
				<form class="validation-form" action="MemberServlet" method="post" novalidate accept-charset="utf-8" >
				<input type="hidden" name="command" value="memeber_id_find_action">
					<div class="row">
						<div class="col-12 mb-3">
							<label for="name">이름(*)</label> 
							<input type="text" class="form-control" id="name" name = "name" placeholder="" value="" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-12 mb-3">
							<label for="name">이메일(*)</label> 
							<input type="email" class="form-control" id="email" name="email" placeholder="" placeholder="you@example.com" value="" required>
							<div class="invalid-feedback">이메일을 입력해주세요.</div>
						</div>
					</div>
					<hr class="mb-4">
					<div class="custom-control custom-checkbox text-center">
						<button class="btn btn-lg btn-block mt-3" style="background-color: #fac279;" type="submit" onclick="return validateForm()">아이디 찾기</button>
					</div>
					<div class="mb-5"></div>
				</form>
			</div>
		</div>

		<script>
		    function validateForm() {
		        const form = document.querySelector('.validation-form');
		
		        if (form.checkValidity() === false) {
		            event.preventDefault();
		            event.stopPropagation();
		        }
		
		        form.classList.add('was-validated');
		    }
		</script>
	</div>
	
	
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
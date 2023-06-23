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
<%
	request.setCharacterEncoding("UTF-8");
	%>
	<jsp:include page="/header.jsp"></jsp:include>
	
	<div class="container mt-5">
		<div class="input-form-backgroud row mx-auto" style="width: 300px;">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3 text-center">회원가입</h4>
				<h6>* 표시는 필수 입력 칸 입니다.</h6>
				<form class="validation-form" action="MemberServlet" method="post" novalidate accept-charset="utf-8" >
				<input type="hidden" name="command" value="member_join">
					<div class="row">
						<div class="col-12 mb-3">
							<label for="name">이름(*)</label> 
							<input type="text" class="form-control" id="name" name = "name" placeholder="" value="" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-12 mb-3">
							<label for="name" >아이디(*)</label>
							<div class="input-group">
								<c:set var="id" value="${param.id}"></c:set>
								<c:choose>
									<c:when test="${not empty id}">
										<input type="text" class="form-control" id="id" name="id" placeholder="" value="${id}" required readonly>
									</c:when>
									<c:otherwise>
										<input type="text" class="form-control" id="id" name="id" placeholder="" value="중복확인 을 눌러주세요" required readonly>	
									</c:otherwise>
								</c:choose>
								<div class="input-group-append">
									<input class="btn" style="background-color: #fac279;" type="button" value="중복확인" onclick="open_win('MemberServlet?command=member_Idcheck_form','회원가입')" required>
								</div>
								<script type="text/javascript">
								
								function open_win(url, name) {
									window.open(url, name, 'width=500, height=230 left =600 top = 250');
								}
								
								</script>
								<div class="invalid-feedback">아이디를 입력해주세요</div>
							</div>
						</div>

						<div class="col-12 mb-3">
							<label for="name">비밀번호(*)</label> 
							<input type="password" class="form-control" id="password" name="pwd" placeholder="" value="" required>
							<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
						</div>
						<div class="col-12 mb-3">
							<label for="name">비밀번호 확인(*)</label> 
							<input type="password" class="form-control" id="passwordconfirm" placeholder="" value="" required>
							<div class="invalid-feedback">비밀번호 확인 을 입력해주세요.</div>
						</div>
						<div class="col-12 mb-3">
							<label for="name">연락처(*)</label> 
							<input type="text" class="form-control" id="phone" name="phone" placeholder="" value="" required>
							<div class="invalid-feedback">연락처를 입력해주세요.</div>
						</div>
						<div class="col-12 mb-3">
							<label for="name">이메일(*)</label> 
							<input type="email" class="form-control" id="email" name="email" placeholder="" placeholder="you@example.com" value="" required>
							<div class="invalid-feedback">이메일을 입력해주세요.</div>
						</div>
					</div>

					<hr class="mb-4">
					<div class="custom-control custom-checkbox text-center">
						<input type="checkbox" class="custom-control-input" id="aggrement"
							required> <label class="custom-control-label"
							for="aggrement">개인정보 수집 및 이용에 동의합니다.</label><br>
						<button class="btn btn-lg btn-block mt-3" style="background-color: #fac279;" type="submit" onclick="validateForm()">가입 완료</button>
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
			
		    function checkPw() {
		        let id = $("#id").val();
		        let pw = $("#password").val();
		        let number = pw.search(/[0-9]/g);
		        let english = pw.search(/[a-z]/ig);
		        let spece = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		        let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

		        if (pw.length < 8 || pw.length > 20) {
		            alert("8자리 ~ 20자리 이내로 입력해주세요.");
		            return false;

		        } else if (pw.search(/\s/) != -1) {
		            alert("비밀번호는 공백 없이 입력해주세요.");
		            return false;

		        } else if (number < 0 || english < 0 || spece < 0) {
		            alert("영문,숫자,특수문자를 혼합하여 입력해주세요.");
		            return false;

		        } else if ((number < 0 && english < 0) || (english < 0 && spece < 0) || (spece < 0 && number < 0)) {
		            alert("영문,숫자, 특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
		            return false;

		        } else if (/(\w)\1\1\1/.test(pw)) {
		            alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
		            return false;

		        } else if (pw.search(id) > -1) {
		            alert("비밀번호에 아이디가 포함되었습니다.");
		            return false;
		        } else {
		            alert("비밀번호가 정상적으로 입력되었습니다.");
		            return true;
		        }

		        if (false === reg.test(pw)) {
		            alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
		            return false;
		        } else {
		            alert("비밀번호가 정상적으로 입력되었습니다.");
		            return true;
		        }

		    }
		</script>
		
	</div>

	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>
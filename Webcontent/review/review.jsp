<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css?ver=1">
<link rel="stylesheet" href="../resources/css/main.css?ver=1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/main.js"></script>
<style>
li {
	list-style: none;
}

a {
	color: black;
	text-decoration: none;
}

img {
	width: 10rem;
	height: auto;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<div class="container border mt-3 rounded-3 w-50">
		<ul class="nav nav-pills nav-fill ">
			<li class="nav-item"><a class="nav-link " style="color: black;"
				aria-current="page" href="mypage.html">내 레시피</a></li>
			<li class="nav-item"><a class="nav-link" style="color: black;"
				href="mypage-save.html">저장 레시피</a></li>
			<li class="nav-item">
				<div class="dropdown">
					<a class="btn btn-secondary1 dropdown-toggle" href="#"
						role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> 요리 후기 </a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item"
							href="ReviewServlet?command=review">나의 요리 레시피</a></li>
						<li><a class="dropdown-item"
							href="ReviewServlet?command=myreview">내가 남긴 후기</a></li>

					</ul>
				</div> <!-- <a class="nav-link" style=" color: black;" href="mypage-review.html">요리 후기</a> -->
			</li>
			<li class="nav-item"><a class="nav-link" style="color: black;"
				href="mypage-edit.html">회원정보 수정</a></li>
		</ul>
	</div>

	<!-- 내 레시피 목록 -->
	<div class="container text-center border mt-3 rounded-5">
		<section class="container">
			<table class="table justify-content-center mt-5 mb-5">
				<thead>
					<tr class="border-2 mt-3 ">
						<th scope="col">번호</th>
						<th>레시피 사진</th>
						<th scope="col">레시피 제목</th>
						<th scope="col">내용</th>
						<th scope="col">내 평점</th>
						<th scope="col">작성일</th>
						<th scope="col">수정/삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="review" items="${reviewList}">
						<tr>
							<th scope="row"><br> <br>${review.recipeid }</th>
							<th scope="row"><a href="recipe_Detail.html"><img
									src="resources/img/${review.reviewpicture }"></a></th>
							<td class=""><br> <br> <b>${review.recipename}</b></td>
							<td><a href="#"><br> <br>${review.review}</a></td>
							<td><br> <br> <b>${review.recipegrade} 점</b></td>
							<td><br> <br>${review.regdate}</td>
							<td><br>

								<form action="ReviewServlet" method="post">
									<input type="hidden" name="command" value="myreview_update">
									<input type="hidden" name="num" value="${review.recipeid}">
									<!--후기 작성 form -->
									<button type="button" class="btn btn-primary"
										data-bs-toggle="modal"
										data-bs-target="#staticBackdrop_${review.recipeid}">
										수정</button>
									<!-- 모달 -->
									<div class="modal fade" id="staticBackdrop_${review.recipeid}"
										data-bs-backdrop="static" data-bs-keyboard="false"
										tabindex="-1"
										aria-labelledby="staticBackdropLabel_${review.recipeid}"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h1 class="modal-title fs-5"
														id="staticBackdropLabel_${review.recipeid}">
														<b>작성자 : [${loginUser.id }] 님</b>
													</h1>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													<div class="form-floating w-50 mx-auto mb-2">
														<select class="form-select"
															id="floatingSelect_${review.recipeid}"
															aria-label="Floating label select example"
															name="recipegrade">
															<option selected></option>
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
														</select> <label for="floatingSelect_${review.recipeid}">점수</label>
													</div>
													<div class="form-floating">
														<textarea class="form-control" placeholder=""
															id="floatingTextarea2_${review.recipeid}"
															style="height: 200px" name="review">${review.review }</textarea>
														<label for="floatingTextarea2_${review.recipeid}">레시피
															후기를 입력해주세요</label>
													</div>
													<div class="file-upload col-12">
														<div class="image-upload-wrap">
															<div class="drag-text">
																<input class="file-upload-input" type='file'
																	onchange="readURL(this);" accept="image/*" /> 후기 <br>사진
																등록
															</div>
														</div>
														<div class="file-upload-content">
															<img class="file-upload-image" />
															<div class="image-title-wrap">
																<button type="button" onclick="removeUpload(this)"
																	class="remove-image">삭제</button>
															</div>
														</div>
													</div>
												</div>
												<script class="jsbin"
													src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">닫기</button>
													<button type="submit" class="btn btn-secondary">작성하기</button>
												</div>
											</div>
										</div>
									</div>
									<button class="btn btn-primary" type="button" value="delete"
										onclick="window.location.href='ReviewServlet?command=myreview_delete&num=${review.recipeid}'">삭제</button>
								</form>
						</tr>
					</c:forEach>


					<script>
   						
					</script>


					<script>
                                    let uploadIndex = 1;

                                    function createImageUpload() {
                                        let uploadElement = `
                                        <div class="file-upload">
                                        <div class="image-upload-wrap">
                                        <div class="drag-text">
                                        <input class="file-upload-input" type="file" onchange="readURL(this);" accept="image/*" />
                                        사진 등록
                                        </div>
                                        </div>
                                        <div class="file-upload-content">
                                        <img class="file-upload-image" src="#" alt="your image" />
                                        <div class="image-title-wrap">
                                        <button type="button" onclick="removeUpload(this)" class="remove-image">삭제</button>
                                        </div>
                                        </div>
                                        </div>
                                        `;
                                        $('#image-uploads').append(uploadElement);
                                        uploadIndex++;
                                    }

                                    function readURL(input) {
                                        if (input.files && input.files[0]) {
                                            var reader = new FileReader();
                                            reader.onload = function (e) {
                                                let $uploadContent = $(input).closest('.file-upload').find('.file-upload-content');
                                                let $uploadImage = $uploadContent.find('.file-upload-image');
                                                $uploadContent.show();
                                                $uploadImage.attr('src', e.target.result);
                                            };
                                            reader.readAsDataURL(input.files[0]);
                                        } else {
                                            removeUpload(input);
                                        }
                                    }

                                    function removeUpload(button) {
                                    
                                        let $upload = $(button).closest('.file-upload');
                                        let $uploadContent = $upload.find('.file-upload-content');
                                        let $uploadImage = $uploadContent.find('.file-upload-image');
                                        
                                        // 이미지 초기화
                                        $uploadImage.attr('src', '#');
                                        $uploadContent.hide();
                                    }

                                    $(document).ready(function () {
                                        $('.image-upload-wrap').bind('dragover', function () {
                                            $(this).addClass('image-dropping');
                                        });
                                        $('.image-upload-wrap').bind('dragleave', function () {
                                            $(this).removeClass('image-dropping');
                                        });
                                    });
					</script>
				</tbody>
			</table>
		</section>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>

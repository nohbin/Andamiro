<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
						<li><a class="dropdown-item" href="mypage-review.html">내가
								남긴 후기</a></li>
						<li><a class="dropdown-item" href="mypage-myreview.html">나의
								요리 레시피</a></li>
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
							<th scope="row"><br>
							<br>${review.num }</th>
							<th scope="row"><a href="recipe_Detail.html"><img
									src="../resources/img/morning.jpg"></a></th>
							<td class=""><br>
							<br>
							<b>${review.title }</b></td>
							<td><a href="#"><br>
								<br>한우소갈비찜</a></td>
							<td><br>
							<br>
							<b>${review.recipegrade} 점</b></td>
							<td><br>
							<br>${review.joindate}</td>
							<td><br>
								
								<form action="ReviewServlet" method="post">
									<input type="hidden" name="command" value="myreview_update">
									<input type="hidden" name="num" value="${review.num}">
									<!-- 후기 작성 form -->
									<button type="button" class="btn btn-primary"
										data-bs-toggle="modal" data-bs-target="#staticBackdrop">
										수정</button>
									<!--모달-->
									<div class="modal fade" id="staticBackdrop"
										data-bs-backdrop="static" data-bs-keyboard="false"
										tabindex="-1" aria-labelledby="staticBackdropLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h1 class="modal-title fs-5" id="staticBackdropLabel">아이디</h1>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													<div class="form-floating w-50 mx-auto mb-2">
														<select class="form-select" id="floatingSelect"
															aria-label="Floating label select example" name="score">
															<option selected>점수</option>
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
														</select>
													</div>
													<div class="form-floating">
														<textarea class="form-control" placeholder=""
															id="floatingTextarea2" style="height: 200px"></textarea>
														<label for="floatingTextarea2">후기를 작성해 주세요</label>
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
															<img class="file-upload-image" src="#" alt="your image" />
															<div class="image-title-wrap">
																<button type="button" onclick="removeUpload(this)"
																	class="remove-image">삭제</button>
															</div>
														</div>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">닫기</button>
												<input type="submit" class="btn btn-secondary" value="수정하기">
												</div>
												<script class="jsbin"
													src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
											</div>
										</div>
									</div>
									<button class="btn btn-primary" type="button" value="delete"
										onclick="window.location.href='ReviewServlet?command=myreview_delete&num=${review.num}'">삭제</button>
								</form>
						</tr>
					</c:forEach>


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



					<script>
                var navLinks = document.querySelectorAll('.nav-link');
                navLinks.forEach(function (link) {
                    link.addEventListener('mouseover', function () {
                        navLinks.forEach(function (link) {
                            link.classList.remove('active');
                        });
                        this.classList.add('active');
                    });
                });
                
                function open_win(url) {

                    window.open(url, "_blank");
                }
                function deleteReview() {
                    alert('삭제 완료');
                }
            </script>

				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
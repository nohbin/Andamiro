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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap">

      <script src="js/bootstrap.bundle.js"></script>
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
            <li class="nav-item">
                <a class="nav-link " style=" color: black;" aria-current="page" href="mypage.html">내 레시피</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style=" color: black;" href="mypage-save.html">저장 레시피</a>
            </li>
            <li class="nav-item">
                <div class="dropdown">
                    <a class="btn btn-secondary1 dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false" >
                     요리 후기
                    </a>
                  
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                      <li><a class="dropdown-item" href="mypage-review.html">내가 남긴 후기</a></li>
                      <li><a class="dropdown-item" href="mypage-myreview.html">나의 요리 레시피</a></li>
                    </ul>
                  </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" style=" color: black;" href="mypage-edit.html">회원정보 수정</a>
            </li>
        </ul>
    </div>

    <!-- 내 레시피 목록 -->
    <div class="container text-center border mt-3 rounded-5">
    

    
<section class="container">
    <table class="table justify-content-center mt-5 mb-5">
        <thead>
          <tr class="border-2 mt-3 " >
            <th scope="col">레시피 </th>
            <th scope="col">레시피 제목</th>
            <th scope="col">후기</th>
            <th></th>
            <th scope="col">받은 평점</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="review" items="${reviewList}">
          <tr>
            <th scope="row"> <a href="recipe_Detail.html"><br>${review.num }</a></th>
            <td class=""><br><b>${review.title }</b></td>
            <td><a href="#"><br><br>2,320건</a></td>
            <td ></td>
            <td ><br><b> ${review.recipegrade }점</b></td>
            <td><br><br>${review.joindate}</td>
          </tr>
          </c:forEach>
    <%--      <tr>
            <tr>
                <th scope="row"> <a href="recipe_Detail.html"><img src="../resources/img/morning2.png" ></a></th>
                <td class=""><br><br><b>곱도리탕</b></td>
                <td><a href="#"><br><br>2,320건</a></td>
                <td ></td>
                <td ><br><br><b> 5점</b></td>
                <td><br><br>2023-05-06</td>
              </tr>
          </tr>
          <tr>
            <tr>
                <th scope="row"> <a href="recipe_Detail.html"><img src="../resources/img/morning3.jpg" ></a></th>
                <td class=""><br><br><b>곱도리탕</b></td>
                <td><a href="#"><br><br>2,320건</a></td>
                <td ></td>
                <td ><br><br><b> 5점</b></td>
                <td><br><br>2023-05-06</td>
              </tr>
          <tr>
            <tr>
                <th scope="row"> <a href="recipe_Detail.html"><img src="../resources/img/morning4.jpg" ></a></th>
                <td class=""><br><br><b>곱도리탕</b></td>
                <td><a href="#"><br><br>2,320건</a></td>
                <td ></td>
                <td ><br><br><b> 5점</b></td>
                <td><br><br>2023-05-06</td>
              </tr>
          <tr>
            <tr>
                <th scope="row"> <a href="recipe_Detail.html"><img src="../resources/img/morning5.jpg" ></a></th>
                <td class=""><br><br><b>곱도리탕</b></td>
                <td><a href="#"><br><br>2,320건</a></td>
                <td ></td>
                <td ><br><br><b> 5점</b></td>
                <td><br><br>2023-05-06</td>
              </tr>
          <tr>
            <tr>
                <th scope="row"> <a href="recipe_Detail.html"><img src="../resources/img/morning6.jpg" ></a></th>
                <td class=""><br><br><b>곱도리탕</b></td>
                <td><a href="#"><br><br>2,320건</a></td>
                <td ></td>
                <td ><br><br><b> 5점</b></td>
                <td><br><br>2023-05-06</td>
              </tr>
          <tr>
            <tr>
                <th scope="row"> <a href="recipe_Detail.html"><img src="../resources/img/morning1.jpg" ></a></th>
                <td class=""><br><br><b>곱도리탕</b></td>
                <td><a href="#"><br><br>2,320건</a></td>
                <td ></td>
                <td ><br><br><b> 5점</b></td>
                <td><br><br>2023-05-06</td>
              </tr> --%> 
        </tbody>
      </table>
      <!-- <div class="d-grid gap-2 d-md-block flex-wrap  d-flex justify-content-center">
       <div class="flex-wrap  d-flex justify-content-center">
        <button class="btn btn-primary me-5" type="button" >수정</button>
        <button class="btn btn-primary me-3" type="button">삭제</button>
        </div>
      </div> -->
    </section>

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
    </script>
    </div>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
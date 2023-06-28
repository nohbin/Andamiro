<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/my.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
  <style>
    li{
      list-style: none;
    }
    a {
            color: black;
            text-decoration: none;
        }
  </style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container border mt-3 rounded-3 w-50">
		<ul class="nav nav-pills nav-fill row">
			<li class="nav-item col-12 col-md-3"><a class="nav-link active"
				style="color: black;" aria-current="page" href="recdiet.jsp">추천식단</a>
			</li>
			<li class="nav-item col-12 col-md-3"><a class="nav-link"
				style="color: black;" aria-current="page" href="simplediet.jsp">간단식단</a>
			</li>
			<li class="nav-item col-12 col-md-3"><a class="nav-link"
				style="color: black;" aria-current="page" href="lowdiet.jsp">저칼로리식단</a>
			</li>
			<li class="nav-item col-12 col-md-3"><a class="nav-link"
				style="color: black;" aria-current="page" href="proteindiet.jsp">프로틴식단</a>
			</li>
		</ul>
	</div>
       <div style="height: 3rem;"></div>
  <%--     <div class="container">
          <div class="row" >
       <c:forEach var="diet" items="${dietList}">   
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet.jsp'">${diet.diet_menu}</button>
                </div>
                <img src="upload/${diet.diet_picture}" class="img-fluid3">
                <div class="mealment">쌀밥, 고추장 달걀조림, 시금치나물, 배추김치, 호두멸치볶음</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_lunch.jsp'">${diet.diet_menu}</button>
                </div>
                <img src="upload/${diet.diet_picture}"  class="img-fluid3">
                <div class="mealment">콩밥, 감자국, 꽁치구이, 호박나물, 백김치</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_dinner.jsp'">${diet.diet_menu}</button>
                </div>
                <img src="upload/${diet.diet_picture}"  class="img-fluid3">
                <div class="mealment"> 보리밥, 시금치된장국, 쇠고기불고기, 오이부추생채, 우유</div>
              </div>
            </div>
		 </c:forEach> --%>

		<div class="container">
			<div class="row">
				<c:forEach var="diet" items="${dietList}">
					<div class="col-12 col-md-4">
						<div class="text-center">
							<div>
								<button type="button" class="btn btn-outline-warning mb-3"
									onclick="location.href='recdiet.jsp'">${diet.diet_menu}
								</button>
							</div>
							<img src="upload/${diet.diet_picture}" style="width: 15rem; height: 10rem;">
<%-- 							<c:forEach var="dietDetail" items="${dietDetailList}">
								<div>
									<div class="fw-bold">${dietDetail.foodName}</div>
								</div>
							</c:forEach> --%>
					</div>
					</div>
				</c:forEach>
				<c:forEach var="dietDetail" items="${dietDetailList}">
					<div style="margin-left:10rem;">
				      <div class="fw-bold">
						${dietDetail.foodName}
				      </div>
					</div>
				</c:forEach> 
				<c:forEach var="dietDetail" items="${dietDetailList2}">
					<div style="margin-left:10rem;">
				      <div class="fw-bold">
						${dietDetail.foodName}
				      </div>
					</div>
				</c:forEach> 
				<c:forEach var="dietDetail" items="${dietDetailList3}">
					<div style="margin-left:10rem;">
				      <div class="fw-bold">
						${dietDetail.foodName}
				      </div>
					</div>
				</c:forEach> 
			</div>
		</div>	
		<!-- 여기까지  -->
		<div style="height: 4rem;"></div>
		<div class="container">
			<div class="row">
				<div class="col d-flex justify-content-between my-3">
					<span class="h4" style="font-weight: bold;">식단별 영양정보</span> <span>*1인분
						기준 영양정보 입니다.</span>
				</div>
			</div>
			<table class="table table-hover" style="height: 300px;">
				<thead class="table-primary text-center head">
					<tr>
						<td>음식명</td>
						<td>칼로리</td>
						<td>영양성분</td>
					</tr>
				</thead>
				<tbody class="table-secondary">
					<tr>
						<td class="h5 border-end">쌀밥</td>
						<td class="h5 border-end" id="cell2">310kcal</td>
						<td class="h5">탄수화물(67.32g), 단백질(5.61g), 지방(0.85g), 당류(0g),
							나트륨(4mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">고추장 달걀조림</td>
						<td class="h5 border-end">350kcal</td>
						<td class="h5">탄수화물(12g), 단백질(10.32g), 지방(8.29g), 당류(5.86g),
							나트륨(502mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">시금치나물</td>
						<td class="h5 border-end">57kcal</td>
						<td class="h5">탄수화물(6.16g), 단백질(2.74g), 지방(3.08g),
							당류(0.81g), 나트륨(497mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">배추김치</td>
						<td class="h5 border-end">25kcal</td>
						<td class="h5">탄수화물(4.4g), 단백질(1.4g), 지방(0.2g), 당류(0g),
							나트륨(232mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">호두멸치볶음</td>
						<td class="h5 border-end">127kcal</td>
						<td class="h5">탄수화물(5.44g), 단백질(7.01g), 지방(8.96g), 당류(0.31g),
							나트륨(695mg)</td>
					</tr>
				</tbody>
			</table>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
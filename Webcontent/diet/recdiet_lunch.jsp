<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
      <li class="nav-item col-12 col-md-3">
          <a class="nav-link active" style=" color: black;" aria-current="page" href="recdiet.jsp">추천식단</a>
      </li>
      <li class="nav-item col-12 col-md-3">
        <a class="nav-link" style=" color: black;" aria-current="page" href="simplediet.jsp">간단식단</a>
    </li>
    <li class="nav-item col-12 col-md-3">
      <a class="nav-link" style=" color: black;" aria-current="page" href="lowdiet.jsp">저칼로리식단</a>
  </li>
  <li class="nav-item col-12 col-md-3">
    <a class="nav-link" style=" color: black;" aria-current="page" href="proteindiet.jsp">프로틴식단</a>
</li>
  </ul>
</div>
      <div style="height: 3rem;"></div>
      <div class="container">
          <div class="row" >
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet.jsp'">아침</button>
                </div>
                <img src="../resources/img/diet1.png" class="img-fluid3">
                <div class="mealment">쌀밥,고추장 달걀조림, 시금치나물, 배추김치,호두멸치볶음</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_lunch.jsp'">점심</button>
                </div>
                <img src="../resources/img/diet2.png" class="img-fluid3">
                <div class="mealment">콩밥, 감자국, 꽁치구이, 호박나물, 백김치</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_dinner.jsp'">저녁</button>
                </div>
                <img src="../resources/img/diet3.png" class="img-fluid3">
                <div class="mealment"> 보리밥, 시금치된장국, 쇠고기불고기, 오이부추생채, 우유</div>
              </div>
            </div>
          </div> 
        </div> 
      <div style="height: 7rem;"></div>
      <div class="container">
        <div class="row">
          <div class="col d-flex justify-content-between my-3">
            <span class="h4" style="font-weight: bold;">식단별 영양정보</span>
            <span>*1인분 기준 영양정보 입니다.</span>
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
              <td class="h5 border-end" >콩밥</td>
              <td class="h5 border-end" >264kcal</td>
              <td class="h5">탄수화물(57.38g), 단백질(5.65g), 지방(0.46g), 당류(0g), 나트륨(564mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">감자국</td>
              <td class="h5 border-end" >85kcal</td>
              <td class="h5">탄수화물(9.39g), 단백질(4.32g), 지방(3.35g), 당류(0.68g), 나트륨(274mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >꽁치구이</td>
              <td class="h5 border-end" >270kcal</td>
              <td class="h5" >탄수화물(0.2g), 단백질(23.9g), 지방(17.9g), 당류(0g), 나트륨(130mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >호박나물</td>
              <td class="h5 border-end" >19kcal</td>
              <td class="h5" >탄수화물(1.3g), 단백질(0.5g), 지방(1.4g), 당류(1.3g), 나트륨(2mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">백김치</td>
              <td class="h5 border-end">22kcal</td>
              <td class="h5">탄수화물(4.75g), 단백질(1.21g), 지방(0.19g), 당류(1.43g), 나트륨(454mg)</td>
            </tr>
          </tbody>
        </table>
      </div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
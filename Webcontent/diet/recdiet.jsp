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
              <td class="h5 border-end" >쌀밥</td>
              <td class="h5 border-end" id="cell2">310kcal</td>
              <td class="h5">탄수화물(67.32g), 단백질(5.61g), 지방(0.85g), 당류(0g), 나트륨(4mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">고추장 달걀조림</td>
              <td class="h5 border-end" >350kcal</td>
              <td class="h5">탄수화물(12g), 단백질(10.32g), 지방(8.29g), 당류(5.86g), 나트륨(502mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >시금치나물</td>
              <td class="h5 border-end" >57kcal</td>
              <td class="h5" >탄수화물(6.16g), 단백질(2.74g), 지방(3.08g), 당류(0.81g), 나트륨(497mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >배추김치</td>
              <td class="h5 border-end" >25kcal</td>
              <td class="h5" >탄수화물(4.4g), 단백질(1.4g), 지방(0.2g), 당류(0g), 나트륨(232mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">호두멸치볶음</td>
              <td class="h5 border-end">127kcal</td>
              <td class="h5">탄수화물(5.44g), 단백질(7.01g), 지방(8.96g), 당류(0.31g), 나트륨(695mg)</td>
            </tr>
          </tbody>
        </table>
      </div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
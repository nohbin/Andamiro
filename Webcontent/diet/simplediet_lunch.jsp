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
          <a class="nav-link" style=" color: black;" aria-current="page" href="recdiet.jsp">추천식단</a>
      </li>
      <li class="nav-item col-12 col-md-3">
        <a class="nav-link active" style=" color: black;" aria-current="page" href="simplediet.jsp">간단식단</a>
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
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='simplediet.jsp'">아침</button>
                </div>
                <img src="../resources/img/simple.png" class="img-fluid3">
                <div class="mealment">조리시간이 30분 이하인 레시피로 이루어진 식단</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='simplediet_lunch.jsp'">점심</button>
                </div>
                <img src="../resources/img/simple.png" class="img-fluid3">
                <div class="mealment">조리시간이 30분 이하인 레시피로 이루어진 식단</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='simplediet_dinner.jsp'">저녁</button>
                </div>
                <img src="../resources/img/simple.png" class="img-fluid3">
                <div class="mealment"> 조리시간이 30분 이하인 레시피로 이루어진 식단</div>
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
              <td class="h5 border-end">점심</td>
              <td class="h5 border-end">칼로리1</td>
              <td class="h5">영양성분1</td>
            </tr>
            <tr>
              <td class="h5 border-end">점심</td>
              <td class="h5 border-end">칼로리2</td>
              <td class="h5">영양성분2</td>
            </tr>
            <tr>
              <td class="h5 border-end">점심</td>
              <td class="h5 border-end">칼로리3</td>
              <td class="h5">영양성분3</td>
            </tr>
            <tr>
              <td class="h5 border-end">점심</td>
              <td class="h5 border-end">칼로리4</td>
              <td class="h5">영양성분4</td>
            </tr>
            <tr>
              <td class="h5 border-end">점심</td>
              <td class="h5 border-end">칼로리5</td>
              <td class="h5">영양성분5</td>
            </tr>
          </tbody>
        </table>
      </div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>